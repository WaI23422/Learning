package BetterCodeAnswer.Hard.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/second-minimum-time-to-reach-destination/">2045. Second Minimum Time to Reach Destination</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>A city is represented as a <strong>bi-directional connected</strong> graph with <code>n</code> vertices where each vertex is labeled from <code>1</code> to <code>n</code> (<strong>inclusive</strong>). The edges in the graph are represented as a 2D integer array <code>edges</code>, where each <code>edges[i] = [u<sub>i</sub>, v<sub>i</sub>]</code> denotes a bi-directional edge between vertex <code>u<sub>i</sub></code> and vertex <code>v<sub>i</sub></code>. Every vertex pair is connected by <strong>at most one</strong> edge, and no vertex has an edge to itself. The time taken to traverse any edge is <code>time</code> minutes.</p>
 * 
 * <p>Each vertex has a traffic signal which changes its color from <strong>green</strong> to <strong>red</strong> and vice versa every&nbsp;<code>change</code> minutes. All signals change <strong>at the same time</strong>. You can enter a vertex at <strong>any time</strong>, but can leave a vertex <strong>only when the signal is green</strong>. You <strong>cannot wait </strong>at a vertex if the signal is <strong>green</strong>.</p>
 * 
 * <p>The <strong>second minimum value</strong> is defined as the smallest value<strong> strictly larger </strong>than the minimum value.</p>
 * 
 * <ul>
 * 	<li>For example the second minimum value of <code>[2, 3, 4]</code> is <code>3</code>, and the second minimum value of <code>[2, 2, 4]</code> is <code>4</code>.</li>
 * </ul>
 * 
 * <p>Given <code>n</code>, <code>edges</code>, <code>time</code>, and <code>change</code>, return <em>the <strong>second minimum time</strong> it will take to go from vertex </em><code>1</code><em> to vertex </em><code>n</code>.</p>
 * 
 * <p><strong>Notes:</strong></p>
 * 
 * <ul>
 * 	<li>You can go through any vertex <strong>any</strong> number of times, <strong>including</strong> <code>1</code> and <code>n</code>.</li>
 * 	<li>You can assume that when the journey <strong>starts</strong>, all signals have just turned <strong>green</strong>.</li>
 * </ul>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/09/29/e1.png" style="width: 200px; height: 250px;">        <img alt="" src="https://assets.leetcode.com/uploads/2021/09/29/e2.png" style="width: 200px; height: 250px;">
 * <pre><strong>Input:</strong> n = 5, edges = [[1,2],[1,3],[1,4],[3,4],[4,5]], time = 3, change = 5
 * <strong>Output:</strong> 13
 * <strong>Explanation:</strong>
 * The figure on the left shows the given graph.
 * The blue path in the figure on the right is the minimum time path.
 * The time taken is:
 * - Start at 1, time elapsed=0
 * - 1 -&gt; 4: 3 minutes, time elapsed=3
 * - 4 -&gt; 5: 3 minutes, time elapsed=6
 * Hence the minimum time needed is 6 minutes.
 * 
 * The red path shows the path to get the second minimum time.
 * - Start at 1, time elapsed=0
 * - 1 -&gt; 3: 3 minutes, time elapsed=3
 * - 3 -&gt; 4: 3 minutes, time elapsed=6
 * - Wait at 4 for 4 minutes, time elapsed=10
 * - 4 -&gt; 5: 3 minutes, time elapsed=13
 * Hence the second minimum time is 13 minutes.      
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/09/29/eg2.png" style="width: 225px; height: 50px;">
 * <pre><strong>Input:</strong> n = 2, edges = [[1,2]], time = 3, change = 2
 * <strong>Output:</strong> 11
 * <strong>Explanation:</strong>
 * The minimum time path is 1 -&gt; 2 with time = 3 minutes.
 * The second minimum time path is 1 -&gt; 2 -&gt; 1 -&gt; 2 with time = 11 minutes.</pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>2 &lt;= n &lt;= 10<sup>4</sup></code></li>
 * 	<li><code>n - 1 &lt;= edges.length &lt;= min(2 * 10<sup>4</sup>, n * (n - 1) / 2)</code></li>
 * 	<li><code>edges[i].length == 2</code></li>
 * 	<li><code>1 &lt;= u<sub>i</sub>, v<sub>i</sub> &lt;= n</code></li>
 * 	<li><code>u<sub>i</sub> != v<sub>i</sub></code></li>
 * 	<li>There are no duplicate edges.</li>
 * 	<li>Each vertex can be reached directly or indirectly from every other vertex.</li>
 * 	<li><code>1 &lt;= time, change &lt;= 10<sup>3</sup></code></li>
 * </ul>
 * </div>
 */
public class SecondMinimumTimeToReachDestination {
    public static void main(String[] args) {
        int[][][][] tests = {
            {
                {{5}},
                {
                    {1,2},
                    {1,3},
                    {1,4},
                    {3,4},
                    {4,5}
                },
                {{3}},
                {{5}}
            }
        };

        for (int[][][] test : tests) {
            int n = test[0][0][0],
                edges[][] = test[1],
                time = test[2][0][0],
                change = test[3][0][0];
            
            System.out.println(new SecondMinimumTimeToReachDestination_Solution().secondMinimum(n, edges, time, change));
        }
    }
}

// 80ms 55.54MB
class SecondMinimumTimeToReachDestination_Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            adj.computeIfAbsent(a, value -> new ArrayList<Integer>()).add(b);
            adj.computeIfAbsent(b, value -> new ArrayList<Integer>()).add(a);
        }
        int[] dist1 = new int[n + 1], dist2 = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dist1[i] = dist2[i] = -1;
        }
        Queue<int[]> queue = new LinkedList<>();
        // Start with node 1, with its minimum distance.
        queue.offer(new int[] { 1, 1 });
        dist1[1] = 0;

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int node = temp[0];
            int freq = temp[1];

            int timeTaken = freq == 1 ? dist1[node] : dist2[node];
            // If the time_taken falls under the red bracket, wait till the path turns
            // green.
            if ((timeTaken / change) % 2 == 1) {
                timeTaken = change * (timeTaken / change + 1) + time;
            } else {
                timeTaken = timeTaken + time;
            }

            if (!adj.containsKey(node))
                continue;
            for (int neighbor : adj.get(node)) {
                if (dist1[neighbor] == -1) {
                    dist1[neighbor] = timeTaken;
                    queue.offer(new int[] { neighbor, 1 });
                } else if (dist2[neighbor] == -1 && dist1[neighbor] != timeTaken) {
                    if (neighbor == n)
                        return timeTaken;
                    dist2[neighbor] = timeTaken;
                    queue.offer(new int[] { neighbor, 2 });
                }
            }

        }
        return 0;
    }
}

// 37ms 56.5MB
class SecondMinimumTimeToReachDestination_Solution2 {
    @SuppressWarnings("unchecked")
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        /**
            1. traffic light is global
                - if a departs before b, a will always arrive first
                    - if a delays bc of red light, b will be delayed as well 
                - carry the time forward
                - round=curTime/change
                    - if round is even, then it is green
                        - nextTime=curTime+time
                    - if round is odd, then it is red
                        - wait
                        - nextTime=curTime+2*time, (round+1)*change+time
            2. the question is asking for second minimum time
                - if A->...->B1->...->C, a second minumum time would be
                    - A->...->B1->...->B2->...-->C
                    - a node can be visited twice
            3. use an timeArr to keep track of the 2nd minimum time for every node
                - bfs into next only timeArr[i]<nextTime
         */

        List<Integer>[] graph= new ArrayList[n+1];
        for(int i=0;i<n+1;i++) graph[i]=new ArrayList<>();
        for(int[] edge:edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        
        Deque<int[]> deque=new LinkedList<>();
        int[] visitedNum=new int[n+1];
        int[] timeArr=new int[n+1];
        Arrays.fill(timeArr,-1);
        deque.offerLast(new int[]{1,0});
        timeArr[0]=0;

        while(deque.size()>0){
            int curSize=deque.size();
            for(int i=0;i<curSize;i++){
                int[] cur=deque.pollFirst();
                //if(cur[0]==n && visitedNum[cur[0]]==2) return cur[1];
                
                int nextTime=0;
                int curLight=cur[1]/change;
                if(curLight%2==0){
                    nextTime=cur[1]+time;
                }
                //nextTime=(curLight+1)*change+time;
                else nextTime=(curLight+1)*change+time;

                for(int nextNode:graph[cur[0]]){
                    if(visitedNum[nextNode]<2 && timeArr[nextNode]<nextTime){
                        deque.offerLast(new int[]{nextNode,nextTime});
                        visitedNum[nextNode]++;
                        timeArr[nextNode]=nextTime;
                        if(nextNode==n && visitedNum[nextNode]==2) return nextTime; 
                    }    
                }
                
            }
        }
        return -1;
    }
}