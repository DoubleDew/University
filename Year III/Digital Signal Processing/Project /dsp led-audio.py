import pyaudio
import numpy as np
from scipy.signal import lfilter, argrelextrema
import serial
import keyboard
import matplotlib.pyplot as plt
import time

# Serial port configuration
ser = serial.Serial('COM10', 9600)  # Change 'COM10' to your Arduino's port

# Audio configuration
CHUNK = 1024
RATE = 44100
THRESHOLD = 500  # Threshold for detecting significant sound
UPDATE_RATE = 0.5  # Update plot every half second

# IIR Filter coefficients for a low-pass filter with a cutoff frequency of 900Hz
b = [0.2929, 0.2929]
a = [1.0, -0.4142]

# Define the signal values for different color  

def get_color_from_signal(signal):
    if signal < 200:
        return (255, 0, 0)  # Red
    elif 200 <= signal < 400:
        return (0, 255, 0)  # Green
    elif 400 <= signal < 600:
        return (0, 0, 255)  # Blue
    elif 600 <= signal < 800:
        return (255, 255, 0)  # Yellow
    else:
        return (255, 0, 255)  # Magenta

def main():
    p = pyaudio.PyAudio()

    stream = p.open(format=pyaudio.paInt16,
                    channels=1,
                    rate=RATE,
                    input=True,
                    frames_per_buffer=CHUNK)

    print("Press 'L' to start listening and 'E' to exit.")

    running = False
    plt.ion()  # Turn on interactive mode for live plot updates

    next_update_time = time.time() + UPDATE_RATE

    try:
        while True:
            if keyboard.is_pressed('e'):
                print("Exiting...")
                ser.write("0,0,0\n".encode())  # Turn off the LEDs
                break
            if keyboard.is_pressed('l') and not running:
                running = True
                print("Started listening...")

            if running:
                data = np.frombuffer(stream.read(CHUNK), dtype=np.int16)
                volume = np.linalg.norm(data)
                
                if volume < THRESHOLD:
                    continue  # Skip the rest of the loop if the sound is below the threshold

                #performs the iir low pass in order to obtsin the low frequencies of the sound
                filtered_data = lfilter(b, a, data)
                
                # Calculate the frequency spectrum
                fft_spectrum = np.abs(np.fft.fft(filtered_data))
                freqs = np.fft.fftfreq(len(fft_spectrum), 1/RATE)

                # Get the positive frequencies
                positive_freqs = freqs[:len(freqs)//2]
                positive_spectrum = fft_spectrum[:len(fft_spectrum)//2]

                # Find the peak frequency
                peak_index = np.argmax(positive_spectrum)
                frequency = positive_freqs[peak_index]

                color = get_color_from_signal(frequency)
                ser.write(f"{color[0]},{color[1]},{color[2]}\n".encode())

                if time.time() >= next_update_time:
                    # Plot the FFT spectrum
                    plt.clf()  # Clear the figure
                    plt.plot(positive_freqs, positive_spectrum)
                    plt.pause(0.01)  # Pause for plot to update
                    next_update_time = time.time() + UPDATE_RATE

    finally:
        stream.stop_stream()
        stream.close()
        p.terminate()
        ser.close()
        print("Program terminated.")

if __name__ == "__main__":
    main()