import numpy as np
import matplotlib.pyplot as plt
import matplotlib.animation as animation

t = np.linspace(0, 2*np.pi, 500)
fig, ax = plt.subplots()
ax.plot(np.cos(t), np.sin(t), color='red')              
ax.set_aspect('equal')
ax.set_xlim(-1.5, 1.5)
ax.set_ylim(-1.5, 1.5)
dot = plt.Circle((np.cos(0), np.sin(0)), 0.05, color='blue')
ax.add_patch(dot)

def update(i):
 x, y = np.cos(t[i]), np.sin(t[i])
 dot.center = (x, y)
 return (dot,)

ani = animation.FuncAnimation(fig, update, frames=len(t), interval=20, blit=True, repeat=True)
plt.show()