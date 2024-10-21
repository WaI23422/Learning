package Medium.Array;

import java.util.Arrays;

public class SpiralMatrixIII {
    public static void main(String[] args) {
        int[][] tests = {
            {1,4,0,0}
        };

        for (int[] test : tests) {
            int rows = test[0],
                cols = test[1],
                rStart = test[2],
                cStart = test[3];

            System.out.println(Arrays.deepToString(
                new SpiralMatrixIII_Solution().spiralMatrixIII(rows, cols, rStart, cStart)
            ));
        }
    }
}

// 5ms 44.97MB
class SpiralMatrixIII_Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int num = 1,
            limit = rows*cols+1,
            arr[][] = new int[limit-1][1],
            // [Right][Down][Left][Up]
            dir[] = new int[4];
        // Initial Start:
        Arrays.fill(dir, 1);

        while (num < limit) {
            // Right:
            int end = dir[0];
            for (int i = 0; i < end; i++) {
                if (isExistCoor(rStart, cStart, rows, cols)) {
                    arr[num-1] = new int[]{rStart,cStart};
                    num++;
                }
                cStart++;
            }
            dir[2] = dir[0]+1;

            // Down:
            end = dir[1];
            for (int i = 0; i < end; i++) {
                if (isExistCoor(rStart, cStart, rows, cols)) {
                    arr[num-1] = new int[]{rStart,cStart};
                    num++;
                }
                rStart++;
            }
            dir[3] = dir[1]+1;

            // Left:
            end = dir[2];
            for (int i = 0; i < end; i++) {
                if (isExistCoor(rStart, cStart, rows, cols)) {
                    arr[num-1] = new int[]{rStart,cStart};
                    num++;
                }
                cStart--;
            }
            dir[0] = dir[2]+1;

            // Up:
            end = dir[3];
            for (int i = 0; i < end; i++) {
                if (isExistCoor(rStart, cStart, rows, cols)) {
                    arr[num-1] = new int[]{rStart,cStart};
                    num++;
                }
                rStart--;
            }
            dir[1] = dir[3]+1;
        }

        return arr;
    }

    private boolean isExistCoor(int rStart, int cStart, int rows, int cols) {
        return rStart >= 0 && cStart >= 0 && cStart < cols && rStart < rows;
    }
}
