import sys

input = sys.stdin.readline


def preorder(root):
    if root != '.':
        print(root, end='')
        preorder(graph[root][0])
        preorder(graph[root][1])


def inorder(root):
    if root != '.':
        inorder(graph[root][0])
        print(root, end='')
        inorder(graph[root][1])


def postorder(root):
    if root != '.':
        postorder(graph[root][0])
        postorder(graph[root][1])
        print(root, end='')


if __name__ == "__main__":
    n = int(input())
    graph = {}

    for _ in range(n):
        root, left, right = input().strip().split()
        graph[root] = [left, right]  # [0]: left, [1]: right

    preorder('A')
    print()
    inorder('A')
    print()
    postorder('A')