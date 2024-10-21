package BetterCodeAnswer.Hard.Array;

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

class RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable_Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind alice = new UnionFind(n);
        UnionFind bob = new UnionFind(n);

        
        int edgesRequired = 0;
        for(int[] edge : edges) {
            if(edge[0]==3) {
                edgesRequired+= (alice.preformUnion(edge[1], edge[2]) | bob.preformUnion(edge[1], edge[2]));
            }
        }

        for(int[] edge : edges) {
            if(edge[0]==2) {
                edgesRequired += bob.preformUnion(edge[1], edge[2]);
            } else if(edge[0]==1) {
                edgesRequired += alice.preformUnion(edge[1], edge[2]);
            }
        }

        if(alice.isConnected() && bob.isConnected()) {
            return edges.length - edgesRequired;
        }

        return -1;

    }

    class UnionFind {

        int[] representative;
        int[] componentSize;
        int components;

        UnionFind(int n) {
            components = n;
            representative = new int[n+1];
            componentSize = new int[n+1];

            for(int i=0;i<=n;i++) {
                representative[i] = i;
                componentSize[i] = i;
            }
        }

        int findRepresentative(int x) {
            if(representative[x] == x) {
                return x;
            }

            return representative[x] = findRepresentative(representative[x]);
        }

        int preformUnion(int x, int y) {
            x = findRepresentative(x); y = findRepresentative(y);

            if(x==y) {
                return 0;
            }

            if(componentSize[x]>componentSize[y]) {
                componentSize[x]+=componentSize[y];
                representative[y] = x;
            } else {
                componentSize[y]+=componentSize[x];
                representative[x] = y;
            }

            components--;
            return 1;
        }

        boolean isConnected() {
            return components==1;
        }
    }    
}

// 10 ms 108.1 MB
class RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable_Solution2 {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind alice = new UnionFind(n);
        UnionFind bob = new UnionFind(n);
        
        int edgesRequired = 0;
        for(int[] edge : edges) {
            if(edge[0]==3) {
                edgesRequired+= (alice.preformUnion(edge[1], edge[2]) | bob.preformUnion(edge[1], edge[2]));
            }
        }

        for(int[] edge : edges) {
            if(edge[0]==2) {
                edgesRequired += bob.preformUnion(edge[1], edge[2]);
            } else if(edge[0]==1) {
                edgesRequired += alice.preformUnion(edge[1], edge[2]);
            }
        }

        if(alice.isConnected() && bob.isConnected()) {
            return edges.length - edgesRequired;
        }

        return -1;

    }

    class UnionFind {

        int[] representative;
        int[] componentSize;
        int components;

        UnionFind(int n) {
            components = n;
            representative = new int[n+1];
            componentSize = new int[n+1];

            for(int i=0;i<=n;i++) {
                representative[i] = i;
                componentSize[i] = i;
            }
        }

        int findRepresentative(int x) {
            if(representative[x] == x) {
                return x;
            }

            return representative[x] = findRepresentative(representative[x]);
        }

        int preformUnion(int x, int y) {
            x = findRepresentative(x); y = findRepresentative(y);

            if(x==y) {
                return 0;
            }

            if(componentSize[x]>componentSize[y]) {
                componentSize[x]+=componentSize[y];
                representative[y] = x;
            } else {
                componentSize[y]+=componentSize[x];
                representative[x] = y;
            }

            components--;
            return 1;
        }

        boolean isConnected() {
            return components==1;
        }
    }    
}