def solution(s):
    arr = s.split(" ")
    intarr = []
    for a in arr:
        intarr.append(int(a))
    maxNum = max(intarr)
    minNum = min(intarr)
    return (str(minNum) + " " + str(maxNum))
    