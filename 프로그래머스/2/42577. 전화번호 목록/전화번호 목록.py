def solution(phone_book):
    answer = True
    pb = sorted(phone_book)
    for idx, k in enumerate(pb):
        if (idx == len(phone_book) - 1): break
        
        if pb[idx + 1].startswith(k):
            answer = False
            break
    return answer