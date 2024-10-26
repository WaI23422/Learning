package BetterCodeAnswer.Hard.TreeNode;

import java.util.Arrays;

import Medium.TreeNode.Class.TreeNode;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/height-of-binary-tree-after-subtree-removal-queries/">2458. Height of Binary Tree After Subtree Removal Queries</a>
 * 
 * <div><div class="elfjS" data-track-load="description_content"><p>You are given the <code>root</code> of a <strong>binary tree</strong> with <code>n</code> nodes. Each node is assigned a unique value from <code>1</code> to <code>n</code>. You are also given an array <code>queries</code> of size <code>m</code>.</p>
 * 
 * <p>You have to perform <code>m</code> <strong>independent</strong> queries on the tree where in the <code>i<sup>th</sup></code> query you do the following:</p>
 * 
 * <ul>
 * 	<li><strong>Remove</strong> the subtree rooted at the node with the value <code>queries[i]</code> from the tree. It is <strong>guaranteed</strong> that <code>queries[i]</code> will <strong>not</strong> be equal to the value of the root.</li>
 * </ul>
 * 
 * <p>Return <em>an array </em><code>answer</code><em> of size </em><code>m</code><em> where </em><code>answer[i]</code><em> is the height of the tree after performing the </em><code>i<sup>th</sup></code><em> query</em>.</p>
 * 
 * <p><strong>Note</strong>:</p>
 * 
 * <ul>
 * 	<li>The queries are independent, so the tree returns to its <strong>initial</strong> state after each query.</li>
 * 	<li>The height of a tree is the <strong>number of edges in the longest simple path</strong> from the root to some node in the tree.</li>
 * </ul>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2022/09/07/binaryytreeedrawio-1.png" style="width: 495px; height: 281px;">
 * <pre><strong>Input:</strong> root = [1,3,4,2,null,6,5,null,null,null,null,null,7], queries = [4]
 * <strong>Output:</strong> [2]
 * <strong>Explanation:</strong> The diagram above shows the tree after removing the subtree rooted at node with value 4.
 * The height of the tree is 2 (The path 1 -&gt; 3 -&gt; 2).
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2022/09/07/binaryytreeedrawio-2.png" style="width: 301px; height: 284px;">
 * <pre><strong>Input:</strong> root = [5,8,9,2,1,3,7,4,6], queries = [3,2,4,8]
 * <strong>Output:</strong> [3,2,3,2]
 * <strong>Explanation:</strong> We have the following queries:
 * - Removing the subtree rooted at node with value 3. The height of the tree becomes 3 (The path 5 -&gt; 8 -&gt; 2 -&gt; 4).
 * - Removing the subtree rooted at node with value 2. The height of the tree becomes 2 (The path 5 -&gt; 8 -&gt; 1).
 * - Removing the subtree rooted at node with value 4. The height of the tree becomes 3 (The path 5 -&gt; 8 -&gt; 2 -&gt; 6).
 * - Removing the subtree rooted at node with value 8. The height of the tree becomes 2 (The path 5 -&gt; 9 -&gt; 3).
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li>The number of nodes in the tree is <code>n</code>.</li>
 * 	<li><code>2 &lt;= n &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>1 &lt;= Node.val &lt;= n</code></li>
 * 	<li>All the values in the tree are <strong>unique</strong>.</li>
 * 	<li><code>m == queries.length</code></li>
 * 	<li><code>1 &lt;= m &lt;= min(n, 10<sup>4</sup>)</code></li>
 * 	<li><code>1 &lt;= queries[i] &lt;= n</code></li>
 * 	<li><code>queries[i] != root.val</code></li>
 * </ul>
 * </div></div>
 */
public class HeightOfBinaryTreeAfterSubtreeRemovalQueries {
    public static void main(String[] args) {
        Object[][][] tests = {
            {
                {1,null,5,null,null,null,3,null,null,null,null,null,null,2,4},
                {3,5,4,2,4}
            },
        };

        for (Object[][] arr : tests) {
            TreeNode root = TreeNode.addNode(arr[0],0);
            int[] queries = new int[arr[1].length];
            for (int i = 0; i < queries.length; i++) {
                queries[i] = (int) arr[1][i];
            }

            System.out.println(Arrays.toString(new HeightOfBinaryTreeAfterSubtreeRemovalQueries_Solution().treeQueries(root, queries)));
        }
    }   
}

// 8ms 71.95MB
class HeightOfBinaryTreeAfterSubtreeRemovalQueries_Solution {

    static final int[] heights = new int[100001];
    int maxHeight = 0;

    public int[] treeQueries(TreeNode root, int[] queries) {
        getLeftHeights(root, 0);
        maxHeight = 0;
        getRightHeights(root, 0);

        int n = queries.length;
        int[] result = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            result[i] = heights[queries[i]];
        }

        return result;
    }

    private void getLeftHeights(TreeNode node, int height) {
        heights[node.val] = maxHeight;
        maxHeight = Math.max(maxHeight, height);
        if (node.left != null) getLeftHeights(node.left, height + 1);
        if (node.right != null) getLeftHeights(node.right, height + 1);
    }

    private void getRightHeights(TreeNode node, int height) {
        heights[node.val] = Math.max(heights[node.val], maxHeight);
        maxHeight = Math.max(height, maxHeight);
        if (node.right != null) getRightHeights(node.right, height + 1);
        if (node.left != null) getRightHeights(node.left, height + 1);
    }
}

// 12ms 66.44MB
class HeightOfBinaryTreeAfterSubtreeRemovalQueries_Solution2 {
    int[] h = new int[100001], l = new int[100001], r = new int[100001];

    public int height(TreeNode root) {
        if (root == null)
            return 0;

        int lh = height(root.left);
        int rh = height(root.right);

        l[root.val] = lh;
        r[root.val] = rh;

        return 1 + Math.max(lh, rh);
    }

    public void solve(TreeNode root, int curmax, int depth) {
        if (root == null)
            return;

        h[root.val] = curmax;
        solve(root.left, Math.max(curmax, depth + r[root.val]), depth + 1);
        solve(root.right, Math.max(curmax, depth + l[root.val]), depth + 1);
    }

    public int[] treeQueries(TreeNode root, int[] queries) {
        height(root);
        solve(root.left, r[root.val], 1);
        solve(root.right, l[root.val], 1);

        int n = queries.length;
        int[] q = new int[n];
        for (int i = 0; i < n; i++) {
            q[i] = h[queries[i]];
        }
        return q;
    }
}