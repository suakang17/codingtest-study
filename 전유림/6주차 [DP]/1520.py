import sys
input = sys.stdin.readline

m, n = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(m)]
dp = [[-1]*n for _ in range(m)]
dx = [0, 0, -1, 1]  # 상하좌우
dy = [-1, 1, 0, 0]

def dfs(x, y):

    if x == m-1 and y == n-1:   # 도착지점에 도착하면 1을 리턴
        return 1

    if dp[x][y] == -1:  # 방문하지 않았다면
        dp[x][y] = 0    # 방문했다고 표시
        for i in range(4):  # 상하좌우 탐색
            nx = x + dx[i] 
            ny = y + dy[i]
            if 0 <= nx < m and 0 <= ny < n: # 범위를 벗어나지 않는다면
                if arr[x][y] > arr[nx][ny]: # 현재 위치보다 낮은 곳으로만 이동
                    dp[x][y] += dfs(nx, ny) # dfs를 통해 이동할 수 있는 경로의 수를 더해준다.
    return dp[x][y]


print(dfs(0, 0))
