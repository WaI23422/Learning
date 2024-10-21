package BetterCodeAnswer.Easy.TreeNode;

import java.util.Stack;

import Easy.TreeNode.Class.TreeNode;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/minimum-absolute-difference-in-bst/">530. Minimum Absolute Difference in BST</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given the <code>root</code> of a Binary Search Tree (BST), return <em>the minimum absolute difference between the values of any two different nodes in the tree</em>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/02/05/bst1.jpg" style="width: 292px; height: 301px;">
 * <pre><strong>Input:</strong> root = [4,2,6,1,3]
 * <strong>Output:</strong> 1
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/02/05/bst2.jpg" style="width: 282px; height: 301px;">
 * <pre><strong>Input:</strong> root = [1,0,48,null,null,12,49]
 * <strong>Output:</strong> 1
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li>The number of nodes in the tree is in the range <code>[2, 10<sup>4</sup>]</code>.</li>
 * 	<li><code>0 &lt;= Node.val &lt;= 10<sup>5</sup></code></li>
 * </ul>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Note:</strong> This question is the same as 783: <a href="https://leetcode.com/problems/minimum-distance-between-bst-nodes/" target="_blank">https://leetcode.com/problems/minimum-distance-between-bst-nodes/</a></p>
 * </div>
 */
public class MinimumAbsoluteDifferenceInBST {
    public static void main(String[] args) {
        Object[][] tests = {
            {1,2,3,4},
            {1,2,3,null,4},
        };

        for (Object[] arr : tests) {
            TreeNode root = TreeNode.addNode(arr,0);
            System.out.println(new MinimumAbsoluteDifferenceInBST_Solution().getMinimumDifference(root));
        }
    }
}

class MinimumAbsoluteDifferenceInBST_Solution {
    public int getMinimumDifference(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        int result = Integer.MAX_VALUE;

        if (root != null) {stack.add(root);}

        while (!stack.isEmpty()) {
            TreeNode temp = stack.peek();

            if (temp != null) {
                stack.pop();

                if (temp.right != null) {
                    stack.add(temp.right);
                }
                stack.add(temp);
                stack.add(null);
                
                if (temp.left != null) {
                    stack.add(temp.left);
                }
            }
            else {
                stack.pop();
                TreeNode temp2 = stack.pop();
                if(pre != null) {
                    result = Math.min(result, temp2.val - pre.val);
                }
                pre = temp2;
            }
        }
        return result;
    }
}