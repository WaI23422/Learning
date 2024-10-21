package Medium.TreeNode;

import Medium.TreeNode.Class.TreeNode;

/**
 * AmountOfTimeForBinaryTreeToBeInfected
 */
public class AmountOfTimeForBinaryTreeToBeInfected {
    public static void main(String[] args) {
        Object[][][] tests = {
            {{1,5,3,null,4,10,6,9,2},{3}},
            {{1},{1}},
        };

        for (Object[][] arr : tests) {
            TreeNode root1 = TreeNode.addNode(arr[0],0);
            int start = (int) arr[1][0];

            System.out.println(new AmountOfTimeForBinaryTreeToBeInfected_Solution().amountOfTime(root1, start));
        }
    }
}

// @see BetterCodeAnswer.Medium.TreeNode.AmountOfTimeForBinaryTreeToBeInfected.java
class AmountOfTimeForBinaryTreeToBeInfected_Solution {
    public int amountOfTime(TreeNode root, int start) {
        return 0;
    }
}