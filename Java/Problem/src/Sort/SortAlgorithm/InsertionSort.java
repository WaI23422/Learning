package Sort.SortAlgorithm;

import java.util.Arrays;

import Generated.Number.RandomIntArray;

/**
 * To sort an array of size N in ascending order iterate over the array and compare the current element (key) to its predecessor, if the key element is smaller than its predecessor, compare it to the elements before. Move the greater elements one position up to make space for the swapped element.
 */
public class InsertionSort {
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
    static void ascending(int arr[]){
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    static void decreasing(int arr[]){
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
 
            while (j >= 0 && arr[j] < key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

}
