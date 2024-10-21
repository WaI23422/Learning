package Medium.Array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/least-number-of-unique-integers-after-k-removals/">1481.Least Number of Unique Integers after K Removals</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given an array of integers&nbsp;<code>arr</code>&nbsp;and an integer <code>k</code>.&nbsp;Find the <em>least number of unique integers</em>&nbsp;after removing <strong>exactly</strong> <code>k</code> elements<b>.</b></p>

<ol>
</ol>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input: </strong>arr = [5,5,4], k = 1
<strong>Output: </strong>1
<strong>Explanation</strong>: Remove the single 4, only 5 is left.
</pre>
<strong class="example">Example 2:</strong>

<pre><strong>Input: </strong>arr = [4,3,1,1,3,3,2], k = 3
<strong>Output: </strong>2
<strong>Explanation</strong>: Remove 4, 2 and either one of the two 1s or three 3s. 1 and 3 will be left.</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= arr.length&nbsp;&lt;= 10^5</code></li>
	<li><code>1 &lt;= arr[i] &lt;= 10^9</code></li>
	<li><code>0 &lt;= k&nbsp;&lt;= arr.length</code></li>
</ul></div>
 */
public class LeastNumberOfUniqueIntegersAfterKRemovals {
    public static void main(String[] args) {
        int[][][] tests = {
            {{5,5,4},{1}},
            {{4,3,1,1,3,3,2},{3}},
            {{4,3,1,1,3,3,2},{0}},
            {{4,3,1,1,3,3,2},{7}},
            {{1,2,3,4},{3}},
            {{2,4,1,8,3,5,1,3},{3}}
        }; 

        for (int[][] test : tests) {
            int[] arr = test[0];
            int k = test[1][0];

            System.out.println(new LeastNumberOfUniqueIntegersAfterKRemovals_Solution().findLeastNumOfUniqueInts(arr, k));
        }
    }
}

// 43 ms 56.8 MB
class LeastNumberOfUniqueIntegersAfterKRemovals_Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        int i = 0;

        HashMap<Integer,Integer> appearNums = new HashMap<>();

        for (int num : arr) {
            appearNums.put(num, appearNums.getOrDefault(num, 0)+1);
        }

        int[] arrAppear = appearNums.values().stream()                  // 41 ms 56.9 MB : Object[] arrAppear = appearNums.values().toArray();
                                             .mapToInt(t -> (int) t)
                                             .toArray();

        Arrays.sort(arrAppear);

        while (k > 0) {
            k -= arrAppear[i++]; // 41 ms 56.9 MB : k -= (int) arrAppear[i++];
        }

        return k < 0 ? arrAppear.length-i +1 : arrAppear.length-i ;
    }
}