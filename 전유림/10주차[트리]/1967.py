import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**5)

n = int(input())
tree = [[] for _ in range(n+1)]
# 양방향 연결 리스트로 저장
# 루트 노드 1인 부모-자식 트리라 하더라도
# 루트의 지름을 구하려면 임의의 노드에서
# 부모-자식 상하 관계에 구애받지 않고
# 모든 노드를 순회할 수 있어야하기때문.
for _ in range(n-1):
    parent, child, weight = map(int, input().split())
    tree[parent].append((child, weight))
    tree[child].append((parent, weight))
    
def DFS(node, cost):
    for adj_node, adj_w in tree[node]:
        cal_w = cost + adj_w
        if visited[adj_node] == -1:
            visited[adj_node] = cal_w
            DFS(adj_node, cal_w)
    
    return

# 첫 번째 DFS로 지름의 양 끝점 중 하나 구하기(성질 증명은 검색)
visited = [-1]*(n+1)
visited[1] = 0

DFS(1, 0)
idx, tmp = 0, 0
for i in range(1, len(visited)):
    if visited[i] > tmp:
        tmp = visited[i]
        idx = i

# 두 번째 DFS로 나머지 트리의 지름 끝점 하나를 찾고 지름 구하기
visited = [-1]*(n+1)
visited[idx] = 0
DFS(idx, 0)

print(max(visited))