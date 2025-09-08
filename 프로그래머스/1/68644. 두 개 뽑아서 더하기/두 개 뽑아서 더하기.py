from itertools import combinations

def solution(numbers):
    answer = []
    
    bob = list(combinations(numbers, 2))
    for i in bob:
        answer.append(i[0]+i[1])
        
    return sorted(list(set(answer)))