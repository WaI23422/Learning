
from ast import List
import math

# 175ms 29.45MB
class Solution:
    def minimumSize(self, nums: List[int], O: int) -> int:
        N = len(nums)
        S = sum(nums)
        G = N+O
        if G >= S: return 1

        def verify(v):
            return sum(math.ceil(n/v) for n in nums) <= G
        
        l = math.ceil(S/G)-1
        h = min(max(nums),math.floor(S/O))
        
        while l<h-1:
            m = (h+l)//2
            if verify(m): h=m
            else: l=m
        return h

# 866ms 29.53MB
class Solution:
    def minimumSize(self, nums, max_operations):
        # Binary search bounds
        left = 1
        right = max(nums)

        # Perform binary search to find the optimal max_balls_in_bag
        while left < right:
            middle = (left + right) // 2

            # Check if a valid distribution is possible with the current middle value
            if self._is_possible(middle, nums, max_operations):
                # If possible, try a smaller value (shift right to middle)
                right = middle
            else:
                # If not possible, try a larger value (shift left to middle + 1)
                left = middle + 1

        # Return the smallest possible value for max_balls_in_bag
        return left

    # Helper function to check if a distribution is possible for a given max_balls_in_bag
    def _is_possible(self, max_balls_in_bag, nums, max_operations):
        total_operations = 0

        # Iterate through each bag in the array
        for num in nums:
            # Calculate the number of operations needed to split this bag
            operations = math.ceil(num / max_balls_in_bag) - 1
            total_operations += operations

            # If total operations exceed max_operations, return False
            if total_operations > max_operations:
                return False

        # We can split the balls within the allowed operations, return True
        return True