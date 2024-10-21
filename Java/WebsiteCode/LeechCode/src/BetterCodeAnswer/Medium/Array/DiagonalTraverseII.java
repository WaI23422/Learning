package BetterCodeAnswer.Medium.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/diagonal-traverse-ii/">1424.Diagonal Traverse II</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>Given a 2D integer array <code>nums</code>, return <em>all elements of </em><code>nums</code><em> in diagonal order as shown in the below images</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/04/08/sample_1_1784.png" style="width: 158px; height: 143px;">
<pre><strong>Input:</strong> nums = [[1,2,3],[4,5,6],[7,8,9]]
<strong>Output:</strong> [1,4,2,7,5,3,8,6,9]
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/04/08/sample_2_1784.png" style="width: 230px; height: 177px;">
<pre><strong>Input:</strong> nums = [[1,2,3,4,5],[6,7],[8],[9,10,11],[12,13,14,15,16]]
<strong>Output:</strong> [1,6,2,8,7,3,9,4,12,10,5,13,11,14,15,16]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i].length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= sum(nums[i].length) &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i][j] &lt;= 10<sup>5</sup></code></li>
</ul>
</div></div>
 */
public class DiagonalTraverseII {
    public static void main(String[] args) {
        int[][][] tests = {
            {{1,2,3},{4,5,6},{7,8,9}},
            {{1,2,3,4,5},{6,7},{8},{9,10,11},{12,13,14,15,16}}
        };

        for (int[][] test : tests) {
            List<List<Integer>> nums = new ArrayList<>();
            for (int[] num : test) {
                List<Integer> numList = Arrays.stream(num).boxed().toList();
                nums.add(numList);
            }

            System.out.println(Arrays.toString((new DiagonalTraverseII_Solution().findDiagonalOrder(nums))));
        }
    }
}

/**
 * <h1 id="approach">Approach</h1>
 * <ol>
<li>Create an array <code>map</code> of <code>ArrayList</code> to store elements based on their diagonal sum.</li>
<li>Traverse the given 2D array <code>nums</code> and populate the <code>map</code> with elements based on their diagonal sum.</li>
<li>Determine the maximum diagonal sum encountered (<code>maxSum</code>).</li>
<li>Initialize an array <code>res</code> to store the final result.</li>
<li>Traverse the <code>map</code> from 0 to <code>maxSum</code> and for each diagonal sum, retrieve the elements in reverse order and add them to <code>res</code>.</li>
<li>Return the resulting array <code>res</code>.</li>
</ol>
 */ 
class DiagonalTraverseII_Solution {
    // 16 ms 62.6 MB
    @SuppressWarnings("all")
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int m = nums.size(), maxSum = 0, size = 0, index = 0;
        List<Integer>[] map = new ArrayList[100001];
        for (int i = 0; i < m; i++) {
            size += nums.get(i).size();
            for (int j = 0; j < nums.get(i).size(); j++) {
                int sum = i + j;
                if (map[sum] == null) map[sum] = new ArrayList<>();
                map[sum].add(nums.get(i).get(j));
                maxSum = Math.max(maxSum, sum);
            }
        }
        int[] res = new int[size];
        for (int i = 0; i <= maxSum; i++) {
            List<Integer> cur = map[i];
            for (int j = cur.size() - 1; j >= 0; j--) {
                res[index++] = cur.get(j);
            }
        }
        return res;
    }
}