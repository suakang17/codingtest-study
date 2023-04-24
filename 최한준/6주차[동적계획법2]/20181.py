import sys

get_line: iter = lambda: map(int, sys.stdin.readline().rstrip().split())
get_input: int = lambda: int(sys.stdin.readline().strip())

N, K = None, None
arr = None
dp_table = None
prefix = None

def set_variable():
    global N, K, arr, dp_table, prefix
    N, K = get_line()
    arr = list(get_line())
    dp_table = [0] * (N + 1)
    prefix = [0]
    

def solution():
    global N, K, arr, dp_table, prefix
    l = r = lmax = answer = s = 0
    while True:
        if s >= K:
            lmax = 0 if l == 0 else max(lmax, dp_table[l - 1])
            dp_table[r-1] = max(dp_table[r-1], lmax + s- K)
            s -= arr[l]
            l += 1
        elif r == N:
            break
        else:
            s += arr[r]
            r+=1
    for i in range(N):
        answer = max(answer, dp_table[i])
    print(answer)
        
        

if __name__ == "__main__":
    set_variable()
    solution()