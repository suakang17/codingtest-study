import sys
k, n = map(int, sys.stdin.readline().split())
l = [int(sys.stdin.readline()) for _ in range(k)]
start, end = 1, max(l)

while start <= end:
    mid = (start + end) // 2
    lines = 0  # 랜선 수
    for i in l:
        lines += i // mid

    if lines >= n:
        start = mid + 1
    else:
        end = mid - 1
print(end)
