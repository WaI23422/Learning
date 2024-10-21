package BetterCodeAnswer.Medium.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/find-the-safest-path-in-a-grid/">2812. Find the Safest Path in a Grid</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You are given a <strong>0-indexed</strong> 2D matrix <code>grid</code> of size <code>n x n</code>, where <code>(r, c)</code> represents:</p>

<ul>
	<li>A cell containing a thief if <code>grid[r][c] = 1</code></li>
	<li>An empty cell if <code>grid[r][c] = 0</code></li>
</ul>

<p>You are initially positioned at cell <code>(0, 0)</code>. In one move, you can move to any adjacent cell in the grid, including cells containing thieves.</p>

<p>The <strong>safeness factor</strong> of a path on the grid is defined as the <strong>minimum</strong> manhattan distance from any cell in the path to any thief in the grid.</p>

<p>Return <em>the <strong>maximum safeness factor</strong> of all paths leading to cell </em><code>(n - 1, n - 1)</code><em>.</em></p>

<p>An <strong>adjacent</strong> cell of cell <code>(r, c)</code>, is one of the cells <code>(r, c + 1)</code>, <code>(r, c - 1)</code>, <code>(r + 1, c)</code> and <code>(r - 1, c)</code> if it exists.</p>

<p>The <strong>Manhattan distance</strong> between two cells <code>(a, b)</code> and <code>(x, y)</code> is equal to <code>|a - x| + |b - y|</code>, where <code>|val|</code> denotes the absolute value of val.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2023/07/02/example1.png" style="width: 362px; height: 242px;">
<pre><strong>Input:</strong> grid = [[1,0,0],[0,0,0],[0,0,1]]
<strong>Output:</strong> 0
<strong>Explanation:</strong> All paths from (0, 0) to (n - 1, n - 1) go through the thieves in cells (0, 0) and (n - 1, n - 1).
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2023/07/02/example2.png" style="width: 362px; height: 242px;">
<pre><strong>Input:</strong> grid = [[0,0,1],[0,0,0],[0,0,0]]
<strong>Output:</strong> 2
<strong>Explanation:</strong> The path depicted in the picture above has a safeness factor of 2 since:
- The closest cell of the path to the thief at cell (0, 2) is cell (0, 0). The distance between them is | 0 - 0 | + | 0 - 2 | = 2.
It can be shown that there are no other paths with a higher safeness factor.
</pre>

<p><strong class="example">Example 3:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2023/07/02/example3.png" style="width: 362px; height: 242px;">
<pre><strong>Input:</strong> grid = [[0,0,0,1],[0,0,0,0],[0,0,0,0],[1,0,0,0]]
<strong>Output:</strong> 2
<strong>Explanation:</strong> The path depicted in the picture above has a safeness factor of 2 since:
- The closest cell of the path to the thief at cell (0, 3) is cell (1, 2). The distance between them is | 0 - 1 | + | 3 - 2 | = 2.
- The closest cell of the path to the thief at cell (3, 0) is cell (3, 2). The distance between them is | 3 - 3 | + | 0 - 2 | = 2.
It can be shown that there are no other paths with a higher safeness factor.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= grid.length == n &lt;= 400</code></li>
	<li><code>grid[i].length == n</code></li>
	<li><code>grid[i][j]</code> is either <code>0</code> or <code>1</code>.</li>
	<li>There is at least one thief in the <code>grid</code>.</li>
</ul>
</div>
 */
public class FindTheSafestPathInAGrid {
    public static void main(String[] args) {
        int[][][] tests = {
            {{},{},{}}
        };

        for (int[][] test : tests) {
            List<List<Integer>> grid = new ArrayList<>();
            for (int i = 0; i < test.length; i++) {
                List<Integer> row = new ArrayList<>();
                for (int j = 0; j < test[0].length; j++) {
                    row.add(test[i][j]);
                }
                grid.add(row);
            }

            System.out.println(new FindTheSafestPathInAGrid_Solution().maximumSafenessFactor(grid));
        }
    }
}

// 76 ms 78 MB
class FindTheSafestPathInAGrid_Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n=grid.size();
        if(grid.get(0).get(0)==1 || grid.get(n-1).get(n-1)==1) return 0;
        int cost[][]=new int[n][n];
        for(var v:cost) Arrays.fill(v, Integer.MAX_VALUE);
        bfs(cost, grid, n);
        int l=1,r=n*n;
        int ans=0;
        while(l<=r){
            int mid=(r-l)/2 + l;
            if(possible(0, 0, cost, mid, n, new boolean[n][n])){
                ans=mid;
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return ans;
    }
    public boolean possible(int i, int j, int cost[][], int mid, int n, boolean visited[][]){
        if(i<0 || j<0 || i>=n || j>=n) return false;
        if(cost[i][j]==Integer.MAX_VALUE || cost[i][j]<mid) return false;
        if(i==n-1 && j==n-1) return true;
        if(visited[i][j]) return false;
        visited[i][j]=true;
        int dir[][]={{1,0},{0,1},{-1,0},{0,-1}};
        boolean ans=false;
        for(var v:dir){
            int ii=i+v[0];
            int jj=j+v[1];
            ans|=possible(ii, jj, cost, mid, n, visited);
            if(ans) return true;
        }
        return ans;
    }
    public void bfs(int cost[][], List<List<Integer>> grid, int n){
        Queue<int[]> q=new LinkedList<>();
        boolean visited[][]=new boolean[n][n];
        for(int i=0;i<grid.size();i++){
            for(int j=0;j<grid.size();j++){
                if(grid.get(i).get(j)==1){
                    q.add(new int[]{i,j});
                    visited[i][j]=true;
                }
            }
        }
        int level=1;
        int dir[][]={{1,0},{0,1},{-1,0},{0,-1}};
        while(!q.isEmpty()){
            int len=q.size();
            for(int i=0;i<len;i++){
                var v=q.poll();
                var temp=v;
                for(var val:dir){
                    int ii=temp[0]+val[0];
                    int jj=temp[1]+val[1];
                    if(isValid(ii, jj, n) && !visited[ii][jj] ){
                        q.add(new int[]{ii,jj});
                        cost[ii][jj]=Math.min(cost[ii][jj], level);
                        visited[ii][jj] = true;
                    }
                }
            }
            level++;
        }
    }
    public boolean isValid(int i, int j, int n){
        return (i>=0 && j>=0 && i<n && j<n);
    }
}

// 92 ms 69.5 MB
class FindTheSafestPathInAGrid_Solution2 {
    int[][] directions = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        int[][] gridArr = new int[n][n];
        int[][] safety = new int[n][n]; //closest distance to thief
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid.get(i).get(j) == 1){
                    gridArr[i][j] = 1;
                    safety[i][j] = 0;
                    queue.add(new int[]{i, j, 0});
                }else{
                    safety[i][j] = Integer.MAX_VALUE;
                }
            }
        }if(gridArr[0][0] == 1 || gridArr[n - 1][n - 1] == 1) return 0;
        //bfs from each thief, update the smallest safety for all cells
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int currX = curr[0];
            int currY = curr[1];
            int currSafety = curr[2];
            for(int[] dir: directions){
                int nextX = currX + dir[0];
                int nextY = currY + dir[1];
                if(isValid(nextX, nextY, n) && safety[nextX][nextY] > currSafety + 1){
                    queue.add(new int[]{nextX, nextY, currSafety + 1});
                    safety[nextX][nextY] = currSafety + 1;
                }
            }
        }
        //bfs from start
        Queue<int[]> path = new PriorityQueue<>((a, b) -> Integer.compare(b[2], a[2]));
        path.add(new int[]{0,0,safety[0][0]});
        gridArr[0][0] = 2;
        while(!path.isEmpty()){
            int[] curr = path.poll();
            int currX = curr[0];
            int currY = curr[1];
            int currSafety = curr[2];
            if(currX == n - 1 && currY == n - 1) return currSafety;
            for(int[] dir: directions){
                int nextX = currX + dir[0];
                int nextY = currY + dir[1];
                if(isValid(nextX, nextY, n) && gridArr[nextX][nextY] != 2){
                    path.add(new int[]{nextX, nextY, Math.min(currSafety, safety[nextX][nextY])});
                    gridArr[nextX][nextY] = 2;
                }
            }
        }return 0;
    }
    public boolean isValid(int i, int j, int n){
        if(i < 0|| i >= n || j<0 || j>=n ) return false;
        return true;
    }
}