import sys

get_line: iter = lambda: map(int, sys.stdin.readline().rstrip().split())
get_input: int = lambda: int(sys.stdin.readline().strip())

N, K = None, None
arr = None
cnt = None

def merge(A, l, mid, r):
    global K, cnt
    i, j = l, mid + 1 # python은 append로 구현하면 필요없음.
    tmp = []
    while i <= mid and j <= r:
        if A[i] <= A[j]:
            tmp.append(A[i])
            i = i + 1
        else:
            tmp.append(A[j])
            j = j + 1
    
    while i <= mid:
        tmp.append(A[i])
        i += 1
    while j <= r:
        tmp.append(A[j])
        j = j + 1

    i= l
    while i <= r:
        cnt += 1
        A[i] = tmp[i-l]
        if cnt == K:
            print(A[i])
            sys.exit(0)
        i += 1

def merge_sort(A, l, r):
    if l < r:
        mid = (l + r) // 2
        merge_sort(A, l, mid)
        merge_sort(A, mid + 1, r)
        merge(A, l, mid, r) #  병합


def set_variable():
    global N, K, arr, cnt
    cnt = 0
    N, K = get_line()
    arr = list(get_line())

def solution():
    global N, K, arr, cnt
    merge_sort(arr, 0, len(arr)-1)
    print(-1)

if __name__ == "__main__":
    set_variable()
    solution()