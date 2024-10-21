package BetterCodeAnswer.Medium.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/convert-an-array-into-a-2d-array-with-conditions/">2610.Convert an Array Into a 2D Array With Conditions</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>You are given an integer array <code>nums</code>. You need to create a 2D array from <code>nums</code> satisfying the following conditions:</p>

<ul>
	<li>The 2D array should contain <strong>only</strong> the elements of the array <code>nums</code>.</li>
	<li>Each row in the 2D array contains <strong>distinct</strong> integers.</li>
	<li>The number of rows in the 2D array should be <strong>minimal</strong>.</li>
</ul>

<p>Return <em>the resulting array</em>. If there are multiple answers, return any of them.</p>

<p><strong>Note</strong> that the 2D array can have a different number of elements on each row.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [1,3,4,1,2,3,1]
<strong>Output:</strong> [[1,3,4,2],[1,3],[1]]
<strong>Explanation:</strong> We can create a 2D array that contains the following rows:
- 1,3,4,2
- 1,3
- 1
All elements of nums were used, and each row of the 2D array contains distinct integers, so it is a valid answer.
It can be shown that we cannot have less than 3 rows in a valid array.</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [1,2,3,4]
<strong>Output:</strong> [[4,3,2,1]]
<strong>Explanation:</strong> All elements of the array are distinct, so we can keep all of them in the first row of the 2D array.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 200</code></li>
	<li><code>1 &lt;= nums[i] &lt;= nums.length</code></li>
</ul>
</div></div>
 */
public class ConvertAnArrayIntoATwoDArrayWithConditions {
    public static void main(String[] args) {
        int[][] tests = {
            {1,3,4,1,2,3,1},
            {1,2,3,4},
        };

        for (int[] nums : tests) {
            List<List<Integer>> ans = new ConvertAnArrayIntoATwoDArrayWithConditions_Solution().findMatrix(nums);
            
            System.out.print("[");
            for (int i = 0; i < ans.size(); i++) {
                List<Integer> ansPart = ans.get(i);
                
                System.out.print(ansPart.toString());
            }
            System.out.println("]");
        }
    }
}

// 4 ms 45 MB
class ConvertAnArrayIntoATwoDArrayWithConditions_Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        int[] freq = new int[nums.length + 1];
        List<List<Integer>> ans = new ArrayList<>();

        for (int c : nums) {
            if (freq[c] >= ans.size()) {
                ans.add(new ArrayList<>());
            }

            ans.get(freq[c]).add(c);
            freq[c]++;
        }

        return ans;
    }
}
