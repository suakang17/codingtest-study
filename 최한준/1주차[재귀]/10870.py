import sys

N = int(sys.stdin.readline())

arr = [0] * (N+1)

def fib(i):
    if i == 0 or i == 1:
        return i
    else:
        return fib(i-2) + fib(i-1)

print(fib(N))