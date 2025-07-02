from collections import Counter

def solution(participant, completion):
    p_count = Counter(participant)
    c_count = Counter(completion)

    diff = p_count - c_count
    return list(diff.keys())[0]