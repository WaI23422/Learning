package BetterCodeAnswer.Easy.Arrays;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/array-partition/">561. Array Partition</a>
 * 
 * <div><div class="elfjS" data-track-load="description_content"><p>Given an integer array <code>nums</code> of <code>2n</code> integers, group these integers into <code>n</code> pairs <code>(a<sub>1</sub>, b<sub>1</sub>), (a<sub>2</sub>, b<sub>2</sub>), ..., (a<sub>n</sub>, b<sub>n</sub>)</code> such that the sum of <code>min(a<sub>i</sub>, b<sub>i</sub>)</code> for all <code>i</code> is <strong>maximized</strong>. Return<em> the maximized sum</em>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [1,4,3,2]
 * <strong>Output:</strong> 4
 * <strong>Explanation:</strong> All possible pairings (ignoring the ordering of elements) are:
 * 1. (1, 4), (2, 3) -&gt; min(1, 4) + min(2, 3) = 1 + 2 = 3
 * 2. (1, 3), (2, 4) -&gt; min(1, 3) + min(2, 4) = 1 + 2 = 3
 * 3. (1, 2), (3, 4) -&gt; min(1, 2) + min(3, 4) = 1 + 3 = 4
 * So the maximum possible sum is 4.</pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [6,2,6,5,1,2]
 * <strong>Output:</strong> 9
 * <strong>Explanation:</strong> The optimal pairing is (2, 1), (2, 5), (6, 6). min(2, 1) + min(2, 5) + min(6, 6) = 1 + 2 + 6 = 9.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= n &lt;= 10<sup>4</sup></code></li>
 * 	<li><code>nums.length == 2 * n</code></li>
 * 	<li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
 * </ul>
 * </div></div>
 */
public class ArrayPartition {
    public static void main(String[] args) {
        int[][] tests = {
            {1,4,3,2}
        };

        for (int[] nums : tests) {
            System.out.println(new ArrayPartition_Solution().arrayPairSum(nums));
        }
    }       
}

// 4ms 46.34MB
class ArrayPartition_Solution {
    public int arrayPairSum(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(num, max);
            min = Math.min(num, min);
        }
        int[] counts = new int[max - min + 1];
        for (int num : nums) {
            counts[num - min]++;
        }
        int res = 0;
        int idx = 0;
        for (int i = 0; i < nums.length / 2; i++) {
            while (counts[idx] == 0) {
                idx++;
            }
            res += idx;
            counts[idx]--;
            while (counts[idx] == 0) {
                idx++;
            }
            counts[idx]--;
        }
        return res + nums.length / 2 * min;
    }
}

// 5ms 46.08MB
class ArrayPartition_Solution2 {
    final static int K = 10000;
    
    public int arrayPairSum(int[] nums) {
        // Store the frequency of each element
        int[] elementToCount = new int[2 * K + 1];
        for (int element : nums) {
            // Add K to element to offset negative values
            elementToCount[element + K]++;
        }
        
        // Initialize sum to zero
        int maxSum = 0;
        boolean isEvenIndex = true;
        for (int element = 0; element <= 2 * K; element++) {
            while (elementToCount[element] > 0) {
                // Add element if it is at even position
                maxSum += (isEvenIndex ? element - K : 0);
                // Flip the value (one to zero or zero to one)
                isEvenIndex = !isEvenIndex;
                // Decrement the frequency count
                elementToCount[element]--;
            }
        }
        return maxSum;
    }
}

// 6ms 46.26MB
class ArrayPartition_Solution3 {
    public int arrayPairSum(int[] nums) {
        int shift = 10000;
        int[] freq = new int[20001];

        for (int i : nums) {
            freq[i + shift]++;
        }

        int sum = 0, k = 1;

        for (int i = 0; i < 20001; i++) {
            while (freq[i]-- != 0) {
                sum += (i - shift) * k;
                k ^= 1;
            }
        }

        return sum;
    }
}