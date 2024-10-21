package Medium.Array;

public class LargestSubmatrixWithRearrangements {
    public static void main(String[] args) {
        int[][][] tests = {
            {{0,0,1},{1,1,1},{1,0,1}},
            {{1,0,1,0,1}},
            {{1,1,0},{1,0,1}}
        };

        for (int[][] matrix : tests) {
            System.out.println(new LargestSubmatrixWithRearrangements_Solution().largestSubmatrix(matrix));
        }
    }
}

class LargestSubmatrixWithRearrangements_Solution {
    public int largestSubmatrix(int[][] matrix) {
        int Count = 0;

        for (int col = 0; col < matrix[0].length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                if (matrix[row][col] == 1) {Count++;}
            }
        }

        // @see BetterCodeAnswer.Medium.Array.LargestSubmatrixWithRearrangements.java

        return Count;
    }
}