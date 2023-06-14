# import sys
#
# def pibo(n):
#     l = [0, 1]
#     for i in range(2, n+1):
#         nxt = l[i-1] + l[i-2]
#         l.append(nxt)
#     return l[n]
#
# print(pibo(int(sys.stdin.readline())))
#
# def recursivpibo(n):
#     if n <= 1:
#         return n
#     return recursivpibo(n-1) + recursivpibo(n-2)
#
# print(recursivpibo(int(sys.stdin.readline())))

import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**7)


n = int(input())

def sol(num):
    global ret

    if num <= 1:
        return num
    return sol(num-1) + sol(num-2)

print(sol(n))