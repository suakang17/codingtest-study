import sys

get_line: iter = lambda: map(int, sys.stdin.readline().rstrip().split())
get_input: int = lambda: int(sys.stdin.readline().strip())

s1 = None
s2 = None
cnt_arr = None

def set_variable():
    global s1, s2, cnt_arr
    s1 = sys.stdin.readline().rstrip()
    s2 = sys.stdin.readline().rstrip()
    cnt_arr = [[0] * (len(s2) + 1) for _ in range(len(s1) + 1)]  

def solution():
    global s1, s2
    for i in range(1, len(s1) + 1):
        for j in range(1, len(s2) + 1):
            if s1[i-1] == s2[j-1]:
                cnt_arr[i][j] = cnt_arr[i-1][j-1] + 1
            else:
                cnt_arr[i][j] = max(cnt_arr[i][j-1], cnt_arr[i-1][j])
    
    print(cnt_arr[-1][-1])
            


if __name__ == "__main__":
    set_variable()
    solution()