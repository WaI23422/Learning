package BetterCodeAnswer.Medium.Number;

import java.util.ArrayList;
import java.util.List;

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

// 0ms 40.36MB
class MaximumSwap_Solution {
    public int maximumSwap(int num) {
        List<Integer>arr = new ArrayList<>();
        int x = num;
        while(x > 0){
            arr.add(x%10);
            x/=10;
        }
        int idx = -1;
        int idy = -1;
        int max = -1;
        for(int i = 0; i < arr.size(); i++){
            if(max == -1 || arr.get(max) < arr.get(i)){
                max = i;
            }
            else if(arr.get(max) > arr.get(i)){
                idx =i;
                idy = max;
            }
        }
        if(idx != -1 && idy != -1){
            int temp = arr.get(idx);
            arr.set(idx,arr.get(idy));
            arr.set(idy,temp);
        }
        int curr = 0;
        for(int i = arr.size()-1; i>=0; i--){
            curr*=10;
            curr+=arr.get(i);
        }
        return curr;
    }
}