<?php  

// 520ms 55.6MB
class Solution
{
    // Directions for movement: right, left, down, up

    public function minimumTime($grid)
    {
        
        if ($grid[0][1] > 1 && $grid[1][0] > 1) {
            return -1;
        }

        $m = count($grid);
        $n = count($grid[0]);

        // Distance matrix to store the minimum obstacles removed to reach each cell
        $minObstacles = array_fill(0, $m--, array_fill(0, $n--, PHP_INT_MAX));

        $deque = new SplPriorityQueue();
        $deque->insert([0, 0, 0], PHP_INT_MAX); // [obstacles, row, col]
        $dir = [0,1,0,-1,0];
        while (!$deque->isEmpty()) {
            $current = $deque->extract();
            [$obstacles, $row, $col] = $current;

            if ($minObstacles[$row][$col] != PHP_INT_MAX) {
                continue;
            }

            if ($row == $m && $col == $n) {
                return $obstacles;
            }

            $minObstacles[$row][$col] = $obstacles++;

            // Explore all four possible directions from the current cell
            for ($i =0; $i < 4; $i++) {
                $newRow = $row + $dir[$i];
                $newCol = $col + $dir[$i+1];

                if (
                    isset($minObstacles[$newRow][$newCol]) &&
                    $minObstacles[$newRow][$newCol] == PHP_INT_MAX
                ) {
                    $futureObstacles = $obstacles;
                    if ($grid[$newRow][$newCol] > $obstacles) {
                        $diff = $grid[$newRow][$newCol] - $obstacles;
                        $futureObstacles = $grid[$newRow][$newCol] + ($diff % 2);
                    }
                    $deque->insert([$futureObstacles, $newRow, $newCol], PHP_INT_MAX - $futureObstacles);
                }
            }
        }

        return -1;
    }
}