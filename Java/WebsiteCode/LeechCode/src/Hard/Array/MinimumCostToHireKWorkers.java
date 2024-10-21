package Hard.Array;

import java.util.Arrays;

public class MinimumCostToHireKWorkers {
    public static void main(String[] args) {
        int[][][] tests = {
            {
                {3,1,10,10,1},
                {4,8,2,2,7},
                {3}
            },
            {
                {10,20,5},
                {70,50,30},
                {2}
            }
        };

        for (int[][] test : tests) {
            int quality[] = test[0],
                wage[] = test[1],
                k = test[2][0];
            
            System.out.println(new MinimumCostToHireKWorkers_Solution().mincostToHireWorkers(quality, wage, k));
        }
    }
}

// Memory Limit Exceeded
class MinimumCostToHireKWorkers_Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        double minCost = Integer.MAX_VALUE,
               contains[][] = new double[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                double frac = ((double) quality[j] / quality[i]);

                contains[i][j] = frac*wage[i];
                
                if (contains[i][j] < wage[j]) {contains[i][j] = Integer.MAX_VALUE ;}
            }
        }

        for (int i = 0; i < n; i++) {
            double cost = findSumKMins(contains[i], k);
            if (cost < minCost) {minCost = cost;}
        }

        return minCost;
    }

    private double findSumKMins(double[] arr, int k) {
        double sum = 0;

        Arrays.sort(arr);

        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        return sum;
    }
}