#%%
import numpy as np
import matplotlib.pyplot as plt
from sklearn.neural_network import MLPClassifier
from sklearn.model_selection import train_test_split
from sklearn.metrics import confusion_matrix
from sklearn.metrics import accuracy_score
from keras.datasets import mnist

(xTrain, tTrain), (xTest, tTest) = mnist.load_data()

plt.close('all')
plt.imshow(xTrain[0], cmap = plt.cm.gray_r)
plt.title('Digit ' + str(tTrain[0]))


# %%
