import sys
from collections import deque

get_line: iter = lambda: map(int, sys.stdin.readline().rstrip().split())
get_input: int = lambda: int(sys.stdin.readline())

N, M, V = get_line()
arr = [[] for _ in range(N + 1)]
visited = [False] * (N + 1)
DFS_list = []
BFS_list = []


def DFS(num: int):
    global DFS_list
    DFS_list.append(num)
    visited[num] = True
    for i in arr[num]:
        if not visited[i]:
            visited[i] = True
            DFS(i)


def BFS(st: int):
    global BFS_list
    BFS_list.append(st)
    deq = deque()
    deq.append(st)
    visited[st] = True
    while deq:
        now = deq.popleft()
        for i in arr[now]:
            if not visited[i]:
                visited[i] = True
                deq.append(i)
                BFS_list.append(i)


for _ in range(M):
    st, ed = get_line()
    arr[st].append(ed)
    arr[ed].append(st)
  
for i in arr:
    i.sort()

DFS(V)
visited = [False] * (N + 1)
BFS(V)

print(*DFS_list)
print(*BFS_list)
