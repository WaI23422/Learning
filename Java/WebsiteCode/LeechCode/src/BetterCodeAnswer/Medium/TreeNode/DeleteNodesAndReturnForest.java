package BetterCodeAnswer.Medium.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
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

// 3ms 44.29 MB
class DeleteNodesAndReturnForest_Solution {

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if (root == null) {
            return new ArrayList<>();
        }

        Set<Integer> toDeleteSet = new HashSet<>();
        for (int val : to_delete) {
            toDeleteSet.add(val);
        }

        List<TreeNode> forest = new ArrayList<>();

        Queue<TreeNode> nodesQueue = new LinkedList<>();
        nodesQueue.add(root);

        while (!nodesQueue.isEmpty()) {
            TreeNode currentNode = nodesQueue.poll();

            if (currentNode.left != null) {
                nodesQueue.add(currentNode.left);
                // Disconnect the left child if it needs to be deleted
                if (toDeleteSet.contains(currentNode.left.val)) {
                    currentNode.left = null;
                }
            }

            if (currentNode.right != null) {
                nodesQueue.add(currentNode.right);
                // Disconnect the right child if it needs to be deleted
                if (toDeleteSet.contains(currentNode.right.val)) {
                    currentNode.right = null;
                }
            }

            // If the current node needs to be deleted, add its non-null children to the forest
            if (toDeleteSet.contains(currentNode.val)) {
                if (currentNode.left != null) {
                    forest.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    forest.add(currentNode.right);
                }
            }
        }

        // Ensure the root is added to the forest if it is not to be deleted
        if (!toDeleteSet.contains(root.val)) {
            forest.add(root);
        }

        return forest;
    }
}

// 0ms 44.76mb
class DeleteNodesAndReturnForest_Solution2 {
    private boolean[] s = new boolean[1001];
    private List<TreeNode> ans = new ArrayList<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for (int x : to_delete) {
            s[x] = true;
        }
        if (dfs(root) != null) {
            ans.add(root);
        }
        return ans;
    }

    private TreeNode dfs(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = dfs(root.left);
        root.right = dfs(root.right);
        if (!s[root.val]) {
            return root;
        }
        if (root.left != null) {
            ans.add(root.left);
        }
        if (root.right != null) {
            ans.add(root.right);
        }
        return null;
    }
}