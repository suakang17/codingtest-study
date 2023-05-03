import sys
import math
from heapq import heappush, heappop

get_line: iter = lambda: map(int, sys.stdin.readline().rstrip().split())
get_input: int = lambda: int(sys.stdin.readline().strip())

V, E, K = None, None, None
dist = None
edge = None
heap = None


def set_variable():
    global V, E, K, dist, edge, heap
    V, E = get_line()
    K = get_input()
    edge = [[] for _ in range(V + 1)]
    dist = [math.inf for _ in range(V + 1)]
    heap = []
    for _ in range(E):
        u, v, w = get_line()
        edge[u].append((v, w))
    
        


def solution():
    def dijkstra():
        global V, E, K, dist, edge, heap
        dist[K] = 0
        heap.append((0, K))
        
        while heap:
            n_dist, n_pos = heappop(heap)
            
            if dist[n_pos] < n_dist:
                continue
            
            for nxt_pos, weight in edge[n_pos]:
                if  dist[nxt_pos] > n_dist + weight:
                    dist[nxt_pos] = n_dist + weight
                    heappush(heap, (dist[nxt_pos], nxt_pos))
    
    dijkstra()
    for i in range(1, V + 1):
        if dist[i] == math.inf:
            print("INF")
        else:
            print(dist[i])
        

if __name__ == "__main__":
    set_variable()
    solution()