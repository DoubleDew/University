import numpy as np
import matplotlib.pyplot as plt
from skimage import io, color, util
plt.close('all')

img = io.imread('tst2.bmp')
img = color.rgb2gray(img)
img = (img * 255).astype(int)

plt.figure(), plt.imshow(img, cmap='gray'), plt.colorbar()
hist, _ = np.histogram(img, range=(0, 256))

h, w = img.shape
img_labels = np.zeros([h, w])
plt.figure(figsize = (10, 10)), plt.plot(hist)

img_labels[np.logical_and(img > 25, img <= 125)] = 3
img_labels[np.logical_and(img > 125, img < 175)] = 2
img_labels[img > 175] = 1

plt.figure(), plt.imshow(img_labels, cmap = 'jet', vmin = 0, vmax = 3), plt.colorbar()
# %%
