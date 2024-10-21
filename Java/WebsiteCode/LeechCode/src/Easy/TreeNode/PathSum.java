package Easy.TreeNode;

import Easy.TreeNode.Class.TreeNode;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/path-sum/">112.Path Sum</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>Given the <code>root</code> of a binary tree and an integer <code>targetSum</code>, return <code>true</code> if the tree has a <strong>root-to-leaf</strong> path such that adding up all the values along the path equals <code>targetSum</code>.</p>

<p>A <strong>leaf</strong> is a node with no children.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/01/18/pathsum1.jpg" style="width: 500px; height: 356px;">
<pre><strong>Input:</strong> root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
<strong>Output:</strong> true
<strong>Explanation:</strong> The root-to-leaf path with the target sum is shown.
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/01/18/pathsum2.jpg">
<pre><strong>Input:</strong> root = [1,2,3], targetSum = 5
<strong>Output:</strong> false
<strong>Explanation:</strong> There two root-to-leaf paths in the tree:
(1 --&gt; 2): The sum is 3.
(1 --&gt; 3): The sum is 4.
There is no root-to-leaf path with sum = 5.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> root = [], targetSum = 0
<strong>Output:</strong> false
<strong>Explanation:</strong> Since the tree is empty, there are no root-to-leaf paths.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the tree is in the range <code>[0, 5000]</code>.</li>
	<li><code>-1000 &lt;= Node.val &lt;= 1000</code></li>
	<li><code>-1000 &lt;= targetSum &lt;= 1000</code></li>
</ul>
</div></div>
 */
public class PathSum {
    public static void main(String[] args) {
        Object[][][] tests = {
            {{5,4,8,11,null,13,4,7,2,null,null,null,1},{22}},
            {{1,2,3},{5}},
            {{},{0}},
        };

        for (Object[][] test : tests) {
            TreeNode root = TreeNode.addNode(test[0], 0);
            int targetSum = (int) test[1][0];

            System.out.println(String.valueOf(new PathSum_Solution().hasPathSum(root, targetSum)));
        }
    }    
}

// 0 ms 43.9 MB
class PathSum_Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) { return false;}

        return pathSum(root, root.val, targetSum);
    }

    public boolean pathSum(TreeNode root, int sum, int target) {
        if (root.left == null && root.right == null) { return sum == target;}
        
        boolean left,right;

        if (root.left != null) { left = pathSum(root.left, sum + root.left.val, target);}
        else {left = false;}

        if (root.right != null) {right = pathSum(root.right, sum + root.right.val, target);}
        else {right = false;}

        return left || right;
    }
}