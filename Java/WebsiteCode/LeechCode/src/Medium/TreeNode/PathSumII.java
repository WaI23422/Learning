package Medium.TreeNode;

import java.util.ArrayList;
import java.util.List;

import Medium.TreeNode.Class.TreeNode;

public class PathSumII {
    public static void main(String[] args) {
        Object[][][] tests = {
            {{5,4,8,11,null,13,4,7,2,null,null,5,1},{22}},
        };

        for (Object[][] arr : tests) {
            TreeNode root = TreeNode.addNode(arr[0],0);
            int targetSum = (int) arr[1][0];

            List<List<Integer>> ans = new PathSumII_Solution().pathSum(root, targetSum);

            System.out.print("[");
            for (List<Integer> list : ans) {
                System.out.print(list.toString() + ",");
            }
            System.out.print("]");
        }
    }
}

// 1ms 44.70MB
class PathSumII_Solution {
    int targetSum;
    List<List<Integer>> path_List;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {return new ArrayList<>();}

        this.targetSum = targetSum;
        this.path_List = new ArrayList<>();

        treeSum(root, new ArrayList<>(){{add(root.val);}}, root.val);

        return path_List;
    }

    private void treeSum(
            TreeNode root, 
            List<Integer> l,
            int sum
    ){
        if (root.left == null && root.right == null && sum == targetSum) { 
            path_List.add(new ArrayList<>(l)); 
        }
        
        if (root.left != null) {
            l.add(root.left.val);
            treeSum(root.left,l, sum+root.left.val);
            l.removeLast();
        }
        if (root.right != null) {
            l.add(root.right.val);
            treeSum(root.right,l, sum+root.right.val);
            l.removeLast();
        }
    }
}