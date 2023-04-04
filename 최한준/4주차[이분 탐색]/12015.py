import sys

get_line: iter = lambda: map(int, sys.stdin.readline().rstrip().split())
get_input: int = lambda: int(sys.stdin.readline().strip())

N = None
arr = None

def set_variable():
    global N, arr
    N = get_input()
    arr = list(get_line())


def solution():
    global N, arr
    def binary_search(arr, num):
        L, R = -1, len(arr)
        while L + 1 < R:
            mid = (L + R) // 2
            if arr[mid] >= num: R = mid
            else : L = mid
        return R

    LIS = list()
    for i in arr:
        if not LIS:
            LIS.append(i)
        elif LIS[-1] < i:
            LIS.append(i)
        else:
            LIS[binary_search(LIS, i)] = i
    print(len(LIS))
            
        


if __name__ == "__main__":
    set_variable()
    solution()