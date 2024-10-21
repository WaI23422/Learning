package Sort.SortAlgorithm;

import java.util.Arrays;

import Generated.Number.RandomIntArray;

/**
 * Dividing an array into smaller subarrays, sorting each subarray, and then merging the sorted subarrays back together to form the final sorted array.
 */
public class MergeSort {
    public static void main(String[] args) {
         int[][] test = {
            {}, // Empty List
            {0}, // Single List
            {0,0,0}, // Identical List
            {9,8,7,6,5,4,3,2,1}, // Reverse List
            {1,3,2,4,5,6,7}, // Chaos List
            RandomIntArray.Range(0, 2000, 2000) // Large List @see Generated\NumberRange\RandomIntArray.java
        };  

        for (int[] arr : test) {
            Sort(arr,0,arr.length-1);
            System.out.println(Arrays.toString(arr));
        }
    }

    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    static void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
 
        // Create temp arrays
        int L[] = new int[n1];
        int R[] = new int[n2];
 
        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
 
        // Merge the temp arrays
 
        // Initial indices of first and second subarrays
        int i = 0, j = 0;
 
        // Initial index of merged subarray array
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
 
        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
 
    // Main function that sorts arr[l..r] using
    // merge()
    public static void Sort(int arr[], int l, int r){
        if (l < r) {
 
            // Find the middle point
            int m = l + (r - l) / 2;
 
            // Sort first and second halves
            Sort(arr, l, m);
            Sort(arr, m + 1, r);
 
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
}
