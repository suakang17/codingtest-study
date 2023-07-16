import sys
input = sys.stdin.readline

# 1.
def scale(n_list, n, now, left, right, possible):  # scale(추리스트, 추개수, 현재 몇변째 추인지, 왼쪽무게, 오른쪽무게, 판정가능한무게리스트)
    new = abs(left - right)  # 현재 양측의 무게 차
    if (new not in possible):
        possible.append(new)

    if (now == n):  # 더이상 올릴 추 x -> 끝
        return 0

    # 아직 미방문시 (dfs)
    if (answer[now][new] == 0):  # now번째 추까지 사용, new 무게차를 측정했는지 table
        # 저울의 왼쪽에 놓는 경우
        scale(n_list, n, now + 1, left + n_list[now], right, possible)

        # 저울의 오른쪽에 놓는 경우
        scale(n_list, n, now + 1, left, right + n_list[now], possible)

        # 저울에 아예 안놓는 경우 (해당 추 사용 x)
        scale(n_list, n, now + 1, left, right, possible)

        answer[now][new] = 1  # 방문 표시


n = int(input())
n_list = list(map(int, input().split()))

m = int(input())
m_list = list(map(int, input().split()))

possible = []

# n번째 추 올렸을 때 추로 만들 수 있는 모든 무게 (0-아무것도 안올림 ~ 15000-500g짜리 다올림)
answer = [[0] * 15001 for i in range(n + 1)]

scale(n_list, n, 0, 0, 0, possible)

for i in range(0, len(m_list)):
    if (m_list[i] in possible):
        print("Y", end=' ')

    else:
        print("N", end=' ')

# 2.

n, n_list = int(input()), list(map(int, input().split()))
m, m_list = int(input()), list(map(int, input().split()))

# 추의 무게는 최대 500이므로 [[추의 개수*500]*추의 개수]로 배열을 구성한다.
dp, r = [[0 for j in range((i + 1) * 500 + 1)] for i in range(n + 1)], []


def scale(num, weight):
    if num > n:
        return

    if dp[num][weight]:
        return

    dp[num][weight] = 1

    scale(num + 1, weight)
    scale(num + 1, weight + n_list[num - 1])
    scale(num + 1, abs(weight - n_list[num - 1]))


scale(0, 0)

for i in m_list:
    if i > 30 * 500:
        r.append("N")
        continue
    if dp[n][i] == 1:
        r.append("Y")
    else:
        r.append("N")
print(*r)