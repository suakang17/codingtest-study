import sys
input = sys.stdin.readline

N, M = map(int, input().split())
INF = int(1e9)
graph = []
dist = [INF] * (N+1)    # dist[i]: 1번 노드에서 i번 노드까지의 최단 거리
for _ in range(M):
    A, B, C = map(int, input().split())
    graph.append((A, B, C))

def bellman_ford(start):
    dist[start] = 0
    for i in range(1, N+1):
        for s, e, t in graph:
            if dist[s] != INF and dist[e] > dist[s] + t:    # dist[s] != INF: s번 노드까지의 최단 거리가 존재한다면
                dist[e] = dist[s] + t   # s번 노드를 거쳐 e번 노드까지의 최단 거리 갱신
                if i == N:  # N번째 라운드에서도 갱신이 일어난다면 음수 사이클이 존재한다
                    return True 
    return False

if bellman_ford(1):
    print(-1)
else:
    for i in range(2, N+1):
        if dist[i] == INF:
            print(-1)
        else:
            print(dist[i])