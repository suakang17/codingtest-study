import sys
import math
get_line: iter = lambda: map(int, sys.stdin.readline().rstrip().split())
get_input: int = lambda: int(sys.stdin.readline().strip())

min_value = None
max_value = None
N = None
arr = None
op_cnt = None
op_arr = None
cnt = 0

def set_variable():
    global min_value, max_value, N, arr, op_cnt, op_arr
    N = get_input()
    arr = list(get_line())
    op_arr = []
    op_cnt = list(get_line())
    min_value = math.inf
    max_value = -math.inf # 알게된 것.

def solution():
    global min_value, max_value, N, arr, op_cnt, op_arr,cnt
    def cal():
        ret = arr[0]
        for num, op in zip(arr[1:], op_arr):
            if op   == 0 : ret += num
            elif op == 1 : ret -= num
            elif op == 2 : ret *= num
            elif op == 3 : ret = int(ret / num)
        return ret
    
    def rec(depth):
        if depth == len(arr) - 1:
            max_value = max(max_value, cal())
            min_value = min(min_value, cal())
            return
        else:
            for idx in range(4):
                if op_cnt[idx] > 0:
                    op_cnt[idx] -= 1
                    op_arr.append(idx)
                    rec(depth + 1)
                    op_arr.pop()
                    op_cnt[idx] += 1
                    
    
    rec(0)
    print(max_value)
    print(min_value)


if __name__ == "__main__":
    set_variable()
    solution()