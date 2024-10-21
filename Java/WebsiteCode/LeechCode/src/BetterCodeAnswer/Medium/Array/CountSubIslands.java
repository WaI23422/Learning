package BetterCodeAnswer.Medium.Array;

public class CountSubIslands {
    public static void main(String[] args) {
        int[][][][] tests = {
            {
                {{1,1,1,0,0},{0,1,1,1,1},{0,0,0,0,0},{1,0,0,0,0},{1,1,0,1,1}}, 
                {{1,1,1,0,0},{0,0,1,1,1},{0,1,0,0,0},{1,0,1,1,0},{0,1,0,1,0}}
            }
        };

        for (int[][][] test : tests) {
            int[][] grid1 = test[0],
                    grid2 = test[1];

            System.out.println(new CountSubIslands_Solution().countSubIslands(grid1, grid2));
        }
    }
}

// 12ms 67.9MB
class CountSubIslands_Solution {

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length;
        int n = grid1[0].length;
        int size = m * n;

        // Initializes union-find structures.
        int[] parents = new int[size];
        for (int x = 1; x < size; x++) {
            parents[x] = x;
        }
        int[] ranks = new int[size];
        int[] areSubislandRoots = new int[size];

        // Process the corner cell.
        int[] firstGridRow1 = grid1[0];
        int[] firstGridRow2 = grid2[0];
        int cornerCell2 = firstGridRow2[0];
        areSubislandRoots[0] = cornerCell2 & firstGridRow1[0];

        // Process the remaining cells in the first row.
        int x = 1;
        int prevCell2 = cornerCell2;
        for (int col = 1; col < n; col++) {
            int cell2 = firstGridRow2[col];
            if (cell2 != 0) {
                areSubislandRoots[x] = firstGridRow1[col];
                if (prevCell2 != 0) {
                    union(x, x - 1, parents, ranks, areSubislandRoots);
                }
            }
            prevCell2 = cell2;
            x++;
        }

        // Process the remaining cells in the first column.
        x = n;
        prevCell2 = cornerCell2;
        for (int row = 1; row < m; row++) {
            int cell2 = grid2[row][0];
            if (cell2 != 0) {
                areSubislandRoots[x] = grid1[row][0];
                if (prevCell2 != 0) {
                    union(x, x - n, parents, ranks, areSubislandRoots);
                }
            }
            prevCell2 = cell2;
            x += n;
        }

        // Process the remaining cells.
        x = n + 1;
        int[] prevGridRow2 = firstGridRow2;
        for (int row = 1; row < m; row++) {
            int[] gridRow1 = grid1[row];
            int[] gridRow2 = grid2[row];
            prevCell2 = gridRow2[0];
            for (int col = 1; col < n; col++) {
                int cell = gridRow2[col];
                if (cell != 0) {
                    areSubislandRoots[x] = gridRow1[col];
                    if (prevCell2 != 0) {
                        union(x, x - 1, parents, ranks, areSubislandRoots);
                    }
                    if (prevGridRow2[col] != 0) {
                        union(x, x - n, parents, ranks, areSubislandRoots);
                    }
                }
                prevCell2 = cell;
                x++;
            }
            prevGridRow2 = gridRow2;
            x++;
        }

        // Count the subislands.
        int numSubislands = 0;
        for (int isSubislandRoot : areSubislandRoots) {
            numSubislands += isSubislandRoot;
        }
        return numSubislands;
    }

    private static void union(int x, int y, int[] parents, int[] ranks, int[] areSubislandRoots) {
        // Find the roots of x and y.
        int xParent = parents[x];
        while (x != xParent) {
            x = xParent;
            xParent = parents[x];
        }
        int yParent = parents[y];
        while (y != yParent) {
            y = yParent;
            yParent = parents[y];
        }

        // Stop if the roots are already the same.
        if (x == y) {
            return;
        }

        // Merge the two roots.
        int rankCmp = ranks[y] - ranks[x];
        int isSubislandRoot = areSubislandRoots[x] & areSubislandRoots[y];
        if (rankCmp > 0) {
            parents[x] = y;
            areSubislandRoots[x] = 0;
            areSubislandRoots[y] = isSubislandRoot;
        } else {
            parents[y] = x;
            areSubislandRoots[y] = 0;
            areSubislandRoots[x] = isSubislandRoot;
            ranks[x] += ~rankCmp >>> 31; // 1 if rankCmp == 0, 0 if rankCmp < 0
        }
    }
}