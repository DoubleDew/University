import numpy as np
from keras.models import Sequential
from keras.layers import Dense
# Load the dataset

X = np.array([[0., 0.],[0., 1.],[1., 0.],[1., 1.]])
T = np.array([[0],[1],[1],[0]])
# Define the Keras model

model = Sequential()
model.add(Dense(4, input_dim=2, activation='relu'))
model.add(Dense(2, activation='relu'))
model.add(Dense(1, activation='tanh'))
# Compile the Keras model

model.compile(loss='binary_crossentropy', optimizer='adam', metrics=['accuracy'])
# Fit the Keras model on the dataset

model.fit(X, T, epochs=150)
# Evaluate the Keras model

_, accuracy = model.evaluate(X, T)
print('Accuracy: %.2f' % (accuracy*100), '%')