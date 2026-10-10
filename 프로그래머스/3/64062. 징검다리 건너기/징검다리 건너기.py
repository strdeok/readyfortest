def solution(stones, k):
    left = 0
    right = max(stones)
    while left < right:
        mid = (left + right+ 1) // 2
        K = 0
        can = True
        for s in stones:
            if s < mid:
                K += 1
                if K >= k:
                    can = False
                    break
            else:
                K = 0
        if can:
            left = mid
        else: 
            right = mid - 1
    return left