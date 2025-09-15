def solution(s):
    answer = ''
    
    arr = []
    for i in s:
        arr.append(i)
    print(arr)
    if len(arr) % 2 == 0:
        answer +=  arr[int(len(arr)/2 - 1)] + arr[int(len(arr)/2)]
    else:
        answer += arr[len(arr)//2]
    return answer