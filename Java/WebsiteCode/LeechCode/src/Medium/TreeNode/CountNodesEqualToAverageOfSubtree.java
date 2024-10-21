package Medium.TreeNode;

import Medium.TreeNode.Class.TreeNode;

public class CountNodesEqualToAverageOfSubtree {
    static int index;

    public static void addNode(TreeNode root, Integer[] list){
        if (list[index] == null){ return;}

        root.val = list[index];
        index++; 

        if (index < list.length){
            if (list[index] != null) {
                root.left = new TreeNode();
                addNode(root.left, list);
            }
            index++;
        }

        if (index < list.length) {
            if (list[index] != null) {
                root.right = new TreeNode();
                addNode(root.right, list);
            }
            index++;
        }
    }

    public static void main(String[] args) {
        Integer[][] tests = {
            {4,8,5,0,1,null,6},
        };

        CountNodesEqualToAverageOfSubtree_Solution res = new CountNodesEqualToAverageOfSubtree_Solution();

        for (Integer[] list : tests) {
            index =0;
            TreeNode root = new TreeNode();
            addNode(root, list);

            System.out.println(res.averageOfSubtree(root));
        }
    }
}

class CountNodesEqualToAverageOfSubtree_Solution {
    static int Sum, Total, Count;
    
    // 8 ms 
    // 42.3 MB
    public void nodeSum(TreeNode root){
        Sum += root.val; Total++;

        if (root.left != null) {
            nodeSum(root.left);
        }

        if (root.right != null) {
            nodeSum(root.right);
        }
    }

    public int averageOfSubtree(TreeNode root) {
        Sum = 0; Total = 0;
        
        nodeSum(root);

        if (root.val == Sum/Total) {Count++;}
        
        if (root.left != null) {averageOfSubtree(root.left);}

        if (root.right != null) {averageOfSubtree(root.right);}

        return Count;
    }
}

