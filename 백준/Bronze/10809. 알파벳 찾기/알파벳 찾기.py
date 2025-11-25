arr = [i for i in input()]
string = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z']

for i in string:
    if i not in arr:
        print(-1, end=" ")
    else:
        print(arr.index(i), end=" ")