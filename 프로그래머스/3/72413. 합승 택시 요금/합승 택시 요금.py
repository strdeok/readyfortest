import heapq

def solution(n, s, a, b, fares):
    answer = float("inf")
    graph = [[] for _ in range(n + 1)]
    
    for start, end, cost in fares:
        graph[start].append((end, cost))
        graph[end].append((start, cost))
    
    
    def dijkstra(x):
        heap = [(0, x)]
        dist = [float("inf")] * (n + 1)
        dist[x] = 0
    
        while heap:
            current_dist, node = heapq.heappop(heap)

            if dist[node] < current_dist:
                continue
            for next_node, cost in graph[node]:
                new_cost = current_dist + cost
                if dist[next_node] > new_cost:
                    dist[next_node] = new_cost
                    heapq.heappush(heap, (new_cost, next_node))
        return dist
    
    s = dijkstra(s)
    a = dijkstra(a)
    b = dijkstra(b)
    
    for i in range(1, n+1):
        answer = min(answer, s[i] + a[i] + b[i])
    return answer