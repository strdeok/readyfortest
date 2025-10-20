case = 0

while True:
    l, p, v = map(int, input().split())
    if l == 0 and p == 0 and v ==0:
        break
    case += 1
    print(f"Case {case}: {v // p * l + min(v % p, l)}")