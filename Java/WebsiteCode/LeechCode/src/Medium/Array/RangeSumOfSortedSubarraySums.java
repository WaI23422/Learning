package Medium.Array;

public class RangeSumOfSortedSubarraySums {
    public static void main(String[] args) {
        int[][][] tests = {
            {
                {1,2,3,4},
                {4},
                {3},
                {4}
            }
        };

        for (int[][] test : tests) {
            int nums[] = test[0],
                n = test[1][0],
                left = test[2][0],
                right = test[3][0];

            System.out.println(new RangeSumOfSortedSubarraySums_Solution().rangeSum(nums, n, left, right));
        }
    }
}

// Brute-Force: 124ms 50.61MB -> 65ms 46.22MB
class RangeSumOfSortedSubarraySums_Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int size =  (n*(n+1))/2,
            sum_arr[] = new int[size];
        final int mod = 1_000_000_007;
        double total_sum = 0;

        // sum_arr[0] = nums[0];
        // for (int i = 1; i < n; i++) {
        //     sum_arr[i] = sum_arr[i-1] + nums[i];
        // }

        // int j = 1, k = 1,
        //     track = 2*n-1;
        // for (int i = n; i < sum_arr.length; i++) {
        //     if (i == track) {
        //         j++; k++;
        //         track += n-k;
        //     }
        //     sum_arr[i] = sum_arr[i-n+k] - nums[j-1];
        // }

        // Fix: 
        for (int i = 0, k = 0; i < n; ++i) {
            int s = 0;
            for (int j = i; j < n; ++j) {
                s += nums[j];
                sum_arr[k++] = s;
            }
        }

        mergeSort(sum_arr, 0, size-1);
        for (int i = left-1; i < right; i++) {
            total_sum += sum_arr[i];
        }
        
        return (int) (total_sum%mod);
    }

    static void merge(int arr[], int l, int m, int r){
        int n1 = m - l + 1;
        int n2 = r - m;
 
        int L[] = new int[n1];
        int R[] = new int[n2];
 
        for (int i = 0; i < n1; ++i) {L[i] = arr[l + i];}
        for (int j = 0; j < n2; ++j) {R[j] = arr[m + 1 + j];}

        int i = 0, j = 0, k = l;
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
}