import unittest

# 137 ms 19.3 MB
class Solution(object):
    def reverseString(self, s):
        """
        :type s: List[str]
        :rtype: None Do not return anything, modify s in-place instead.
        """
        for i in range(len(s) // 2):
            temp = s[i]
            s[i] = s[-1 -i]
            s[-1 -i] = temp


# 126 ms 19.2 MB   
class Solution2(object):
    def reverseString(self, s):
        """
        :type s: List[str]
        :rtype: None Do not return anything, modify s in-place instead.
        """
        left = 0
        right = len(s)-1
        while left < right:
            s[left], s[right] = s[right], s[left]
            left += 1
            right -= 1
        
        
# class TestReverseString(unittest.TestCase):
#     def setUp(self):
#         self.solution = Solution()

#     def test_reverse_string(self):
#         test_cases = [
#             (["h", "e", "l", "l", "o"], ["o", "l", "l", "e", "h"]),
#             (["H", "a", "n", "n", "a", "h"], ["h", "a", "n", "n", "a", "H"]),
#             (["A"], ["A"]),
#             ([], []),
#             (["a", "b"], ["b", "a"])
#         ]

#         for i, (input_list, expected_output) in enumerate(test_cases):
#             with self.subTest(test=i):
#                 self.solution.reverseString(input_list)
#                 self.assertEqual(input_list, expected_output)
#                 print(input_list)

if __name__ == "__main__":
    tests = [
        ["h", "e", "l", "l", "o"]   
    ]
    
    for test in tests:
        Solution().reverseString(test)
        print(test)