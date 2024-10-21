package BetterCodeAnswer.Easy.Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/majority-element/">169.Majority Element</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>Given an array <code>nums</code> of size <code>n</code>, return <em>the majority element</em>.</p>

<p>The majority element is the element that appears more than <code>⌊n / 2⌋</code> times. You may assume that the majority element always exists in the array.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> nums = [3,2,3]
<strong>Output:</strong> 3
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> nums = [2,2,1,1,1,2,2]
<strong>Output:</strong> 2
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == nums.length</code></li>
	<li><code>1 &lt;= n &lt;= 5 * 10<sup>4</sup></code></li>
	<li><code>-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
</ul>

<p>&nbsp;</p>
<strong>Follow-up:</strong> Could you solve the problem in linear time and in <code>O(1)</code> space?</div></div>
 */
public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {3,2,3};

        MajorityElement_Solution answer = new MajorityElement_Solution();

        System.out.println(answer.majorityElement(nums));
    }   
}

/**
 * <h1 id="approach-1-sorting">Approach 1: Sorting</h1>
 * 
 * <h1 id="intuition">Intuition:</h1>
 * <p>The intuition behind this approach is that if an element occurs more than n/2 times in the array (where n is the size of the array), it will always occupy the middle position when the array is sorted. Therefore, we can sort the array and return the element at index n/2.</p>
 * <h1 id="explanation">Explanation:</h1>
 * <ol>
<li>The code begins by sorting the array <code>nums</code> in non-decreasing order using the <code>sort</code> function from the C++ Standard Library. This rearranges the elements such that identical elements are grouped together.</li>
<li>Once the array is sorted, the majority element will always be present at index <code>n/2</code>, where <code>n</code> is the size of the array.
<ul>
<li>This is because the majority element occurs more than n/2 times, and when the array is sorted, it will occupy the middle position.</li>
</ul>
</li>
<li>The code returns the element at index <code>n/2</code> as the majority element.</li>
</ol>
<p>The time complexity of this approach is O(n log n) since sorting an array of size n takes O(n log n) time.</p>
 */
class MajorityElement_Solution {
    // 2 ms
    // 48.5 
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return nums[n/2];
    }
}

/**
 * <h1 id="approach-2-hash-map">Approach 2: Hash Map</h1>
 * 
 * <h1 id="intuition-1">Intuition:</h1>
 * <p>The intuition behind using a hash map is to count the occurrences of each element in the array and then identify the element that occurs more than n/2 times. By storing the counts in a hash map, we can efficiently keep track of the occurrences of each element.</p>
 * <p>Explanation:</p>
 * <ol>
<li>The code begins by initializing a hash map <code>m</code> to store the count of occurrences of each element.</li>
<li>It then iterates through the array <code>nums</code> using a for loop.</li>
<li>For each element <code>nums[i]</code>, it increments its count in the hash map <code>m</code> by using the line <code>m[nums[i]]++;</code>.
<ul>
<li>If <code>nums[i]</code> is encountered for the first time, it will be added to the hash map with a count of 1.</li>
<li>If <code>nums[i]</code> has been encountered before, its count in the hash map will be incremented by 1.</li>
</ul>
</li>
<li>After counting the occurrences of each element, the code updates <code>n</code> to be <code>n/2</code>, where <code>n</code> is the size of the array. This is done to check if an element occurs more than n/2 times, which is the criteria for being the majority element.</li>
<li>The code then iterates through the key-value pairs in the hash map using a range-based for loop.
<ul>
<li>For each key-value pair <code>(x.first, x.second)</code>, it checks if the count <code>x.second</code> is greater than <code>n</code>.</li>
<li>If the count is greater than <code>n</code>, it means that <code>x.first</code> occurs more than n/2 times, so it returns <code>x.first</code> as the majority element.</li>
</ul>
</li>
<li>If no majority element is found in the hash map, the code returns 0 as the default value.
<ul>
<li>Note that this will only occur if the input array <code>nums</code> is empty or does not have a majority element.</li>
</ul>
</li>
</ol>
<p>The time complexity of this approach is O(n) because it iterates through the array once to count the occurrences and then iterates through the hash map, which has a maximum size of the number of distinct elements in the array.</p>

 */
class SolutMajorityElement_Solutionion2 {
    // 11 ms
    // 47.1 MB
    public int majorityElement(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        n = n / 2;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > n) {
                return entry.getKey();
            }
        }
        
        return 0;
    }
}