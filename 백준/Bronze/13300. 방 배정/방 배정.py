# 동성끼리 여자 = 0 / 남자 = 1
# 같은 학년끼리
# 한 방에 한 명 가능
# 최대 인원 수 K
# 최소 방 개수
# 학년 별로 배열에 저장. ex. 1학년이면 students[0]
# 여자면 앞, 남자면 뒤 ex. 1학년 여자  students[0][0] + 1
# 방 개수 구하기
# 배열 반복문 돌려
# k로 나눠서 몫, 나머지를 count에 +1
n, k = map(int, (input().split()))

students = [[0]*2 for _ in range(6)]
count = 0

for i in range(n):
    s, y = map(int, input().split())
    students[y-1][s] += 1

for i in students:
    if i[0] >= k:
        count += i[0] // k
        if i[0] % k != 0:
            count += 1
    elif i[0] < k and i[0] != 0:
        count += 1
        
    if i[1] >= k:
        count += i[1] // k
        if i[1] % k != 0:
            count += 1
    elif i[1] < k and i[1] != 0:
        count += 1

print(count)
    