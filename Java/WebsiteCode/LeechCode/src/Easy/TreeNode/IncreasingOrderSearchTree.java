package Easy.TreeNode;

import java.util.Arrays;

import Easy.TreeNode.Class.TreeNode;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/increasing-order-search-tree/">897. Increasing Order Search Tree</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given the <code>root</code> of a binary search tree, rearrange the tree in <strong>in-order</strong> so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only one right child.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/11/17/ex1.jpg" style="width: 600px; height: 350px;">
 * <pre><strong>Input:</strong> root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
 * <strong>Output:</strong> [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/11/17/ex2.jpg" style="width: 300px; height: 114px;">
 * <pre><strong>Input:</strong> root = [5,1,7]
 * <strong>Output:</strong> [1,null,5,null,7]
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li>The number of nodes in the given tree will be in the range <code>[1, 100]</code>.</li>
 * 	<li><code>0 &lt;= Node.val &lt;= 1000</code></li>
 * </ul>
 * </div>
 */
public class IncreasingOrderSearchTree {
    public static void main(String[] args) {
        Object[][] tests = {
            {5,3,6,2,4,null,8,1,null,null,null,7,9},
            {1,2,3,4},
        };

        for (Object[] arr : tests) {
            TreeNode root = TreeNode.addNode(arr,0);
            System.out.println(Arrays.toString(TreeNode.toArray(new IncreasingOrderSearchTree_Solution().increasingBST(root))));
        }
    }
}

// 0ms 41.12mb
class IncreasingOrderSearchTree_Solution {
    TreeNode tempRoot = new TreeNode();
    public TreeNode increasingBST(TreeNode root) {
        TreeNode newRoot = tempRoot;
        goThroughTree(root);

        return newRoot.right;
    }

    private void goThroughTree(TreeNode root) {
        if (root == null) {return;}
        goThroughTree(root.left);
        tempRoot.right = new TreeNode(root.val);
        tempRoot = tempRoot.right;
        goThroughTree(root.right);
    }
}