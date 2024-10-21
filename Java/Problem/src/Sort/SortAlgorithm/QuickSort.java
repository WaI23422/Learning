package Sort.SortAlgorithm;

import java.util.Arrays;

import Generated.Number.RandomIntArray;

/**
 * Picks an element as a pivot and partitions the given array around the picked pivot by placing the pivot in its correct position in the sorted array. ( based on the Divide and Conquer algorithm )
 */
public class QuickSort {
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

    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
 
    // This function takes last element as pivot,
    // places the pivot element at its correct position
    // in sorted array, and places all smaller to left
    // of pivot and all greater elements to right of pivot
    static int partition(int[] arr, int low, int high)
    {
        // Choosing the pivot
        int pivot = arr[high];
 
        // Index of smaller element and indicates
        // the right position of pivot found so far
        int i = (low - 1);
 
        for (int j = low; j <= high - 1; j++) {
 
            // If current element is smaller than the pivot
            if (arr[j] < pivot) {
 
                // Increment index of smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }
 
    // The main function that implements QuickSort
    // arr[] --> Array to be sorted,
    // low --> Starting index,
    // high --> Ending index
    static void Sort(int[] arr, int low, int high){
        if (low < high) {
 
            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);
 
            // Separately sort elements before
            // partition and after partition
            Sort(arr, low, pi - 1);
            Sort(arr, pi + 1, high);
        }
    }
}
