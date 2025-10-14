import numpy as np  
import scipy.signal as sp
import matplotlib.pyplot as plt

fs = 8000
fc = 2000
ft = 400

rp = 0.1
rs = 50

wp = np.array([fc - ft/2])/(fs/2)
ws = np.array([fc + ft/2])/(fs/2)

N, w = sp.cheb1ord(wp, ws, rp, rs)
# N = 20
b, a = sp.cheby1(N, rp, wp)
w,h = sp.freqz(b, a, worN=512, plot=None)
f = (fs/2) * w / np.pi

print(N)

plt.close('all')
plt.plot(f, abs(h), linewidth = 3)