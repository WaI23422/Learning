package Hard.Array;

public class MaximumProfitInJobScheduling {
    public static void main(String[] args) {
        int[][][] tests = {
            {{1,2,3,3},{3,4,5,6},{50,10,40,70}},
            {{1,2,3,4,6},{3,5,10,6,9},{20,20,100,70,60}},
            {{1,1,1},{2,3,4},{5,6,4}},
        };

        for (int[][] test : tests) {
            int[] startTime = test[0], endTime = test[1], profit = test[2];

            System.out.println(new MaximumProfitInJobScheduling_Solution().jobScheduling(startTime, endTime, profit));
        }
    }
}

// Brute-Force - Time Limit Exceeded
class MaximumProfitInJobScheduling_Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < startTime.length; i++) {
            max = Math.max(max, workAt(startTime, endTime[i], endTime, profit, profit[i]));
        }

        return max;
    }

    public int workAt(int[] startTime, int startWork,int[] endTime, int[] profit, int totalProfit) {
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < startTime.length; i++) {
            if (startWork <= startTime[i]) {
                max = Math.max(max, workAt(startTime, endTime[i], endTime, profit, totalProfit + profit[i]));
            }
        }

        return Math.max(totalProfit, max) ;
    }
}
