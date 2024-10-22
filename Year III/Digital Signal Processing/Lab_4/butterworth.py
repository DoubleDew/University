#%%
import numpy as np
import matplotlib.pyplot as plt
import scipy.signal as sp

fs = 13000
fc1 = 2000
fc2 = 6000
ft = 250

rp = 0.2
rs = 20

wp = np.array([fc1 + ft/2, fc2 - ft/2])/(fs/2)
ws = np.array([fc1 - ft/2, fc2 + ft/2])/(fs/2)

N, w = sp.buttord(wp, ws, rp, rs)
b, a = sp.butter(N, w, btype = 'bandpass', output = 'ba')
w, h = sp.freqz(b, a, worN = 512, plot = None)
f = (fs/2) * w / np.pi

plt.close('all')
plt.plot(f,abs(h), linewidth = 2)
plt.grid()
plt.xlabel('Frequency (Hz)')
plt.ylabel('Gain')
plt.title('Butterworth Bandpass Filter')
# %%
