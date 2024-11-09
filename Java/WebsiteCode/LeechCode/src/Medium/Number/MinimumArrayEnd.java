package Medium.Number;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/minimum-array-end/">3133. Minimum Array End</a>
 * 
 * <div><div class="elfjS" data-track-load="description_content"><p>You are given two integers <code>n</code> and <code>x</code>. You have to construct an array of <strong>positive</strong> integers <code>nums</code> of size <code>n</code> where for every <code>0 &lt;= i &lt; n - 1</code>, <code>nums[i + 1]</code> is <strong>greater than</strong> <code>nums[i]</code>, and the result of the bitwise <code>AND</code> operation between all elements of <code>nums</code> is <code>x</code>.</p>
 * 
 * <p>Return the <strong>minimum</strong> possible value of <code>nums[n - 1]</code>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <div class="example-block">
 * <p><strong>Input:</strong> <span class="example-io">n = 3, x = 4</span></p>
 * 
 * <p><strong>Output:</strong> <span class="example-io">6</span></p>
 * 
 * <p><strong>Explanation:</strong></p>
 * 
 * <p><code>nums</code> can be <code>[4,5,6]</code> and its last element is 6.</p>
 * </div>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <div class="example-block">
 * <p><strong>Input:</strong> <span class="example-io">n = 2, x = 7</span></p>
 * 
 * <p><strong>Output:</strong> <span class="example-io">15</span></p>
 * 
 * <p><strong>Explanation:</strong></p>
 * 
 * <p><code>nums</code> can be <code>[7,15]</code> and its last element is 15.</p>
 * </div>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= n, x &lt;= 10<sup>8</sup></code></li>
 * </ul>
 * </div></div>
 */
public class MinimumArrayEnd {
   public static void main(String[] args) {
        int[][] tests = {
            {6715154,7193485},
            {3,1},
            {2,7},
            {3,4},
        };

        for (int[] test : tests) {
            int n = test[0],
                x = test[1];

            System.out.println(new MinimumArrayEnd_Solution().minEnd(n, x));
        }
   } 
}

// 1ms 41.05MB
class MinimumArrayEnd_Solution {
    public long minEnd(int n, int x) {
        int x_bit[] = new int[31],
            idx = 0;

        while (x > 0) {
            int bit = x&1;
            x_bit[idx++] = bit;
            x>>=1;
        }

        n--;
        long ans = 0;
        for (int i = 0; i < idx; i++) {
            if (x_bit[i] == 0 && n>0) {
                x_bit[i] |= n&1;
                n>>=1;
            } 
 
            ans += (x_bit[i] << i);
        }

        return n > 0 ?  ( (long) n << idx) + ans : ans;
    }
}