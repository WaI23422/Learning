package BetterCodeAnswer.Easy.Arrays;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/contains-duplicate/">217.Contains Duplicate</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given an integer array <code>nums</code>, return <code>true</code> if any value appears <strong>at least twice</strong> in the array, and return <code>false</code> if every element is distinct.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> nums = [1,2,3,1]
<strong>Output:</strong> true
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> nums = [1,2,3,4]
<strong>Output:</strong> false
</pre><p><strong class="example">Example 3:</strong></p>
<pre><strong>Input:</strong> nums = [1,1,1,3,3,4,3,2,4,2]
<strong>Output:</strong> true
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
</ul>
</div>
 */
public class ContainsDuplicate {
    public static void main(String[] args) {
        int[][] tests = {
            {7,1,5,3,6,4},
            {7,6,4,3,1},
            {3,1,2,4,1,5,4},
            {2,5,1,4}
        };

        for (int[] nums : tests) {
            System.out.println(new ContainsDuplicate_Solution().containsDuplicate(nums));
        }
        
    }   
}

// 6 ms 54.9 MB
class ContainsDuplicate_Solution {
    public boolean containsDuplicate(int[] nums) {
        boolean flag = false;
        while(!flag) {
            flag = true;
            for (int i = 0; i < nums.length-1; i++) {
                if(nums[i] > nums[i+1]) {
                    int temp = nums[i];
                    nums[i] = nums[i+1];
                    nums[i+1] = temp;
                    flag = false;
                }
                if(nums[i] == nums[i+1])
                    return true;
            }
        }
        return false;
    }
}

// 2ms 59.9MB
class ContainsDuplicate_Solution2 {
    public boolean containsDuplicate(int[] nums) {
        final int length = nums.length;
        if (length == 1)
            return false;
        if (length == 2)
            return nums[0] == nums[1];

        for (int i = 1; i < length; i++) {
            final int current = nums[i];
            int j = i - 1, jval = nums[j];
            if (current < jval) {
                while (true) {
                    nums[j + 1] = jval;
                    if (j-- == 0)
                        break;
                    jval = nums[j];
                    if (current >= jval)
                        break;
                }
                nums[j + 1] = current;
            }

            if (j > -1 && current == jval)
                return true;
        }

        return false;
    }
}