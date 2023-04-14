from collections import deque
import sys
sys.setrecursionlimit(10**9)
input = sys.stdin.readline

n, m, r = map(int, input().split())
graph = [[] for _ in range(n+1)]    # 각 노드가 연결된 정보?
visited = [0]*(n+1)
order = 1

for _ in range(m):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)

def dfs(r):   # 정점, 간선, 시작
    global order
    visited[r] = order
    graph[r].sort()
    for i in graph[r]:
        if visited[i]==0:
            order += 1
            dfs(i)


dfs(r)

for i in visited[1:]:
    print(i)
