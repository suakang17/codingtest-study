import sys
input = sys.stdin.readline

def solve():
    k, arr = int(input()), [0] + list(map(int, input().split()))
    # 누적합
    s = [0 for _ in range(k+1)]
    for i in range(1, k+1):
        s[i] = s[i-1] + arr[i]

    dp = [[0 for _ in range(k+1)] for _ in range(k+1)]
    for i in range(2, k+1):  # i == 부분 파일의 길이
        for j in range(1, k+2-i):  # 시작점
            dp[j][j+i-1] = min([dp[j][j+k] + dp[j+k+1][j+i-1] for k in range(i-1)]) + (s[j+i-1] - s[j-1])

    print(dp[1][k])


for _ in range(int(input())):  # t
    solve()