import sys

get_line: iter = lambda: map(int, sys.stdin.readline().rstrip().split())
get_input: int = lambda: int(sys.stdin.readline().strip())

N = None
K = None

def set_variable():
    global N, K
    N = get_input()
    K = get_input()


def solution():
    global N, K
    def binary_search(L, R):
        def possible(num):
            cnt = 0
            for i in range(1, N + 1):
                cnt += min(N, num // i)
            if cnt >= K : return True
            else : return False
        while L + 1 < R:
            mid = (L + R) // 2
            if possible(mid) : R = mid
            else : L = mid
        return R
    print(binary_search(0, int(1e9 + 1)))
            


if __name__ == "__main__":
    set_variable()
    solution()