import sys
input = sys.stdin.readline

t = int(input())

def s():
    n = int(input())
    a = list(map(int, input().split()))
    s = [0] * (n+1)
    for i in range(1, n+1):
        s[i] = s[i-1] + a[i]

    dp = [[0] * (n+1) for _ in range(n+1)]
    for i in range(1, n):
        for j in range(1, n-i+1):
            dp[j][j+i] = min(dp[j][j+k] + dp[j+k+1][j+i] for k in range(i)) + s[j+i] - s[j-1]
    print(dp[1][n])


for _ in range(t):
   s()