package Medium.Array;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/shortest-subarray-to-be-removed-to-make-array-sorted/">1574. Shortest Subarray to be Removed to Make Array Sorted</a>
 * 
 * <div><div class="elfjS" data-track-load="description_content"><p>Given an integer array <code>arr</code>, remove a subarray (can be empty) from <code>arr</code> such that the remaining elements in <code>arr</code> are <strong>non-decreasing</strong>.</p>
 * 
 * <p>Return <em>the length of the shortest subarray to remove</em>.</p>
 * 
 * <p>A <strong>subarray</strong> is a contiguous subsequence of the array.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> arr = [1,2,3,10,4,2,3,5]
 * <strong>Output:</strong> 3
 * <strong>Explanation:</strong> The shortest subarray we can remove is [10,4,2] of length 3. The remaining elements after that will be [1,2,3,3,5] which are sorted.
 * Another correct solution is to remove the subarray [3,10,4].
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> arr = [5,4,3,2,1]
 * <strong>Output:</strong> 4
 * <strong>Explanation:</strong> Since the array is strictly decreasing, we can only keep a single element. Therefore we need to remove a subarray of length 4, either [5,4,3,2] or [4,3,2,1].
 * </pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <pre><strong>Input:</strong> arr = [1,2,3]
 * <strong>Output:</strong> 0
 * <strong>Explanation:</strong> The array is already non-decreasing. We do not need to remove any elements.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= arr.length &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>0 &lt;= arr[i] &lt;= 10<sup>9</sup></code></li>
 * </ul>
 * </div></div>
 */
public class ShortestSubarrayToBeRemovedToMakeArraySorted {
    public static void main(String[] args) {
        int[][] tests = {
            {2,7,4,6,11,17,4,1,5,13,10,12},
            {4,1,8,10,4},
            {5,4,3,2,1},
            {1,2,3,10,4,2,3,5},
            {1,2,3},
        };

        for (int[] arr : tests) {
            System.out.println(new ShortestSubarrayToBeRemovedToMakeArraySorted_Solution().findLengthOfShortestSubarray(arr));
        }
    }
}

// 1084ms 64.79MB
class ShortestSubarrayToBeRemovedToMakeArraySorted_Solution {
    
    public int findLengthOfShortestSubarray(int[] arr) {    
        int len = arr.length-1,
            left = 0;
        boolean state[] = new boolean[len+1];

        if (len == 0) {return 0;}

        state[0] = true;
        while (left < len) {
            if (arr[left] > arr[left+1]) {break;}
            state[left+1] = true;
            left++;
        }
        if (left == len) {return 0;}

        int right = len,
            min = len-left;
        while (right > 0) {
            if (arr[right-1] > arr[right]) {break;}
            right--;
        }

        for (int i = len; i >= right; i--) {
            int idx = 0;
            while (arr[idx] <= arr[i] && state[idx]) {idx++;}
            min = Math.min(i - idx,min);
        }

        return min;
    }
}