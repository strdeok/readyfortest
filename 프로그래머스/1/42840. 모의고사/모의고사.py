def solution(answers):
    answer = [0, 0, 0]
    one_pattern = [1, 2, 3, 4, 5]
    two_pattern = [2,1,2,3,2,4,2,5]
    third_pattern = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5] 

    
    for i in range(len(answers)):
        if answers[i] == one_pattern[i%5]:
            answer[0] += 1
        if answers[i] == two_pattern[i%8]:
            answer[1] += 1
        if answers[i] == third_pattern[i%10]:
            answer[2] += 1
            
    a = []
    max_score = -1
    for j, k in enumerate(answer):
        if k > max_score:
            a = [j+1]
            max_score = k
        elif k == max_score:
            a.append(j+1)
    return a