import sys
sys.setrecursionlimit(10**9+1)

get_line: iter = lambda: map(int, sys.stdin.readline().rstrip().split())
get_input: int = lambda: int(sys.stdin.readline().strip())

N, M, R, cnt = None, None, None, None
cnt_arr = None
adj = None
visited = None

def set_variable():
    global N, M, R, adj, visited, cnt, cnt_arr
    N, M, R = get_line()
    visited = [False for _ in range(N + 1)]
    cnt_arr = [0 for _ in range(N + 1)] 
    adj = [[] for _ in range(N + 1)]
    for _ in range(M):
        u, v = get_line()
        adj[u].append(v)
        adj[v].append(u)
    adj = list(map(sorted, adj))
    cnt = 0
    # print(adj)
    
        


def solution():
    def dfs(pos):
        global N, M, R, adj, visited, cnt, cnt_arr
        cnt += 1
        cnt_arr[pos] = cnt
        visited[pos] = True
        if adj[pos]:
            for i in adj[pos]:
                if visited[i] == False:
                    dfs(i)
        else: 
            return
    dfs(R)
    for i in cnt_arr[1:]:
        print(i)
        
    
    
if __name__ == "__main__":
    set_variable()
    solution()