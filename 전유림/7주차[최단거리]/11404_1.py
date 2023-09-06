import sys
import heapq
input = sys.stdin.readline
INF = sys.maxsize

n = int(input())
m = int(input())
graph = [[INF] * (n+1) for _ in range (n+1)]
for _ in range (m):
    a, b, c = map(int, input().split())
    graph[a][b] = min(graph[a][b], c)

heap = []
def dijkstra(start):
    heapq.heappush(heap, (0, start))
    distance = [INF] * (n+1)
    distance[start] = 0
    while heap:
        dist, now = heapq.heappop(heap) # dist: 현재까지의 거리, now: 현재 노드
        if distance[now] < dist:    # 이미 최단거리를 구한 노드라면
            continue
        for i in range (1, n+1):    # 현재 노드와 연결된 노드들을 확인
            cost = dist + graph[now][i] # 현재 노드를 거쳐서 가는 비용
            if cost < distance[i]:  # 현재 노드를 거쳐서 가는 비용이 더 작다면
                distance[i] = cost  # 최단거리 갱신
                heapq.heappush(heap, (cost, i)) # 힙에 삽입
    return distance

for i in range (1, n+1):
    distance = dijkstra(i)
    for j in range (1, n+1):
        if distance[j] == INF:
            print(0, end = ' ')
        else:
            print(distance[j], end = ' ')
    print()