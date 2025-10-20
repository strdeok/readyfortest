N = int(input())
store = list(map(int, input().split()))

count = 0
recent = -1 

for milk in store:
    if recent == -1 and milk == 0:
        count += 1
        recent = 0
    elif recent - milk == -1 or recent - milk == 2:
        count += 1
        recent = milk

print(count)
