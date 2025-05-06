def solution(k, score):
    answer = []
    savedList = []

    for i in range(len(score)):
        savedList.append(score[i])
        arrangedList = sorted(savedList, reverse=True)
        hall_of_fame = arrangedList[:k]
        savedList = hall_of_fame
        answer.append(hall_of_fame[-1])

    return answer
