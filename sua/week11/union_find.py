def find(node):
    if parent[node] != node:  # not root
        return find(parent[node])
    else:
        return node  # return root


# 경로 압축(path compression) ver.
def find_compression(node):
    # if not root, root를 찾을 때까지 재귀적으로 호출
    if parent[node] != node:
        parent[node] = find_compression(parent[node])
    return parent[node]


def union(a, b):
    # 각각의 root
    a = find(a)
    b = find(b)

    if a < b:
        parent[b] = a
    else:
        parent[a] = b


v, e = map(int, input().split())  # v: 노드 수, e: 간선 수
parent = [0] * (v+1)  # 부모 테이블

for i in range(1, v+1):  # n번 노드가 값 n을 갖도록 초기화
    parent[i] = i

# 각 원소가 속한 집합 출력하기 (부모 타고 올라가 root)
print('각 원소가 속한 집합: ', end='')
for i in range(1, v + 1):
    print(find(i), end=' ')

print()

# 부모 테이블 내용 출력하기
print('부모 테이블: ', end='')
for i in range(1, v + 1):
    print(parent[i], end=' ')