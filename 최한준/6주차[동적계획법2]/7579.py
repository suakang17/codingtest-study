import sys
import math

get_line: iter = lambda: map(int, sys.stdin.readline().rstrip().split())
get_input: int = lambda: int(sys.stdin.readline().strip())

N, M = None, None
memory = None
cost = None
dp_table = None

def set_variable():
    global N, M, memory, cost, dp_table
    N, M = get_line()
    memory = list(get_line())
    cost = list(get_line())
    dp_table = [0] * (10000 + 1)

def solution():
    sum_cost = sum(cost)
    def kanpsack():
        global N, M, memory, cost, dp_table
        for i in range(N):
            for j in range(sum_cost, cost[i] - 1, -1):
                dp_table[j] = max(dp_table[j], dp_table[j-cost[i]] + memory[i])
        
    kanpsack()    
    answer = math.inf
    for i in range(sum_cost + 1):
        if dp_table[i] >= M:
            answer = min(answer, i)
    print(answer)


if __name__ == "__main__":
    set_variable()
    solution()