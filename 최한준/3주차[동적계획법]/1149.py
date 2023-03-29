import sys
from copy import deepcopy

get_line: iter = lambda: map(int, sys.stdin.readline().rstrip().split())
get_input: int = lambda: int(sys.stdin.readline().strip())

arr = None
N = None
dp = None

def set_variable():
    global arr, N, dp
    N = get_input()
    arr = [list(get_line()) for i in range(N)]
    dp = [[0] * 3 for i in range(N)]
    

def solution():
    global arr, N, dp
    dp[0] = deepcopy(arr[0])
    for i in range(1, N):
        dp[i][0] = min(dp[i-1][1], dp[i-1][2]) + arr[i][0]
        dp[i][1] = min(dp[i-1][0], dp[i-1][2]) + arr[i][1]
        dp[i][2] = min(dp[i-1][0], dp[i-1][1]) + arr[i][2]
    
    print(min(dp[N-1]))
        


if __name__ == "__main__":
    set_variable()
    solution()