import sys
from collections import deque

n, m, r = map(int, sys.stdin.readline().split())
graph = [[] for _ in range(n+1)]
visited = [0] * (n+1)

for _ in range(m):
    u, v = map(int, sys.stdin.readline().split())
    graph[u].append(v)
    graph[v].append(u)

for each in graph:
    each.sort()


def bfs(graph, visited, r):
    # 현재 노드 r 넣기
    queue = deque([r])
    # 현재 노드 r 방문 처리
    cnt = 1
    visited[r] = cnt
    cnt += 1

    while queue:
        r = queue.popleft()
        # r과 연결된 노드들 == i
        for i in graph[r]:
            if visited[i] == 0:
                queue.append(i)
                visited[i] = cnt
                cnt += 1

bfs(graph, visited, r)

for i in visited[1::]:
    print(i)