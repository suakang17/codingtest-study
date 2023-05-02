import sys
from heapq import heappop, heappush
get_line: iter = lambda: map(int, sys.stdin.readline().rstrip().split())
get_input: int = lambda: int(sys.stdin.readline().strip())

N = None
heap = None
def set_variable():
    global N, heap
    N = get_input()
    heap = []

def solution():
    global N, heap
    def abs_smaller_priority(item):
        return abs(item), item
    for _ in range(N):
        x = get_input()
        if x == 0:
            if heap : 
                print(heappop(heap)[1])
            else:
                print(0)
        else:
            heappush(heap, abs_smaller_priority(x))
            

if __name__ == "__main__":
    set_variable()
    solution()