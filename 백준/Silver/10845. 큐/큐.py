from collections import deque
import sys

n = int(input())            
q = deque()

for _ in range(n):
    order = sys.stdin.readline().rsplit()
    
    if order[0] == 'push':
        q.append(int(order[1]))
    if order[0] == 'pop':
        if len(q) == 0:
            print(-1)
        else: 
            print(q[0])
            q.popleft()
    if order[0] == 'size':
        print(len(q))
    if order[0] == 'empty':
        if len(q) == 0:
            print(1)
        else: print(0)
    if order[0] == 'front':
        if len(q) == 0:
            print(-1)
        else: print(q[0])
    if order[0] == "back":
        if len(q) == 0:
            print(-1)
        else: print(q[-1])