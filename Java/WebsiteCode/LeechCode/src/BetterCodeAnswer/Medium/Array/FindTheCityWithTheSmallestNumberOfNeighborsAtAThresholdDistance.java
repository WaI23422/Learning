package BetterCodeAnswer.Medium.Array;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/">1334. Find the City With the Smallest Number of Neighbors at a Threshold Distance</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>There are <code>n</code> cities numbered from <code>0</code> to <code>n-1</code>. Given the array <code>edges</code> where <code>edges[i] = [from<sub>i</sub>, to<sub>i</sub>, weight<sub>i</sub>]</code> represents a bidirectional and weighted edge between cities <code>from<sub>i</sub></code> and <code>to<sub>i</sub></code>, and given the integer <code>distanceThreshold</code>.</p>
 * 
 * <p>Return the city with the smallest number of cities that are reachable through some path and whose distance is <strong>at most</strong> <code>distanceThreshold</code>, If there are multiple such cities, return the city with the greatest number.</p>
 * 
 * <p>Notice that the distance of a path connecting cities <em><strong>i</strong></em> and <em><strong>j</strong></em> is equal to the sum of the edges' weights along that path.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/01/16/find_the_city_01.png" style="width: 300px; height: 225px;">
 * <pre><strong>Input:</strong> n = 4, edges = [[0,1,3],[1,2,1],[1,3,4],[2,3,1]], distanceThreshold = 4
 * <strong>Output:</strong> 3
 * <strong>Explanation: </strong>The figure above describes the graph.&nbsp;
 * The neighboring cities at a distanceThreshold = 4 for each city are:
 * City 0 -&gt; [City 1, City 2]&nbsp;
 * City 1 -&gt; [City 0, City 2, City 3]&nbsp;
 * City 2 -&gt; [City 0, City 1, City 3]&nbsp;
 * City 3 -&gt; [City 1, City 2]&nbsp;
 * Cities 0 and 3 have 2 neighboring cities at a distanceThreshold = 4, but we have to return city 3 since it has the greatest number.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/01/16/find_the_city_02.png" style="width: 300px; height: 225px;">
 * <pre><strong>Input:</strong> n = 5, edges = [[0,1,2],[0,4,8],[1,2,3],[1,4,2],[2,3,1],[3,4,1]], distanceThreshold = 2
 * <strong>Output:</strong> 0
 * <strong>Explanation: </strong>The figure above describes the graph.&nbsp;
 * The neighboring cities at a distanceThreshold = 2 for each city are:
 * City 0 -&gt; [City 1]&nbsp;
 * City 1 -&gt; [City 0, City 4]&nbsp;
 * City 2 -&gt; [City 3, City 4]&nbsp;
 * City 3 -&gt; [City 2, City 4]
 * City 4 -&gt; [City 1, City 2, City 3]&nbsp;
 * The city 0 has 1 neighboring city at a distanceThreshold = 2.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>2 &lt;= n &lt;= 100</code></li>
 * 	<li><code>1 &lt;= edges.length &lt;= n * (n - 1) / 2</code></li>
 * 	<li><code>edges[i].length == 3</code></li>
 * 	<li><code>0 &lt;= from<sub>i</sub> &lt; to<sub>i</sub> &lt; n</code></li>
 * 	<li><code>1 &lt;= weight<sub>i</sub>,&nbsp;distanceThreshold &lt;= 10^4</code></li>
 * 	<li>All pairs <code>(from<sub>i</sub>, to<sub>i</sub>)</code> are distinct.</li>
 * </ul>
 * </div>
 */
public class FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance {
    public static void main(String[] args) {
        int[][][][] tests = {
            {
                {{4}},
                {
                    {0,1,3},
                    {1,2,1},
                    {1,3,4},
                    {2,3,1}
                },
                {{4}}
            }
        };

        for (int[][][] test : tests) {
            int n = test[0][0][0],
                edges[][] = test[1],
                distanceThreshold = test[2][0][0];

            System.out.println(new FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance_Solution().findTheCity(n, edges, distanceThreshold));
        }
    }
}

// 29ms 45.16MB | Dijkstra 
class FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance_Solution {

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // Adjacency list to store the graph
        @SuppressWarnings("unchecked")
        List<int[]>[] adjacencyList = new List[n];
        // Matrix to store shortest path distances from each city
        int[][] shortestPathMatrix = new int[n][n];

        // Initialize adjacency list and shortest path matrix
        for (int i = 0; i < n; i++) {
            Arrays.fill(shortestPathMatrix[i], Integer.MAX_VALUE); // Set all distances to infinity
            shortestPathMatrix[i][i] = 0; // Distance to itself is zero
            adjacencyList[i] = new ArrayList<>();
        }

        // Populate the adjacency list with edges
        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            int weight = edge[2];
            adjacencyList[start].add(new int[] { end, weight });
            adjacencyList[end].add(new int[] { start, weight }); // For undirected graph
        }

        // Compute shortest paths from each city using Dijkstra's algorithm
        for (int i = 0; i < n; i++) {
            dijkstra(n, adjacencyList, shortestPathMatrix[i], i);
        }

        // Find the city with the fewest number of reachable cities within the distance threshold
        return getCityWithFewestReachable(
            n,
            shortestPathMatrix,
            distanceThreshold
        );
    }

    // Dijkstra's algorithm to find shortest paths from a source city
    void dijkstra(
        int n,
        List<int[]>[] adjacencyList,
        int[] shortestPathDistances,
        int source
    ) {
        // Priority queue to process nodes with the smallest distance first
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) ->
            (a[1] - b[1])
        );
        priorityQueue.add(new int[] { source, 0 });
        Arrays.fill(shortestPathDistances, Integer.MAX_VALUE); // Set all distances to infinity
        shortestPathDistances[source] = 0; // Distance to source itself is zero

        // Process nodes in priority order
        while (!priorityQueue.isEmpty()) {
            int[] current = priorityQueue.remove();
            int currentCity = current[0];
            int currentDistance = current[1];
            if (currentDistance > shortestPathDistances[currentCity]) {
                continue;
            }

            // Update distances to neighboring cities
            for (int[] neighbor : adjacencyList[currentCity]) {
                int neighborCity = neighbor[0];
                int edgeWeight = neighbor[1];
                if (
                    shortestPathDistances[neighborCity] >
                    currentDistance + edgeWeight
                ) {
                    shortestPathDistances[neighborCity] = currentDistance +
                    edgeWeight;
                    priorityQueue.add(
                        new int[] {
                            neighborCity,
                            shortestPathDistances[neighborCity],
                        }
                    );
                }
            }
        }
    }

    // Determine the city with the fewest number of reachable cities within the distance threshold
    int getCityWithFewestReachable(
        int n,
        int[][] shortestPathMatrix,
        int distanceThreshold
    ) {
        int cityWithFewestReachable = -1;
        int fewestReachableCount = n;

        // Count number of cities reachable within the distance threshold for each city
        for (int i = 0; i < n; i++) {
            int reachableCount = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                } // Skip self
                if (shortestPathMatrix[i][j] <= distanceThreshold) {
                    reachableCount++;
                }
            }
            // Update the city with the fewest reachable cities
            if (reachableCount <= fewestReachableCount) {
                fewestReachableCount = reachableCount;
                cityWithFewestReachable = i;
            }
        }
        return cityWithFewestReachable;
    }
}

// 112ms 43.97mb | Bellman-Ford
class FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance_Solution2 {

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // Large value to represent infinity
        int INF = (int) 1e9 + 7;
        // Matrix to store shortest path distances from each city
        int[][] shortestPathMatrix = new int[n][n];

        // Initialize shortest path matrix
        for (int i = 0; i < n; i++) {
            Arrays.fill(shortestPathMatrix[i], INF); // Set all distances to infinity
            shortestPathMatrix[i][i] = 0; // Distance to itself is zero
        }

        // Populate the matrix with initial edge weights
        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            int weight = edge[2];
            shortestPathMatrix[start][end] = weight;
            shortestPathMatrix[end][start] = weight; // For undirected graph
        }

        // Compute shortest paths from each city using Bellman-Ford algorithm
        for (int i = 0; i < n; i++) {
            bellmanFord(n, edges, shortestPathMatrix[i], i);
        }

        // Find the city with the fewest number of reachable cities within the distance threshold
        return getCityWithFewestReachable(
            n,
            shortestPathMatrix,
            distanceThreshold
        );
    }

    // Bellman-Ford algorithm to find shortest paths from a source city
    void bellmanFord(
        int n,
        int[][] edges,
        int[] shortestPathDistances,
        int source
    ) {
        // Initialize distances from the source
        Arrays.fill(shortestPathDistances, Integer.MAX_VALUE);
        shortestPathDistances[source] = 0; // Distance to source itself is zero

        // Relax edges up to n-1 times
        for (int i = 1; i < n; i++) {
            for (int[] edge : edges) {
                int start = edge[0];
                int end = edge[1];
                int weight = edge[2];
                // Update shortest path distances if a shorter path is found
                if (
                    shortestPathDistances[start] != Integer.MAX_VALUE &&
                    shortestPathDistances[start] + weight <
                    shortestPathDistances[end]
                ) {
                    shortestPathDistances[end] = shortestPathDistances[start] +
                    weight;
                }
                if (
                    shortestPathDistances[end] != Integer.MAX_VALUE &&
                    shortestPathDistances[end] + weight <
                    shortestPathDistances[start]
                ) {
                    shortestPathDistances[start] = shortestPathDistances[end] +
                    weight;
                }
            }
        }
    }

    // Determine the city with the fewest number of reachable cities within the distance threshold
    int getCityWithFewestReachable(
        int n,
        int[][] shortestPathMatrix,
        int distanceThreshold
    ) {
        int cityWithFewestReachable = -1;
        int fewestReachableCount = n;

        // Count number of cities reachable within the distance threshold for each city
        for (int i = 0; i < n; i++) {
            int reachableCount = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                } // Skip self
                if (shortestPathMatrix[i][j] <= distanceThreshold) {
                    reachableCount++;
                }
            }
            // Update the city with the fewest reachable cities
            if (reachableCount <= fewestReachableCount) {
                fewestReachableCount = reachableCount;
                cityWithFewestReachable = i;
            }
        }
        return cityWithFewestReachable;
    }
}

// 54ms 44.9MB |  SPFA
class FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance_Solution3 {

    @SuppressWarnings("unchecked")
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // Adjacency list to store the graph
        List<int[]>[] adjacencyList = new List[n];
        // Matrix to store shortest path distances from each city
        int[][] shortestPathMatrix = new int[n][n];

        // Initialize adjacency list and shortest path matrix
        for (int i = 0; i < n; i++) {
            Arrays.fill(shortestPathMatrix[i], Integer.MAX_VALUE); // Set all distances to infinity
            shortestPathMatrix[i][i] = 0; // Distance to itself is zero
            adjacencyList[i] = new ArrayList<>();
        }

        // Populate the adjacency list with edges
        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            int weight = edge[2];
            adjacencyList[start].add(new int[] { end, weight });
            adjacencyList[end].add(new int[] { start, weight }); // For undirected graph
        }

        // Compute shortest paths from each city using SPFA algorithm
        for (int i = 0; i < n; i++) {
            spfa(n, adjacencyList, shortestPathMatrix[i], i);
        }

        // Find the city with the fewest number of reachable cities within the distance threshold
        return getCityWithFewestReachable(
            n,
            shortestPathMatrix,
            distanceThreshold
        );
    }

    // SPFA algorithm to find shortest paths from a source city
    void spfa(
        int n,
        List<int[]>[] adjacencyList,
        int[] shortestPathDistances,
        int source
    ) {
        // Queue to process nodes with updated shortest path distances
        Deque<Integer> queue = new ArrayDeque<>();
        // Array to track the number of updates for each node
        int[] updateCount = new int[n];
        queue.add(source);
        Arrays.fill(shortestPathDistances, Integer.MAX_VALUE); // Set all distances to infinity
        shortestPathDistances[source] = 0; // Distance to source itself is zero

        // Process nodes in queue
        while (!queue.isEmpty()) {
            int currentCity = queue.removeFirst();
            for (int[] neighbor : adjacencyList[currentCity]) {
                int neighborCity = neighbor[0];
                int edgeWeight = neighbor[1];

                // Update shortest path distance if a shorter path is found
                if (
                    shortestPathDistances[neighborCity] >
                    shortestPathDistances[currentCity] + edgeWeight
                ) {
                    shortestPathDistances[neighborCity] =
                        shortestPathDistances[currentCity] + edgeWeight;
                    updateCount[neighborCity]++;
                    queue.add(neighborCity);

                    // Detect negative weight cycles (not expected in this problem)
                    if (updateCount[neighborCity] > n) {
                        System.out.println("Negative weight cycle detected");
                    }
                }
            }
        }
    }

    // Determine the city with the fewest number of reachable cities within the distance threshold
    int getCityWithFewestReachable(
        int n,
        int[][] shortestPathMatrix,
        int distanceThreshold
    ) {
        int cityWithFewestReachable = -1;
        int fewestReachableCount = n;

        // Count number of cities reachable within the distance threshold for each city
        for (int i = 0; i < n; i++) {
            int reachableCount = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                } // Skip self
                if (shortestPathMatrix[i][j] <= distanceThreshold) {
                    reachableCount++;
                }
            }
            // Update the city with the fewest reachable cities
            if (reachableCount <= fewestReachableCount) {
                fewestReachableCount = reachableCount;
                cityWithFewestReachable = i;
            }
        }
        return cityWithFewestReachable;
    }
}

// 9ms 44.04MB | floyd warshall
class FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance_Solution4 {

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // Large value to represent infinity
        int INF = (int) 1e9 + 7;
        // Distance matrix to store shortest paths between all pairs of cities
        int[][] distanceMatrix = new int[n][n];

        // Initialize distance matrix
        for (int i = 0; i < n; i++) {
            Arrays.fill(distanceMatrix[i], INF); // Set all distances to infinity
            distanceMatrix[i][i] = 0; // Distance to itself is zero
        }

        // Populate the distance matrix with initial edge weights
        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            int weight = edge[2];
            distanceMatrix[start][end] = weight;
            distanceMatrix[end][start] = weight; // For undirected graph
        }

        // Compute shortest paths using Floyd-Warshall algorithm
        floyd(n, distanceMatrix);

        // Find the city with the fewest number of reachable cities within the distance threshold
        return getCityWithFewestReachable(n, distanceMatrix, distanceThreshold);
    }

    // Floyd-Warshall algorithm to compute shortest paths between all pairs of cities
    void floyd(int n, int[][] distanceMatrix) {
        // Update distances for each intermediate city
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // Update shortest path from i to j through k
                    distanceMatrix[i][j] = Math.min(
                        distanceMatrix[i][j],
                        distanceMatrix[i][k] + distanceMatrix[k][j]
                    );
                }
            }
        }
    }

    // Determine the city with the fewest number of reachable cities within the distance threshold
    int getCityWithFewestReachable(
        int n,
        int[][] distanceMatrix,
        int distanceThreshold
    ) {
        int cityWithFewestReachable = -1;
        int fewestReachableCount = n;

        // Count number of cities reachable within the distance threshold for each city
        for (int i = 0; i < n; i++) {
            int reachableCount = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                } // Skip self
                if (distanceMatrix[i][j] <= distanceThreshold) {
                    reachableCount++;
                }
            }
            // Update the city with the fewest reachable cities
            if (reachableCount <= fewestReachableCount) {
                fewestReachableCount = reachableCount;
                cityWithFewestReachable = i;
            }
        }
        return cityWithFewestReachable;
    }
}

// 7ms 44.04MB | floyd warshall
class FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance_Solution5 {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        
        // Initialize the distance matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = Integer.MAX_VALUE / 2; // Use /2 to prevent overflow
                }
            }
        }
        
        // Update the distance matrix with the edges
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            dist[u][v] = wt;
            dist[v][u] = wt;
        }
        
        // Apply Floyd-Warshall algorithm
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        
        int city = -1;
        int minCount = n;
        
        // Find the city with the smallest number of reachable cities within distanceThreshold
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && dist[i][j] <= distanceThreshold) {
                    count++;
                }
            }
            if (count < minCount) {
                minCount = count;
                city = i;
            } else if (count == minCount && i > city) {
                city = i;
            }
        }
        
        return city;
    }
}

// 5ms 44.24MB
class FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance_Solution6 {
    public int findTheCity(int n, int[][] edges, int t) {
        int m = edges.length;
        int[][] d = new int[n][n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(i!=j) {
                    d[i][j]=Integer.MAX_VALUE;
                }
            }
        }
        for(int i=0;i<m;i++) {
            if(edges[i][2]<=t) {
                d[edges[i][0]][edges[i][1]] = edges[i][2];
                d[edges[i][1]][edges[i][0]] = edges[i][2];
            }
        }
        for(int k=0;k<n;k++) {
            for(int i=0;i<n;i++) {
                if (d[i][k] == Integer.MAX_VALUE)
                    continue;
                for(int j=i;j<n;j++) {
                    if(d[k][j] < Integer.MAX_VALUE && d[i][j] > (d[i][k] + d[k][j])) {
                        d[i][j]=d[j][i] = d[i][k]+d[k][j];
                    }
                }
            }
        }
        int count=n;
        int ans = -1;
        for(int i=0;i<n;i++) {
            int c=0;
            for(int j=0;j<n;j++) {
                if(d[i][j]<=t) {
                    c++;
                }
            }
            if(c<=count) {
                count=c;
                ans=i;
            }
        }
        return ans;
    }
}