
from ast import List

# 52ms 19.13MB
class Solution:
    def maxCount(self, banned: List[int], n: int, maxSum: int) -> int:
        ans = 0
        temp = 0
        banned = set(banned)
        for i in range(1, n + 1):
            if temp >= maxSum or temp + i > maxSum: break
            elif i not in banned:
                temp += i
                ans += 1
        return ans

# 43ms 19.09MB
class Solution:
    def maxCount(self, banned: list[int], n: int, maxSum: int) -> int:
        # Store banned numbers in a set for quick lookup
        banned_set = set(banned)

        count = 0

        # Try each number from 1 to n
        for num in range(1, n + 1):
            # Skip banned numbers
            if num in banned_set:
                continue

            # Return if adding the current number exceeds maxSum
            if maxSum - num < 0:
                return count

            # Include current number
            maxSum -= num
            count += 1

        return count