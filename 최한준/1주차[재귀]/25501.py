import sys

get_line: iter = lambda: map(int, sys.stdin.readline().rstrip().split())
get_input: int = lambda: int(sys.stdin.readline().strip())

N = None
cnt = None
S = None
def recursion(s, l, r):
    global cnt
    cnt += 1
    if l >= r: return 1
    elif s[l] != s[r]: return 0
    else: return recursion(s, l+1, r-1)

def isPalindrome(s):
    global cnt 
    cnt = 0
    return recursion(s, 0, len(s)-1)


def set_variable():
    global N, cnt
    N = get_input()

def solution():
    global N, cnt, S
    for _ in range(N):
        S = sys.stdin.readline().rstrip()
        print(isPalindrome(S), cnt)

if __name__ == "__main__":
    set_variable()
    solution()