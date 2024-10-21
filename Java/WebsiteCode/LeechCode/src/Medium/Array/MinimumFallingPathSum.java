package Medium.Array;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/minimum-falling-path-sum/">931.Minimum Falling Path Sum</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given an <code>n x n</code> array of integers <code>matrix</code>, return <em>the <strong>minimum sum</strong> of any <strong>falling path</strong> through</em> <code>matrix</code>.</p>

<p>A <strong>falling path</strong> starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right. Specifically, the next element from position <code>(row, col)</code> will be <code>(row + 1, col - 1)</code>, <code>(row + 1, col)</code>, or <code>(row + 1, col + 1)</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/11/03/failing1-grid.jpg" style="width: 499px; height: 500px;">
<pre><strong>Input:</strong> matrix = [[2,1,3],[6,5,4],[7,8,9]]
<strong>Output:</strong> 13
<strong>Explanation:</strong> There are two falling paths with a minimum sum as shown.
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/11/03/failing2-grid.jpg" style="width: 164px; height: 365px;">
<pre><strong>Input:</strong> matrix = [[-19,57],[-40,-5]]
<strong>Output:</strong> -59
<strong>Explanation:</strong> The falling path with a minimum sum is shown.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == matrix.length == matrix[i].length</code></li>
	<li><code>1 &lt;= n &lt;= 100</code></li>
	<li><code>-100 &lt;= matrix[i][j] &lt;= 100</code></li>
</ul>
</div>
 */
public class MinimumFallingPathSum {
    public static void main(String[] args) {
        int[][][] tests = {
            {{2,1,3},{6,5,4},{7,8,9}},
            {{-19,57},{-40,-5}},
        };

        for (int[][] matrix : tests) {
            System.out.println(new MinimumFallingPathSum_Solution().minFallingPathSum(matrix));
        }
    }
}

// Brute-Force Time Limit Exceeded
class MinimumFallingPathSum_Solution {
    private int[][] MATRIX;
    private int WIDTH, HEIGHT;
    
    public int minFallingPathSum(int[][] matrix) {
        MATRIX = matrix; WIDTH = matrix[0].length; HEIGHT = matrix.length;

        int minPath = Integer.MAX_VALUE;

        for (int i = 0; i < WIDTH; i++) {
            minPath = Math.min(minPath, fallingPathSum(i,1,matrix[0][i]));
        }   

        return minPath;
    }

    public int fallingPathSum(int coorX, int coorY, int previousTotal){
        if (coorY == HEIGHT) {return previousTotal;}

        int pathOne = Integer.MAX_VALUE, pathTwo = Integer.MAX_VALUE, pathThree;
        
        if (coorX-1 >= 0 ) {
            pathOne = fallingPathSum(coorX-1, coorY+1, previousTotal + MATRIX[coorY][coorX-1]);
        }

        if (coorX+1 < WIDTH) {
            pathTwo = fallingPathSum(coorX+1, coorY+1, previousTotal + MATRIX[coorY][coorX+1]);
        }

        pathThree = fallingPathSum(coorX, coorY+1, previousTotal + MATRIX[coorY][coorX]);
        
        return Math.min(Math.min(pathOne, pathTwo), pathThree);
    }
}
