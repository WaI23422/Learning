from pyparsing import List, deque

#  157ms 31.82MB
class Solution:
    def shortestSubarray(self, nums: List[int], k: int) -> int:
        shortest = float('inf')
        queue = deque([])
        total = currLen = 0

        for i,n in enumerate(nums):
            if n < 0:
                if total + n <= 0:
                    queue = deque([])
                    total = currLen = 0
                    continue
                
                else:
                    removed, removeLen = queue.pop()
                    curr = n + removed
                    stackLength = 1 + removeLen

                    while queue and curr < 0:
                        removed, removeLen = queue.pop()
                        curr += removed
                        stackLength += removeLen

                    total += n
                    queue.append((curr, stackLength))
                    currLen += 1
            
            else:
                queue.append((n, 1))
                total += n
                currLen += 1

            while queue and total >= k:
                shortest = min(shortest, currLen)
                removed, removeLen = queue.popleft()
                total -= removed
                currLen -= removeLen
        
        return shortest if shortest <= len(nums) else -1

        