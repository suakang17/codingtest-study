def solution(board, moves):
    answer = 0
    basket = []
    # board[i][j]  (i, j)
    for m in moves:
        for i in range(len(board)):
            if board[i][m - 1] != 0:
                if len(basket) != 0 and basket[-1] == board[i][m - 1]:
                    board[i][m - 1] = 0
                    del basket[-1]
                    answer += 2
                    break
                basket.append(board[i][m - 1])
                board[i][m - 1] = 0
                break

    return answer