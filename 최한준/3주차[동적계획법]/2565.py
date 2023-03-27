import sys

get_line: iter = lambda: map(int, sys.stdin.readline().rstrip().split())
get_input: int = lambda: int(sys.stdin.readline().strip())


arr = None
N = None
cnt = None

def set_variable():
    global arr, N, cnt
    N = get_input()
    arr = []
    cnt = [0] * N
    for _ in range(N):
        idx, n = get_line()
        arr.append((idx, n))
    arr.sort()


def solution():
    global arr, N
    for i in range(N):
        cnt[i] = 1
        for j in range(i):
            if arr[i][1] > arr[j][1]:
                cnt[i] = max(cnt[i], cnt[j] + 1)

    print(N - max(cnt))

if __name__ == "__main__":
    set_variable()
    solution()