package Medium.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/most-stones-removed-with-same-row-or-column/">947. Most Stones Removed with Same Row or Column</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>On a 2D plane, we place <code>n</code> stones at some integer coordinate points. Each coordinate point may have at most one stone.</p>
 * 
 * <p>A stone can be removed if it shares either <strong>the same row or the same column</strong> as another stone that has not been removed.</p>
 * 
 * <p>Given an array <code>stones</code> of length <code>n</code> where <code>stones[i] = [x<sub>i</sub>, y<sub>i</sub>]</code> represents the location of the <code>i<sup>th</sup></code> stone, return <em>the largest possible number of stones that can be removed</em>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
 * <strong>Output:</strong> 5
 * <strong>Explanation:</strong> One way to remove 5 stones is as follows:
 * 1. Remove stone [2,2] because it shares the same row as [2,1].
 * 2. Remove stone [2,1] because it shares the same column as [0,1].
 * 3. Remove stone [1,2] because it shares the same row as [1,0].
 * 4. Remove stone [1,0] because it shares the same column as [0,0].
 * 5. Remove stone [0,1] because it shares the same row as [0,0].
 * Stone [0,0] cannot be removed since it does not share a row/column with another stone still on the plane.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
 * <strong>Output:</strong> 3
 * <strong>Explanation:</strong> One way to make 3 moves is as follows:
 * 1. Remove stone [2,2] because it shares the same row as [2,0].
 * 2. Remove stone [2,0] because it shares the same column as [0,0].
 * 3. Remove stone [0,2] because it shares the same row as [0,0].
 * Stones [0,0] and [1,1] cannot be removed since they do not share a row/column with another stone still on the plane.
 * </pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <pre><strong>Input:</strong> stones = [[0,0]]
 * <strong>Output:</strong> 0
 * <strong>Explanation:</strong> [0,0] is the only stone on the plane, so you cannot remove it.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= stones.length &lt;= 1000</code></li>
 * 	<li><code>0 &lt;= x<sub>i</sub>, y<sub>i</sub> &lt;= 10<sup>4</sup></code></li>
 * 	<li>No two stones are at the same coordinate point.</li>
 * </ul>
 * </div>
 */
public class MostStonesRemovedWithSameRowOrColumn {
    public static void main(String[] args) {
        int[][][] tests = {
            {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}}
        };

        for (int[][] stones : tests) {
            System.out.println(new MostStonesRemovedWithSameRowOrColumn_Solution().removeStones(stones));
        }
    }
}

// 32ms 44.6MB
@SuppressWarnings("all")
class MostStonesRemovedWithSameRowOrColumn_Solution {

    public int removeStones(int[][] stones) {
        int n = stones.length;

        // Adjacency list to store graph connections
        List<Integer>[] adjacencyList = new List[n];
        for (int i = 0; i < n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        // Build the graph: Connect stones that share the same row or column
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (
                    stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]
                ) {
                    adjacencyList[i].add(j);
                    adjacencyList[j].add(i);
                }
            }
        }

        int numOfConnectedComponents = 0;
        boolean[] visited = new boolean[n];

        // Traverse all stones using DFS to count connected components
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                depthFirstSearch(adjacencyList, visited, i);
                numOfConnectedComponents++;
            }
        }

        // Maximum stones that can be removed is total stones minus number of connected components
        return n - numOfConnectedComponents;
    }

    // DFS to visit all stones in a connected component
    private void depthFirstSearch(
        List<Integer>[] adjacencyList,
        boolean[] visited,
        int stone
    ) {
        visited[stone] = true;

        for (int neighbor : adjacencyList[stone]) {
            if (!visited[neighbor]) {
                depthFirstSearch(adjacencyList, visited, neighbor);
            }
        }
    }
}