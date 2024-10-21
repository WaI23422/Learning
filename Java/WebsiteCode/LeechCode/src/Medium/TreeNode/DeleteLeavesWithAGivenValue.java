package Medium.TreeNode;

import java.util.Arrays;

import Medium.TreeNode.Class.TreeNode;

public class DeleteLeavesWithAGivenValue {
    public static void main(String[] args) {
        Object[][][] tests = {
            {{1,2,3,2,null,2,4},{2}}
        };

        for (Object[][] test : tests) {
            TreeNode root = TreeNode.addNode(test[0], 0);
            int target = (int) test[1][0];

            TreeNode ans = new DeleteLeavesWithAGivenValue_Solution().removeLeafNodes(root, target);
            System.out.println(Arrays.toString(TreeNode.toArray(ans)));
        }
    }
}

// 0 ms 44.1 MB
class DeleteLeavesWithAGivenValue_Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) { return null;}

        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);

        if (root.left == null && root.right == null && root.val == target) {
            return null;
        }

        return root;
    }
}