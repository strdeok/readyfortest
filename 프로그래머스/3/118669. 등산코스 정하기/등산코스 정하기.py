import heapq

def solution(n, paths, gates, summits):
    answer = [float("inf"), float("inf")]

    graph = [[] for _ in range(n + 1)]

    for start, end, cost in paths:
        graph[start].append((end, cost))
        graph[end].append((start, cost))

    gate_set = set(gates)
    summit_set = set(summits)

    heap = []
    dist = [float("inf")] * (n + 1)

    for g in gates:
        dist[g] = 0
        heapq.heappush(heap, (0, g))

    while heap:
        cost, current_node = heapq.heappop(heap)

        if dist[current_node] < cost:
            continue

        if current_node in summit_set:
            continue

        for next_node, c in graph[current_node]:
            if next_node in gate_set:
                continue

            new_cost = max(cost, c)

            if dist[next_node] > new_cost:
                dist[next_node] = new_cost
                heapq.heappush(heap, (new_cost, next_node))

    for s in sorted(summits):
        if answer[1] > dist[s]:
            answer = [s, dist[s]]

    return answer