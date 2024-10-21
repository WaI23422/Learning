package BetterCodeAnswer.Medium.TreeNode;

import java.util.Arrays;

import Medium.TreeNode.Class.TreeNode;

public class BinarySearchTreeToGreaterSumTree {
    public static void main(String[] args) {
        Object[][] tests = {
            {4,1,6,0,2,5,7,null,null,null,3,null,null,null,8},
        };

        for (Object[] arr : tests) {
            TreeNode root = TreeNode.addNode(arr,0);

            System.out.println(Arrays.toString(TreeNode.toArray(new BinarySearchTreeToGreaterSumTree_Solution().bstToGst(root))));
        }
    }
}

// @see Medium.TreeNode
class BinarySearchTreeToGreaterSumTree_Solution {
    int sum = 0;
    
    public TreeNode bstToGst(TreeNode root) {
        return root;
    }
}