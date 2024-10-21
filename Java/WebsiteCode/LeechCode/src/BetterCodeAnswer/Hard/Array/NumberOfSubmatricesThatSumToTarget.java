package BetterCodeAnswer.Hard.Array;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/number-of-submatrices-that-sum-to-target/">1074.Number of Submatrices That Sum to Target</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given a <code>matrix</code>&nbsp;and a <code>target</code>, return the number of non-empty submatrices that sum to <font face="monospace">target</font>.</p>

<p>A submatrix <code>x1, y1, x2, y2</code> is the set of all cells <code>matrix[x][y]</code> with <code>x1 &lt;= x &lt;= x2</code> and <code>y1 &lt;= y &lt;= y2</code>.</p>

<p>Two submatrices <code>(x1, y1, x2, y2)</code> and <code>(x1', y1', x2', y2')</code> are different if they have some coordinate&nbsp;that is different: for example, if <code>x1 != x1'</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/09/02/mate1.jpg" style="width: 242px; height: 242px;">
<pre><strong>Input:</strong> matrix = [[0,1,0],[1,1,1],[0,1,0]], target = 0
<strong>Output:</strong> 4
<strong>Explanation:</strong> The four 1x1 submatrices that only contain 0.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> matrix = [[1,-1],[-1,1]], target = 0
<strong>Output:</strong> 5
<strong>Explanation:</strong> The two 1x2 submatrices, plus the two 2x1 submatrices, plus the 2x2 submatrix.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> matrix = [[904]], target = 0
<strong>Output:</strong> 0
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= matrix.length &lt;= 100</code></li>
	<li><code>1 &lt;= matrix[0].length &lt;= 100</code></li>
	<li><code>-1000 &lt;= matrix[i] &lt;= 1000</code></li>
	<li><code>-10^8 &lt;= target &lt;= 10^8</code></li>
</ul>
</div>
 */
public class NumberOfSubmatricesThatSumToTarget {
    public static void main(String[] args) {
        int[][][][] tests = {
            {{{0,1,0},{1,1,1},{0,1,0}},{{0}}},
            {{{1,-1},{-1,1}},{{0}}},
            {{{904}},{{0}}},
        };

        for (int[][][] test : tests) {
            int[][] matrix = test[0];
            int target = test[1][0][0];

            System.out.println(new NumberOfSubmatricesThatSumToTarget_Solution().numSubmatrixSumTarget(matrix, target));
        }
    }
}

// 16 ms 65.2 MB
class NumberOfSubmatricesThatSumToTarget_Solution {
    static byte[] map = new byte[20_000_001];
    static final int BASE_SUM = -10_000_000;
    
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int rowLastIdx = matrix.length - 1;
        int colLastIdx = matrix[0].length - 1;
        int result = 0;
        
        // Copy the original int[][] matrix a the colSums[][] matrix.  This 
        // matrix will be used to build some running sums along the rows.  If the 
        // matrix is taller than it is wide, then also transpose the matrix to make 
        // the width the long dimension.  Sum all the columns in each row, starting 
        // at the rightmost column (highest numbered column) and summing to the left 
        // (summing to column 0).  Then each cell in the colSums[][] matrix will be 
        // the sum of all cell values to the right on the same row.
        int[][] colSums;
        if (rowLastIdx <= colLastIdx) {                 // Height <= width
            colSums = new int[rowLastIdx + 1][colLastIdx + 2];
            for (int row = 0; row <= rowLastIdx; row++) {
                int sum = 0;
                for (int col = colLastIdx; col >= 0; col--)
                    sum = colSums[row][col] = sum + matrix[row][col];
            }            
        } else {                                        // Height > width.  Transpose.
            int temp = colLastIdx;
            colLastIdx = rowLastIdx;
            rowLastIdx = temp;
            colSums = new int[rowLastIdx + 1][colLastIdx + 2];
            for (int row = 0; row <= rowLastIdx; row++) {
                int[] curSumRow = colSums[row];
                int sum = 0;
                for (int col = colLastIdx; col >= 0; col--)
                    sum = curSumRow[col] = sum + matrix[col][row];
            }            
        }

        // Loop through all possible sub matrixes, to see if the sum is the target.  All 
        // columns have already been summed on each row, so that each cell in colSums[][] 
        // matrix is the sum of all cells to the right on the same row.  Then for a given 
        // starting column of a submatrix, and a given width of the submatrix, 
        int[] curRowSums = new int[rowLastIdx + 2];
        for (int startCol = colLastIdx; startCol >= 0; startCol--) {
            for (int colWidth = colLastIdx - startCol + 1; colWidth > 0; colWidth--) {
                int sum = -BASE_SUM;
                map[target - BASE_SUM] = 1;
                curRowSums[rowLastIdx + 1] = target - BASE_SUM;
                for (int row = rowLastIdx; row >= 0; row--) {
                    sum += colSums[row][startCol] - colSums[row][startCol + colWidth];
                    result += map[sum];
                    map[sum + target]++;
                    curRowSums[row] = sum + target;
                }
                for (int row = rowLastIdx + 1; row >= 0; row--)
                    map[curRowSums[row]] = 0;
            }
        }
        
        return result;
    }
}

// 79 ms 44.2 MB
class NumberOfSubmatricesThatSumToTarget_Solution2 {
    public int numSubmatrixSumTarget(int[][] nums, int t) {
        int row=nums.length;
        int col=nums[0].length;
        int count=0;
        for(int i=0;i<row;i++)//1
        {
            int arr[]=new int[col];
            for(int j=i;j<row;j++)//2
            {
                for(int k=0;k<col;k++)//3
                {
                    arr[k]+=nums[j][k];
                }
                for(int l=0;l<col;l++)//4
                {
                    int sum=0;
                    for(int r=l;r<col;r++)//5
                    {
                        sum+=arr[r];
                        if(sum==t)
                        {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}