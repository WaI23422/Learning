package Searching;

public class BinarySearch {
    public static int search(int[] arr, int target) {
        int left = 0, right = arr.length-1, mid;

        while (left <= right) {
            mid = left + (right - left)/2; // Avoid Overflow.
            
            if (arr[mid] == target) {return mid;}
            else if (arr[mid] < target) {left = mid +1;}
            else {right = mid -1;}
        }

        return -1;

    }
}
