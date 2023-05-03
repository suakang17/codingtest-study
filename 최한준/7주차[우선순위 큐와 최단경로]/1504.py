import sys
import math
from heapq import heappush, heappop
get_line: iter = lambda: map(int, sys.stdin.readline().rstrip().split())
get_input: int = lambda: int(sys.stdin.readline().strip())

N, E = None, None
edge = None

def set_variable():
    global N, E, edge
    N, E = get_line()
    edge = [[] for _ in range(N + 1)]
    for _ in range(E):
        a, b, c = get_line()
        edge[a].append((b, c))
        edge[b].append((a, c))

def solution():
    def dijkstra(st):
        global N, E, edge
        dist = [math.inf for _ in range(N + 1)] # dist[ed] => st에서 출발해 ed까지의 최단거리.
        dist[st] = 0
        heap = [(0, st)]
        
        while heap:
            n_dist, n_pos = heappop(heap)
            
            for nxt_pos, weight in edge[n_pos]:
                if dist[nxt_pos] > n_dist + weight:
                    dist[nxt_pos] = n_dist + weight
                    heappush(heap, (dist[nxt_pos], nxt_pos))
        
        return dist
    
    v1, v2 = get_line()
    v1_dist = dijkstra(v1)
    v2_dist = dijkstra(v2)
    
    answer = min(v1_dist[1] + v2_dist[N], v1_dist[N] + v2_dist[1])
    answer += v1_dist[v2]
    if answer >= math.inf:
        print(-1)
    else:
        print(answer)


if __name__ == "__main__":
    set_variable()
    solution()