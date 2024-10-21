package BetterCodeAnswer.Medium.Array;

import java.util.stream.Stream;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/word-search/">79. Word Search</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given an <code>m x n</code> grid of characters <code>board</code> and a string <code>word</code>, return <code>true</code> <em>if</em> <code>word</code> <em>exists in the grid</em>.</p>

<p>The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/04/word2.jpg" style="width: 322px; height: 242px;">
<pre><strong>Input:</strong> board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
<strong>Output:</strong> true
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/04/word-1.jpg" style="width: 322px; height: 242px;">
<pre><strong>Input:</strong> board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
<strong>Output:</strong> true
</pre>

<p><strong class="example">Example 3:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/15/word3.jpg" style="width: 322px; height: 242px;">
<pre><strong>Input:</strong> board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
<strong>Output:</strong> false
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>m == board.length</code></li>
	<li><code>n = board[i].length</code></li>
	<li><code>1 &lt;= m, n &lt;= 6</code></li>
	<li><code>1 &lt;= word.length &lt;= 15</code></li>
	<li><code>board</code> and <code>word</code> consists of only lowercase and uppercase English letters.</li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong> Could you use search pruning to make your solution faster with a larger <code>board</code>?</p>
</div>
 */
public class WordSearch {
    public static void main(String[] args) {
        Object[][][][] tests = {
            {{{"A","B","C","E"},{"S","F","C","S"},{"A","D","E","E"}},{{"ABCB"}}},
            {{{"A","B","C","E"},{"S","F","E","S"},{"A","D","E","E"}},{{"ABCESEEEFS"}}},
            {{{"a","a"}},{{"aaa"}}},
            {{{"A","B","C","E"},{"S","F","C","S"},{"A","D","E","E"}},{{"ABCCED"}}},
            {{{"A","B","C","E"},{"S","F","C","S"},{"A","D","E","E"}},{{"SEE"}}},
            {{{"A","B","C"},{"A","D","C"},{"A","T","C"}},{{"ABCDB"}}},
        };

        for (Object[][][] test : tests) {
            char[][] board = new char[test[0].length][test[0][0].length];
            
            int i = 0;
            for (Object[] row : test[0]) {
                board[i++] = Stream.of(row)
                                   .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                                   .toString()
                                   .toCharArray();
            }

            String word = (String) test[1][0][0];
        
            System.out.println(new WordSearch_Solution().exist(board, word));
        }
    }
}

// 0 ms 41.4 MB
class WordSearch_Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length, m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        char[] wordChar = word.toCharArray();
        if (wordChar.length > n * m)
            return false;
        int counts[] = new int[256];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                counts[board[i][j]]++;
            }
        }
        int len = wordChar.length;
        for(int i=0; i<len/2; i++)
        {
            if(counts[wordChar[i]]>counts[wordChar[len-1-i]]){
                for(int j=0; j<len/2; j++)
                {
                    char temp = wordChar[j];
                    wordChar[j]=wordChar[len-1-j];
                    wordChar[len-1-j]=temp;
                }
                break;
            }
        }
        for (char c : wordChar) {
            if (--counts[c] < 0)
                return false;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visit(board, wordChar, 0, i, j, n, m, visited))
                    return true;
            }
        }
        return false;
    }

    private boolean visit(char[][] board, char[] word, int start, int x, int y,
            int n, int m, boolean[][] visited) {
        if (start == word.length)
            return true;
        if (x < 0 || x >= n || y < 0 || y >= m || visited[x][y])
            return false;
        if (word[start] != board[x][y])
            return false;
        visited[x][y] = true;
        boolean found = visit(board, word, start + 1, x + 1, y, n, m, visited)
                || visit(board, word, start + 1, x - 1, y, n, m, visited)
                || visit(board, word, start + 1, x, y + 1, n, m, visited)
                || visit(board, word, start + 1, x, y - 1, n, m, visited);
        visited[x][y] = false;
        return found;
    }
}

// 15 ms 42 MB
class WordSearch_Solution2 {
    int n, m, chn;

    public boolean exist(char[][] board, String word) {
        n = board.length;
        m = board[0].length;
        char[] chs = word.toCharArray();
        int mm = board.length, nn = board[0].length;
        if (mm * nn < word.length())
            return false;
        char[] wrd = word.toCharArray();
        int[] boardf = new int[128];
        for (int i = 0; i < mm; ++i) {
            for (int j = 0; j < nn; ++j) {
                ++boardf[board[i][j]];
            }
        }
        for (char ch : wrd)
        {
            if (--boardf[ch] < 0)
            {
                return false;
            }
        }
        chn = chs.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == chs[0] && existUtils(board, chs, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean existUtils(char[][] board, char[] chs, int index, int i, int j) {
        if (i < 0 || i == n || j < 0 || j == m || chs[index] != board[i][j]) {
            return false;
        }
        if (index == (chn - 1)) {
            return true;
        }
        char c = board[i][j];
        board[i][j] = '#';
        boolean result = existUtils(board, chs, index + 1, i + 1, j) ||
                existUtils(board, chs, index + 1, i - 1, j) ||
                existUtils(board, chs, index + 1, i, j + 1) ||
                existUtils(board, chs, index + 1, i, j - 1);
        board[i][j] = c;
        return result;
    }
}