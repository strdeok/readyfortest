def solution(s):
    answer = True
    stack = []
    
    for S in s:
        if len(stack) == 0:
            stack.append(S)
        elif stack[-1] == "(" and S == ")":
            stack.pop()
        else:
            stack.append(S)
    return True if len(stack) == 0 else False