import sys
input = sys.stdin.readline
INF = sys.maxsize

def bellman_ford(start):
    dist = [INF] * (N+1)
    dist[start] = 0

    for i in range(N):
        for s, e, t in graph:
            if dist[e] > dist[s] + t:
                dist[e] = dist[s] + t
                if i == N-1:
                    return True
    return False

TC = int(input())
for _ in range(TC):
    N, M, W = map(int, input().split())
    graph = []
    for _ in range(M):
        S, E, T = map(int, input().split())
        graph.append((S, E, T))
        graph.append((E, S, T))
    for _ in range(W):
        S, E, T = map(int, input().split())
        graph.append((S, E, -T))

    if bellman_ford(1):
        print('YES')
    else:
        print('NO')
