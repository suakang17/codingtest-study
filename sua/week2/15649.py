import sys
ret = [] # 재귀함수를 이용하여 m개의 수열을 저장하기 위한 리스트

n, m = map(int, sys.stdin.readline().split())


def dfs():
    if len(ret) == m:  # 리스트에 들어간 수열들이 m개가 되면 리스트에 들어있는 숫자들을 모두 출력하고 함수 종료
        print(' '.join(map(str, ret)))
        return

    for i in range(1, n+1):  # 1부터 n까지의 숫자들을 모두 확인
        if i not in ret:  # 리스트 ret에 이미 있는 요소와 중복여부 확인
            ret.append(i)  # 중복이 아니면 숫자 i를 ret에 추가
            dfs()  # 현재 ret에 요소가 있는 상태에서 다음숫자를 넣기위하여 가지치기하기(재귀함수)
            ret.pop()


dfs()