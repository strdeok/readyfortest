from collections import deque

def solution(board):
    answer = -1
    rows = len(board)
    cols = len(board[0])
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    
    q = deque()
    visited = set()
    goal = []
    
    for r in range(rows):
        for c in range(cols):
            if board[r][c] == 'R':
                q.append((r, c, 0))
                visited.add((r,c))
            if board[r][c] == 'G':
                goal = [r, c]
    
    def move(x, y, dx, dy):
        nx = x
        ny = y
        while (0 <= nx < rows 
            and 0 <= ny < cols
            and board[nx][ny] != 'D'           
           ):
            nx += dx
            ny += dy
        return nx - dx, ny - dy
    
    while q:
        x, y, count = q.popleft()
        if goal[0] == x and goal[1] == y:
            answer = count
            break
        for i in range(4):
            nx, ny = move(x, y, dx[i], dy[i])
            if nx == x and ny == y:
                continue
            if (nx, ny) not in visited:
                visited.add((nx, ny))
                q.append((nx, ny, count + 1))
    return answer