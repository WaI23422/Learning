package BetterCodeAnswer.Hard.Array;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/constrained-subsequence-sum/">1425.Constrained Subsequence Sum</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>Given an integer array <code>nums</code> and an integer <code>k</code>, return the maximum sum of a <strong>non-empty</strong> subsequence of that array such that for every two <strong>consecutive</strong> integers in the subsequence, <code>nums[i]</code> and <code>nums[j]</code>, where <code>i &lt; j</code>, the condition <code>j - i &lt;= k</code> is satisfied.</p>

<p>A <em>subsequence</em> of an array is obtained by deleting some number of elements (can be zero) from the array, leaving the remaining elements in their original order.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [10,2,-10,5,20], k = 2
<strong>Output:</strong> 37
<b>Explanation:</b> The subsequence is [10, 2, 5, 20].
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [-1,-2,-3], k = 1
<strong>Output:</strong> -1
<b>Explanation:</b> The subsequence must be non-empty, so we choose the largest number.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> nums = [10,-2,-10,-5,20], k = 2
<strong>Output:</strong> 23
<b>Explanation:</b> The subsequence is [10, -2, -5, 20].
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= k &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
</ul>
</div></div>
 */
public class ConstrainedSubsequenceSum {
    public static void main(String[] args) {
        int[][][] tests = {
            {{10,2,-10,5,20}, {2}},
            {{-1,-2,-3},{1}},
            {{10,-2,-10,-5,20},{2}}
        };

        ConstrainedSubsequenceSum_Solution res =new ConstrainedSubsequenceSum_Solution();

        for (int[][] test : tests) {
            System.out.println(res.constrainedSubsetSum(test[0], test[1][0]));
        }
    }
}

/**
 * <h1 id="intuition">Intuition:</h1>
 * 
 * <p>The problem essentially asks for the maximum sum of a non-empty subsequence of the array that satisfies a certain condition. This condition is that for every two consecutive integers in the subsequence (nums[i] and nums[j], where i &lt; j), the difference between the indices (j - i) should be less than or equal to k.</p>
 * <p>The given code provides a solution using dynamic programming with a deque (double-ended queue). It iterates through the array while keeping track of the maximum subsequence sum.</p>
 * 
 * <h1 id="approach">Approach:</h1>
 * <ol>
<li>Initialize a variable <code>res</code> to store the maximum subsequence sum. This variable is set to the value of the first element in the array <code>A[0]</code>.</li>
<li>Create a deque <code>q</code> to maintain a double-ended queue to track possible elements in the subsequence.</li>
<li>Iterate through the elements of the array using a loop, and for each element <code>A[i]</code>, do the following:
<ul>
<li>Update <code>A[i]</code> by adding the value at the front of the deque (if not empty). This step is essential as it helps to maintain the constraint <code>j - i &lt;= k</code>.</li>
<li>Update the <code>res</code> to be the maximum of the current <code>res</code> and <code>A[i]</code>. This is essentially updating the maximum subsequence sum.</li>
<li>Check if the deque is not empty and the current element <code>A[i]</code> is greater than the last element in the deque. If so, remove the last element from the deque. This step ensures that the deque only contains elements in non-increasing order.</li>
<li>If the current element <code>A[i]</code> is greater than 0, add it to the deque. This step is essential for maintaining a sequence of positive elements.</li>
<li>Check if the index <code>i</code> is greater than or equal to <code>k</code> and if the deque is not empty and the front element in the deque is equal to <code>A[i - k]</code>. If all these conditions are met, it means that the front element in the deque is <code>k</code> steps behind the current element, so it is no longer valid for the subsequence. Remove it from the deque.</li>
</ul>
</li>
<li>Finally, return the <code>res</code>, which represents the maximum subsequence sum that satisfies the given conditions.</li>
</ol>
<h1 id="complexity-analysis">Complexity Analysis:</h1>

<ul>
<li>Time Complexity: The code iterates through the array once, resulting in O(n) time complexity.</li>
<li>Space Complexity: The deque <code>q</code> can store up to <code>k</code> elements, so the space complexity is O(k).</li>
</ul>
 */
class ConstrainedSubsequenceSum_Solution {
    // 32 ms 
    // 56.7 MB
    public int constrainedSubsetSum(int[] nums, int k) {
        int maxSum = nums[0];
        Deque<Integer> maxSumQueue = new ArrayDeque<>();
        
        for (int i = 0; i < nums.length; ++i) {
            nums[i] += !maxSumQueue.isEmpty() ? maxSumQueue.peek() : 0;
            maxSum = Math.max(maxSum, nums[i]);
            
            while (!maxSumQueue.isEmpty() && nums[i] > maxSumQueue.peekLast()) {
                maxSumQueue.pollLast();
            }
            
            if (nums[i] > 0) {
                maxSumQueue.offer(nums[i]);
            }
            
            if (i >= k && !maxSumQueue.isEmpty() && maxSumQueue.peek() == nums[i - k]) {
                maxSumQueue.poll();
            }
        }
        
        return maxSum;
    }
}

/**
 * <h4 id="approach-1-heappriority-queue">Approach 1: Heap/Priority Queue</h4>
 * 
 * <p><strong>Intuition</strong></p>
 * <p>Before we start developing a strategy, we must carefully understand what the problem is asking for.</p>
 * <p>We need to maximize the sum of a subsequence. We can take as many integers as we want, but the primary constraint is that we <strong>cannot</strong> have a gap of <code>k</code> or more in our subsequence.</p>
 * <p>You may immediately notice that in an array of positive integers, we should always take the entire array. The tricky part comes in when we have negative integers. Of course, we would prefer to avoid negative integers since they will decrease our sum. However, it may be worth taking a negative integer as a sort of "bridge". Take a look at the following example:</p>
 * <p><img src="https://leetcode.com/problems/constrained-subsequence-sum/Figures/1425/1.png" alt="example"><br>
<br></p>
<p>In this example, we have a group of negative numbers separating a <code>16</code> and a group of positive numbers that sum to <code>16</code>. We would like to take all the positive numbers while avoiding the negative numbers, but we aren't allowed to as that would result in a gap of three numbers. As <code>k = 2</code>, the biggest gap we can have is one number. The optimal solution here is to take the <code>-5</code>.</p>
<p><img src="https://leetcode.com/problems/constrained-subsequence-sum/Figures/1425/2.png" alt="example"><br>
<br></p>
<p>As you can see, the <code>-5</code> acts as a bridge for the positive numbers. The question now is, how do we know when it is worth it to take negative numbers? In this case, taking the <code>-5</code> allowed us to take the first element of <code>16</code>. This results in a net gain of <code>11</code>. Anytime we have a positive net gain, we should consider taking this element because it can contribute to a positive sum and potentially increase the sum of subsequent subsequences.</p>
<p>We will iterate over the input from left to right. At each index <code>i</code>, we will consider the maximum possible sum of a subsequence that <strong>includes and ends at nums[i]</strong>. Let's call this value <code>curr</code>. How do we calculate <code>curr</code> for a given index <code>i</code>? We want the maximum possible sum of a subsequence that ends within the last <code>k</code> indices. We will then add <code>nums[i]</code> to this sum.</p>
<p>We could solve this using dynamic programming - let <code>dp[i]</code> represent the maximum possible sum of a subsequence that includes and ends at <code>nums[i]</code>. We can calculate <code>dp[i]</code> by taking the maximum <code>dp[j]</code> for all <code>j</code> in the range <code>[i - k, i - 1]</code> (the last <code>k</code> indices), then adding <code>nums[i]</code> to it.</p>
<p>However, we would be iterating up to <code>k</code> times to calculate each state. As <code>k</code> can be large, this approach is too slow. We need a faster way to find the maximum <code>dp[j]</code> for all indices <code>j</code> in the range <code>[i - k, i - 1]</code>.</p>
<p>Because we are only concerned with the maximum sum, we could use a max heap. The max heap would store <code>dp[j]</code> for all <code>j</code> in the last <code>k</code> indices. We can easily calculate <code>curr</code> by simply checking the top of this heap.</p>
<p>We need to make sure we don't use elements of the heap that are more than <code>k</code> away from the current index. Before we calculate <code>curr</code>, we pop from the top of the heap if it is outside our range. This means each entry in the heap will also need its associated index, so we can tell when an element is out of range.</p>
<p>Note that if the top of the heap is negative, it is better to not take it. This is a process very similar to Kadane's Algorithm, which solves the <a href="https://leetcode.com/problems/maximum-subarray/" target="_blank">Maximum Subarray</a> problem. When the top of the heap is negative, it indicates that selecting this subsequence would result in a sum less than 0. Every element in the array to the left of the current index should be abandoned - any "bridge" would not be worth taking. It's better to discard these subsequences altogether and reset the sum to 0.</p>
<p><strong>Algorithm</strong></p>
<ol>
<li>Initialize a max <code>heap</code> with <code>(nums[0], 0)</code>. Also initialize the answer <code>ans = nums[0]</code>.</li>
<li>Iterate <code>i</code> over the indices of <code>nums</code>, starting from <code>i = 1</code>:
<ul>
<li>While <code>i</code> minus the index (second element) at the top of <code>heap</code> is greater than <code>k</code>, pop from <code>heap</code>.</li>
<li>Set <code>curr</code> to the value (first element) at the top of <code>heap</code>, plus <code>nums[i]</code>. Note that if the value at the top of <code>heap</code> is negative, we should take <code>0</code> instead.</li>
<li>Update <code>ans</code> with <code>curr</code> if it is larger.</li>
<li>Push <code>(curr, i)</code> to <code>heap</code>.</li>
</ul>
</li>
<li>Return <code>ans</code>.</li>
</ol>
 */
class ConstrainedSubsequenceSum_Solution2 {
    // 85 ms 
    // 60.7 MB
    public int constrainedSubsetSum(int[] nums, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> {
            return b[0] - a[0];
        });
        
        heap.add(new int[] {nums[0], 0});
        int ans = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            while (i - heap.peek()[1] > k) {
                heap.remove();
            }
            
            int curr = Math.max(0, heap.peek()[0]) + nums[i];
            ans = Math.max(ans, curr);
            heap.add(new int[] {curr, i});
        }
        
        return ans;
    }
}

/**
 * <h4 id="approach-2-treemap-like-data-structure">Approach 2: TreeMap-Like Data Structure</h4>
 * 
 * <p><strong>Intuition</strong></p>
 * 
 * <p>As we saw in the previous approach, the crux of the dynamic programming idea was finding the maximum value of <code>dp</code> in the last <code>k</code> indices. We accomplished this in <span class="math math-inline"><span class="katex"><span class="katex-mathml">O(log⁡n)O(\log{}n)</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathnormal" style="margin-right: 0.02778em;">O</span><span class="mopen">(</span><span class="mop">lo<span style="margin-right: 0.01389em;">g</span></span><span class="mspace" style="margin-right: 0.1667em;"></span><span class="mord"></span><span class="mord mathnormal">n</span><span class="mclose">)</span></span></span></span></span> time with a heap, but we could achieve <span class="math math-inline"><span class="katex"><span class="katex-mathml">O(log⁡k)O(\log{}k)</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathnormal" style="margin-right: 0.02778em;">O</span><span class="mopen">(</span><span class="mop">lo<span style="margin-right: 0.01389em;">g</span></span><span class="mspace" style="margin-right: 0.1667em;"></span><span class="mord"></span><span class="mord mathnormal" style="margin-right: 0.03148em;">k</span><span class="mclose">)</span></span></span></span></span> with a tree map data structure (like a red-black tree). Because <code>k &lt;= n</code>, this is a slight improvement in terms of big O.</p>
 * <p>Let's actually use the <code>dp</code> array that we spoke of in the previous approach this time. We will have a data structure <code>window</code> that holds all values of <code>dp</code> in the last <code>k</code> indices. We can easily calculate <code>dp[i]</code> as <code>nums[i]</code> plus the maximum value in <code>window</code>. Then, we can add <code>dp[i]</code> to <code>window</code>.</p>
 * <p>To maintain <code>window</code>, once we reach index <code>k</code>, we need to start removing <code>dp[i - k]</code> from <code>window</code> at each iteration.</p>
 * <p>In Java, we will use <code>TreeMap</code>. Each key will be a value in <code>dp</code> which we will map to its frequency. To remove <code>dp[i - k]</code> from the window, we will decrement its frequency, and if its frequency becomes <code>0</code>, we will delete the key.</p>
 * <p>In C++, we will use <code>std::map</code>, which functions similarly to Java's <code>TreeMap</code>.</p>
 * <p>In Python, we will use <a href="https://grantjenks.com/docs/sortedcontainers/sortedlist.html" target="_blank">sortedcontainers.SortedList</a>, which is more like a list than a map, but still provides us with the efficient operations we require.</p>
 * <p>For all implementations, we will initialize <code>window</code> with a key of <code>0</code> to make the code cleaner, otherwise we would need to handle the first index differently (check if <code>window</code> is empty before accessing the maximum key).</p>
 * <p>The answer to the problem will be the max value in <code>dp</code> in the end.</p>
 * <p><strong>Algorithm</strong></p>
 * <ol>
<li>Initialize <code>window</code> with <code>0: 0</code>.</li>
<li>Initialize an array <code>dp</code> with the same length as <code>nums</code>.</li>
<li>Iterate <code>i</code> over the indices of <code>nums</code>:
<ul>
<li>Set <code>dp[i]</code> to <code>nums[i]</code> plus the maximum key in <code>window</code>.</li>
<li>Increment the frequency of <code>dp[i]</code> in <code>window</code>.</li>
<li>If <code>i &gt;= k</code>:
<ul>
<li>Decrement the frequency of <code>dp[i - k]</code> in <code>window</code>. If the frequency becomes <code>0</code>, delete it from <code>window</code>.</li>
</ul>
</li>
</ul>
</li>
<li>Return the max value in <code>dp</code>.</li>
</ol>
 */
class ConstrainedSubsequenceSum_Solution3 {
    // 355 ms 
    // 59.4 MB
    @SuppressWarnings("all")
    public int constrainedSubsetSum(int[] nums, int k) {
        TreeMap<Integer, Integer> window = new TreeMap();
        window.put(0, 0);
        
        int dp[] = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            dp[i] = nums[i] + window.lastKey();
            window.put(dp[i], window.getOrDefault(dp[i], 0) + 1);
            
            if (i >= k) {
                window.put(dp[i - k], window.get(dp[i - k]) - 1);
                if (window.get(dp[i - k]) == 0) {
                    window.remove(dp[i - k]);
                }
            }
        }
        
        int ans = Integer.MIN_VALUE;
        for (int num : dp) {
            ans = Math.max(ans, num);
        }
        
        return ans;
    }
}