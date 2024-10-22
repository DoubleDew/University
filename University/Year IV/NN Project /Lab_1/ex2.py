
#%%
from keras.datasets import mnist
import matplotlib.pyplot as plt
import numpy as np
from numpy import random

(xTrain, tTrain), (xTest, yTest) = mnist.load_data()

n = 5
nTrain = np.size(tTrain)
for l in range(n):
    for c in range(n):
        plt.subplot(n, n, l*n+c+1)
        ex = np.random.randint(nTrain)
        plt.imshow(255 - xTrain[ex], cmap = 'gray')        
        plt.title(tTrain[ex])
# %%
