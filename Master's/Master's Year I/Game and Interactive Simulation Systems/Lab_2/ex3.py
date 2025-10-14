import numpy as np

a = np.random.randint(0, 100, 10)

np.savetxt('unsorted.txt', a, fmt='%d')