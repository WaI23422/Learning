package BetterCodeAnswer.Medium.Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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

// 25 ms 56.8 MB
class LeastNumberOfUniqueIntegersAfterKRemovals_Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Arrays.sort(arr);
        int[] node = new int[arr.length+1];
        int cnt = 0;
        int length=1;
        for (int i = 0; i < arr.length; i++) {
            if (i+1 < arr.length && arr[i] == arr[i+1]) {
                length++;
            } else {
                cnt++;
                node[length]++;
                length=1;
            }
        }
        for(int i=1;i<node.length;i++) {
            int canRemove = Math.min(k/i, node[i]);
            cnt-=canRemove;
            k-=canRemove*i;
        }
        return cnt;
    }
}

// 29 ms 56.8 MB
class LeastNumberOfUniqueIntegersAfterKRemovals_Solution2    {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            count.put(arr[i], count.getOrDefault(arr[i], 0) + 1);
        }
        int unique = count.size();

        int[] countArray = new int[100000];
        for(Integer key : count.keySet()) {
            int keyCount = count.get(key);
            countArray[keyCount]++;
        }

        for (int i = 1; i < 100000; i++) {
            if (countArray[i]!= 0) {
                int remove = k / i;
                if (remove == 0) {
                    break;
                } else {
                    remove = Math.min(remove, countArray[i]);
                    unique -= remove;
                    k -= remove * i;
                }
            }
        }
        return unique;
    }
}