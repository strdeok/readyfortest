def solution(array, commands):
    answer = []
    for c in commands:
        cp = array
        i = c[0]
        j = c[1]
        k = c[2]
        sliced = cp[i - 1 : j]
        sliced.sort()
        answer.append(sliced[k - 1])
    return answer