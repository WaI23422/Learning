package Medium.Array;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/minimum-limit-of-balls-in-a-bag/">1760. Minimum Limit of Balls in a Bag</a>
 * 
 * <div><div class="elfjS" data-track-load="description_content"><p>You are given an integer array <code>nums</code> where the <code>i<sup>th</sup></code> bag contains <code>nums[i]</code> balls. You are also given an integer <code>maxOperations</code>.</p>
 * 
 * <p>You can perform the following operation at most <code>maxOperations</code> times:</p>
 * 
 * <ul>
 * 	<li>Take any bag of balls and divide it into two new bags with a <strong>positive </strong>number of balls.
 * 
 * 	<ul>
 * 		<li>For example, a bag of <code>5</code> balls can become two new bags of <code>1</code> and <code>4</code> balls, or two new bags of <code>2</code> and <code>3</code> balls.</li>
 * 	</ul>
 * 	</li>
 * </ul>
 * 
 * <p>Your penalty is the <strong>maximum</strong> number of balls in a bag. You want to <strong>minimize</strong> your penalty after the operations.</p>
 * 
 * <p>Return <em>the minimum possible penalty after performing the operations</em>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [9], maxOperations = 2
 * <strong>Output:</strong> 3
 * <strong>Explanation:</strong> 
 * - Divide the bag with 9 balls into two bags of sizes 6 and 3. [<strong><u>9</u></strong>] -&gt; [6,3].
 * - Divide the bag with 6 balls into two bags of sizes 3 and 3. [<strong><u>6</u></strong>,3] -&gt; [3,3,3].
 * The bag with the most number of balls has 3 balls, so your penalty is 3 and you should return 3.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [2,4,8,2], maxOperations = 4
 * <strong>Output:</strong> 2
 * <strong>Explanation:</strong>
 * - Divide the bag with 8 balls into two bags of sizes 4 and 4. [2,4,<strong><u>8</u></strong>,2] -&gt; [2,4,4,4,2].
 * - Divide the bag with 4 balls into two bags of sizes 2 and 2. [2,<strong><u>4</u></strong>,4,4,2] -&gt; [2,2,2,4,4,2].
 * - Divide the bag with 4 balls into two bags of sizes 2 and 2. [2,2,2,<strong><u>4</u></strong>,4,2] -&gt; [2,2,2,2,2,4,2].
 * - Divide the bag with 4 balls into two bags of sizes 2 and 2. [2,2,2,2,2,<strong><u>4</u></strong>,2] -&gt; [2,2,2,2,2,2,2,2].
 * The bag with the most number of balls has 2 balls, so your penalty is 2, and you should return 2.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>1 &lt;= maxOperations, nums[i] &lt;= 10<sup>9</sup></code></li>
 * </ul>
 * </div></div>
 */
public class MinimumLimitOfBallsInABag {
    public static void main(String[] args) {
        
    }
}

// 84ms 60.99MB
class MinimumLimitOfBallsInABag_Solution {

    public int minimumSize(int[] nums, int maxOperations) {
        // Binary search bounds
        int left = 1;
        int right = 0;

        for (int num : nums) {
            right = Math.max(right, num);
        }

        // Perform binary search to find the optimal maxBallsInBag
        while (left < right) {
            int middle = (left + right) / 2;

            // Check if a valid distribution is possible with the current middle value
            if (isPossible(middle, nums, maxOperations)) {
                right = middle; // If possible, try a smaller value (shift right to middle)
            } else {
                left = middle + 1; // If not possible, try a larger value (shift left to middle + 1)
            }
        }

        // Return the smallest possible value for maxBallsInBag
        return left;
    }

    // Helper function to check if a distribution is possible for a given maxBallsInBag
    private boolean isPossible(
        int maxBallsInBag,
        int[] nums,
        int maxOperations
    ) {
        int totalOperations = 0;

        // Iterate through each bag in the array
        for (int num : nums) {
            // Calculate the number of operations needed to split this bag
            int operations = (int) Math.ceil(num / (double) maxBallsInBag) - 1;
            totalOperations += operations;

            // If total operations exceed maxOperations, return false
            if (totalOperations > maxOperations) {
                return false;
            }
        }

        // We can split the balls within the allowed operations, return true
        return true;
    }
}