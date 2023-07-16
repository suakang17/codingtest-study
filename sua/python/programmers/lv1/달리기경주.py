players = ["mumu", "soe", "poe", "kai", "mine"]
callings = ["kai", "kai", "mine", "mine"]

#  시간초과
# def solution(players, callings):
#     answer = []
#
#     for overtaker in callings:
#         idx = players.index(overtaker)
#         overtake(idx, overtaker)
#
#     answer = players
#
#     return answer
#
#
# def overtake(idx, overtaker):
#     overtaked = players[idx - 1]
#     players[idx - 1] = overtaker
#     players[idx] = overtaked
#
#
# print(solution(players, callings))

def solution(players, callings):
    answer = []
    # idx = {i : player for i, player in enumerate(players)}
    p = {player: i for i, player in enumerate(players)}

    for overtaker in callings:
        idx = p[overtaker]  # 등수
        overtaken = players[idx - 1]
        players[idx - 1] = overtaker
        players[idx] = overtaken

    answer = players
    return answer

print(solution(players, callings))