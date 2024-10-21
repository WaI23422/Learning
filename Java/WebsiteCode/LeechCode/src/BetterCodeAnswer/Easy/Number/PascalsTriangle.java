package BetterCodeAnswer.Easy.Number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/pascals-triangle/">118.Pascal's Triangle</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>Given an integer <code>numRows</code>, return the first numRows of <strong>Pascal's triangle</strong>.</p>

<p>In <strong>Pascal's triangle</strong>, each number is the sum of the two numbers directly above it as shown:</p>
<img alt="" src="https://upload.wikimedia.org/wikipedia/commons/0/0d/PascalTriangleAnimated2.gif" style="height: 240px; width: 260px;">
<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> numRows = 5
<strong>Output:</strong> [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> numRows = 1
<strong>Output:</strong> [[1]]
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= numRows &lt;= 30</code></li>
</ul>
</div></div>
 */
public class PascalsTriangle {
    public static void main(String[] args) {
        int[] tests = {
            5,
            1,
            2,
            3,
        };

        for (int numRows : tests) {
            List<List<Integer>> ansList = new PascalsTriangle_Solution().generate(numRows);

            System.out.print("[");
            for (int i = 0; i < ansList.size(); i++) {  
                if (i != ansList.size()-1) {
                    System.out.print(Arrays.toString(ansList.get(i).stream().mapToInt(t->t).toArray())+",");
                } else {
                    System.out.print(Arrays.toString(ansList.get(i).stream().mapToInt(t->t).toArray()));
                }
            }
            System.out.println("]" );
        }
    }
}

// 0 ms 40.7 MB
class PascalsTriangle_Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            int val = 1;
            for (int j = 0; j <= i; j++) {
                row.add(val);
                val = val * (i - j) / (j + 1);
            }
            result.add(row);
        }
        return result;
    }
}