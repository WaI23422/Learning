from collections import defaultdict
from typing import Counter, List

# 36ms 20.09MB
class Solution:
    def maxEqualRowsAfterFlips(self, matrix: List[List[int]]) -> int:
        cnt = Counter()
        for row in matrix:
            t = tuple(row) if row[0] == 0 else tuple(x ^ 1 for x in row)
            cnt[t] += 1
        return max(cnt.values())
    
# 55ms 19.21MB
class Solution:
    def maxEqualRowsAfterFlips(self, matrix):
        n = len(matrix)
        m = len(matrix[0])
        pattern_count = defaultdict(int)

        for row in matrix:
            temp = "".join('1' if x == row[0] else '0' for x in row)
            pattern_count[temp] += 1

        maxi = max(pattern_count.values())
        return maxi