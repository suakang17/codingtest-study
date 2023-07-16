# LIS 시간 줄이기 ver.
# 증가한다는 것은 선행 원소보다 후행 원소가 커야 한다는 것
# 가장 길다는 것은 제한 된 수의 범위 내 볼 때 상호 원소간 값의 차이가 적어야 한다는 것
# 이분 탐색: 대치를 하는 과정에 탐색하는 값보다 큰 가장 가까운 원소를 찾는데 쓰임
import sys
input = sys.stdin.readline

n = int(input())
cases = list(map(int, input().split()))
lis = [0]

for case in cases:
    if lis[-1] < case:
        lis.append(case)
    else:
        left = 0
        right = len(lis)

        while left < right:
            mid = (right + left) // 2
            if lis[mid] < case:
                left = mid + 1
            else:
                right = mid
        lis[right] = case

print(len(lis) - 1)