import sys
input = sys.stdin.readline


def solution():
    n, k = map(int, input().split())
    vertical = [0] * 1000002

    for _ in range(n):
        left, right = map(int, input().split())
        vertical[left + 1] += 1
        vertical[right + 1] -= 1

    for i in range(1, len(vertical)):
        vertical[i] += vertical[i-1]

    lo, hi, val = 0, 0, 0
    flag = False
    while lo < 1000001 and hi < 1000001:
        if val == k:
            flag = True
            break
        elif val < k:
            hi += 1
            val += vertical[hi]
        else:
            lo += 1
            val -= vertical[lo]

    if flag:
        print(lo, hi)
    else:
        print(0, 0)


if __name__ == "__main__":
    solution()
