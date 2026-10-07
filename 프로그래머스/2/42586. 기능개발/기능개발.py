def solution(progresses, speeds):
    answer = []

    days = 0
    count = 0

    for p, s in zip(progresses, speeds):
        left = 100 - p

        need_days = left // s + 1 if left % s != 0 else left // s

        if need_days <= days:
            count += 1
        else:
            if count > 0:
                answer.append(count)

            days = need_days
            count = 1

    answer.append(count)

    return answer