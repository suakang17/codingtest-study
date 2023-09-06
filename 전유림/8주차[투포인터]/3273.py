import sys
input = sys.stdin.readline

n = int(input())
s = list(map(int, input().split()))
x = int(input())

start, end = 0, n-1
cnt = 0

s.sort()

while start < end:
    if s[start] + s[end] == x:
        cnt += 1
        start += 1
        end -= 1
    elif s[start] + s[end] < x:
        start += 1
    else:
        end -= 1

print(cnt)