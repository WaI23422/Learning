package BetterCodeAnswer.Medium.TreeNode;

import Medium.TreeNode.Class.TreeNode;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/flip-equivalent-binary-trees/">951. Flip Equivalent Binary Trees</a>
 * 
 * <div><div class="elfjS" data-track-load="description_content"><p>For a binary tree <strong>T</strong>, we can define a <strong>flip operation</strong> as follows: choose any node, and swap the left and right child subtrees.</p>
 * 
 * <p>A binary tree <strong>X</strong>&nbsp;is <em>flip equivalent</em> to a binary tree <strong>Y</strong> if and only if we can make <strong>X</strong> equal to <strong>Y</strong> after some number of flip operations.</p>
 * 
 * <p>Given the roots of two binary trees <code>root1</code> and <code>root2</code>, return <code>true</code> if the two trees are flip equivalent or <code>false</code> otherwise.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="Flipped Trees Diagram" src="https://assets.leetcode.com/uploads/2018/11/29/tree_ex.png" style="width: 500px; height: 220px;">
 * <pre><strong>Input:</strong> root1 = [1,2,3,4,5,6,null,null,null,7,8], root2 = [1,3,2,null,6,4,5,null,null,null,null,8,7]
 * <strong>Output:</strong> true
 * <strong>Explanation: </strong>We flipped at nodes with values 1, 3, and 5.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> root1 = [], root2 = []
 * <strong>Output:</strong> true
 * </pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <pre><strong>Input:</strong> root1 = [], root2 = [1]
 * <strong>Output:</strong> false
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li>The number of nodes in each tree is in the range <code>[0, 100]</code>.</li>
 * 	<li>Each tree will have <strong>unique node values</strong> in the range <code>[0, 99]</code>.</li>
 * </ul>
 * </div></div>
 */
public class FlipEquivalentBinaryTrees {
    public static void main(String[] args) {
        Object[][][] tests = {
            {
                {6,1,0},
                {6,null,1}
            },
        };

        for (Object[][] arr : tests) {
            TreeNode root1 = TreeNode.addNode(arr[0],0),
                     root2 = TreeNode.addNode(arr[1], 0);

            System.out.println(new FlipEquivalentBinaryTrees_Solution().flipEquiv(root1, root2));
        }
    }
}

// 0ms 41.50MB
class FlipEquivalentBinaryTrees_Solution {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) {
            return true;
        }

        if(root1==null || root2 == null || root1.val != root2.val) {
            return false;
        }

        return (flipEquiv(root1.left, root2.left) && 
            flipEquiv(root1.right, root2.right)) || 
                (flipEquiv(root1.left, root2.right) && 
                    flipEquiv(root1.right, root2.left));
    }
}