package BetterCodeAnswer.Hard.Array;

import java.util.Arrays;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/minimum-number-of-days-to-disconnect-island/">1568. Minimum Number of Days to Disconnect Island</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You are given an <code>m x n</code> binary grid <code>grid</code> where <code>1</code> represents land and <code>0</code> represents water. An <strong>island</strong> is a maximal <strong>4-directionally</strong> (horizontal or vertical) connected group of <code>1</code>'s.</p>
 * 
 * <p>The grid is said to be <strong>connected</strong> if we have <strong>exactly one island</strong>, otherwise is said <strong>disconnected</strong>.</p>
 * 
 * <p>In one day, we are allowed to change <strong>any </strong>single land cell <code>(1)</code> into a water cell <code>(0)</code>.</p>
 * 
 * <p>Return <em>the minimum number of days to disconnect the grid</em>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/12/24/land1.jpg" style="width: 500px; height: 169px;">
 * <pre><strong>Input:</strong> grid = [[0,1,1,0],[0,1,1,0],[0,0,0,0]]
 * 
 * <strong>Output:</strong> 2
 * <strong>Explanation:</strong> We need at least 2 days to get a disconnected grid.
 * Change land grid[1][1] and grid[0][2] to water and get 2 disconnected island.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/12/24/land2.jpg" style="width: 404px; height: 85px;">
 * <pre><strong>Input:</strong> grid = [[1,1]]
 * <strong>Output:</strong> 2
 * <strong>Explanation:</strong> Grid of full water is also disconnected ([[1,1]] -&gt; [[0,0]]), 0 islands.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>m == grid.length</code></li>
 * 	<li><code>n == grid[i].length</code></li>
 * 	<li><code>1 &lt;= m, n &lt;= 30</code></li>
 * 	<li><code>grid[i][j]</code> is either <code>0</code> or <code>1</code>.</li>
 * </ul>
 * </div>
 */
public class MinimumNumberOfDaysToDisconnectIsland {
    public static void main(String[] args) {
        int[][][] tests = {
            {{0,1,1},{1,1,1},{1,1,0}},
            {{1,1,1,0},{1,1,1,1},{1,0,1,1},{1,1,1,1},{0,1,1,1}},
            {{1,1,0,1,1},{1,1,1,1,1},{1,1,0,1,1},{1,1,1,1,1}},
            {{1,1,1,1,0,1,1,1,1},{1,1,1,1,0,1,1,1,1},{0,0,0,1,0,1,0,0,0},{1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1}},
            {{1,1}},
            {{0,1,1,0},{0,1,1,0},{0,0,0,0}},
        };
    
        for (int[][] grid : tests) {
            for (int[] land  : grid) {
                System.out.println(Arrays.toString(land));
            }
            System.out.println(new MinimumNumberOfDaysToDisconnectIsland_Solution().minDays(grid));
        }
    }
}

// 41ms 45.07MB
class MinimumNumberOfDaysToDisconnectIsland_Solution {

    // Directions for adjacent cells: right, left, down, up
    private static final int[][] DIRECTIONS = {
        { 0, 1 },
        { 0, -1 },
        { 1, 0 },
        { -1, 0 },
    };

    public int minDays(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Count initial islands
        int initialIslandCount = countIslands(grid);

        // Already disconnected or no land
        if (initialIslandCount != 1) {
            return 0;
        }

        // Try removing each land cell
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 0) continue; // Skip water

                // Temporarily change to water
                grid[row][col] = 0;
                int newIslandCount = countIslands(grid);

                // Check if disconnected
                if (newIslandCount != 1) return 1;

                // Revert change
                grid[row][col] = 1;
            }
        }

        return 2;
    }

    private int countIslands(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int islandCount = 0;

        // Iterate through all cells
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                // Found new island
                if (!visited[row][col] && grid[row][col] == 1) {
                    exploreIsland(grid, row, col, visited);
                    islandCount++;
                }
            }
        }
        return islandCount;
    }

    // Helper method to explore all cells of an island
    private void exploreIsland(
        int[][] grid,
        int row,
        int col,
        boolean[][] visited
    ) {
        visited[row][col] = true;

        // Check all adjacent cells
        for (int[] direction : DIRECTIONS) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            // Explore if valid land cell
            if (isValidLandCell(grid, newRow, newCol, visited)) {
                exploreIsland(grid, newRow, newCol, visited);
            }
        }
    }

    private boolean isValidLandCell(
        int[][] grid,
        int row,
        int col,
        boolean[][] visited
    ) {
        int rows = grid.length;
        int cols = grid[0].length;
        // Check bounds, land, and not visited
        return (
            row >= 0 &&
            col >= 0 &&
            row < rows &&
            col < cols &&
            grid[row][col] == 1 &&
            !visited[row][col]
        );
    }
}

//2ms 42.04MB
class MinimumNumberOfDaysToDisconnectIsland_Solution2 {

    // Directions for adjacent cells: right, down, left, up
    private static final int[][] DIRECTIONS = {
        { 0, 1 },
        { 1, 0 },
        { 0, -1 },
        { -1, 0 },
    };

    public int minDays(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        ArticulationPointInfo apInfo = new ArticulationPointInfo(false, 0);
        int landCells = 0, islandCount = 0;

        // Arrays to store information for each cell
        int[][] discoveryTime = new int[rows][cols]; // Time when a cell is first discovered
        int[][] lowestReachable = new int[rows][cols]; // Lowest discovery time reachable from the subtree rooted at
        // this cell
        int[][] parentCell = new int[rows][cols]; // Parent of each cell in DFS tree

        // Initialize arrays with default values
        for (int i = 0; i < rows; i++) {
            Arrays.fill(discoveryTime[i], -1);
            Arrays.fill(lowestReachable[i], -1);
            Arrays.fill(parentCell[i], -1);
        }

        // Traverse the grid to find islands and articulation points
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    landCells++;
                    if (discoveryTime[i][j] == -1) { // If not yet visited
                        // Start DFS for a new island
                        findArticulationPoints(
                            grid,
                            i,
                            j,
                            discoveryTime,
                            lowestReachable,
                            parentCell,
                            apInfo
                        );
                        islandCount++;
                    }
                }
            }
        }

        // Determine the minimum number of days to disconnect the grid
        if (islandCount == 0 || islandCount >= 2) return 0; // Already disconnected or no land
        if (landCells == 1) return 1; // Only one land cell
        if (apInfo.hasArticulationPoint) return 1; // An articulation point exists
        return 2; // Need to remove any two land cells
    }

    private void findArticulationPoints(
        int[][] grid,
        int row,
        int col,
        int[][] discoveryTime,
        int[][] lowestReachable,
        int[][] parentCell,
        ArticulationPointInfo apInfo
    ) {
        int cols = grid[0].length;
        discoveryTime[row][col] = apInfo.time;
        apInfo.time++;
        lowestReachable[row][col] = discoveryTime[row][col];
        int children = 0;

        // Explore all adjacent cells
        for (int[] direction : DIRECTIONS) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if (isValidLandCell(grid, newRow, newCol)) {
                if (discoveryTime[newRow][newCol] == -1) {
                    children++;
                    parentCell[newRow][newCol] = row * cols + col; // Set parent
                    findArticulationPoints(
                        grid,
                        newRow,
                        newCol,
                        discoveryTime,
                        lowestReachable,
                        parentCell,
                        apInfo
                    );

                    // Update lowest reachable time
                    lowestReachable[row][col] = Math.min(
                        lowestReachable[row][col],
                        lowestReachable[newRow][newCol]
                    );

                    // Check for articulation point condition
                    if (
                        lowestReachable[newRow][newCol] >=
                            discoveryTime[row][col] &&
                        parentCell[row][col] != -1
                    ) {
                        apInfo.hasArticulationPoint = true;
                    }
                } else if (newRow * cols + newCol != parentCell[row][col]) {
                    // Update lowest reachable time for back edge
                    lowestReachable[row][col] = Math.min(
                        lowestReachable[row][col],
                        discoveryTime[newRow][newCol]
                    );
                }
            }
        }

        // Root of DFS tree is an articulation point if it has more than one child
        if (parentCell[row][col] == -1 && children > 1) {
            apInfo.hasArticulationPoint = true;
        }
    }

    // Check if the given cell is a valid land cell
    private boolean isValidLandCell(int[][] grid, int row, int col) {
        int rows = grid.length, cols = grid[0].length;
        return (
            row >= 0 &&
            col >= 0 &&
            row < rows &&
            col < cols &&
            grid[row][col] == 1
        );
    }

    private class ArticulationPointInfo {

        boolean hasArticulationPoint;
        int time;

        ArticulationPointInfo(boolean hasArticulationPoint, int time) {
            this.hasArticulationPoint = hasArticulationPoint;
            this.time = time;
        }
    }
}

//1ms 42.04MB
class MinimumNumberOfDaysToDisconnectIsland_Solution3 {
    int time;
    int[][] vis;
    int[][] low;
    int[] d=new int[]{0,1,0,-1,0};
    boolean arti;
    public int minDays(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        arti=false;
        vis=new int[n][m];
        low=new int[n][m];
        time=1;
        boolean found=false;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    if(found)
                        return 0;
                    found=true;
                    art(i,j,grid,-1,-1);
                }
            }
        }

        if(time==1)
            return 0;

        if(time==2)
            return 1;
        if(arti)
            return 1;
        else
            return 2;
    }

    public void art(int row,int col,int[][] grid , int parRow,int parCol){
        grid[row][col]=0;
        vis[row][col]=time;
        low[row][col]=time;
        time++;
        int child=0;
        for(int i=0;i<4;i++){
            int x=d[i]+row;
            int y=d[i+1]+col;

            if(x<0 || y<0 || x>=grid.length || y>=grid[0].length || (x==parRow && y==parCol) || (vis[x][y]==0 && grid[x][y]==0))
                continue;
            if(vis[x][y]==0){
                child++;
                art(x,y,grid,row,col);
                low[row][col]=Math.min(low[row][col],low[x][y]);
                if(low[x][y]>=vis[row][col] && (parRow!=-1 && parCol!=-1))
                    arti=true;
            }else{
                low[row][col]=Math.min(low[row][col],vis[x][y]);
            }
        }

        if(parRow==-1 && parCol==-1 && child>1)
            arti=true;
    }
}