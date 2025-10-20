n = int(input())
count = 0

while True:
    if n == 0:
        print(count)
        break
    
    if n % 5 == 0:
        n -= 5
        count += 1
    elif n % 3 == 0:
        n -= 3
        count += 1
    elif n >= 5:
        n -= 5
        count += 1
    elif n >= 3:
        n -= 3
        count += 1
    else:
        print(-1)
        break