def solution(n, lost, reserve):
    lost_set = set(lost)
    reserve_set = set(reserve)

    common_set = lost_set & reserve_set
    
    for c in common_set:
        lost_set.remove(c)
        reserve_set.remove(c)
        
    for r in sorted(reserve_set):
        if r - 1 in lost_set:
            lost_set.remove(r-1)
        elif r + 1 in lost_set:
            lost_set.remove(r+1)

    return n - len(lost_set)