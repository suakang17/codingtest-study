# 2차원을 1차원 배열로, 그냥 뒤에 이어붙이기
# 이분 탐색으로 어떤 수보다 작은 자연수의 곱(i * j)이 몇 개인지 알아내기
# A보다 작은 숫자가 몇 개인지 찾아내면 A가 몇 번째 숫자인지 알 수 있음
n, k = int(input()), int(input())
start, end = 1, k

while start <= end:
    mid = (start + end) // 2

    temp = 0
    for i in range(1, n + 1):
        temp += min(mid // i, n)

    if temp >= k:
        answer = mid
        end = mid - 1
    else:
        start = mid + 1
print(answer)