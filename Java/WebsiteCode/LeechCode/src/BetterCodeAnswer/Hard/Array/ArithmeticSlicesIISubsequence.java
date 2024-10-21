package BetterCodeAnswer.Hard.Array;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/arithmetic-slices-ii-subsequence/">446.Arithmetic Slices II - Subsequence</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>Given an integer array <code>nums</code>, return <em>the number of all the <strong>arithmetic subsequences</strong> of</em> <code>nums</code>.</p>

<p>A sequence of numbers is called arithmetic if it consists of <strong>at least three elements</strong> and if the difference between any two consecutive elements is the same.</p>

<ul>
	<li>For example, <code>[1, 3, 5, 7, 9]</code>, <code>[7, 7, 7, 7]</code>, and <code>[3, -1, -5, -9]</code> are arithmetic sequences.</li>
	<li>For example, <code>[1, 1, 2, 5, 7]</code> is not an arithmetic sequence.</li>
</ul>

<p>A <strong>subsequence</strong> of an array is a sequence that can be formed by removing some elements (possibly none) of the array.</p>

<ul>
	<li>For example, <code>[2,5,10]</code> is a subsequence of <code>[1,2,1,<strong><u>2</u></strong>,4,1,<u><strong>5</strong></u>,<u><strong>10</strong></u>]</code>.</li>
</ul>

<p>The test cases are generated so that the answer fits in <strong>32-bit</strong> integer.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [2,4,6,8,10]
<strong>Output:</strong> 7
<strong>Explanation:</strong> All arithmetic subsequence slices are:
[2,4,6]
[4,6,8]
[6,8,10]
[2,4,6,8]
[4,6,8,10]
[2,4,6,8,10]
[2,6,10]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [7,7,7,7,7]
<strong>Output:</strong> 16
<strong>Explanation:</strong> Any subsequence of this array is arithmetic.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1&nbsp; &lt;= nums.length &lt;= 1000</code></li>
	<li><code>-2<sup>31</sup> &lt;= nums[i] &lt;= 2<sup>31</sup> - 1</code></li>
</ul>
</div></div>
 */
public class ArithmeticSlicesIISubsequence {
    public static void main(String[] args) {
        int[][] tests = {
            {2,4,6,8,10},
            {7,7,7,7,7},
        };

        for (int[] nums : tests) {
            System.out.println(new ArithmeticSlicesIISubsequence_Solution().numberOfArithmeticSlices(nums));
        }
    }
}


// 132 ms 90.4 MB
/**
 * <h1 id="approach">Approach</h1>
 * <h4 id="one-way-to-solve-this-problem-is-to-use-dynamic-programming-we-can-maintain-a-2d-array-dp-where-dpij-represents-the-number-of-arithmetic-subsequences-ending-at-index-i-with-a-common-difference-of-j-we-can-then-iterate-through-the-array-updating-the-dp-array-and-counting-the-total-number-of-arithmetic-subsequences">One way to solve this problem is to use dynamic programming. We can maintain a 2D array <code>dp</code>, where <code>dp[i][j]</code> represents the number of arithmetic subsequences ending at index <code>i</code> with a common difference of <code>j</code>. We can then iterate through the array, updating the <code>dp</code> array and counting the total number of arithmetic subsequences.</h4>
 * <h3 id="heres-a-step-by-step-breakdown-of-the-approach">Here's a step-by-step breakdown of the approach:</h3>
 * <h4 id="1-initialize-a-variable-total_count-to-0-which-will-keep-track-of-the-total-number-of-arithmetic-subsequences">1. Initialize a variable <code>total_count</code> to 0, which will keep track of the total number of arithmetic subsequences.</h4>
 * <h4 id="2-initialize-a-2d-array-dp-with-dimensions-n-x-n-where-n-is-the-length-of-the-input-array-nums-each-element-dpij-will-represent-the-number-of-arithmetic-subsequences-ending-at-index-i-with-a-common-difference-of-j">2. Initialize a 2D array <code>dp</code> with dimensions <code>n x n</code>, where <code>n</code> is the length of the input array <code>nums</code>. Each element <code>dp[i][j]</code> will represent the number of arithmetic subsequences ending at index <code>i</code> with a common difference of <code>j</code>.</h4>
 * <h4 id="3-iterate-through-the-array-nums-with-two-nested-loops">3. Iterate through the array <code>nums</code> with two nested loops:</h4>
 * <ul>
<li>
<h5 id="the-outer-loop-i-goes-from-1-to-n---1">The outer loop (<code>i</code>) goes from 1 to <code>n - 1</code>.</h5>
</li>
<li>
<h5 id="the-inner-loop-j-goes-from-0-to-i---1">The inner loop (<code>j</code>) goes from 0 to <code>i - 1</code>.</h5>
</li>
</ul>
<h4 id="4-for-each-pair-of-indices-i-j-calculate-the-common-difference-diff--numsi---numsj">4. For each pair of indices (<code>i, j</code>), calculate the common difference <code>diff = nums[i] - nums[j]</code>.</h4>
<h4 id="5-update-dpidiff-by-incrementing-it-by-1-indicating-that-we-have-found-a-new-arithmetic-subsequence-ending-at-index-i-with-a-common-difference-of-diff">5. Update <code>dp[i][diff]</code> by incrementing it by 1, indicating that we have found a new arithmetic subsequence ending at index <code>i</code> with a common difference of <code>diff</code>.</h4>
<h4 id="6-if-there-is-an-existing-subsequence-ending-at-index-j-with-the-common-difference-diff-extend-it-to-form-a-longer-subsequence-ending-at-index-i-increment-dpidiff-by-the-value-of-dpjdiff">6. If there is an existing subsequence ending at index <code>j</code> with the common difference <code>diff</code>, extend it to form a longer subsequence ending at index <code>i</code>. Increment <code>dp[i][diff]</code> by the value of <code>dp[j][diff]</code>.</h4>
<h4 id="7-update-the-total_count-by-adding-the-value-of-dpjdiff-to-it">7. Update the <code>total_count</code> by adding the value of <code>dp[j][diff]</code> to it.</h4>
<h4 id="8-after-the-loops-the-total_count-will-contain-the-total-number-of-arithmetic-subsequences">8. After the loops, the <code>total_count</code> will contain the total number of arithmetic subsequences.</h4>
 */
class ArithmeticSlicesIISubsequence_Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int total_count = 0;

        @SuppressWarnings("unchecked")
        HashMap<Integer, Integer>[] dp = new HashMap[n];

        for (int i = 0; i < n; ++i) {
            dp[i] = new HashMap<>();
        }

        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                long diff = (long) nums[i] - nums[j]; 

                if (diff > Integer.MAX_VALUE || diff < Integer.MIN_VALUE) {
                    continue; 
                }

                int diffInt = (int) diff;

                dp[i].put(diffInt, dp[i].getOrDefault(diffInt, 0) + 1);  
                if (dp[j].containsKey(diffInt)) {
                    dp[i].put(diffInt, dp[i].get(diffInt) + dp[j].get(diffInt));
                    total_count += dp[j].get(diffInt);
                }
            }
        }

        return total_count;
    }
}

// 36ms 53.66MB
class ArithmeticSlicesIISubsequence_Solution2 {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        HashMap<Long, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            long temp = nums[i];
            if(!map.containsKey(temp)){
                map.put(temp, new ArrayList<Integer>());
            }
            map.get(temp).add(i);
        }

        int sum = 0;
        for(int i = 1; i < n; i++){
            for(int j = i + 1; j < n; j++){
                long a = 2L * nums[i] - nums[j];
                if(map.containsKey(a) ){
                    for(int k : map.get(a)){
                        if(k < i){
                            dp[i][j] += dp[k][i] + 1;
                        }else{
                            break;
                        }
                    }
                }
                sum += dp[i][j];
            }
        }
        return sum;
    }
}