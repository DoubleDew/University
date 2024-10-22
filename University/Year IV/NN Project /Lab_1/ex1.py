import numpy as np
import matplotlib.pyplot as plt
import matplotlib.image as mpimg

def rgb2gray(rgb):
    return np.dot(rgb[...,:3], [0.299, 0.587, 0.114])

img_rgb = mpimg.imread('image.jpg')
plt.imshow(img_rgb)

plt.show()

img_gray = rgb2gray(img_rgb)
plt.imshow(img_gray, cmap = plt.get_cmap('gray'))

plt.savefig('image_gray.jpg')

plt.show()