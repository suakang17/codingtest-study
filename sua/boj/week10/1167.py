# "그래프에서 서로 가장 멀리 떨어져있는 두 노드는  임의의 한 노드에서 가장 떨어진 노드 중 하나이다" -> dfs 두 번
# 루트 노드 지정이 없으므로
import sys

input = sys.stdin.readline
sys.setrecursionlimit(10**9)


def solution(x, y):
    for next, weight in graph[x]:
        if visited[next] == -1:
            visited[next] = weight + y
            solution(next, visited[next])


if __name__ == "__main__":
    v = int(input())
    graph = [[] for _ in range(v+1)]

    for _ in range(v):
        w = list(map(int, input().split()))
        for i in range(1, len(w)-2, 2):
            graph[w[0]].append((w[i], w[i+1]))  # (연결노드, 가중치)

    visited = [-1 for _ in range(v+1)]  # 부모 노드 저장용 # 1은 시작노드로 0이라 방문 표기가 안되니 -1로 초기화
    visited[1] = 0
    solution(1, 0)  # 1번 노드 (특정 노드)시작 (시작 노드, 누적 가중치)

    start = visited.index(max(visited))
    visited = [-1 for _ in range(v+1)]  # 부모 노드 저장용 # 1은 시작노드로 0이라 방문 표기가 안되니 -1로 초기화
    visited[start] = 0
    solution(start, 0)

    print(max(visited))