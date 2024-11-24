from math import inf
from typing import List

# 36ms 27.93MB 
class Solution:
    def maxMatrixSum(self, matrix: List[List[int]]) -> int:
        total_sum = 0
        negative_count = 0 
        minel = inf
        for i in matrix:
            for j in i:
                if j<0:
                    j = -j
                    negative_count+=1
                total_sum+=j
                if j<minel:
                    minel = j
        if negative_count%2==0:
            return total_sum
        else:
            return total_sum-2*minel
        
# 79ms 24.86MB
class Solution:
    def maxMatrixSum(self, matrix: List[List[int]]) -> int:
        neg = 0
        minVal = float('inf')
        sum_abs = 0

        for row in matrix:
            for val in row:
                if val < 0:
                    neg += 1
                sum_abs += abs(val)
                minVal = min(minVal, abs(val))

        if neg % 2 == 1:
            sum_abs -= 2 * minVal

        return sum_abs