package BetterCodeAnswer.Medium.Array;

import java.util.HashMap;
import java.util.Map;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/restore-the-array-from-adjacent-pairs/">1743.Restore the Array From Adjacent Pairs</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>There is an integer array <code>nums</code> that consists of <code>n</code> <strong>unique </strong>elements, but you have forgotten it. However, you do remember every pair of adjacent elements in <code>nums</code>.</p>

<p>You are given a 2D integer array <code>adjacentPairs</code> of size <code>n - 1</code> where each <code>adjacentPairs[i] = [u<sub>i</sub>, v<sub>i</sub>]</code> indicates that the elements <code>u<sub>i</sub></code> and <code>v<sub>i</sub></code> are adjacent in <code>nums</code>.</p>

<p>It is guaranteed that every adjacent pair of elements <code>nums[i]</code> and <code>nums[i+1]</code> will exist in <code>adjacentPairs</code>, either as <code>[nums[i], nums[i+1]]</code> or <code>[nums[i+1], nums[i]]</code>. The pairs can appear <strong>in any order</strong>.</p>

<p>Return <em>the original array </em><code>nums</code><em>. If there are multiple solutions, return <strong>any of them</strong></em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> adjacentPairs = [[2,1],[3,4],[3,2]]
<strong>Output:</strong> [1,2,3,4]
<strong>Explanation:</strong> This array has all its adjacent pairs in adjacentPairs.
Notice that adjacentPairs[i] may not be in left-to-right order.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> adjacentPairs = [[4,-2],[1,4],[-3,1]]
<strong>Output:</strong> [-2,4,1,-3]
<strong>Explanation:</strong> There can be negative numbers.
Another solution is [-3,1,4,-2], which would also be accepted.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> adjacentPairs = [[100000,-100000]]
<strong>Output:</strong> [100000,-100000]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>nums.length == n</code></li>
	<li><code>adjacentPairs.length == n - 1</code></li>
	<li><code>adjacentPairs[i].length == 2</code></li>
	<li><code>2 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>-10<sup>5</sup> &lt;= nums[i], u<sub>i</sub>, v<sub>i</sub> &lt;= 10<sup>5</sup></code></li>
	<li>There exists some <code>nums</code> that has <code>adjacentPairs</code> as its pairs.</li>
</ul>
</div></div>
 */
public class RestoreTheArrayFromAdjacentPairs {
    public static void main(String[] args) {
        int[][][] test = {
            {{1,2},{3,2},{4,1},{1,3}},
        };

        RestoreTheArrayFromAdjacentPairs_Solution res = new RestoreTheArrayFromAdjacentPairs_Solution();

        for (int[][] adjacentPairs : test) {
            System.out.println(res.restoreArray(adjacentPairs));
        }
    }   
}

/**
 * <h1 id="intuition">Intuition</h1>
 * <p>The problem involves reconstructing the original array from the adjacent pairs. We know that each element in the original array is unique, but the order of the elements is not given. To solve this, we can create a mapping of each element to its adjacent elements using a dictionary. We iterate through the adjacent pairs and build this mapping.</p>
 * <p>Next, we find the starting element that has only one adjacent element (the first element in the original array) and begin building the original array from there. We use a result array to store the elements of the original array as we traverse the adjacent pairs.</p>
 * <p>Next, we find the starting element that has only one adjacent element (the first element in the original array) and begin building the original array from there. We use a result array to store the elements of the original array as we traverse the adjacent pairs.</p>
 * <h1 id="approach">Approach</h1>
 * <ol>
<li>Create a dictionary <code>pairs</code> to store the mapping of each element to its adjacent elements. Initialize it with empty arrays.</li>
<li>Iterate through the adjacent pairs, updating the <code>pairs</code> dictionary.</li>
<li>Find the starting element (the one with only one adjacent element) and set it as the first element in the result array.</li>
<li>Continue building the result array by choosing the adjacent element of the current element and updating the current element. Repeat this process until we have reconstructed the entire array.</li>
<li>Return the result array as the original array.</li>
</ol>
 */
class RestoreTheArrayFromAdjacentPairs_Solution {
    public int[] restoreArray(int[][] vals) {
        Map<Integer, int[]> pairs = new HashMap<>();
        for (int i = 0; i < vals.length; i++) {
            if (pairs.containsKey(vals[i][0])) {
                pairs.get(vals[i][0])[1] = vals[i][1];
            } else {
                pairs.put(vals[i][0], new int[] {vals[i][1], -1000000});
            }
            if (pairs.containsKey(vals[i][1])) {
                pairs.get(vals[i][1])[1] = vals[i][0];
            } else {
                pairs.put(vals[i][1], new int[] {vals[i][0], -1000000});
            }
        }
        int[] result = new int[vals.length + 1];
        int start = -1000000;
        for (Map.Entry<Integer, int[]> entry : pairs.entrySet()) {
            if (entry.getValue()[1] == -1000000) {
                start = entry.getKey();
            }
        }
        result[0] = start;
        int left = -1000000;
        for (int i = 1; i < result.length; i++) {
            int[] val = pairs.get(start);
            int newval = (val[0] == left ? val[1] : val[0]);
            result[i] = newval;
            left = start;
            start = newval;
        }
        return result;
    }
}