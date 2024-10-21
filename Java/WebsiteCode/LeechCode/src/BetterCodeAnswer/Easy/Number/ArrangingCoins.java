package BetterCodeAnswer.Easy.Number;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/arranging-coins/">441. Arranging Coins</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You have <code>n</code> coins and you want to build a staircase with these coins. The staircase consists of <code>k</code> rows where the <code>i<sup>th</sup></code> row has exactly <code>i</code> coins. The last row of the staircase <strong>may be</strong> incomplete.</p>
 * 
 * <p>Given the integer <code>n</code>, return <em>the number of <strong>complete rows</strong> of the staircase you will build</em>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/04/09/arrangecoins1-grid.jpg" style="width: 253px; height: 253px;">
 * <pre><strong>Input:</strong> n = 5
 * <strong>Output:</strong> 2
 * <strong>Explanation:</strong> Because the 3<sup>rd</sup> row is incomplete, we return 2.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/04/09/arrangecoins2-grid.jpg" style="width: 333px; height: 333px;">
 * <pre><strong>Input:</strong> n = 8
 * <strong>Output:</strong> 3
 * <strong>Explanation:</strong> Because the 4<sup>th</sup> row is incomplete, we return 3.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= n &lt;= 2<sup>31</sup> - 1</code></li>
 * </ul>
 * </div>
 */
public class ArrangingCoins {
    public static void main(String[] args) {
        int[] tests = {
            5,
            4,
            3,
            2,
            1,
            0
        };        
        
        for (int n : tests) {
            System.out.println(new ArrangingCoins_Solution().arrangeCoins(n));
        }
    }
}

// 1 ms 40.8 MB
class ArrangingCoins_Solution {
    public int arrangeCoins(int n) {
        return (int)((Math.sqrt(1 + 8 * (long)n) - 1) / 2);
    }
}