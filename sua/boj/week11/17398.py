import sys

input = sys.stdin.readline


def find(node):
    if parents[node] != node:
        parents[node] = find(parents[node])
    return parents[node]


def merge(a, b):
    root1 = find(a)
    root2 = find(b)

    parents[root2] = root1

    if root1 != root2:
        weight[root1] += weight[root2]


if __name__ == "__main__":
    n, m, q = map(int, input().split())
    parents = [i for i in range(n+1)]
    graph = [list(map(int, input().split())) for _ in range(m)]
    remove_list = [int(input()) for _ in range(q)]
    weight = [1 for _ in range(n+1)]


    cnt = 0
    remove_sort_list = list(remove_list)
    remove_sort_list.sort()
    for i in range(m):
        if cnt < q:
            if remove_sort_list[cnt] == i + 1:
                cnt += 1
                continue
        merge(graph[i][0], graph[i][1])

    # not in 으로 연결 끊기 처리했으나 O(n)이므로 시간 초과 -> 위처럼 sort(nlogn)해놓고 처리
    # cnt = 1
    # for connection in graph:
    #     if cnt not in remove_list:
    #         x, y = connection[0], connection[1]
    #         merge(x, y)
    #     cnt += 1

    ans = 0

    for _ in range(q):
        now = remove_list.pop()
        n1, n2 = graph[now - 1]
        root1 = find(n1)
        root2 = find(n2)
        if root1 != root2:
            ans += weight[root1] * weight[root2]
            parents[root2] = root1
            weight[root1] += weight[root2]
    print(ans)
