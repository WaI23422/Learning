package Hard.Array;

import java.util.PriorityQueue;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/minimum-time-to-visit-a-cell-in-a-grid/">2577. Minimum Time to Visit a Cell In a Grid</a>
 * 
 * <div><div class="elfjS" data-track-load="description_content"><p>You are given a <code>m x n</code> matrix <code>grid</code> consisting of <b>non-negative</b> integers where <code>grid[row][col]</code> represents the <strong>minimum</strong> time required to be able to visit the cell <code>(row, col)</code>, which means you can visit the cell <code>(row, col)</code> only when the time you visit it is greater than or equal to <code>grid[row][col]</code>.</p>
 * 
 * <p>You are standing in the <strong>top-left</strong> cell of the matrix in the <code>0<sup>th</sup></code> second, and you must move to <strong>any</strong> adjacent cell in the four directions: up, down, left, and right. Each move you make takes 1 second.</p>
 * 
 * <p>Return <em>the <strong>minimum</strong> time required in which you can visit the bottom-right cell of the matrix</em>. If you cannot visit the bottom-right cell, then return <code>-1</code>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <p><img alt="" src="https://assets.leetcode.com/uploads/2023/02/14/yetgriddrawio-8.png"></p>
 * 
 * <pre><strong>Input:</strong> grid = [[0,1,3,2],[5,1,2,5],[4,3,8,6]]
 * <strong>Output:</strong> 7
 * <strong>Explanation:</strong> One of the paths that we can take is the following:
 * - at t = 0, we are on the cell (0,0).
 * - at t = 1, we move to the cell (0,1). It is possible because grid[0][1] &lt;= 1.
 * - at t = 2, we move to the cell (1,1). It is possible because grid[1][1] &lt;= 2.
 * - at t = 3, we move to the cell (1,2). It is possible because grid[1][2] &lt;= 3.
 * - at t = 4, we move to the cell (1,1). It is possible because grid[1][1] &lt;= 4.
 * - at t = 5, we move to the cell (1,2). It is possible because grid[1][2] &lt;= 5.
 * - at t = 6, we move to the cell (1,3). It is possible because grid[1][3] &lt;= 6.
 * - at t = 7, we move to the cell (2,3). It is possible because grid[2][3] &lt;= 7.
 * The final time is 7. It can be shown that it is the minimum time possible.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <p><img alt="" src="https://assets.leetcode.com/uploads/2023/02/14/yetgriddrawio-9.png" style="width: 151px; height: 151px;"></p>
 * 
 * <pre><strong>Input:</strong> grid = [[0,2,4],[3,2,1],[1,0,4]]
 * <strong>Output:</strong> -1
 * <strong>Explanation:</strong> There is no path from the top left to the bottom-right cell.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>m == grid.length</code></li>
 * 	<li><code>n == grid[i].length</code></li>
 * 	<li><code>2 &lt;= m, n &lt;= 1000</code></li>
 * 	<li><code>4 &lt;= m * n &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>0 &lt;= grid[i][j] &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>grid[0][0] == 0</code></li>
 * </ul>
 * 
 * <p>&nbsp;</p>
 * <style type="text/css">.spoilerbutton {display:block; border:dashed; padding: 0px 0px; margin:10px 0px; font-size:150%; font-weight: bold; color:#000000; background-color:cyan; outline:0; 
 * }
 * .spoiler {overflow:hidden;}
 * .spoiler > div {-webkit-transition: all 0s ease;-moz-transition: margin 0s ease;-o-transition: all 0s ease;transition: margin 0s ease;}
 * .spoilerbutton[value="Show Message"] + .spoiler > div {margin-top:-500%;}
 * .spoilerbutton[value="Hide Message"] + .spoiler {padding:5px;}
 * </style>
 * </div></div>
 */
public class MinimumTimeToVisitACellInAGrid {
    public static void main(String[] args) {
        
    }
}


// 241ms 60.4MB
class MinimumTimeToVisitACellInAGrid_Solution {

    public int minimumTime(int[][] grid) {
        // If both initial moves require more than 1 second, impossible to proceed
        if (grid[0][1] > 1 && grid[1][0] > 1) {
            return -1;
        }

        int rows = grid.length, cols = grid[0].length;
        // Possible movements: down, up, right, left
        int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        boolean[][] visited = new boolean[rows][cols];

        // Priority queue stores {time, row, col}
        // Ordered by minimum time to reach each cell
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) ->
            Integer.compare(a[0], b[0])
        );
        pq.add(new int[] { grid[0][0], 0, 0 });

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int time = curr[0], row = curr[1], col = curr[2];

            // Check if reached target
            if (row == rows - 1 && col == cols - 1) {
                return time;
            }

            // Skip if cell already visited
            if (visited[row][col]) {
                continue;
            }
            visited[row][col] = true;

            // Try all four directions
            for (int[] d : directions) {
                int nextRow = row + d[0], nextCol = col + d[1];
                if (!isValid(visited, nextRow, nextCol)) {
                    continue;
                }

                // Calculate the wait time needed to move to next cell
                int waitTime = ((grid[nextRow][nextCol] - time) % 2 == 0)
                    ? 1
                    : 0;
                int nextTime = Math.max(
                    grid[nextRow][nextCol] + waitTime,
                    time + 1
                );
                pq.add(new int[] { nextTime, nextRow, nextCol });
            }
        }
        return -1;
    }

    // Checks if given cell coordinates are valid and unvisited
    private boolean isValid(boolean[][] visited, int row, int col) {
        return (
            row >= 0 &&
            col >= 0 &&
            row < visited.length &&
            col < visited[0].length &&
            !visited[row][col]
        );
    }
}