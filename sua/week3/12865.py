# 주어진 데이터 내 가치 최댓값 -> dp
import sys
n, k = map(int, sys.stdin.readline().split())
w_v = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]  # w_v[i][0]: i번 보석 무게, w_v[i][1]: i번 보석 가치 ! 해당 리스트 인덱싱은 0부터
d = [[0 for _ in range(k+1)] for _ in range(n+1)]  # d[n][k] n번 보석 / 용량 k


def knapsack(k, n):
    for i in range(n+1):
        for w in range(k+1):
            if i == 0 or w == 0:  # 담을 보석이 x or 담을 여유 무게 x
                d[i][w] = 0
            elif w_v[i-1][0] <= w:  # 대상 보석을 담을 수 있는 경우 (대상 보석만큼의 여유 무게 o)
                d[i][w] = max(w_v[i-1][1] + d[i-1][w-w_v[i-1][0]], d[i-1][w])  # 대상보석가치+대상보석담을여유무게있는상태의최적값 vs. 대상보석안담는경우최적값
            elif w_v[i-1][0] > w:  # 대상 보석을 못담는 경우 (대상 보석만큼의 여유 무게 x)
                d[i][w] = d[i-1][w]
    return d[n][k]

print(knapsack(k,n))