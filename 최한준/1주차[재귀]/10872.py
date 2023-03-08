import sys

N = int(sys.stdin.readline())
ans = 1

def r(i):
    if i == 1 or i == 0:
        return 1
    else:
        return i * r(i - 1);


print(r(N))