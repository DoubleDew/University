def count_lucky_numbers(N, lucky_digits, G, unlucky_digits, a, b):
    count = 0
    
    for i in range(a, b + 1):
        for digit in unlucky_digits:
            if str(digit) in str(i):
                break
            else:
                count += 1
                
    return count

if __name__ == "__main__":
  N, *lucky_digits = map(int, input().split())
  G, *unlucky_digits = map(int, input().split())
  a, b = map(int, input().split())

  print(count_lucky_numbers(N, lucky_digits, G, unlucky_digits, a, b))