import sys

N = int(sys.stdin.readline())


def star(n):
    if n == 1:
        return ['*']
    n = n // 3
    a = star(n)
    top = [i * 3 for i in a]
    middle = [i + ' ' * n + i for i in a]
    return top + middle + top


mystar = '\n'.join(star(N))
print(mystar)