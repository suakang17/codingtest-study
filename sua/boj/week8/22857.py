import sys
input = sys.stdin.readline


def main():
    # 연속 짝수 부분 수열 길이를 구하기 위한 투포인터 구현
    kcnt, size, maxsize = 0, 0, 0  # 현재 부분수열 홀수 개수 / 현재 부분수열 길이 / 가장 긴 부분수열 길이
    lo, hi = 0, 1

    for lo in range(n):
        while kcnt <= k and lo < hi < n:
            if s[lo] % 2:  # 짝수
                size += 1
                hi += 1

            else:  # 홀수
                if kcnt == k:
                    max(maxsize, size)
                else:
                    kcnt += 1




if __name__ == "__main__":
    n, k = map(int, input().split())
    # 어차피 길이 출력이니까 홀0/짝1으로 저장
    s = list(map(int, input().split()))

    main()



