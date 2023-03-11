import sys
n, k = map(int, sys.stdin.readline().split())
l = list(map(int, sys.stdin.readline().split()))
savedorder = []


def merge_sort(arr):
    if len(arr) == 1:
        return arr

    mid = (len(arr) + 1) // 2

    left = merge_sort(arr[:mid])
    right = merge_sort(arr[mid:])

    i = j = 0
    l2 = []
    while (len(left) > i) and (len(right) > j):
        if left[i] < right[j]:
          l2.append(left[i])
          savedorder.append(left[i])
          i += 1

        else:
            l2.append(right[j])
            savedorder.append(right[j])
            j += 1
    while i < len(left):
        l2.append(left[i])
        savedorder.append(left[i])
        i += 1
    while j < len(right):
        l2.append(right[j])
        savedorder.append(right[j])
        j += 1
    return l2

merge_sort(l)

if len(savedorder) >= k:
    print(savedorder[k-1])
else:
    print(-1)

print(savedorder)