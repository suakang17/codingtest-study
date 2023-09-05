from collections import deque
import sys
sys.setrecursionlimit(10**9)
input = sys.stdin.readline

def dfs(r):
    visited[r] = True
    print(r, end=" ")
    for i in graph[r]:
        if not visited[i]:
            dfs(i)

def bfs(r):
    queue = deque([r])
    visited[r] = True
    while queue:
        u = queue.popleft()
        print(u, end=" ")
        for i in graph[u]:
            if not visited[i]:
                visited[i] = True
                queue.append(i)


n, m, r = map(int, input().split())
graph = [[] for _ in range(n+1)]

for _ in range(m):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)

for i in range(n+1):
        graph[i].sort()
       
visited = [0]*(n+1)
dfs(r)
print()

visited = [0]*(n+1)
bfs(r)
