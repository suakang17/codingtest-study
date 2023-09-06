import sys
sys.setrecursionlimit(10**9)
input = sys.stdin.readline

f = int(input())

def find(node):
    if parents[node] != node:
        parents[node] = find(parents[node])
    return parents[node]

def union(a, b):   
    p1 = find(a)
    p2 = find(b)
    if p1 != p2:
        parents[p2] = p1
        friends[p1] += friends[p2]
    print(friends[p1])

for _ in range(f):
    n = int(input())
    parents, friends = {}, {}
    for _ in range(n):
        a, b = input().rstrip().split()
        if a not in parents:
            parents[a] = a
            friends[a] = 1
        if b not in parents:
            parents[b] = b
            friends[b] = 1
        union(a, b)