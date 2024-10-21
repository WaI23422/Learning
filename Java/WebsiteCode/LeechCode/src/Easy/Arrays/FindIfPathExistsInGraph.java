package Easy.Arrays;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/find-if-path-exists-in-graph/">1971. Find if Path Exists in Graph</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>There is a <strong>bi-directional</strong> graph with <code>n</code> vertices, where each vertex is labeled from <code>0</code> to <code>n - 1</code> (<strong>inclusive</strong>). The edges in the graph are represented as a 2D integer array <code>edges</code>, where each <code>edges[i] = [u<sub>i</sub>, v<sub>i</sub>]</code> denotes a bi-directional edge between vertex <code>u<sub>i</sub></code> and vertex <code>v<sub>i</sub></code>. Every vertex pair is connected by <strong>at most one</strong> edge, and no vertex has an edge to itself.</p>

<p>You want to determine if there is a <strong>valid path</strong> that exists from vertex <code>source</code> to vertex <code>destination</code>.</p>

<p>Given <code>edges</code> and the integers <code>n</code>, <code>source</code>, and <code>destination</code>, return <code>true</code><em> if there is a <strong>valid path</strong> from </em><code>source</code><em> to </em><code>destination</code><em>, or </em><code>false</code><em> otherwise</em><em>.</em></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/08/14/validpath-ex1.png" style="width: 141px; height: 121px;">
<pre><strong>Input:</strong> n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
<strong>Output:</strong> true
<strong>Explanation:</strong> There are two paths from vertex 0 to vertex 2:
- 0 → 1 → 2
- 0 → 2
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/08/14/validpath-ex2.png" style="width: 281px; height: 141px;">
<pre><strong>Input:</strong> n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], source = 0, destination = 5
<strong>Output:</strong> false
<strong>Explanation:</strong> There is no path from vertex 0 to vertex 5.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 2 * 10<sup>5</sup></code></li>
	<li><code>0 &lt;= edges.length &lt;= 2 * 10<sup>5</sup></code></li>
	<li><code>edges[i].length == 2</code></li>
	<li><code>0 &lt;= u<sub>i</sub>, v<sub>i</sub> &lt;= n - 1</code></li>
	<li><code>u<sub>i</sub> != v<sub>i</sub></code></li>
	<li><code>0 &lt;= source, destination &lt;= n - 1</code></li>
	<li>There are no duplicate edges.</li>
	<li>There are no self edges.</li>
</ul>
</div>
 */
public class FindIfPathExistsInGraph {
    public static void main(String[] args) {
        
    }
}

class FindIfPathExistsInGraph_Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
        
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source] = 0;
        
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        priorityQueue.offer(new int[] {0, source});
        
        while (!priorityQueue.isEmpty()) {
            int[] current = priorityQueue.poll();
            int currentDistance = current[0];
            int currentNode = current[1];
            
            if (currentNode == destination) {
                return true;
            }
            
            if (currentDistance > distances[currentNode]) {
                continue;
            }
            
            for (int neighbor : graph.getOrDefault(currentNode, new ArrayList<>())) {
                int distance = currentDistance + 1; // Assuming unweighted graph
                if (distance < distances[neighbor]) {
                    distances[neighbor] = distance;
                    priorityQueue.offer(new int[] {distance, neighbor});
                }
            }
        }
        
        return false;
    }
}