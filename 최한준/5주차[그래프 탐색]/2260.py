import sys
from collections import deque

get_line: iter = lambda: map(int, sys.stdin.readline().rstrip().split())
get_input: int = lambda: int(sys.stdin.readline().strip())

N, M = None, None
arr = None
visited = None

def set_variable():
    global N, M, visited, arr
    N, M = get_line()
    arr = [list(sys.stdin.readline().strip()) for _ in range(N)]
    visited = [[[False] * 2 for _ in range(M)] for _ in range(N)] 
        

def solution():
    def bfs():
        global N, M, visited, arr
        def possible(y, x, break_cnt):
            if 0 <= y < N and 0 <= x < M and break_cnt - int(arr[y][x]) >= 0 and visited[y][x][break_cnt] == False: return True
            else: return False
        dy,dx = [0, 1, 0, -1], [1, 0, -1, 0]
        queue = deque([(0, 0, 1)])
        cnt = 1
        while queue:
            for _ in range(len(queue)):
                y, x, break_cnt = queue.popleft()
                if y == N-1 and x == M-1:
                    return cnt
                for i in range(4):
                    ny, nx = y + dy[i], x + dx[i]
                    if possible(ny, nx, break_cnt):
                        if arr[ny][nx] == "1": 
                            visited[ny][nx][1] = True
                            visited[ny][nx][0] = True
                            queue.append((ny, nx, 0))
                        else: 
                            visited[ny][nx][break_cnt] = True
                            queue.append((ny, nx, break_cnt))
            cnt += 1
        return -1
    
    print(bfs())
        

if __name__ == "__main__":
    set_variable()
    solution()