import sys
from collections import deque
input = sys.stdin.readline
sys.setrecursionlimit(10**9)

def findCycle(start):   # 사이클이 존재하는지 확인
    isCycle = False
    q = deque()
    q.append(start)    # 시작 노드를 큐에 넣고
    
    while q:
        now = q.popleft() 
        if visited[now]:    # 방문한 노드가 다시 나오면 사이클이 존재
            isCycle = True
        
        visited[now] = 1
        
        for next in tree[now]:  # 현재 노드와 연결된 노드들을 탐색
            if visited[next] == 0:  # 방문하지 않은 노드
                q.append(next)  # 큐에 넣고
                
    return isCycle


case = 0
while True:
    n, m = map(int, input().split())
    case += 1
    if n == 0 and m == 0:
        break
    tree = [[] for _ in range(n+1)]
    visited = [0]*(n+1) # 방문 여부
    cnt = 0
    
    # 양방향 매핑
    for _ in range(m):
        a, b = map(int, input().split())
        tree[a].append(b)
        tree[b].append(a)
    
    for node in range(1, n+1):
        if visited[node] == 0:  # 방문하지 않은 노드만 탐색
            if not findCycle(node): # 사이클이 없으면
                cnt += 1
    
    if cnt == 0:
        print(f'Case {case}: No trees.')
    elif cnt == 1:
        print(f'Case {case}: There is one tree.')
    else:
        print(f'Case {case}: A forest of {cnt} trees.')