# clase 8
# populatie 1000
# cluster_std 5 

from sklearn.neural_network import MLPClassifier
from sklearn.datasets import make_blobs
from sklearn.model_selection import train_test_split
from sklearn.metrics import accuracy_score, confusion_matrix
import matplotlib.pyplot as plt

X, T = make_blobs(n_samples = 1000, n_features = 8, centers = 8, cluster_std = 5, random_state = 0)

plt.subplot(2, 1, 1)
plt.scatter(X[:, 0], X[:, 1], c = T)

xTrain, xTest, tTrain, tTest = train_test_split(X, T)

mlp = MLPClassifier(hidden_layer_sizes = (), activation = 'relu', solver = 'adam', alpha = 1e-5, tol = 1e-4,
                    verbose = True, max_iter = 1000)

mlp.fit(xTrain, tTrain)
Y = mlp.predict(xTest)

print("Accuracy score: ", accuracy_score(Y, tTest))
print("Confusion Matrix: ")
print(confusion_matrix(Y, tTest))

plt.subplot(2, 1, 2)
loss = mlp.loss_curve_
plt.plot(loss)
plt.show()