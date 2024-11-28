DIFFS = [(-1, 0), (0, 1), (1, 0), (0, -1)]

from collections import deque
from typing import List

# 571ms 39.95MB
class Solution:
    def minimumObstacles(self, grid: List[List[int]]) -> int:
        grid = grid
        n_rows = len(grid)
        n_cols = len(grid[0])
        available = [[True] * n_cols for row in grid]
        available[0][0] = False
        in_progress = deque([(0, 0, 0)])
        while True:
            i, j, distance = in_progress.popleft()
            for di, dj in DIFFS:
                new_i = i + di
                new_j = j + dj
                if 0 <= new_i < n_rows and 0 <= new_j < n_cols and available[new_i][new_j]:
                    available[new_i][new_j] = False
                    if new_i == n_rows - 1 and new_j == n_cols - 1:
                        return distance
                    if grid[new_i][new_j] == 0:
                            in_progress.appendleft((new_i, new_j, distance))
                    else:
                            in_progress.append((new_i, new_j, distance+1))