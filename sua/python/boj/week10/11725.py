# DFS
import sys

input = sys.stdin.readline
sys.setrecursionlimit(10**6)


def solution(arr, visited, start):
    for i in arr[start]:
        if not visited[i]:
            visited[i] = start  # visited를 1로 방문처리하는게 아니라 부모 노드 붙여줌
            solution(arr, visited, i)


if __name__ == "__main__":
    n = int(input())
    graph = [[] for _ in range(n+1)]
    visited = [0 for _ in range(n+1)]

    for _ in range(n-1):
        a, b = map(int, input().split())
        graph[a].append(b)
        graph[b].append(a)

    solution(graph, visited, 1)

    for i in range(2, n+1):
        print(visited[i])


# BFS
import sys
from collections import deque

input = sys.stdin.readline


def bfs():
    while queue:
        now = queue.popleft()  # now와 연결된 노드 중에서 미방문한 노드의 result[next]값에 now(부모노드) 넣기
        for next in graph[now]:
            if not result[next]:
                result[next] = now
                queue.append(next)


if __name__ == "__main__":
    n = int(input())
    graph = [[] for _ in range(n+1)]
    for _ in range(n-1):
        a, b = map(int, input().split())
        graph[a].append(b)
        graph[b].append(a)

    queue = deque()
    queue.append(1)

    result = [0 for _ in range(n+1)]

    bfs()

    for i in range(2, n+1):
        print(result[i])