import sys
input = sys.stdin.readline
INF = sys.maxsize

n, m = map(int, input().split())
graph = [[] for _ in range(n+1)]
for _ in range(m):
    u, v, w = map(int, input().split())
    graph[u].append((v, w))

def bellman_ford(start):
    dist = [-INF] * (n+1)   # 거리 저장
    prev = [-1] * (n+1)    # 이전 노드 저장
    dist[start] = 0    # 시작점은 0으로 초기화
    for i in range(n): 
        for u in range(1, n+1): # 모든 노드에 대해
            for v, w in graph[u]:   # 모든 간선에 대해
                if dist[v] < dist[u] + w:   # 최댓값 갱신
                    dist[v] = dist[u] + w 
                    prev[v] = u 
                    if i == n-1:    # n-1번째에도 갱신이 일어난다면 음수 사이클 존재
                        dist[v] = INF
    if dist[n] == INF:  # 음수 사이클 존재
        print(-1)
        return
    path = []   # 경로 저장
    cur = n     # 현재 노드
    while cur != -1:    # 시작점에 도달할 때까지
        path.append(cur)    # 경로에 추가
        cur = prev[cur]    # 이전 노드로 이동
    print(*path[::-1])  # 역순으로 출력

bellman_ford(1)
