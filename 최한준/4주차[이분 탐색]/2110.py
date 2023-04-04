import sys
import math

get_line: iter = lambda: map(int, sys.stdin.readline().rstrip().split())
get_input: int = lambda: int(sys.stdin.readline().strip())

N, C = None, None
pos = None

def set_variable():
    global N, C, pos
    N, C = get_line()
    pos = list()
    for _ in range(N):
        pos.append(get_input())
    pos.sort()


def solution():
    global N, C, pos
    def binary_search(L, R):
        def possible(dist): 
        # dist 보다 넓게 설치해서 C개 넘게 설치 할 수 있으면 True, 아니면 False
            pre_pos = -math.inf
            cnt = 0
            for i in pos:
                if i - pre_pos >= dist:
                    cnt += 1
                    pre_pos = i
                else: continue
            if cnt >= C : return True
            else : return False
        while L + 1 < R:
            mid = (L + R) // 2
            if possible(mid): L = mid
            else : R = mid
        return L
    print(binary_search(0, int(1e9+1)))
                    
if __name__ == "__main__":
    set_variable()
    solution()