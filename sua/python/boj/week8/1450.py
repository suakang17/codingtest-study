import sys
input = sys.stdin.readline

# 1.
# def solution():
#     arr = [0] * 1000001
#     n, k = map(int, input().split())
#     for i in range(n):
#         a, b = map(int, input().split())
#         arr[a + 1] += 1
#         arr[b + 1] -= 1
#     for i in range(1, 1000001):
#         arr[i] += arr[i - 1]
#
#     lo, hi = 0, 0
#     sum = 0
#     while True:
#         if sum < k:
#             hi += 1
#             sum += arr[hi]
#         elif sum > k:
#             sum -= arr[lo]
#             lo += 1
#         else:
#             print(lo, hi)
#             return
#
#         if hi == 1000001:
#             break
#     print(0, 0)


# 2.
from itertools import combinations
def solution():
    list_a = arr[:len(arr) // 2]
    list_b = arr[len(arr) // 2:]

    subset_a = []
    subset_b = []

    for i in range(len(list_a) + 1):
        for subset in combinations(list_a, i):
            subset_a.append(sum(subset))

    for i in range(len(list_b) + 1):
        for subset in combinations(list_b, i):
            subset_b.append(sum(subset))

    subset_a.sort()
    answer = 0

    for each_b in subset_b:
        if each_b > c:
            continue

        lo, hi = 0, len(subset_a)

        while lo < hi:
            mid = (lo + hi) // 2

            if each_b + subset_a[mid] > c:
                hi = mid
            else:
                lo = mid + 1

        answer += hi

    print(answer)


if __name__ == '__main__':
    n, c = map(int, input().split())
    arr = list(map(int, input().split()))

    solution()