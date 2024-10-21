package Hard.Array;

import java.util.Arrays;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable/">1579. Remove Max Number of Edges to Keep Graph Fully Traversable</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Alice and Bob have an undirected graph of <code>n</code> nodes and three types of edges:</p>
 * 
 * <ul>
 * 	<li>Type 1: Can be traversed by Alice only.</li>
 * 	<li>Type 2: Can be traversed by Bob only.</li>
 * 	<li>Type 3: Can be traversed by both Alice and Bob.</li>
 * </ul>
 * 
 * <p>Given an array <code>edges</code> where <code>edges[i] = [type<sub>i</sub>, u<sub>i</sub>, v<sub>i</sub>]</code> represents a bidirectional edge of type <code>type<sub>i</sub></code> between nodes <code>u<sub>i</sub></code> and <code>v<sub>i</sub></code>, find the maximum number of edges you can remove so that after removing the edges, the graph can still be fully traversed by both Alice and Bob. The graph is fully traversed by Alice and Bob if starting from any node, they can reach all other nodes.</p>
 * 
 * <p>Return <em>the maximum number of edges you can remove, or return</em> <code>-1</code> <em>if Alice and Bob cannot fully traverse the graph.</em></p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <p><strong><img alt="" src="https://assets.leetcode.com/uploads/2020/08/19/ex1.png" style="width: 179px; height: 191px;"></strong></p>
 * 
 * <pre><strong>Input:</strong> n = 4, edges = [[3,1,2],[3,2,3],[1,1,3],[1,2,4],[1,1,2],[2,3,4]]
 * <strong>Output:</strong> 2
 * <strong>Explanation: </strong>If we remove the 2 edges [1,1,2] and [1,1,3]. The graph will still be fully traversable by Alice and Bob. Removing any additional edge will not make it so. So the maximum number of edges we can remove is 2.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <p><strong><img alt="" src="https://assets.leetcode.com/uploads/2020/08/19/ex2.png" style="width: 178px; height: 190px;"></strong></p>
 * 
 * <pre><strong>Input:</strong> n = 4, edges = [[3,1,2],[3,2,3],[1,1,4],[2,1,4]]
 * <strong>Output:</strong> 0
 * <strong>Explanation: </strong>Notice that removing any edge will not make the graph fully traversable by Alice and Bob.
 * </pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <p><strong><img alt="" src="https://assets.leetcode.com/uploads/2020/08/19/ex3.png" style="width: 178px; height: 190px;"></strong></p>
 * 
 * <pre><strong>Input:</strong> n = 4, edges = [[3,2,3],[1,1,2],[2,3,4]]
 * <strong>Output:</strong> -1
 * <b>Explanation: </b>In the current graph, Alice cannot reach node 4 from the other nodes. Likewise, Bob cannot reach 1. Therefore it's impossible to make the graph fully traversable.</pre>
 * 
 * <p>&nbsp;</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>1 &lt;= edges.length &lt;= min(10<sup>5</sup>, 3 * n * (n - 1) / 2)</code></li>
 * 	<li><code>edges[i].length == 3</code></li>
 * 	<li><code>1 &lt;= type<sub>i</sub> &lt;= 3</code></li>
 * 	<li><code>1 &lt;= u<sub>i</sub> &lt; v<sub>i</sub> &lt;= n</code></li>
 * 	<li>All tuples <code>(type<sub>i</sub>, u<sub>i</sub>, v<sub>i</sub>)</code> are distinct.</li>
 * </ul>
 * </div>
 */
public class RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable {
    public static void main(String[] args) {
        int[][][][] tests = {
            {
                {
                    {3,1,2},
                    {3,2,3},
                    {1,1,3},
                    {1,2,4},
                    {1,1,2},
                    {2,3,4}
                }
                ,
                {{4}}
            }
        };

        for (int[][][] test : tests) {
            int n = test[1][0][0],
                edges[][] = test[0];

            System.out.println(new RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable_Solution().maxNumEdgesToRemove(n, edges));
        }
    }
}

// 30 ms 88.5 MB
class RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable_Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        Arrays.sort(edges,(a,b)-> Integer.compare(b[0],a[0]));
        int[] parA = new int[n+1];
        int[] rankA = new int[n+1];
        int[] parB = new int[n+1];
        int[] rankB = new int[n+1];
        for(int i = 1; i<=n; i++){
            parA[i] = parB[i] = i;
            rankA[i] = rankB[i] = 1;
        }
        int countA = 1;
        int countB = 1;
        int ans = 0;
        for(int i = 0; i<edges.length; i++){
            int type = edges[i][0];
            int x = edges[i][1];
            int y = edges[i][2];
            if(type == 3){
                boolean mergeA = union(x,y,parA,rankA);
                boolean mergeB = union(x,y,parB,rankB);
                if(mergeA == false && mergeB == false){
                    ans++;
                }
                else{
                    if(mergeA == true) countA++;
                    if(mergeB == true) countB++;
                }
            }
            else if(type == 2){
                boolean mergeB = union(x,y,parB,rankB);
                if(mergeB == false){
                    ans++;
                }
                else{
                    countB++;
                }
            }
            else{
                boolean mergeA = union(x,y,parA,rankA);
                if(mergeA == false){
                    ans++;
                }
                else{
                    countA++;
                }
            }
        }
        if(countA != n || countB != n) return -1;
        return ans;
    }
    public boolean union(int x, int y, int[] par, int[] rank){
        int Px = find(x,par);
        int Py = find(y,par);
        if(Px == Py) return false;
        if(rank[Px] > rank[Py]) par[Py] = Px;
        else if(rank[Py] > rank[Px]) par[Px] = Py;
        else{
            par[Py] = Px;
            rank[Px]++;
        }
        return true;
    }
    public int find(int x, int[] par){
        if(par[x] == x) return x;
        int temp = find(par[x], par);
        par[x] = temp;
        return temp;
    }
}