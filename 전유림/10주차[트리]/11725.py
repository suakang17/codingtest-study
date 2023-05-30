import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

n = int(input())
node = [[] for _ in range(n+1)]
parent = [0] * (n+1)
for _ in range(n-1):
    a, b = map(int, input().split())
    node[a].append(b)
    node[b].append(a)

def tree(start):
    for i in node[start]:
        if parent[i] == 0:
            parent[i] = start
            tree(i)

tree(1)
for i in range(2, n+1):
    print(parent[i])