from sklearn.datasets import make_blobs
from sklearn.neural_network import MLPClassifier
from sklearn.model_selection import train_test_split
from sklearn.metrics import accuracy_score, confusion_matrix
import matplotlib.pyplot as plt

X, T = make_blobs(n_samples = 1000, n_features  = 7, centers = 7, cluster_std = 4, random_state = 0)

# n_samples: population
# n_features: number of classes
# centers: number of centers
# cluster_std: standard deviation

plt.subplot(2, 1, 1)
plt.title('Blobs')
plt.scatter(X[:, 0], X[:, 1], c = T)

xTrain, xTest, tTrain, tTest = train_test_split(X, T, shuffle = False)

mlp = MLPClassifier(hidden_layer_sizes=(7,), solver = 'adam', activation = 'relu', alpha = 1e-5, tol = 1e-4, verbose = True, max_iter = 1000)

mlp.fit(xTrain, tTrain)

Y = mlp.predict(xTest)

print('Accuracy score: ', accuracy_score(Y, tTest))
print('Confusion matrix: ', confusion_matrix(Y, tTest))

plt.subplot(2, 1, 2)
plt.plot(mlp.loss_curve_)
plt.title('Loss curve')
plt.show()