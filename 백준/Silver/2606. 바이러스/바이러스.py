from collections import deque

def bfs(graph, start, visited):
    queue = deque([start])
    visited[start] = True
    count = 0

    while queue:
        v = queue.popleft()
        for i in graph[v]:
            if not visited[i]:
                visited[i] = True
                queue.append(i)
                count += 1
    return count

computers = int(input())
networks = int(input())

graph = [[] for _ in range(computers + 1)]

for _ in range(networks):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

visited = [False] * (computers + 1)

print(bfs(graph, 1, visited))
