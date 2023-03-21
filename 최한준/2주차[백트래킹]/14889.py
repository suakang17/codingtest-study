import sys
import math

get_line: iter = lambda: map(int, sys.stdin.readline().rstrip().split())
get_input: int = lambda: int(sys.stdin.readline().strip())

N = None
arr = None
top = None
bottom = None
ans = None

def set_variable():
    global N, arr, top, bottom, ans
    N = get_input()
    arr = [list(get_line()) for _ in range(N)]
    ans = math.inf

def solution():
    def rec(depth, team1, team2):
        global N, arr, top, bottom, ans
        if depth == N:
            sum1, sum2 = 0, 0
            for i in team1:
                for j in team1:
                    sum1 += arr[i][j]
            for i in team2:
                for j in team2:
                    sum2 += arr[i][j]
            ans = min(ans, abs(sum1- sum2))
        else:
            if len(team1) == N//2:
                rec(depth + 1, team1 , team2 + [depth])
            elif len(team2) == N // 2:
                rec(depth + 1, team1 + [depth], team2)
            else:
                rec(depth + 1, team1 + [depth], team2)
                rec(depth + 1, team1, team2 + [depth])
    
    rec(0, [], [])
    print(ans)

if __name__ == "__main__":
    set_variable()
    solution()