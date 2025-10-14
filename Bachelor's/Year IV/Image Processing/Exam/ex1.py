#%%
# Import skimage and matplotlib
from skimage import io
import matplotlib.pyplot as plt

img = io.imread('test_noise.png')
plt.figure(),plt.imshow(img, cmap = 'gray'), plt.colorbar()
# %%
