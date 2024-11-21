package Medium.Array;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/count-unguarded-cells-in-the-grid/">2257. Count Unguarded Cells in the Grid</a>
 * 
 * <div><div class="elfjS" data-track-load="description_content"><p>You are given two integers <code>m</code> and <code>n</code> representing a <strong>0-indexed</strong> <code>m x n</code> grid. You are also given two 2D integer arrays <code>guards</code> and <code>walls</code> where <code>guards[i] = [row<sub>i</sub>, col<sub>i</sub>]</code> and <code>walls[j] = [row<sub>j</sub>, col<sub>j</sub>]</code> represent the positions of the <code>i<sup>th</sup></code> guard and <code>j<sup>th</sup></code> wall respectively.</p>
 * 
 * <p>A guard can see <b>every</b> cell in the four cardinal directions (north, east, south, or west) starting from their position unless <strong>obstructed</strong> by a wall or another guard. A cell is <strong>guarded</strong> if there is <strong>at least</strong> one guard that can see it.</p>
 * 
 * <p>Return<em> the number of unoccupied cells that are <strong>not</strong> <strong>guarded</strong>.</em></p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2022/03/10/example1drawio2.png" style="width: 300px; height: 204px;">
 * <pre><strong>Input:</strong> m = 4, n = 6, guards = [[0,0],[1,1],[2,3]], walls = [[0,1],[2,2],[1,4]]
 * <strong>Output:</strong> 7
 * <strong>Explanation:</strong> The guarded and unguarded cells are shown in red and green respectively in the above diagram.
 * There are a total of 7 unguarded cells, so we return 7.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2022/03/10/example2drawio.png" style="width: 200px; height: 201px;">
 * <pre><strong>Input:</strong> m = 3, n = 3, guards = [[1,1]], walls = [[0,1],[1,0],[2,1],[1,2]]
 * <strong>Output:</strong> 4
 * <strong>Explanation:</strong> The unguarded cells are shown in green in the above diagram.
 * There are a total of 4 unguarded cells, so we return 4.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= m, n &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>2 &lt;= m * n &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>1 &lt;= guards.length, walls.length &lt;= 5 * 10<sup>4</sup></code></li>
 * 	<li><code>2 &lt;= guards.length + walls.length &lt;= m * n</code></li>
 * 	<li><code>guards[i].length == walls[j].length == 2</code></li>
 * 	<li><code>0 &lt;= row<sub>i</sub>, row<sub>j</sub> &lt; m</code></li>
 * 	<li><code>0 &lt;= col<sub>i</sub>, col<sub>j</sub> &lt; n</code></li>
 * 	<li>All the positions in <code>guards</code> and <code>walls</code> are <strong>unique</strong>.</li>
 * </ul>
 * </div></div>
 */
public class CountUnguardedCellsInTheGrid {
    public static void main(String[] args) {
        
    }
}

// 19ms 67.5MB
class CountUnguardedCellsInTheGrid_Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
         int matrix[][] = new int[m][n],
            total = m*n,
            b_vision = 0;

        for (int[] guard : guards) { matrix[guard[0]][guard[1]] = -1; }
        for (int[] wall : walls) { matrix[wall[0]][wall[1]] = -1; }
            
        for (int[] guard : guards) {
            int row = guard[0], 
                col = guard[1];

            // Down:
            while (--row >= 0) {
                if (matrix[row][col] == -1) { break; }

                if (matrix[row][col] == 0) {
                    matrix[row][col] = 1;
                    b_vision++;
                }
            }

            // Up:
            row = guard[0]; col = guard[1];
            while (++row < m) {
                if (matrix[row][col] == -1) {break;}

                if (matrix[row][col] == 0) {
                    matrix[row][col] = 1;
                    b_vision++;
                }
            }

            // Left:
            row = guard[0]; col = guard[1];
            while (--col >= 0) {
                if (matrix[row][col] == -1) {break;}
                
                if (matrix[row][col] == 0) {
                    matrix[row][col] = 1;
                    b_vision++;
                }
            }

            // Right:
            row = guard[0]; col = guard[1];
            while (++col < n) {
                if (matrix[row][col] == -1) {break;} 

                if (matrix[row][col] == 0) {
                    matrix[row][col] = 1;
                    b_vision++;
                }
            }
        }

        return total - b_vision - guards.length - walls.length;
    }
}