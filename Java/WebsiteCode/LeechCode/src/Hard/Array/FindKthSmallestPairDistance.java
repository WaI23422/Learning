package Hard.Array;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/find-k-th-smallest-pair-distance/">719. Find K-th Smallest Pair Distance</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>The <strong>distance of a pair</strong> of integers <code>a</code> and <code>b</code> is defined as the absolute difference between <code>a</code> and <code>b</code>.</p>
 * 
 * <p>Given an integer array <code>nums</code> and an integer <code>k</code>, return <em>the</em> <code>k<sup>th</sup></code> <em>smallest <strong>distance among all the pairs</strong></em> <code>nums[i]</code> <em>and</em> <code>nums[j]</code> <em>where</em> <code>0 &lt;= i &lt; j &lt; nums.length</code>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [1,3,1], k = 1
 * <strong>Output:</strong> 0
 * <strong>Explanation:</strong> Here are all the pairs:
 * (1,3) -&gt; 2
 * (1,1) -&gt; 0
 * (3,1) -&gt; 2
 * Then the 1<sup>st</sup> smallest distance pair is (1,1), and its distance is 0.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [1,1,1], k = 2
 * <strong>Output:</strong> 0
 * </pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [1,6,1], k = 3
 * <strong>Output:</strong> 5
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>n == nums.length</code></li>
 * 	<li><code>2 &lt;= n &lt;= 10<sup>4</sup></code></li>
 * 	<li><code>0 &lt;= nums[i] &lt;= 10<sup>6</sup></code></li>
 * 	<li><code>1 &lt;= k &lt;= n * (n - 1) / 2</code></li>
 * </ul>
 * </div>
 */
public class FindKthSmallestPairDistance {
    public static void main(String[] args) {
        int[][][] tests = {
            {
                {1,3,1},
                {1}
            }
        };

        for (int[][] test : tests) {
            int nums[] = test[0],
                k = test[1][0];

            System.out.println(new FindKthSmallestPairDistance_Solution().smallestDistancePair(nums, k));
        }
    }
}

// 381ms 44.88MB
class FindKthSmallestPairDistance_Solution {
    public int smallestDistancePair(int[] nums, int k) {
        // Find min-max:
        int min = 1_000_000,
            max = 0,
            len = nums.length;
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            if (num < min) {min = num;}
            if (num > max) {max = num;}
        }

        int[] distances = new int[max-min+1];

        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                distances[Math.abs(nums[i]-nums[j])]++;
            }
        }

        for (int i = 0; i < distances.length; i++) {
            int distance = distances[i];
            if (distance < k) {
                k -= distance;
            } else {
                return i;
            }
        }

        return -1;
    }
}