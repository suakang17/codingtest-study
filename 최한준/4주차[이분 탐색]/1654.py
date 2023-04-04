import sys

get_line: iter = lambda: map(int, sys.stdin.readline().rstrip().split())
get_input: int = lambda: int(sys.stdin.readline().strip())

K, N = None, None
arr = None

def set_variable():
    global K, N, arr
    K, N = get_line()
    arr = list()
    for _ in range(K):
        arr.append(get_input())
        

def solution():
    global K, N, arr
    def binary_search(L, R):
        def possible(num):
            cnt = 0
            for i in arr:
                cnt += (i // num)
            if cnt >= N : return True
            else : return False
        while L + 1 < R:
            mid = (L + R) // 2
            if possible(mid): L = mid
            else : R = mid
        return L
    
    print(binary_search(0, max(arr) + 1))
            


if __name__ == "__main__":
    set_variable()
    solution()