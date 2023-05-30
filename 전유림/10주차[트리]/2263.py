import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

n = int(input())
inorder = list(map(int, input().split()))
postorder = list(map(int, input().split()))

node = [0] * (n+1)
for i in range(n):
    node[inorder[i]] = i

def preorder(in_start, in_end, post_start, post_end):
    if in_start > in_end or post_start > post_end:
        return
    root = postorder[post_end]
    print(root, end=' ')
    p = node[root]
    left = p - in_start
    preorder(in_start, p-1, post_start, post_start+left-1)
    preorder(p+1, in_end, post_start+left, post_end-1)

preorder(0, n-1, 0, n-1)