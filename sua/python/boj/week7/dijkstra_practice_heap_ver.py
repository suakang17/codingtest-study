import sys
import heapq
input = sys.stdin.readline
INF = sys.maxsize

v, e = map(int, input().split())
k = int(input())
graph = [[] for _ in range(v+1)]
heap = []
distance = [INF] * (v+1)

for _ in range(e):
    start, end, w = map(int, input().split())
    graph[start].append((end, w))  # (목적지노드, 가중치)


def dijkstra(start):
    heapq.heappush(heap, (start, 0))  # 시작노드, 최단거리 (self == 0) 을 heappush => 방문처리,
    distance[start] = 0

    while heap:
        now, w = heapq.heappop(heap)  # heap에서 최단거리에 해당하는 노드의 인덱스, 가중치 return

        # heappop한 거리가 distance에 저장된 값보다 큰 경우, 이미 방문한 노드이므로 continue 처리
        if distance[now] < w:
            continue

        for i in graph[now]:
            next_distance = w + i[1]

            if next_distance < distance[i[0]]:
                distance[i[0]] = next_distance

                heapq.heappush(heap, i)


dijkstra(k)
for i in range(1, v+1):
    print("INF" if distance[i] == INF else distance[i])