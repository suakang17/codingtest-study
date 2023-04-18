import sys
import math
sys.setrecursionlimit(10**5 + 1)
get_line: iter = lambda: map(int, sys.stdin.readline().rstrip().split())
get_input: int = lambda: int(sys.stdin.readline().strip())

arr = None
N = None
dp_table = None
def set_variable():
    global arr, N, dp_table
    N = get_input()
    arr = []
    for _ in range(N):
        arr.append(list(get_line()))
    dp_table = [[math.inf for _ in range(N + 1)] for _ in range(N + 1)]
        
def solution():
    def dp(s, e):
        global arr, N, dp_table
        if s == e:
            return 0
        if dp_table[s][e] != math.inf:
            return dp_table[s][e]
        else:
            ret = math.inf
            for i in range(s, e):
                left = dp(s, i)
                right = dp(i + 1, e)
                ret = min(ret, left + right + arr[s][0] * arr[i][1] * arr[e][1])
            dp_table[s][e] = ret
            return dp_table[s][e]

    print(dp(0, N - 1))

if __name__ == "__main__":
    set_variable()
    solution() 