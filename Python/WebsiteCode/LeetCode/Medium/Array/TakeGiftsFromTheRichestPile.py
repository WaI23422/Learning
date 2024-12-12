import heapq
import math
from typing import List

# 5ms 17.40MB
class Solution:
    def pickGifts(self, gifts: List[int], k: int) -> int:
        heap = [-v for v in gifts]
        heapq.heapify(heap)

        while k > 0:
            v = heapq.heappop(heap)
            v = -v
            v = math.floor(v ** 0.5)
            heapq.heappush(heap, -v)
            k -= 1

        return -1 * sum(heap)