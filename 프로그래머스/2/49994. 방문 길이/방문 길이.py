def solution(dirs):
    x,y = 0, 0
    distance = 0
    history = set()
    
    for i in dirs:
        nx, ny = x, y
        if i == "U" and y < 5:
            ny += 1
        elif i == "L" and x > -5:
            nx -= 1
        elif i == "R" and x < 5:
            nx += 1
        elif i == "D" and y > -5:
            ny -= 1
        else:
            continue
        
        if ((x, y, nx, ny) not in history and (nx, ny, x, y) not in history):
            distance += 1
            history.add((x,y,nx,ny))
        x, y = nx, ny
    return distance