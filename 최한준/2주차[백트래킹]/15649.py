import sys

get_line: iter = lambda: map(int, sys.stdin.readline().rstrip().split())
get_input: int = lambda: int(sys.stdin.readline().strip())
    
N, M = None, None
visited = None
arr = None
    
def set_variable():
    global N, M, visited, arr
    N, M = get_line()
    visited = [False for _ in range(N + 1)]
    arr = [0 for _ in range(M)]

def solution():
    global N, M, visited, arr
    def rec(depth):
        if depth == M:
            for i in range(M):
                print(arr[i], end=" ")
            print("")
        else:
            for i in range(1, N + 1):
                if visited[i] == False:
                    visited[i] = True
                    arr[depth] = i
                    rec(depth + 1)
                    visited[i] = False
     
    rec(0)
    
if __name__ == "__main__":
    set_variable()
    solution()