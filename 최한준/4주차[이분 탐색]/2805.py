import sys

get_line: iter = lambda: map(int, sys.stdin.readline().rstrip().split())
get_input: int = lambda: int(sys.stdin.readline().strip())

N, M = None, None
arr = None

def set_variable():
    global N, M, arr
    N, M = get_line()
    arr = list(get_line())

def solution():
    global N, M, arr
    def binary_search(L, R):
        def possible(num):
            length = 0
            for i in arr:
                length += 0 if i - num <= 0 else i - num
            if length >= M : return True
            else : False
        while L + 1 < R:
            mid = (L + R) // 2
            if possible(mid) : L = mid
            else : R = mid
        return L
    
    print(binary_search(0, max(arr) + 1))


if __name__ == "__main__":
    set_variable()
    solution()