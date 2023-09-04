from collections import defaultdict


def solution(id_list, report, k):
    report = list(set(report))
    reporter_reported = defaultdict(set)  # 유저별 신고한 사람 id
    cnt = defaultdict(int)

    for r in report:
        reporter, reported = r.split()
        reporter_reported[reporter].add(reported)  # 신고한사람 : {신고당한사람}
        cnt[reported] += 1  # 신고당한사람 : 신고당한 횟수

    answer = []
    for id in id_list:
        mailcnt = 0
        for user in reporter_reported[id]:
            if cnt[user] >= k:
                mailcnt += 1
        answer.append(mailcnt)

    return answer