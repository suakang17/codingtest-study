def solution(new_id):
    answer = ''
    new_id = new_id.lower()  # step1

    answer = ''  # step2
    for word in new_id:
        if word.isalnum() or word in '-_.':
            answer += word

    while '..' in answer:  # steo3
        answer = answer.replace('..', '.')

    answer = answer[1:] if answer.startswith('.') and len(answer) > 1 else answer
    answer = answer[:-1] if answer.endswith('.') else answer

    answer = 'a' if answer == '' else answer

    if len(answer) >= 16:
        answer = answer[:15]
        if answer.endswith('.'):
            answer = answer[:-1]

    if len(answer) <= 3:
        answer += answer[-1] * (3 - len(answer))

    return answer


print(solution('...!@BaT#*..y.abcdefghijklm'))