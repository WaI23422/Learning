package Medium.Array;

import java.util.Arrays;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/sort-an-array/">912. Sort an Array</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given an array of integers <code>nums</code>, sort the array in ascending order and return it.</p>
 * 
 * <p>You must solve the problem <strong>without using any built-in</strong> functions in <code>O(nlog(n))</code> time complexity and with the smallest space complexity possible.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [5,2,3,1]
 * <strong>Output:</strong> [1,2,3,5]
 * <strong>Explanation:</strong> After sorting the array, the positions of some numbers are not changed (for example, 2 and 3), while the positions of other numbers are changed (for example, 1 and 5).
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [5,1,1,2,0,0]
 * <strong>Output:</strong> [0,0,1,1,2,5]
 * <strong>Explanation:</strong> Note that the values of nums are not necessairly unique.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= nums.length &lt;= 5 * 10<sup>4</sup></code></li>
 * 	<li><code>-5 * 10<sup>4</sup> &lt;= nums[i] &lt;= 5 * 10<sup>4</sup></code></li>
 * </ul>
 * </div>
 */
public class SortAnArray {
    public static void main(String[] args) {
        int[][] tests = {
            {5,2,3,1}
        };
        
        for (int[] nums : tests) {
            System.out.println(new SortAnArray_Solution().sortArray(nums));
        }
    }
}

class SortAnArray_Solution {
    public int[] sortArray(int[] nums) {
        // Java sort
        Arrays.sort(nums); // 17ms 55.46MB
        sortDir(nums); // Time Limit Exceeded
        quickSort(nums, 0, nums.length-1); // Time Limit Exceeded
        mergeSort(nums, 0, nums.length-1);  // 29ms 56.12MB
        heapSort(nums); // 37ms 55.40MB
        radixSort(nums, nums.length-1); // Error for negative

        return nums;
    }

    static int getMax(int arr[], int n){
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }

    static void countSort(int arr[], int n, int exp){
        int output[] = new int[n]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);

        for (i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;

        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }

    static void radixSort(int arr[], int n){
        int m = getMax(arr, n);

        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }

    public static void heapSort(int arr[]){
        int N = arr.length;

        for (int i = N / 2 - 1; i >= 0; i--)
            heapify(arr, N, i);
 
        for (int i = N - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
 
            heapify(arr, i, 0);
        }
    }

    static void heapify(int arr[], int N, int i){
        int largest = i; 
        int l = 2 * i + 1; 
        int r = 2 * i + 2; 
 
        if (l < N && arr[l] > arr[largest])
            largest = l;
 
        if (r < N && arr[r] > arr[largest])
            largest = r;
 
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
 
            heapify(arr, N, largest);
        }
    }

    static void merge(int arr[], int l, int m, int r){
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];
 
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0;
 
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
 
    public static void mergeSort(int arr[], int l, int r){
        if (l < r) {
            int m = l + (r - l) / 2;
 
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }

    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);

            quickSort(arr, low, pivot-1);
            quickSort(arr, pivot+1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
 
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    public void sortDir(int[] arr) {
        while (true) {
            int track = 0;

            for (int i = 1; i < arr.length; i++) {
                if (arr[i-1] > arr[i]) {
                    swap(arr,i-1,i);

                    track++;
                }
            }

            if (track == 0) {
                break;
            }
        }
    }

    public void swap(int[] arr, int pos_1, int pos_2) {
        int temp = arr[pos_1];
        arr[pos_1] = arr[pos_2];
        arr[pos_2] = temp;
    }
}