from collections import Counter

def solution(participant, completion):
    count_p = Counter(participant)
    count_c = Counter(completion)

    result = count_p - count_c
    return list(result.keys())[0]