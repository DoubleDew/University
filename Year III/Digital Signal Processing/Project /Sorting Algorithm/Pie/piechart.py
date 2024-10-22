import matplotlib.pyplot as plt
import matplotlib.animation as animation
import numpy as np
import wave


def bubble_sort(data):
    steps = []
    n = len(data)
    data = data.copy()
    for i in range(n):
        for j in range(0, n-i-1):
            if data[j] > data[j+1]:
                data[j], data[j+1] = data[j+1], data[j]
                steps.append(data.copy())
    return steps

def quick_sort(data):
    steps = []
    _quick_sort(data, 0, len(data) - 1, steps)
    return steps

def _quick_sort(arr, low, high, steps):
    if low < high:
        pi = partition(arr, low, high, steps)
        _quick_sort(arr, low, pi - 1, steps)
        _quick_sort(arr, pi + 1, high, steps)

def partition(arr, low, high, steps):
    pivot = arr[high]
    i = low - 1
    for j in range(low, high):
        if arr[j] <= pivot:
            i += 1
            arr[i], arr[j] = arr[j], arr[i]
            steps.append(arr.copy())
    arr[i + 1], arr[high] = arr[high], arr[i + 1]
    steps.append(arr.copy())
    return i + 1

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

def merge_sort(data):
    steps = []
    _merge_sort(data, steps)
    return steps

def _merge_sort(data, steps):
    if len(data) > 1:
        mid = len(data) // 2
        L = data[:mid]
        R = data[mid:]

        _merge_sort(L, steps)
        _merge_sort(R, steps)

        i = j = k = 0
        while i < len(L) and j < len(R):
            if L[i] < R[j]:
                data[k] = L[i]
                i += 1
            else:
                data[k] = R[j]
                j += 1
            k += 1
        while i < len(L):
            data[k] = L[i]
            i += 1
            k += 1
        while j < len(R):
            data[k] = R[j]
            j += 1
            k += 1
        steps.append(data.copy())

def radix_sort(data):
    steps = []
    max1 = max(data)
    exp = 1
    while max1 / exp > 1:
        counting_sort(data, exp, steps)
        exp *= 10
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

def counting_sort(data, exp, steps):
    n = len(data)
    output = [0] * n
    count = [0] * 10

    for i in range(n):
        index = data[i] // exp
        count[index % 10] += 1

    for i in range(1, 10):
        count[i] += count[i - 1]

    i = n - 1
    while i >= 0:
        index = data[i] // exp
        output[count[index % 10] - 1] = data[i]
        count[index % 10] -= 1
        i -= 1

    for i in range(n):
        data[i] = output[i]
    steps.append(data.copy())

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

    # steps = bubble_sort(data)
    # steps = insertion_sort(data)
    steps = counting_sort(data)
    # steps = quick_sort(data)
    fig, ax = plt.subplots(figsize=(10, 10))

    def update_pie_chart(num):
        ax.clear()
        current_data = steps[num]
        colors = cmap(norm(current_data))
        ax.pie(current_data, autopct=None, startangle=140, colors=colors)
        ax.set_title('Sort Animation')

    ani = animation.FuncAnimation(
        fig, update_pie_chart, frames=len(steps), repeat=False, interval=50)
    plt.show()


if __name__ == "__main__":
    main()
