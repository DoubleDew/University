import numpy as np

a = np.random.randint(0, 100, 10)
a = np.sort(a)

np.savetxt('sorted.txt', a, fmt='%d')