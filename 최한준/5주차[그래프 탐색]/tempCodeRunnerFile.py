import sys
import math
from collections import deque

get_line: iter = lambda: map(int, sys.stdin.readline().rstrip().split())
get_input: int = lambda: int(sys.stdin.readline().strip())


arr = None
N, M = None, None

def set_variable():
    global arr, N, M
    N, M = get_line()
    arr = [[] for _ in range(200)]
    for _ in range(N):
        x, y = get_line()
        arr[x].append(y)
        
    for _ in range(M):
        x, y = get_line()
        arr[x].append(y)
    
    


def solution():
    def bfs():            
        global arr, N, M
        visited = [False] * 200
        queue = deque()
        queue.append(1)
        cnt = 0
        while queue:
            for i in range(len(queue)):
                pos = queue.popleft()
                print(pos)
                for i in range(1, 7):
                    if visited[pos + i] == False and pos + i <= 100:
                        visited[pos + i] = True
                        if arr[pos + i]:
                            for nxt in arr[pos + i]:
                                if visited[nxt] == False:
                                    visited[nxt] = True
                                    queue.append(nxt)
                        else:
                            queue.append(pos + i)
            cnt += 1
            if visited[100] == True:
                print(cnt)
                sys.exit(0)
    bfs()
                    
        


if __name__ == "__main__":
    set_variable()
    solution()