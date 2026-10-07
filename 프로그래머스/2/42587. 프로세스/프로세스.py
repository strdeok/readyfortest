from collections import deque

def solution(priorities, location):
    answer = 0
    dq = deque(enumerate(priorities))

    while True:
        i = dq.popleft()
        maxInt = 0
        
        for d in dq:
            maxInt = max(maxInt, d[1])
        if i[1] < maxInt:
            dq.append(i)
        elif (i[0] == location):
            break
        else: answer += 1
            
    return answer + 1