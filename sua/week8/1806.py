import sys
input = sys.stdin.readline

n, s = map(int, input().split())
num = list(map(int, input().split()))

lo, hi = 0, 0
sum = 0
min_length = sys.maxsize

while True:
    if sum >= s:
        min_length = min(min_length, hi - lo)
        sum -= num[lo]
        lo += 1
    elif hi == n:
        break
    else:
        sum += num[hi]
        hi += 1

if min_length == sys.maxsize:
    print(0)
else:
    print(min_length)