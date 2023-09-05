import sys
from collections import deque
input = sys.stdin.readline

n = int(input())
space = [list(map(int, input().split())) for _ in range(n)]

# 아기 상어의 위치 찾기
for i in range(n):
    for j in range(n):
        if space[i][j] == 9:
            x, y = i, j
            space[i][j] = 0

# 아기 상어의 크기와 먹은 물고기 수
size, eat = 2, 0
dx = [-1, 0, 0, 1]  # 상좌우하
dy = [0, -1, 1, 0]

def bfs(x, y):
    q = deque()
    q.append((x, y))
    visited = [[0]*n for _ in range(n)]
    visited[x][y] = 1
    can_eat = []

    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i] 
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < n and visited[nx][ny] == 0:
                # 빈 공간이거나 먹을 수 있는 물고기라면
                if space[nx][ny] == 0 or space[nx][ny] == size:
                    q.append((nx, ny))
                    visited[nx][ny] = visited[x][y] + 1
                # 먹을 수 있는 물고기라면
                elif space[nx][ny] < size:
                    q.append((nx, ny))
                    visited[nx][ny] = visited[x][y] + 1
                    can_eat.append((visited[nx][ny], nx, ny))

    if len(can_eat) == 0:
        return None
    else:
        can_eat.sort()
        return can_eat[0]
    
answer = 0
while True:
    result = bfs(x, y)
    if result == None:
        break
    else:
        distance, x, y = result
        space[x][y] = 0
        answer += distance - 1
        eat += 1
        if eat == size:
            size += 1
            eat = 0

print(answer)