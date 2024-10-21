package Medium.Number;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/maximum-swap/">670. Maximum Swap</a>
 * 
 * <div><div class="elfjS" data-track-load="description_content"><p>You are given an integer <code>num</code>. You can swap two digits at most once to get the maximum valued number.</p>
 * 
 * <p>Return <em>the maximum valued number you can get</em>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> num = 2736
 * <strong>Output:</strong> 7236
 * <strong>Explanation:</strong> Swap the number 2 and the number 7.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> num = 9973
 * <strong>Output:</strong> 9973
 * <strong>Explanation:</strong> No swap.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>0 &lt;= num &lt;= 10<sup>8</sup></code></li>
 * </ul>
 * </div></div>
 */
public class MaximumSwap {
    public static void main(String[] args) {
        int[] tests = {
            1,
            0,
            2736,
            9973
        };

        for (int num : tests) {
            System.out.println(new MaximumSwap_Solution().maximumSwap(num));
        }
    }
}

// 0ms 40.28MB
class MaximumSwap_Solution {
    public int maximumSwap(int num) {
        int num_arr[] = new int[9],
            idx = 0,
            quick_pow_10[] = {
                1, 10, 100,
                1_000, 10_000,
                100_000, 1_000_000,
                10_000_000, 100_000_000
            };
        
        int temp_num = num;
        while (temp_num > 0) {
            num_arr[idx++] = temp_num%10;
            temp_num/=10;
        }

        int max = num;
        for (int i = 0; i < idx; i++) {
            for (int j = i+1; j < idx; j++) {
                max = Math.max(
                    max, 
                    num-num_arr[i]*quick_pow_10[i] + num_arr[i]*quick_pow_10[j]
                    - num_arr[j]*quick_pow_10[j] + num_arr[j]*quick_pow_10[i]
                );
            }
        }

        return max;
    }
}