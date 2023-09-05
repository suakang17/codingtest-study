import sys

N, C = map(int, sys.stdin.readline().split())
weight = list(map(int, sys.stdin.readline().split())) 
left = weight[:N // 2]  # N // 2보다 작은 인덱스
right = weight[N // 2:]     # N // 2보다 크거나 같은 인덱스
lsum = [] 
rsum = [] 

def bruteforce(st, end, warr, sumarr): 
    if st >= len(warr):     # st가 배열의 길이보다 크거나 같으면
        sumarr.append(end)  # sumarr에 end를 추가하고
        return     
    bruteforce(st + 1, end, warr, sumarr)       # st번째 물건을 선택하지 않는 경우
    bruteforce(st + 1, end + warr[st], warr, sumarr)    # st번째 물건을 선택하는 경우
 
def binarysearch(start, end, arr, target):   # 이분 탐색
    while start < end:
        mid = (start + end) // 2 
        if arr[mid] <= target: 
            start = mid + 1 
        else: 
            end = mid 
    return end 

bruteforce(0, 0, left, lsum) 
bruteforce(0, 0, right, rsum) 
rsum.sort() 

result = 0 
for i in lsum: 
    if C - i >= 0: 
        result += binarysearch(0, len(rsum), rsum, C - i) 
    
print(result)