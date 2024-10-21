package BetterCodeAnswer.Medium.TreeNode;

import BetterCodeAnswer.Medium.TreeNode.Class.TreeNode;

/**
 * PseudoPalindromicPathsInABinaryTree
 */
public class PseudoPalindromicPathsInABinaryTree {
    public static void main(String[] args) {
        Object[][] tests = {
            {2,3,1,3,1,null,1},
            {2,1,1,1,3,null,null,null,null,null,1},
            {9},
        };

        for (Object[] test : tests) {
            TreeNode root = TreeNode.addNode(test, 0);

            System.out.println(new PseudoPalindromicPathsInABinaryTree_Solution().pseudoPalindromicPaths(root));
        }
    }
}

// 5 ms 69.9 MB
class PseudoPalindromicPathsInABinaryTree_Solution {
    int ans =0;
    public int pseudoPalindromicPaths (TreeNode root) {
        func(root, 0);
        return ans;
    }

    void func(TreeNode node, int seen){
        if(node == null) return;

        seen^=(1<<node.val);
        if(node.left == null && node.right == null){
            if((seen & (seen-1)) == 0){
                ans++;
            }
            return;
        }
        func(node.left, seen);
        func(node.right, seen);

    }
}