package Easy.Arrays;


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
 * Applied: Moore Voting Algorithm.
 */
class MajorityElement_Solution {
    // 1 ms
    // 49.4 MB
    public int majorityElement(int[] nums) {
        int element = 0;
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                element = num;
            }

            if (element == num) {
                count++;
            } else {
                count--;
            }
        }

        return element;
    }
}