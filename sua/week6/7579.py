import sys
input = sys.stdin.readline

n, m = map(int, input().split())
a = [0] + list(map(int, input().split()))  # byte
c = [0] + list(map(int, input().split()))  # cost
dp = [[0 for _ in range(sum(c) + 1)] for _ in range(n + 1)]  # 냅색알고리즘이 실행될 dp
result = sum(c)  # 열의 최댓값

for i in range(1, n + 1):
    byte = a[i]
    cost = c[i]

    for j in range(1, sum(c) + 1):
        if j < cost:  # 현재 앱을 비활성화할만큼의 cost가 충분하지 않을 경우
            dp[i][j] = dp[i - 1][j]
        else:
            # 같은 cost 내에서 현재 앱을 끈 뒤의 byte와 현재 앱을 끄지 않은 뒤의 byte를 비교
            dp[i][j] = max(byte + dp[i - 1][j - cost], dp[i - 1][j])

        if dp[i][j] >= m:  # 조건이 충족된다면
            result = min(result, j)  # 더 작은 cost값으로 갱신
if m != 0:
    print(result)
else:
    print(0)