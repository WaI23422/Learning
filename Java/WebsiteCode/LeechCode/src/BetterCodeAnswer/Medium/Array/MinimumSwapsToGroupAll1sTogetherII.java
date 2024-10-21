package BetterCodeAnswer.Medium.Array;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/minimum-swaps-to-group-all-1s-together-ii/">2134. Minimum Swaps to Group All 1's Together II</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>A <strong>swap</strong> is defined as taking two <strong>distinct</strong> positions in an array and swapping the values in them.</p>
 * 
 * <p>A <strong>circular</strong> array is defined as an array where we consider the <strong>first</strong> element and the <strong>last</strong> element to be <strong>adjacent</strong>.</p>
 * 
 * <p>Given a <strong>binary</strong> <strong>circular</strong> array <code>nums</code>, return <em>the minimum number of swaps required to group all </em><code>1</code><em>'s present in the array together at <strong>any location</strong></em>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [0,1,0,1,1,0,0]
 * <strong>Output:</strong> 1
 * <strong>Explanation:</strong> Here are a few of the ways to group all the 1's together:
 * [0,<u>0</u>,<u>1</u>,1,1,0,0] using 1 swap.
 * [0,1,<u>1</u>,1,<u>0</u>,0,0] using 1 swap.
 * [1,1,0,0,0,0,1] using 2 swaps (using the circular property of the array).
 * There is no way to group all 1's together with 0 swaps.
 * Thus, the minimum number of swaps required is 1.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [0,1,1,1,0,0,1,1,0]
 * <strong>Output:</strong> 2
 * <strong>Explanation:</strong> Here are a few of the ways to group all the 1's together:
 * [1,1,1,0,0,0,0,1,1] using 2 swaps (using the circular property of the array).
 * [1,1,1,1,1,0,0,0,0] using 2 swaps.
 * There is no way to group all 1's together with 0 or 1 swaps.
 * Thus, the minimum number of swaps required is 2.
 * </pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [1,1,0,0,1]
 * <strong>Output:</strong> 0
 * <strong>Explanation:</strong> All the 1's are already grouped together due to the circular property of the array.
 * Thus, the minimum number of swaps required is 0.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>nums[i]</code> is either <code>0</code> or <code>1</code>.</li>
 * </ul>
 * </div>
 */
public class MinimumSwapsToGroupAll1sTogetherII {
    public static void main(String[] args) {
        int[][] tests= {
            {1,1,0},
            {0,1},
            {1},
            {0,1,0,1,1,0,0},
            {1,1,0,0,1}
        };

        for (int[] nums : tests) {
            System.out.println(new MinimumSwapsToGroupAll1sTogetherII_Solution().minSwaps(nums));
        }
    }
}

// 3ms 59.35MB
class MinimumSwapsToGroupAll1sTogetherII_Solution {
    public int minSwaps(int[] nums) {
        int k=0;
        for(int i=0;i<nums.length;i++){
            k+=nums[i];
        }
        int sum=0; int min=nums.length;
        for(int j=0;j<nums.length;j++){
            sum+=nums[j];
            if(j>=k){sum-=nums[j-k];}
            if(j>=k-1)min=Math.min(min,k-sum);
        }
        for(int i=0;i<=k-2;i++){
            //length-k,...,length-1
            //length-k+1 - 0; length-k+2 - 1; length-k+3 - 2;
            sum=sum+nums[i]-nums[nums.length-k+i];
            min=Math.min(min,k-sum);
        }
        return min;
    }
}
