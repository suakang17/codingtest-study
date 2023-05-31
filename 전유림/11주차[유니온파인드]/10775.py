import sys
sys.setrecursionlimit(10**9)
input = sys.stdin.readline

g = int(input())
p = int(input())
parent = [i for i in range(g+1)]
planes = [int(input()) for _ in range(p)]

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

result = 0
for plane in planes:
    p = find(plane)
    if p == 0:
        break
    union(p, p-1)
    result += 1
print(result)