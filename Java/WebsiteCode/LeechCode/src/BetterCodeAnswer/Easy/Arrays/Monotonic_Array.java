package BetterCodeAnswer.Easy.Arrays;

/**
 * <div class="xFUwe" data-track-load="description_content"><p>An array is <strong>monotonic</strong> if it is either monotone increasing or monotone decreasing.</p>

<p>An array <code>nums</code> is monotone increasing if for all <code>i &lt;= j</code>, <code>nums[i] &lt;= nums[j]</code>. An array <code>nums</code> is monotone decreasing if for all <code>i &lt;= j</code>, <code>nums[i] &gt;= nums[j]</code>.</p>

<p>Given an integer array <code>nums</code>, return <code>true</code><em> if the given array is monotonic, or </em><code>false</code><em> otherwise</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [1,2,2,3]
<strong>Output:</strong> true
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [6,5,4,4]
<strong>Output:</strong> true
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> nums = [1,3,2]
<strong>Output:</strong> false
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>-10<sup>5</sup> &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
</ul>
</div>
 */
class Monotonic_Array_Solution {
    // 1 ms	
    // 55.4 MB
    public boolean isMonotonic(int[] nums) {
        if (nums.length < 2) return true;

        int direction = 0;  // 0 means unknown, 1 means increasing, -1 means decreasing

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) {  // increasing
                if (direction == 0) 
                    direction = 1;
                else if (direction == -1) 
                    return false;
            } else if (nums[i] < nums[i-1]) {  // decreasing
                if (direction == 0) 
                    direction = -1;
                else if (direction == 1) 
                    return false;
            }
        }

        return true;
    }
}

class Monotonic_Array_Solution2 {
    // 2 ms
    // 55.3 MB
    public boolean isMonotonic(int[] nums) {
        boolean increasing = true;
        boolean decreasing = true;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                decreasing = false;
            } else if (nums[i] < nums[i - 1]) {
                increasing = false;
            }

            if (!increasing && !decreasing) {
                return false;
            }
        }

        return true;
    }
}