<?php  

// 812ms 83.4MB
class Solution {
    // Directions for movement: right, left, down, up
    private $directions = [
        [0, 1],
        [0, -1],
        [1, 0],
        [-1, 0],
    ];

    public function minimumObstacles($grid) {
        $m = count($grid);
        $n = count($grid[0]);

        // Distance matrix to store the minimum obstacles removed to reach each cell
        $minObstacles = array_fill(0, $m, array_fill(0, $n, PHP_INT_MAX));

        $minObstacles[0][0] = 0;

        $deque = new SplQueue();
        $deque->push([0, 0, 0]); // [obstacles, row, col]

        while (!$deque->isEmpty()) {
            $current = $deque->shift();
            [$obstacles, $row, $col] = $current;

            // Explore all four possible directions from the current cell
            foreach ($this->directions as $dir) {
                $newRow = $row + $dir[0];
                $newCol = $col + $dir[1];

                if (
                    $this->isValid($grid, $newRow, $newCol) &&
                    $minObstacles[$newRow][$newCol] === PHP_INT_MAX
                ) {
                    if ($grid[$newRow][$newCol] === 1) {
                        // If it's an obstacle, add 1 to obstacles and push to the back
                        $minObstacles[$newRow][$newCol] = $obstacles + 1;
                        $deque->push([$obstacles + 1, $newRow, $newCol]);
                    } else {
                        // If it's an empty cell, keep the obstacle count and push to the front
                        $minObstacles[$newRow][$newCol] = $obstacles;
                        $deque->unshift([$obstacles, $newRow, $newCol]);
                    }
                }
            }
        }

        return $minObstacles[$m - 1][$n - 1];
    }

    // Helper method to check if the cell is within the grid bounds
    private function isValid($grid, $row, $col) {
        return $row >= 0 && $col >= 0 && $row < count($grid) && $col < count($grid[0]);
    }
}