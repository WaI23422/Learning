package Hard.Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/minimum-number-of-removals-to-make-mountain-array/">1671. Minimum Number of Removals to Make Mountain Array</a>
 * 
 * <div><div class="elfjS" data-track-load="description_content"><p>You may recall that an array <code>arr</code> is a <strong>mountain array</strong> if and only if:</p>
 * 
 * <ul>
 * 	<li><code>arr.length &gt;= 3</code></li>
 * 	<li>There exists some index <code>i</code> (<strong>0-indexed</strong>) with <code>0 &lt; i &lt; arr.length - 1</code> such that:
 * 	<ul>
 * 		<li><code>arr[0] &lt; arr[1] &lt; ... &lt; arr[i - 1] &lt; arr[i]</code></li>
 * 		<li><code>arr[i] &gt; arr[i + 1] &gt; ... &gt; arr[arr.length - 1]</code></li>
 * 	</ul>
 * 	</li>
 * </ul>
 * 
 * <p>Given an integer array <code>nums</code>​​​, return <em>the <strong>minimum</strong> number of elements to remove to make </em><code>nums<em>​​​</em></code><em> </em><em>a <strong>mountain array</strong>.</em></p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [1,3,1]
 * <strong>Output:</strong> 0
 * <strong>Explanation:</strong> The array itself is a mountain array so we do not need to remove any elements.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [2,1,1,5,6,2,3,1]
 * <strong>Output:</strong> 3
 * <strong>Explanation:</strong> One solution is to remove the elements at indices 0, 1, and 5, making the array nums = [1,5,6,3,1].
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>3 &lt;= nums.length &lt;= 1000</code></li>
 * 	<li><code>1 &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
 * 	<li>It is guaranteed that you can make a mountain array out of <code>nums</code>.</li>
 * </ul>
 * </div></div>
 */
public class MinimumNumberOfRemovalsToMakeMountainArray {
    public static void main(String[] args) {
        int[][] tests = {
            {2,3,1,3,1},
            {1,3,1},
            {2,3,1,4,1},
            {2,1,1,5,6,2,3,1},
        };

        for (int[] nums : tests) {
            System.out.println(new MinimumNumberOfRemovalsToMakeMountainArray_Solution().minimumMountainRemovals(nums));
        }
    }
}

/**
 * 20ms 44.68MB
 */
class MinimumNumberOfRemovalsToMakeMountainArray_Solution {

    private List<Integer> getLongestIncreasingSubsequenceLength(
        List<Integer> v
    ) {
        List<Integer> lisLen = new ArrayList<>(
            Collections.nCopies(v.size(), 1)
        );
        List<Integer> lis = new ArrayList<>();
        lis.add(v.get(0));

        for (int i = 1; i < v.size(); i++) {
            int index = lowerBound(lis, v.get(i));

            // Add to the list if v[i] is greater than the last element
            if (index == lis.size()) {
                lis.add(v.get(i));
            } else {
                // Replace the element at index with v[i]
                lis.set(index, v.get(i));
            }

            lisLen.set(i, lis.size());
        }

        return lisLen;
    }

    // Returns the index of the first element which is equal to or greater than target.
    private int lowerBound(List<Integer> lis, int target) {
        int left = 0, right = lis.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (lis.get(mid) >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int minimumMountainRemovals(int[] nums) {
        int N = nums.length;
        List<Integer> numsList = new ArrayList<>();
        for (int num : nums) numsList.add(num);

        List<Integer> lisLength = getLongestIncreasingSubsequenceLength(
            numsList
        );

        Collections.reverse(numsList);
        List<Integer> ldsLength = getLongestIncreasingSubsequenceLength(
            numsList
        );
        // Reverse the length array to correctly depict the lenght of longest decreasing subsequnec for each index.
        Collections.reverse(ldsLength);

        int minRemovals = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            if (lisLength.get(i) > 1 && ldsLength.get(i) > 1) {
                minRemovals = Math.min(
                    minRemovals,
                    N - lisLength.get(i) - ldsLength.get(i) + 1
                );
            }
        }

        return minRemovals;
    }
}