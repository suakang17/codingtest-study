import sys
n = int(sys.stdin.readline())
l = sorted([list(map(int, input().split())) for _ in range(n)])

dp = [1 for _ in range(n)]

for i in range(n):
    for j in range(i):
        if l[i][1] > l[j][1]:
            dp[i] = max(dp[i], dp[j] + 1)

print(n - max(dp))