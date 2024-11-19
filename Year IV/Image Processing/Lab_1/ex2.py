#%%
import numpy as np
import matplotlib as mpl
import matplotlib.pyplot as plt

img = np.zeros([256, 256])
colormap = np.zeros([256, 3])

for i in range(256):
    img[:, i] = i
    
for i in range(128):
    colormap[i, 0] = i/127    
    
for i in range(128, 256):
    colormap[i, 0] = 1
    colormap[i, 2] = (i - 128)/127

colormap = mpl.colors.ListedColormap(colormap)

plt.figure(), plt.imshow(img, cmap = colormap), plt.colorbar()
    
# %%