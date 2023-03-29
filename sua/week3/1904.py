import sys
n = int(sys.stdin.readline())
dp = [0] * 1000000
dp[0] = 1
dp[1] = 2

# bottom-up: 시간 초과
# -> 수가 커질수록 나누는 시간도 오래 걸리므로
# 반복문 안에서 수시로 나머지 연산을 해 주어야 메모리 초과가 발생하지 않는다.
# 값이 int값을 초과하기 때문에 n = 1000000 일 경우 엄청나게 많은 메모리를 차지하게 된다.
# for i in range(2, n):
#     dp[i] = dp[i-1] + dp[i-2]
#
# print(dp[n-1] % 15746)

# runtimeerr - indexerr -> dp 초기화를 백만개인데 십만개로 잘못함
for i in range(2, n):
    dp[i] = (dp[i-1] + dp[i-2]) % 15746

print(dp[n-1])

# sol
n = int(input())

li = [1, 2]

for i in range(2, n):
    li.append((li[i - 1] + li[i - 2]) % 15746)
print(li[n - 1])