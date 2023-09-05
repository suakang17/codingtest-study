import sys
input = sys.stdin.readline

n = int(input())
s = list(map(int, input().split()))
s.sort()

start, end = 0, n-1
ans = abs(s[start] + s[end])
result = [s[start], s[end]]
while start < end:
    tmp = s[start] + s[end]
    if abs(tmp) < ans:
        ans = abs(tmp)
        result = [s[start], s[end]]
        if tmp == 0 :
            break
    if tmp < 0:
        start += 1
    else:
        end -= 1

print(*result)