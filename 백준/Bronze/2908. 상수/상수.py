a, b = input().split()
a1 = []
b1 = []

for i in a:
    a1.append(i)
for k in b:
    b1.append(k)

a1.reverse()
b1.reverse()
a = ''.join(a1)
b = ''.join(b1)
print(max(int(a), int(b)))