package Easy.Arrays;

import java.util.Arrays;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/defuse-the-bomb/">1652. Defuse the Bomb</a>
 * 
 * <div><div class="elfjS" data-track-load="description_content"><p>You have a bomb to defuse, and your time is running out! Your informer will provide you with a <strong>circular</strong> array <code>code</code>&nbsp;of length of <code>n</code>&nbsp;and a key <code>k</code>.</p>
 * 
 * <p>To decrypt the code, you must replace every number. All the numbers are replaced <strong>simultaneously</strong>.</p>
 * 
 * <ul>
 * 	<li>If <code>k &gt; 0</code>, replace the <code>i<sup>th</sup></code> number with the sum of the <strong>next</strong> <code>k</code> numbers.</li>
 * 	<li>If <code>k &lt; 0</code>, replace the <code>i<sup>th</sup></code> number with the sum of the <strong>previous</strong> <code>k</code> numbers.</li>
 * 	<li>If <code>k == 0</code>, replace the <code>i<sup>th</sup></code> number with <code>0</code>.</li>
 * </ul>
 * 
 * <p>As <code>code</code> is circular, the next element of <code>code[n-1]</code> is <code>code[0]</code>, and the previous element of <code>code[0]</code> is <code>code[n-1]</code>.</p>
 * 
 * <p>Given the <strong>circular</strong> array <code>code</code> and an integer key <code>k</code>, return <em>the decrypted code to defuse the bomb</em>!</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> code = [5,7,1,4], k = 3
 * <strong>Output:</strong> [12,10,16,13]
 * <strong>Explanation:</strong> Each number is replaced by the sum of the next 3 numbers. The decrypted code is [7+1+4, 1+4+5, 4+5+7, 5+7+1]. Notice that the numbers wrap around.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> code = [1,2,3,4], k = 0
 * <strong>Output:</strong> [0,0,0,0]
 * <strong>Explanation:</strong> When k is zero, the numbers are replaced by 0. 
 * </pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <pre><strong>Input:</strong> code = [2,4,9,3], k = -2
 * <strong>Output:</strong> [12,5,6,13]
 * <strong>Explanation:</strong> The decrypted code is [3+9, 2+3, 4+2, 9+4]. Notice that the numbers wrap around again. If k is negative, the sum is of the <strong>previous</strong> numbers.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>n == code.length</code></li>
 * 	<li><code>1 &lt;= n&nbsp;&lt;= 100</code></li>
 * 	<li><code>1 &lt;= code[i] &lt;= 100</code></li>
 * 	<li><code>-(n - 1) &lt;= k &lt;= n - 1</code></li>
 * </ul>
 * </div></div>
 */
public class DefuseTheBomb {
    public static void main(String[] args) {
        int[][][] tests = {
            {
                {2,4,9,3},
                {-2}
            },
            {
                {5,7,1,4},
                {3}
            },
        };

        for (int[][] test : tests) {
            int code[] = test[0],
                k = test[1][0];

            System.out.println(Arrays.toString(new DefuseTheBomb_Solution().decrypt(code, k)));
        }
    }
}

// 0ms 41.70MB
class DefuseTheBomb_Solution {
    public int[] decrypt(int[] code, int k) {
        int len = code.length,
            ans[] = new int[len];
        if (k == 0) { return ans;}

        if (k > 0) {
            int idx = 0;
            while (idx < k) {
                ans[0] += code[(++idx % len)];
            }
            
            for (int i = 1; i < len; i++) {
                ans[i] = ans[i-1] - code[i%len] + code[(i+k)%len];
            }
        } else {
            k = Math.abs(k);
            int idx = 0;
            while (idx < k) { ans[0] += code[len-1-(idx++ % len)]; }

            for (int i = 1; i < len; i++) {
                ans[i] = ans[i-1] + code[(i-1)%len] - code[(len-1-k+i)%len];
            }
        }

        return ans;
    }
}

// Time Limit Exceeded
class DefuseTheBomb_Solution1 {
    public int[] decrypt(int[] code, int k) {
        int len = code.length,
            ans[] = new int[len];
        if (k == 0) { return ans;}

        if (k > 0) {
            for (int i = 0; i < len; i++) {
                int idx = i + 1;
                while (idx < k) {
                    ans[i] += code[(idx % len)];
                }
            }
        } else {
            k = Math.abs(k);
            for (int i = 0; i < len; i++) {
                int idx = i + 1;
                while (idx < k) {
                    ans[i] += code[len-(idx % len)];
                }
            }
        }

        return ans;
    }
}