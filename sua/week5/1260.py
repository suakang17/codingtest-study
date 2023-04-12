import sys
from collections import deque

n, m, v = map(int, sys.stdin.readline().split())
graph = [[] for _ in range(n + 1)]
for _ in range(m):
    n1, n2 = map(int, sys.stdin.readline().split())
    graph[n1].append(n2)
    graph[n2].append(n1)

for each in graph:
    each.sort()

visited = [0] * (n + 1)


def dfs(graph, v, visited):
    if visited[v] == 0:
        print(v, end=" ")
        visited[v] = 1

        for i in graph[v]:
            if visited[i] == 0:
                visited[v] = 1
                dfs(graph, i, visited)


dfs(graph, v, visited)
print()  # 개행

visited = [0] * (n + 1)

def bfs(graph, v, visited):
    if visited[v] == 0:
        queue = deque([v])
        print(v, end=" ")
        visited[v] = 1
        while queue:
            v = queue.popleft()  # 여기서 popleft하는데 while문 안끝남?? queue비는거 아닌지?
            for i in graph[v]:
                if visited[i] == 0:
                    queue.append(i)
                    print(i, end=" ")
                    visited[i] = 1

bfs(graph, v, visited)


# 입력받은 노드의 개수만큼 이차원 리스트로 False로 초기화한다음 만약 연결되어 있다면 True로 바꿔주는 풀이
# (이차원 리스트의 인덱스:각 노드, 해당인덱스의 값들: 노드들과 연결 여부)
from collections import deque

N, M, V = map(int, input().split())

graph = [[False] * (N + 1) for _ in range(N + 1)]

for _ in range(M):
    a, b = map(int, input().split())
    graph[a][b] = True
    graph[b][a] = True

visited1 = [False] * (N + 1)  # dfs의 방문기록
visited2 = [False] * (N + 1)  # bfs의 방문기록


def bfs(V):
    q = deque([V])  # pop메서드의 시간복잡도가 낮은 덱 내장 메서드를 이용한다
    visited2[V] = True  # 해당 V 값을 방문처리
    while q:  # q가 빌때까지 돈다.
        V = q.popleft()  # 큐에 있는 첫번째 값 꺼낸다.
        print(V, end=" ")  # 해당 값 출력
        for i in range(1, N + 1):  # 1부터 N까지 돈다
            if not visited2[i] and graph[V][i]:  # 만약 해당 i값을 방문하지 않았고 V와 연결이 되어 있다면
                q.append(i)  # 그 i 값을 추가
                visited2[i] = True  # i 값을 방문처리


def dfs(V):
    visited1[V] = True  # 해당 V값 방문처리
    print(V, end=" ")
    for i in range(1, N + 1):
        if not visited1[i] and graph[V][i]:  # 만약 i값을 방문하지 않았고 V와 연결이 되어 있다면
            dfs(i)  # 해당 i 값으로 dfs를 돈다.(더 깊이 탐색)


dfs(V)
print()
bfs(V)