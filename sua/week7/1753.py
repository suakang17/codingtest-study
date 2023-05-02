import sys
import heapq

input = sys.stdin.readline
INF = sys.maxsize

v, e = map(int, input().split())
k = int(input())

graph = [[] for _ in range(v+1)]
dp = [INF] * (v+1)
heap = []

for _ in range(e):
    u, v, w = map(int, input().split())
    # (가중치, 목적지)
    graph[u].append((w, v))


def Dijkstra(start):
    dp[start] = 0
    heapq.heappush(heap, (0, start))

    while heap:
        weight, now = heapq.heappop(heap)

        if dp[now] < weight:
            continue

        for w, next_node in graph[now]:
            next_weight = w + weight

            if next_weight < dp[next_node]:
                dp[next_node] = next_weight
                heapq.heappush(heap, (next_weight, next_node))


Dijkstra(k)
for i in dp[1:]:
    print("INF" if i == INF else i)