package Sort.SortAlgorithm;

import java.util.Arrays;

import Generated.Number.RandomIntArray;

/**
 * <ul>
 *  <li> Traverse from left and compare adjacent elements and the higher one is placed at right side. 
 *  <li> In this way, the largest element is moved to the rightmost end at first. 
 *  <li> This process is then continued to find the second largest and place it and so on until the data is sorted.
 * </ul>
 */
public class BubbleSort {
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
            ascending(arr);
            System.out.println(Arrays.toString(arr));
        }
    }

    // Time Complexity: O(n^2)
    static void ascending(int arr[]){
        int len = arr.length;
        int i, j;
        boolean swapped;
        for (i = 0; i < len - 1; i++) {
            swapped = false;
            for (j = 0; j < len - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                     
                    // Swap arr[j] and arr[j+1]
                    arr[j] = arr[j] + arr[j + 1];
                    arr[j + 1] = arr[j] - arr[j+1];
                    arr[j] = arr[j] - arr[j+1];
                    swapped = true;
                }
            }
 
            if (swapped == false)
                break;
        }
    }

    static void decreasing(int arr[]){
        int len = arr.length;
        int i, j;
        boolean swapped;
        for (i = 0; i < len - 1; i++) {
            swapped = false;
            for (j = 0; j < len - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                     
                    // Swap arr[j] and arr[j+1]
                    arr[j] = arr[j] + arr[j + 1];
                    arr[j + 1] = arr[j] - arr[j+1];
                    arr[j] = arr[j] - arr[j+1];
                    swapped = true;
                }
            }
 
            if (swapped == false)
                break;
        }
    }
}

