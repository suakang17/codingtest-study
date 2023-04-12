import sys
from collections import deque

get_line: iter = lambda: map(int, sys.stdin.readline().rstrip().split())
get_input: int = lambda: int(sys.stdin.readline())

N, M = get_line()
arr = [list(map(int, input())) for _ in range(N)]
visited = [[False] * M for _ in range(N)]

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]


def OOB(y, x, h, w):
    if 0 <= y < h and 0 <= x < w:return True
    else:return False


def BFS(sy=0, sx=0):
    deq = deque()
    deq.append((sy, sx, 1))
    visited[sy][sx] = True
    while deq:
        y, x, dist = deq.popleft()
        if y == N - 1 and x == M - 1: return dist
        for i in range(4):
            nxt_y = y + dy[i]
            nxt_x = x + dx[i]
            if OOB(nxt_y, nxt_x, N, M) and not visited[nxt_y][nxt_x] and arr[nxt_y][nxt_x] == 1:
                visited[nxt_y][nxt_x] = True
                deq.append((nxt_y, nxt_x, dist + 1))

print(BFS())
