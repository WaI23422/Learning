package Medium.Array;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/score-after-flipping-matrix/">861. Score After Flipping Matrix</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You are given an <code>m x n</code> binary matrix <code>grid</code>.</p>

<p>A <strong>move</strong> consists of choosing any row or column and toggling each value in that row or column (i.e., changing all <code>0</code>'s to <code>1</code>'s, and all <code>1</code>'s to <code>0</code>'s).</p>

<p>Every row of the matrix is interpreted as a binary number, and the <strong>score</strong> of the matrix is the sum of these numbers.</p>

<p>Return <em>the highest possible <strong>score</strong> after making any number of <strong>moves</strong> (including zero moves)</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/07/23/lc-toogle1.jpg" style="width: 500px; height: 299px;">
<pre><strong>Input:</strong> grid = [[0,0,1,1],[1,0,1,0],[1,1,0,0]]
<strong>Output:</strong> 39
<strong>Explanation:</strong> 0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> grid = [[0]]
<strong>Output:</strong> 1
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>m == grid.length</code></li>
	<li><code>n == grid[i].length</code></li>
	<li><code>1 &lt;= m, n &lt;= 20</code></li>
	<li><code>grid[i][j]</code> is either <code>0</code> or <code>1</code>.</li>
</ul>
</div>
 */
public class ScoreAfterFlippingMatrix {
    public static void main(String[] args) {
        int[][][] tests = {
            {{0,0,1,1},{1,0,1,0},{1,1,0,0}},
        };

        for (int[][] grid : tests) {
            System.out.println(new ScoreAfterFlippingMatrix_Solution().matrixScore(grid));
        }
    }
}

// 1 ms 41.6 MB
class ScoreAfterFlippingMatrix_Solution {
    public int matrixScore(int[][] grid) {
        int rlen = grid.length,
            clen = grid[0].length,
            score = 0,
            rowChange[] = new int[rlen],
            columnOne[] = new int[clen];

        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == 0) { 
                rowChange[i] ^= 1;
            }
            for (int j = 0; j < columnOne.length; j++) {
                int ones = grid[i][j];
                if (rowChange[i] == 1) {ones^= 1;}
                columnOne[j]+=ones; 
            }
        }

        for (int i = 0; i < rlen; i++) {
            StringBuffer binaryString = new StringBuffer();
            for (int j = 0; j < clen; j++) {
                binaryString.append(grid[i][j]^rowChange[i]^(columnOne[j] >rlen/2?0:1));
            }

            score += Integer.parseInt(binaryString.toString(),2);
        }

        return score;
    }
}