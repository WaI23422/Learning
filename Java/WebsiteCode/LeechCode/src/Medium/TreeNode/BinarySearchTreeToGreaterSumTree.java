package Medium.TreeNode;

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

// 0 ms 40.5 MB
class BinarySearchTreeToGreaterSumTree_Solution {
    int sum = 0;
    
    public TreeNode bstToGst(TreeNode root) {
        changeValRoot(root);

        return root;
    }

    public void changeValRoot(TreeNode root) {
        if (root == null) {return;}

        changeValRoot(root.right);
        
        sum += root.val;
        root.val = sum;

        changeValRoot(root.left);
    }
}