# import sys
#
#
# def recursion(s, l, r):
#     global cnt
#     cnt += 1
#     if l >= r: return 1
#     elif s[l] != s[r]: return 0
#     return recursion(s, l+1, r-1)
#
#
# def isPalindrome(s):
#     return recursion(s, 0, len(s)-1)
#
#
# t = int(sys.stdin.readline())
# for _ in range(t):
#     cnt = 0
#     print(isPalindrome(sys.stdin.readline().rstrip()), cnt)

import sys
input = sys.stdin.readline

