import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**9)

arr = []
while True:
    try:
        arr.append(int(input()))
    except:
        break

def postorder(start, end):
    if start > end:
        return
    mid = end + 1
    for i in range(start+1, end+1):
        if arr[start] < arr[i]:
            mid = i
            break
    postorder(start+1, mid-1)
    postorder(mid, end)
    print(arr[start])
postorder(0, len(arr)-1)