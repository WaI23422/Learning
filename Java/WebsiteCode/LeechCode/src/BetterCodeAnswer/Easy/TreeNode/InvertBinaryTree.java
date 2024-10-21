package BetterCodeAnswer.Easy.TreeNode;

import java.util.Arrays;

import BetterCodeAnswer.Easy.TreeNode.Class.TreeNode;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/invert-binary-tree/">226.Invert Binary Tree</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given the <code>root</code> of a binary tree, invert the tree, and return <em>its root</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/03/14/invert1-tree.jpg" style="width: 500px; height: 165px;">
<pre><strong>Input:</strong> root = [4,2,7,1,3,6,9]
<strong>Output:</strong> [4,7,2,9,6,3,1]
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/03/14/invert2-tree.jpg" style="width: 500px; height: 120px;">
<pre><strong>Input:</strong> root = [2,1,3]
<strong>Output:</strong> [2,3,1]
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> root = []
<strong>Output:</strong> []
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the tree is in the range <code>[0, 100]</code>.</li>
	<li><code>-100 &lt;= Node.val &lt;= 100</code></li>
</ul>
</div>
 */
public class InvertBinaryTree {
    public static void main(String[] args) {
        Object[][] tests = {
            {1,2,3,4},
            {1,2,3,null,4},
            {}
        };

        for (Object[] arr : tests) {
            TreeNode root = TreeNode.addNode(arr,0);
            String[] ans = TreeNode.toArray(new InvertBinaryTree_Solution().invertTree(root));

            System.out.println(Arrays.toString(ans));
        }
    }
}

// @see Easy.TreeNode.InvertBinaryTree.java
class InvertBinaryTree_Solution {
    public TreeNode invertTree(TreeNode root) {
        return root;
    }
}