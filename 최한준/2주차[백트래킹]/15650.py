import sys
from collections import deque

get_line: iter = lambda: map(int, sys.stdin.readline().rstrip().split())
get_input: int = lambda: int(sys.stdin.readline().strip())

N, M = None, None

def set_variable():
    global N, M
    N, M = get_line()

def solution():
    global N, M
    visited = [False for _ in range(N)] 
    deq = deque()
    def recursive(level, now_list, last_num):
        if level == M:
            print(*now_list)
            return
        else:
            for idx, i in enumerate(range(last_num, N)):
                idx += last_num
                if visited[i] == False:
                    visited[idx] = True
                    now_list.append(idx+1)
                    recursive(level + 1, now_list, idx + 1)
                    now_list.pop()
                    visited[idx] = False

    recursive(0, deq, 0)


if __name__ == "__main__":
    set_variable()
    solution()