import numpy as np
import matplotlib.pyplot as plt

a, b, c = 1, 0, 0

x = np.linspace(-10, 10, 400)
y = a * x**2 + b * x + c

plt.close('all')
plt.figure(figsize=(6, 6))
plt.plot(x, y, 'b', linewidth=5)
# label = f'y = {a}x^2 + {b}x + {c}'
# plt.axhline(0, color='black', linewidth = 0.8)
# plt.axvline(0, color='black', linewidth = 0.8)

plt.show()