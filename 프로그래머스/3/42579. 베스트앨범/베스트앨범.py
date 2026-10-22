import heapq

def solution(genres, plays):
    answer = []
    d = {}
    most_plays = []
    for i in range(len(genres)):
        if genres[i] not in d:
            d[genres[i]] = [(plays[i], i)]
            d[genres[i]].insert(0, plays[i])
        else:
            d[genres[i]].append((plays[i], i))
            d[genres[i]][0] += plays[i]
    for g in d:
        heapq.heappush(most_plays, (-d[g][0], g))
    
    while most_plays:
        # 많이 재생된 장르
        max_play = heapq.heappop(most_plays)[1]
        arr = []
        for i, p in enumerate(d[max_play]):
            if i == 0: continue
            heapq.heappush(arr, (-p[0], p[1]))
        count = 0
        while arr:
            if count == 2: break
            answer.append(heapq.heappop(arr)[1])
            count += 1
            
    
    # 많이 재생된 노래
    # 고유 번호가 낮은 노래
    # 두 개씩 모으기
    
    return answer