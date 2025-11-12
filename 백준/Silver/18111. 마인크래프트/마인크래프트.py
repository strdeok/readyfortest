import sys  # 빠른 입력을 위해 sys 사용

# 첫 줄: n(행), m(열), b(인벤토리 블록 수)
n, m, b = map(int, sys.stdin.readline().split())

# 전체 땅 높이를 일렬로 입력받기
ground = []
for _ in range(n):                                        # n줄 반복
    ground += list(map(int, sys.stdin.readline().split()))  # 각 줄의 m개 높이 추가

# 현재 지형의 최소/최대 높이
min_ground = min(ground)  # 목표 높이 하한
max_ground = max(ground)  # 목표 높이 상한

# 결과 초기화
min_time = 10**18   # 충분히 큰 수로 초기화
max_height = -1     # 최소 시간일 때의 최대 높이

# 가능한 모든 목표 높이 h를 시도 (min~max면 충분)
for h in range(min_ground, max_ground + 1):  # 목표 높이 h
    add = 0      # h까지 올리기 위해 필요한 블록 총합
    remove = 0   # h로 내리며 회수되는 블록 총합

    # 모든 칸을 순회하면서 add/remove 총합만 계산 (순서 독립)
    for block in ground:          # 각 칸의 현재 높이
        if block > h:             # 목표보다 높으면
            remove += (block - h) # 그만큼 제거(인벤토리로 회수)
        elif block < h:           # 목표보다 낮으면
            add += (h - block)    # 그만큼 추가(인벤토리에서 사용)

    # 가능 여부: 제거한 블록 + 기존 인벤토리로 add를 충당할 수 있어야 함
    if remove + b < add:          # 부족하면 이 높이는 불가능
        continue                  # 다음 높이로

    # 시간 계산: 제거=2초/블록, 추가=1초/블록
    time = remove * 2 + add       # 총 소요 시간

    # 갱신 규칙: 더 작은 시간 우선, 같으면 더 높은 높이
    if (time < min_time) or (time == min_time and h > max_height):
        min_time = time           # 최소 시간 갱신
        max_height = h            # 그때의 높이 갱신

# 최종 결과 출력
print(min_time, max_height)       # 예: "640 64"
