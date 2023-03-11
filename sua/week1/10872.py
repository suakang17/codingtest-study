import sys

def fac(n):  # O(N)
    res = 1
    for i in range(n, 0, -1):
        res *= i
    return res

print(fac(int(sys.stdin.readline())))

def recursivefac(n):
    ret = 1
    if n > 0:
        ret = n * recursivefac(n-1)
    return ret

print(recursivefac(int(sys.stdin.readline())))