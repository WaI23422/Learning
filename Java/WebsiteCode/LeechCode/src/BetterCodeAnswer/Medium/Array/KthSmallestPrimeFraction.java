package BetterCodeAnswer.Medium.Array;

public class KthSmallestPrimeFraction {
    public static void main(String[] args) {
        int[][][] tests = {
            {{1,2,3,5},{3}},
            {{1,7},{1}}
        };

        for (int[][] test : tests) {
            int arr[] = test[0],
                k = test[1][0];

            System.out.println(new KthSmallestPrimeFraction_Solution().kthSmallestPrimeFraction(arr, k));
        }
    }
}

// 1 ms 42.3 MB
class KthSmallestPrimeFraction_Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;

        double low = 0;
        double high = 1.0;

        while(low<high)
        {
            double mid = (low+high)/2;
            int res[] = getFractionsLessThanMid(arr, k, n, mid);

            if(res[0] == k) return new int[]{arr[res[1]],arr[res[2]]};
            else if(res[0]>k) high = mid;
            else low = mid;
        }

        return new int[]{};
    }

    private int[] getFractionsLessThanMid(int[] arr, int k, int n, double mid)
    {
        double maxLessThanMid = 0.0;
        int x = 0, y = 0;

        int total = 0;
        int j = 1;

        for(int i=0;i<n-1;i++)
        {
            while(j<n && arr[i]>arr[j]*mid)
            {
                j++;
            }

            if(j==n) break;

            total += (n-j);

            double fraction = (double)arr[i]/arr[j];
            if(fraction > maxLessThanMid)
            {
                maxLessThanMid = fraction;
                x = i;
                y = j;
            }
        }
        return new int[]{total, x ,y};
    }
}

// 19 ms 42.2 MB
class KthSmallestPrimeFraction_Solution2 {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k == 0) {
            return null;
        }

        double left = arr[0] / arr[arr.length - 1];
        double right = 1L; //1.0 is also OK

        while (left <= right) {
            double mid = left + (right - left) / 2;

            int[] countWithPos = findSmallerEqualTo(arr, mid);

            if (countWithPos[0] == k) {
                return new int[] {arr[countWithPos[1]], arr[countWithPos[2]]};
            } else if (countWithPos[0] > k) {
                right = mid;
            } else {
                left = mid;
            }
        }

        return null;
    }

    private int[] findSmallerEqualTo(int[] arr, double mid) {
        int count = 0;
        int maxSmallerNum = 0;
        int maxSmallerDen = arr.length - 1;

        for (int i = 0; i < arr.length; i++) {
            int j = arr.length - 1;

            while (j > i && arr[i] <= arr[j] * mid) {
                count++;
                j--;
            }

            if (j + 1 < arr.length) {
                if (arr[i] * arr[maxSmallerDen] > arr[j + 1] * arr[maxSmallerNum]) {
                    maxSmallerNum = i;
                    maxSmallerDen = j + 1;
                }
            }
            
        }

        return new int[] {count, maxSmallerNum, maxSmallerDen};
    }


}