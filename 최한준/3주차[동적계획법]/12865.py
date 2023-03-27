import sys

get_line: iter = lambda: map(int, sys.stdin.readline().rstrip().split())
get_input: int = lambda: int(sys.stdin.readline().strip())

N, K = None, None
bag = None
max_value = None

def set_variable():
    global N, K, bag, max_value
    N, K = get_line()
    bag = list()
    max_value = [0 for _ in range(K+1)]
    for _ in range(N):
        w, v = get_line()
        bag.append((w, v))

def solution():
    global N,K, bag, max_value
    for w, v in bag:
        for j in range(K, 0, -1):
            if w <= j:
                max_value[j] = max(max_value[j], max_value[j - w] + v)
           
         
    print(max(max_value))
            

if __name__ == "__main__":
    set_variable()
    solution()