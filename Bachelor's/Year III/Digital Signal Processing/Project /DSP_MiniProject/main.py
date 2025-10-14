import os
import imageio.v2 as imageio
import matplotlib.pyplot as plt
import numpy as np
import sounddevice as sd
from scipy.signal import stft
from scipy.fft import fft, fftfreq
from scipy.io import wavfile

def generate_two_tones(volume):
    duration = 5
    sample_rate = 44100
    t = np.linspace(0, duration, int(sample_rate * duration), endpoint=False)
    tone1 = volume * np.sin(2 * np.pi * 1950 * t)
    tone2 = volume * np.sin(2 * np.pi * 2000 * t)
    return tone1 + tone2

def make_non_linear(signal, gain=0.01):
    return signal + gain + signal ** 5

def record_sound(duration=1, sample_rate=44100, name='recording.wav'):
    print("Started recording")
    recording = sd.rec(int(duration * sample_rate), samplerate=sample_rate, channels=1, dtype='float32')
    sd.wait()  # Wait until recording is finished
    print("Recording complete")
    wavfile.write(name, sample_rate, recording)

def plot_fft(signal, sample_rate, volume, ind, frames, in_time):
    fft_res = fft(signal)
    freqs = fftfreq(len(fft_res), 1/sample_rate)
    mag = np.abs(fft_res) / len(signal)

    positive_freqs = freqs[:len(freqs)//2]
    positive_mag = mag[:len(mag)//2]

    plt.figure(figsize=(12, 6))
    plt.plot(positive_freqs, positive_mag)
    plt.xlabel('Frequency (Hz)')
    plt.ylabel('Magnitude (dB)')
    plt.title(f'FFT at volume: {volume * 100}%')
    plt.grid(True)
    
    filename = f'frame_{ind}.png'
    frames.append(filename)
    plt.savefig(filename)
    plt.close()

    in_time.append([2 * positive_freqs, positive_mag])

def main() -> None:
    sample_rate = 44100
    duration = 1
    frequency1 = 1950
    frequency2 = 2000

    volume_levels = [0.2, 0.4, 0.6, 0.8, 1.0]
    ip3_values = []
    im3_values = []
    in_time = []
    frames = []

    tone = generate_two_tones(1)
    new_tone = np.int16(tone / np.max(np.abs(tone)) * 32767)
    wavfile.write("generated.wav", sample_rate, new_tone)

    for i in range(5):
        input("Press enter to record...")
        record_sound(duration, sample_rate, f'generated{i}.wav')

    for ind, volume in enumerate(volume_levels):
        _, tone_signal = wavfile.read(f'generated{ind}.wav')
        tone_signal = tone_signal.ravel()

        f, t, Zxx = stft(tone_signal, fs=sample_rate, nperseg=2048, noverlap=512)
        threshold = np.percentile(np.abs(Zxx), 95)
        
        Zxx[np.abs(Zxx) < threshold] = 0

        plot_fft(tone_signal, sample_rate, volume, ind, frames, in_time)

        f1_index = np.argmin(np.abs(f - frequency1))
        f2_index = np.argmin(np.abs(f - frequency2))
        im3_1_index = np.argmin(np.abs(f - (2 * frequency1 - frequency2)))
        im3_2_index = np.argmin(np.abs(f - (2 * frequency2 - frequency1)))

        print(f"Volume: {volume}")
        print(f"STFT Frequencies: {f}")
        print(f"Zxx shape: {Zxx.shape}")

        fundamental_power1 = np.abs(Zxx[f1_index, :]).max()
        fundamental_power2 = np.abs(Zxx[f2_index, :]).max()
        im3_power1 = np.mean(np.abs(Zxx[im3_1_index]) ** 2)
        im3_power2 = np.mean(np.abs(Zxx[im3_2_index]) ** 2)
        im3_power = (im3_power1 + im3_power2) / 2

        ip3 = 10 * np.log10(3/2 * (fundamental_power1 + fundamental_power2) - im3_power / 2)
        ip3_values.append(ip3)
        im3_values.append(im3_power)

        print(f"IP3: {ip3}")

    nip3_values = np.array(ip3_values)
    nim3_values = np.array(im3_values)

    _, axes = plt.subplots(2, 3, figsize=(15, 10))
    for ith in range(2):
        for jth in range(3):
            if ith == 1 and jth == 2:
                axes[ith, jth].plot(volume_levels, nip3_values, label='IP3')
                axes[ith, jth].plot(volume_levels, nim3_values, label='IM3')
                axes[ith, jth].set_xlabel('Volume Level (%)')
                axes[ith, jth].set_ylabel('Power (dB)')
                axes[ith, jth].set_title('IP3 and IM3 vs. Volume Level')
                axes[ith, jth].legend()
                axes[ith, jth].grid(True)
            else:
                index = ith * 3 + jth
                if index < len(volume_levels):
                    axes[ith, jth].plot(in_time[index][0], in_time[index][1])
                    axes[ith, jth].set_xlabel('Frequency (Hz)')
                    axes[ith, jth].set_ylabel('Magnitude (dB)')
                    axes[ith, jth].set_title(f'FFT at volume: {volume_levels[index] * 100}%')
                    axes[ith, jth].grid(True)

    plt.show()

    plt.scatter(volume_levels, nip3_values, label='IP3')
    plt.scatter(volume_levels, nim3_values, label='IM3')
    plt.xlabel('Volume Level (%)')
    plt.ylabel('Power (dB)')
    plt.title('IP3 and IM3 vs. Volume Level')
    plt.legend()
    plt.grid(True)
    plt.show()

    with imageio.get_writer('plots.gif', mode='I', duration=0.01, loop=0) as writer:
        for frame in frames:
            image = imageio.imread(frame)
            writer.append_data(image)

    for frame in frames:
        os.remove(frame)

if __name__ == "__main__":
    main()