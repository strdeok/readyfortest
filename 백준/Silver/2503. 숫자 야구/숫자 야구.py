y = []

for h in range(1,10):
    for t in range(1,10):
        for i in range(1,10):
            if h != t and h != i and t != i:
                y.append(str(h) + str(t) + str(i))

for k in range(int(input())):
    n,s,b = input().split()
    answer = []
    s = int(s)
    b = int(b)
    
    for i in y:
        strike_count = 0
        ball_count = 0

        if n[0] == i[0]:
            strike_count += 1
        elif n[0] in i:
            ball_count += 1

        if n[1] == i[1]:
            strike_count += 1
        elif n[1] in i:
            ball_count += 1

        if n[2] == i[2]:
            strike_count += 1
        elif n[2] in i:
            ball_count += 1

        if strike_count == s and ball_count == b:
            answer.append(i)
    y = answer
print(len(y))