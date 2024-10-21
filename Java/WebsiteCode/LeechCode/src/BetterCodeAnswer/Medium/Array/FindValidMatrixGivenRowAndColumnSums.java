package BetterCodeAnswer.Medium.Array;

import java.util.Arrays;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/find-valid-matrix-given-row-and-column-sums/">1605. Find Valid Matrix Given Row and Column Sums</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You are given two arrays <code>rowSum</code> and <code>colSum</code> of non-negative integers where <code>rowSum[i]</code> is the sum of the elements in the <code>i<sup>th</sup></code> row and <code>colSum[j]</code> is the sum of the elements of the <code>j<sup>th</sup></code> column of a 2D matrix. In other words, you do not know the elements of the matrix, but you do know the sums of each row and column.</p>
 * 
 * <p>Find any matrix of <strong>non-negative</strong> integers of size <code>rowSum.length x colSum.length</code> that satisfies the <code>rowSum</code> and <code>colSum</code> requirements.</p>
 * 
 * <p>Return <em>a 2D array representing <strong>any</strong> matrix that fulfills the requirements</em>. It's guaranteed that <strong>at least one </strong>matrix that fulfills the requirements exists.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> rowSum = [3,8], colSum = [4,7]
 * <strong>Output:</strong> [[3,0],
 *          [1,7]]
 * <strong>Explanation:</strong> 
 * 0<sup>th</sup> row: 3 + 0 = 3 == rowSum[0]
 * 1<sup>st</sup> row: 1 + 7 = 8 == rowSum[1]
 * 0<sup>th</sup> column: 3 + 1 = 4 == colSum[0]
 * 1<sup>st</sup> column: 0 + 7 = 7 == colSum[1]
 * The row and column sums match, and all matrix elements are non-negative.
 * Another possible matrix is: [[1,2],
 *                              [3,5]]
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> rowSum = [5,7,10], colSum = [8,6,8]
 * <strong>Output:</strong> [[0,5,0],
 *          [6,1,0],
 *          [2,0,8]]
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= rowSum.length, colSum.length &lt;= 500</code></li>
 * 	<li><code>0 &lt;= rowSum[i], colSum[i] &lt;= 10<sup>8</sup></code></li>
 * 	<li><code>sum(rowSum) == sum(colSum)</code></li>
 * </ul>
 * </div>
 */
public class FindValidMatrixGivenRowAndColumnSums {
    public static void main(String[] args) {
        int[][][] tests = {
            {
                {5,7,10},
                {8,6,8}
            }
        };

        for (int[][] test : tests) {
            int rowSum[] = test[0],
                colSum[] = test[1];

            System.out.println(Arrays.deepToString(new FindValidMatrixGivenRowAndColumnSums_Solution().restoreMatrix(rowSum, colSum)));
        }
    }
}

// 1 ms 52.82 MB
class FindValidMatrixGivenRowAndColumnSums_Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m=rowSum.length;
        int n=colSum.length;
        int[][] ans= new int[m][n];
        int i=0,j=0;
        while(i<m && j<n){
            ans[i][j]=Math.min(rowSum[i],colSum[j]);
            rowSum[i]-=ans[i][j];
            colSum[j]-=ans[i][j];
            if(rowSum[i]==0){
                i++;
            }
            if(colSum[j]==0){
                j++;
            }
        }
        return ans;
        
    }
}