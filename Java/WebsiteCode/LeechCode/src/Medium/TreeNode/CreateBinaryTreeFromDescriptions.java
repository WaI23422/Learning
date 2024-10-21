package Medium.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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

// 1503 ms 55.8 MB
class CreateBinaryTreeFromDescriptions_Solution1 {
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, TreeNode> nodesContain = new HashMap<>();
        List<TreeNode> noParentTree = new ArrayList<>();

        for (int[] des : descriptions) {
            int nodeVal = des[0],
            valAdd = des[1],
            pos = des[2];

            if (nodesContain.containsKey(nodeVal)) {
                TreeNode temp;
                if (nodesContain.containsKey(valAdd)) {
                    temp = nodesContain.get(valAdd); 
                } else {
                    temp = new TreeNode(valAdd);
                    nodesContain.put(valAdd, temp);
                }
                
                noParentTree.remove(temp);
                addLeftRight(nodesContain, temp, nodeVal, pos);
            } else {
                TreeNode tempVal = new TreeNode(nodeVal),
                        temp;
                if (nodesContain.containsKey(valAdd)) {
                    temp = nodesContain.get(valAdd); 
                } else {
                    temp = new TreeNode(valAdd);
                    nodesContain.put(valAdd, temp);
                }
                nodesContain.put(nodeVal, tempVal);
                addLeftRight(nodesContain, temp, nodeVal, pos);
                
                if (!noParentTree.contains(tempVal)) {
                    noParentTree.add(tempVal);
                }
                if (noParentTree.contains(temp)) {
                    noParentTree.remove(temp);
                }
            }
        }

        return noParentTree.getFirst();
    }

    private void addLeftRight(HashMap<Integer, TreeNode> nodesContain, TreeNode temp, int nodeVal, int pos){
        if (pos == 1) {
            nodesContain.get(nodeVal).left = temp;
        } else {
            nodesContain.get(nodeVal).right = temp;
        }
    }
}

// Time Limit Exceed:
class CreateBinaryTreeFromDescriptions_Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        List<TreeNode> nodesContain = new ArrayList<>();
        List<TreeNode> noParentTree = new ArrayList<>();

        for (int[] des : descriptions) {
            int nodeVal = des[0],
            valAdd = des[1],
            pos = des[2];

            TreeNode tempNodeVal = findIfExistTreeNode(nodesContain, noParentTree, nodeVal,true),
                     tempValAdd = findIfExistTreeNode(nodesContain, noParentTree, valAdd,false);

            if (noParentTree.contains(tempValAdd)) {
                noParentTree.remove(tempValAdd);
            }

            if (pos == 1) {
                tempNodeVal.left = tempValAdd;
            } else {
                tempNodeVal.right = tempValAdd;
            }
        }

        return noParentTree.getFirst();
    }

    private TreeNode findIfExistTreeNode(List<TreeNode> list,List<TreeNode> noParentTree, int val, boolean isNode) {
        for (TreeNode treeNode : list) {
            if (treeNode.val == val) {
                return treeNode;
            }
        }

        TreeNode temp = new TreeNode(val);  

        if (isNode) {noParentTree.add(temp);}
        list.add(temp);
        
        return temp;
    }
}