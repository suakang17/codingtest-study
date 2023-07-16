# 횟수의 최솟값 -> dp
import sys
n = int(sys.stdin.readline())
d = [0] * (n+1)  # d[n] = n이 1이 되는데 필요한 최소 연산 수

# bottom-up
for i in range(2, n+1):
    d[i] = d[i-1] + 1  # 1 빼는 연산 적용시 연산횟수 미리 저장
    if i % 3 == 0:
        d[i] = min(d[i], d[i//3]+1)  # i를 3로 나눈 값이 1이 되는데 걸리는 최소 연산 횟수 + i를 3로 나누는 연산횟수 1회
    if i % 2 == 0:
        d[i] = min(d[i], d[i//2]+1)  # i를 2로 나눈 값이 1이 되는데 걸리는 최소 연산 횟수 + i를 2로 나누는 연산횟수 1회

print(d[n])