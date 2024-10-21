package Medium.TreeNode;

import Medium.TreeNode.Class.TreeNode;

public class SumRootToLeafNumbers {
    public static void main(String[] args) {
        Object[][] tests = {
            {4,9,0,5,1},
            {2,3,1,3,1,null,1},
            {2,1,1,1,3,null,null,null,null,null,1},
            {9},
            {1,2,3},
        };

        for (Object[] test : tests) {
            TreeNode root = TreeNode.addNode(test, 0);

            System.out.println(new SumRootToLeafNumbers_Solution().sumNumbers(root));
        }
    }
}

// 0 ms 40.3 MB
class SumRootToLeafNumbers_Solution {
    public int sumNumbers(TreeNode root) {
        return sumEachRoot(root,0);
    }

    private int sumEachRoot(TreeNode root, int totalPrev) {
        totalPrev = totalPrev*10 + root.val;
        if (root.left == null && root.right == null) {return totalPrev;}

        int sumLeft = 0, sumRight = 0;
        if (root.left != null) {
            sumLeft = sumEachRoot(root.left, totalPrev);
        }

        if (root.right != null) {
            sumRight = sumEachRoot(root.right, totalPrev);
        }

        return sumLeft + sumRight;
    }
}
