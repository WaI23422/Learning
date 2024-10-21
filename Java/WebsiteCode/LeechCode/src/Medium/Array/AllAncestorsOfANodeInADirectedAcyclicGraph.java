package Medium.Array;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/all-ancestors-of-a-node-in-a-directed-acyclic-graph/">2192. All Ancestors of a Node in a Directed Acyclic Graph</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You are given a positive integer <code>n</code> representing the number of nodes of a <strong>Directed Acyclic Graph</strong> (DAG). The nodes are numbered from <code>0</code> to <code>n - 1</code> (<strong>inclusive</strong>).</p>
 * 
 * <p>You are also given a 2D integer array <code>edges</code>, where <code>edges[i] = [from<sub>i</sub>, to<sub>i</sub>]</code> denotes that there is a <strong>unidirectional</strong> edge from <code>from<sub>i</sub></code> to <code>to<sub>i</sub></code> in the graph.</p>
 * 
 * <p>Return <em>a list</em> <code>answer</code><em>, where </em><code>answer[i]</code><em> is the <strong>list of ancestors</strong> of the</em> <code>i<sup>th</sup></code> <em>node, sorted in <strong>ascending order</strong></em>.</p>
 * 
 * <p>A node <code>u</code> is an <strong>ancestor</strong> of another node <code>v</code> if <code>u</code> can reach <code>v</code> via a set of edges.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2019/12/12/e1.png" style="width: 322px; height: 265px;">
 * <pre><strong>Input:</strong> n = 8, edgeList = [[0,3],[0,4],[1,3],[2,4],[2,7],[3,5],[3,6],[3,7],[4,6]]
 * <strong>Output:</strong> [[],[],[],[0,1],[0,2],[0,1,3],[0,1,2,3,4],[0,1,2,3]]
 * <strong>Explanation:</strong>
 * The above diagram represents the input graph.
 * - Nodes 0, 1, and 2 do not have any ancestors.
 * - Node 3 has two ancestors 0 and 1.
 * - Node 4 has two ancestors 0 and 2.
 * - Node 5 has three ancestors 0, 1, and 3.
 * - Node 6 has five ancestors 0, 1, 2, 3, and 4.
 * - Node 7 has four ancestors 0, 1, 2, and 3.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2019/12/12/e2.png" style="width: 343px; height: 299px;">
 * <pre><strong>Input:</strong> n = 5, edgeList = [[0,1],[0,2],[0,3],[0,4],[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
 * <strong>Output:</strong> [[],[0],[0,1],[0,1,2],[0,1,2,3]]
 * <strong>Explanation:</strong>
 * The above diagram represents the input graph.
 * - Node 0 does not have any ancestor.
 * - Node 1 has one ancestor 0.
 * - Node 2 has two ancestors 0 and 1.
 * - Node 3 has three ancestors 0, 1, and 2.
 * - Node 4 has four ancestors 0, 1, 2, and 3.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= n &lt;= 1000</code></li>
 * 	<li><code>0 &lt;= edges.length &lt;= min(2000, n * (n - 1) / 2)</code></li>
 * 	<li><code>edges[i].length == 2</code></li>
 * 	<li><code>0 &lt;= from<sub>i</sub>, to<sub>i</sub> &lt;= n - 1</code></li>
 * 	<li><code>from<sub>i</sub> != to<sub>i</sub></code></li>
 * 	<li>There are no duplicate edges.</li>
 * 	<li>The graph is <strong>directed</strong> and <strong>acyclic</strong>.</li>
 * </ul>
 * </div>
 */
public class AllAncestorsOfANodeInADirectedAcyclicGraph {
    public static void main(String[] args) {
        int[][][][] tests = {
            {
                {
                    {0,3},
                    {0,4},
                    {1,3},
                    {2,4},
                    {2,7},
                    {3,5},
                    {3,6},
                    {3,7},
                    {4,6}
                },
                {{8}}
            },
        };    

        for (int[][][] test : tests) {
            int n = test[1][0][0],
                edges[][] = test[0];

            List<List<Integer>> abs = new AllAncestorsOfANodeInADirectedAcyclicGraph_Solution().getAncestors(n, edges);

            System.out.println(Arrays.toString(abs.toArray()));
        }
    }
}

// Time Limit Exceeded
class AllAncestorsOfANodeInADirectedAcyclicGraph_Solution {
    List<List<Integer>> ancestorsList;
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        ancestorsList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ancestorsList.add(new ArrayList<>());
        }       

        for (int[] edge : edges) {
            int from = edge[0],
                to = edge[1];
            ancestorsList.get(to).add(from);
        }

        for (int i = 0; i < n; i++) {
            List<Integer> ancestorList = ancestorsList.get(i);

            Queue<Integer> ancestor = new ArrayDeque<>(){
                {addAll(ancestorList);}
            };
            // Add ancestor:
            while (!ancestor.isEmpty()) {
                List<Integer> preAncestorList = ancestorsList.get(ancestor.poll());
                if (preAncestorList.size() == 0) {continue;}

                for (Integer anc : preAncestorList) {
                    if (!ancestorList.contains(anc)) {
                        ancestorList.add(anc);
                        ancestor.add(anc);
                    }
                }
            }
        }
        
        for (List<Integer> ancestorList : ancestorsList) {
            ancestorList.sort(null);
        }   
        return ancestorsList;
    }
}

// 45 ms 65.2 MB
class AllAncestorsOfANodeInADirectedAcyclicGraph_Solution2 {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> ans = new ArrayList<>();
        @SuppressWarnings("unchecked")
        List<Integer>[] graph = new List[n];
  
        for (int i = 0; i < n; ++i) {
            ans.add(new ArrayList<>());
            graph[i] = new ArrayList<>();
        }
    
        for (int[] edge : edges) {
            final int u = edge[0];
            final int v = edge[1];
            graph[u].add(v);
        }
    
        for (int i = 0; i < n; ++i)
            dfs(graph, i, i, new boolean[n], ans);
    
        return ans;
    }
  
    private void dfs(List<Integer>[] graph, int u, int ancestor, boolean[] seen,
                     List<List<Integer>> ans) {
        seen[u] = true;
        for (final int v : graph[u]) {
            if (seen[v]) {continue;}
            ans.get(v).add(ancestor);
            dfs(graph, v, ancestor, seen, ans);
        }
    }
}
  
  