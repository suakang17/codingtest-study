# DP: O(N^2)
import sys
n = int(sys.stdin.readline())
arr = list(map(int, sys.stdin.readline().split()))

# dp[i]: arr[i]를 마지막 값으로 가지는 가장 긴 증가 부분수열의 길이
dp = [1 for i in range(n)]

for i in range(n):
    for j in range(i):
        if arr[i] > arr[j]:
            dp[i] = max(dp[i], dp[j]+1)

print(max(dp))