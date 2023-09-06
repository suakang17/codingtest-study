import sys
input = sys.stdin.readline

def solve():
    n = int(input())
    a = list(map(int, input().split()))
    dp = [[0] * n for _ in range(n)]
    s = [0] * (n + 1)
    
    for i in range(1, n + 1):
        s[i] = s[i - 1] + a[i - 1]

    for i in range(2, n+1):
        for j in range(1, n+2-i):
            dp[j][j+i-1] = min(dp[j][j+k] + dp[j+k+1][j+i-1] for k in range(i-1)) + (s[j+i-1] - s[j-1])
    print(dp[1][n])

t = int(input())
for _ in range(t):
   solve()