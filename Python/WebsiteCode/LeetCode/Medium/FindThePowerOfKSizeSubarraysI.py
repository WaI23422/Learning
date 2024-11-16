# 1ms 16.85MB
from ast import List


class Solution:
    def resultsArray(self, nums, k):
        if k == 1:
            return nums  # If k is 1, every single element is a valid subarray

        length = len(nums)
        result = [-1] * (length - k + 1)
        consecutive_count = 1  # Count of consecutive elements

        for index in range(length - 1):
            if nums[index] + 1 == nums[index + 1]:
                consecutive_count += 1
            else:
                consecutive_count = 1  # Reset count if not consecutive

            # If we have enough consecutive elements, update the result
            if consecutive_count >= k:
                result[index - k + 2] = nums[index + 1]

        return result
    
# 0ms 16.69MB
class Solution:
    def resultsArray(self, nums: List[int], k: int) -> List[int]:
        if k == 1: return nums
        ans = []
        l, r = 0, 1
        n = len(nums)

        while r < n:
            if nums[r] - nums[r-1] != 1:
                while l < r and l + k - 1 < n:
                    ans.append(-1)
                    l+=1
                l = r
            elif r - l == k - 1:
                ans.append(nums[r])
                l += 1

            r += 1
        return ans