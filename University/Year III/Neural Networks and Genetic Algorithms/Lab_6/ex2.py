from sklearn.datasets import make_blobs
from sklearn.neural_network import MLPClassifier
from sklearn.model_selection import train_test_split
from sklearn.metrics import accuracy_score, confusion_matrix
import matplotlib.pyplot as plt

X, T = make_blobs(n_samples = 1000, n_features = 5, centers = 5, cluster_std = 4, random_state = 0)

plt.subplot(2, 1, 1)
plt.scatter(X[:, 0], X[:, 1], c = T)

mlp = MLPClassifier(hidden_layer_sizes = (5,), solver = 'adam', activation = 'relu', alpha = 1e-5, tol = 1e-4, verbose = True, max_iter = 1000)

xTrain, xTest, tTrain, tTest = train_test_split(X, T, shuffle = False)

mlp.fit(xTrain, tTrain)

Y = mlp.predict(xTest)

print('Accuracy score: ', accuracy_score(Y, tTest))
print('Confusion matrix: ')
print(confusion_matrix(Y, tTest))

plt.subplot(2, 1, 2)
loss = mlp.loss_curve_
plt.plot(loss)
plt.show()