package BetterCodeAnswer.Medium.Array;

import java.util.Arrays;

public class WidestVerticalAreaBetweenTwoPointsContainingNoPoints {
    public static void main(String[] args){
        int[][][] tests = {
            {{8,7},{9,9},{7,4},{9,7}},
            {{3,1},{9,0},{1,0},{1,4},{5,3},{8,8}}
        };

        for (int[][] points : tests) {
            System.out.println(new WidestVerticalAreaBetweenTwoPointsContainingNoPoints_Solution().maxWidthOfVerticalArea(points));
        }
    }
}

// 38 ms 73 MB
class WidestVerticalAreaBetweenTwoPointsContainingNoPoints_Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, (pA, pB) -> pA[0] - pB[0]);
        int maxDiff = 0;
        for (int idx = 1; idx < points.length; idx++) {
            maxDiff = Math.max(points[idx][0] - points[idx - 1][0], maxDiff);
        }
        return maxDiff;
    }
}