import sys
sys.setrecursionlimit(10**9)
input = sys.stdin.readline

n = int(input())
m = int(input())
parent = [i for i in range(n+1)]

def find(node):
    if parent[node] != node:
        parent[node] = find(parent[node])
    return parent[node]

def union(a, b):    
    p1 = find(a)
    p2 = find(b)
    if p1 != p2:    
        if p1 > p2: 
            parent[p1] = p2
        else:
            parent[p2] = p1

for i in range(1, n+1):
    line = list(map(int, input().rstrip().split()))
    for j in range(1, n+1):
        if line[j-1] == 1:
            union(i, j)

plan = list(map(int, input().rstrip().split()))
flag = True
for i in range(m-1):
    if find(plan[i]) != find(plan[i+1]):
        flag = False
        break

if flag:
    print('YES')
else:
    print('NO')