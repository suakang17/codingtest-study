import sys
input = sys.stdin.readline

n = int(input())
s = [list(map(int, input().split())) for i in range(n)]  # [[5,3],[3,2],[2,6] ...]
dp = [[0] * n for i in range(n)]  # n x n 크기 테이블 -> dp[x][y] == min (행렬x ~ 행렬y까지의 곱셈연산횟수)

for i in range(1, n):  # 첫 행렬
    for j in range(n-i):  # 대각선
        x = j + i
        dp[j][x] = 2 ** 32  # 최댓값 (문제에서 제시)

        for k in range(j, x):
            dp[j][x] = min(dp[j][x], dp[j][k] + dp[k + 1][x] + s[j][0] * s[k][1] * s[x][1])


print(dp[0][n - 1])