import math

nINF = -math.inf


# 벨만 포드 알고리즘
def bf(start):
    dist[start] = 0

    for i in range(n):
        for cur in range(1, n + 1):
            for (next, cost) in graph[cur]:
                nextCost = dist[cur] + cost

                if dist[cur] != nINF and dist[next] < nextCost:
                    dist[next] = nextCost
                    route[next] = cur  # next 노드로 가는 전 node를 담아줌

                    # 사이클일 경우
                    if i == n - 1:
                        dist[next] = math.inf  # 도착 노드의 금품을 무한으로 설정


if __name__ == '__main__':
    # 지점의 개수(n), 골목길 개수(m)
    n, m = map(int, input().split())

    graph = [[] for _ in range(n + 1)]
    dist = [nINF] * (n + 1)  # 시작 지점에서 node까지의 최대 금품
    route = [0] * (n + 1)  # 경로를 담아주기 위한 배열

    for _ in range(m):
        u, v, w = map(int, input().split())
        graph[u].append((v, w))

    bf(1)
    res = [n]  # 최적의 경로를 담아줄 결과 배열

    # n번 노드로 가는데 사이클이 포함되어 있지 않을 경우
    if dist[n] != math.inf:
        node = n

        # n번부터 역으로 res 배열에 담아준다.
        while node != 1:
            node = route[node]
            res.append(node)

        # 뒤집어서 출력
        for i in reversed(res):
            print(i, end=' ')
        print()
    else:  # n번 노드로 가는데 사이클이 포함되어 있을 경우 -1 출력
        print('-1')