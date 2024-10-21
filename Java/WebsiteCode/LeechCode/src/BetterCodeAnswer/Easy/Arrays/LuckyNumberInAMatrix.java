package BetterCodeAnswer.Easy.Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/lucky-numbers-in-a-matrix/">1380. Lucky Numbers in a Matrix</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given an <code>m x n</code> matrix of <strong>distinct </strong>numbers, return <em>all <strong>lucky numbers</strong> in the matrix in <strong>any </strong>order</em>.</p>
 * 
 * <p>A <strong>lucky number</strong> is an element of the matrix such that it is the minimum element in its row and maximum in its column.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> matrix = [[3,7,8],[9,11,13],[15,16,17]]
 * <strong>Output:</strong> [15]
 * <strong>Explanation:</strong> 15 is the only lucky number since it is the minimum in its row and the maximum in its column.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
 * <strong>Output:</strong> [12]
 * <strong>Explanation:</strong> 12 is the only lucky number since it is the minimum in its row and the maximum in its column.
 * </pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <pre><strong>Input:</strong> matrix = [[7,8],[1,2]]
 * <strong>Output:</strong> [7]
 * <strong>Explanation:</strong> 7 is the only lucky number since it is the minimum in its row and the maximum in its column.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>m == mat.length</code></li>
 * 	<li><code>n == mat[i].length</code></li>
 * 	<li><code>1 &lt;= n, m &lt;= 50</code></li>
 * 	<li><code>1 &lt;= matrix[i][j] &lt;= 10<sup>5</sup></code>.</li>
 * 	<li>All elements in the matrix are distinct.</li>
 * </ul>
 * </div>
 */
public class LuckyNumberInAMatrix {
    public static void main(String[] args) {
        int[][][] tests = {
            {
                {3,7,8},
                {9,11,13},
                {15,16,17}
            },
            {
                {1,10,4,2},
                {9,3,8,7},
                {15,16,17,12}
            },
        };

        for (int[][] matrix : tests) {
            System.out.println(new LuckyNumberInAMatrix_Solution().luckyNumbers(matrix));
        }
    }
}

// 1ms 45MB
class LuckyNumberInAMatrix_Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
      for (int[] row : matrix) {
        final int minIndex = getMinIndex(row);
        if (row[minIndex] == maxNumOfColumn(matrix, minIndex))
          return List.of(row[minIndex]);
      }
      return new ArrayList<>();
    }
  
    private int getMinIndex(int[] row) {
      int minIndex = 0;
      for (int j = 0; j < row.length; ++j)
        if (row[j] < row[minIndex])
          minIndex = j;
      return minIndex;
    }
  
    private int maxNumOfColumn(int[][] matrix, int j) {
      int res = 0;
      for (int i = 0; i < matrix.length; ++i)
        res = Math.max(res, matrix[i][j]);
      return res;
    }
}

// 0ms 45.7MB
class LuckyNumberInAMatrix_Solution2 {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> lsRes = new ArrayList<>();

        for(int i = 0; i < matrix.length; i++)
        {
            int col = findMin(matrix, i);

            int maxCol = matrix[i][col];
            if(maxInCol(matrix, maxCol, col))
                lsRes.add(maxCol);
            // for(int r = 0; r < matrix.length; r++)
            // {
            //     if(matrix[r][col] > maxCol)
            //         maxCol = matrix[r][col];
            // }

            // if(minRow == maxCol)
            //     lsRes.add(matrix[i][col]);
        }

        return lsRes;
    }
    private int findMin(int[][] matrix, int row){
		int val= matrix[row][0], col=0;
		for(int i=1;i<matrix[row].length;i++){
			if(matrix[row][i]<val){
				val=matrix[row][i];
				col=i;
			}
		}
		return col;
	}
    private boolean maxInCol(int[][] matrix, int val, int col){
        for(int i=0;i<matrix.length;i++){
            if(matrix[i][col]>val)
                return false;
        }
        return true;
    }
}