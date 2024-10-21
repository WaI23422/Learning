package Medium.Array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/find-all-groups-of-farmland/">1992. Find All Groups of Farmland</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You are given a <strong>0-indexed</strong> <code>m x n</code> binary matrix <code>land</code> where a <code>0</code> represents a hectare of forested land and a <code>1</code> represents a hectare of farmland.</p>

<p>To keep the land organized, there are designated rectangular areas of hectares that consist <strong>entirely</strong> of farmland. These rectangular areas are called <strong>groups</strong>. No two groups are adjacent, meaning farmland in one group is <strong>not</strong> four-directionally adjacent to another farmland in a different group.</p>

<p><code>land</code> can be represented by a coordinate system where the top left corner of <code>land</code> is <code>(0, 0)</code> and the bottom right corner of <code>land</code> is <code>(m-1, n-1)</code>. Find the coordinates of the top left and bottom right corner of each <strong>group</strong> of farmland. A <strong>group</strong> of farmland with a top left corner at <code>(r<sub>1</sub>, c<sub>1</sub>)</code> and a bottom right corner at <code>(r<sub>2</sub>, c<sub>2</sub>)</code> is represented by the 4-length array <code>[r<sub>1</sub>, c<sub>1</sub>, r<sub>2</sub>, c<sub>2</sub>].</code></p>

<p>Return <em>a 2D array containing the 4-length arrays described above for each <strong>group</strong> of farmland in </em><code>land</code><em>. If there are no groups of farmland, return an empty array. You may return the answer in <strong>any order</strong></em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/07/27/screenshot-2021-07-27-at-12-23-15-copy-of-diagram-drawio-diagrams-net.png" style="width: 300px; height: 300px;">
<pre><strong>Input:</strong> land = [[1,0,0],[0,1,1],[0,1,1]]
<strong>Output:</strong> [[0,0,0,0],[1,1,2,2]]
<strong>Explanation:</strong>
The first group has a top left corner at land[0][0] and a bottom right corner at land[0][0].
The second group has a top left corner at land[1][1] and a bottom right corner at land[2][2].
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/07/27/screenshot-2021-07-27-at-12-30-26-copy-of-diagram-drawio-diagrams-net.png" style="width: 200px; height: 200px;">
<pre><strong>Input:</strong> land = [[1,1],[1,1]]
<strong>Output:</strong> [[0,0,1,1]]
<strong>Explanation:</strong>
The first group has a top left corner at land[0][0] and a bottom right corner at land[1][1].
</pre>

<p><strong class="example">Example 3:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/07/27/screenshot-2021-07-27-at-12-32-24-copy-of-diagram-drawio-diagrams-net.png" style="width: 100px; height: 100px;">
<pre><strong>Input:</strong> land = [[0]]
<strong>Output:</strong> []
<strong>Explanation:</strong>
There are no groups of farmland.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>m == land.length</code></li>
	<li><code>n == land[i].length</code></li>
	<li><code>1 &lt;= m, n &lt;= 300</code></li>
	<li><code>land</code> consists of only <code>0</code>'s and <code>1</code>'s.</li>
	<li>Groups of farmland are <strong>rectangular</strong> in shape.</li>
</ul>
</div>
 */
public class FindAllGroupsOfFarmland {
    public static void main(String[] args) {
        int[][][] tests = {
            {{1,0,0},{0,1,1},{0,1,1}},
            {{0}},
            {{1,1},{1,1}},
        };

        for (int[][] land : tests) {
            System.out.println(new FindAllGroupsOfFarmland_Solution().findFarmland(land));
        }
    }
}

// 12 ms 62.1 MB
class FindAllGroupsOfFarmland_Solution {
    public int[][] findFarmland(int[][] land) {
        int rows = land.length;
        int cols = land[0].length;
        List<int[]> result = new ArrayList<>();
        boolean[][] visited = new boolean[rows][cols];
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        Queue<int[]> queue = new LinkedList<>();
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    int[] farmland = {i, j, i, j}; // [min_row, min_col, max_row, max_col]
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                    
                    while (!queue.isEmpty()) {
                        int[] curr = queue.poll();
                        int curRow = curr[0];
                        int curCol = curr[1];
                        
                        for (int[] dir : directions) {
                            int newRow = curRow + dir[0];
                            int newCol = curCol + dir[1];
                            
                            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols &&
                                land[newRow][newCol] == 1 && !visited[newRow][newCol]) {
                                queue.offer(new int[]{newRow, newCol});
                                visited[newRow][newCol] = true;
                                farmland[2] = Math.max(farmland[2], newRow); // update max_row
                                farmland[3] = Math.max(farmland[3], newCol); // update max_col
                            }
                        }
                    }
                    
                    result.add(farmland);
                }
            }
        }
        
        return result.toArray(new int[result.size()][]);
    }
}