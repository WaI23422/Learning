
from ast import List

# 4ms 18.6MB
class Solution:
    def findChampion(self, n: int, edges: List[List[int]]) -> int:
        can_win = [True] * n
        for a, b in edges:
            can_win[b] = False
        winner = -1
        winner_count = 0
        for i in range(0, n): # range(n): 11ms -> 4ms
            if can_win[i]:
                winner = i
                winner_count += 1
        if winner_count == 1:
            return winner
        return -1
