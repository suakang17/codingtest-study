import sys

get_line: iter = lambda: map(int, sys.stdin.readline().rstrip().split())
get_input: int = lambda: int(sys.stdin.readline().strip())

N, M = None, None
card = None
query = None

def set_variable():
    global N, M, card, query
    N = get_input()
    card = sorted(list(get_line()))
    M = get_input()
    query = list(get_line())


def solution():
    global query
    def lower_bound(L, R, num):
        global card
        while L + 1 < R:
            mid = (L + R) // 2
            if card[mid] >= num: R = mid# F...F|T...T 이므로 오른쪽을 내림.
            else : L = mid
        return R # index pos

    def upper_bound(L, R, num):
        global card
        while L + 1 < R:
            mid = (L + R) // 2
            if card[mid] > num: R = mid# F...F|T...T 이므로 오른쪽을 내림.
            else : L = mid
        return R # index pos
    
    for q in query:
        # print(upper_bound(-1, N, q), lower_bound(-1, N, q), upper_bound(-1, N, q) - lower_bound(-1, N, q))
        print(upper_bound(-1, N, q) - lower_bound(-1, N, q), end=" ")

if __name__ == "__main__":
    set_variable()
    solution()