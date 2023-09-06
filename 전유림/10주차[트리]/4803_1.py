import sys
from collections import deque
input = sys.stdin.readline
sys.setrecursionlimit(10**9)

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

case = 0

while True:
    n, m = map(int, input().rstrip().split())
    if n == 0 and m == 0:
        break
    case += 1
    parent = [i for i in range(n+1)]
    cycle = []
    for _ in range(m):
        a, b = map(int, input().rstrip().split())
        p1 = find(a)
        p2 = find(b)
        if p1 != p2:
            union(a, b)
        else:
            # cycle이 발생한 케이스이므로 따로 저장
            cycle.append(a)

    #  find 함수를 돌려서 각 정점의 parents를 갱신한다.
    for i in range(n+1):
        find(i)

    # cycle이 있는 그룹들 저장
    group = set()
    for cycle_vertex in cycle:
        group.add(parent[cycle_vertex]) # cycle이 발생한 정점의 부모를 저장

    count = 0
    for i in range(1, n+1): # 부모가 같은 그룹들을 카운트
        if parent[i] in group:
            continue
        count += 1
        group.add(parent[i])    # group에 추가해서 중복을 제거
    
    if count == 0:
        print(f'Case {case}: No trees.')
    elif count == 1:
        print(f'Case {case}: There is one tree.')
    else:
        print(f'Case {case}: A forest of {count} trees.')
    