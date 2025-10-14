import sys
try:
    a = int(input("Enter a : "))
    b = float(input("Enter b :"))
except:
    print("Error, please enter numeric input")
    sys.exit(1) # ends program