import sys
from collections import deque

n, m = map(int, sys.stdin.readline().split())
matrix = [sys.stdin.readline().rstrip() for _ in range(n)]  # str
visited = [[0] * m for _ in range(n)]

# 방향 구현 (상하좌우)
dx, dy = [0, 0, -1, 1], [-1, 1, 0, 0]


def bfs(x, y):
    queue = deque()
    queue.append((x, y))
    visited[0][0] = 1

    while queue:
        x, y = queue.popleft()

        # 목적지 도착
        if x == n-1 and y == m-1:
            print(visited[x][y])

        # 상하좌우 이동 가능한 블록 확인
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < n and 0 <= ny < m:
                # 진행 가능
                if matrix[nx][ny] == "1" and visited[nx][ny] == 0:
                    visited[nx][ny] = visited[x][y] + 1  # 도착 순서 저장
                    queue.append((nx, ny))


bfs(0, 0)