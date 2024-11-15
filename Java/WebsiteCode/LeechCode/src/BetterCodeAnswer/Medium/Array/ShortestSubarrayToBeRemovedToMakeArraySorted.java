package BetterCodeAnswer.Medium.Array;

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

// 2ms 64.79MB
class ShortestSubarrayToBeRemovedToMakeArraySorted_Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n=arr.length;
        int left=0,right=arr.length-1;
        while(left<n-1&&arr[left]<=arr[left+1]) {left++;}
        if(left==n-1) {return 0;}
        while(right>0&&arr[right]>=arr[right-1]) {right--;}
        int res=Math.min(right,n-left-1);
        int i=0;
        while(i<=left&&right<n)
        {
            if(arr[i]<=arr[right])
            {
                res=Math.min(res,right-i-1);
                i++;
            }
            else
            right++;
        }
        return res;
    }
}