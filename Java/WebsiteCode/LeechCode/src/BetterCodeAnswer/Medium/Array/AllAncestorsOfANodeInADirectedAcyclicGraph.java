package BetterCodeAnswer.Medium.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

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

// 84 ms 96.7 MB
class AllAncestorsOfANodeInADirectedAcyclicGraph_Solution {

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        // Create adjacency list
        @SuppressWarnings("unchecked")
        List<Integer>[] adjacencyList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        // Fill the adjacency list and indegree array based on the edges
        int[] indegree = new int[n];
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            adjacencyList[from].add(to);
            indegree[to]++;
        }

        // Queue for nodes with no incoming edges (starting points for topological sort)
        Queue<Integer> nodesWithZeroIndegree = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                nodesWithZeroIndegree.add(i);
            }
        }

        // List to store the topological order of nodes
        List<Integer> topologicalOrder = new ArrayList<>();
        while (!nodesWithZeroIndegree.isEmpty()) {
            int currentNode = nodesWithZeroIndegree.poll();
            topologicalOrder.add(currentNode);

            // Reduce indegree of neighboring nodes and add them to the queue
            // if they have no more incoming edges
            for (int neighbor : adjacencyList[currentNode]) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    nodesWithZeroIndegree.add(neighbor);
                }
            }
        }

        // Initialize the result list and set list for storing ancestors
        List<List<Integer>> ancestorsList = new ArrayList<>();
        List<Set<Integer>> ancestorsSetList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ancestorsList.add(new ArrayList<>());
            ancestorsSetList.add(new HashSet<>());
        }

        // Fill the set list with ancestors using the topological order
        for (int node : topologicalOrder) {
            for (int neighbor : adjacencyList[node]) {
                // Add immediate parent, and other ancestors.
                ancestorsSetList.get(neighbor).add(node);
                ancestorsSetList
                    .get(neighbor)
                    .addAll(ancestorsSetList.get(node));
            }
        }

        // Convert sets to lists and sort them
        for (int i = 0; i < ancestorsList.size(); i++) {
            ancestorsList.get(i).addAll(ancestorsSetList.get(i));
            Collections.sort(ancestorsList.get(i));
        }

        return ancestorsList;
    }
}

// 62 ms 65.2 MB
class AllAncestorsOfANodeInADirectedAcyclicGraph_Solution2 {

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        // Initialize adjacency list for each node and ancestors list
        @SuppressWarnings("unchecked")
        List<Integer>[] adjacencyList = new ArrayList[n];
        List<List<Integer>> ancestors = new ArrayList<>();

        // Initialize adjacency list and ancestors list for each node
        for (int i = 0; i < n; i++) {
            adjacencyList[i] = new ArrayList<>();
            ancestors.add(new ArrayList<>());
        }

        // Populate the adjacency list with edges
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            adjacencyList[from].add(to);
        }

        // Perform DFS for each node to find all its ancestors
        for (int i = 0; i < n; i++) {
            findAncestorsDFS(i, adjacencyList, i, ancestors);
        }

        return ancestors;
    }

    // Helper method to perform DFS and find ancestors
    private void findAncestorsDFS(
        int ancestor,
        List<Integer>[] adjacencyList,
        int currentNode,
        List<List<Integer>> ancestors
    ) {
        for (int childNode : adjacencyList[currentNode]) {
            // Check if the ancestor is already added to avoid duplicates
            if (
                ancestors.get(childNode).isEmpty() ||
                ancestors
                        .get(childNode)
                        .get(ancestors.get(childNode).size() - 1) !=
                    ancestor
            ) {
                ancestors.get(childNode).add(ancestor);
                findAncestorsDFS(ancestor, adjacencyList, childNode, ancestors);
            }
        }
    }
}

// 224 ms 64.8 MB
class AllAncestorsOfANodeInADirectedAcyclicGraph_Solution3 {

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        // Initialize adjacency list for the graph
        @SuppressWarnings("unchecked")
        List<Integer>[] adjacencyList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        // Populate the adjacency list with reversed edges
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            adjacencyList[to].add(from);
        }

        List<List<Integer>> ancestorsList = new ArrayList<>();

        // For each node, find all its ancestors (children in reversed graph)
        for (int i = 0; i < n; i++) {
            List<Integer> ancestors = new ArrayList<>();
            Set<Integer> visited = new HashSet<>();
            findChildren(i, adjacencyList, visited);
            // Add visited nodes to the current nodes' ancestor list
            for (int node = 0; node < n; node++) {
                if (node == i) continue;
                if (visited.contains(node)) ancestors.add(node);
            }
            ancestorsList.add(ancestors);
        }

        return ancestorsList;
    }

    // Helper method to perform DFS and find all children of a given node
    private void findChildren(
        int currentNode,
        List<Integer>[] adjacencyList,
        Set<Integer> visitedNodes
    ) {
        // Mark current node as visited
        visitedNodes.add(currentNode);

        // Recursively traverse all neighbors
        for (int neighbour : adjacencyList[currentNode]) {
            if (!visitedNodes.contains(neighbour)) {
                findChildren(neighbour, adjacencyList, visitedNodes);
            }
        }
    }
}

// 33 ms 66.1 MB
class AllAncestorsOfANodeInADirectedAcyclicGraph_Solution4 {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0; i<n; i++){
            res.add(new ArrayList<>());
        } 

        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] graph=new ArrayList[n];
        for(int i=0; i<n; i++){
            graph[i]=new ArrayList<>();
        }   
        for(int[] edge: edges){
            graph[edge[0]].add(edge[1]);
        }
        for(int i=0; i<n; i++){
            dfs(graph,i,i,res,new boolean[n]);
        }
        return res;
    }
    public void dfs( ArrayList<Integer>[] graph, int parent, int curr, List<List<Integer>> res,boolean[] visit){
        visit[curr]=true;
        for(int i=0; i< graph[curr].size(); i++){
            int dest=graph[curr].get(i);
            if(!visit[dest]){
                res.get(dest).add(parent);
                dfs(graph,parent,dest,res,visit);
            }
        }
    }
}