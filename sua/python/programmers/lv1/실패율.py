# 22번 tc 시간 초과

def solution(N, stages):
    failure_dict = {stage: 0 for stage in range(1, N + 1)}  # stage : 실패율
    cnt_dict = {stage: 0 for stage in range(1, N + 1)}  # stage : 도달자
    cnt1 = {stage: 0 for stage in range(1, N + 1)}  # stage : 도달 but not clear

    for stage in cnt_dict:
        for s in stages:
            if s >= stage:
                cnt_dict[stage] += 1
            if s == stage:
                cnt1[stage] += 1

    for i in range(1, N + 1):
        if cnt_dict[i] == 0:
            failure_dict[i] = 0
            continue
        failure_dict[i] = cnt1[i] / cnt_dict[i]

    sorted_failure_dict = sorted(failure_dict.items(), key=lambda item: item[1], reverse=True)
    answer = [sorted_failure_dict[i][0] for i in range(len(sorted_failure_dict))]

    return answer


a = 5
b = [2, 1, 2, 6, 2, 4, 3, 3]
print(solution(a, b))