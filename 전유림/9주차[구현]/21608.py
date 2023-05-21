import sys
input = sys.stdin.readline

n = int(input())

seat = [[0] * (n+1) for _ in range(n+1)]

dy = [0, 1, 0, -1]
dx = [1, 0, -1, 0]

student = []
for _ in range(n**2):
    info = list(map(int, input().split()))
    now_student = info[0]
    like = info[1:]
    student.append(info)
    result = []

    for i in range (1, n+1):
        for j in range(1, n+1):
            if seat[i][j] == 0:
                cnt = 0
                empty = 0
                for k in range(4):
                    ny = i + dy[k]
                    nx = j + dx[k]
                    if 1 <= ny < n+1 and 1 <= nx < n+1:
                        if seat[ny][nx] in like:
                            cnt += 1
                        if seat[ny][nx] == 0:
                            empty += 1
                result.append((cnt, empty, i, j))
    result=sorted(result, key=lambda x: (-x[0], -x[1], x[2], x[3]))
    seat[result[0][2]][result[0][3]] = now_student

student.sort()

answer = 0
for i in range(1, n+1):
    for j in range(1, n+1):
        cnt = 0
        for k in range(4):
            ny = i + dy[k]
            nx = j + dx[k]
            if 1 <= ny < n+1 and 1 <= nx < n+1:
                if seat[ny][nx] in student[seat[i][j]-1][1:]:
                    cnt += 1
        if cnt != 0:
            answer += 10**(cnt-1)

print(answer)