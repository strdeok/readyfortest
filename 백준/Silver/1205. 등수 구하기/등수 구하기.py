n, t, p = map(int, input().split())
if n == 0:
    print(1)
    exit()

rank_list = list(map(int, input().split()))

rank_list.sort(reverse=True)
rank = 1

if n >= p and rank_list[-1] >= t:
    print(-1)
    exit()
    
for i in range(n):
    if rank_list[i] > t:
        rank += 1

print(rank)