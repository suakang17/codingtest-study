# 1. 순열 조합 이용 2. dfs
# 계산 순서는 무조건 주어진대로 -> 연산자 우선순위 무시
# 나눗셈은 정수 나눗셈으로 몫만 취함 //
# 음수를 양수로 나눌 때는 양수로 바꾼 뒤 몫을 취하고, 그 몫을 음수로 바꾸는 방식
import sys
n = int(sys.stdin.readline())
a = list(map(int, sys.stdin.readline().split()))
add, sub, mul, div = map(int, sys.stdin.readline().split())
max_result = -1e9
min_result = 1e9


def dfs(depth, num):
    global max_result, min_result, add, sub, mul, div
    if depth == n:
        max_result = max(max_result, num)
        min_result = min(min_result, num)
    else:
        if add > 0:
            add -= 1
            dfs(depth + 1, num + a[depth])
            add += 1
        if sub > 0:
            sub -= 1
            dfs(depth + 1, num - a[depth])
            sub += 1
        if mul > 0:
            mul -= 1
            dfs(depth + 1, num * a[depth])
            mul += 1
        if div > 0:
            div -= 1
            dfs(depth + 1, int(num / a[depth]))
            div += 1

dfs(1, a[0])
print(max_result)
print(min_result)