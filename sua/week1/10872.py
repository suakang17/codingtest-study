# import sys
#
# def fac(n):  # O(N)
#     res = 1
#     for i in range(n, 0, -1):
#         res *= i
#     return res
#
# print(fac(int(sys.stdin.readline())))
#
# def recursivefac(n):
#     ret = 1
#     if n > 0:
#         ret = n * recursivefac(n-1)
#     return ret
#
# print(recursivefac(int(sys.stdin.readline())))


import sys
input = sys.stdin.readline
#
n = int(input())
global ret
ret = 1


def fac(num):
    global ret
    if num == 0:
        return 1
    if num == 1:
        return ret
    ret *= num
    fac(num-1)

fac(n)
print(ret)