package BetterCodeAnswer.Hard.Array;

import java.util.Arrays;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/sum-of-distances-in-tree/">834. Sum of Distances in Tree</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>There is an undirected connected tree with <code>n</code> nodes labeled from <code>0</code> to <code>n - 1</code> and <code>n - 1</code> edges.</p>

<p>You are given the integer <code>n</code> and the array <code>edges</code> where <code>edges[i] = [a<sub>i</sub>, b<sub>i</sub>]</code> indicates that there is an edge between nodes <code>a<sub>i</sub></code> and <code>b<sub>i</sub></code> in the tree.</p>

<p>Return an array <code>answer</code> of length <code>n</code> where <code>answer[i]</code> is the sum of the distances between the <code>i<sup>th</sup></code> node in the tree and all other nodes.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/07/23/lc-sumdist1.jpg" style="width: 304px; height: 224px;">
<pre><strong>Input:</strong> n = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
<strong>Output:</strong> [8,12,6,10,10,10]
<strong>Explanation:</strong> The tree is shown above.
We can see that dist(0,1) + dist(0,2) + dist(0,3) + dist(0,4) + dist(0,5)
equals 1 + 1 + 2 + 2 + 2 = 8.
Hence, answer[0] = 8, and so on.
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/07/23/lc-sumdist2.jpg" style="width: 64px; height: 65px;">
<pre><strong>Input:</strong> n = 1, edges = []
<strong>Output:</strong> [0]
</pre>

<p><strong class="example">Example 3:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/07/23/lc-sumdist3.jpg" style="width: 144px; height: 145px;">
<pre><strong>Input:</strong> n = 2, edges = [[1,0]]
<strong>Output:</strong> [1,1]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 3 * 10<sup>4</sup></code></li>
	<li><code>edges.length == n - 1</code></li>
	<li><code>edges[i].length == 2</code></li>
	<li><code>0 &lt;= a<sub>i</sub>, b<sub>i</sub> &lt; n</code></li>
	<li><code>a<sub>i</sub> != b<sub>i</sub></code></li>
	<li>The given input represents a valid tree.</li>
</ul>
</div>
 */
public class SumOfDistancesInTree {
    public static void main(String[] args) {
        
    }
}

// 17 ms 61.44 MB
class SumOfDistancesInTree_Solution {
    int[][] graph;
    int[] count;
    int[] res;
    int N;
    
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        this.N = N;
        this.res = new int[N];
        this.graph = new int[N][];
        this.count = new int[N];
        
        for (int[] e : edges) {
            ++count[e[0]];
            ++count[e[1]];
        }
        for (int i = 0; i < N; i++) {
            graph[i] = new int[count[i]];
        }
        for (int[] e : edges) {
            graph[e[0]][--count[e[0]]] = e[1];
            graph[e[1]][--count[e[1]]] = e[0];
        }
        dfs1(0, -1);
        dfs2(0, -1);
        return res;
    }
    public void dfs1(int cur, int parent) {
        count[cur] = 1;
        for (int child : graph[cur]) {
            if (child != parent) {
                dfs1(child, cur);
                count[cur] += count[child];
                res[cur] += res[child] + count[child];
            }
        }
    }
    public void dfs2(int cur, int parent) {
        for (int child : graph[cur]) {
            if (child != parent) {
                res[child] = res[cur] + N - 2 * count[child];
                dfs2(child, cur);
            }
        }
    }
}

// 25 ms 57.7 MB
class SumOfDistancesInTree_Solution2 {
    static final int MAX = 30000;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        int[][] tree = tree(n, edges);
        int[] parents = parents(tree);
        return solve(tree, parents);
    }

    static final int[] parents(int[][] tree) {
        final int[] p = new int[tree.length];
        for (int i = 0; i < tree.length; i++) {
            for (int c : tree[i]) {
                p[c] = i;
            }
        }
        p[0] = -1;
        return p;
    }

    static final int[] computRes(int[][] tree) {
        final int[] p = new int[tree.length];
        for (int i = 0; i < tree.length; i++) {
            for (int c : tree[i]) {
                p[c] = i;
            }
        }
        p[0] = -1;
        return p;
    }

    static final int[] solve(int[][] tree, int[] parents) {
        int len = 0;
        int[] distance = new int[tree.length];
        int[] children = new int[tree.length];
        for (int i = 0; i < tree.length; i++) {
            final int tl = tree[i].length;
            if (tl == 0) {
                q[len++] = i;
            } else {
                counts[i] = tl;
            }
        }
        for (int i = 0; i < len; i++) {
            final int node = q[i];
            final int parent = parents[node];
            if (parent >= 0) {
                final int newChildren = children[node] + 1;
                children[parent] += newChildren;
                distance[parent] += distance[node] + newChildren;
                if (--counts[parent] == 0) {
                    q[len++] = parent;
                }
            }
        }
        len = 0;
        for (int next : tree[0]) {
            q[len++] = next;
        }
        for (int i = 0; i < len; i++) {
            final int node = q[i];
            final int parent = parents[node];
            distance[node] = distance[parent] - 2 * (children[node] + 1) + tree.length;
            for (int next : tree[node]) q[len++] = next;
        }
        return distance;
    }

    static final int[] q = new int[MAX];
    static final int[] counts = new int[MAX];

    static int[][] tree(final int n, final int[][] edges) {
        for (int[] e : edges) {
            counts[e[0]]++;
            counts[e[1]]++;
        }
        final int[][] r = new int[n][];
        for (int i = 0; i < n; i++) r[i] = new int[counts[i]];
        for (int[] e : edges) {
            final int n1 = e[0];
            final int n2 = e[1];
            r[n1][--counts[n1]] = n2;
            r[n2][--counts[n2]] = n1;
        }
        //System.out.println("next: " + Arrays.deepToString(r));
        return filter(r);
    }

    private static int[][] filter(int[][] a) {
        final boolean[] visited = new boolean[a.length];
        int qLen = 0;
        q[qLen++] = 0;
        visited[0] = true;
        for (int i = 0; i < qLen; i++) {
            final int node = q[i];
            final int[] r = a[node];
            int len = 0;
            for (int n : r) {
                if (!visited[n]) {
                    visited[n] = true;
                    q[qLen++] = n;
                    r[len++] = n;
                }
            }
            a[node] = Arrays.copyOf(r, len);
        }
        return a;
    }
}