n = int(input())
count = 0

for _ in range(n):
    history = []
    current = ''
    a = input()
    if len(a) == 1:
        count += 1
        continue
    else:
        history.append(a[0])
        current = a[0]
        for k in range(1,len(a)):
            if a[k] in history and a[k] != current:
                break
            else:
                history.append(a[k])
                current=a[k]
        if ''.join(history) == a:
            count += 1
print(count)