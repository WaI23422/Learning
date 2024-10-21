package Easy.Arrays;

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
public class Monotonic_Array {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1};
        Monotonic_Array_Solution solution = new Monotonic_Array_Solution();

        System.out.println(solution.isMonotonic(nums));
    }
}

class Monotonic_Array_Solution {
    // 3 ms
    // 55.5 MB
    public boolean isMonotonic(int[] nums) {
        int numb1 = nums[0];
        int incrs = 0;
        int decrs = 0;
        
        // Track the number if it increases continuously or decreases continuously:
        for (int i = 1; i < nums.length; i++) {
            if (numb1 > nums[i]) {
                incrs +=1;
                numb1 = nums[i];
            } else if (numb1 < nums[i]) {
                decrs +=1;
                numb1 = nums[i];
            } else {
                numb1 = nums[i];
            }
        }

        if ((incrs >0 && decrs ==0) || (incrs ==0 && decrs > 0) || (incrs == 0 && decrs == 0)) {
            return true;
        } else {
            return false;
        }
    }
}