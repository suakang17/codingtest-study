# s(ij) == s(행,열) = s(i번줄, j번째수)
# 인원을 배치해보면서 능력치 차이 최소로 만드는 팀 구성

# 스타트와 링크 두 팀으로 나누기 위하여 한 팀에 속하면 visited 리스트를 통하여 방문처리 해주면서 재귀함수 형태로 만든다.
# 만약 한 팀에 속한 팀원의 명수가 n//2로 다 채워졌으면 스타트팀의 능력치와 링크팀의 능력치를 구한다.
# 방문처리된 팀이 스타트팀이라고 하면, 방문처리 안된 팀이 링크팀이다. 이것을 이용해서 능력치를 구할 수 있다.
# 스타트팀의 능력치와 스타트팀의 능력치의 차이의 절대값과 최소 능력치값을 비교하면서 계속 갱신해준다.

def dfs(depth, idx):
    global min_diff
    if depth == n//2:  # n//2명이 팀 당 최대 인원이므로 이만큼의 깊이까지 도달하면 팀 완성 -> 각 팀의 능력치 구함
        power1, power2 = 0, 0  # 능력치 초기화 power 1: 스타트팀, power 2: 링크팀
        for i in range(n):  # 줄 수(i번째 줄)
            for j in range(n):  # j번째 수
                if visited[i] and visited[j]:
                    power1 += graph[i][j]
                elif not visited[i] and not visited[j]:
                    power2 += graph[i][j]
        min_diff = min(min_diff, abs(power1 - power2))
        return

    for i in range(idx, n):
        if not visited[i]:
            visited[i] = True
            dfs(depth + 1, i + 1)
            visited[i] = False  # 이미 팀에 담아서 능력치 차이 계산 끝난 조합(인원)은 False 처리 -> 팀에서 뺌


import sys
n = int(sys.stdin.readline())
visited = [False for _ in range(n)]
graph = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
min_diff = int(1e9)

dfs(0, 0)
print(min_diff)