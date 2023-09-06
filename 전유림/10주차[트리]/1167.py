import sys
from collections import deque
input = sys.stdin.readline

v = int(input())
node = [[] for _ in range(v+1)]

for _ in range(v):
    a = list(map(int, input().split()))
    for i in range(1, len(a)-2, 2):
        node[a[0]].append((a[i], a[i+1]))

def bfs(start):
    visited = [-1] * (v+1)
    visited[start] = 0
    q = deque()
    q.append(start)
    max_node = [0, 0]
    while q:
        now = q.popleft()
        for next, dist in node[now]:
            if visited[next] == -1:
                visited[next] = visited[now] + dist
                q.append(next)
                if max_node[0] < visited[next]:
                    max_node = visited[next], next
    return max_node

dis, node = bfs(1)
dis, node = bfs(node)
print(dis)