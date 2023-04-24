import sys
input = sys.stdin.readline

n, m = map(int, input().split())   # 앱의 개수, 활성화 시키고 싶은 앱의 메모리
an = list(map(int, input().split()))    # 활성화 앱의 메모리
cn = list(map(int, input().split()))    # 비활성화 했을 경우 앱의 비용

result = sys.maxsize
dp = [[0] * (sum(cn) + 1) for _ in range(n + 1)]   # dp[i][j] : i번째 앱까지 고려했을 때, 비용 j를 사용했을 때 확보할 수 있는 최대 메모리

for i in range(n):
    for j in range(sum(cn)):
        if cn[i] > j:
            dp[i][j] = dp[i - 1][j]
        else:
            dp[i][j] = max(dp[i-1][j], an[i]+dp[i-1][j-cn[i]])
        
        if dp[i][j] >= m:
            result = min(result, j)


if m==0:    # 활성화 시키고 싶은 앱의 메모리가 0이면 0
    print(0)
elif n == 1:    # 앱이 1개면 비활성화 했을 때의 비용 출력
    print(cn[0])
elif result == sys.maxsize:
    print(n*m)
else:
    print(result)