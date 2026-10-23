def solution(info, edges):
    answer = 0
    nodes = [[] for _ in range(len(info))]
    
    for start, end in edges:
        nodes[start].append(end)

    def dfs(s, w, available):
        nonlocal answer
        if w >= s:
            return
        answer = max(answer, s)
        for a in available:
            next_available = available.copy()
            next_available.remove(a)
            next_available.extend(nodes[a])
            if info[a] == 0:
                dfs(s + 1, w, next_available)
            if info[a] == 1:
                dfs(s, w + 1, next_available)
    dfs(1, 0, nodes[0])
    return answer