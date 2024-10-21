package Sort.SortAlgorithm;

import java.util.Arrays;

import Generated.Number.RandomIntArray;

/**
 * Repeatedly selecting the smallest (or largest) element from the unsorted portion of the list and moving it to the sorted portion of the list. 
 */
public class SelectionSort {
    // Test run
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
            decreasing(arr);
            System.out.println(Arrays.toString(arr));
        }
    }

    // Time Complexity: O(n^2)
    static void ascending(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            
            int min_index = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[min_index]) {
                    min_index = j;
                }
            }

            // Swap minimum number at index j to index i: 
            int hold = arr[min_index];
            arr[min_index] = arr[i];
            arr[i] = hold;
        }
    }

    static void decreasing(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            
            int min_index = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] > arr[min_index]) {
                    min_index = j;
                }
            }

            // Swap minimum number at index j to index i: 
            int hold = arr[min_index];
            arr[min_index] = arr[i];
            arr[i] = hold;
        }
    }
}

