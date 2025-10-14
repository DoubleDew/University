import numpy as np
import matplotlib.pyplot as plt
from pathlib import Path
from scipy.io.wavfile import read

fs = 48000
folder = Path('measurements')
files = [f for f in folder.glob('*.wav') if 'witness' not in f.name]

if not files:
    print('No recordings found in ./measurements/')

for wav in files:
    rate, data = read(wav)
    if rate != fs:
        print(f'Skipping {wav} (expected 48 kHz,  got {rate})')
        continue
    if '70' in wav.stem:
        n_trim = int(2 * rate)
        print(f"Trimmed last 2 seconds of {wav.name}")
        data = data[:-n_trim]
    
    for ch, sig in enumerate(data.T):
        #time
        t = np.arange(len(sig)) / fs
        plt.figure(figsize = (8, 3))
        plt.plot(t, sig)
        plt.title(f'{wav.stem} ch{ch} - time')
        plt.xlabel('Time [s]')
        plt.ylabel('Amplitude')
        plt.tight_layout()
        plt.savefig(wav.with_name(f'{wav.stem}_ch{ch}_time.png'))
        plt.close()
        
        #frequency
        win = np.hanning(len(sig))
        S = np.fft.rfft(sig * win)
        f = np.fft.rfftfreq(len(sig), 1 / fs)
        mag_db = 20 * np.log10(np.maximum(np.abs(S), 1e-12))
        
        plt.figure(figsize = (8, 3))
        plt.plot(f, mag_db)
        plt.xticks(np.arange(0, fs/2 + 1, 2500))
        plt.minorticks_on()
        plt.grid(which = "both", linestyle = '--', alpha = 0.5)
        plt.title(f'{wav.stem} ch{ch} - freq')
        plt.xlabel('Frequency [Hz]')
        plt.ylabel('Magnitude [dBFS]')
        plt.tight_layout()
        plt.savefig(wav.with_name(f'{wav.stem}_ch{ch}_freq.png'))
        plt.close()
        
        #zoomed in for better view
        plt.figure(figsize = (8, 3))
        plt.plot(f, mag_db)
        plt.xticks(np.arange(2500, 3500, 100))
        plt.minorticks_on()
        plt.grid(which = "both", linestyle = '--', alpha = 0.5)
        plt.title(f'{wav.stem} ch{ch} - freq (zoomed)')
        plt.xlabel('Frequency [Hz]')
        plt.ylabel('Magnitude [dBFS]')
        plt.xlim(2500, 3500)
        plt.tight_layout()
        plt.savefig(wav.with_name(f'{wav.stem}_ch{ch}_freq_zoomed.png'))
        plt.close()
        
    print(f'Plotted {wav}')

print('Finished. Inspect the PNGs for artefacts.')
