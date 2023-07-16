def solution(numbers, hand):
    answer = ''
    # 위치 x, y
    keypad = {1: [0, 0], 2: [0, 1], 3: [0, 2], 4: [1, 0], 5: [1, 1], 6: [1, 2], 7: [2, 0], 8: [2, 1], 9: [2, 2],
              '*': [3, 0], 0: [3, 1], '#': [3, 2]}

    l = keypad['*']
    r = keypad['#']
    for num in numbers:
        if keypad[num][1] == 0:
            answer += 'L'
            l = keypad[num]
        elif keypad[num][1] == 2:
            answer += 'R'
            r = keypad[num]
        else:
            leftgap = sum([abs(a - b) for a, b in zip(keypad[num], l)])
            rightgap = sum([abs(a - b) for a, b in zip(keypad[num], r)])

            if leftgap > rightgap:
                answer += 'R'
                r = keypad[num]
            elif leftgap < rightgap:
                answer += 'L'
                l = keypad[num]
            else:
                if hand == 'left':
                    answer += 'L'
                    l = keypad[num]
                else:
                    answer += 'R'
                    r = keypad[num]

    return answer


numbers = [1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5]
hand = 'right'
print(solution(numbers, hand))