package BetterCodeAnswer.Easy.Arrays;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/three-consecutive-odds/">1550. Three Consecutive Odds</a>
 * 
 * <div class="elfjS" data-track-load="description_content">Given an integer array <code>arr</code>, return <code>true</code>&nbsp;if there are three consecutive odd numbers in the array. Otherwise, return&nbsp;<code>false</code>.
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> arr = [2,6,4,1]
 * <strong>Output:</strong> false
 * <b>Explanation:</b> There are no three consecutive odds.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> arr = [1,2,34,3,4,5,7,23,12]
 * <strong>Output:</strong> true
 * <b>Explanation:</b> [5,7,23] are three consecutive odds.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= arr.length &lt;= 1000</code></li>
 * 	<li><code>1 &lt;= arr[i] &lt;= 1000</code></li>
 * </ul>
 * </div>
 */
public class ThreeConsecutiveOdds {
    public static void main(String[] args) {
        int[][] tests = {
            {2,6,4,1},
            {1,2,34,3,4,5,7,23,12}
        };

        for (int[] arr : tests) {
            System.out.println(new threeConsecutiveOdds_Solution().threeConsecutiveOdds(arr));
        }
    }
}

// 0 ms 42.3 MB
class threeConsecutiveOdds_Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int len = arr.length;
        int i,c=0;
        for(i=0;i<len-2;i++)
        {
            if(arr[i]%2!=0 && arr[i+1]%2!=0)
            {
                if(arr[i+2]%2!=0)
                {
                    c++;
                }
               
            }
        }

        if(c!=0)
            return true;
        else
            return false;
       
    }
}