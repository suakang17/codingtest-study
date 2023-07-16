import sys
from collections import deque

input = sys.stdin.readline
sys.setrecursionlimit(10**9)
# 트리: 사이클 x
# 정점 n개 간선 n-1개
# 임의의 두 정점에 대해 경로 유일

# start 부터 bfs통해 graph순회 -> 사이클 여부 return
def findCycle(start):
    isCycle = 0
    q = deque()
    q.append(start)

    while q:
        now = q.popleft()
        if visited[now]:
            isCycle = 1

        visited[now] = 1

        for next in graph[now]:
            if not visited[next]:
                q.append(next)

    return isCycle

if __name__ == "__main__":
    case = 1
    while True:
        n, m = map(int, input().split())  # n개 정점, m개 간선
        if n == 0 and m == 0:
            break

        graph = [[] for _ in range(n+1)]
        visited = [0 for _ in range(n+1)]
        cnt = 0

        for _ in range(m):
            a, b = map(int, input().split())  # 간선 정보
            graph[a].append(b)
            graph[b].append(a)

        for i in range(1, n+1):
            if not visited[i]:
                if not findCycle(i):
                    cnt += 1

        if cnt == 0:
            print(f'Case {case}: No trees.')
        elif cnt == 1:
            print(f'Case {case}: There is one tree.')
        else:
            print(f'Case {case}: A forest of {cnt} trees.')

        case += 1