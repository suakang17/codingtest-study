import sys
sys.setrecursionlimit(10**9)
input = sys.stdin.readline

n, m, k = map(int, input().split())
parent = [i for i in range(n+1)]
node1, node2 = None, None

def find(node):
    if parent[node] != node:
        parent[node] = find(parent[node])
    return parent[node]

def union(a, b):   
    p1 = find(a)
    p2 = find(b)
    if p1 > p2:
        parent[p1] = p2
    else:
        parent[p2] = p1

def count(x):
    cnt = 0
    for i in range(1, n+1):
        if find(i) == x:
            cnt += 1
    return cnt

for i in range(m):
    a, b = map(int, input().split())
    if i != k-1:
        union(a, b)
    else:
        node1, node2 = a, b

if find(node1) == find(node2):
    print("0")
else:
    result = count(parent[1])
    print(result*(n-result))