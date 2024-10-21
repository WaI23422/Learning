package BetterCodeAnswer.Medium.TreeNode;

import java.util.Arrays;

import Medium.TreeNode.Class.TreeNode;

public class AddOneRowToTree {
    public static void main(String[] args) {
        Object[][][] tests = {
            {{4,2,null,3,1,5},{1},{3}},
            {{4,2,6,3,1,5},{1},{1}},
            {{4,2,6,3,1,5},{1},{2}},
            {{4,2,6,3,1,5},{1},{4}},
        };

        for (Object[][] test : tests) {
            TreeNode root = TreeNode.addNode(test[0], 0);
            int val = (int) test[1][0];
            int depth = (int) test[2][0];

            System.out.println(Arrays.toString(TreeNode.toArray(new AddOneRowToTree_Solution().addOneRow(root,val ,depth))));
        }
    }
}

// @see Medium.TreeNode.*
class AddOneRowToTree_Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        return root;
    }
}