arr = [i for i in map(int, input().split())]
answer = 0

for i in arr:
    answer += i**2
print(answer%10)