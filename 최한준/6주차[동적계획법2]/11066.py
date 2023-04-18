import sys
import math
sys.setrecursionlimit(10**9 + 1)
get_line: iter = lambda: map(int, sys.stdin.readline().rstrip().split())
get_input: int = lambda: int(sys.stdin.readline().strip())

dp_table = None
arr = None
pre_fix = None
K = None
def set_variable():
    global K, arr, dp_table, pre_fix
    K = get_input()
    arr = [0] + list(get_line())
    pre_fix = [0] + [0 for _ in range(K)]
    for i in range(1, K + 1):
        pre_fix[i] = pre_fix[i-1] + arr[i]
    dp_table = [[math.inf for _ in range(K + 1)] for _ in range(K + 1)]
    

def solution():
    def dp(s, e):
        global K, arr, dp_table, pre_fix
        if s == e:
            dp_table[s][e] = 0
            return dp_table[s][e]
        if dp_table[s][e] != math.inf:
            return dp_table[s][e]
        else:
            ret = math.inf
            for i in range(s, e):
                left = dp(s, i)
                right = dp(i + 1, e)
                ret = min(ret, left + right)
            dp_table[s][e] = ret + pre_fix[e] - pre_fix[s - 1]        
            return dp_table[s][e]
    
    print(dp(1, K))

if __name__ == "__main__":
    TC = get_input()
    for _ in range(TC):
        set_variable()
        solution()