import sys

def pibo(n):
    l = [0, 1]
    for i in range(2, n+1):
        nxt = l[i-1] + l[i-2]
        l.append(nxt)
    return l[n]

print(pibo(int(sys.stdin.readline())))