n = int(input())
people = []
count= 0

while True:
    if count == n:
        break
    people.append(int(input()))
    count += 1
    

if n ==1:
    print(0)
    exit()

b = people[0]
people.remove(b)
maesoo = 0

while True:
    if b > max(people): break
    people.sort()
    people[-1] -= 1
    maesoo += 1
    b += 1
    
print(maesoo)
