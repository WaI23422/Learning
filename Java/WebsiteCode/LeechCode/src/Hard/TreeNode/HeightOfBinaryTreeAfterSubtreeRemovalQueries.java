package Hard.TreeNode;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

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

// 99ms 68.76MB
class HeightOfBinaryTreeAfterSubtreeRemovalQueries_Solution {
    int node_number = 1,
        root_depth[];
    public int[] treeQueries(TreeNode root, int[] queries) {
        countNode(root);
        int max_root_depth[] = new int[node_number],
            ans[] = new int[queries.length];
        root_depth = new int[node_number];
        dfs(root, 0,max_root_depth);
        bfs(root, max_root_depth);

        for (int i = 0; i < ans.length; i++) {
            ans[i] = max_root_depth[queries[i]];
        }

        return ans;
    }

    private void bfs(TreeNode root, int[] arr) {
        Queue<TreeNode> treenode_queue = new LinkedList<>() {{add(root);}};

        while (!treenode_queue.isEmpty()) {
            int size = treenode_queue.size(),
                hold_num[] = new int[size];

            PriorityQueue<Integer> root_value = new PriorityQueue<>( Collections.reverseOrder() );
            for (int i = 0; i < size; i++) {
                TreeNode temp_root = treenode_queue.remove();

                root_value.add(arr[temp_root.val]);

                hold_num[i] = temp_root.val;
                if (temp_root.left != null) {
                    treenode_queue.add(temp_root.left);
                }
                if (temp_root.right != null) {
                    treenode_queue.add(temp_root.right);
                }
            }

            for (int i = 0; i < size; i++) {
                int numb = hold_num[i];

                if (size == 1) {
                    arr[numb] = root_depth[numb] ;   
                    continue; 
                }

                int temp = root_value.remove();

                if (temp == arr[numb]) {
                    int temp_num = temp;
                        temp = root_value.remove();
                        root_value.add(temp_num);
                }

                arr[numb] = temp;
                
                root_value.add(temp);
            }
        }
    }

    private void countNode(TreeNode root) {
        if (root == null) {return;}

        node_number++;
        countNode(root.left);
        countNode(root.right);
    }

    public int dfs(TreeNode root, int level, int[] arr) {
        if (root == null) {return level-1;}

        root_depth[root.val] = level-1;

        int max = Math.max(dfs(root.left, level+1, arr),dfs(root.right, level+1,arr));

        arr[root.val] = max;

        return max;
    }
}