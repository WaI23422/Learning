package BetterCodeAnswer.Medium.Array;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/minimum-height-trees/">310. Minimum Height Trees</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>A tree is an undirected graph in which any two vertices are connected by&nbsp;<i>exactly</i>&nbsp;one path. In other words, any connected graph without simple cycles is a tree.</p>

<p>Given a tree of <code>n</code> nodes&nbsp;labelled from <code>0</code> to <code>n - 1</code>, and an array of&nbsp;<code>n - 1</code>&nbsp;<code>edges</code> where <code>edges[i] = [a<sub>i</sub>, b<sub>i</sub>]</code> indicates that there is an undirected edge between the two nodes&nbsp;<code>a<sub>i</sub></code> and&nbsp;<code>b<sub>i</sub></code> in the tree,&nbsp;you can choose any node of the tree as the root. When you select a node <code>x</code> as the root, the result tree has height <code>h</code>. Among all possible rooted trees, those with minimum height (i.e. <code>min(h)</code>)&nbsp; are called <strong>minimum height trees</strong> (MHTs).</p>

<p>Return <em>a list of all <strong>MHTs'</strong> root labels</em>.&nbsp;You can return the answer in <strong>any order</strong>.</p>

<p>The <strong>height</strong> of a rooted tree is the number of edges on the longest downward path between the root and a leaf.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/09/01/e1.jpg" style="width: 800px; height: 213px;">
<pre><strong>Input:</strong> n = 4, edges = [[1,0],[1,2],[1,3]]
<strong>Output:</strong> [1]
<strong>Explanation:</strong> As shown, the height of the tree is 1 when the root is the node with label 1 which is the only MHT.
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/09/01/e2.jpg" style="width: 800px; height: 321px;">
<pre><strong>Input:</strong> n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]
<strong>Output:</strong> [3,4]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 2 * 10<sup>4</sup></code></li>
	<li><code>edges.length == n - 1</code></li>
	<li><code>0 &lt;= a<sub>i</sub>, b<sub>i</sub> &lt; n</code></li>
	<li><code>a<sub>i</sub> != b<sub>i</sub></code></li>
	<li>All the pairs <code>(a<sub>i</sub>, b<sub>i</sub>)</code> are distinct.</li>
	<li>The given input is <strong>guaranteed</strong> to be a tree and there will be <strong>no repeated</strong> edges.</li>
</ul>
</div>
 */
public class MinimumHeightTrees {
    public static void main(String[] args) {
        int[][][][] tests = {
            {{{1,0},{1,2},{1,3}},{{4}}},
            {{{3,0},{3,1},{3,2},{3,4},{5,4}},{{6}}}
        };

        for (int[][][] test : tests) {
            int n = test[1][0][0];
            int[][] edges = test[0];

            System.out.println(new MinimumHeightTrees_Solution().findMinHeightTrees(n, edges));
        }
    }
}

//  7 ms 55 MB
class MinimumHeightTrees_Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int[] counts = new int[n];
        int[] links = new int[n];
        for (int[] edge : edges) {
            links[edge[0]] ^= edge[1];
            counts[edge[0]]++;
            links[edge[1]] ^= edge[0];
            counts[edge[1]]++;
        }
        Queue<Integer> Qu = new LinkedList<>();
        int[] dists = new int[n];
        for (int i = 0; i < n; i++) {
            if (counts[i] == 1)
                Qu.add(i);
        }
        int stp = 1;
        while (!Qu.isEmpty()) {
            int size = Qu.size();
            for (int j = 0; j < size; j++) {
                int tmp = Qu.poll();
                links[links[tmp]] ^= tmp;
                counts[links[tmp]]--;
                if (counts[links[tmp]] == 1) {
                    dists[links[tmp]] = Math.max(stp, dists[links[tmp]]);
                    Qu.add(links[tmp]);
                }
            }
            stp++;
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(dists[i], max);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (dists[i] == max)
                res.add(i);
        }
        return res;
    }
}

// 10ms 55MB
class MinimumHeightTrees_Solution2  {
    int idx = 0;
    int[] head, next, end;
    void add(int u, int v) {
        // for (int idx = head[u]; idx != -1; idx = next[idx])
        next[idx] = head[u];
        head[u] = idx;
        end[idx] = v;
        idx++;
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int m = n * 2 - 2;
        head = new int[n]; next = new int[m]; end = new int[m];
        Arrays.fill(head, -1);
        int[] indeg = new int[n];
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            add(u, v);
            add(v, u);
            indeg[u]++;
            indeg[v]++;
        }
        Deque<Integer> que = new ArrayDeque<>();
        for (int u = 0; u < n; u++) {
            if (indeg[u] == 1) {
                que.offer(u);
            }
        }
        List<Integer> res = new ArrayList<>();
        if (n == 1) res.add(0);
        while (!que.isEmpty()) {
            int size = que.size();
            res = new ArrayList<>(que);
            for (int i = 0; i < size; i++) {
                int u = que.poll();
                for (int index = head[u]; index != -1; index = next[index]) {
                    int v = end[index];
                    indeg[v]--;
                    if (indeg[v] == 1) que.offer(v);
                }
            }
        }
        return res;
    }
}