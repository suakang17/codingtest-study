import sys


def cntodd(num: int):  # 자리수별 odd counting method
    oddcnt = 0
    while num:
        if (num % 10) % 2 != 0:
                oddcnt += 1
        num //= 10
    return oddcnt


def seq(n: str, total: int):
    if len(n) == 1:
        res.append(total)
        return

    if len(n) == 2:
        newnum = int(str(n)[0]) + int(str(n)[1])
        seq(str(newnum), total + cntodd(newnum))

    else:  # 임의의 위치에서 끊어 3개 수로 분할 -> 끊는 위치에 따라 최종값 분기 -> 분기별로 저장 & 비교 필요
        for i in range(1, len(str(n))):  # 브루트포스 # 같은 위치 끊으면 x
            for j in range(i + 1, len(str(n))):
                newnum = int(str(n)[:i]) + int(str(n)[i:j]) + int(str(n)[j:])
                seq(str(newnum), total + cntodd(newnum))


n = sys.stdin.readline().rstrip() # 1 ≤ N ≤ 10^9 - 1
res = []
seq(n, cntodd(int(n)))
print(min(res), max(res))

# math.inf