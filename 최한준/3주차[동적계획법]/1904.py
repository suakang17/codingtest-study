import sys

MOD = 15746
get_line: iter = lambda: map(int, sys.stdin.readline().rstrip().split())
get_input: int = lambda: int(sys.stdin.readline())

N = get_input()

arr = [0, 1, 2] + [0] * (N + 1)

for i in range(3, N + 1):
    arr[i] = (arr[i - 1] + arr[i - 2]) % MOD
print(arr[N])
