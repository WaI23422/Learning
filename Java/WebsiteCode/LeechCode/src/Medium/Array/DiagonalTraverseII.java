package Medium.Array;

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

// 13 ms 71.4 MB
class DiagonalTraverseII_Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
       if (nums.size() == 1) {
            List<Integer> list = nums.get(0);
            int[] a = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                a[i] = list.get(i);
            }
            return a;
        }
        int[] previousRow = new int[nums.size()];
        int size = 0;
        int max = 0;
        int i = 0;
        previousRow[0] = -1;
        for (List<Integer> num : nums) {
            size += num.size();
            max = Math.max(max, num.size());
            if (i > 0) {
                if (nums.get(i - 1).size() > 1) {
                    previousRow[i] = i - 1;
                } else {
                    previousRow[i] = previousRow[i - 1];
                }
            }
            i++;
        }

        int[] result = new int[size];
        int n = nums.size();
        int m = max;

        int idx = 0;
        result[idx++] = nums.get(0).get(0);

        for (int rowIdx = 1; rowIdx < n + m - 1; rowIdx++) {
            int r = rowIdx < n ? rowIdx : n - 1;
            int diff = rowIdx < n ? 0 : rowIdx + 1 - n;
            int c = 0 + diff;

            while (r >= 0 && c < m) {
                List<Integer> row = nums.get(r);
                if (row.size() > c) {
                    result[idx++] = row.get(c);
                }
                int key = previousRow[r];
                diff = r - key;
                r = key;
                c += diff;
            }
        }

        return result;
    }
}