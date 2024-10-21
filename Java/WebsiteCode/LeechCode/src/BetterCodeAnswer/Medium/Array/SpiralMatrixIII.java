package BetterCodeAnswer.Medium.Array;

import java.util.Arrays;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/spiral-matrix-iii/">885. Spiral Matrix III</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You start at the cell <code>(rStart, cStart)</code> of an <code>rows x cols</code> grid facing east. The northwest corner is at the first row and column in the grid, and the southeast corner is at the last row and column.</p>
 * 
 * <p>You will walk in a clockwise spiral shape to visit every position in this grid. Whenever you move outside the grid's boundary, we continue our walk outside the grid (but may return to the grid boundary later.). Eventually, we reach all <code>rows * cols</code> spaces of the grid.</p>
 * 
 * <p>Return <em>an array of coordinates representing the positions of the grid in the order you visited them</em>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/08/24/example_1.png" style="width: 174px; height: 99px;">
 * <pre><strong>Input:</strong> rows = 1, cols = 4, rStart = 0, cStart = 0
 * <strong>Output:</strong> [[0,0],[0,1],[0,2],[0,3]]
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * <img alt="" src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/08/24/example_2.png" style="width: 202px; height: 142px;">
 * <pre><strong>Input:</strong> rows = 5, cols = 6, rStart = 1, cStart = 4
 * <strong>Output:</strong> [[1,4],[1,5],[2,5],[2,4],[2,3],[1,3],[0,3],[0,4],[0,5],[3,5],[3,4],[3,3],[3,2],[2,2],[1,2],[0,2],[4,5],[4,4],[4,3],[4,2],[4,1],[3,1],[2,1],[1,1],[0,1],[4,0],[3,0],[2,0],[1,0],[0,0]]
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= rows, cols &lt;= 100</code></li>
 * 	<li><code>0 &lt;= rStart &lt; rows</code></li>
 * 	<li><code>0 &lt;= cStart &lt; cols</code></li>
 * </ul>
 * </div>
 */
public class SpiralMatrixIII {
    public static void main(String[] args) {
        int[][] tests = {
            {1,4,0,0}
        };

        for (int[] test : tests) {
            int rows = test[0],
                cols = test[1],
                rStart = test[2],
                cStart = test[3];

            System.out.println(Arrays.deepToString(
                new SpiralMatrixIII_Solution().spiralMatrixIII(rows, cols, rStart, cStart)
            ));
        }
    }
}

// 1ms 44.82MB
class SpiralMatrixIII_Solution {
    int minX, minY, maxX, maxY, index;
    
        int[][] result;
    
        public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
            
            int n = cols * rows;
            result = new int[n][];
    
            minX = cStart;
            maxX = cStart + 1;
            minY = rStart;
            maxY = rStart;
            index = 0;
            result[index++] = new int[]{rStart, cStart};
    
            while (true) {
                if (minY >= 0){
                    right(Math.max(0, minX + 1), Math.min(cols - 1, maxX));
                } 
                maxY++;
                if (index >= n) break;
    
                if (maxX < cols) down(Math.max(0, minY + 1), Math.min(rows - 1, maxY));
                minX--;
                if (index >= n) break;
    
                if (maxY < rows) left(Math.min(cols - 1, maxX - 1), Math.max(0, minX));
                minY--;
                if (index >= n) break;
    
                if (minX >= 0) up(Math.min(rows - 1, maxY - 1), Math.max(0, minY));
                maxX++;
                if (index >= n) break;
            }
            return result;
        }
    
        public void right(int start, int end) {
            for (int i = start; i <= end; i++) 
                result[index++] = new int[]{minY, i};
        }
    
        public void left(int start, int end) {
            for (int i = start; i >= end; i--) 
               result[index++] = new int[]{maxY, i};
        }
    
        public void down(int start, int end) {
            for (int i = start; i <= end; i++) 
                result[index++] = new int[]{i, maxX};
        }
    
        public void up(int start, int end) {
            for (int i = start; i >= end; i--) 
               result[index++] = new int[]{i, minX};
        }
    }