import heapq
import sys
input = sys.stdin.readline

n = int(input())
x = list(int(input()) for _ in range(n))
heap = []

for i in x:
    if i == 0:
        if heap:
            print(heapq.heappop(heap))
        else:
            print(0)

    else:
        heapq.heappush(heap, i)