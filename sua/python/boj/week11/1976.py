import sys

input = sys.stdin.readline
sys.setrecursionlimit(10**6)


def find(a):
    if parents[a] != a:
        parents[a] = find(parents[a])
    return parents[a]


def merge(a, b):
    a = find(a)
    b = find(b)

    if a > b:
        parents[a] = b
    else:
        parents[b] = a


if __name__ == "__main__":
    n = int(input())
    m = int(input())

    graph = [list(map(int, input().split())) for _ in range(n)]
    parents = list(range(n))
    plan = list(map(int, input().split()))

    for i in range(n):
        for j in range(n):
            if graph[i][j] == 1:
                merge(i, j)

    ans = "YES"
    for i in range(1, m):
        if parents[plan[i] - 1] != parents[plan[0] - 1]:
            ans = "NO"
            break

    print(ans)