import sys
sys.setrecursionlimit(10**9)
input = sys.stdin.readline

n, m, q = map(int, input().split())
parent = [-1 for _ in range(n+1)]
graph = [(0, 0) for _ in range(m+1)]    # 간선 정보
check = [False for _ in range(m+1)]    # 삭제할 간선인지 확인
disconnect = [0 for _ in range(q+1)]    # 삭제할 간선

def find(node):
    if parent[node] < 0:
        return node
    parent[node] = find(parent[node])
    return parent[node]

def union(a, b):
    a = find(a)
    b = find(b)
    if a == b:  # 사이클이 생기는 경우
        return
    parent[a] += parent[b]  
    parent[b] = a   # b의 부모를 a로 설정하는 이유: b의 부모가 a가 아니라 b라면, a의 부모가 b가 되는 것이다. 이는 사이클을 형성하는 것이다. 따라서 b의 부모를 a로 설정해야 한다.

for i in range(1, m+1):
    x, y = map(int, input().split())
    graph[i] = (x, y)   # 간선 정보 저장
    check[i] = True    # 삭제할 간선이 아닌 것으로 설정

for i in range(1, q+1):
    disconnect[i] = int(input())    # 삭제할 간선 정보 저장
    check[disconnect[i]] = False    # 삭제할 간선으로 설정

for i in range(1, m+1):
    if check[i]:
        union(graph[i][0], graph[i][1])   
        # 삭제할 간선이 아닌 경우 유니온 파인드 진행하는 이유: 
        # 삭제할 간선이 아닌 간선들로 유니온 파인드를 진행해야 사이클이 생기는지 확인할 수 있다.
answer = 0

for i in range(q, 0, -1):
    temp = disconnect[i]    # 삭제할 간선
    x = find(graph[temp][0])    # 삭제할 간선의 두 정점
    y = find(graph[temp][1])
    if x != y:  # 사이클이 생기지 않는 경우
        answer += (parent[x] * parent[y]) 
    union(x, y) # 삭제할 간선을 추가한 경우 유니온 파인드 진행하는 이유: 삭제할 간선을 추가한 경우 유니온 파인드를 진행해야 사이클이 생기는지 확인할 수 있다.

print(answer)