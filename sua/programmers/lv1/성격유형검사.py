def solution(survey, choices):
    type_dict = {"A": 0, "N": 0, "C": 0, "F": 0, "R": 0, "T": 0, "J": 0, "M": 0}
    c_dict = {1: "3 0", 2: "2 0", 3: "1 0", 4: "0 0", 5: "0 1", 6: "0 2", 7: "0 3"}

    for i in range(len(choices)):
        a, b = survey[i][0], survey[i][1]  # A N
        x, y = map(int, c_dict[choices[i]].split())  # 0 1
        type_dict[a] += x
        type_dict[b] += y

    return makechoice(type_dict)


def makechoice(type_dict):
    answer = ""
    # RT CF JM AN
    answer += 'R' if type_dict['R'] >= type_dict['T'] else 'T'
    answer += 'C' if type_dict['C'] >= type_dict['F'] else 'F'
    answer += 'J' if type_dict['J'] >= type_dict['M'] else 'M'
    answer += 'A' if type_dict['A'] >= type_dict['N'] else 'N'
    return answer


    # ret = []
    # # RT CF JM AN
    # if type_dict["R"] > type_dict["T"]:
    #     ret.append("R")
    # elif type_dict["T"] > type_dict["F"]:
    #     ret.append("T")
    # else:
    #     ret.append("R")
    #
    # if type_dict["C"] > type_dict["F"]:
    #     ret.append("C")
    # elif type_dict["F"] > type_dict["C"]:
    #     ret.append("F")
    # else:
    #     ret.append("C")
    #
    # if type_dict["J"] > type_dict["M"]:
    #     ret.append("J")
    # elif type_dict["M"] > type_dict["J"]:
    #     ret.append("M")
    # else:
    #     ret.append("J")
    #
    # if type_dict["A"] > type_dict["N"]:
    #     ret.append("A")
    # elif type_dict["N"] > type_dict["A"]:
    #     ret.append("N")
    # else:
    #     ret.append("A")
    # return ret