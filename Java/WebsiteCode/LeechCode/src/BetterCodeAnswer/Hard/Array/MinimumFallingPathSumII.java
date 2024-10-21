package BetterCodeAnswer.Hard.Array;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/minimum-falling-path-sum-ii/">1289. Minimum Falling Path Sum II</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given an <code>n x n</code> integer matrix <code>grid</code>, return <em>the minimum sum of a <strong>falling path with non-zero shifts</strong></em>.</p>

<p>A <strong>falling path with non-zero shifts</strong> is a choice of exactly one element from each row of <code>grid</code> such that no two elements chosen in adjacent rows are in the same column.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/08/10/falling-grid.jpg" style="width: 244px; height: 245px;">
<pre><strong>Input:</strong> grid = [[1,2,3],[4,5,6],[7,8,9]]
<strong>Output:</strong> 13
<strong>Explanation:</strong> 
The possible falling paths are:
[1,5,9], [1,5,7], [1,6,7], [1,6,8],
[2,4,8], [2,4,9], [2,6,7], [2,6,8],
[3,4,8], [3,4,9], [3,5,7], [3,5,9]
The falling path with the smallest sum is&nbsp;[1,5,7], so the answer is&nbsp;13.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> grid = [[7]]
<strong>Output:</strong> 7
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == grid.length == grid[i].length</code></li>
	<li><code>1 &lt;= n &lt;= 200</code></li>
	<li><code>-99 &lt;= grid[i][j] &lt;= 99</code></li>
</ul>
</div>
 */
public class MinimumFallingPathSumII {
    public static void main(String[] args) {
        int[][][] tests  = {
            {{},{}}
        };

        for (int[][] grid : tests) {
            System.out.println(new MinimumFallingPathSumII_Solution().minFallingPathSum(grid));
        }
    }
}

// 2 ms 51.8 MB
class MinimumFallingPathSumII_Solution {
    public int minFallingPathSum(int[][] grid) {
        return minFallingPathSum(0,grid).minSum;
    }

    private Triplet minFallingPathSum(int row, int[][] grid){

        if(row == grid.length){
            return new Triplet(0,0,0);
        }

        Triplet nextRowTriplet = minFallingPathSum(row+1, grid); //trying passing row++
        Triplet currentTriplet = new Triplet(Integer.MAX_VALUE, Integer.MAX_VALUE, -1);

        for(int col = 0; col<grid[0].length; col++){
            int sum = grid[row][col] + ((col != nextRowTriplet.minSumIndex) ? nextRowTriplet.minSum : nextRowTriplet.secondMinSum);
            if(sum <= currentTriplet.minSum){
                currentTriplet.secondMinSum = currentTriplet.minSum;
                currentTriplet.minSum = sum;
                currentTriplet.minSumIndex = col;
            }else if(sum < currentTriplet.secondMinSum){
                currentTriplet.secondMinSum = sum;
            }
        }

        return currentTriplet;
    }
}

class Triplet{
    int minSum;
    int secondMinSum;
    int minSumIndex;
    
    Triplet(int minSum, int secondMinSum, int minSumIndex){
        this.minSum = minSum;
        this.secondMinSum = secondMinSum;
        this.minSumIndex = minSumIndex;
    }
}

// 2 ms 51.8 MB 
@SuppressWarnings("unused")
class MinimumFallingPathSumII_Solution2 {
    public int minFallingPathSum(int[][] grid) {
        // Minimum and Second Minimum Column Index
        int nextMin1C = -1;
        int nextMin2C = -1;

        // Minimum and Second Minimum Value
        int nextMin1 = -1;
        int nextMin2 = -1;

        // Find the minimum and second minimum from the last row
        
        for (int col = 0; col < grid.length; col++) {
            if (nextMin1 == -1 || grid[grid.length - 1][col] <= nextMin1) {
                nextMin2 = nextMin1;
                nextMin2C = nextMin1C;
                nextMin1 = grid[grid.length - 1][col];
                nextMin1C = col;
            } else if (nextMin2 == -1 || grid[grid.length - 1][col] <= nextMin2) {
                nextMin2 = grid[grid.length - 1][col];
                nextMin2C = col;
            }
        }

        // Fill the recursive cases
        for (int row = grid.length - 2; row >= 0; row--) {
            // Minimum and Second Minimum Column Index of the current row
            int min1C = -1;
            int min2C = -1;

            // Minimum and Second Minimum Value of current row
            int min1 = -1;
            int min2 = -1;

            for (int col = 0; col < grid.length; col++) {
                // Select minimum from valid cells of the next row
                int value;
                if (col != nextMin1C) {
                    value = grid[row][col] + nextMin1;
                } else {
                    value = grid[row][col] + nextMin2;
                }

                // Save minimum and second minimum
                if (min1 == -1 || value <= min1) {
                    min2 = min1;
                    min2C = min1C;
                    min1 = value;
                    min1C = col;
                } else if (min2 == -1 || value <= min2) {
                    min2 = value;
                    min2C = col;
                }
            }

            // Change of row. Update nextMin1C, nextMin2C, nextMin1, nextMin2
            nextMin1C = min1C;
            nextMin2C = min2C;
            nextMin1 = min1;
            nextMin2 = min2;
        }
        
        // Return the minimum from the first row
        return nextMin1;
    }
}

// 5 ms 51.8 MB
class MinimumFallingPathSumII_Solution3 {
    public int minFallingPathSum(int[][] grid) {
        // Initialize a two-dimensional array to cache the result of each sub-problem
        int[][] memo = new int[grid.length][grid.length];

        // Minimum and Second Minimum Column Index
        int nextMin1C = -1;
        int nextMin2C = -1;

        // Base Case. Fill and save the minimum and second minimum column index
        for (int col = 0; col < grid.length; col++) {
            memo[grid.length - 1][col] = grid[grid.length - 1][col];
            if (nextMin1C == -1 || memo[grid.length - 1][col] <= memo[grid.length - 1][nextMin1C]) {
                nextMin2C = nextMin1C;
                nextMin1C = col;
            } else if (nextMin2C == -1 || memo[grid.length - 1][col] <= memo[grid.length - 1][nextMin2C]) {
                nextMin2C = col;
            }
        }

        // Fill the recursive cases
        for (int row = grid.length - 2; row >= 0; row--) {
            // Minimum and Second Minimum Column Index of the current row
            int min1C = -1;
            int min2C = -1;

            for (int col = 0; col < grid.length; col++) {
                // Select minimum from valid cells of the next row
                if (col != nextMin1C) {
                    memo[row][col] = grid[row][col] + memo[row + 1][nextMin1C];
                } else {
                    memo[row][col] = grid[row][col] + memo[row + 1][nextMin2C];
                }

                // Save minimum and second minimum column index
                if (min1C == -1 || memo[row][col] <= memo[row][min1C]) {
                    min2C = min1C;
                    min1C = col;
                } else if (min2C == -1 || memo[row][col] <= memo[row][min2C]) {
                    min2C = col;
                }
            }

            // Change of row. Update nextMin1C and nextMin2C
            nextMin1C = min1C;
            nextMin2C = min2C;
        }

        // Return the minimum from the first row
        return memo[0][nextMin1C];
    }
}