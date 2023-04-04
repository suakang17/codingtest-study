# 재귀
import sys
n = int(sys.stdin.readline())
a = sorted(list(map(int, sys.stdin.readline().split())))
m = int(sys.stdin.readline())
goals = list(map(int, sys.stdin.readline().split()))

start = 0
end = len(a) - 1


def bs(arr, target, start, end):
    if start > end:
        return 0

    mid = int((start + end) //2)
    if arr[mid] == target:
        return 1

    elif arr[mid] > target:
        return bs(arr, target, start, mid - 1)

    else:
        return bs(arr, target, mid + 1, end)


for i in goals:
    if bs(a, i, start, end):
        print(1)
    else:
        print(0)

# 2 - 반복문
def bs(arr, target, start, end):
    while start <= end:
        mid = (start + end) // 2

        if arr[mid] == target:
            return 1

        elif arr[mid] > target:
            end = mid - 1

        else:
            start = mid + 1
    return 0