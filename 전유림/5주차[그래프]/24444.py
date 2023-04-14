from collections import deque
import sys
input = sys.stdin.readline

n, m, r = map(int, input().split())
graph = [[] for _ in range(n+1)]
visited = [0]*(n+1)
order = 1

for _ in range(m):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)

for i in range(n+1):
        graph[i].sort()

def bfs(r):
    global order
    queue = deque([r])
    visited[r] = order
    while queue:
        u = queue.popleft()
        for i in graph[u]:
            if visited[i]: continue
            order += 1
            visited[i] = order
            queue.append(i)

bfs(r)
print(*visited[1:], sep="\n")
