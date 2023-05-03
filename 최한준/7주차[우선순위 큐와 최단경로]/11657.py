import sys
import math

get_line: iter = lambda: map(int, sys.stdin.readline().rstrip().split())
get_input: int = lambda: int(sys.stdin.readline().strip())

N, M = None, None
edge = None
dist = None

def set_variable():
    global N, M, edge, dist
    N, M = get_line()
    edge = [[] for _ in range(N + 1)]
    dist = [math.inf for _ in range(N + 1)]
    for _ in range(M):
        a, b, c = get_line()
        edge[a].append((b,c))


def solution():
    def bellman_ford():
        global N, M, edge, dist
        dist[1] = 0 # 시작 지점을 1로 잡음, 아무 곳이나 잡아도 상관없기 때문
        flag = True
        for i in range(N):
            for now_pos in range(1, N + 1):
                for nxt_pos, weight in edge[now_pos]:
                    if dist[now_pos] != math.inf and dist[nxt_pos] > dist[now_pos] + weight:
                        dist[nxt_pos] = dist[now_pos] + weight
                        if i == N - 1:
                            flag = False
        return flag

    flag = bellman_ford()
    
    if flag:
        for ans in dist[2:]:
            if ans == math.inf:
                print(-1)
            else:
                print(ans)
    else:
        print(-1)
        

if __name__ == "__main__":
    set_variable()
    solution()