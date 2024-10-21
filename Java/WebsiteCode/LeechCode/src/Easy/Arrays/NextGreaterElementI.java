package Easy.Arrays;

import java.util.Arrays;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/next-greater-element-i/">496. Next Greater Element I</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>The <strong>next greater element</strong> of some element <code>x</code> in an array is the <strong>first greater</strong> element that is <strong>to the right</strong> of <code>x</code> in the same array.</p>
 * 
 * <p>You are given two <strong>distinct 0-indexed</strong> integer arrays <code>nums1</code> and <code>nums2</code>, where <code>nums1</code> is a subset of <code>nums2</code>.</p>
 * 
 * <p>For each <code>0 &lt;= i &lt; nums1.length</code>, find the index <code>j</code> such that <code>nums1[i] == nums2[j]</code> and determine the <strong>next greater element</strong> of <code>nums2[j]</code> in <code>nums2</code>. If there is no next greater element, then the answer for this query is <code>-1</code>.</p>
 * 
 * <p>Return <em>an array </em><code>ans</code><em> of length </em><code>nums1.length</code><em> such that </em><code>ans[i]</code><em> is the <strong>next greater element</strong> as described above.</em></p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums1 = [4,1,2], nums2 = [1,3,4,2]
 * <strong>Output:</strong> [-1,3,-1]
 * <strong>Explanation:</strong> The next greater element for each value of nums1 is as follows:
 * - 4 is underlined in nums2 = [1,3,<u>4</u>,2]. There is no next greater element, so the answer is -1.
 * - 1 is underlined in nums2 = [<u>1</u>,3,4,2]. The next greater element is 3.
 * - 2 is underlined in nums2 = [1,3,4,<u>2</u>]. There is no next greater element, so the answer is -1.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums1 = [2,4], nums2 = [1,2,3,4]
 * <strong>Output:</strong> [3,-1]
 * <strong>Explanation:</strong> The next greater element for each value of nums1 is as follows:
 * - 2 is underlined in nums2 = [1,<u>2</u>,3,4]. The next greater element is 3.
 * - 4 is underlined in nums2 = [1,2,3,<u>4</u>]. There is no next greater element, so the answer is -1.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= nums1.length &lt;= nums2.length &lt;= 1000</code></li>
 * 	<li><code>0 &lt;= nums1[i], nums2[i] &lt;= 10<sup>4</sup></code></li>
 * 	<li>All integers in <code>nums1</code> and <code>nums2</code> are <strong>unique</strong>.</li>
 * 	<li>All the integers of <code>nums1</code> also appear in <code>nums2</code>.</li>
 * </ul>
 * 
 * <p>&nbsp;</p>
 * <strong>Follow up:</strong> Could you find an <code>O(nums1.length + nums2.length)</code> solution?</div>
 */
public class NextGreaterElementI {
    public static void main(String[] args) {
        int[][][] tests = {
            {
                {4,1,2},
                {1,3,4,2}
            }
        };

        for (int[][] test : tests) {
            int nums1[] = test[0],
                nums2[] = test[1];

            System.out.println(Arrays.toString(new NextGreaterElementI_Solution().nextGreaterElement(nums1, nums2)));
        }
    }
}

// Brute-Force
// 8 ms 42.9 MB
class NextGreaterElementI_Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len1=  nums1.length,
            len2 = nums2.length,
            ans[] = new int[len1];

        for (int i = 0; i < len1; i++) {
            int num1 = nums1[i];
            for (int j = 0; j < len2; j++) {
                int num2 = nums2[j];
                if (num1 == num2) {
                    ans[i] = findNextGreaterElement(nums2,num1,j);
                }
            }
        }

        return ans;
    }

    private int findNextGreaterElement(int[] numArr, int compareNum, int startIdx) {
        int len = numArr.length;
        for (int i = startIdx + 1; i < len; i++) {
            if (compareNum < numArr[i]) {
                return numArr[i];
            }
        }

        return -1;
    }
}