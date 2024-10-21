package Medium.Array;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/filling-bookcase-shelves/">1105. Filling Bookcase Shelves</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You are given an array <code>books</code> where <code>books[i] = [thickness<sub>i</sub>, height<sub>i</sub>]</code> indicates the thickness and height of the <code>i<sup>th</sup></code> book. You are also given an integer <code>shelfWidth</code>.</p>
 *
 * <p>We want to place these books in order onto bookcase shelves that have a total width <code>shelfWidth</code>.</p>
 * 
 * <p>We choose some of the books to place on this shelf such that the sum of their thickness is less than or equal to <code>shelfWidth</code>, then build another level of the shelf of the bookcase so that the total height of the bookcase has increased by the maximum height of the books we just put down. We repeat this process until there are no more books to place.</p>
 * 
 * <p>Note that at each step of the above process, the order of the books we place is the same order as the given sequence of books.</p>
 * 
 * <ul>
 * 	<li>For example, if we have an ordered list of <code>5</code> books, we might place the first and second book onto the first shelf, the third book on the second shelf, and the fourth and fifth book on the last shelf.</li>
 * </ul>
 * 
 * <p>Return <em>the minimum possible height that the total bookshelf can be after placing shelves in this manner</em>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2019/06/24/shelves.png" style="height: 500px; width: 337px;">
 * <pre><strong>Input:</strong> books = [[1,1],[2,3],[2,3],[1,1],[1,1],[1,1],[1,2]], shelfWidth = 4
 * <strong>Output:</strong> 6
 * <strong>Explanation:</strong>
 * The sum of the heights of the 3 shelves is 1 + 3 + 2 = 6.
 * Notice that book number 2 does not have to be on the first shelf.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> books = [[1,3],[2,4],[3,2]], shelfWidth = 6
 * <strong>Output:</strong> 4
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= books.length &lt;= 1000</code></li>
 * 	<li><code>1 &lt;= thickness<sub>i</sub> &lt;= shelfWidth &lt;= 1000</code></li>
 * 	<li><code>1 &lt;= height<sub>i</sub> &lt;= 1000</code></li>
 * </ul>
 * </div>
 * 
 */
public class FillingBookcaseShelves {
    public static void main(String[] args) {
        int[][][][] tests = {
            {
                {{4}},
                {
                    {1,1},{2,3},{2,3},{1,1},{1,1},{1,1},{1,2},
                }
            },
        };

        for (int[][][] test : tests) {
            int shelfWidth = test[0][0][0],
                books[][] = test[1];

            System.out.println(new FillingBookcaseShelves_Solution().minHeightShelves(books, shelfWidth));
        }
    }
}

/**
 * 1ms 42.56MB
 */
class FillingBookcaseShelves_Solution {

    public int minHeightShelves(int[][] books, int shelfWidth) {
        // dp[i] = minimum height of bookcase containing all books up to and
        // excluding book i
        int[] dp = new int[books.length + 1];

        // base cases
        dp[0] = 0;
        dp[1] = books[0][1];

        for (int i = 2; i <= books.length; i++) {
            // new shelf built to hold current book
            int remainingShelfWidth = shelfWidth - books[i - 1][0];
            int maxHeight = books[i - 1][1];
            dp[i] = books[i - 1][1] + dp[i - 1];

            int j = i - 1;
            // calculate the height when previous books are added onto a new shelf
            while (j > 0 && remainingShelfWidth - books[j - 1][0] >= 0) {
                maxHeight = Math.max(maxHeight, books[j - 1][1]);
                remainingShelfWidth -= books[j - 1][0];
                dp[i] = Math.min(dp[i], maxHeight + dp[j - 1]);
                j--;
            }
        }

        return dp[books.length];
    }
}