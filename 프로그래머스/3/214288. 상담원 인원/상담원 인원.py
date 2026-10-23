import heapq

def solution(k, n, reqs):
    # k 상담유형
    # n 멘토 수
    # reqs 상담요청
    answer = float('INF')
    tmp = 0
    participants = [[] for _ in range(k)] 
    
    # 유형별로 몰아넣기
    for start, end, t in reqs:
        participants[t-1].append((start, start+end))
    
    consultants = [1] * k
    
    def distribute(t):
        nonlocal tmp
        max_len = consultants[t - 1]
        q = []
        for start, end in participants[t - 1]:
            if (len(q) == max_len):
                prev_end = heapq.heappop(q)[0]
                wait = max(0, prev_end - start)
                tmp += wait
                heapq.heappush(q, (end + wait, start + wait))
            else:
                heapq.heappush(q, (end, start))
            
    def assign(count, idx):
        nonlocal tmp
        nonlocal answer
        
        if count > n:
            return
        elif count == n:
            for t in range(1, k+1):
                distribute(t)
            answer = min(answer, tmp)
            tmp = 0
            return
        for i in range(idx, k):
            consultants[i] += 1
            assign(count + 1, i)
            consultants[i] -= 1
    
    assign(k, 0)
    return answer