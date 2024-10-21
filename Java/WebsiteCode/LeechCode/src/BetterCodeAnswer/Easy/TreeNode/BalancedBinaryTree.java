package BetterCodeAnswer.Easy.TreeNode;

import BetterCodeAnswer.Easy.TreeNode.Class.TreeNode;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/balanced-binary-tree/">110.Balanced Binary Tree</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>Given a binary tree, determine if it is <span data-keyword="height-balanced" class=" cursor-pointer relative text-dark-blue-s text-sm"><div class="popover-wrapper inline-block" data-headlessui-state=""><div><div aria-expanded="false" data-headlessui-state="" id="headlessui-popover-button-:rj:"><div><strong>height-balanced</strong></div></div><div style="position: fixed; z-index: 40; inset: 0px auto auto 0px; transform: translate(81px, 241px);"></div></div></div></span>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/06/balance_1.jpg" style="width: 342px; height: 221px;">
<pre><strong>Input:</strong> root = [3,9,20,null,null,15,7]
<strong>Output:</strong> true
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/06/balance_2.jpg" style="width: 452px; height: 301px;">
<pre><strong>Input:</strong> root = [1,2,2,3,3,null,null,4,4]
<strong>Output:</strong> false
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> root = []
<strong>Output:</strong> true
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the tree is in the range <code>[0, 5000]</code>.</li>
	<li><code>-10<sup>4</sup> &lt;= Node.val &lt;= 10<sup>4</sup></code></li>
</ul>
</div></div>
 */
public class BalancedBinaryTree {
    public static void main(String[] args) {
        Object[][] tests = {
            {3,9,20,null,null,15,7},
            {1,2,2,3,3,null,null,4,4},
            {}
        };

        for (Object[] test : tests) {
            TreeNode root = TreeNode.addNode(test, 0);

            System.out.println(new BalancedBinaryTree_Solution().isBalanced(root));
        }
    }    
}

// 0 ms 42.9 MB
class BalancedBinaryTree_Solution {
    public boolean isBalanced(TreeNode root) {
        // If the tree is empty, we can say it’s balanced...
        if (root == null)  return true;
        // Height Function will return -1, when it’s an unbalanced tree...
		if (Height(root) == -1)  return false;
		return true;
	}
    // Create a function to return the “height” of a current subtree using recursion...
	public int Height(TreeNode root) {
        // Base case...
		if (root == null)  return 0;
        // Height of left subtree...
		int leftHeight = Height(root.left);
        // Height of height subtree...
		int rightHight = Height(root.right);
        // In case of left subtree or right subtree unbalanced, return -1...
		if (leftHeight == -1 || rightHight == -1)  return -1;
        // If their heights differ by more than ‘1’, return -1...
        if (Math.abs(leftHeight - rightHight) > 1)  return -1;
        // Otherwise, return the height of this subtree as max(leftHeight, rightHight) + 1...
		return Math.max(leftHeight, rightHight) + 1;
    }
}