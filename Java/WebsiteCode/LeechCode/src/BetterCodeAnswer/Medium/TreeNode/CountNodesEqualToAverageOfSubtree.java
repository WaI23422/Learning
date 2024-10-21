package BetterCodeAnswer.Medium.TreeNode;

import BetterCodeAnswer.Medium.TreeNode.Class.TreeNode;

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
    private int count;

    // 0 ms 42.7 MB
    public int averageOfSubtree(TreeNode root) {
        count = 0;
        process(root);
        
        System.gc(); // 2 ms 40.6 MB
        return count;   
    }

    public int[] process(TreeNode node) {
        if (node == null) return new int[2];
        int[] prev = process(node.left);
        int[] next = process(node.right);
        int subCount = prev[0] + next[0] + 1;
        int subSum = prev[1] + next[1] + node.val;
        if (subSum / subCount == node.val) {
            count++;
        }
        prev[0] += next[0] + 1;
        prev[1] += next[1] + node.val;

        return prev;
    }
}
