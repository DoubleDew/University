import matplotlib.pyplot as plt
import numpy as np
from skimage import io,color

plt.close('all')
def filt_weighted_mean(img, kernel):
    h, w = img.shape
    img_filtered = np.zeros([h, w])
    
    mask_size = kernel.shape[0]
    for i in range(mask_size // 2, w - mask_size // 2):  
        for j in range (mask_size // 2, h - mask_size // 2):
            V = img_noise[i - mask_size // 2:i + (mask_size // 2 + 1), j - mask_size // 2:j + (mask_size // 2 + 1)]
            V = V * kernel
            img_filtered[i, j] = np.sum(V) 
    return img_filtered
    
def MSE(original, processed):
    mse = np.mean((original - processed) ** 2) 
    return mse
    
plt.close('all')

img = io.imread('lena.png')
img = color.rgb2gray(img)

img = np.uint8(img * 256)

sigma = int(input('Standard deviation value: '))
N = np.random.normal(0, sigma, (img.shape[0], img.shape[1]))

img_noise = img + N

kernel_weighted_mean = np.array([[0.075, 0.124, 0.075],
                                 [0.124, 0.2, 0.124],
                                 [0.075, 0.124, 0.075]
                                ])
mask_size = int(input("Mask value: "))
kernel_arithmetic_mean = np.ones((mask_size, mask_size)) / mask_size ** 2 

filtered_arithmetic = filt_weighted_mean(img_noise, kernel_arithmetic_mean)
filtered_weighted = filt_weighted_mean(img_noise, kernel_weighted_mean)

mse_arithmetic = MSE(img, filtered_arithmetic)
mse_weighted = MSE(img, filtered_weighted)
print(f"MSE for arithmetic mean filter: {mse_arithmetic}")
print(f"MSE for weighted mean filter: {mse_weighted}")

contour1 = img - filtered_arithmetic
contour2 = img - filtered_weighted

plt.figure(), plt.imshow(img, cmap='gray'), plt.title('Original Image'), plt.colorbar()
plt.figure(), plt.imshow(img_noise, cmap='gray'), plt.title('Noisy Image'), plt.colorbar()
plt.figure(), plt.imshow(filtered_arithmetic, cmap='gray'), plt.title('Arithmetic Mean Filtered Image'), plt.colorbar()
plt.figure(), plt.imshow(filtered_weighted, cmap='gray'), plt.title('Weighted Mean Filtered Image'), plt.colorbar()
plt.figure(), plt.imshow(contour1, cmap='gray_r'), plt.title('Contour image from Arithmetic'), plt.colorbar()
plt.figure(), plt.imshow(contour2, cmap='gray_r'), plt.title('Contour image from Weighted'), plt.colorbar()
plt.show()