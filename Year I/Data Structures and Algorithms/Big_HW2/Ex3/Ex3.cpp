#include <bits/stdc++.h>
using namespace std;

void printSolution(int arr[], int size)
{
    for (int i = 0; i < size; i++)
        cout << arr[i] << ' ';
    cout << '\n';
}

void transform(int arr[], int size, int index)
{
    int right = 2 * index + 2;
    int left = 2 * index + 1;
    int large = index;

    if (left < size && arr[left] > arr[large])
        large = left;

    if (right < size && arr[right] > arr[large])
        large = right;

    if (large != index)
    {
        swap(arr[index], arr[large]);
        transform(arr, size, large);
    }
}

void maxHeap(int arr[], int size)
{
    for (int i = size / 2 - 1; i >= 0; i--)
        transform(arr, size, i);
}

void heapSort(int arr[], int size)
{
    maxHeap(arr, size);
    for (int i = size - 1; i > 0; i--)
    {
        swap(arr[0], arr[i]);
        transform(arr, i, 0);
    }
}

int main()
{
    int arr[200];
    int n;
    cin >> n;
    for (int i = 0; i < n; i++)
        cin >> arr[i];
    printSolution(arr, n);
    heapSort(arr, n);
    printSolution(arr, n);
    return 0;
}