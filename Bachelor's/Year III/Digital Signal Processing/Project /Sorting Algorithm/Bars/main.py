import wave
import numpy as np
import matplotlib.pyplot as plt
import matplotlib.animation as animation

def read_wav_file(file_path):
    with wave.open(file_path, 'rb') as wav_file:
        n_channels = wav_file.getnchannels()
        sample_width = wav_file.getsampwidth()
        n_frames = wav_file.getnframes()
        framerate = wav_file.getframerate()
        
        frames = wav_file.readframes(n_frames)
        

        if sample_width == 1:
            dtype = np.uint8  
        elif sample_width == 2:
            dtype = np.int16  
        else:
            raise ValueError(f"Unsupported sample width: {sample_width}")

        samples = np.frombuffer(frames, dtype=dtype)
        
        if n_channels > 1:
            samples = samples.reshape(-1, n_channels)
            
        return samples, framerate

def animate_sorted_spectrum(samples, framerate):
    if samples.ndim > 1:
        samples = samples[:, 0]
    fft_magnitude = np.abs(np.fft.rfft(samples))

    return fft_magnitude


def bubble_sort(numbers):
    n = len(numbers)
    swapped = True
    while swapped:
        swapped = False
        for i in range(n-1):
            if numbers[i] > numbers[i+1]:
                numbers[i], numbers[i+1] = numbers[i+1], numbers[i]
                yield numbers
                swapped = True

def insertion_sort(data):
    steps = []
    for i in range(1, len(data)):
        key = data[i]
        j = i - 1
        while j >= 0 and key < data[j]:
            data[j + 1] = data[j]
            j -= 1
        data[j + 1] = key
        steps.append(data.copy())
    return steps

def quick_sort(data):
    def partition(arr, low, high):
        pivot = arr[high]
        i = low - 1
        for j in range(low, high):
            if arr[j] <= pivot:
                i += 1
                arr[i], arr[j] = arr[j], arr[i]
        arr[i + 1], arr[high] = arr[high], arr[i + 1]
        return i + 1

    def _quick_sort(arr, low, high, steps):
        if low < high:
            pi = partition(arr, low, high)
            steps.append(arr.copy())
            _quick_sort(arr, low, pi - 1, steps)
            _quick_sort(arr, pi + 1, high, steps)

    steps = []
    _quick_sort(data, 0, len(data) - 1, steps)
    return steps


def bucket_sort(data):
    steps = []
    if len(data) == 0:
        return data
    
    bucket_count = len(data)
    max_value = max(data)
    min_value = min(data)
    buckets = [[] for _ in range(bucket_count)]

    for num in data:
        index = int((num - min_value) / (max_value - min_value + 1) * bucket_count)
        buckets[index].append(num)
    
    sorted_data = []
    for bucket in buckets:
        sorted_bucket = sorted(bucket)
        sorted_data.extend(sorted_bucket)
        steps.append(sorted_data.copy())
    
    return steps

# def main():

#     file_path = 'song.wav'

#     samples, framerate = read_wav_file(file_path)

#     fft = animate_sorted_spectrum(samples, framerate)
#     numbers = fft[:64]

#     fig, ax = plt.subplots()
#     bars = ax.bar(range(len(numbers)), sorted(numbers.copy()), color='blue')
#     plt.show()

#     fig, ax1 = plt.subplots(figsize=(10, 6))
#     bars = ax1.bar(range(len(numbers)), numbers)
#     def update_fig(numbers):
#         for bar, height in zip(bars, numbers):
#             bar.set_height(height)
#         return bars

#     # ani = animation.FuncAnimation(fig, update_fig, frames=bubble_sort(numbers.copy()), blit=True, repeat=False, interval=5)
#     # ani = animation.FuncAnimation(fig, update_fig, frames=insertion_sort(numbers.copy()), blit=True, repeat=False, interval=60)
#     ani = animation.FuncAnimation(fig, update_fig, frames=quick_sort(numbers.copy()), blit=True, repeat=False, interval=150)
#     # ani = animation.FuncAnimation(fig, update_fig, frames=bucket_sort(numbers.copy()), blit=True, repeat=False, interval=60)

#     plt.title('Sorting Visualization')
#     plt.xlabel('Index')
#     plt.ylabel('Value')
#     plt.show()
#     plt.close()

def main():
    file_path = 'song.wav'

    samples, framerate = read_wav_file(file_path)

    fft = animate_sorted_spectrum(samples, framerate)
    data = fft[:64]

    norm = plt.Normalize(min(data), max(data))
    cmap = plt.cm.RdYlGn

    sorted_data = sorted(data.copy())
    colors = cmap(norm(sorted_data))

    fig, ax = plt.subplots()
    ax.pie(sorted_data, autopct=None, startangle=140, colors=colors)
    ax.set_title('Sorted Data')
    plt.show()

    steps = quick_sort(data)
    fig, ax = plt.subplots(figsize=(10, 10))

    def update_pie_chart(num):
        ax.clear()
        current_data = steps[num]
        colors = cmap(norm(current_data))
        ax.pie(current_data, autopct=None, startangle=140, colors=colors)
        ax.set_title('Sort Animation')

     # ani = animation.FuncAnimation(fig, update_pie_chart, frames=bubble_sort(data.copy()), blit=True, repeat=False, interval=5)
    # ani = animation.FuncAnimation(fig, update_pie_chart, frames=insertion_sort(data.copy()), blit=True, repeat=False, interval=60)
    ani = animation.FuncAnimation(fig, update_pie_chart, frames=quick_sort(data.copy()), blit=True, repeat=False, interval=150)
    # ani = animation.FuncAnimation(fig, update_pie_chart, frames=bucket_sort(data.copy()), blit=True, repeat=False, interval=60)
    
    plt.title('Sorting Visualization')
    plt.xlabel('Index')
    plt.ylabel('Value')
    plt.show()
    plt.close()


if __name__ == "__main__":
    main()
