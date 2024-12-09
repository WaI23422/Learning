# 20ms 46.68MB
from ast import List


class Solution:
    def isArraySpecial(self, nums: List[int], queries: List[List[int]]) -> List[bool]:
        
        runningSum = 0
        partialSum = []
        oddEven = None

        for num in nums:
            if num % 2 == oddEven:
                runningSum += 1
            oddEven = num % 2
            partialSum.append(runningSum)

        out = []

        for start, end in queries:
            if partialSum[start] == partialSum[end]:
                out.append(True)
            else:
                out.append(False)
        return out
    
# 32ms 46.41MB
class Solution:
    def isArraySpecial(self, nums, queries):
        n = len(nums)
        pref = [1] * n
        for i in range(1, n):
            if (nums[i] & 1) != (nums[i - 1] & 1):
                pref[i] = pref[i - 1] + 1
            else:
                pref[i] = 1

        ans = []
        for s, e in queries:
            length = e - s + 1
            if pref[e] < length:
                ans.append(False)
            else:
                ans.append(True)
        return ans