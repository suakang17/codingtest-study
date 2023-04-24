import sys
input = sys.stdin.readline

n, k = map(int, input().split())
val = list(int(input()) for _ in range(n))

# 합이 i원이 되는 경우의 수를 담는 dp table
# dp[0] == 1 : 합이 0원이 되는 경우의 수가 아닌 dp[i]를 위한 사전 선언
# dp[i] == 합이 i원이 되는 경우의 수 (i > 0)
dp = [1] + [0 for _ in range(k+1)]

for i in val:
    for j in range(i, k+1):
        if j - i >= 0:
            dp[j] += dp[j-i]

print(dp[k])