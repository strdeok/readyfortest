def solution(answers):
    answer = []
    p_1 = [1, 2, 3, 4, 5]
    p_2 = [2,1,2,3,2,4,2,5]
    p_3 = [3,3,1,1,2,2,4,4,5,5]
    arr = [0,0,0]
    
    for i in range(len(answers)):
        if p_1[i%5] == answers[i]:
            arr[0] += 1
        if p_2[i%len(p_2)] == answers[i]:
            arr[1] += 1
        if p_3[i%len(p_3)] == answers[i]:
            arr[2] += 1
            
    high = max(arr)
    for i in range(len(arr)):
        if arr[i] == high:
            answer.append(i+1)
    return answer