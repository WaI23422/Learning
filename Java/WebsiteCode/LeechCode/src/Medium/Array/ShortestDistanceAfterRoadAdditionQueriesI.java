package Medium.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/shortest-distance-after-road-addition-queries-i/">3243. Shortest Distance After Road Addition Queries I</a>
 * 
 * <div><div class="elfjS" data-track-load="description_content"><p>You are given an integer <code>n</code> and a 2D integer array <code>queries</code>.</p>
 * 
 * <p>There are <code>n</code> cities numbered from <code>0</code> to <code>n - 1</code>. Initially, there is a <strong>unidirectional</strong> road from city <code>i</code> to city <code>i + 1</code> for all <code>0 &lt;= i &lt; n - 1</code>.</p>
 * 
 * <p><code>queries[i] = [u<sub>i</sub>, v<sub>i</sub>]</code> represents the addition of a new <strong>unidirectional</strong> road from city <code>u<sub>i</sub></code> to city <code>v<sub>i</sub></code>. After each query, you need to find the <strong>length</strong> of the <strong>shortest path</strong> from city <code>0</code> to city <code>n - 1</code>.</p>
 * 
 * <p>Return an array <code>answer</code> where for each <code>i</code> in the range <code>[0, queries.length - 1]</code>, <code>answer[i]</code> is the <em>length of the shortest path</em> from city <code>0</code> to city <code>n - 1</code> after processing the <strong>first </strong><code>i + 1</code> queries.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <div class="example-block">
 * <p><strong>Input:</strong> <span class="example-io">n = 5, queries = [[2,4],[0,2],[0,4]]</span></p>
 * 
 * <p><strong>Output:</strong> <span class="example-io">[3,2,1]</span></p>
 * 
 * <p><strong>Explanation: </strong></p>
 * 
 * <p><img alt="" src="https://assets.leetcode.com/uploads/2024/06/28/image8.jpg" style="width: 350px; height: 60px;"></p>
 * 
 * <p>After the addition of the road from 2 to 4, the length of the shortest path from 0 to 4 is 3.</p>
 * 
 * <p><img alt="" src="https://assets.leetcode.com/uploads/2024/06/28/image9.jpg" style="width: 350px; height: 60px;"></p>
 * 
 * <p>After the addition of the road from 0 to 2, the length of the shortest path from 0 to 4 is 2.</p>
 * 
 * <p><img alt="" src="https://assets.leetcode.com/uploads/2024/06/28/image10.jpg" style="width: 350px; height: 96px;"></p>
 * 
 * <p>After the addition of the road from 0 to 4, the length of the shortest path from 0 to 4 is 1.</p>
 * </div>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <div class="example-block">
 * <p><strong>Input:</strong> <span class="example-io">n = 4, queries = [[0,3],[0,2]]</span></p>
 * 
 * <p><strong>Output:</strong> <span class="example-io">[1,1]</span></p>
 * 
 * <p><strong>Explanation:</strong></p>
 * 
 * <p><img alt="" src="https://assets.leetcode.com/uploads/2024/06/28/image11.jpg" style="width: 300px; height: 70px;"></p>
 * 
 * <p>After the addition of the road from 0 to 3, the length of the shortest path from 0 to 3 is 1.</p>
 * 
 * <p><img alt="" src="https://assets.leetcode.com/uploads/2024/06/28/image12.jpg" style="width: 300px; height: 70px;"></p>
 * 
 * <p>After the addition of the road from 0 to 2, the length of the shortest path remains 1.</p>
 * </div>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>3 &lt;= n &lt;= 500</code></li>
 * 	<li><code>1 &lt;= queries.length &lt;= 500</code></li>
 * 	<li><code>queries[i].length == 2</code></li>
 * 	<li><code>0 &lt;= queries[i][0] &lt; queries[i][1] &lt; n</code></li>
 * 	<li><code>1 &lt; queries[i][1] - queries[i][0]</code></li>
 * 	<li>There are no repeated roads among the queries.</li>
 * </ul>
 * </div></div>
 */
public class ShortestDistanceAfterRoadAdditionQueriesI {
    public static void main(String[] args) {
        
    }
}

// 161ms 45.7MB
class ShortestDistanceAfterRoadAdditionQueriesI_Solution {

    // Function to find the minimum distance from node 0 to node n-1
    public int findMinDistance(List<List<Integer>> adjList, int n) {
        int[] dp = new int[n];
        dp[n - 1] = 0; // Base case: distance to destination (n-1) is 0

        // Iterate from the second last node down to the first node
        for (int currentNode = n - 2; currentNode >= 0; currentNode--) {
            int minDistance = n;
            // Explore neighbors to find the minimum distance
            for (int neighbor : adjList.get(currentNode)) {
                minDistance = Math.min(minDistance, dp[neighbor] + 1);
            }
            dp[currentNode] = minDistance; // Store the calculated distance for the current node
        }
        return dp[0];
    }

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<Integer> answer = new ArrayList<>();
        List<List<Integer>> adjList = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        // Initialize edges between consecutive nodes
        for (int i = 0; i < n - 1; i++) {
            adjList.get(i).add(i + 1);
        }

        // Process each query to add new edges
        for (int[] road : queries) {
            int u = road[0];
            int v = road[1];
            adjList.get(u).add(v); // Add the directed edge from u to v

            // Calculate the minimum distance after adding the new edge
            answer.add(findMinDistance(adjList, n));
        }

        // Convert List<Integer> to int[] before returning
        int[] result = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }

        return result; // Return the results for each query
    }
}