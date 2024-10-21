package Medium.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/sort-the-jumbled-numbers/">2191. Sort the Jumbled Numbers</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You are given a <strong>0-indexed</strong> integer array <code>mapping</code> which represents the mapping rule of a shuffled decimal system. <code>mapping[i] = j</code> means digit <code>i</code> should be mapped to digit <code>j</code> in this system.</p>
 * 
 * <p>The <strong>mapped value</strong> of an integer is the new integer obtained by replacing each occurrence of digit <code>i</code> in the integer with <code>mapping[i]</code> for all <code>0 &lt;= i &lt;= 9</code>.</p>
 * 
 * <p>You are also given another integer array <code>nums</code>. Return <em>the array </em><code>nums</code><em> sorted in <strong>non-decreasing</strong> order based on the <strong>mapped values</strong> of its elements.</em></p>
 * 
 * <p><strong>Notes:</strong></p>
 * 
 * <ul>
 * 	<li>Elements with the same mapped values should appear in the <strong>same relative order</strong> as in the input.</li>
 * 	<li>The elements of <code>nums</code> should only be sorted based on their mapped values and <strong>not be replaced</strong> by them.</li>
 * </ul>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> mapping = [8,9,4,0,2,1,3,5,7,6], nums = [991,338,38]
 * <strong>Output:</strong> [338,38,991]
 * <strong>Explanation:</strong> 
 * Map the number 991 as follows:
 * 1. mapping[9] = 6, so all occurrences of the digit 9 will become 6.
 * 2. mapping[1] = 9, so all occurrences of the digit 1 will become 9.
 * Therefore, the mapped value of 991 is 669.
 * 338 maps to 007, or 7 after removing the leading zeros.
 * 38 maps to 07, which is also 7 after removing leading zeros.
 * Since 338 and 38 share the same mapped value, they should remain in the same relative order, so 338 comes before 38.
 * Thus, the sorted array is [338,38,991].
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> mapping = [0,1,2,3,4,5,6,7,8,9], nums = [789,456,123]
 * <strong>Output:</strong> [123,456,789]
 * <strong>Explanation:</strong> 789 maps to 789, 456 maps to 456, and 123 maps to 123. Thus, the sorted array is [123,456,789].
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>mapping.length == 10</code></li>
 * 	<li><code>0 &lt;= mapping[i] &lt;= 9</code></li>
 * 	<li>All the values of <code>mapping[i]</code> are <strong>unique</strong>.</li>
 * 	<li><code>1 &lt;= nums.length &lt;= 3 * 10<sup>4</sup></code></li>
 * 	<li><code>0 &lt;= nums[i] &lt; 10<sup>9</sup></code></li>
 * </ul>
 * </div>
 */
public class SortTheJumbledNumbers {
    public static void main(String[] args) {
        int[][][] tests = {
            {
                {8,9,4,0,2,1,3,5,7,6},
                {991,338,38}
            },
            {
                {9,8,7,6,5,4,3,2,1,0},
                {0,1,2,3,4,5,6,7,8,9}
            },
        };

        for (int[][] test : tests) {
            int[] mapping = test[0],
                  nums = test[1];

            System.out.println(Arrays.toString(new SortTheJumbledNumbers_Solution().sortJumbled(mapping, nums)));
        }
    }
}

// 125ms 55.49MB  
class SortTheJumbledNumbers_Solution {
    int[] mapping;
    public int[] sortJumbled(int[] mapping, int[] nums) {
        this.mapping = mapping;
        int len = nums.length;

        List<int[]> pairs = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            pairs.add(new int[]{convertNums(nums[i]),nums[i]});
        }

        // 139ms 55.49MB -> 125ms 55.49MB
        Collections.sort(pairs, (a, b) -> a[0] - b[0]);
        // Collections.sort(
        //     pairs,
        //     new Comparator<Integer[]>() {
        //         @Override
        //         public int compare(Integer[] o1, Integer[] o2) {
        //             return o1[0].compareTo(o2[0]);
        //         }
        //     }
        // );

        for (int i = 0; i < pairs.size(); i++) {
            nums[i] = pairs.get(i)[1];
        }

        return nums;
    }

    private int convertNums(int num) {
        if (num == 0) { return mapping[0]; }

        int tempNum = 0,
            at = 0;

        while (num != 0) {
            int temp = num % 10;
            num /= 10;

            tempNum += mapping[temp]*Math.pow(10, at++);
        }

        return tempNum;
    }

    // int[] mapping;
    // public int[] sortJumbled(int[] mapping, int[] nums) {
    //     this.mapping = mapping;
    //     int len = nums.length,
    //         numsMapping[] = new int[len];

    //     for (int i = 0; i < len; i++) {
    //         numsMapping[i] = convertNums(nums[i]);
    //     }

    //     quickSort(numsMapping , nums, 0, len-1);

    //     return nums;
    // }

    // private int convertNums(int num) {
    //     if (num == 0) { return mapping[0]; }

    //     int tempNum = 0,
    //         at = 0;

    //     while (num != 0) {
    //         int temp = num % 10;
    //         num /= 10;

    //         tempNum += mapping[temp]*Math.pow(10, at++);
    //     }

    //     return tempNum;
    // }

    // private void quickSort(int[] arr, int[] coArr, int low, int high){
    //     if (low < high) {
    //         int pi = partition(arr, coArr, low, high);
    //         quickSort(arr, coArr, low, pi - 1);
    //         quickSort(arr, coArr, pi + 1, high);
    //     }
    // }

    // private void swap(int[] arr, int[] coArr, int i, int j){
    //     int temp = arr[i];
    //     arr[i] = arr[j];
    //     arr[j] = temp;

    //     temp = coArr[i];
    //     coArr[i] = coArr[j];
    //     coArr[j] = temp;
    // }

    // private int partition(int[] arr, int[] coArr, int low, int high){
    //     int pivot = arr[high];
    //     int i = (low - 1);
 
    //     for (int j = low; j <= high - 1; j++) {
    //         if (arr[j] <= pivot) {
    //             i++;
    //             swap(arr,coArr, i, j);
    //         }
    //     }
    //     swap(arr,coArr, i + 1, high);
    //     return (i + 1);
    // }
}

// 81ms 55.3MB
class SortTheJumbledNumbers_Solution2 {

    public int[] sortJumbled(int[] mapping, int[] nums) {
        List<int[]> storePairs = new ArrayList<int[]>();

        for (int i = 0; i < nums.length; i++) {
            int mappedValue = 0;
            int temp = nums[i];
            int place = 1;

            if (temp == 0) {
                storePairs.add(new int[] { mapping[0], i });
                continue;
            }
            while (temp != 0) {
                mappedValue = place * mapping[temp % 10] + mappedValue;
                place *= 10;
                temp /= 10;
            }
            storePairs.add(new int[] { mappedValue, i });
        }

        Collections.sort(storePairs, (a, b) -> a[0] - b[0]);

        int[] answer = new int[nums.length];
        for (int i = 0; i < storePairs.size(); i++) {
            answer[i] = nums[storePairs.get(i)[1]];
        }

        return answer;
    }
}