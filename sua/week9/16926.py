import sys
input = sys.stdin.readline

n,m,r = map(int,input().split())

data = [list(map(int,input().split())) for _ in range(n)]

for _ in range(r):
    for i in range(min(n, m) // 2):
    	# x, y 는 돌려지는 배열중 가장 첫번째 배열 인덱스
        x, y = i, i
        temp = data[x][y]
                            # 안쪽까지 계속 고려해야하기 때문에 n-i랑 m-i까지로 범위설정
        for j in range(i + 1, n - i):  #좌
            x = j
            prev_value = data[x][y]
            data[x][y] = temp
            temp = prev_value

        for j in range(i + 1, m - i):  #하
            y = j
            prev_value = data[x][y]
            data[x][y] = temp
            temp = prev_value

        for j in range(i + 1, n - i):  #우
            x = n - j - 1
            prev_value = data[x][y]
            data[x][y] = temp
            temp = prev_value

        for j in range(i + 1, m - i):  #상
            y = m - j -1
            prev_value = data[x][y]
            data[x][y] = temp
            temp = prev_value

for i in range(n):
    for j in range(m):
        print(data[i][j], end=' ')
    print()