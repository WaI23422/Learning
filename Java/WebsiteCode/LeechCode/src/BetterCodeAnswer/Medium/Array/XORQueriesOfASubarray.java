package BetterCodeAnswer.Medium.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

// 8ms 55.90MB
class XORQueriesOfASubarray_Solution {

    public int[] xorQueries(int[] arr, int[][] queries) {
        List<Integer> result = new ArrayList<>();

        // Step 1: Convert arr into an in-place prefix XOR array
        for (int i = 1; i < arr.length; ++i) {
            arr[i] ^= arr[i - 1];
        }

        // Step 2: Resolve each query using the prefix XOR array
        for (int[] q : queries) {
            if (q[0] > 0) {
                result.add(arr[q[0] - 1] ^ arr[q[1]]);
            } else {
                result.add(arr[q[1]]);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}

// 2ms 55.00MBs
class XORQueriesOfASubarray_Solution2 {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n=arr.length;
        int[] pre=new int[n];
        pre[0]=arr[0];
        for(int i=1;i<n;i++) {
            pre[i]=pre[i-1]^arr[i];
        }
        int[] res=new int[queries.length];
        for(int k=0;k<queries.length;k++) {
            int i=queries[k][0];
            int j=queries[k][1];
            if(i==0) {
                res[k]=pre[j];
            } else {
                res[k]=pre[j]^pre[i-1];
            }
        }
        return res;
    }
}