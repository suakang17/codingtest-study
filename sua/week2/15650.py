import sys
n, m = map(int, sys.stdin.readline().split())
ret = []

def ascdfs():
    if len(ret) == m:
        for i in range(1, m):
            if ret[i] < ret[i-1]:
                return
        print(' '.join(map(str, ret)))
        return

    for i in range(1, n+1):
        if i not in ret:
            ret.append(i)
            ascdfs()
            ret.pop()


ascdfs()