import heapq
import sys
input = sys.stdin.readline

n = int(input())
x = list(int(input()) for _ in range(n))
heap = []

for i in x:
    if i == 0:
        if heap:
            print(-heapq.heappop(heap)) # 최대 힙이므로 -를 붙여줘야 최대값이 출력됨
        else:
            print(0)
    else:
        heapq.heappush(heap, -i)