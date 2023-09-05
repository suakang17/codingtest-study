from collections import deque

n, m = map(int, input().split())
board = [0] * 101
ladder, snake = dict(), dict()
queue = deque([1])

for _ in range(n):
    a, b = map(int, input().split())
    ladder[a] = b

for _ in range(m):
    a, b = map(int, input().split())
    snake[a] = b

def bfs():
    while queue:
        x = queue.popleft()
        if x == 100:
            return board[x]
        for i in range(1, 7):
            nx = x + i
            if nx > 100:
                continue
            if nx in ladder.keys():
                nx = ladder[nx]
            if nx in snake.keys():
                nx = snake[nx]
            if board[nx] == 0:
                board[nx] = board[x] + 1
                queue.append(nx)
            

print(bfs())