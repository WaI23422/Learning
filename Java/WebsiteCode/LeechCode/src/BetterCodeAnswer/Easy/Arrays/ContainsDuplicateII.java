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
public class ContainsDuplicateII {
    public static void main(String[] args) {
        int[][][] tests = {
            {{1,0,1,1},{1}},
            {{0,1,2,3,4,5,0},{5}},
            {{3,4,5},{4}},
            {{1,2,3,1},{3}},
            {{1,2,3,1,2,3},{2}},
            {{2,2},{3}}
        };

        for (int[][] test : tests) {
            int[] nums = test[0];
            int k = test[1][0];
            System.out.println(new ContainsDuplicateII_Solution().containsNearbyDuplicate(nums, k));
        }
        
    }   
}

// 5 ms 55.1 MB
class ContainsDuplicateII_Solution {

    private static final int HASH_CONST = 0x9E3779B9, NULL = Integer.MAX_VALUE;

    public boolean containsNearbyDuplicate(final int[] nums, final int k) {
        final int size = nums.length;
        if (size < 2) return false;

        int capacity = 4;
        final int minCapacity = size + size / 4 + 2;
        while (capacity < minCapacity) capacity <<= 1;
        final int mask = capacity++ - 1;
        final int[] keys = new int[capacity], values = new int[capacity];

        for (int i = size - 1; i >= 0; i--) {
            int oldIndex = NULL;
            if (nums[i] == 0) {
                final int i1 = mask + 1;
                if (keys[i1]++ == 0) {
                    values[i1] = i;
                } else {
                    oldIndex = values[i1];
                    values[i1] = i;
                }
            } else {
                int i1 = nums[i] * HASH_CONST & mask;
                while (true) {
                    final int k1 = keys[i1];
                    if (k1 == 0) {
                        keys[i1] = nums[i];
                        values[i1] = i;
                        break;
                    }
                    if (k1 == nums[i]) {
                        oldIndex = values[i1];
                        values[i1] = i;
                        break;
                    }
                    i1 = ++i1 & mask;
                }
            }
            if (oldIndex - i <= k) return true;
        }

        return false;
    }

}