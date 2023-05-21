import sys
input = sys.stdin.readline

n, m, k = map(int, input().split())
fireballs = [list(map(int, input().split())) for _ in range(m)]
graph = [[[] for _ in range(n)] for _ in range(n)]
dx = [-1, -1, 0, 1, 1, 1, 0, -1]
dy = [0, 1, 1, 1, 0, -1, -1, -1]
for i in range(m):
    r, c, m, s, d = fireballs[i]
    graph[r-1][c-1].append((m, s, d))

def move():
    global graph, dx, dy
    new_graph = [[[] for _ in range(n)] for _ in range(n)]
    for i in range(n):
        for j in range(n):
            for m, s, d in graph[i][j]:
                nx = (i + dx[d] * s) % n
                ny = (j + dy[d] * s) % n
                new_graph[nx][ny].append((m, s, d))
    graph = new_graph

def merge():
    global graph
    for i in range(n):
        for j in range(n):
            if len(graph[i][j]) >= 2:
                m_sum, s_sum, d_sum = 0, 0, []
                for m, s, d in graph[i][j]:
                    m_sum += m
                    s_sum += s
                    d_sum.append(d % 2)
                graph[i][j] = []
                if m_sum // 5 == 0: continue
                if sum(d_sum) == 0 or sum(d_sum) == len(d_sum):
                    for k in range(4):
                        graph[i][j].append((m_sum // 5, s_sum // len(d_sum), k * 2))
                else:
                    for k in range(4):
                        graph[i][j].append((m_sum // 5, s_sum // len(d_sum), k * 2 + 1))

for _ in range(k):
    move()
    merge()

answer = 0
for i in range(n):
    for j in range(n):
        for m, s, d in graph[i][j]:
            answer += m
print(answer)