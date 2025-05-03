def solution(sides):
    Min = min(sides[0], sides[1])
    Max = max(sides[0], sides[1])
    return len(list(range(Max-Min, Max))) +      len(list(range(Max+1, Max+Min)))
    
    
    
