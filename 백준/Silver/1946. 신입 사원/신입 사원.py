import sys
input = sys.stdin.readline

t = int(input())
whole = []
for _ in range(t):
    people = 1
    scores = []
    best_score = 999
    
    for _ in range(int(input())):
        a, b = map(int, input().split())
        scores.append([a,b])
    scores.sort(key=lambda x: x[0])
    best_score = scores[0][1]
    for i in range(len(scores)-1):
        if scores[i+1][1] < best_score:
            best_score = scores[i+1][1]
            people += 1
    print(people)