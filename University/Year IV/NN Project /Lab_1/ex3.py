#%%
from keras.datasets import mnist
import matplotlib.pyplot as plt
import numpy as np
from sklearn.neural_network import MLPClassifier

(xTrain, tTrain), (xTest, yTest) = mnist.load_data()

net = MLPClassifier(hidden_layer_sizes = (5, 10), max_iter = 100, alpha = 1e-5, 
                    solver = 'lbfgs', random_state = 1)

net.fit(xTrain, tTrain)
       
#needs reshaping from 3 to 2 dimensions
# %%
