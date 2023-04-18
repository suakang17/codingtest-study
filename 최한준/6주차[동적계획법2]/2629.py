import sys
sys.setrecursionlimit(10**9 + 1)
get_line: iter = lambda: map(int, sys.stdin.readline().rstrip().split())
get_input: int = lambda: int(sys.stdin.readline().strip())

N, M = None, None
chu = None
weights = None
dp_table = None

def set_variable():
    global N, M, chu, weights, dp_table
    N = get_input()
    chu = list(get_line()) + [0]
    M = get_input()
    weights = get_line()
    dp_table = [[False] * (15000 + 1) for _ in range(N + 3)]

def solution():
    def dp(n, weight):
        global N, M, chu, weights, dp_table
        if n > N:
            return 
        if dp_table[n][weight] == True:
            return

        dp_table[n][weight] = True
        dp(n + 1, weight) # 안 올린 경우
        if n != N:
            dp(n + 1, weight + chu[n]) # 오른쪽
            dp(n + 1, abs(weight - chu[n]))  # 왼쪽

    dp(0, 0)
    for i in weights:
        if i > 15000:
            print("N", end= " ") 
        elif dp_table[N][i]:
            print("Y", end=" ")
        else:
            print("N", end= " ") 

if __name__ == "__main__":
    set_variable()
    solution()