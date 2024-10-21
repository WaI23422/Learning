package Medium.Array;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/count-number-of-nice-subarrays/">1248. Count Number of Nice Subarrays</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given an array of integers <code>nums</code> and an integer <code>k</code>. A continuous subarray is called <strong>nice</strong> if there are <code>k</code> odd numbers on it.</p>
 * 
 * <p>Return <em>the number of <strong>nice</strong> sub-arrays</em>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [1,1,2,1,1], k = 3
 * <strong>Output:</strong> 2
 * <strong>Explanation:</strong> The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [2,4,6], k = 1
 * <strong>Output:</strong> 0
 * <strong>Explanation:</strong> There are no odd numbers in the array.
 * </pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [2,2,2,1,2,2,1,2,2,2], k = 2
 * <strong>Output:</strong> 16
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= nums.length &lt;= 50000</code></li>
 * 	<li><code>1 &lt;= nums[i] &lt;= 10^5</code></li>
 * 	<li><code>1 &lt;= k &lt;= nums.length</code></li>
 * </ul>
 * </div>
 */
public class CountNumberOfNiceSubarrays {
    public static void main(String[] args) {
        int[][][] tests  = {
            {
                {1,1,2,1,1},
                {3}
            },
            {
                {2,2,2,1,2,2,1,2,2,2},
                {2}
            },
        };

        for (int[][] test : tests) {
            int nums[] = test[0],
                k = test[1][0];

            System.out.println(new CountNumberOfNiceSubarrays_Solution().numberOfSubarrays(nums, k));
        }
    }
}

// 7 ms 54.8 MB
class CountNumberOfNiceSubarrays_Solution {
    // Time Limit Exceeded:
    // public int numberOfSubarrays(int[] nums, int k) {
    //     int oddSubArray = 0,
    //         oddVal = 0;

    //     for (int i = 0; i < nums.length; i++) {
    //         if (nums[i]%2 == 1) {oddVal++;}

    //         int idx = 0,
    //             tempOdd = oddVal;
    //         while (idx <= i && tempOdd >= k) {
    //             if (tempOdd == k) {oddSubArray++;}
    //             tempOdd -= nums[idx++]%2 == 0 ? 0 : 1; 
    //         }
    //     }

    //     return oddSubArray;
    // }

    public int numberOfSubarrays(int[] nums, int k) {
        int left = 0,
            right = 0,
            oddNum = 0,
            evenNum = 0,
            oddSubArray = 0;

        while (right < nums.length) {
            if (nums[right++]%2 == 1) {
                oddNum++;
                if (oddNum > k) {
                    oddNum--;
                    evenNum=0;
                }
                
                if (oddNum == k) {
                    while (nums[left++]%2 == 0) { evenNum++; }
                    oddSubArray+= evenNum+1;
                }
            } else {
                if (oddNum == k) {
                    oddSubArray += evenNum+1;
                }
            }
        }

        return oddSubArray;
    }
}

