from collections import deque

n, m, v = map(int, input().split())

graph = [[] for _ in range(n+1)]

for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

for i in range(1, n + 1):
    graph[i].sort()  

def bfs(start):
    visited = [False] * (n + 1)
    queue = deque([start])
    visited[start] = True
    while queue:
        v = queue.popleft()
        print(v, end = ' ')
        for i in graph[v]:
            if not visited[i]:
                visited[i] = True
                queue.append(i)
    
    
dfs_visited = [False] * (n + 1)
def dfs(v):
    dfs_visited[v] = True
    print(v, end=" ")
    for i in graph[v]:
        if not dfs_visited[i]:
            dfs(i)
            
dfs(v)    
print()
bfs(v)