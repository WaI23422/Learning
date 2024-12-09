package Medium.Array;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/special-array-ii/">3152. Special Array II</a>
 * 
 * <div><div class="elfjS" data-track-load="description_content"><p>An array is considered <strong>special</strong> if every pair of its adjacent elements contains two numbers with different parity.</p>
 * 
 * <p>You are given an array of integer <code>nums</code> and a 2D integer matrix <code>queries</code>, where for <code>queries[i] = [from<sub>i</sub>, to<sub>i</sub>]</code> your task is to check that <span data-keyword="subarray" class=" cursor-pointer relative text-dark-blue-s text-sm"><div class="popover-wrapper inline-block" data-headlessui-state=""><div><div aria-expanded="false" data-headlessui-state="" id="headlessui-popover-button-:rt:"><div>subarray</div></div><div style="position: fixed; z-index: 40; inset: 0px auto auto 0px; transform: translate(52px, 241px);"></div></div></div></span> <code>nums[from<sub>i</sub>..to<sub>i</sub>]</code> is <strong>special</strong> or not.</p>
 * 
 * <p>Return an array of booleans <code>answer</code> such that <code>answer[i]</code> is <code>true</code> if <code>nums[from<sub>i</sub>..to<sub>i</sub>]</code> is special.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <div class="example-block">
 * <p><strong>Input:</strong> <span class="example-io">nums = [3,4,1,2,6], queries = [[0,4]]</span></p>
 * 
 * <p><strong>Output:</strong> <span class="example-io">[false]</span></p>
 * 
 * <p><strong>Explanation:</strong></p>
 * 
 * <p>The subarray is <code>[3,4,1,2,6]</code>. 2 and 6 are both even.</p>
 * </div>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <div class="example-block">
 * <p><strong>Input:</strong> <span class="example-io">nums = [4,3,1,6], queries = [[0,2],[2,3]]</span></p>
 * 
 * <p><strong>Output:</strong> <span class="example-io">[false,true]</span></p>
 * 
 * <p><strong>Explanation:</strong></p>
 * 
 * <ol>
 * 	<li>The subarray is <code>[4,3,1]</code>. 3 and 1 are both odd. So the answer to this query is <code>false</code>.</li>
 * 	<li>The subarray is <code>[1,6]</code>. There is only one pair: <code>(1,6)</code> and it contains numbers with different parity. So the answer to this query is <code>true</code>.</li>
 * </ol>
 * </div>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>1 &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>1 &lt;= queries.length &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>queries[i].length == 2</code></li>
 * 	<li><code>0 &lt;= queries[i][0] &lt;= queries[i][1] &lt;= nums.length - 1</code></li>
 * </ul>
 * </div></div>
 */
public class SpecialArrayII {
    public static void main(String[] args) {
        
    }
}

// 2ms 98.74MB
class SpecialArrayII_Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] pref = new int[n];
        pref[0] = 1;
        for (int i = 1; i < n; i++) {
            if ((nums[i] & 1) != (nums[i - 1] & 1)) {
                pref[i] = pref[i - 1] + 1;
            } else {
                pref[i] = 1;
            }
        }
        boolean[] ans = new boolean[queries.length];
        int index = 0;
        for (int[] query : queries) {
            int s = query[0], e = query[1];
            int len = e - s + 1;
            if (pref[e] < len) {
                ans[index++] = false;
            } else {
                ans[index++] = true;
            }
        }
        return ans;
    }
}