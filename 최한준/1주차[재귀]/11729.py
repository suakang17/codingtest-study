import sys

N = int(sys.stdin.readline())

cnt = 0


def hanoi(n, st, mid, ed):
    global cnt
    cnt += 1
    if n == 1:
        print(f"{st} {ed}")
    else:
        hanoi(n - 1, st, ed, mid)
        print(f"{st} {ed}")
        hanoi(n - 1, mid, st, ed)


print((1 << N) - 1)
hanoi(N, 1, 2, 3)
