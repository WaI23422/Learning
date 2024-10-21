package BetterCodeAnswer.Medium.Array;

import java.util.Arrays;

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

// 2ms 42.34MB
class StoneGameII_Solution {

    public int stoneGameII(int[] piles) {
        // Store the suffix sum of all array elements.
        int[] suffixSum = Arrays.copyOf(piles, piles.length);

        for (int i = suffixSum.length - 2; i >= 0; i--) {
            suffixSum[i] += suffixSum[i + 1];
        }
        return maxStones(suffixSum, 1, 0, new int[piles.length][piles.length]);
    }

    private int maxStones(
        int[] suffixSum,
        int maxTillNow,
        int currIndex,
        int[][] memo
    ) {
        // If currIndex + 2*maxTillNow lies outside the array, pick all remaining stones.
        if (currIndex + 2 * maxTillNow >= suffixSum.length) {
            return suffixSum[currIndex];
        }
        if (memo[currIndex][maxTillNow] > 0) return memo[currIndex][maxTillNow];
        int res = Integer.MAX_VALUE;
        // Find the minimum value res for the next move possible.
        for (int i = 1; i <= 2 * maxTillNow; i++) {
            res = Math.min(
                res,
                maxStones(
                    suffixSum,
                    Math.max(i, maxTillNow),
                    currIndex + i,
                    memo
                )
            );
        }
        // Memoize the difference of suffixSum[p] and res. This denotes the maximum
        // stones that can be picked.
        memo[currIndex][maxTillNow] = suffixSum[currIndex] - res;
        return memo[currIndex][maxTillNow];
    }
}

// 3ms 42.27MB
class StoneGameII_Solution2 {
    public int stoneGameII(int[] piles) {
      final int n = piles.length;
      int[][] mem = new int[n][n];
      int[] suffix = new int[n]; // suffix[i] := sum(piles[i..n))
      Arrays.stream(mem).forEach(A -> Arrays.fill(A, -1));
      suffix[n - 1] = piles[n - 1];
      for (int i = n - 2; i >= 0; --i)
        suffix[i] = suffix[i + 1] + piles[i];
      return stoneGameII(suffix, 0, 1, mem);
    }
  
    // Returns the maximum number of stones Alice can get from piles[i..n) with M.
    private int stoneGameII(int[] suffix, int i, int M, int[][] mem) {
      if (i + 2 * M >= suffix.length)
        return suffix[i];
      if (mem[i][M] != -1)
        return mem[i][M];
  
      int opponent = suffix[i];
  
      for (int X = 1; X <= 2 * M; ++X)
        opponent = Math.min(opponent, stoneGameII(suffix, i + X, Math.max(M, X), mem));
  
      return mem[i][M] = suffix[i] - opponent;
    }
  }