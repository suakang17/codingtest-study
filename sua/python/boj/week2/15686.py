import sys

def cal():
    tmp = 0
    for hx, hy in house:
        distance = 1e9
        for e, (cx, cy) in t_ch:
            distance = min(distance, abs(hx - cx) + abs(hy - cy))
        tmp += distance
    result.append(tmp)

def select_chicken(cnt):
    if cnt == m:
        cal()
        return

    for e, (cx, cy) in enumerate(chicken):
        if visited[cx][cy] == 0:
            if t_ch:
                if e < t_ch[-1][0]:
                    continue

            visited[cx][cy] = 1
            t_ch.append((e, (cx,cy)))
            select_chicken(cnt + 1)
            visited[cx][cy] = 0
            t_ch.pop()



n, m = map(int, sys.stdin.readline().split())
l = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
house = []
chicken = []
visited = [[0] * n for _ in range(n)]
t_ch = []
result = []

for i in range(n):
    for j in range(n):
        if l[i][j] == 1:
            house.append((i, j))
        elif l[i][j] == 2:
            chicken.append((i, j))

select_chicken(0)
print(min(result))