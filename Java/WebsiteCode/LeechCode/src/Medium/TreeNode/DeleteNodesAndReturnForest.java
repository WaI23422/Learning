package Medium.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Medium.TreeNode.Class.TreeNode;

public class DeleteNodesAndReturnForest {
    public static void main(String[] args) {
        Object[][][] tests = {
            {{1,2,3,4,5,6,7},{3,5}},
        };

        for (Object[][] arr : tests) {
            TreeNode root = TreeNode.addNode(arr[0],0);
            int[] to_delete = Arrays.stream(arr[1])
                                    .mapToInt(t-> (int) t)
                                    .toArray();

            List<TreeNode> ans = new DeleteNodesAndReturnForest_Solution().delNodes(root, to_delete);
            for (TreeNode node : ans) {
                System.out.print(Arrays.toString(TreeNode.toArray(node))+" ");
            }
        }
    }
}

// 1ms 44.29 MB
class DeleteNodesAndReturnForest_Solution {

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> toDeleteSet = new HashSet<>();
        for (int val : to_delete) {
            toDeleteSet.add(val);
        }
        List<TreeNode> forest = new ArrayList<>();

        root = processNode(root, toDeleteSet, forest);

        // If the root is not deleted, add it to the forest
        if (root != null) {
            forest.add(root);
        }

        return forest;
    }

    private TreeNode processNode(
        TreeNode node,
        Set<Integer> toDeleteSet,
        List<TreeNode> forest
    ) {
        if (node == null) {
            return null;
        }

        node.left = processNode(node.left, toDeleteSet, forest);
        node.right = processNode(node.right, toDeleteSet, forest);

        // Node Evaluation: Check if the current node needs to be deleted
        if (toDeleteSet.contains(node.val)) {
            // If the node has left or right children, add them to the forest
            if (node.left != null) {
                forest.add(node.left);
            }
            if (node.right != null) {
                forest.add(node.right);
            }
            // Return null to its parent to delete the current node
            return null;
        }

        return node;
    }
}