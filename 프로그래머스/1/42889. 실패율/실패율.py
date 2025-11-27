def solution(N, stages):
    answer = []
    arr = [0] * (N+2)
    
    for i in stages:
        arr[i] += 1
    
    try_people = sum(arr)
    
    for i in range(1, len(arr)-1):
        if arr[i] == 0:
            answer.append([i, 0])
        else: 
            answer.append([i, arr[i]/try_people])
            try_people -= arr[i]
            
    answer.sort(key=lambda x: x[1], reverse=True)
    return ([a[0] for a in answer])