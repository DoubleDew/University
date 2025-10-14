#%%
from skimage import io, color, util
import numpy as np
import matplotlib.pyplot as plt
import matplotlib as mpl

def rank_filter_order(img, rank, f_size):
    h, w = img.shape
    img_f = img.copy()
    border = f_size // 2
    for i in range(border, h - border):
        for j in range(border, w - border):
            V = img_n[i - border : i + border + 1, j - border : j + border + 1]
            V = np.sort(V, axis=None)
            img_f[i, j] = V[rank]
    return img_f

plt.close('all')

img = io.imread('test_noise.png')

img_n = util.random_noise(img, 's&p', amount = 0.05)
plt.figure(), plt.imshow(img_n, cmap = 'gray'), plt.colorbar()
img_n = np.round(img_n * 256)

image_order = rank_filter_order(img_n, 4, 3)
plt.figure(), plt.imshow(image_order, cmap = 'gray'), plt.colorbar()

colormap = np.array([[0.0, 0.0, 0.0],[0.0, 0.5, 0.0],[1.0, 0.0, 0.0]])
colormap = mpl.colors.ListedColormap(colormap)
plt.figure(), plt.imshow(image_order, cmap = colormap), plt.colorbar()
# %%
