import sys
input = sys.stdin.readline

n = int(input())

a = [False, False] + [True] * (n - 1)
prime_num = []

for i in range(2, n + 1):
    if a[i]:
        prime_num.append(i)
        for j in range(2 * i, n + 1, i):
            a[j] = False

answer = 0
start = 0
end = 0

while end <= len(prime_num):
    temp_sum = sum(prime_num[start:end])
    if temp_sum == n:
        answer += 1
        end += 1
    elif temp_sum < n:
        end += 1
    else:
        start += 1

print(answer)