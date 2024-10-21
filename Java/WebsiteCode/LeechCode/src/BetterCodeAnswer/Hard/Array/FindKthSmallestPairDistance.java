package BetterCodeAnswer.Hard.Array;

import java.util.Arrays;

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

// 7ms 44.88MB
class FindKthSmallestPairDistance_Solution2  {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int s=0,e=nums[nums.length-1]-nums[0];
        while(s<e){
            int mid=(s+e)/2;
            int cnt=0;
            int j=1;
            
            for(int i=0;i<nums.length;i++){
                while(j<nums.length&&nums[j]-nums[i]<=mid) j++;
                cnt+=j-i-1;
            }

            if (cnt<k) s=mid+1;
            else e=mid;
        }
        return s;
    }
}

// 6ms 44.88MB
class FindKthSmallestPairDistance_Solution {

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int arraySize = nums.length;

        // Initialize binary search range
        int low = 0;
        int high = nums[arraySize - 1] - nums[0];

        while (low < high) {
            int mid = (low + high) / 2;

            // Count pairs with distance <= mid
            int count = countPairsWithMaxDistance(nums, mid);

            // Adjust binary search bounds based on count
            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    // Count number of pairs with distance <= maxDistance using a moving window
    private int countPairsWithMaxDistance(int[] nums, int maxDistance) {
        int count = 0;
        int arraySize = nums.length;
        int left = 0;

        for (int right = 0; right < arraySize; ++right) {
            // Adjust the left pointer to maintain the window with distances <=
            // maxDistance
            while (nums[right] - nums[left] > maxDistance) {
                ++left;
            }
            // Add the number of valid pairs ending at the current right index
            count += right - left;
        }
        return count;
    }
}