import numpy as np
import sounddevice as sd
import matplotlib.pyplot as plt
from scipy.io.wavfile import write
from pathlib import Path

fs = 48000
length = 5.0
f1 = 3000
delta_f = 50
f2 = f1 + delta_f
amp = 0.9
out = Path('measurements')
out.mkdir(exist_ok = True)

assert f1 - 6 * delta_f > 0, 'f1 must satisfy f1 - 6 * delta_f > 0'

t = np.linspace(0, length, int(length * fs), endpoint = False)
stim = amp * (np.sin(2 * np.pi * f1 * t) + np.sin(2 * np.pi * f2 * t)) / 2
stereo = np.column_stack((stim, stim))

write(out / 'witness.wav', fs, (stereo * 32767).astype(np.int16))

#time plot
plt.figure(figsize = (8, 3))
plt.plot(t, stim)
plt.title('Witness - time domain')
plt.xlabel('Time [s]')
plt.ylabel('Amplitude')
plt.savefig(out / 'witness_time.png')
plt.tight_layout()
plt.close()

#frequency plot
win = np.hanning(len(stim))
S = np.fft.rfft(stim * win)
f = np.fft.rfftfreq(len(stim), 1 / fs)
mag_db = 20 * np.log10(np.maximum(np.abs(S), 1e-12))

plt.figure(figsize = (8, 3))
plt.plot(f, mag_db)
plt.title('Witness - frequency domain')
plt.xlabel('Frequency [Hz]')
plt.ylabel('Magnitude [dBFS]')
plt.tight_layout()
plt.savefig(out / 'witness_freq.png')
plt.close()

print('Witness saved - set laptop vol. at 50% and play by pressing Enter')
input()
print('Playing...')
sd.play(stim, fs)
print('Done - now record it with your phone')
