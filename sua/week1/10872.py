import sys

def fac(n):  # O(N)
    res = 1
    for i in range(n, 0, -1):
        res *= i
    return res

print(fac(int(sys.stdin.readline())))