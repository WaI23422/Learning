package BetterCodeAnswer.Medium.TreeNode;

import BetterCodeAnswer.Medium.TreeNode.Class.TreeNode;

/**
 * FindBottomLeftTreeValue
 */
public class FindBottomLeftTreeValue {
    public static void main(String[] args) {
        Object[][] tests = {
            // {2,1,3},
            {1,2,3,4,null,5,6,null,null,7}
        };

        for (Object[] arr : tests) {
            TreeNode root = TreeNode.addNode(arr,0);
            System.out.println(new FindBottomLeftTreeValue_Solution().findBottomLeftValue(root));
        }
    }
}

// 0 ms 43.37 MB
class FindBottomLeftTreeValue_Solution {

    int leftmost = 0;
    int leftmostrow = -1;
    void visit(TreeNode root, int depth) {
        if (root == null) return;
        if (depth > leftmostrow) {
            leftmost = root.val;
            leftmostrow = depth;
        }
        visit(root.left, depth+1);
        visit(root.right, depth+1);
    }

    public int findBottomLeftValue(TreeNode root) {
        visit(root, 0)    ;
        return leftmost;
    }
}