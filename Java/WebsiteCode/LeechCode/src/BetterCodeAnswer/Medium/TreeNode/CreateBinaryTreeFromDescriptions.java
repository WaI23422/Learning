package BetterCodeAnswer.Medium.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import Medium.TreeNode.Class.TreeNode;

public class CreateBinaryTreeFromDescriptions {
    public static void main(String[] args) {
        int[][][] tests = {
            {
                {39,70,1},
                {13,39,1},
                {85,74,1},
                {74,13,1},
                {38,82,1},
                {82,85,1}
            },
            {
                {20,15,1},
                {20,17,0},
                {50,20,1},
                {50,80,0},
                {80,19,1}
            },
        };
        
        for (int[][] descriptions : tests) {
            System.out.println(Arrays.toString(TreeNode.toArray(new CreateBinaryTreeFromDescriptions_Solution().createBinaryTree(descriptions))));
        }
    }
}

// 44 ms 56 MB
class CreateBinaryTreeFromDescriptions_Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer,TreeNode>map=new HashMap<>();
        for(int[]info:descriptions){
            map.put(info[1],new TreeNode(info[1]));
        }
        TreeNode root=null;
        for(int[]info:descriptions){
            if(!map.containsKey(info[0])){
                root= new TreeNode(info[0]);
                map.put(info[0],root);
            }
            if(info[2]==1){
                map.get(info[0]).left=map.get(info[1]);
            }
            else{
                map.get(info[0]).right=map.get(info[1]);
            }
        }
        return root;

    }
}