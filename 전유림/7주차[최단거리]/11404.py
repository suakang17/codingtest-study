import sys
input = sys.stdin.readline
INF = sys.maxsize

n = int(input())
m = int(input())
graph = [[INF] * (n+1) for _ in range (n+1)]
for _ in range (m):
    a, b, c = map(int, input().split())
    graph[a][b] = min(graph[a][b], c)

def floyd_warshall():
    for k in range (1, n+1):    # k: 거쳐가는 노드
        for i in range (1, n+1):    # i: 출발 노드
            for j in range (1, n+1):    # j: 도착 노드
                if i == j:  # 출발 노드와 도착 노드가 같다면
                    graph[i][j] = 0
                else:  
                    # 최단 거리 갱신
                    graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])   

floyd_warshall()

for i in range (1, n+1):    # i: 출발 노드
    for j in range (1, n+1):    # j: 도착 노드
        if graph[i][j] == INF:  # 도달할 수 없는 경우
            print(0, end=" ")
        else:
            print(graph[i][j], end=" ")
    print()