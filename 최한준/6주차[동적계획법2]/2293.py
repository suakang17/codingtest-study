import sys
input = sys.stdin.readline

N, K = map(int, input().split(' '))
coins = []
for _ in range(N):
    coins.append(int(input()))


def solution():
    dp = [0] * (K+1)
    dp[0] = 1
    for i in range(N):
        coin = coins[i]
        for j in range(coin, K+1):
            dp[j] += dp[j-coin]

    return dp[K]


print(solution()) 