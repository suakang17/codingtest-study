import sys
import heapq
input = sys.stdin.readline

V, E = map(int, input().split())
K = int(input())

INF = sys.maxsize
graph = [[] for _ in range(V+1)]    # 각 노드에 연결되어 있는 노드에 대한 정보를 담는 리스트
distance = [INF] * (V+1)        # 최단 거리 테이블을 모두 무한으로 초기화

def dijkstra(start):
    distance[start] = 0
    queue = []
    heapq.heappush(queue, (0, start))

    while queue:
        dist, now = heapq.heappop(queue)

        if distance[now] < dist:
            continue

        for i in graph[now]:
            cost = dist + i[1]  # 현재 노드를 거쳐서 다른 노드로 이동하는 거리

            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(queue, (cost, i[0]))

for _ in range(E):
    u, v, w = map(int, input().split())
    graph[u].append((v, w))

dijkstra(K)

for i in range(1, V+1):
    if distance[i] == INF:
        print("INF")
    else:
        print(distance[i])