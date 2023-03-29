import sys

get_line: iter = lambda: map(int, sys.stdin.readline().rstrip().split())
get_input: int = lambda: int(sys.stdin.readline())

N = get_input()

arr = [987654321] * (N + 1)
arr1 = [0] * (N + 1)
arr[1] = 0
for i in range(1, N):
    arr[i + 1] = min(arr[i] + 1, arr[i + 1])
    if i * 3 <= N:
        arr[i * 3] = min(arr[i * 3], arr[i] + 1)
    if i * 2 <= N:
        arr[i * 2] = min(arr[i * 2], arr[i] + 1)

print(arr[N])