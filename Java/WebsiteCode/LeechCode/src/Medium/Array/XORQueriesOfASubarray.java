package Medium.Array;

import java.util.Arrays;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/xor-queries-of-a-subarray/">1310. XOR Queries of a Subarray</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You are given an array <code>arr</code> of positive integers. You are also given the array <code>queries</code> where <code>queries[i] = [left<sub>i, </sub>right<sub>i</sub>]</code>.</p>
 *
 * <p>For each query <code>i</code> compute the <strong>XOR</strong> of elements from <code>left<sub>i</sub></code> to <code>right<sub>i</sub></code> (that is, <code>arr[left<sub>i</sub>] XOR arr[left<sub>i</sub> + 1] XOR ... XOR arr[right<sub>i</sub>]</code> ).</p>
 * 
 * <p>Return an array <code>answer</code> where <code>answer[i]</code> is the answer to the <code>i<sup>th</sup></code> query.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> arr = [1,3,4,8], queries = [[0,1],[1,2],[0,3],[3,3]]
 * <strong>Output:</strong> [2,7,14,8] 
 * <strong>Explanation:</strong> 
 * The binary representation of the elements in the array are:
 * 1 = 0001 
 * 3 = 0011 
 * 4 = 0100 
 * 8 = 1000 
 * The XOR values for queries are:
 * [0,1] = 1 xor 3 = 2 
 * [1,2] = 3 xor 4 = 7 
 * [0,3] = 1 xor 3 xor 4 xor 8 = 14 
 * [3,3] = 8
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> arr = [4,8,2,10], queries = [[2,3],[1,3],[0,0],[0,3]]
 * <strong>Output:</strong> [8,0,4,4]
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= arr.length, queries.length &lt;= 3 * 10<sup>4</sup></code></li>
 * 	<li><code>1 &lt;= arr[i] &lt;= 10<sup>9</sup></code></li>
 * 	<li><code>queries[i].length == 2</code></li>
 * 	<li><code>0 &lt;= left<sub>i</sub> &lt;= right<sub>i</sub> &lt; arr.length</code></li>
 * </ul>
 * </div>
 */
public class XORQueriesOfASubarray {
    public static void main(String[] args) {
        int[][][][] tests = {
            {
                {{1,3,4,8}},
                {{0,1},{1,2},{0,3},{3,3}}
            }
        };

        for (int[][][] test : tests) {
            int arr[] = test[0][0],
                queries[][] = test[1];

            System.out.println(Arrays.toString(new XORQueriesOfASubarray_Solution().xorQueries(arr, queries)));
        }
    }
}

// Brute-Force: 551ms 56.36MB
class XORQueriesOfASubarray_Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int ans[] = new int[queries.length],
            idx = 0;
        
        for (int[] query : queries) {
            int start = query[0],
                end = query[1],
                xor = 0;

            for (int i = start; i <= end; i++) {
                xor ^= arr[i];
            }

            ans[idx++] = xor;
        }

        return ans;
    }
}