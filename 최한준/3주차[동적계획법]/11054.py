import sys

get_line: iter = lambda: map(int, sys.stdin.readline().rstrip().split())
get_input: int = lambda: int(sys.stdin.readline().strip())

N = None
arr = None
up_cnt = None
down_cnt = None

def set_variable():
    global N, arr, up_cnt, down_cnt
    N = get_input()
    arr = list(get_line())
    up_cnt = [0] * N
    down_cnt = [0] * N


def solution():
    global N, arr, up_cnt, down_cnt
    for i in range(N):
        up_cnt[i] = 1
        down_cnt[N-1-i] = 1
        for j in range(i):
            if arr[i] > arr[j]:
                up_cnt[i] = max(up_cnt[i], up_cnt[j] + 1)
            if arr[N - 1 - i] > arr[N - 1 - j]:
                down_cnt[N - 1 - i] = max(down_cnt[N - 1 - i] , down_cnt[N - 1 - j] + 1)
    
    answer = 0
    for i in range(N):
        answer = max(answer, up_cnt[i] + down_cnt[i])
    
    print(answer - 1)

if __name__ == "__main__":
    set_variable()
    solution()