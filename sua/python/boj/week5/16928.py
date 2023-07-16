# 최소 횟수 (최단경로 cnt) -> bfs
# 방향 간선
import sys
from collections import deque

board = [0] * 101  # 1~100
visited = [0] * 101  # 각 칸 방문 횟수

# 키 -> 값으로 이동 위한 딕셔너리
ladder = dict()
snake = dict()
n, m = map(int, sys.stdin.readline().split())
for _ in range(n):
    u, v = map(int, sys.stdin.readline().split())
    ladder[u] = v
for _ in range(m):
    u, v = map(int, sys.stdin.readline().split())
    snake[u] = v


def bfs(x):
    visited[x] = 1
    queue = deque([x])
    while queue:
        x = queue.popleft()

        # 100번 도착 경우
        if x == 100:
            print(board[x])
            exit(0)

        for dice in range(1, 7):
            nx = x + dice
            if nx <= 100 and visited[nx] == 0:
                # 사다리 만난 경우
                if nx in ladder.keys():
                    nx = ladder[nx]
                # 뱀 만난 경우
                if nx in snake.keys():
                    nx = snake[nx]
                if visited[nx] == 0:
                    board[nx] = board[x] + 1
                    visited[nx] = visited[x] + 1
                    queue.append(nx)

bfs(1)