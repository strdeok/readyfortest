# 구현
import sys
n = int(input())
if n == 0:
    print(0)
    exit()
    
arr = []
for _ in range(n):
    arr.append(int(sys.stdin.readline()))

av = int((n * 15 / 100) + 0.5)

arr.sort()
arr = arr[av:len(arr)-av]
print(int(sum(arr) / len(arr) + 0.5))