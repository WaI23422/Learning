package Medium.Array;

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

// 14 ms 73 MB
class WidestVerticalAreaBetweenTwoPointsContainingNoPoints_Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int max = Integer.MIN_VALUE;
        int[] witdhCoor = new int[points.length];

        for (int i = 0; i < points.length; i++) {
            witdhCoor[i] = points[i][0];
        }

        Arrays.sort(witdhCoor);
        
        for (int i = 1; i < witdhCoor.length; i++) {
            // if (witdhCoor[i] - witdhCoor[i-1] > max) {
                // max = witdhCoor[i]-witdhCoor[i-1];
            // }
            max = Math.max(witdhCoor[i]-witdhCoor[i-1], max); // -> 13 ms 73.2 MB
        }

        return max;
    }
}