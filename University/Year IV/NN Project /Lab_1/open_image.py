#%%
import matplotlib.pyplot as plt

A = plt.imread('image.jpg')
plt.imshow(A)
plt.show()
plt.close()

GA = 0.299 * A[:,:,0] + 0.587 * A[:,:,1] + 0.114 * A[:,:,2]
plt.figure()
plt.imshow(GA, cmap = 'gray')

plt.show()
#%%
