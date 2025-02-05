from typing import List


class Solution:
    def func(self, s1: str, s2: str) -> bool:
        s1_len = len(s1)
        
        swap_count = 0
        swap_diff_pos = []*2
        for i in range(s1_len):
            if s1[i] != s2[i]:
                swap_count += 1
                swap_diff_pos.append(i)
        
        if swap_count%2 == 1 or swap_count/2 > 1:
            return False
        if swap_count/2 == 1 and (s1[swap_diff_pos[0]] != s2[swap_diff_pos[1]] or s1[swap_diff_pos[1]] != s2[swap_diff_pos[0]]):
            return False
        
        return True

    def func2 (self, s1: str, s2: str) -> bool:
        if s1==s2:
            return True
        if sorted(s1)!=sorted(s2):
            return False
        count=0
        for i in range(len(s1)):
            if s1[i]!=s2[i]:
                count+=1
        if count!=2:
            return False
        return True

if __name__ == "__main__":
    solution = Solution()
    testcase_list = [
        ["bank", "kanb"],
        ["attack", "defend"],
        ["kelb", "kelb"],
        ["abcd", "dcba"],
        ["kka", "akk"],
        ["caa","aaz"]
    ]

    ans_list = [True, False, True, False, True, False]

    for i in range(len(testcase_list)):
        print("Test case {}: {}".format(i, solution.func(
            testcase_list[i][0], testcase_list[i][1]) == ans_list[i]))
        print("Test result: {}".format(solution.func(
            testcase_list[i][0], testcase_list[i][1])))
        print("Expected result: {} \n".format(ans_list[i]))
