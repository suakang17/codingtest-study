def solution(park, routes):
    # 시작시점 찾기 (i, j)
    si, sj = findStart(park)
    ret = list(move(park, routes, si, sj))

    return ret


def findStart(park):  # O(N) == 2500
    sizeX = len(park)
    sizeY = len(park[0])

    for i in range(sizeX):
        for j in range(sizeY):
            if park[i][j] == 'S':
                return i, j


def move(park, routes, si, sj):

    for r in routes:
        dir, cnt = r.split()
        cnt = int(cnt)
        c = 0
        x = si
        y = sj

        while c < cnt:
            if dir == "E":
                yy = y + 1
                if yy in range(len(park[0])) and park[x][yy] != 'X':
                    y = yy
                    c += 1
                    continue
                else:
                    break

            elif dir == "W":
                yy = y - 1
                if yy in range(len(park[0])) and park[x][yy] != 'X':
                    y = yy
                    c += 1
                    continue
                else:
                    break

            elif dir == "S":
                xx = x + 1
                if xx in range(len(park)) and park[xx][y] != 'X':
                    x = xx
                    c += 1
                    continue
                else:
                    break

            elif dir == "N":
                xx = x - 1
                if xx in range(len(park)) and park[xx][y] != 'X':
                    x = xx
                    c += 1
                    continue
                else:
                    break
        if c == cnt:
            si = x
            sj = y


    return si, sj


park = ["OSO","OOO","OXO","OOO"]
routes = ["E 2","S 3","W 1"]
print(solution(park, routes))