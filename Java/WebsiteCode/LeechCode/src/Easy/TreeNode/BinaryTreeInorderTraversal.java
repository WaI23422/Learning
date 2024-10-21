package Easy.TreeNode;

import java.util.ArrayList;
import java.util.List;

import Easy.TreeNode.Class.TreeNode;

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

// 0 ms 41.2 MB
class BinaryTreeInorderTraversal_Solution {
    private List<Integer> res = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        traverse(root);
        return res;
    }
    
    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        res.add(root.val);
        traverse(root.right);
    }
}