import sys
input = sys.stdin.readline

n, s = map(int, input().split())
arr = list(map(int, input().split()))

start, end = 0, 0
sum = arr[0]    # 부분합
result = sys.maxsize

while start <= end and end < n:
    if sum < s: # 부분합이 s보다 작다면
        end += 1
        if end < n: # end가 n보다 작다면
            sum += arr[end]   # end를 1 증가시키고 부분합에 더해준다.
    else:
        result = min(result, end-start+1)   # 부분합이 s보다 크거나 같다면 result를 갱신하고
        sum -= arr[start]   # 부분합에서 빼준다.
        start += 1

print(result if result != sys.maxsize else 0)