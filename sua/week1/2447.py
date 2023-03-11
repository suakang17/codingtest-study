import sys

# 패턴 반복 -> 재귀
# 패턴: 가운데 n/3*n/3크기의 정사각형을 n/3의 패턴으로 감싸기
# 별 하나하나를 기본 패턴으로 치환


def printstar(n):
    if n == 1:
        return ['*']
    stars = printstar(n // 3)
    l = []

    for s in stars:
        l.append(s * 3)
    for s in stars:
        l.append(s + ' '*(n//3) + s)
    for s in stars:
        l.append(s * 3)
    return l


n = int(sys.stdin.readline())
print('\n'.join(printstar(n)))