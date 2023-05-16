import sys

# 1/11 성공

input = sys.stdin.readline


# attack
def attack(action, d, b):
    _x, _y = action

    # 해당 도미노가 이미 넘어져 있는 경우
    if b[_x][_y] == 'F':
        return b, 0

    s = 0
    cnt = board[_x][_y]  # 넘어질 도미노의 길이 == 넘어질 도미노 개수

    while cnt:
        # 좌표는 board 사이즈 이내이도록
        if not 0 <= _x < n or not 0 <= _y < m:
            break

        # 넘어뜨리기
        if b[_x][_y] == 'S':  # 서있는 경우
            b[_x][_y] = 'F'
            s += 1

            cnt = max(cnt, board[_x][_y])  # 현재 넘어져야 하는 도미노 갯수와 지금 넘어진 도미노의 높이를 비교, 더 큰 수로 갱신

        _x, _y = _x + dx[d], _y + dy[d]
        cnt -= 1

    return b, s


def defence(action, b):
    _x, _y = action
    b[_x][_y] = 'S'
    
    return b


if __name__ == "__main__":
    n, m, r = map(int, input().split())
    board = [list(map(int, input().split())) for _ in range(n)]

    # 좌우상하
    dx = [0, 0, -1, 1]  # m, 행
    dy = [-1, 1, 0, 0]  # n, 열
    direction = {'W': 0, 'E': 1, 'N': 2, 'S': 3}
    board_process, attack_score = [['S'] * m for _ in range(n)], 0  # 서-앉아있는 게임 진행 보드, 공격자 점수

    for _ in range(r):
        # attack input
        attack_x, attack_y, attack_d = map(str, input().split())
        attack_x, attack_y, attack_d = int(attack_x) - 1, int(attack_y) - 1, direction[attack_d]

        # attack
        board_process, score = attack((attack_x, attack_y), attack_d, board_process)

        # defence input
        defence_x, defence_y = map(int, input().split())
        defence_x, defence_y = defence_x - 1, defence_y - 1  # 인덱스 0부터

        # defence
        board_process = defence((defence_x, defence_y), board_process)

        # score
        attack_score += score

    # result
    print(attack_score)
    for i in range(n):
        print(''.join(map(str, board_process[i])))


# 2
import sys


# 공격
def attack(coordinate, d, _board):
    _x, _y = coordinate
    # 보드의 공격좌표 도미노가 이미 넘어져 있는 경우 함수 실행 중지
    if _board[_x][_y] == 'F':
        return _board, 0

    _score = 0
    count = game_board[_x][_y]  # 넘어질 도미노 높이 = 넘어져야 하는 도미노 갯수
    while count:

        # 좌표가 게임판을 벗어나는 경우 반복문 중지
        if not 0 <= _x < N or not 0 <= _y < M:
            break

        # 도미노를 넘어뜨린다
        if _board[_x][_y] == 'S':  # 현재 좌표의 도미노가 서 있는 경우
            _board[_x][_y] = 'F'  # 'F'상태(넘어진 상태)로 바꿔준다
            _score += 1  # 넘어졌으므로 공격자의 점수 +1

            # 넘어질 도미노 갯수 업데이트
            # 현재 넘어져야 하는 도미노 갯수와 지금 넘어진 도미노의 높이를 비교, 더 큰 수로 갱신
            count = max(count, game_board[_x][_y])

        # 공격 방향으로 좌표 이동
        _x, _y = _x + dx[d], _y + dy[d]
        # 넘어져야 하는 도미노 갯수 -1
        count -= 1

    # 공격 동작 후 도미노 게임판 상태, 공격 점수 반환
    return _board, _score


# 방어
def defend(coordinate, _board):
    _x, _y = coordinate
    # 방어 좌표의 도미도를 'S'상태(서 있는 상태)로 바꿔줌
    _board[_x][_y] = 'S'

    # 방어 동작 후 도미노 게임판 상태 반환
    return _board


input_func = sys.stdin.readline
if __name__ == '__main__':
    # 데이터 입력
    N, M, R = map(int, input_func().split())
    game_board = [list(map(int, input_func().split())) for _ in range(N)]

    # 좌표 설정
    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0]
    direction = {'E': 0, 'W': 1, 'S': 2, 'N': 3}  # 각 문자에 따라 좌표 인덱스 매치
    moving_board, attack_score = [['S'] * M for _ in range(N)], 0  # 전부 서 있는 초기 도미노 게임판 생성, 게임 점수 0

    # 명령어 갯수만큼 라운드 반복
    for _ in range(R):
        # 공격동작 입력
        attack_x, attack_y, attack_d = map(str, input_func().split())
        attack_x, attack_y, attack_d = int(attack_x) - 1, int(attack_y) - 1, direction[
            attack_d]  # 인덱스를 0부터 시작하도록 -1, 방향 문자에 따라 좌표 인덱스 설정

        # 공격
        moving_board, score = attack((attack_x, attack_y), attack_d, moving_board)

        # 방어동작 입력
        defend_x, defend_y = map(int, input_func().split())
        defend_x, defend_y = defend_x - 1, defend_y - 1  # 인덱스 0부터 시작하도록 -1

        # 방어
        moving_board = defend((defend_x, defend_y), moving_board)

        # 공격자의 총 점수 갱신
        attack_score += score

    # 결과 출력
    print(attack_score)
    for idx in range(N):
        print(' '.join(map(str, moving_board[idx])))
