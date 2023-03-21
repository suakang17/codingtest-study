import sys
import math
from itertools import *

get_line: iter = lambda: map(int, sys.stdin.readline().rstrip().split())
get_input: int = lambda: int(sys.stdin.readline().strip())

N, M = None, None
arr = None
c_list = None
h_list = None

def set_variable():
    global N, M, c_list, h_list
    N, M = get_line()
    arr = [list(get_line()) for _ in range(N)]
    c_list = []
    h_list = []
    for i in range(N):
        for j in range(N):
            if arr[i][j] == 1 : h_list.append((i, j))
            if arr[i][j] == 2 : c_list.append((i, j))

def solution():
    def cal(c_comb):
        global N, M, c_list, h_list
        ret = 0
        for h_y, h_x in h_list:
            min_value = math.inf
            for y, x in c_comb:
                min_value = min(min_value, abs(y - h_y) + abs(x - h_x))
            ret += min_value
        return ret

    print(min([cal(c_comb)for c_comb in combinations(c_list, M)]))


if __name__ == "__main__":
    set_variable()
    solution()