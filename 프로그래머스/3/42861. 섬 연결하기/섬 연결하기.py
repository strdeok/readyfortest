def solution(n, costs):
    answer = 0
    parent = list(range(n))
    costs.sort(key=lambda x:x[2])
    
    def find(x):
        if x != parent[x]:
            parent[x] = find(parent[x])
        return parent[x]
    
    def union(a, b):
        root_a = find(a)
        root_b = find(b)
        
        if (root_a == root_b):
            return False
        
        parent[root_a] = root_b
        return True
    
    for a, b, cost in costs:
        if union(a, b):
            answer += cost
    
    return answer