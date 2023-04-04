# 랜선, 나무 문제와 유사
# 대상: 거리 -> max
import sys
n, c = map(int, sys.stdin.readline().split())

array = []
for i in range(n):
    array.append(int(sys.stdin.readline()))

array.sort()


def binary_search(array, start, end):
    while start <= end:
        mid = (start + end) // 2
        current = array[0]
        count = 1

        for i in range(1, len(array)):
            if array[i] >= current + mid:
                count += 1
                current = array[i]

        if count >= c:  # 설치할 수 있는 공유기 개수가 c개를 넘어가면 최적이 아님
            global answer
            start = mid + 1
            answer = mid
        else:
            end = mid - 1


start = 1  # 거리의 최솟값
end = array[-1] - array[0]  # 거리의 최댓값
answer = 0

binary_search(array, start, end)
print(answer)