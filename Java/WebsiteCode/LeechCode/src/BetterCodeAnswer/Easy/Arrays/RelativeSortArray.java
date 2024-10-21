package BetterCodeAnswer.Easy.Arrays;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/relative-sort-array/">1122. Relative Sort Array</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given two arrays <code>arr1</code> and <code>arr2</code>, the elements of <code>arr2</code> are distinct, and all elements in <code>arr2</code> are also in <code>arr1</code>.</p>
 * 
 * <p>Sort the elements of <code>arr1</code> such that the relative ordering of items in <code>arr1</code> are the same as in <code>arr2</code>. Elements that do not appear in <code>arr2</code> should be placed at the end of <code>arr1</code> in <strong>ascending</strong> order.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * <strong>Output:</strong> [2,2,2,1,4,3,3,9,6,7,19]
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> arr1 = [28,6,22,8,44,17], arr2 = [22,28,8,6]
 * <strong>Output:</strong> [22,28,8,6,17,44]
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= arr1.length, arr2.length &lt;= 1000</code></li>
 * 	<li><code>0 &lt;= arr1[i], arr2[i] &lt;= 1000</code></li>
 * 	<li>All the elements of <code>arr2</code> are <strong>distinct</strong>.</li>
 * 	<li>Each&nbsp;<code>arr2[i]</code> is in <code>arr1</code>.</li>
 * </ul>
 * </div>
 * 
 */ 
public class RelativeSortArray {
    public static void main(String[] args) {
        int[][][] tests = {
            {
                {2,21,43,38,0,42,33,7,24,13,12,27,12,24,5,23,29,48,30,31},
                {2,42,38,0,43,21}
            }
        };

        for (int[][] test : tests) {
            int[] arr1 = test[0],
                  arr2 = test[1];

            System.out.println(Arrays.toString(new RelativeSortArray_Solution().relativeSortArray(arr1, arr2)));
        }
    }
}

// 1 ms 42 MB
class RelativeSortArray_Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] arr2Idx = new int[1001];
        Arrays.fill(arr2Idx, -1);
        for(int i = 0; i < arr2.length; i++) {
            arr2Idx[arr2[i]] = i;
        }

        Comparator<Integer> comparator = (Integer a, Integer b) -> {
            if(arr2Idx[a] != -1 && arr2Idx[b] != -1) {
                return arr2Idx[a] - arr2Idx[b];
            } else if(arr2Idx[a] != -1) {
                return - 1;
            } else if (arr2Idx[b] != -1) {
                return 1;
            }
            return a - b;
        };
        mergeSort(arr1, comparator, 0, arr1.length, new int[arr1.length]);

        return arr1;
    }

    private void mergeSort(int[] nums, Comparator<Integer> comparator, int start, int end, int[] tmp) {
        if(end - start == 1) {
            return;
        }
        int p = (start + end)/2;
        mergeSort(nums, comparator, start, p, tmp);
        mergeSort(nums, comparator, p, end, tmp);
        mergeSorted(nums, comparator, start, p, end, tmp);
    }

    private void mergeSorted(int[] nums, Comparator<Integer> comparator, int start, int p, int end, int[] tmp) {
        //int k = 0;
        for(int i = start; i < end; i++){
            tmp[i] = nums[i];
        }

        int i = start;
        int j = p;
        int k = start;

        while(i < p && j < end) {
            while(i < p && comparator.compare(tmp[i], tmp[j]) <= 0) {
                nums[k] = tmp[i];
                i++;
                k++;
            }
            while(j < end && comparator.compare(tmp[j], tmp[i]) <= 0) {
                nums[k] = tmp[j];
                j++;
                k++;
            }
        }
        while(i < p) {
            nums[k] = tmp[i];
            i++;
            k++;
        }
        while(j < end) {
            nums[k] = tmp[j];
            j++;
            k++;
        }
    }
}