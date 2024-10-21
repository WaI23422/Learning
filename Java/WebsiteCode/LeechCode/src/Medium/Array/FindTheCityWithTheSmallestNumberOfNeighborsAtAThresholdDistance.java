package Medium.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
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

//37ms 44.61MB
class FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance_Solution {

    class Edge {
        int v;
        int wt;
        Edge(int a, int b) {
            v = a;
            wt = b;
        }
    }

    private int dijiktras(int s,ArrayList<Edge>[] g, int t, int n) {

        PriorityQueue<Edge> pq = new PriorityQueue<Edge>((Edge a,Edge b) -> a.wt -b.wt);
        int dis[]= new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        pq.add(new Edge(s,0));
        dis[s] =0;
       // int count =0;
       //  System.out.println(s);

         HashSet<Integer> set = new HashSet<>();
        while(!pq.isEmpty()) {
           // int v = pq.poll().v;
            Edge polled = pq.poll();
            int v = polled.v ;
            int weight = polled.wt;
          //  System.out.println("polled: "+ v +" "+ weight);
            for(Edge child: g[v]) { 
                if(dis[child.v] > weight+child.wt) {
                    dis[child.v] = weight+child.wt;
                   
                    if(dis[child.v] <= t) {
                        set.add(child.v);
                      //  System.out.println(child.v + " "+ dis[child.v]);
                        pq.add(new Edge(child.v, dis[child.v]));
                    }
                }
            }
        }

        return set.size();
    }
    @SuppressWarnings("unchecked")
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        ArrayList<Edge>[] g = new ArrayList[n];

        for(int i=0;i<n;++i) g[i] = new ArrayList<>();

        for(int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            g[u].add(new Edge(v,wt));
            g[v].add(new Edge(u,wt));
        }

        int min = Integer.MAX_VALUE;
        int index = 0;

        for(int i=0;i<n;++i) {
            int count = dijiktras(i, g, distanceThreshold, n) ;
            if(min >= count) {
                min = count;
                index = i;
            }
        
        }

        return index;
    }
}