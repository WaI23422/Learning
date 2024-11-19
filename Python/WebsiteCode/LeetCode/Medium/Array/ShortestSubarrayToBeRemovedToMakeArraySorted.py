from pyparsing import List

# 11ms
class Solution:
    def findLengthOfShortestSubarray(self, arr: List[int]) -> int:
        n, left=len(arr), 0
        while left+1<n and arr[left]<=arr[left+1]: left+=1

        if left==n-1: return 0

        stack=[n-1]
        for r in range(n-2, left, -1):
            if arr[r]<=arr[r+1]: stack.append(r)
            else: break
        
        remove=min(n-left-1, stack[-1])
        for i in range(0, left+1):
            while stack and arr[i]>arr[stack[-1]]: stack.pop()
            if stack: remove=min(remove, stack[-1]-i-1)
        return remove
        
# 12ms
class Solution:
    def findLengthOfShortestSubarray(self, arr: List[int]) -> int:
        right = len(arr) - 1
        while right > 0 and arr[right] >= arr[right - 1]:
            right -= 1

        ret = right
        left = 0
        while left < right and (left == 0 or arr[left - 1] <= arr[left]):
            # find next valid number after arr[left]
            while right < len(arr) and arr[left] > arr[right]:
                right += 1
            # save length of removed subarray
            ret = min(ret, right - left - 1)
            left += 1
        return ret