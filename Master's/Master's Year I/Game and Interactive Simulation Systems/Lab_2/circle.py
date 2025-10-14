import numpy as np
import matplotlib.pyplot as plt

# radius = 5
# center_x, center_y = 0, 0
# theta = np.linspace(0, 2 * np.pi, 100)
# x = center_x + radius * np.cos(theta)
# y = center_y + radius * np.sin(theta)  
# plt.plot(x, y)
# plt.axis('equal')
# plt.show()

alpha = np.linspace(0, 2 * np.pi, 100)

x = np.cos(alpha)
y = np.sin(alpha)

plt.plot(x, y, 'r')
plt.axis('square')
plt.show()