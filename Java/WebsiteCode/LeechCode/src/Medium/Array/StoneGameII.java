package Medium.Array;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/stone-game-ii/">1140. Stone Game II</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Alice and Bob continue their&nbsp;games with piles of stones.&nbsp; There are a number of&nbsp;piles&nbsp;<strong>arranged in a row</strong>, and each pile has a positive integer number of stones&nbsp;<code>piles[i]</code>.&nbsp; The objective of the game is to end with the most&nbsp;stones.&nbsp;</p>
 * 
 * <p>Alice&nbsp;and Bob take turns, with Alice starting first.&nbsp; Initially, <code>M = 1</code>.</p>
 * 
 * <p>On each player's turn, that player&nbsp;can take <strong>all the stones</strong> in the <strong>first</strong> <code>X</code> remaining piles, where <code>1 &lt;= X &lt;= 2M</code>.&nbsp; Then, we set&nbsp;<code>M = max(M, X)</code>.</p>
 * 
 * <p>The game continues until all the stones have been taken.</p>
 * 
 * <p>Assuming Alice and Bob play optimally, return the maximum number of stones Alice&nbsp;can get.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> piles = [2,7,9,4,4]
 * <strong>Output:</strong> 10
 * <strong>Explanation:</strong>  If Alice takes one pile at the beginning, Bob takes two piles, then Alice takes 2 piles again. Alice can get 2 + 4 + 4 = 10 piles in total. If Alice takes two piles at the beginning, then Bob can take all three piles left. In this case, Alice get 2 + 7 = 9 piles in total. So we return 10 since it's larger. 
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> piles = [1,2,3,4,5,100]
 * <strong>Output:</strong> 104
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= piles.length &lt;= 100</code></li>
 * 	<li><code>1 &lt;= piles[i]&nbsp;&lt;= 10<sup>4</sup></code></li>
 * </ul>
 * </div>
 * 
 * 
 */
public class StoneGameII {
    public static void main(String[] args) {
        int[][] tests = {
            {
                2,7,9,4,4
            }
        };

        for (int[] piles : tests) {
            System.out.println(new StoneGameII_Solution().stoneGameII(piles));
        }
    }   
}

// 8ms 42.34MB
class StoneGameII_Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        
        int[][] dp = new int[n][n + 1];
        int[] suffixSum = new int[n];
        suffixSum[n - 1] = piles[n - 1];
        
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }
        
        for (int i = n - 1; i >= 0; i--) {
            for (int m = 1; m <= n; m++) {
                if (i + 2 * m >= n) {
                    dp[i][m] = suffixSum[i];
                } else {
                    for (int x = 1; x <= 2 * m; x++) {
                        dp[i][m] = Math.max(dp[i][m], suffixSum[i] - dp[i + x][Math.max(m, x)]);
                    }
                }
            }
        }
        
        return dp[0][1];
    }
}