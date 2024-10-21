package Easy.Arrays;

import java.util.Arrays;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/rank-transform-of-an-array/">1331. Rank Transform of an Array</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given an array of integers&nbsp;<code>arr</code>, replace each element with its rank.</p>
 * 
 * <p>The rank represents how large the element is. The rank has the following rules:</p>
 * 
 * <ul>
 * 	<li>Rank is an integer starting from 1.</li>
 * 	<li>The larger the element, the larger the rank. If two elements are equal, their rank must be the same.</li>
 * 	<li>Rank should be as small as possible.</li>
 * </ul>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> arr = [40,10,20,30]
 * <strong>Output:</strong> [4,1,2,3]
 * <strong>Explanation</strong>: 40 is the largest element. 10 is the smallest. 20 is the second smallest. 30 is the third smallest.</pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> arr = [100,100,100]
 * <strong>Output:</strong> [1,1,1]
 * <strong>Explanation</strong>: Same elements share the same rank.
 * </pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <pre><strong>Input:</strong> arr = [37,12,28,9,100,56,80,5,12]
 * <strong>Output:</strong> [5,3,4,2,8,6,7,1,3]
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>0 &lt;= arr.length &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>-10<sup>9</sup>&nbsp;&lt;= arr[i] &lt;= 10<sup>9</sup></code></li>
 * </ul>
 * </div>
 */
public class RankTransformOfAnArray {
    public static void main(String[] args) {
        int[][] tests = {
            {37,12,28,9,100,56,80,5,12},
            {40,10,20,30}
        };

        for (int[] arr : tests) {
            System.out.println(Arrays.toString(new RankTransformOfAnArray_Solution().arrayRankTransform(arr)));
        }
    }
}

// 22ms 56.56MB
class RankTransformOfAnArray_Solution {
    public int[] arrayRankTransform(int[] arr) {
        int len = arr.length,
            idx_arr[] = new int[len];

        if (len == 0) {return new int[0];}

        for (int i = 0; i < len; i++) {
            idx_arr[i] = i;
        }
        
        Sort(arr, idx_arr, 0, len-1);

        int ans[] = new int[len],
            rank = 1,
            prev_num = arr[0];

        for (int i = 0; i < len; i++) {
            if (arr[i] == prev_num) {
                ans[idx_arr[i]] = rank;
            } else {
                ans[idx_arr[i]] = ++rank;
            }

            prev_num = arr[i];
        }

        return ans;
    }

    static void merge(int arr[],int idx_arr[], int l, int m, int r){
        int n1 = m - l + 1;
        int n2 = r - m;
 
        int L[] = new int[n1],
            R[] = new int[n2],
            L_idx[] = new int[n1],
            R_idx[] = new int[n2];
 
        for (int i = 0; i < n1; ++i){
            L[i] = arr[l + i];
            L_idx[i] = idx_arr[l+i];
        }
        for (int j = 0; j < n2; ++j){
            R[j] = arr[m + 1 + j];
            R_idx[j] = idx_arr[m + 1 + j];
        }

        int i = 0, j = 0,
            k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                idx_arr[k] = L_idx[i];
                i++;
            } else {
                arr[k] = R[j];
                idx_arr[k] = R_idx[j];
                j++;
            }
            k++;
        }
 
        while (i < n1) {
            arr[k] = L[i];
            idx_arr[k] = L_idx[i];
            i++;
            k++;
        }
 
        while (j < n2) {
            arr[k] = R[j];
            idx_arr[k] = R_idx[j];
            j++;
            k++;
        }
    }
 
    public static void Sort(int arr[], int idx_arr[], int l, int r){
        if (l < r) {
            int m = l + (r - l) / 2;
 
            Sort(arr,idx_arr, l, m);
            Sort(arr,idx_arr, m + 1, r);
 
            merge(arr,idx_arr, l, m, r);
        }
    }
}