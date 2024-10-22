#%%
import numpy as np
import matplotlib.pyplot as plt
import scipy.signal as sp

fs = 16000
fc = 3000
ft = 400

rp = 2
rs = 40

wp = np.array([fc + ft/2]) / (fs/2) 
ws = np.array([fc - ft/2]) / (fs/2)

N, w = sp.cheb1ord(wp, ws, rp, rs)
print("Order is: ", N)

b, a = sp.cheby1(N, rp, w, btype = 'low', output = 'ba')
w, h = sp.freqz(b, a, worN = 512, plot = None)
f = (fs/2) * w / np.pi

plt.close('all')
plt.plot(f,abs(h), linewidth = 2)
plt.grid()
plt.xlabel('Frequency')
plt.ylabel('Gain')
plt.title('Cheby1 Lowpass Filter')
# %%
