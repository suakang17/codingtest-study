import sys
import math
import itertools 
get_line: iter = lambda: map(int, sys.stdin.readline().rstrip().split())
get_input: int = lambda: int(sys.stdin.readline().strip())

N = None
arr = None

def set_variable():
    global N, arr
    N = get_input()
    arr = [list(get_line()) for _ in range(N)]

def solution():
    global N, arr, ans
    s=sum(p:=[sum(i)+sum(j)for i,j in zip(arr,zip(*arr))])//2
    print(min(abs(s-sum(i))for i in itertools.combinations(p,int(N)//2)))
    print(p, "-p")
    print([i for i in itertools.combinations(p,int(N)//2)])
    for i,j in zip(arr,zip(*arr)):
        print(i, j)

if __name__ == "__main__":
    set_variable()
    solution()