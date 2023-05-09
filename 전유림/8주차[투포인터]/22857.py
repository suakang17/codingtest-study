import sys
input = sys.stdin.readline

n, k = map(int, input().split())
s = list(map(int, input().split()))

start, end = 0, 0
size, size_max = 0, 0
cnt = 0    # 홀수의 개수
flag = 1

for start in range(n):
    while cnt <= k and flag:
        if s[end] % 2:    # 홀수면
            if cnt == k :   # k개의 홀수를 만족하면
                break
            cnt += 1
        size += 1   # 홀수가 아니면 size를 늘려준다.
        if end == n-1:  # 끝까지 갔으면 종료
            flag = 0    # 종료를 위한 flag
            break
        end += 1    # 끝점을 늘려준다.

    if size_max < size - cnt:   # 최대값 갱신
        size_max = size - cnt

    if s[start] % 2:
        cnt -= 1
    size -= 1

print(size_max)