import sys
sys.setrecursionlimit(10 ** 6)  # 재귀 허용 깊이를 수동으로 늘려주는 코드

n, m, r = map(int, sys.stdin.readline().split())
graph = [[] for _ in range(n+1)]  # 1부터 인덱싱 하기 위해
visited = [0] * (n+1)
cnt = 1

for _ in range(m):
    u, v = map(int, sys.stdin.readline().split())
    graph[u].append(v)
    graph[v].append(u)

for each in graph:  # 오름차순 정렬
    each.sort()
def dfs(graph, v, visited):
    global cnt
    visited[v] = cnt
    for i in graph[v]:
        if visited[i] == 0:
            cnt += 1
            dfs(graph, i, visited)

dfs(graph, r, visited)

for i in range(n+1):
    if i != 0:
        print(visited[i])