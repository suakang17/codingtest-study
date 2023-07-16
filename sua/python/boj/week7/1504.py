import sys
import heapq
input = sys.stdin.readline
INF = sys.maxsize

n, e = map(int, input().split())
graph = [[] for _ in range(n+1)]  # 양방향 graph


for _ in range(e):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))  # (목적지 노드, 거리)
    graph[b].append((a, c))

v1, v2 = map(int, input().split())  # 반드시 지나야 하는 노드

# 경우의 수는 딱 두가지 : 각각의 화살표 최솟값의 합 min(# 1, # 2)
# 1. 1 -> must1 -> must 2 -> n
# 2. 1 -> must2 -> must 1 -> n


def dijkstra(start, end):
    heap = []
    distance = [INF] * (n + 1)

    distance[start] = 0
    heapq.heappush(heap, (0, start))  # (노드, 가중치) -> heapq는 튜플 첫 요소 기준 정렬이므로 (가중치, 노드)여야함

    while heap:
        d, now = heapq.heappop(heap)

        if d > distance[now]:
            continue

        for i in graph[now]:  # i[0]: 목적지 노드, i[1]: 가중치
            next_distance = d + i[1]
            if distance[i[0]] > next_distance:
                distance[i[0]] = next_distance
                heapq.heappush(heap, (distance[i[0]], i[0]))

    return distance[end]


case1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, n)
case2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, n)

print(-1) if case1 >= INF and case2 >= INF else print(min(case1, case2))
