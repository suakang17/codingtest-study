import sys
from collections import deque
sys.setrecursionlimit(10**9)
get_line: iter = lambda: map(int, sys.stdin.readline().rstrip().split())
get_input: int = lambda: int(sys.stdin.readline().strip())

N, M = None, None
arr = None
dp_table = None
dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]
def set_variable():
    global N, M, arr, dp_table
    N, M = get_line()
    arr = [list(get_line()) for _ in range(N)]
    dp_table = [[-1] * M for _ in range(N)]

def solution():
    global N, M, arr, dp_table
    def DFS(y, x):
        def possible(y, x):
            if 0 <= y < N and 0 <= x < M: return True
            else: return False
        if dp_table[y][x] != -1: 
            return dp_table[y][x]
        if y == 0 and x == 0:
            return 1
        else:
            dp_table[y][x] = 0
            for i in range(4):
                nxt_y, nxt_x = y + dy[i], x + dx[i]
                if possible(nxt_y, nxt_x) and arr[y][x] < arr[nxt_y][nxt_x]:
                    dp_table[y][x] += DFS(nxt_y, nxt_x)
            
            return dp_table[y][x]
    
    print(DFS(N-1, M-1))

if __name__ == "__main__":
    set_variable()
    solution()