#%%
# Import matplotlib, pyplot (separate from matplotlib, since that is the way we will use it), and numpy
import numpy as np
import matplotlib as mpl
import matplotlib.pyplot as plt

# How to create an array filled with zeros
img = np.zeros([128,128])
colormap = np.zeros([128,3])

# Create the image here
for i in range(128):
    img[:, i] = i

# Create the colormap here
for i in range(128):
    colormap[i, 0] = i/127

# Display the image
colormap = mpl.colors.ListedColormap(colormap)
plt.figure(), plt.imshow(img, cmap = colormap), plt.colorbar()
# %%
