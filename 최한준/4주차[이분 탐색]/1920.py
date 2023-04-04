import sys

get_line: iter = lambda: map(int, sys.stdin.readline().rstrip().split())
get_input: int = lambda: int(sys.stdin.readline().strip())

N = None
arr = None
M = None
query = None

def set_variable():
    global N, arr, M, query
    N = get_input()
    arr = sorted(list(get_line()))
    M = get_input()
    query = list(get_line())


def solution():
    def f(num):
        global N, arr, M, query
        L, R = -1, N
        while L + 1 < R :
            mid = (L + R) // 2
            if arr[mid] >= num : R = mid
            else : L = mid
        if (R != N and arr[R] == num) or (N == 1 and arr[0] == num ): return 1
        else : return 0
    
    for q in query:
        print(f(q))


if __name__ == "__main__":
    set_variable()
    solution()