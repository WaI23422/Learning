package Easy.TreeNode;

import Easy.TreeNode.Class.TreeNode;

public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        Object[][] tests = {
            {1,2,3,4},
            {1,2,3,null,4},
        };

        for (Object[] arr : tests) {
            TreeNode root = TreeNode.addNode(arr,0);
            System.out.println(new DiameterOfBinaryTree_Solution().diameterOfBinaryTree(root));
        }
    }
}

// 0 ms 42.2 MB
class DiameterOfBinaryTree_Solution {
    int result = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return result;
    }

    public int depth(TreeNode node){
        if(node == null) return 0;
        int leftDepth = depth(node.left);
        int rightDepth = depth(node.right);

        int currrentD = leftDepth + rightDepth;
        result = Math.max(result, currrentD);

        return Math.max(leftDepth, rightDepth) + 1;
    }
}