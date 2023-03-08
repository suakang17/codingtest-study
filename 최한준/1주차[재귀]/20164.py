import sys
import math

get_line: iter = lambda: map(int, sys.stdin.readline().rstrip().split())
get_input: int = lambda: int(sys.stdin.readline().strip())

N = None
def set_variable():
    global N 
    N = get_input()


def solution():
    def rec(num):
        cnt = 0
        for i in num:
            cnt += 1 if int(i) % 2 else 0
        if len(num) == 1:
            return cnt, cnt
        elif len(num) == 2:
            min_cnt, max_cnt  = rec(str(sum(map(int, num))))
            return cnt +  min_cnt, cnt + max_cnt
        else:
            min_cnt = math.inf
            max_cnt = 0
            for i in range(1, len(num) - 1):
                for j in range(i + 1, len(num)):
                    now_min, now_max = rec(str(sum(map(int, [num[:i], num[i:j], num[j:]]))))
                    min_cnt = min(min_cnt, now_min)
                    max_cnt = max(max_cnt, now_max)
            return cnt + min_cnt, cnt + max_cnt
    
    print(*rec(str(N)))

if __name__ == "__main__":
    set_variable()
    solution()