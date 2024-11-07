package Medium.Array;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/largest-combination-with-bitwise-and-greater-than-zero/">2275. Largest Combination With Bitwise AND Greater Than Zero</a>
 * 
 * <div><div class="elfjS" data-track-load="description_content"><p>The <strong>bitwise AND</strong> of an array <code>nums</code> is the bitwise AND of all integers in <code>nums</code>.</p>
 * 
 * <ul>
 * 	<li>For example, for <code>nums = [1, 5, 3]</code>, the bitwise AND is equal to <code>1 &amp; 5 &amp; 3 = 1</code>.</li>
 * 	<li>Also, for <code>nums = [7]</code>, the bitwise AND is <code>7</code>.</li>
 * </ul>
 * 
 * <p>You are given an array of positive integers <code>candidates</code>. Evaluate the <strong>bitwise AND</strong> of every <strong>combination</strong> of numbers of <code>candidates</code>. Each number in <code>candidates</code> may only be used <strong>once</strong> in each combination.</p>
 * 
 * <p>Return <em>the size of the <strong>largest</strong> combination of </em><code>candidates</code><em> with a bitwise AND <strong>greater</strong> than </em><code>0</code>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> candidates = [16,17,71,62,12,24,14]
 * <strong>Output:</strong> 4
 * <strong>Explanation:</strong> The combination [16,17,62,24] has a bitwise AND of 16 &amp; 17 &amp; 62 &amp; 24 = 16 &gt; 0.
 * The size of the combination is 4.
 * It can be shown that no combination with a size greater than 4 has a bitwise AND greater than 0.
 * Note that more than one combination may have the largest size.
 * For example, the combination [62,12,24,14] has a bitwise AND of 62 &amp; 12 &amp; 24 &amp; 14 = 8 &gt; 0.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> candidates = [8,8]
 * <strong>Output:</strong> 2
 * <strong>Explanation:</strong> The largest combination [8,8] has a bitwise AND of 8 &amp; 8 = 8 &gt; 0.
 * The size of the combination is 2, so we return 2.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= candidates.length &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>1 &lt;= candidates[i] &lt;= 10<sup>7</sup></code></li>
 * </ul>
 * </div></div>
 */
public class LargestCombinationWithBitwiseANDGreaterThanZero {
    public static void main(String[] args) {
        int[][] tests = {
            {16,17,71,62,12,24,14}
        };

        for (int[] candidates : tests) {
            System.out.println(new LargestCombinationWithBitwiseANDGreaterThanZero_Solution().largestCombination(candidates));
        }
    }
}


// 32ms 56.6MB
class LargestCombinationWithBitwiseANDGreaterThanZero_Solution {
    public int largestCombination(int[] candidates) {
        int arr[] = new int[30],
            min = Integer.MAX_VALUE,
            len = candidates.length,
            limit = 0;

        for (int i = 0; i < len; i++) {
            int num = candidates[i],
                idx = 0;
            while (num > 0) {
                if ((num&1) == 0) {arr[idx]++;}
                idx++;
                num >>= 1;
            }
            for (int j = idx; j < 30; j++) {
                arr[j]++;
            }
            limit = Math.max(idx,limit);
        }

        for (int i = 0; i < limit; i++){
            min = Math.min(arr[i],min);
        }

        return len - min;
    }
}