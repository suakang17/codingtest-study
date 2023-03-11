import sys
n = int(sys.stdin.readline())

# 마지막을 제외한 원판들을 모두 보조 장대에 놓는다.
# 마지막 원판을 목표 장대에 놓는다.
# 보조 장대에 있는 나머지 원판을 모두 목표 장대에 놓는다.

def hanoi(n,start, target, temp):
    if n == 1:
        print(start, target)
        return
    hanoi(n-1, start, temp, target)
    hanoi(1, start, target, temp)
    hanoi(n-1, temp, target, start)

print(2**n - 1)
hanoi(n, 1, 3, 2)