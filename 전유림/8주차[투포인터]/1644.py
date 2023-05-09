import sys
input = sys.stdin.readline

n = int(input())
start, end = 0, 0
cnt = 0

a = [False,False] + [True]*(n-1)
primes=[]

for i in range(2,n+1):
    if a[i]:
        primes.append(i)
        for j in range(2*i, n+1, i):
            a[j] = False

while end <= len(primes):
    tmp = sum(primes[start:end])
    if tmp == n:
        cnt += 1
        end += 1
    elif tmp < n:
        end += 1
    else:
        start += 1

print(cnt)