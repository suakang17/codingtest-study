import sys
sys.setrecursionlimit(10**9)
input = sys.stdin.readline

n, m = map(int, input().split())
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

for i in range(m):
    a, b = map(int, input().split())
    if find(a) == find(b):
        print(i+1)
        break
    else:
        union(a, b)
else:
    print(0)