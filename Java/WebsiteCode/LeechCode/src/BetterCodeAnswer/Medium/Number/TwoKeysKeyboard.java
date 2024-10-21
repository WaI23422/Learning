package BetterCodeAnswer.Medium.Number;

import java.util.Arrays;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/2-keys-keyboard/">650. 2 Keys Keyboard</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>There is only one character <code>'A'</code> on the screen of a notepad. You can perform one of two operations on this notepad for each step:</p>
 * 
 * <ul>
 * 	<li>Copy All: You can copy all the characters present on the screen (a partial copy is not allowed).</li>
 * 	<li>Paste: You can paste the characters which are copied last time.</li>
 * </ul>
 * 
 * <p>Given an integer <code>n</code>, return <em>the minimum number of operations to get the character</em> <code>'A'</code> <em>exactly</em> <code>n</code> <em>times on the screen</em>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> n = 3
 * <strong>Output:</strong> 3
 * <strong>Explanation:</strong> Initially, we have one character 'A'.
 * In step 1, we use Copy All operation.
 * In step 2, we use Paste operation to get 'AA'.
 * In step 3, we use Paste operation to get 'AAA'.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> n = 1
 * <strong>Output:</strong> 0
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= n &lt;= 1000</code></li>
 * </ul>
 * </div>
 */
public class TwoKeysKeyboard {
    public static void main(String[] args) {
        int[] tests = {
            // 1,2,3,4,5,
            // 6,
            // 10,
            9,
            1000
        };

        for (int n : tests) {
            System.out.println(new TwoKeysKeyboard_Solution().minSteps(n));
        }
    }
}

// 1ms 40.3MB
class TwoKeysKeyboard_Solution {
    private int[] f;

    public int minSteps(int n) {
        f = new int[n + 1];
        Arrays.fill(f, -1);
        return dfs(n);
    }

    private int dfs(int n) {
        if (n == 1) {
            return 0;
        }
        if (f[n] != -1) {
            return f[n];
        }
        int ans = n;
        for (int i = 2; i * i <= n; ++i) {
            if (n % i == 0) {
                ans = Math.min(ans, dfs(n / i) + i);
            }
        }
        f[n] = ans;
        return ans;
    }
}

// 0ms 40.2MB
class TwoKeysKeyboard_Solution2 {
    public int minSteps(int n) {
       int ans=0;
       for(int i=2;i*i<=n;){
            if(n%i==0){
                ans+=i;
                n=n/i;
            }else{
                i++;
            }
       }
       if(n!=1) ans=ans+n;
       return ans;
    }
}