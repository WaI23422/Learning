package BetterCodeAnswer.Easy.Arrays;

import java.util.Arrays;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/difference-between-ones-and-zeros-in-row-and-column/">2482.Difference Between Ones and Zeros in Row and Column</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>You are given a <strong>0-indexed</strong> <code>m x n</code> binary matrix <code>grid</code>.</p>

<p>A <strong>0-indexed</strong> <code>m x n</code> difference matrix <code>diff</code> is created with the following procedure:</p>

<ul>
	<li>Let the number of ones in the <code>i<sup>th</sup></code> row be <code>onesRow<sub>i</sub></code>.</li>
	<li>Let the number of ones in the <code>j<sup>th</sup></code> column be <code>onesCol<sub>j</sub></code>.</li>
	<li>Let the number of zeros in the <code>i<sup>th</sup></code> row be <code>zerosRow<sub>i</sub></code>.</li>
	<li>Let the number of zeros in the <code>j<sup>th</sup></code> column be <code>zerosCol<sub>j</sub></code>.</li>
	<li><code>diff[i][j] = onesRow<sub>i</sub> + onesCol<sub>j</sub> - zerosRow<sub>i</sub> - zerosCol<sub>j</sub></code></li>
</ul>

<p>Return <em>the difference matrix </em><code>diff</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img src="https://assets.leetcode.com/uploads/2022/11/06/image-20221106171729-5.png" style="width: 400px; height: 208px;">
<pre><strong>Input:</strong> grid = [[0,1,1],[1,0,1],[0,0,1]]
<strong>Output:</strong> [[0,0,4],[0,0,4],[-2,-2,2]]
<strong>Explanation:</strong>
- diff[0][0] = <code>onesRow<sub>0</sub> + onesCol<sub>0</sub> - zerosRow<sub>0</sub> - zerosCol<sub>0</sub></code> = 2 + 1 - 1 - 2 = 0 
- diff[0][1] = <code>onesRow<sub>0</sub> + onesCol<sub>1</sub> - zerosRow<sub>0</sub> - zerosCol<sub>1</sub></code> = 2 + 1 - 1 - 2 = 0 
- diff[0][2] = <code>onesRow<sub>0</sub> + onesCol<sub>2</sub> - zerosRow<sub>0</sub> - zerosCol<sub>2</sub></code> = 2 + 3 - 1 - 0 = 4 
- diff[1][0] = <code>onesRow<sub>1</sub> + onesCol<sub>0</sub> - zerosRow<sub>1</sub> - zerosCol<sub>0</sub></code> = 2 + 1 - 1 - 2 = 0 
- diff[1][1] = <code>onesRow<sub>1</sub> + onesCol<sub>1</sub> - zerosRow<sub>1</sub> - zerosCol<sub>1</sub></code> = 2 + 1 - 1 - 2 = 0 
- diff[1][2] = <code>onesRow<sub>1</sub> + onesCol<sub>2</sub> - zerosRow<sub>1</sub> - zerosCol<sub>2</sub></code> = 2 + 3 - 1 - 0 = 4 
- diff[2][0] = <code>onesRow<sub>2</sub> + onesCol<sub>0</sub> - zerosRow<sub>2</sub> - zerosCol<sub>0</sub></code> = 1 + 1 - 2 - 2 = -2
- diff[2][1] = <code>onesRow<sub>2</sub> + onesCol<sub>1</sub> - zerosRow<sub>2</sub> - zerosCol<sub>1</sub></code> = 1 + 1 - 2 - 2 = -2
- diff[2][2] = <code>onesRow<sub>2</sub> + onesCol<sub>2</sub> - zerosRow<sub>2</sub> - zerosCol<sub>2</sub></code> = 1 + 3 - 2 - 0 = 2
</pre>

<p><strong class="example">Example 2:</strong></p>
<img src="https://assets.leetcode.com/uploads/2022/11/06/image-20221106171747-6.png" style="width: 358px; height: 150px;">
<pre><strong>Input:</strong> grid = [[1,1,1],[1,1,1]]
<strong>Output:</strong> [[5,5,5],[5,5,5]]
<strong>Explanation:</strong>
- diff[0][0] = onesRow<sub>0</sub> + onesCol<sub>0</sub> - zerosRow<sub>0</sub> - zerosCol<sub>0</sub> = 3 + 2 - 0 - 0 = 5
- diff[0][1] = onesRow<sub>0</sub> + onesCol<sub>1</sub> - zerosRow<sub>0</sub> - zerosCol<sub>1</sub> = 3 + 2 - 0 - 0 = 5
- diff[0][2] = onesRow<sub>0</sub> + onesCol<sub>2</sub> - zerosRow<sub>0</sub> - zerosCol<sub>2</sub> = 3 + 2 - 0 - 0 = 5
- diff[1][0] = onesRow<sub>1</sub> + onesCol<sub>0</sub> - zerosRow<sub>1</sub> - zerosCol<sub>0</sub> = 3 + 2 - 0 - 0 = 5
- diff[1][1] = onesRow<sub>1</sub> + onesCol<sub>1</sub> - zerosRow<sub>1</sub> - zerosCol<sub>1</sub> = 3 + 2 - 0 - 0 = 5
- diff[1][2] = onesRow<sub>1</sub> + onesCol<sub>2</sub> - zerosRow<sub>1</sub> - zerosCol<sub>2</sub> = 3 + 2 - 0 - 0 = 5
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>m == grid.length</code></li>
	<li><code>n == grid[i].length</code></li>
	<li><code>1 &lt;= m, n &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= m * n &lt;= 10<sup>5</sup></code></li>
	<li><code>grid[i][j]</code> is either <code>0</code> or <code>1</code>.</li>
</ul>
</div></div>
 */
public class DifferenceBetweenOnesAndZerosInRowAndColumn {
    public static void main(String[] args) {
        int[][][] tests = {
            {{0,1,1},{1,0,1},{0,0,1}},
            {{1,1,1},{1,1,1}},
        };

        for (int[][] grid : tests) {
            int[][] ans = new DifferenceBetweenOnesAndZerosInRowAndColumn_Solution().onesMinusZeros(grid);

            System.out.print("[");
            for (int[] arr : ans) {
                System.out.print(Arrays.toString(arr));
            }
            System.out.print("]");
            System.out.println("");
        }
    }    
}

// 3 ms 73.3 MB
class DifferenceBetweenOnesAndZerosInRowAndColumn_Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int row[]= new int[grid.length];
        int column[]= new int[grid[0].length];
        for(int i=0; i<row.length; i++){
            int one=0;
            for(int j=0; j<column.length; j++){
                one = one + grid[i][j];
            }
            row[i]= (2*one)-(row.length);
        }

        for(int j=0; j<column.length; j++){
            int one=0;
            for(int i=0; i<row.length; i++){
                one = one + grid[i][j];
            }
            column[j]= (2*one)-(column.length);
        }

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                grid[i][j]= row[i]+column[j];
            }
        }
        return grid;
    }
}