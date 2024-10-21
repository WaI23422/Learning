package Easy.TreeNode;

import Easy.TreeNode.Class.TreeNode;

public class SameTree {
    public static void main(String[] args) {
        Object[][][] tests = {
            {{1},{2}},
            {{1,2,3},{1,2,3}},
            {{1,2},{1,null,2}},
            {{1,2,1},{1,1,2}}
        };

        for (Object[][] test : tests) {
            TreeNode p = TreeNode.addNode(test[0],0);
            TreeNode q = TreeNode.addNode(test[1],0);

            System.out.println(String.valueOf(new SameTree_Solution().isSameTree(p, q)));
        }
    }
}

// @see Easy.Array.SameTree.java
class SameTree_Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}