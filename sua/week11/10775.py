import sys

input = sys.stdin.readline


def find(airplane):
    stack = [airplane]

    while True:
        parking_gate = alters[airplane]

        if parking_gate == airplane:
            break
        else:
            stack.append(parking_gate)
            airplane = alters[parking_gate]

    while stack:
        temp = stack.pop()
        alters[temp] = parking_gate

    return parking_gate


def merge(a,b):
    a_root = find(a)
    b_root = find(b)

    alters[a_root] = b_root


if __name__ == "__main__":
    g = int(input())
    p = int(input())
    airplanes = [int(input()) for _ in range(p)]

    alters = list(range(g + 1))

    cnt = 0

    for i in range(p):
        airplane = airplanes[i]
        root = find(airplane)

        if root == 0:
            break

        merge(root, root-1)
        cnt += 1

    print(cnt)
