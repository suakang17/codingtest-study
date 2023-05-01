import sys
input = sys.stdin.readline
INF = sys.maxsize

n, m = map(int, input().split())  # 노드, 간선수
start = int(input())  # 시작 노드 number

graph = [[] for _ in range(n+1)]  # 인덱스 0 ~ n (n+1개)
visited = [False] * (n+1)  # 인덱스 0 ~ n (n+1개)
distance = [INF] * (n+1)  # n번 노드부터 1~n번 노드까지의 최단거리 저장할 table # 인덱스 0 ~ n (n+1개)

for _ in range(m):
    u, v, w = map(int, input().split())
    graph[u].append((v, w))  # (목적지 노드, 가중치)

# 방문하지 않은 노드 중 시작 노드로부터 가장 최단거리인 노드 인덱스 반환
def get_closest_node():
    min_value = INF
    index = 0  # 가장 최단거리 짧은 노드의 인덱스
    for i in range(1, n+1):
        if distance[i] < min_value and not visited[i]:  # not visited로 본인노드 제외도 됨
            min_value = distance[i]
            index = i

    return index


def dijkstra(start):
    distance[start] = 0
    visited[start] = True

    for i in graph[start]:
        distance[i[0]] = i[1]  # 목적지 노드까지의 거리 == 가중치

    for _ in range(n-1):
        now = get_closest_node()  # 가장 최단거리인 방문x 노드 인덱스
        visited[now] = True  # 해당 노드 방문처리

        for next_node in graph[now]:
            next_distance = distance[now] + next_node[1]
            if next_distance < distance[next_node[0]]:
                distance[next_node[0]] = next_distance


dijkstra(start)

for i in range(1, n+1):
    print("INF" if distance[i] == INF else distance[i])