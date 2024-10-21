package BetterCodeAnswer.Easy.Arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/number-of-good-pairs/">1512.Number of Good Pairs</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>Given an array of integers <code>nums</code>, return <em>the number of <strong>good pairs</strong></em>.</p>

<p>A pair <code>(i, j)</code> is called <em>good</em> if <code>nums[i] == nums[j]</code> and <code>i</code> &lt; <code>j</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [1,2,3,1,1,3]
<strong>Output:</strong> 4
<strong>Explanation:</strong> There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [1,1,1,1]
<strong>Output:</strong> 6
<strong>Explanation:</strong> Each pair in the array are <em>good</em>.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> nums = [1,2,3]
<strong>Output:</strong> 0
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 100</code></li>
	<li><code>1 &lt;= nums[i] &lt;= 100</code></li>
</ul>
</div></div>
 */
public class NumberOfGoodPairs {
    public static void main(String[] args) {
        int[] nums = {6,5,1,5,7,7,9,1,5,7,1,6,10,9,7,4,1,8,7,1,1,8,6,4,7,4,10,5,3,9,10,1,9,5,5,4,1,7,4,2,9,2,6,6,4,2,10,3,5,3,6,4,7,4,6,4,4,6,3,4,10,1,10,6,10,4,9,6,6,4,8,6,9,5,4};

        NumberOfGoodPairs_Solution numberOfGoodPairs_Solution = new NumberOfGoodPairs_Solution();

        System.out.println(numberOfGoodPairs_Solution.numIdenticalPairs(nums));
    }
}

/**
 * <h4 id="approach-2-hash-map">Approach 2: Hash Map</h4>
 * 
 * <p><strong>Intuition</strong></p>
 * <p>We can improve our performance by using a hash map to count the frequency of the encountered numbers during the traversal.</p>
 * <p>Let's say that we are iterating over the input, and we encounter a number <code>x = 6</code>. We also know that we have seen <code>6</code> three times before the current index. The current <code>6</code> could pair with any of the previous three to form a good pair.</p>
 * <p>In general, whenever we encounter a number, it can form <code>k</code> good pairs with previously traversed numbers, where <code>k</code> is the number of times we have seen the number previously.</p>
 * <p>Different from approach 1, while this approach doesn't track the indices of each number, we keep a count of their occurrences. This ensures that all good pairs are considered, and because the counts of each number are accumulated as it's traversed, it guarantees that good pairs are counted only once. This way, we avoid both undercounting and overcounting.</p>
 * <p><img src="https://leetcode.com/problems/number-of-good-pairs/Figures/1512/1.png" alt="example"><br>
<br></p>
 */
class NumberOfGoodPairs_Solution {
    // 1 ms
    // 39.4 MB
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        int ans = 0;

        for (int num: nums) {
            ans += counts.getOrDefault(num, 0);
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        
        return ans;
    }
}