import sys

input = sys.stdin.readline


def find(x):
    if parent[x] == x:
        return x
    parent[x] = find(parent[x])
    return parent[x]


def merge(x, y):
    x = find(x)
    y = find(y)

    if x == y:  # 이미 친구
        return

    parent[y] = x
    cnt[x] += cnt[y]


if __name__ == "__main__":
    t = int(input())
    for _ in range(t):
        f = int(input())
        parent, cnt = {}, {}

        for _ in range(f):
            a, b = input().split()
            if a not in parent:
                parent[a] = a
                cnt[a] = 1

            if b not in parent:
                parent[b] = b
                cnt[b] = 1

            merge(a, b)

            print(cnt[find(a)])