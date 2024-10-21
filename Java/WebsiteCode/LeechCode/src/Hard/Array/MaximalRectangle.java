package Hard.Array;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/maximal-rectangle/">85. Maximal Rectangle</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given a <code>rows x cols</code>&nbsp;binary <code>matrix</code> filled with <code>0</code>'s and <code>1</code>'s, find the largest rectangle containing only <code>1</code>'s and return <em>its area</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/09/14/maximal.jpg" style="width: 402px; height: 322px;">
<pre><strong>Input:</strong> matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
<strong>Output:</strong> 6
<strong>Explanation:</strong> The maximal rectangle is shown in the above picture.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> matrix = [["0"]]
<strong>Output:</strong> 0
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> matrix = [["1"]]
<strong>Output:</strong> 1
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>rows == matrix.length</code></li>
	<li><code>cols == matrix[i].length</code></li>
	<li><code>1 &lt;= row, cols &lt;= 200</code></li>
	<li><code>matrix[i][j]</code> is <code>'0'</code> or <code>'1'</code>.</li>
</ul>
</div>
 */
public class MaximalRectangle {
    public static void main(String[] args) {
        char[][][] tests = {
            {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','0','1','1','1'},
                {'1','0','1','0','0'},
                {'1','0','1','0','0'},
            }
        };

        for (char[][] matrix : tests) {
            System.out.println(new MaximalRectangle_Solution().maximalRectangle(matrix));
        }
    }
}

// @see BetterCodeAnswer.Hard.Array
class MaximalRectangle_Solution {
    public int maximalRectangle(char[][] matrix) {
        return 0;
    }
}