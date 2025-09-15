def solution(array):
    answer = {}
    a = set(array)
    b = list(a)
    
    for i in b:
        answer[i] = array.count(i)

    c = [k for k,v in answer.items() if max(answer.values()) == v]
    if len(c) > 1:
        return -1
    else:
        return c[0]