# 미로문제와 유사 && 최소 일수 -> bfs
# 미로는 (0,0) 출발점 고정으로 시작이지만,
# 이 문제는 어느 토마토가 시작하느냐에 따라 최소일수가 달라지므로 여러개의 시작점 가짐
# 따라서 익어있는 토마토의 좌표들을 모두 큐에 넣어두어야함
import sys
from collections import deque

m, n = map(int, sys.stdin.readline().split())
box = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]  # str
# 상하좌우
dx, dy = [0, 0, -1, 1], [-1, 1, 0, 0]
queue = deque()

# 익은 토마토 좌표 큐에 넣기
for i in range(n):
    for j in range(m):
        if box[i][j] == 1:
            queue.append((i, j))


def bfs():
    while queue:
        x, y = queue.popleft()

        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if 0 <= nx < n and 0 <= ny < m and box[nx][ny] == '0':
                box[nx][ny] = box[x][y] + 1
                queue.append((nx, ny))


bfs()
res = 0
for row in box:
    for tomato in row:
        if tomato == '0':
            print(-1)
            exit(0)
    res = max(res, max(row))

print(res - 1)  # 익어있는 토마토는 1로 표시되었는데 여기서부터 cnt 시작했으므로