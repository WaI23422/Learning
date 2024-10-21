package BetterCodeAnswer.Easy.Number;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/hamming-distance/">461. Hamming Distance</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>The <a href="https://en.wikipedia.org/wiki/Hamming_distance" target="_blank">Hamming distance</a> between two integers is the number of positions at which the corresponding bits are different.</p>
 * 
 * <p>Given two integers <code>x</code> and <code>y</code>, return <em>the <strong>Hamming distance</strong> between them</em>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> x = 1, y = 4
 * <strong>Output:</strong> 2
 * <strong>Explanation:</strong>
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 * The above arrows point to positions where the corresponding bits are different.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> x = 3, y = 1
 * <strong>Output:</strong> 1
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>0 &lt;=&nbsp;x, y &lt;= 2<sup>31</sup> - 1</code></li>
 * </ul>
 * </div>
 */
public class HammingDistance {
    public static void main(String[] args) {
        int[][] tests = {
            {1,4},
            {3,1}
        };

        for (int[] test : tests) {
            System.out.println(new HammingDistance_Solution().hammingDistance(test[0], test[1]));
        }
    }   
}

// 0 ms 40.6 MB
class HammingDistance_Solution {
    public int hammingDistance(int x, int y) {
        int t = x ^ y;
        int ans = 0;

        while(t != 0) {
            ans++;
            t &= t - 1;
        }

        return ans;
    }
}