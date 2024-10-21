package Easy.Arrays;

public class SpecialArrayWithXElementsGreaterThanOrEqualX {
    public static void main(String[] args) {
        int[][] tests = {
            {3,5}
        };

        for (int[] nums : tests) {
            System.out.println(new SpecialArrayWithXElementsGreaterThanOrEqualX_Solution().specialArray(nums));
        }
    }
}

// 0 ms 41.2 MB
class SpecialArrayWithXElementsGreaterThanOrEqualX_Solution {
    public int specialArray(int[] nums) {
        int n = nums.length;
        
        Sort(nums,0,n-1);
        
        for (int i = 0; i < n; i++) {
            if (n == 0) {continue;}
            if (n-i <= nums[i] && (i-1<0 || nums[i - 1] < n-i)) {
                return n-i;
            }
        }
        
        return -1;
    }

    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int partition(int[] arr, int low, int high){
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

    static void Sort(int[] arr, int low, int high){
        if (low < high) {
            int pi = partition(arr, low, high);
 
            Sort(arr, low, pi - 1);
            Sort(arr, pi + 1, high);
        }
    }
}

// 1 ms 41.4 MB
class SpecialArrayWithXElementsGreaterThanOrEqualX_Solution1 {
    public int specialArray(int[] nums) {
        int[] bucket = new int[1001];
        for (int num : nums) {
            bucket[num]++;
        }
        int total = nums.length;
        for (int i = 0; i < 1001; i++) {
            if (i == total) {
                return i;
            }
            total -= bucket[i];
        }
        return -1;
    }
}