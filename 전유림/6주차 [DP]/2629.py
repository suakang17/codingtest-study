import sys
input = sys.stdin.readline

# 입력값 받기

num_pends = int(input()) # 추의 개수 (<= 30)
pends = list(map(int, input().split())) # 추 (오름차순, <= 500)
num_marbles = int(input()) # 구슬의 개수 (<= 7)
marbles = list(map(int, input().split())) # 구슬의 무게 (<= 40000)

# dp table 만들기

dp = [[0]*(30*500+1) for _ in range(num_pends+1)] 
# dp[i][j]  = i 번째 까지의 추를 놓았을 때, j 무게를 만들 수 있는지

result = set()

# 관련 함수 정의

def get_result(pends, n, now, left, right):
    """
    pends : 추 목록
    n : 전체 추의 개수
    now : 이제 놓을 추의 index
    left : 왼쪽 팔의 무게
    right : 오른쪽 팔의 무게
    """
    
    new = abs(left - right)
    # 처음 함수가 호출되었을 때의 무게를 잰다.

    if new not in result: # 처음 재는 무게라면
        result.add(new) # result에 추가

    if now == n : # 재귀 탈출 조건 (모든 추를 다 올려놓았을 때)
        return 0

    if dp[now][new] == 0: # now까지의 추로 아직 무게를 잰 적이 없다면
        get_result(pends, n, now+1, left + pends[now], right) # 왼쪽에 놓기
        get_result(pends, n, now+1, left, right + pends[now]) # 오른쪽에 놓기
        get_result(pends, n, now+1, left, right) # 놓지 않기
        dp[now][new] = 1 # 무게를 재었다고 표시

get_result(pends, num_pends, 0, 0, 0)
answer = []

for marble in marbles:
    if marble in result:
        answer.append("Y")
    else:
        answer.append("N")

print(*answer)