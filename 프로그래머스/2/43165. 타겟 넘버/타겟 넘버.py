N = 0
Numbers = []
answer = 0

def solution(numbers, target):
    global N, Numbers, answer
    
    Numbers = numbers
    N = len(numbers)
    dfs(0, 0, target)
    return answer

def dfs(idx, num, target):
    global answer
    if (idx == N):
        if num == target:
            answer += 1
        return
    dfs(idx + 1, num + Numbers[idx], target)
    dfs(idx + 1, num - Numbers[idx], target)