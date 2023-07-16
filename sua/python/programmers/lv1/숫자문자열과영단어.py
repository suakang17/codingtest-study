import sys

sys.setrecursionlimit(10 ** 6)


def strtonum(s):
    answer = ''
    numdict = {'zero': 0, 'one': 1, 'two': 2, 'three': 3, 'four': 4, 'five': 5, 'six': 6, 'seven': 7, 'eight': 8,
               'nine': 9}

    for i in range(len(s)):
        if s[i] in '0123456789':
            answer += s[i]
            if len(s[i + 1:]) != 0:
                answer += strtonum(s[i + 1:])
            return answer
        else:
            for j in range(len(s) - i + 1):
                if s[i:j] in numdict:
                    answer += str(numdict[s[i:j]])
                    if len(s[j:]) != 0:
                        answer += strtonum(s[j:])
                        return answer
                    else:
                        return answer


def solution(s):
    return int(strtonum(s))