def solution(spell, dic):
    answer = []
    for i in dic:
        count = 0
        if len(spell) != len(i):
            answer.append(2)
        else:
            for k in spell:
                if k in i:
                    count += 1
                    if count == len(spell):
                        answer.append(1)
    print(answer)
    if 1 in answer:
        return 1
    else:
        return 2
                        