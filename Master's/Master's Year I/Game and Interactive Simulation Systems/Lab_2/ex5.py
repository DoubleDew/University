import numpy as np

print("Enter your number: ")
number = int(input())

file = open("unsorted.txt")
for i in file:
    if i == number:
        print("The number is in the file.")
        break
    else:
        print("The number is not in the file.")
        break