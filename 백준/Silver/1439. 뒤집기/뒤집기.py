s = list(map(int, input()))

count_0 = 0
count_1 = 0

for i in range(len(s)-1):
    if s[i] != s[i+1]:
        if s[i] == 0:
            count_0 += 1
        else: count_1 += 1

if s[-1] == 0:
    count_0 += 1
else: count_1 += 1
print(min(count_0, count_1))