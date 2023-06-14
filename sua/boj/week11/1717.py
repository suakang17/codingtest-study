import sys

input = sys.stdin.readline
sys.setrecursionlimit(10**6)


def find(node):
    if graph[node] == node:  # root
        return node
    graph[node] = find(graph[node])
    return graph[node]


def merge(node1, node2):
    node1 = find(node1)
    node2 = find(node2)

    if node1 == node2:
        return  # 이미 같은 그래프

    if node1 < node2:
        graph[node2] = node1
    else:
        graph[node1] = node2


if __name__ == "__main__":
    n, m = map(int, input().split())
    graph = [0] * (n+1)

    for i in range(n+1):
        graph[i] = i

    for cal in range(m):
        x, a, b = map(int, input().split())

        if x == 0:
            merge(a, b)

        else:
            if find(a) == find(b):
                print("YES")
            else:
                print("NO")