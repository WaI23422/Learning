package Easy.Arrays;


/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/minimum-common-value/">2540.Minimum Common Value</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given two integer arrays <code>nums1</code> and <code>nums2</code>, sorted in non-decreasing order, return <em>the <strong>minimum integer common</strong> to both arrays</em>. If there is no common integer amongst <code>nums1</code> and <code>nums2</code>, return <code>-1</code>.</p>

<p>Note that an integer is said to be <strong>common</strong> to <code>nums1</code> and <code>nums2</code> if both arrays have <strong>at least one</strong> occurrence of that integer.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums1 = [1,2,3], nums2 = [2,4]
<strong>Output:</strong> 2
<strong>Explanation:</strong> The smallest element common to both arrays is 2, so we return 2.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums1 = [1,2,3,6], nums2 = [2,3,4,5]
<strong>Output:</strong> 2
<strong>Explanation:</strong> There are two common elements in the array 2 and 3 out of which 2 is the smallest, so 2 is returned.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums1.length, nums2.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums1[i], nums2[j] &lt;= 10<sup>9</sup></code></li>
	<li>Both <code>nums1</code> and <code>nums2</code> are sorted in <strong>non-decreasing</strong> order.</li>
</ul>
</div>
 */
public class MinimumCommonValue {
    public static void main(String[] args) {
        int[][][] tests = {
            {{1,2,3},{2,4}},
            {{1,2,3,6},{2,3,4,5}},
            {{1},{2}},
            {{1,2,5,6},{3,4}}
        };

        for (int[][] test : tests) {
            int[] nums1 = test[0],
                  nums2 = test[1];

            System.out.println(new MinimumCommonValue_Solution().getCommon(nums1, nums2));
        }
    }
}

// 0 ms 62.5 MB
class MinimumCommonValue_Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int left = 0, right = 0,
            len1 = nums1.length, len2 = nums2.length;
        
        if (nums1[0] > nums2[len2-1] || nums2[0] > nums1[len1-1]) {return -1;}

        while (left < len1 && right < len2) {
            if (nums1[left] == nums2[right]) {return nums1[left];}
            else if (nums1[left] > nums2[right]) {right++;}
            else {left++;}
        }

        return -1;
    }
}