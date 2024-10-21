package BetterCodeAnswer.Hard.Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/build-a-matrix-with-conditions/">2392. Build a Matrix With Conditions</a>
 * <div class="elfjS" data-track-load="description_content"><p>You are given a <strong>positive</strong> integer <code>k</code>. You are also given:</p>
 * 
 * <ul>
 * 	<li>a 2D integer array <code>rowConditions</code> of size <code>n</code> where <code>rowConditions[i] = [above<sub>i</sub>, below<sub>i</sub>]</code>, and</li>
 * 	<li>a 2D integer array <code>colConditions</code> of size <code>m</code> where <code>colConditions[i] = [left<sub>i</sub>, right<sub>i</sub>]</code>.</li>
 * </ul>
 * 
 * <p>The two arrays contain integers from <code>1</code> to <code>k</code>.</p>
 * 
 * <p>You have to build a <code>k x k</code> matrix that contains each of the numbers from <code>1</code> to <code>k</code> <strong>exactly once</strong>. The remaining cells should have the value <code>0</code>.</p>
 * 
 * <p>The matrix should also satisfy the following conditions:</p>
 * 
 * <ul>
 * 	<li>The number <code>above<sub>i</sub></code> should appear in a <strong>row</strong> that is strictly <strong>above</strong> the row at which the number <code>below<sub>i</sub></code> appears for all <code>i</code> from <code>0</code> to <code>n - 1</code>.</li>
 * 	<li>The number <code>left<sub>i</sub></code> should appear in a <strong>column</strong> that is strictly <strong>left</strong> of the column at which the number <code>right<sub>i</sub></code> appears for all <code>i</code> from <code>0</code> to <code>m - 1</code>.</li>
 * </ul>
 * 
 * <p>Return <em><strong>any</strong> matrix that satisfies the conditions</em>. If no answer exists, return an empty matrix.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2022/07/06/gridosdrawio.png" style="width: 211px; height: 211px;">
 * <pre><strong>Input:</strong> k = 3, rowConditions = [[1,2],[3,2]], colConditions = [[2,1],[3,2]]
 * <strong>Output:</strong> [[3,0,0],[0,0,1],[0,2,0]]
 * <strong>Explanation:</strong> The diagram above shows a valid example of a matrix that satisfies all the conditions.
 * The row conditions are the following:
 * - Number 1 is in row <u>1</u>, and number 2 is in row <u>2</u>, so 1 is above 2 in the matrix.
 * - Number 3 is in row <u>0</u>, and number 2 is in row <u>2</u>, so 3 is above 2 in the matrix.
 * The column conditions are the following:
 * - Number 2 is in column <u>1</u>, and number 1 is in column <u>2</u>, so 2 is left of 1 in the matrix.
 * - Number 3 is in column <u>0</u>, and number 2 is in column <u>1</u>, so 3 is left of 2 in the matrix.
 * Note that there may be multiple correct answers.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> k = 3, rowConditions = [[1,2],[2,3],[3,1],[2,3]], colConditions = [[2,1]]
 * <strong>Output:</strong> []
 * <strong>Explanation:</strong> From the first two conditions, 3 has to be below 1 but the third conditions needs 3 to be above 1 to be satisfied.
 * No matrix can satisfy all the conditions, so we return the empty matrix.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>2 &lt;= k &lt;= 400</code></li>
 * 	<li><code>1 &lt;= rowConditions.length, colConditions.length &lt;= 10<sup>4</sup></code></li>
 * 	<li><code>rowConditions[i].length == colConditions[i].length == 2</code></li>
 * 	<li><code>1 &lt;= above<sub>i</sub>, below<sub>i</sub>, left<sub>i</sub>, right<sub>i</sub> &lt;= k</code></li>
 * 	<li><code>above<sub>i</sub> != below<sub>i</sub></code></li>
 * 	<li><code>left<sub>i</sub> != right<sub>i</sub></code></li>
 * </ul>
 * </div>
 */
public class BuildAMatrixWithConditions {
    public static void main(String[] args) {
        int[][][][] tests = {
            {
                {
                    {1,2},
                    {3,2}
                },
                {
                    {2,1},
                    {3,2}
                },
                {{3}}
            }
        };

        for (int[][][] test : tests) {
            int k = test[2][0][0],
                rowConditions[][] = test[0],
                colConditions[][] = test[1];

            System.out.println(new BuildAMatrixWithConditions_Solution().buildMatrix(k, rowConditions, colConditions));
        }
    }
}

// 10ms 55.97MB 
// Kahn's algorithm
class BuildAMatrixWithConditions_Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        List<Integer> order1 = GenerateTopologicalSort(rowConditions, k);
        List<Integer> order2 = GenerateTopologicalSort(colConditions, k);
        if (order1.size() < k || order2.size() < k) return new int[0][0];
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < k; i++) m.put(order2.get(i), i);
        int[][] ans = new int[k][k];
        for (int i = 0; i < k; i++)
            ans[i][m.get(order1.get(i))] = order1.get(i);
        return ans;
    }

    private List<Integer> GenerateTopologicalSort(int[][] A, int k) {
        int[] deg = new int[k];
        List<Integer> order = new ArrayList<>();
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < k; i++) graph.add(new ArrayList<>());
        Queue<Integer> q = new LinkedList<>();
        for (int[] c: A) {
            graph.get(c[0] - 1).add(c[1] - 1);
            deg[c[1] - 1]++;
        }
        for (int i = 0; i < k; i++)
            if (deg[i] == 0) q.add(i);
        while(!q.isEmpty()) {
            int x = q.poll();
            order.add(x + 1);
            for (int y: graph.get(x)) 
                if (--deg[y] == 0) q.add(y);
        }
        return order;
    }
}