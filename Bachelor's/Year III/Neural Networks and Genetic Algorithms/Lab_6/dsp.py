#dsp
import numpy as np
import matplotlib.pyplot as plt
import scipy.signal as sp

fs = 15000
fc1 = 4500
fc2 = 6500
ft = 300

rp = 0.2
rs = 40

wp =  np.array([fc1 - ft/2, fc2 + ft/2]) / (fs/2)
ws =  np.array([fc1 + ft/2, fc2 - ft/2]) / (fs/2)

N, wN = sp.ellipord(wp, ws, rp, rs)
print('Order: ', N)
b, a = sp.ellip(N, rp, rs, wN, 'bandpass')
w, h = sp.freqz(b, a, worN = 512)
f = (fs/2) * w/np.pi

plt.semilogy(f, abs(h))
plt.xlabel('Frequency')
plt.ylabel('Gain')
plt.title('Elliptic Bandpass Filter')
plt.grid()
plt.show()