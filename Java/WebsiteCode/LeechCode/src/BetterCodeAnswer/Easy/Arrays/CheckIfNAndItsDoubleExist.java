package BetterCodeAnswer.Easy.Arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/check-if-n-and-its-double-exist/">1346. Check If N and Its Double Exist</a>
 * 
 * <div><div class="elfjS" data-track-load="description_content"><p>Given an array <code>arr</code> of integers, check if there exist two indices <code>i</code> and <code>j</code> such that :</p>
 * 
 * <ul>
 * 	<li><code>i != j</code></li>
 * 	<li><code>0 &lt;= i, j &lt; arr.length</code></li>
 * 	<li><code>arr[i] == 2 * arr[j]</code></li>
 * </ul>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> arr = [10,2,5,3]
 * <strong>Output:</strong> true
 * <strong>Explanation:</strong> For i = 0 and j = 2, arr[i] == 10 == 2 * 5 == 2 * arr[j]
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> arr = [3,1,7,11]
 * <strong>Output:</strong> false
 * <strong>Explanation:</strong> There is no i and j that satisfy the conditions.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>2 &lt;= arr.length &lt;= 500</code></li>
 * 	<li><code>-10<sup>3</sup> &lt;= arr[i] &lt;= 10<sup>3</sup></code></li>
 * </ul>
 * </div></div>
 */
public class CheckIfNAndItsDoubleExist {
    public static void main(String[] args) {
        
    }
}

// 2ms 43.27MB
class CheckIfNAndItsDoubleExist_Solution {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> seen = new HashSet<>();

        for (int num : arr) {
            // Check if 2 * num or num / 2 exists in the set
            if (
                seen.contains(2 * num) ||
                (num % 2 == 0 && seen.contains(num / 2))
            ) {
                return true;
            }
            // Add the current number to the set
            seen.add(num);
        }
        // No valid pair found
        return false;
    }
}