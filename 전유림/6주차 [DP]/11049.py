import sys
input = sys.stdin.readline

matrix = []
n = int(input())
for _ in range (n):
    r, c = map(int, input().split())
    matrix.append((r, c))

dp = [[0] * n for _ in range(n)]

def solve(n):
    for i in range(1, n):
        for j in range(n-i):
            dp[j][j+i] = min(dp[j][j+k] + dp[j+k+1][j+i] + matrix[j][0] * matrix[j+k][1] * matrix[j+i][1] for k in range(i))
    print(dp[0][n-1])

solve(n)
