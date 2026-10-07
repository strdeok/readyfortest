from collections import deque
def solution(maps):
    answer = -1
    n = len(maps)
    m = len(maps[0])
    dx = [1, -1, 0, 0]
    dy = [0, 0, -1, 1]
    visited = [[False] * m for _ in range(n)]
    dq = deque()
    
    visited[0][0] = True
    
    dq.append([0, 0, 0])
    
    while dq:
        now = dq.popleft()
        if now[0] == n - 1 and now[1] == m - 1:
            answer = now[2] + 1
            break
        for i in range(4):
            nx = now[0] + dx[i]
            ny = now[1] + dy[i]
            dist = now[2]
            if nx >= 0 and ny >= 0 and nx < n and ny < m and not visited[nx][ny] and maps[nx][ny] == 1:
                visited[nx][ny] = True
                dq.append([nx, ny, dist + 1])
        
    return answer