def solution(array, commands):
    answer = []
    
    for i in commands:
        copied = array
        changed = (copied[i[0]-1:i[1]])
        changed.sort()
        answer.append(changed[i[2]-1])
        
    return answer