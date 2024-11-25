
from collections import deque
from heapq import heappop, heappush
from typing import List

# 0ms 16.8MB
class Solution:
    def slidingPuzzle(self, board: List[List[int]]) -> int:
        m, n = 2, 3
        seq = []
        start, end = '', '123450'
        for i in range(m):
            for j in range(n):
                if board[i][j] != 0:
                    seq.append(board[i][j])
                start += str(board[i][j])

        def check(seq):
            n = len(seq)
            cnt = sum(seq[i] > seq[j] for i in range(n) for j in range(i, n))
            return cnt % 2 == 0

        def f(s):
            ans = 0
            for i in range(m * n):
                if s[i] != '0':
                    num = ord(s[i]) - ord('1')
                    ans += abs(i // n - num // n) + abs(i % n - num % n)
            return ans

        if not check(seq):
            return -1
        q = [(f(start), start)]
        dist = {start: 0}
        while q:
            _, state = heappop(q)
            if state == end:
                return dist[state]
            p1 = state.index('0')
            i, j = p1 // n, p1 % n
            s = list(state)
            for a, b in [[0, -1], [0, 1], [1, 0], [-1, 0]]:
                x, y = i + a, j + b
                if 0 <= x < m and 0 <= y < n:
                    p2 = x * n + y
                    s[p1], s[p2] = s[p2], s[p1]
                    next = ''.join(s)
                    s[p1], s[p2] = s[p2], s[p1]
                    if next not in dist or dist[next] > dist[state] + 1:
                        dist[next] = dist[state] + 1
                        heappush(q, (dist[next] + f(next), next))
        return -1

# 7ms 16.9MB
class Solution:
    def slidingPuzzle(self, board):
        # Directions for possible swaps based on '0' position
        dir = [[1, 3], [0, 2, 4], [1, 5], [0, 4], [1, 3, 5], [2, 4]]
        target = "123450"
        vis = set() # Track visited configurations
        q = deque()
        start = ""

        # Convert 2D board to a single string
        for row in board:
            for col in row:
                start += str(col)

        q.append(start)
        vis.add(start)
        step = 0

        # Perform BFS
        while q:
            size = len(q)
            for _ in range(size):
                current = q.popleft()

                # Check if target is reached
                if current == target:
                    return step

                zero = current.find('0') # Find position of '0'

                # Generate next moves
                for move in dir[zero]:
                    next_state = list(current)
                    next_state[zero], next_state[move] = next_state[move], next_state[zero]
                    next_state = ''.join(next_state)
                    if next_state not in vis:  # Add unvisited states to the queue
                        vis.add(next_state)
                        q.append(next_state)
            step += 1
        return -1  # Return -1 if target is unreachable