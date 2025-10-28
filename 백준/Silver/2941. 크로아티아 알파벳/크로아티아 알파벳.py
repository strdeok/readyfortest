croatia = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']
w = input()
count = 0
i = 0 
while i < len(w):
    if i + 2 < len(w) and w[i:i+3] == 'dz=':
        count += 1
        i += 3
    elif i + 1 < len(w) and w[i:i+2] in croatia:
        count += 1
        i += 2  
    else:
        count += 1
        i += 1  
print(count)
