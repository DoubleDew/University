#%%
import numpy as np
import matplotlib.pyplot as plt
from skimage import io, color, util
plt.close('all')

img = io.imread('tst1.bmp')
img = color.rgb2gray(img)

# hist1, _ = np.histogram(img, range = (0, 256))
# plt.figure(figsize = (10, 10)), plt.plot(hist1)

img = util.random_noise(img, mean = 0, var = (10/255) ** 2)
img = (img * 255).astype(int)
plt.figure(), plt.imshow(img, cmap = 'gray'), plt.colorbar()

# hist, _ = np.histogram(img, range = (0, 256))
# plt.figure(figsize = (10, 10)), plt.plot(hist)

img_labels = np.zeros(img.shape)
img_labels[np.logical_and(img > 25, img <= 75)] = 1
img_labels[np.logical_and(img > 75, img <= 125)] = 2
img_labels[np.logical_and(img > 125, img <= 175)] = 3
img_labels[img > 175] = 4

plt.figure(), plt.imshow(img_labels, cmap = 'jet', vmin = 0, vmax = 4), plt.colorbar()

h, w = img.shape
img_f = img_labels.copy()
window_size = 3
border = window_size // 2
for i in range(border, h - border):
    for j in range(border, w - border):
        V = img_labels[i - border:i + border + 1, j - border:j + border + 1]
        V = np.sort(V, axis = None)
        img_f[i, j] = V[4]
        
plt.figure(), plt.imshow(img_f, cmap = 'jet', vmin = 0, vmax = 4), plt.colorbar()

mask = np.ones([3, 3]) / 9
img_f = img.copy()
for i in range(border, h - border):
    for j in range(border, w - border):
        V = img[i - border:i + border + 1, j - border:j + border + 1]
        V = V * mask
        img_f[i, j] = np.sum(V)

plt.figure(), plt.imshow(img_f, cmap='gray'), plt.colorbar()
        
hist2, _ = np.histogram(img_f,  bins = 256, range = (0, 256))
plt.figure(figsize = (10, 10)), plt.plot(hist2)

img_labels = np.zeros(img_f.shape)
img_labels[np.logical_and(img_f > 25, img_f <= 75)] = 1
img_labels[np.logical_and(img_f > 75, img_f <= 125)] = 2
img_labels[np.logical_and(img_f > 125, img_f <= 175)] = 3
img_labels[img_f > 175] = 4

plt.figure(), plt.imshow(img_labels, cmap = 'jet', vmin = 0, vmax = 4), plt.colorbar()
# %%
