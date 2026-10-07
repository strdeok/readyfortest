import heapq

def solution(scoville, K):
    answer = 0
    
    heapq.heapify(scoville)
    while True:
        if (scoville[0] >= K):
            break
        if len(scoville) < 2 and scoville[0] < K:
            answer = -1
            break
        a = heapq.heappop(scoville)
        b = heapq.heappop(scoville)

        heapq.heappush(scoville, a + b * 2)
        answer += 1
    
    return answer