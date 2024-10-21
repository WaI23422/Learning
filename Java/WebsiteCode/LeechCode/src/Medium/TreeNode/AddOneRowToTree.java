package Medium.TreeNode;

import java.util.Arrays;

import Medium.TreeNode.Class.TreeNode;

public class AddOneRowToTree {
    public static void main(String[] args) {
        Object[][][] tests = {
            {{4,2,6,3,1,5},{1},{1}},
            {{4,2,6,3,1,5},{1},{2}},
            {{4,2,null,3,1},{1},{3}},
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

class AddOneRowToTree_Solution {
    public TreeNode add(TreeNode root, int val, int depth, int curr) {
        if (root == null)
            return null;

        if (curr == depth - 1) {
            TreeNode lTemp = root.left;
            TreeNode rTemp = root.right;

            root.left = new TreeNode(val);
            root.right = new TreeNode(val);
            root.left.left = lTemp;
            root.right.right = rTemp;

            return root;
        }

        root.left = add(root.left, val, depth, curr + 1);
        root.right = add(root.right, val, depth, curr + 1);

        return root;
    }

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }

        return add(root, val, depth, 1);
    }
}