# 증가했다가 감소하는 수열
# O(N^2)
import sys
n = int(sys.stdin.readline())
l = list(map(int, sys.stdin.readline().split()))
dp_asc = [1 for _ in range(n)]
dp_dsc = [1 for _ in range(n)]
result = [1 for _ in range(n)]

for i in range(1, n):
    for j in range(i):
        if l[i] > l[j]:
            dp_asc[i] = max(dp_asc[i], dp_asc[j] + 1)

l.reverse()  # O(N)

for i in range(1, n):
    for j in range(i):
        if l[i] > l[j]:
            dp_dsc[i] = max(dp_dsc[i], dp_dsc[j] + 1)

dp_dsc.reverse()

for i in range(n):
    result[i] = dp_asc[i] + dp_dsc[i] - 1

print(max(result))