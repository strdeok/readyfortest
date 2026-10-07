def solution(sizes):
    answer = 0
    max_w = 0
    max_h  = 0
    for w, h in sizes:
        mw = max(w, h)
        mh = min(w, h)
        max_w = max(max_w, mw)
        max_h = max(max_h, mh)
    
    return max_w * max_h