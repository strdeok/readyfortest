def solution(wallpaper):
    locations = []
    location = [-1, 0]
    for i in wallpaper:
        location[0] += 1
        location[1] = 0
        for k in list(i):
            if k == "#":
                locations.append(location[:])
                location[1] += 1
            else: 
                location[1] += 1
    rows = [loc[0] for loc in locations]
    cols = [loc[1] for loc in locations]
    return [min(rows), min(cols), max(rows)+1, max(cols)+1]