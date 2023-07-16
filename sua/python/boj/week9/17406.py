import sys
from itertools import permutations
from copy import deepcopy
input = sys.stdin.readline


n, m, k = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]
rcs = [list(map(int, input().split())) for _ in range(k)]

ans = 987654321

# 1. 회전 순서 정하기 (최대 6!=720)
for p in permutations(rcs, k):
    # 2. 회전
    copy_arr = deepcopy(arr)  # 원본리스트 카피
    for r, c, s in p:
        r -= 1
        c -= 1
        for n in range(s, 0, -1):
            tmp = copy_arr[r-n][c+n]
            copy_arr[r-n][c-n+1:c+n+1] = copy_arr[r-n][c-n:c+n]  # ->
            for row in range(r-n, r+n):  # ↑
                copy_arr[row][c-n] = copy_arr[row+1][c-n]
            copy_arr[r+n][c-n:c+n] = copy_arr[r+n][c-n+1:c+n+1]  # <-
            for row in range(r+n, r-n, -1):  # ↓
                copy_arr[row][c+n] = copy_arr[row-1][c+n]
            copy_arr[r-n+1][c+n] = tmp

    # 3. 각 행의 최소값 찾기
    for row in copy_arr:
        ans = min(ans, sum(row))

print(ans)