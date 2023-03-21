import sys
from pprint import pprint
# import numpy as np

get_line: iter = lambda: map(int, sys.stdin.readline().rstrip().split())
get_input: int = lambda: int(sys.stdin.readline().strip())

arr = None
empty_arr = None
col = None
row = None
grd = None
cnt = None

def set_variable():
    global arr, empty_arr, col, row, grd, cnt
    cnt = 0
    empty_arr = []
    arr = [list(get_line()) for _ in range(9)]
    col = [[True for _ in range(10)] for _ in range(9)] # col[i][j] = i열의 j 숫자가 들어올 수 있나?
    row = [[True for _ in range(10)] for _ in range(9)]
    grd = [[True for _ in range(10)] for _ in range(9)]
    for i in range(9):
        for j in range(9):
            if arr[i][j] == 0:
                empty_arr.append((i, j))
            else:                
                col[j][arr[i][j]] = False
                row[i][arr[i][j]] = False
                grd[i//3 * 3 + j // 3][arr[i][j]] = False

def solution():
    def b_track(depth):
        global arr, empty_arr, col, row, grd, cnt
        if depth == len(empty_arr):
            for line in arr:
                print(*line)
            sys.exit(0)
        else:
            now_y, now_x = empty_arr[depth]
            for i in range(1, 10):
                if col[now_x][i] == True and row[now_y][i] == True and grd[now_y // 3 * 3 + now_x // 3][i] == True:
                    col[now_x][i] = row[now_y][i] = grd[now_y // 3 * 3 + now_x // 3][i] = False
                    print()
                    arr[now_y][now_x] = i
                    b_track(depth + 1)
                    arr[now_y][now_x] = 0
                    col[now_x][i] = row[now_y][i] = grd[now_y // 3 * 3 + now_x // 3][i] = True
    
    b_track(0)


if __name__ == "__main__":
    set_variable()
    solution()