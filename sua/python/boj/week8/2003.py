import sys
input = sys.stdin.readline


def main():
    ret = 0
    lo, hi = 0, 1
    while hi <= n and lo <= hi:
        if sum(a[lo:hi]) > m:  # sum 줄이기
            lo += 1
        elif sum(a[lo:hi]) == m:
            ret += 1
            hi += 1
        else:  # sum 늘리기
            hi += 1

    print(ret)


if __name__ == '__main__':
    n, m = map(int, input().split())
    a = list(map(int, input().split()))
    main()