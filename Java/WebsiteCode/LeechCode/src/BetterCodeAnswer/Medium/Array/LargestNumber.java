package BetterCodeAnswer.Medium.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/largest-number/">179. Largest Number</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given a list of non-negative integers <code>nums</code>, arrange them such that they form the largest number and return it.</p>
 * 
 * <p>Since the result may be very large, so you need to return a string instead of an integer.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [10,2]
 * <strong>Output:</strong> "210"
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [3,30,34,5,9]
 * <strong>Output:</strong> "9534330"
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= nums.length &lt;= 100</code></li>
 * 	<li><code>0 &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
 * </ul>
 * </div>
 */
public class LargestNumber {
    public static void main(String[] args) {
        int[][] tests = {
            {432,43243},
            {3,5,30,34,9,922,91,55,545},
            {10,2},
        };

        for (int[] nums : tests) {
            System.out.println(new LargestNumber_Solution().largestNumber(nums));
        }
    }
}

// Time sort: 9ms 44.68MB
class LargestNumber_Solution {

    private static final int RUN = 32;

    public String largestNumber(int[] nums) {
        // Convert int array to Integer array for custom sorting
        Integer[] numsArray = Arrays.stream(nums)
            .boxed()
            .toArray(Integer[]::new);
        // Sort the numbers using custom Tim Sort
        timSort(numsArray);
        // Concatenate sorted numbers to form the largest number
        StringBuilder largestNum = new StringBuilder();
        for (int num : numsArray) {
            largestNum.append(num);
        }
        // Handle the case where the largest number is zero
        return largestNum.charAt(0) == '0' ? "0" : largestNum.toString();
    }

    private void insertionSort(Integer[] nums, int left, int right) {
        for (int i = left + 1; i <= right; ++i) {
            int temp = nums[i];
            int j = i - 1;
            while (j >= left && compare(temp, nums[j])) {
                nums[j + 1] = nums[j];
                --j;
            }
            nums[j + 1] = temp;
        }
    }

    private void merge(Integer[] nums, int left, int mid, int right) {
        Integer[] leftArr = Arrays.copyOfRange(nums, left, mid + 1);
        Integer[] rightArr = Arrays.copyOfRange(nums, mid + 1, right + 1);

        int i = 0, j = 0, k = left;
        while (i < leftArr.length && j < rightArr.length) {
            if (compare(leftArr[i], rightArr[j])) {
                nums[k++] = leftArr[i++];
            } else {
                nums[k++] = rightArr[j++];
            }
        }
        while (i < leftArr.length) nums[k++] = leftArr[i++];
        while (j < rightArr.length) nums[k++] = rightArr[j++];
    }

    private void timSort(Integer[] nums) {
        int n = nums.length;
        // Sort small runs with insertion sort
        for (int i = 0; i < n; i += RUN) {
            insertionSort(nums, i, Math.min(i + RUN - 1, n - 1));
        }
        // Merge sorted runs
        for (int size = RUN; size < n; size *= 2) {
            for (int left = 0; left < n; left += 2 * size) {
                int mid = left + size - 1;
                int right = Math.min(left + 2 * size - 1, n - 1);
                if (mid < right) {
                    merge(nums, left, mid, right);
                }
            }
        }
    }

    private boolean compare(int firstNum, int secondNum) {
        String firstStr = Integer.toString(firstNum);
        String secondStr = Integer.toString(secondNum);
        return (firstStr + secondStr).compareTo(secondStr + firstStr) > 0;
    }
}

// Heap sort: 6ms 44.05MB
class LargestNumber_Solution2 {

    public String largestNumber(int[] nums) {
        // Priority queue to order numbers using the custom comparison function
        PriorityQueue<String> maxHeap = new PriorityQueue<>(
            new Comparator<String>() {
                @Override
                public int compare(String first, String second) {
                    return (second + first).compareTo(first + second);
                }
            }
        );

        int totalLength = 0;

        // Convert integers to strings and push them into the priority queue
        for (int num : nums) {
            String strNum = Integer.toString(num);
            totalLength += strNum.length();
            maxHeap.offer(strNum);
        }

        // Build the result string from the priority queue
        StringBuilder result = new StringBuilder(totalLength);
        while (!maxHeap.isEmpty()) {
            result.append(maxHeap.poll());
        }

        // Handle edge case where the result might be "000...0"
        return result.charAt(0) == '0' ? "0" : result.toString();
    }
}

// Merge sort: 6ms 44.56MB
class LargestNumber_Solution3 {

    public String largestNumber(int[] nums) {
        // Sort the numbers using Merge Sort
        List<Integer> sortedNums = mergeSort(nums, 0, nums.length - 1);
        // Concatenate sorted numbers to form the largest number
        StringBuilder largestNum = new StringBuilder();
        for (int num : sortedNums) {
            largestNum.append(num);
        }
        // Handle the case where the largest number is zero
        return largestNum.charAt(0) == '0' ? "0" : largestNum.toString();
    }

    private List<Integer> mergeSort(int[] nums, int left, int right) {
        // Base case: a single element is already sorted
        if (left >= right) return List.of(nums[left]);
        int mid = left + (right - left) / 2;
        // Recursively sort the left and right halves
        List<Integer> leftHalf = mergeSort(nums, left, mid);
        List<Integer> rightHalf = mergeSort(nums, mid + 1, right);
        // Merge the sorted halves
        return merge(leftHalf, rightHalf);
    }

    private List<Integer> merge(
        List<Integer> leftHalf,
        List<Integer> rightHalf
    ) {
        List<Integer> sortedNums = new ArrayList<>();
        int leftIndex = 0, rightIndex = 0;
        // Merge the two halves based on custom comparison
        while (leftIndex < leftHalf.size() && rightIndex < rightHalf.size()) {
            if (compare(leftHalf.get(leftIndex), rightHalf.get(rightIndex))) {
                sortedNums.add(leftHalf.get(leftIndex++));
            } else {
                sortedNums.add(rightHalf.get(rightIndex++));
            }
        }
        // Append remaining elements from left half
        while (leftIndex < leftHalf.size()) sortedNums.add(
            leftHalf.get(leftIndex++)
        );
        // Append remaining elements from right half
        while (rightIndex < rightHalf.size()) sortedNums.add(
            rightHalf.get(rightIndex++)
        );
        return sortedNums;
    }

    private boolean compare(int firstNum, int secondNum) {
        // Compare concatenated strings to decide the order
        String s1 = String.valueOf(firstNum) + String.valueOf(secondNum);
        String s2 = String.valueOf(secondNum) + String.valueOf(firstNum);
        return s1.compareTo(s2) > 0;
    }
}