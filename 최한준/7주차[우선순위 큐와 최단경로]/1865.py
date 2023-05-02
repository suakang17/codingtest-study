import sys

get_line: iter = lambda: map(int, sys.stdin.readline().rstrip().split())
get_input: int = lambda: int(sys.stdin.readline().strip())

N, M, W = None, None, None
dist, adj = None, None


def set_variable():
    global N, M, W, adj, dist
    N, M, W = get_line()
    adj = [[] for _ in range(N + 1)]
    for _ in range(M):
        S, E, T = get_line()
        adj[S].append((E, T))
        adj[E].append((S, T))
    for _ in range(W):
        S, E, T = get_line()
        adj[S].append((E, -T))
    dist = [sys.maxsize] * (N + 1)


def solution():
    global N, M, W, adj, dist

    def bellman_ford():
        dist[1] = 0
        check = False
        for i in range(N):
            for now_pos in range(1, N + 1):
                for nxt_pos, weight in adj[now_pos]:
                    if (dist[nxt_pos] > dist[now_pos] + weight):
                        dist[nxt_pos] = dist[now_pos] + weight
                        if i == N - 1:
                            check = True
        return check

    if bellman_ford():
        print("YES")
    else:
        print("NO")


if __name__ == "__main__":
    TC = get_input()
    for _ in range(TC):
        set_variable()
        solution()
