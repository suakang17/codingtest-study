import sys

input = sys.stdin.readline


def find(x):
    if x == parents[x]:
        return x
    else:
        y = find(parents[x])
        parents[x] = y
        return y


def merge(x, y, idx):
    global endgame
    x = find(x)
    y = find(y)
    if x != y:
        parents[max(x,y)] = min(x,y)
    elif endgame == 0:
        endgame = idx


if __name__ == "__main__":
    n, m = map(int, input().split())
    parents = [i for i in range(n)]
    endgame = 0

    for i in range(m):
        a, b = map(int, input().split())
        merge(a, b, i+1)

    print(endgame)