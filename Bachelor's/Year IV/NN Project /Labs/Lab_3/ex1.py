# cifar100

import numpy as np
import matplotlib.pyplot as plt
from keras.datasets import cifar100
from keras.models import Sequential
from keras.layers import Dense, Flatten, Conv2D, MaxPooling2D, Activation, Dropout
from keras.losses import categorical_crossentropy
from keras.utils import to_categorical
from keras.optimizers import Adam
from keras.callbacks import Callback, EarlyStopping
from keras.preprocessing.image import ImageDataGenerator

(xTrain, tTrain), (xTest, tTest) = cifar100.load_data()

xTrain = xTrain.astype('float32')
xTest = xTest.astype('float32')

# xTrain = xTrain.reshape((len(xTrain), -1))
# xTest = xTest.reshape((len(xTest), -1))

xTrain = xTrain/255.
xTest = xTest/255.

noClasses = len(np.uniquely(tTrain))

width, height, numChannels = 32, 32, 3
input_shape = (width, height, numChannels)

tTrain = to_categorical(tTrain, noClasses)
tTest = to_categorical(tTest, noClasses)

plt.figure(figsize=(10, 10))

for i in range (4*4):
  plt.subplot(4, 4, i+1)
  plt.imshow(xTrain[i])
  plt.axis('off')

plt.show()

model = Sequential()
# 128 and not only 32 filters because there are 100 classes. 32 filters gave bad results.
model.add(Conv2D(128, (3, 3), padding='same', input_shape=xTrain.shape[1:]))
model.add(Activation('elu'))

model.add(Conv2D(128, (3, 3)))
model.add(Activation('elu'))
model.add(MaxPooling2D(pool_size=(2, 2)))

model.add(Conv2D(256, (3, 3), padding='same'))
model.add(Activation('elu'))

model.add(Conv2D(256, (3, 3)))
model.add(Activation('elu'))
model.add(MaxPooling2D(pool_size=(2, 2)))
model.add(Dropout(0.25))

model.add(Conv2D(512, (3, 3), padding='same'))
model.add(Activation('elu'))

model.add(Conv2D(512, (3, 3)))
model.add(Activation('elu'))
model.add(MaxPooling2D(pool_size=(2, 2)))
model.add(Dropout(0.25))

model.add(Flatten())
model.add(Dense(1024))
model.add(Activation('elu'))
model.add(Dropout(0.5))
model.add(Dense(noClasses))
model.add(Activation('softmax'))

model.summary()

datagen = ImageDataGenerator(
    featurewise_center = False,
    samplewise_center = False,
    featurewise_std_normalization = False,
    samplewise_std_normalization = False,
    zca_whitening = False,
    rotation_range = 0,
    width_shift_range = 0.1,
    height_shift_range = 0.1,
    horizontal_flip = True,
    vertical_flip = False
)

datagen.fit(xTrain)

early_stop = EarlyStopping(monitor = 'val_loss', mode = 'min', 
                           verbose = 1, patience = 8, 
                           restore_best_weights = True)

history = model.fit_generator(datagen.flow(xTrain, tTrain, batch_size = 128), 
                              steps_per_epoch = xTrain.shape[0] // 128, 
                              epochs = 100, validation_data = (xTest, tTest), 
                              callbacks = [early_stop])

score = model.evaluate(xTest, tTest, verbose = 0)
print('Test loss:', score[0] + 'Test accuracy:', score[1])

plt.plot(history.history['loss'])
plt.title('Validation Loss History')
plt.ylabel('Loss')
plt.xlabel('Epoch')
plt.show()

plt.plot(history.history['accuracy'])
plt.title('Validation Accuracy History')
plt.ylabel('Accuracy')
plt.xlabel('Epoch')
plt.show()
