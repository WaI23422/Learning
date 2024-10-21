package BetterCodeAnswer.Medium.TreeNode;

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

// 0 ms 41.3 MB
class SumRootToLeafNumbers_Solution {
    public int sumTree(TreeNode root,int sum){
        if(root==null) return 0;
        sum=sum*10+root.val;
        if(root.left==null && root.right==null) return sum;
        return sumTree(root.left,sum)+sumTree(root.right,sum);
    }
    public int sumNumbers(TreeNode root) {
                return sumTree(root,0);
    }

}