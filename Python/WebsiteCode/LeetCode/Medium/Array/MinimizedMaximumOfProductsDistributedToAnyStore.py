import math
from typing import List

class Solution:
    # 638ms 28.62MB
    def minimizedMaximum(self, storeCount: int, productQuantities: List[int]) -> int:
        maxQuantity = max(productQuantities)
        left = 1
        right = maxQuantity
        result = 0
        
        while left <= right:
            mid = left + (right - left) // 2
            if self.canDistributeProducts(mid, storeCount, productQuantities):
                result = mid
                right = mid - 1
            else:
                left = mid + 1
        
        return result
    
    def canDistributeProducts(self, maxProductsPerStore: int, storeCount: int, quantities: List[int]) -> bool:
        requiredStores = 0
        
        for quantity in quantities:
            # Calculate stores needed for current product type
            requiredStores += (quantity + maxProductsPerStore - 1) // maxProductsPerStore
        
        return requiredStores <= storeCount
    
    def _solve_with_bin_search_by_value(self, n: int, q: List[int]) -> int:
        # TC: O(m*log(m) + m*log(p)), where p := max(q)
        q.sort(reverse=True)
        m = len(q)
        left, right = 1, q[0]
        res = right
        while left <= right:
            free_slots = n - m
            mid = (left + right) // 2
            i = 0
            while i < m and free_slots >= 0:
                slots = math.ceil(q[i] / mid) - 1
                if not slots:
                    break
                free_slots -= slots
                i += 1
            if free_slots < 0: #not enough slots
                left = mid + 1
            else:
                right = mid - 1
                res = mid
        
        return res
            
    # 337ms 28.82MB
    def minimizedMaximum2(self, n: int, quantities: List[int]) -> int:
        if n == len(quantities):
            return max(quantities)

        return self._solve_with_bin_search_by_value(n, quantities)
    
if __name__ == "__main__":
    tests = [
        [[11,6],[6]]   
    ]
    
    for test in tests:
        print(Solution().minimizedMaximum(test[1][0],test[0]))