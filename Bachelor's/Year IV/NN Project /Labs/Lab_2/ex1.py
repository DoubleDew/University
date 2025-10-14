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

xTrain = xTrain.reshape((len(xTrain), -1))
xTest = xTest.reshape((len(xTest), -1))

xTrain = xTrain/255.
xTest = xTest/255.

mlp = MLPClassifier(hidden_layer_sizes = (20,20), activation = 'relu', max_iter = 50, alpha = 1e-4,
                    solver = 'sgd', verbose = 1, learning_rate_init = .1)

mlp.fit(xTrain, tTrain)
tTest = mlp.predict(xTest)
print("Training set score: %f" % mlp.score(xTrain, tTrain))
print("Test set score: %f" % mlp.score(xTest, tTest))

print('The accuracy is:',accuracy_score(tTest,tTest)) # accuracy_score(y_true, y_pred)
print('Confusion Matrix is: ') 
print(confusion_matrix(tTest,tTest)) # confusion_matrix(y_true, y_pred) - ON LINES!!!
plt.figure()
plt.plot(mlp.loss_curve_)
plt.title('Loss Minimization')
# %%
