# 시간초과 -> pypy3 성공
# # 놓지 못하는 경우
# # 1. 같은 열에 이미 다른 퀸 존재시
# # 2. 대각선에 이미 다른 퀸 존재시 -> 0,0 부터 위치시키므로 i보다 작은 값의 위치만 확인하면 됨
import sys


def isPromise(x):  # x와 i 가 같으면 행이 같은거 근데 for문을 보면 x와 i가 같을 수가 없다.
    for i in range(x):  # 인덱스가 행  row[n]값이 열
        if board[x] == board[i] or abs(board[x] - board[i]) == x - i:  # 열이 같거나 대각선이 같으면 false
            return False  # 대각선이 같은경우는 두 좌표에서 행 - 행 = 열 - 열 이 같으면 두개는 같은 대각선상에 있다.
    return True


# 한줄씩 재귀하며 dfs 실행


def nqueen(x):
    global ans

    if x == n:
        ans += 1
    else:
        # 각 행에 퀸 놓기
        for i in range(n):  # i 는 열번호 0부터 N 전까지 옮겨가면서 유망한곳 찾기
            board[x] = i
            if isPromise(x):  # 행,열,대각선 체크함수 true이면 백트래킹 안하고 계속 진행
                nqueen(x + 1)



n = int(sys.stdin.readline())
board = [0] * n
ans = 0

nqueen(0)
print(ans)
