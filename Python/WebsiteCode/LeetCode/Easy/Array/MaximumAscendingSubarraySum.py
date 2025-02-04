from typing import List

class Solution:
    def maxAscendingSum(self, nums: List[int]) -> int:
        preNum = 0
        maxSum = 0
        ascSum = preNum
        for num in nums:
            if num > preNum:
                ascSum += num
            else:
                maxSum = max(maxSum, ascSum)
                ascSum = num
            preNum = num
            
        return max(maxSum, ascSum)
    
    def maxAscendingSum2(self, nums: List[int]) -> int:
        result = 0
        cur = nums[0]

        for i in range(len(nums)-1):
            
            if nums[i] < nums[i+1]:
                cur += nums[i+1]
            else:
                result = max(cur, result)
                cur = nums[i+1]

        return max(cur, result)
                
if __name__ == "__main__":
    solution = Solution()
    nums_list = [
        [10, 20, 30, 5, 10, 50],
        [10, 20, 30, 40, 50],
        [12, 17, 15, 13, 10, 11, 12]
    ]
    
    ans_list = [65,150,33]
   
    for i in range(len(nums_list)):
        print("Test case {}: {}".format(i, solution.maxAscendingSum(nums_list[i]) == ans_list[i]))
        print("Test result: {}".format(solution.maxAscendingSum(nums_list[i])))
        print("Expected result: {} \n".format(ans_list[i]))
