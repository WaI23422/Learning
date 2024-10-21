package BetterCodeAnswer.Medium.Array;

import java.util.Arrays;

public class LargestSubmatrixWithRearrangements {
    public static void main(String[] args) {
        int[][][] tests = {
            {{0,0,1},{1,1,1},{1,0,1}},
            {{1,0,1,0,1}},
            {{1,1,0},{1,0,1}}
        };

        for (int[][] matrix : tests) {
            System.out.println(new LargestSubmatrixWithRearrangements_Solution().largestSubmatrix(matrix));
        }
    }
}

/**
 * <h1 id="intuition">Intuition</h1>
 * <p>The problem asks for the area of the largest submatrix containing only 1s after rearranging the columns optimally. The solution involves preprocessing the matrix to store the height of consecutive 1s ending at each cell. Then, for each row, we sort the heights in non-decreasing order and calculate the area for each possible submatrix.</p>
 * <h1 id="approach">Approach</h1>
 * <ol>
<li>Iterate through the matrix starting from the second row (<code>i = 1</code>).</li>
<li>For each cell <code>matrix[i][j]</code>:
<ul>
<li>If <code>matrix[i][j]</code> is 1, update it to store the height of consecutive 1s ending at this cell by adding the height of the previous row's corresponding cell (<code>matrix[i - 1][j]</code>).</li>
</ul>
</li>
<li>After preprocessing, for each row, sort the row in non-decreasing order.</li>
<li>For each cell in the sorted row, calculate the area of the submatrix that ends at this cell, considering the consecutive 1s.
<ul>
<li>The area is given by <code>height * width</code>, where <code>height</code> is the height of consecutive 1s ending at this cell, and <code>width</code> is the position of the cell in the sorted row.</li>
<li>Update the maximum area accordingly.</li>
</ul>
</li>
<li>Return the maximum area as the result.</li>
</ol>
 */
class LargestSubmatrixWithRearrangements_Solution {
    // 9 ms 68.1 MB
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 1; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] = matrix[i - 1][j] + 1;
                }
            }
        }
        int ans = 0;
        for (var row : matrix) {
            Arrays.sort(row);
            for (int j = n - 1, k = 1; j >= 0 && row[j] > 0; --j, ++k) {
                int s = row[j] * k;
                ans = Math.max(ans, s);
            }
        }
        return ans;
    }
}