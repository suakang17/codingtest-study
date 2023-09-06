import sys
import heapq
input = sys.stdin.readline
INF = sys.maxsize

N, E = map(int, input().split())
graph = [[] for _ in range(N+1)]

for _ in range(E):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))
    graph[b].append((a, c))

v1, v2 = map(int, input().split())

def dijkstra(start):
    distance = [INF] * (N+1)    # 함수 안에 넣는 이유: 함수가 호출될 때마다 초기화되어야 하기 때문
    distance[start] = 0
    queue = []
    heapq.heappush(queue, (0, start))

    while queue:
        dist, now = heapq.heappop(queue)

        if distance[now] < dist:
            continue
        
        for i in graph[now]:
            cost = dist + i[1]

            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(queue, (cost, i[0]))

    return distance

original = dijkstra(1)
v1_dist = dijkstra(v1)
v2_dist = dijkstra(v2)
result = min(original[v1] + v1_dist[v2] + v2_dist[N], original[v2] + v2_dist[v1] + v1_dist[N])

print(result if result < INF else -1)
