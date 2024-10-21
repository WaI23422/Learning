package Easy.TreeNode;

import Easy.TreeNode.Class.TreeNode;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/maximum-depth-of-binary-tree/">104.Maximum Depth of Binary Tree</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>Given the <code>root</code> of a binary tree, return <em>its maximum depth</em>.</p>

<p>A binary tree's <strong>maximum depth</strong>&nbsp;is the number of nodes along the longest path from the root node down to the farthest leaf node.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/26/tmp-tree.jpg" style="width: 400px; height: 277px;">
<pre><strong>Input:</strong> root = [3,9,20,null,null,15,7]
<strong>Output:</strong> 3
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> root = [1,null,2]
<strong>Output:</strong> 2
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the tree is in the range <code>[0, 10<sup>4</sup>]</code>.</li>
	<li><code>-100 &lt;= Node.val &lt;= 100</code></li>
</ul>
</div></div>
 */
public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        Object[][] tests = {
            {3,9,20,null,null,15,7},
            {1,null,2}
        };

        for (Object[] nums : tests) {
            System.out.println(new MaximumDepthOfBinaryTree_Solution().maxDepth(TreeNode.addNode(nums, 0)));
        }
    }
}

// 0 ms 41.3 MB
class MaximumDepthOfBinaryTree_Solution {
    public int maxDepth(TreeNode root) {
        return numDepth(root,0);
    }
    
    public int numDepth(TreeNode root, int depth){
        if (root==null){ return depth;}

        return Math.max(numDepth(root.left,depth),numDepth(root.right,depth)) + 1;
    }
}


// 0 ms 41.8 MB
class MaximumDepthOfBinaryTree_Solution2 {
    public int maxDepth(TreeNode root) {
        return numDepth(root,0);
    }
    
    public int numDepth(TreeNode root, int depth){
        if (root==null){ return depth;}
        depth++;

        return Math.max(numDepth(root.left,depth),numDepth(root.right,depth));
    }
}
