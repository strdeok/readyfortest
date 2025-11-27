# DFS
import sys

n, m  = map(int, input().split())
graph = []

for _ in range(m):
    graph.append(list(map(int, sys.stdin.readline().rsplit())))
    
if n == 1 and m == 1:
    print('Yes')
    exit()
    
dx = [1, 0]
dy = [0, 1]
visit = [[False] * n for _ in range(m)]

def dfs(x, y):
    if x == n -1 and y == m -1:
        print('Yes')
        exit()
        
    for i in range(2):
        nx = x + dx[i]
        ny = y + dy[i]
    
        
        if nx < n and ny < m and graph[ny][nx] == 1 and visit[ny][nx] == False:
            visit[ny][nx] = True
            dfs(nx, ny)
dfs(0, 0)
print('No')