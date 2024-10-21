package BetterCodeAnswer.Easy.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import BetterCodeAnswer.Easy.TreeNode.Class.TreeNode;

/**
 * BinaryTreeInorderTraversal
 */
public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        Object[][] tests = {
            {1,2,3,4},
            {1,2,3,null,4},
        };

        for (Object[] arr : tests) {
            TreeNode root = TreeNode.addNode(arr,0);
            System.out.println(new BinaryTreeInorderTraversal_Solution().inorderTraversal(root));
        }
    }   
}

/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal/editorial/
 */
class BinaryTreeInorderTraversal_Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }
}