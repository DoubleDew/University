import numpy as np
import matplotlib.pyplot as plt
from skimage import io,color, util

plt.close('all')

img=io.imread('lena.png')
img=color.rgb2gray(img)
img=(img*255).astype(int)

plt.figure(), plt.imshow(img, cmap='gray'), plt.colorbar()