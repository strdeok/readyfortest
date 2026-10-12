import heapq

def solution(N, road, K):
    answer = 0
    graph = [[] for _ in range(N + 1)]
    
    for start, end, cost in road:
        graph[start].append([end, cost])
        graph[end].append([start, cost])
    
    dist = [float("inf")] * (N + 1)
    dist[1] = 0
    
    heap = [(0, 1)]
    
    while heap:
        current_dist, node = heapq.heappop(heap)
        
        if current_dist > dist[node]:
            continue
        
        for next_node, cost in graph[node]:
            new_cost = current_dist + cost
            if dist[next_node] > new_cost:
                dist[next_node] = new_cost
                heapq.heappush(heap, (new_cost, next_node))
    for d in dist[1:]:
        if d <= K:
            answer += 1
    return answer