import sys
input = sys.stdin.readline

N, K = map(int, input().split())
arr = [0] * 1000002 # 누적합을 구해줄 배열

for i in range(N):
    l, r = map(int, input().split())
    arr[l+1] += 1   # 시작점에 1을 더해준다. 이유: 시작점에 끝점을 넣어주면 누적합을 구할 때, 시작점을 포함하게 된다.
    arr[r+1] -= 1   # 끝점에 1을 빼주면 누적합을 구할 때, 끝점을 포함하지 않게 된다.

for i in range(1, 1000001): # 누적합을 구해준다.
    arr[i] += arr[i-1]

start, end = 0, 0
sum = 0
while True:
    if sum < K: # 합이 K보다 작으면 end를 늘려준다.
        end += 1
        sum += arr[end] # 누적합을 구해준 배열의 값을 더해준다.
    elif sum > K:   # 합이 K보다 크면 start를 늘려준다.
        start += 1
        sum -= arr[start]   # 누적합을 구해준 배열의 값을 빼준다.
    else:
        print(start, end)   # 합이 K와 같으면 start와 end를 출력해준다.
        break
    if end == 1000001:
        print(0, 0)
        break
