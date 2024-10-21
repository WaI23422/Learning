package BetterCodeAnswer.Medium.Array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/regions-cut-by-slashes/">959. Regions Cut By Slashes</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>An <code>n x n</code> grid is composed of <code>1 x 1</code> squares where each <code>1 x 1</code> square consists of a <code>'/'</code>, <code>'\'</code>, or blank space <code>' '</code>. These characters divide the square into contiguous regions.</p>
 * 
 * <p>Given the grid <code>grid</code> represented as a string array, return <em>the number of regions</em>.</p>
 * 
 * <p>Note that backslash characters are escaped, so a <code>'\'</code> is represented as <code>'\\'</code>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2018/12/15/1.png" style="width: 200px; height: 200px;">
 * <pre><strong>Input:</strong> grid = [" /","/ "]
 * <strong>Output:</strong> 2
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2018/12/15/2.png" style="width: 200px; height: 198px;">
 * <pre><strong>Input:</strong> grid = [" /","  "]
 * <strong>Output:</strong> 1
 * </pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2018/12/15/4.png" style="width: 200px; height: 200px;">
 * <pre><strong>Input:</strong> grid = ["/\\","\\/"]
 * <strong>Output:</strong> 5
 * <strong>Explanation: </strong>Recall that because \ characters are escaped, "\\/" refers to \/, and "/\\" refers to /\.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>n == grid.length == grid[i].length</code></li>
 * 	<li><code>1 &lt;= n &lt;= 30</code></li>
 * 	<li><code>grid[i][j]</code> is either <code>'/'</code>, <code>'\'</code>, or <code>' '</code>.</li>
 * </ul>
 * </div>
 */
public class RegionsCutBySlashes {
    public static void main(String[] args) {
        String[][] tests = {
            {
                " /","/ "
            }
        };

        for (String[] grid : tests) {
            System.out.println(new RegionsCutBySlashes_Solution().regionsBySlashes(grid));
        }
    }
}

// 13ms 44.55MB
/**
 * <h3 id="approach-1-expanded-grid" level="3" class="group/heading relative"><a href="#approach-1-expanded-grid" class="!text-sd-muted-foreground absolute right-full top-1/2 -translate-y-1/2 cursor-pointer pr-0.5 text-xs opacity-0 group-hover/heading:opacity-100" aria-hidden="true" tabindex="-1"><div class="relative text-[12px] leading-[normal] p-[1px] before:block before:h-3 before:w-3"><svg aria-hidden="true" focusable="false" data-prefix="fas" data-icon="link" class="svg-inline--fa fa-link absolute left-1/2 top-1/2 -translate-x-1/2 -translate-y-1/2" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 640 512" spacing="square"><path fill="currentColor" d="M579.8 267.7c56.5-56.5 56.5-148 0-204.5c-50-50-128.8-56.5-186.3-15.4l-1.6 1.1c-14.4 10.3-17.7 30.3-7.4 44.6s30.3 17.7 44.6 7.4l1.6-1.1c32.1-22.9 76-19.3 103.8 8.6c31.5 31.5 31.5 82.5 0 114L422.3 334.8c-31.5 31.5-82.5 31.5-114 0c-27.9-27.9-31.5-71.8-8.6-103.8l1.1-1.6c10.3-14.4 6.9-34.4-7.4-44.6s-34.4-6.9-44.6 7.4l-1.1 1.6C206.5 251.2 213 330 263 380c56.5 56.5 148 56.5 204.5 0L579.8 267.7zM60.2 244.3c-56.5 56.5-56.5 148 0 204.5c50 50 128.8 56.5 186.3 15.4l1.6-1.1c14.4-10.3 17.7-30.3 7.4-44.6s-30.3-17.7-44.6-7.4l-1.6 1.1c-32.1 22.9-76 19.3-103.8-8.6C74 372 74 321 105.5 289.5L217.7 177.2c31.5-31.5 82.5-31.5 114 0c27.9 27.9 31.5 71.8 8.6 103.9l-1.1 1.6c-10.3 14.4-6.9 34.4 7.4 44.6s34.4 6.9 44.6-7.4l1.1-1.6C433.5 260.8 427 182 377 132c-56.5-56.5-148-56.5-204.5 0L60.2 244.3z"></path></svg></div></a>Approach 1: Expanded Grid</h3>
 * <h4 id="intuition">Intuition</h4>
 * <p>When a cell in the grid contains a slash, it effectively divides it into two parts. A forward slash divides the cell into top-left and bottom-right sections, while a backslash divides it into top-right and bottom-left sections. As you can see in Example 1 of the problem, counting the regions directly is challenging since a divided cell does not always lead to an additional region.</p>
 * <p>To address this, we can magnify the grid by expanding each cell into a <span class="math math-inline"><span class="katex"><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.7278em; vertical-align: -0.0833em;"></span><span class="mord">3</span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mbin">×</span><span class="mspace" style="margin-right: 0.2222em;"></span></span><span class="base"><span class="strut" style="height: 0.6444em;"></span><span class="mord">3</span></span></span></span></span> sub-grid, with slashes represented by diagonal cells marked as barriers:</p>
 * <p><img src="../Figures/959/expanded_grid.png" alt=""></p>
 * <p>This transformation simplifies our task. If we treat the slashes and grid boundaries as water, and the remaining cells as land, the problem becomes analogous to the <a href="https://leetcode.com/problems/number-of-islands/description/" target="_blank">Number of Islands</a>.</p>
 * <p>We can solve this using the <a href="https://en.wikipedia.org/wiki/Flood_fill" target="_blank">flood-fill algorithm</a> to visit each connected region in the grid. We iterate over each cell of the grid and invoke <code>floodfill</code> whenever we encounter an unvisited land cell. The <code>floodfill</code> function explores all reachable land cells from the current cell and marks them as visited.  Then, we continue to iterate over each cell in the grid until we reach the next unvisited cell, which signifies the next land region. The total number of <code>floodfill</code> calls corresponds to the number of regions in the grid, which is our desired answer.</p>
 * <blockquote>
 * <p>Note: In our implementation, we use Breadth-First Search (BFS) for the flood-fill algorithm. Alternatively, Depth-First Search (DFS) can also be employed, yielding similar time and space complexities.</p>
 * </blockquote>
 * <h4 id="algorithm">Algorithm</h4>
 * <ul>
 * <li>Initialize an array <code>DIRECTIONS</code> to specify traversal directions: right, left, down, and up.</li>
 * </ul>
 * <p>Main method <code>regionsBySlashes</code>:</p>
 * <ul>
 * <li>Set <code>gridSize</code> as the size of the original grid.</li>
 * <li>Create a new 2D array <code>expandedGrid</code> with dimensions three times the original grid size.</li>
 * <li>Iterate through each cell <code>(i, j)</code> in the original <code>grid</code>:
 * <ul>
 * <li>Calculate <code>baseRow</code> and <code>baseCol</code> as three times of <code>i</code> and <code>j</code>.</li>
 * <li>Check the character in the current cell:
 * <ul>
 * <li>If it is a backslash (<code>\\</code>):
 * <ul>
 * <li>Mark the cells in the main diagonal <code>(baseRow, baseCol)</code>, <code>(baseRow+1, baseCol+1)</code>, <code>(baseRow+2, baseCol+2)</code> as <code>1</code>.</li>
 * </ul>
 * </li>
 * <li>If it is a forward slash (<code>/</code>):
 * <ul>
 * <li>Mark the other diagonal <code>(baseRow, baseCol+2)</code>, <code>(baseRow+1, baseCol+1)</code>, <code>(baseRow+2, baseCol)</code> as <code>1</code>.</li>
 * </ul>
 * </li>
 * </ul>
 * </li>
 * </ul>
 * </li>
 * <li>Initialize a counter <code>regionCount</code> to <code>0</code>.</li>
 * <li>Iterate through each cell <code>(i, j)</code> in <code>expandedGrid</code>:
 * <ul>
 * <li>If the cell is unvisited (value <code>0</code>):
 * <ul>
 * <li>Call the <code>floodfill</code> method to fill the region.</li>
 * <li>Increment <code>regionCount</code>.</li>
 * </ul>
 * </li>
 * </ul>
 * </li>
 * <li>Return <code>regionCount</code> as the total number of distinct regions.</li>
 * </ul>
 * <p>Helper method <code>floodfill</code>:</p>
 * <ul>
 * <li>Define a method <code>floodfill</code> with parameters: <code>expandedGrid</code> and the <code>row</code> and <code>col</code> indices.</li>
 * <li>Initialize a queue and add the starting cell <code>(row, col)</code> to it.</li>
 * <li>Mark the starting cell as visited by setting <code>expandedGrid[row][col]</code> to <code>1</code>.</li>
 * <li>While the <code>queue</code> is not empty:
 * <ul>
 * <li>Dequeue <code>currentCell</code>.</li>
 * <li>For each <code>direction</code> in <code>DIRECTIONS</code>:
 * <ul>
 * <li>Set <code>newRow</code> as <code>currentCell[0] + direction[0]</code>.</li>
 * <li>Set <code>newCol</code> as <code>currentCell[1] + direction[1]</code>.</li>
 * <li>Check if the new cell is valid and unvisited using the <code>isValidCell</code> method:
 * <ul>
 * <li>If valid, mark the cell as visited and add it to the <code>queue</code>.</li>
 * </ul>
 * </li>
 * </ul>
 * </li>
 * </ul>
 * </li>
 * </ul>
 * <p>Helper method <code>isValidCell</code>.</p>
 * <ul>
 * <li>Define a method <code>isValidCell</code> with parameters: <code>expandedGrid</code>, <code>row</code>, and <code>col</code>.</li>
 * <li>Return <code>true</code> if the cell <code>(row, col)</code> is within bounds and unvisited.</li>
 * <li>Otherwise, return <code>false</code>.</li>
 * </ul>
 */
class RegionsCutBySlashes_Solution {

    // Directions for traversal: right, left, down, up
    private static final int[][] DIRECTIONS = {
        { 0, 1 },
        { 0, -1 },
        { 1, 0 },
        { -1, 0 },
    };

    public int regionsBySlashes(String[] grid) {
        int gridSize = grid.length;
        // Create a 3x3 matrix for each cell in the original grid
        int[][] expandedGrid = new int[gridSize * 3][gridSize * 3];

        // Populate the expanded grid based on the original grid
        // 1 represents a barrier in the expanded grid
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                int baseRow = i * 3;
                int baseCol = j * 3;
                // Check the character in the original grid
                if (grid[i].charAt(j) == '\\') {
                    // Mark diagonal for backslash
                    expandedGrid[baseRow][baseCol] = 1;
                    expandedGrid[baseRow + 1][baseCol + 1] = 1;
                    expandedGrid[baseRow + 2][baseCol + 2] = 1;
                } else if (grid[i].charAt(j) == '/') {
                    // Mark diagonal for forward slash
                    expandedGrid[baseRow][baseCol + 2] = 1;
                    expandedGrid[baseRow + 1][baseCol + 1] = 1;
                    expandedGrid[baseRow + 2][baseCol] = 1;
                }
            }
        }

        int regionCount = 0;
        // Count regions using flood fill
        for (int i = 0; i < gridSize * 3; i++) {
            for (int j = 0; j < gridSize * 3; j++) {
                // If we find an unvisited cell (0), it's a new region
                if (expandedGrid[i][j] == 0) {
                    // Fill that region
                    floodFill(expandedGrid, i, j);
                    regionCount++;
                }
            }
        }
        return regionCount;
    }

    // Flood fill algorithm to mark all cells in a region
    private void floodFill(int[][] expandedGrid, int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        expandedGrid[row][col] = 1;
        queue.add(new int[] { row, col });

        while (!queue.isEmpty()) {
            int[] currentCell = queue.poll();
            // Check all four directions from the current cell
            for (int[] direction : DIRECTIONS) {
                int newRow = direction[0] + currentCell[0];
                int newCol = direction[1] + currentCell[1];
                // If the new cell is valid and unvisited, mark it and add to queue
                if (isValidCell(expandedGrid, newRow, newCol)) {
                    expandedGrid[newRow][newCol] = 1;
                    queue.add(new int[] { newRow, newCol });
                }
            }
        }
    }

    // Check if a cell is within bounds and unvisited
    private boolean isValidCell(int[][] expandedGrid, int row, int col) {
        int n = expandedGrid.length;
        return (
            row >= 0 &&
            col >= 0 &&
            row < n &&
            col < n &&
            expandedGrid[row][col] == 0
        );
    }
}

// 5ms 41.95MB
/**
 * <h3 id="approach-2-disjoint-set-union-triangles" level="3" class="group/heading relative"><a href="#approach-2-disjoint-set-union-triangles" class="!text-sd-muted-foreground absolute right-full top-1/2 -translate-y-1/2 cursor-pointer pr-0.5 text-xs opacity-0 group-hover/heading:opacity-100" aria-hidden="true" tabindex="-1"><div class="relative text-[12px] leading-[normal] p-[1px] before:block before:h-3 before:w-3"><svg aria-hidden="true" focusable="false" data-prefix="fas" data-icon="link" class="svg-inline--fa fa-link absolute left-1/2 top-1/2 -translate-x-1/2 -translate-y-1/2" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 640 512" spacing="square"><path fill="currentColor" d="M579.8 267.7c56.5-56.5 56.5-148 0-204.5c-50-50-128.8-56.5-186.3-15.4l-1.6 1.1c-14.4 10.3-17.7 30.3-7.4 44.6s30.3 17.7 44.6 7.4l1.6-1.1c32.1-22.9 76-19.3 103.8 8.6c31.5 31.5 31.5 82.5 0 114L422.3 334.8c-31.5 31.5-82.5 31.5-114 0c-27.9-27.9-31.5-71.8-8.6-103.8l1.1-1.6c10.3-14.4 6.9-34.4-7.4-44.6s-34.4-6.9-44.6 7.4l-1.1 1.6C206.5 251.2 213 330 263 380c56.5 56.5 148 56.5 204.5 0L579.8 267.7zM60.2 244.3c-56.5 56.5-56.5 148 0 204.5c50 50 128.8 56.5 186.3 15.4l1.6-1.1c14.4-10.3 17.7-30.3 7.4-44.6s-30.3-17.7-44.6-7.4l-1.6 1.1c-32.1 22.9-76 19.3-103.8-8.6C74 372 74 321 105.5 289.5L217.7 177.2c31.5-31.5 82.5-31.5 114 0c27.9 27.9 31.5 71.8 8.6 103.9l-1.1 1.6c-10.3 14.4-6.9 34.4 7.4 44.6s34.4 6.9 44.6-7.4l1.1-1.6C433.5 260.8 427 182 377 132c-56.5-56.5-148-56.5-204.5 0L60.2 244.3z"></path></svg></div></a>Approach 2: Disjoint Set Union (Triangles)</h3>
 * <h4 id="intuition-1">Intuition</h4>
 * <p>Our previous approach involved magnifying each cell into a <span class="math math-inline"><span class="katex"><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.7278em; vertical-align: -0.0833em;"></span><span class="mord">3</span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mbin">×</span><span class="mspace" style="margin-right: 0.2222em;"></span></span><span class="base"><span class="strut" style="height: 0.6444em;"></span><span class="mord">3</span></span></span></span></span> grid, increasing the number of unit cells by a factor of 9. We can further optimize this process by reconceptualizing how regions are formed and connected. Instead of viewing the grid as squares, let's envision each cell divided into four triangles. This allows for a more precise representation of slashes.</p>
 * <p><img src="../Figures/959/triangles.png" alt="cell divided into four triangles"></p>
 * <p>Initially, each triangle is considered its own region. As we traverse the grid, we can group together all triangles not separated by slashes as belonging to one component (region). The total number of these groups will be our required answer.</p>
 * <p>A widely used data structure for grouping connected components is the Disjoint Set Union (DSU). A DSU assigns each component (a unit triangle) a parent, which is initially itself. To connect or union two components, we assign them to the same parent, meaning units with the same parent belong to the same connected component. To learn more about how the disjoint set union data structure is implemented, refer to this LeetCode <a href="https://leetcode.com/explore/learn/card/graph/618/disjoint-set/3881/" target="_blank">Explore Card</a>.</p>
 * <p>We iterate over the grid and perform two main types of operations:</p>
 * <ol>
 * <li>
 * <p>Union adjacent components:</p>
 * <p>Regardless of whether a cell contains a forward slash or backslash, the top triangle of a cell will always connect to the bottom triangle of the cell above it. The same principle applies to the left triangle of a cell and the right triangle of the cell to its left.</p>
 * <p><img src="../Figures/959/top_and_left.png" alt="connecting top and left cells"></p>
 * </li>
 * <li>
 * <p>Union intra-cell components:</p>
 * <p>A slash divides the cell diagonally, allowing us to combine the two adjacent triangles on each side of the diagonal.</p>
 * </li>
 * </ol>
 * <p>We begin with the total number of triangles as our initial region count. Each successful union operation indicates that two distinct components have been merged into one, reducing the total number of regions by one. After processing all cells, the remaining count represents the number of distinct regions.</p>
 * <h4 id="algorithm-1">Algorithm</h4>
 * <p>Main method <code>regionsBySlashes</code>:</p>
 * <ul>
 * <li>Set <code>gridSize</code> as the size of the <code>grid</code>.</li>
 * <li>Calculate <code>totalTriangles</code> in the grid as <code>gridSize * gridSize * 4</code>.</li>
 * <li>Create a <code>parentArray</code> to represent the disjoint sets of triangles and initialize each element to <code>-1</code>.</li>
 * <li>Initialize <code>regionCount</code> to <code>totalTriangles</code>, assuming each triangle is initially a separate region.</li>
 * <li>Iterate through each cell of <code>grid</code>:
 * <ul>
 * <li>If there is a cell above the current cell, union the bottom triangle of the above cell with the top triangle of the current cell.</li>
 * <li>If there is a cell to the left of the current cell, union the right triangle of the left cell with the left triangle of the current cell.</li>
 * <li>If the current cell is not <code>/</code>:
 * <ul>
 * <li>Union the top triangle with the right triangle.</li>
 * <li>Union the bottom triangle with the left triangle.</li>
 * </ul>
 * </li>
 * <li>If the current cell is not <code>\\</code>:
 * <ul>
 * <li>Union the top triangle with the left triangle.</li>
 * <li>Union the bottom triangle with the right triangle.</li>
 * </ul>
 * </li>
 * </ul>
 * </li>
 * <li>Return <code>regionCount</code> as our answer.</li>
 * </ul>
 * <p>Helper method <code>getTriangleIndex</code>:</p>
 * <ul>
 * <li>Define a method <code>getTriangleIndex</code> with parameters: <code>gridSize</code>, the <code>row</code> and <code>col</code> indices, and the <code>triangleNum</code>.</li>
 * <li>Return <code>(gridSize * row + col) * 4 + triangleNum</code>.</li>
 * </ul>
 * <p>Helper method <code>unionTriangles</code>:</p>
 * <ul>
 * <li>Define a method <code>unionTriangles</code> with parameters: <code>parentArray</code> and the two indices <code>x</code> and <code>y</code>.</li>
 * <li>Find <code>parentX</code> and <code>parentY</code> using the <code>findParent</code> method.</li>
 * <li>If <code>parentX</code> is not equal to <code>parentY</code>:
 * <ul>
 * <li>Set <code>parentArray[parentX]</code> to <code>parentY</code> and return <code>1</code>.</li>
 * </ul>
 * </li>
 * <li>Return <code>0</code>.</li>
 * </ul>
 * <p>Helper method <code>findParent</code>:</p>
 * <ul>
 * <li>Define a method <code>findParent</code> with parameters: <code>parentArray</code> and the index <code>x</code>.</li>
 * <li>If <code>parentArray[x]</code> is equal to <code>-1</code>:
 * <ul>
 * <li><code>x</code> has no parent. Return <code>x</code>.</li>
 * </ul>
 * </li>
 * <li>Set <code>parentArray[x]</code> to the parent of <code>parentArray[x]</code> using <code>findParent</code>. Return <code>parentArray[x]</code>.</li>
 * </ul>
 * 
 */
class RegionsCutBySlashes_Solution2 {

    public int regionsBySlashes(String[] grid) {
        int gridSize = grid.length;
        int totalTriangles = gridSize * gridSize * 4;
        int[] parentArray = new int[totalTriangles];
        Arrays.fill(parentArray, -1);

        // Initially, each small triangle is a separate region
        int regionCount = totalTriangles;

        for (int row = 0; row < gridSize; row++) {
            for (int col = 0; col < gridSize; col++) {
                // Connect with the cell above
                if (row > 0) {
                    regionCount -=
                    unionTriangles(
                        parentArray,
                        getTriangleIndex(gridSize, row - 1, col, 2),
                        getTriangleIndex(gridSize, row, col, 0)
                    );
                }
                // Connect with the cell to the left
                if (col > 0) {
                    regionCount -=
                    unionTriangles(
                        parentArray,
                        getTriangleIndex(gridSize, row, col - 1, 1),
                        getTriangleIndex(gridSize, row, col, 3)
                    );
                }

                // If not '/', connect triangles 0-1 and 2-3
                if (grid[row].charAt(col) != '/') {
                    regionCount -=
                    unionTriangles(
                        parentArray,
                        getTriangleIndex(gridSize, row, col, 0),
                        getTriangleIndex(gridSize, row, col, 1)
                    );
                    regionCount -=
                    unionTriangles(
                        parentArray,
                        getTriangleIndex(gridSize, row, col, 2),
                        getTriangleIndex(gridSize, row, col, 3)
                    );
                }

                // If not '\', connect triangles 0-3 and 1-2
                if (grid[row].charAt(col) != '\\') {
                    regionCount -=
                    unionTriangles(
                        parentArray,
                        getTriangleIndex(gridSize, row, col, 0),
                        getTriangleIndex(gridSize, row, col, 3)
                    );
                    regionCount -=
                    unionTriangles(
                        parentArray,
                        getTriangleIndex(gridSize, row, col, 2),
                        getTriangleIndex(gridSize, row, col, 1)
                    );
                }
            }
        }
        return regionCount;
    }

    // Calculate the index of a triangle in the flattened array
    // Each cell is divided into 4 triangles, numbered 0 to 3 clockwise from the top
    private int getTriangleIndex(
        int gridSize,
        int row,
        int col,
        int triangleNum
    ) {
        return (gridSize * row + col) * 4 + triangleNum;
    }

    // Union two triangles and return 1 if they were not already connected, 0 otherwise
    private int unionTriangles(int[] parentArray, int x, int y) {
        int parentX = findParent(parentArray, x);
        int parentY = findParent(parentArray, y);

        if (parentX != parentY) {
            parentArray[parentX] = parentY;
            return 1; // Regions were merged, so count decreases by 1
        }

        return 0; // Regions were already connected
    }

    // Find the parent (root) of a set
    private int findParent(int[] parentArray, int x) {
        if (parentArray[x] == -1) return x;

        return parentArray[x] = findParent(parentArray, parentArray[x]);
    }
}

// 3ms 41.24MB
/**
 * <h3 id="approach-3-disjoint-set-union-graph" level="3" class="group/heading relative"><a href="#approach-3-disjoint-set-union-graph" class="!text-sd-muted-foreground absolute right-full top-1/2 -translate-y-1/2 cursor-pointer pr-0.5 text-xs opacity-0 group-hover/heading:opacity-100" aria-hidden="true" tabindex="-1"><div class="relative text-[12px] leading-[normal] p-[1px] before:block before:h-3 before:w-3"><svg aria-hidden="true" focusable="false" data-prefix="fas" data-icon="link" class="svg-inline--fa fa-link absolute left-1/2 top-1/2 -translate-x-1/2 -translate-y-1/2" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 640 512" spacing="square"><path fill="currentColor" d="M579.8 267.7c56.5-56.5 56.5-148 0-204.5c-50-50-128.8-56.5-186.3-15.4l-1.6 1.1c-14.4 10.3-17.7 30.3-7.4 44.6s30.3 17.7 44.6 7.4l1.6-1.1c32.1-22.9 76-19.3 103.8 8.6c31.5 31.5 31.5 82.5 0 114L422.3 334.8c-31.5 31.5-82.5 31.5-114 0c-27.9-27.9-31.5-71.8-8.6-103.8l1.1-1.6c10.3-14.4 6.9-34.4-7.4-44.6s-34.4-6.9-44.6 7.4l-1.1 1.6C206.5 251.2 213 330 263 380c56.5 56.5 148 56.5 204.5 0L579.8 267.7zM60.2 244.3c-56.5 56.5-56.5 148 0 204.5c50 50 128.8 56.5 186.3 15.4l1.6-1.1c14.4-10.3 17.7-30.3 7.4-44.6s-30.3-17.7-44.6-7.4l-1.6 1.1c-32.1 22.9-76 19.3-103.8-8.6C74 372 74 321 105.5 289.5L217.7 177.2c31.5-31.5 82.5-31.5 114 0c27.9 27.9 31.5 71.8 8.6 103.9l-1.1 1.6c-10.3 14.4-6.9 34.4 7.4 44.6s34.4 6.9 44.6-7.4l1.1-1.6C433.5 260.8 427 182 377 132c-56.5-56.5-148-56.5-204.5 0L60.2 244.3z"></path></svg></div></a>Approach 3: Disjoint Set Union (Graph)</h3>
 * <h4 id="intuition-2">Intuition</h4>
 * <p>Let's shift our perspective and consider slashes as connectors rather than dividers. Imagine each cell as a graph with four vertices at its corners, with slashes acting as edges between these vertices. The following diagram illustrates this concept:</p>
 * <p><img src="../Figures/959/grid_to_graph.png" alt="cell as a graph"></p>
 * <p>In this paradigm, a slash can be represented as follows:</p>
 * <ul>
 * <li>A <code>/</code> slash connects the top-right point of a cell to the bottom-left point.</li>
 * <li>A <code>\</code> slash connects the top-left point to the bottom-right point.</li>
 * <li>An empty space doesn't add any new connections.</li>
 * </ul>
 * <p>The edges of the grid form the boundaries of the graph, creating an initial region. As we connect vertices (slashes), cycles may form, indicating the creation of new regions within the graph. By tracking the total number of cycles formed while iterating over all slashes, we determine the final count of regions.</p>
 * <p>To manage connected components, we use a DSU (Disjoint Set Union) data structure. We start by connecting the boundary points as the first region. As we process each cell, we treat each slash as an edge and union the corresponding vertices. If a union operation reveals that the vertices already share the same parent, it indicates a cycle, prompting us to increment our counter.</p>
 * <h4 id="algorithm-2">Algorithm</h4>
 * <p>Main method <code>regionsBySlashes</code>:</p>
 * <ul>
 * <li>Initialize variables:
 * <ul>
 * <li><code>gridSize</code> to the length of <code>grid</code>.</li>
 * <li><code>pointsPerSide</code> to <code>gridSize + 1</code>.</li>
 * <li><code>totalPoints</code> to <code>pointsPerSide * pointsPerSide</code>.</li>
 * </ul>
 * </li>
 * <li>Create an array <code>parentArray</code> to represent the disjoint set, initialized with <code>-1</code>.</li>
 * <li>Loop over the each point:
 * <ul>
 * <li>If the point lies on the border, set its <code>parent</code> to <code>0</code>.</li>
 * </ul>
 * </li>
 * <li>Set <code>parent[0]</code> (top-left corner) to <code>-1</code> to make it the root.</li>
 * <li>Initialize <code>regionCount</code> to <code>1</code>, accounting for the border region.</li>
 * <li>Iterate through each cell <code>(i, j)</code> in the <code>grid</code>:
 * <ul>
 * <li>If it's a forward slash (<code>/</code>):
 * <ul>
 * <li>Calculate the <code>topRight</code> and <code>bottomLeft</code> indices.</li>
 * <li>Call <code>union</code> on these points and add the result to <code>regionCount</code>.</li>
 * </ul>
 * </li>
 * <li>If it's a backslash (<code>\\</code>):
 * <ul>
 * <li>Calculate the <code>topLeft</code> and <code>bottomRight</code> indices.</li>
 * <li>Call <code>union</code> on these points and add the result to <code>regionCount</code>.</li>
 * </ul>
 * </li>
 * </ul>
 * </li>
 * <li>Return the final <code>regionCount</code>.</li>
 * </ul>
 * <p>Helper method <code>find</code>:</p>
 * <ul>
 * <li>Define a method <code>find</code> with parameters: <code>parentArray</code> and the <code>node</code>.</li>
 * <li>If <code>parentArray[node]</code> is equal to <code>-1</code>:
 * <ul>
 * <li><code>node</code> does not have any parent. Return <code>node</code>.</li>
 * </ul>
 * </li>
 * <li>Set <code>parentArray[node]</code> to the parent of <code>parentArray[node]</code> using the <code>find</code> method. Return <code>parentArray[node]</code>.</li>
 * </ul>
 * <p>Helper method <code>union</code>:</p>
 * <ul>
 * <li>Define a method union with parameters: <code>parentArray</code> and nodes <code>node1</code> and <code>node2</code>.</li>
 * <li>Set <code>parent1</code> to <code>parent2</code> to the parents of <code>node1</code> and <code>node2</code> respectively.</li>
 * <li>If <code>parent1</code> is equal to <code>parent2</code>, return <code>1</code>.</li>
 * <li>Set <code>parentArray[parent2]</code> to <code>parent1</code>.</li>
 * <li>Return <code>0</code>.</li>
 * </ul>
 */
class RegionsCutBySlashes_Solution3 {

    public int regionsBySlashes(String[] grid) {
        int gridSize = grid.length;
        int pointsPerSide = gridSize + 1;
        int totalPoints = pointsPerSide * pointsPerSide;

        // Initialize disjoint set data structure
        int[] parentArray = new int[totalPoints];
        Arrays.fill(parentArray, -1);

        // Connect border points
        for (int i = 0; i < pointsPerSide; i++) {
            for (int j = 0; j < pointsPerSide; j++) {
                if (
                    i == 0 ||
                    j == 0 ||
                    i == pointsPerSide - 1 ||
                    j == pointsPerSide - 1
                ) {
                    int point = i * pointsPerSide + j;
                    parentArray[point] = 0;
                }
            }
        }

        // Set the parent of the top-left corner to itself
        parentArray[0] = -1;
        int regionCount = 1; // Start with one region (the border)

        // Process each cell in the grid
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                // Treat each slash as an edge connecting two points
                if (grid[i].charAt(j) == '/') {
                    int topRight = i * pointsPerSide + (j + 1);
                    int bottomLeft = (i + 1) * pointsPerSide + j;
                    regionCount += union(parentArray, topRight, bottomLeft);
                } else if (grid[i].charAt(j) == '\\') {
                    int topLeft = i * pointsPerSide + j;
                    int bottomRight = (i + 1) * pointsPerSide + (j + 1);
                    regionCount += union(parentArray, topLeft, bottomRight);
                }
            }
        }

        return regionCount;
    }

    // Find the parent of a set
    private int find(int[] parentArray, int node) {
        if (parentArray[node] == -1) return node;

        return parentArray[node] = find(parentArray, parentArray[node]);
    }

    // Union two sets and return 1 if a new region is formed, 0 otherwise
    private int union(int[] parentArray, int node1, int node2) {
        int parent1 = find(parentArray, node1);
        int parent2 = find(parentArray, node2);

        if (parent1 == parent2) {
            return 1; // Nodes are already in the same set, new region formed
        }

        parentArray[parent2] = parent1; // Union the sets
        return 0; // No new region formed
    }
}