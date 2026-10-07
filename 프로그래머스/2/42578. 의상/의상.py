def solution(clothes):
    answer = 1
    d = {}

    for name, category in clothes:
        if category not in d:
            d[category] = []

        d[category].append(name)

    for category in d:
        answer *= len(d[category]) + 1
    
    
    return answer - 1