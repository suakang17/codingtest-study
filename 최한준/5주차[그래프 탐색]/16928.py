import sys
import math
from collections import deque

get_line: iter = lambda: map(int, sys.stdin.readline().rstrip().split())
get_input: int = lambda: int(sys.stdin.readline().strip())


arr = None
N, M = None, None

def set_variable():
    global arr, N, M
    N, M = get_line()
    arr = [-1] * 200
    for _ in range(N + M):
        x, y = get_line()
        arr[x] = y


def solution():
    def bfs():            
        global arr, N, M
        visited = [False] * 200
        queue = deque([(1, 0)])
        while queue:
            pos, cnt = queue.popleft()
            if pos == 100: return cnt
            for i in range(1, 7):
                if visited[pos + i] == False and arr[pos + i] != -1:
                    nxt = pos + i
                    while arr[nxt] != -1 and visited[nxt] == False: 
                        visited[nxt] = True
                        nxt = arr[nxt]
                    if visited[nxt] == False:
                        visited[nxt] = True
                        queue.append((nxt, cnt + 1))
                elif visited[pos + i] == False:
                    visited[pos + i] = True
                    queue.append((pos + i, cnt+1))
            
    print(bfs())
if __name__ == "__main__":
    set_variable()
    solution()