n, score, p = map(int, input().split())

if n == 0:
    print(1)
    exit()
    
arr = list(map(int, input().split()))
rank = 1

for i in arr:
    if i > score:
        rank += 1

if p < rank or (min(arr) == score and p == n):
    print(-1)
else: print(rank)