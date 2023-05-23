import sys

input = sys.stdin.readline
sys.setrecursionlimit(10**6)


def solution(s, e):
    # pre 첫요소: 최상위 root
    # 작아지다가 커짐 -> 왼, 오 subtree 나누는 지점
    # 루트 값을 기준으로 루트보다 큰 값이 존재하면 그 값을 기준으로 왼쪽, 오른쪽 트리를 나누기
    if s > e:
        return

    mid = e + 1

    for i in range(s+1, e+1):
        if preorder[s] < preorder[i]:
            mid = i
            break

    solution(s+1, mid-1)  # 왼쪽트리
    solution(mid, e) # 오른쪽트리
    print(preorder[s])  #


if __name__ == "__main__":
    preorder = []  # 50 30 24 5 / 28 / 45 / 98 52 / 60
    while True:
        try:
            preorder.append(int(input()))
        except:
            break

    solution(0, len(preorder)-1)