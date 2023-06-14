import sys
n = int(sys.stdin.readline())
ns = sorted(list(map(int, sys.stdin.readline().split())))
m = int(sys.stdin.readline())
ms = list(map(int, sys.stdin.readline().split()))

def bs(arr, target, start, end):
    mid = (start + end) // 2
    if start > end:
        return 0
    elif arr[mid] == target:
        return arr[start:end+1].count(target)
    elif arr[mid] > target:
        return bs(arr, target, start, mid-1)
    else:
        return bs(arr, target, mid+1, end)


n_dic = {}
for each in ns:
    start = 0
    end = len(ns) - 1
    if n not in n_dic:
        n_dic[n] = bs(ns, each, start, end)

print(' '.join(str(n_dic[x]) if x in n_dic else '0' for x in ms))

# 앞 뒤 인덱스 확인
def bs(arr, target, start, end):
    if start > end:
        return 0
    mid = (start + end) // 2
    if arr[mid] == target:
        i, j = 0, 0
        while mid - i >= start:
            if arr[mid] != arr[mid - i]:
                break
            else: i += 1
        while mid + j <= end:
            if arr[mid] != arr[mid + j]:
                break
            else: j += 1
        return i + j - 1
    elif arr[mid] > target:
        return bs(arr, target, start, mid - 1)
    else:
        return bs(arr, target, mid + 1, end)

n_dic = {}
for each in ns:
    start = 0
    end = len(ns) - 1
    if n not in n_dic:
        n_dic[n] = bs(ns, each, start, end)

print(' '.join(str(n_dic[x]) if x in n_dic else '0' for x in ms))

# 3 - 순서대로 숫자 세어 나가기 https://chancoding.tistory.com/45
index, m_dic = 0, {}

for m in sorted(ms):
    cnt = 0
    if m not in m_dic:
        while index < len(ns):
            if m == ns[index]:
                cnt += 1; index += 1
            elif m > ns[index]:
                index += 1
            else: break
        m_dic[m] = cnt

print(' '.join(str(m_dic[m]) for m in ms))

# 시간 초과
# import sys
# n = int(sys.stdin.readline())
# ns = sorted(list(map(int, sys.stdin.readline().split())))
# m = int(sys.stdin.readline())
# ms = list(map(int, sys.stdin.readline().split()))
#
#
# def bs(arr, target, start, end):
#     mid = (start + end) // 2
#     if start > end:
#         return 0
#     elif arr[mid] == target:
#         return arr[start:end+1].count(target)
#     elif arr[mid] > target:
#         return bs(arr, target, start, mid-1)
#     else:
#         return bs(arr, target, mid+1, end)
#
# for each in ms:
#     start = 0
#     end = len(ns) - 1
#     print(bs(ns, each, start, end), end = " ")