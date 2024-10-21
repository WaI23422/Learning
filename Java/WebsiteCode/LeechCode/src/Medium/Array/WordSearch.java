package Medium.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

// Time Limit Exceeded
class WordSearch_Solution1 {
    int BOARD_HEIGHT,
        BOARD_WIDTH;

    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        List<Integer[]> indexFirstChar = new ArrayList<>();

        char firstChar = chars[0];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == firstChar) {
                    indexFirstChar.add(new Integer[]{i,j});
                }
            }
        }

        if (indexFirstChar.size() == 0) { return false; }

        BOARD_HEIGHT = board.length;
        BOARD_WIDTH = board[0].length;

        boolean res = false;
        for (Integer[] index : indexFirstChar) {
            List<Integer[]> previousIndex = new ArrayList<>();
            previousIndex.add(index);
            res = res || nextExist(board, chars, index,previousIndex, 1);
        }
        
        return res;
    }

    private boolean nextExist(char[][] board, char[] chars, Integer[] boardIndex, List<Integer[]> previousIndex, int charIndex){
        if (charIndex >= chars.length) {return true;}

        int i = boardIndex[0], j = boardIndex[1];
        char character = chars[charIndex];

        boolean up = false, 
                down = false, 
                left = false, 
                right = false;
        if (listNotCotain(previousIndex, new Integer[]{i+1,j}) && i+1 < BOARD_HEIGHT && board[i+1][j] == character) {
            List<Integer[]> previousIndexUp = new ArrayList<>(previousIndex);
            previousIndexUp.add(new Integer[]{i+1,j});
            up = nextExist(board, chars, new Integer[]{i+1,j},previousIndexUp, charIndex+1);
        }

        if (listNotCotain(previousIndex, new Integer[]{i-1,j}) && i-1 >= 0 && board[i-1][j] == character) {
            List<Integer[]> previousIndexDown = new ArrayList<>(previousIndex);
            previousIndexDown.add(new Integer[]{i-1,j});
            down = nextExist(board, chars, new Integer[]{i-1,j},previousIndexDown, charIndex+1);
        }

        if (listNotCotain(previousIndex, new Integer[]{i,j+1}) && j+1 < BOARD_WIDTH && board[i][j+1] == character) {
            List<Integer[]> previousIndexRight = new ArrayList<>(previousIndex);
            previousIndexRight.add(new Integer[]{i,j+1});
            right = nextExist(board, chars, new Integer[]{i,j+1},previousIndexRight, charIndex+1);
        }

        if (listNotCotain(previousIndex, new Integer[]{i,j-1}) && j-1 >= 0 && board[i][j-1] == character) {
            List<Integer[]> previousIndexLeft = new ArrayList<>(previousIndex);
            previousIndexLeft.add(new Integer[]{i,j-1});
            left = nextExist(board, chars, new Integer[]{i,j-1},previousIndexLeft, charIndex+1);
        }

        return up || down || left || right;
    }

    private boolean listNotCotain(List<Integer[]> list, Integer[] obj) {
        for (Integer[] integer : list) {
            if (Arrays.equals(integer, obj)) {
                return false;
            }
        }

        return true;
    } 
}

// 146 ms 41.3 MB
class WordSearch_Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];
        boolean result = false;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    result = backtrack(board, word, visited, i, j, 0);
                    if (result) return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean backtrack(char[][] board, String word, boolean[][] visited, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }
        
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }
        
        visited[i][j] = true;
        
        if (backtrack(board, word, visited, i + 1, j, index + 1) ||
            backtrack(board, word, visited, i - 1, j, index + 1) ||
            backtrack(board, word, visited, i, j + 1, index + 1) ||
            backtrack(board, word, visited, i, j - 1, index + 1)) {
            return true;
        }
        
        visited[i][j] = false;
        return false;
    }
}