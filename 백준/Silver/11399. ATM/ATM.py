n = int(input())
arr = list(map(int, input().split()))

arr.sort()
answer = 0
answer_arr = []
for i in arr:
    answer = answer + i
    answer_arr.append(answer)
    
print(sum(answer_arr))