import sys
from collections import deque
sys.setrecursionlimit(10**9 + 1)

get_line: iter = lambda: map(int, sys.stdin.readline().rstrip().split())
get_input: int = lambda: int(sys.stdin.readline().strip())

N, M = None, None
arr = None
que = None
dy = [0, 1, 0, -1]
dx = [1, 0, -1, 0]
def set_variable():
    global N, M, arr, que
    que = []
    M, N = get_line()
    arr = [list(get_line()) for _ in range(N)]
    for i in range(N):
        for j in range(M):
            if arr[i][j] == 1:  que.append((i, j))

def solution():
    def BFS():
        def possible(y, x):
            if 0 <= y < N and 0 <= x < M and arr[y][x] == 0: return True
            else: return False
        global N, M, arr,que
        que = deque(que)
        cnt = 0
        while que:
            flag = False
            for _ in range(len(que)):
                y, x = que.popleft()
                for i in range(4):
                    nxt_y = y + dy[i]
                    nxt_x = x + dx[i]
                    if possible(nxt_y, nxt_x):
                        if flag == False: flag = True
                        arr[nxt_y][nxt_x] = 1
                        que.append((nxt_y, nxt_x))
            if flag : cnt += 1
        return cnt
    ret = BFS()
    for ar in arr:
        for a in ar:
            if a == 0:
                print(-1)
                sys.exit(0)
    print(ret)
                    
        
        


if __name__ == "__main__":
    set_variable()
    solution()