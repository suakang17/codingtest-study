import sys

get_line: iter = lambda: map(int, sys.stdin.readline().rstrip().split())
get_input: int = lambda: int(sys.stdin.readline().strip())

n, m, edge = None, None, None


def set_variable():
    global n, m, edge
    n = get_input()
    m = get_input()
    edge = [[sys.maxsize for _ in range(n + 1)] for _ in range(n + 1)]
    for _ in range(m):
        a, b, c = get_line()
        edge[a][b] = min(edge[a][b], c)

    for i in range(1, n + 1):
        edge[i][i] = 0


def solution():
    global n, m, edge

    def floyd_warshall():
        for m in range(1, n + 1):
            for s in range(1, n + 1):
                for e in range(1, n + 1):
                    if edge[s][m] != sys.maxsize and edge[m][e] != sys.maxsize:
                        edge[s][e] = min(edge[s][e], edge[s][m] + edge[m][e])

    floyd_warshall()
    for i in range(1, n + 1):
        ans_list = []
        for j in range(1, n + 1):
            if edge[i][j] == sys.maxsize:
                ans_list.append(0)
            else:
                ans_list.append(edge[i][j])
        print(*ans_list)

if __name__ == "__main__":
    set_variable()
    solution()
