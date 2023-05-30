import sys
input = sys.stdin.readline

n = int(input())
tree = {}

for _ in range(n):
    parents, left, right = sys.stdin.readline().rstrip().split()
    tree[parents] = [left, right]

# 전위순회
def preorder(parents):
    if parents != ".":
            print(parents, end="")
            preorder(tree[parents][0])
            preorder(tree[parents][1])

# 중위
def inorder(parents):  
    if parents != ".":
        inorder(tree[parents][0])
        print(parents, end="")
        inorder(tree[parents][1])

# 후위
def postorder(parents):  
    if parents != ".":
        postorder(tree[parents][0])
        postorder(tree[parents][1])
        print(parents, end="")



preorder("A")
print()
inorder("A")
print()
postorder("A")
print()
