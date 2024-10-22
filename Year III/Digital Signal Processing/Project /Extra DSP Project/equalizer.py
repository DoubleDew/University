import numpy as np
import scipy.signal as signal
import soundfile as sf
import matplotlib.pyplot as plt

def apply_low_pass_filter(audio_data, fs, cutoff_freq):
    nyquist = 0.5 * fs
    normal_cutoff = cutoff_freq / nyquist
    b, a = signal.butter(4, normal_cutoff, btype='low', analog=False)
    
    filtered_audio = signal.filtfilt(b, a, audio_data)
    
    return filtered_audio

def plot_audio_signal(audio_data, fs, title, subplot_position):
    times = np.arange(len(audio_data)) / float(fs)
    plt.subplot(subplot_position)
    plt.plot(times, audio_data)
    plt.title(title)
    plt.xlabel('Time [s]')
    plt.ylabel('Amplitude')

def main():
    input_file = 'input.wav'
    output_file = 'output.wav'
    
    try:
        audio_data, fs = sf.read(input_file)
        
        if len(audio_data.shape) > 1 and audio_data.shape[1] > 1:
            audio_data = audio_data[:, 0]
        
        cutoff_freq = 1000  
        filtered_audio = apply_low_pass_filter(audio_data, fs, cutoff_freq)
        
        sf.write(output_file, filtered_audio, fs)
        
        plt.figure(figsize=(10, 8))
        
        plot_audio_signal(audio_data, fs, 'Original Audio Signal', 211)
        plot_audio_signal(filtered_audio, fs, 'Filtered Audio Signal', 212)
        
        plt.tight_layout()
        plt.show()
        
    except Exception as e:
        print(f"An error occurred: {e}")

if __name__ == '__main__':
    main()