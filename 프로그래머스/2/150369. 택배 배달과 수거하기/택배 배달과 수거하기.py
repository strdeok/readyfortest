def solution(cap, n, deliveries, pickups):
    answer = 0
    di = n - 1
    pi = n - 1

    while True:
        while di >= 0 and deliveries[di] == 0:
            di -= 1

        while pi >= 0 and pickups[pi] == 0:
            pi -= 1

        if di < 0 and pi < 0:
            break

        answer += (max(di, pi) + 1) * 2

        dc = cap

        while dc > 0 and di >= 0:
            amount = min(dc, deliveries[di])

            deliveries[di] -= amount
            dc -= amount

            if deliveries[di] == 0:
                di -= 1
        
        pc = cap
        while pc > 0 and pi >= 0:
            amount = min(pc, pickups[pi])

            pickups[pi] -= amount
            pc -= amount

            if pickups[pi] == 0:
                pi -= 1
        

    return answer