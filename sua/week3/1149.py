# 비용의 최솟값 -> dp
import sys
n = int(sys.stdin.readline())
p = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
# p[i][0]: R, p[i][1]: G, p[i][2]: B

# bottom-up
for i in range(1, len(p)):
    p[i][0] = min(p[i - 1][1], p[i - 1][2]) + p[i][0]
    p[i][1] = min(p[i - 1][0], p[i - 1][2]) + p[i][1]
    p[i][2] = min(p[i - 1][0], p[i - 1][1]) + p[i][2]
print(min(p[n - 1][0], p[n - 1][1], p[n - 1][2]))