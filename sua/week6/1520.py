import sys
input = sys.stdin.readline
m, n = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(m)]
# 상하좌우 graph[x][y]
dx, dy = [0, 0, -1, 1], [-1, 1, 0, 0]
dp = [[-1] * n for _ in range(m)]
def dfs(sx, sy):
    if sx == m-1 and sy == n-1:
        return 1

    if dp[sx][sy] != -1:
        return dp[sx][sy]

    ways = 0
    for i in range(4):
        nx, ny = sx + dx[i], sy + dy[i]
        if 0 <= nx < m and 0 <= ny < n and graph[sx][sy] > graph[nx][ny]:
            ways += dfs(nx, ny)

    dp[sx][sy] = ways
    return dp[sx][sy]


print(dfs(0, 0))