import sys
sys.setrecursionlimit(10**9)
input = sys.stdin.readline

n, m = map(int, input().rstrip().split())
parent = [i for i in range(n+1)]

def find(node):
    if parent[node] != node:
        parent[node] = find(parent[node])
    return parent[node]

def union(a, b):    #parent: 부모 테이블, a: 노드 a, b: 노드 b
    p1 = find(a)
    p2 = find(b)
    if p1 != p2:    # 두 노드의 부모가 같지 않으면
        if p1 > p2: # 노드 번호가 작은 노드가 부모가 되도록
            parent[p1] = p2
        else:
            parent[p2] = p1

for _ in range(m):
    op, a, b = map(int, input().rstrip().split())
    if op == 0:
        union(a, b)
    else:
        p1 = find(a)
        p2 = find(b)
        if p1 == p2:
            print('YES')
        else:
            print('NO')