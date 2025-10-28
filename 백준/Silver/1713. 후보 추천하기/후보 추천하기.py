n = int(input())
b = int(input())
b_order = list(map(int, input().split()))

b_count = []
photo = []

if n == 0:
    exit()

for i in b_order:
    if i in photo:
        b_count[photo.index(i)] += 1
    else:
        if len(photo) < n:
            photo.append(i)
            b_count.append(1)
        else:
            min_cnt = min(b_count)
            idx = b_count.index(min_cnt) 
            del b_count[idx]
            del photo[idx]
            photo.append(i)
            b_count.append(1)

photo.sort()
print(' '.join(map(str, photo)))