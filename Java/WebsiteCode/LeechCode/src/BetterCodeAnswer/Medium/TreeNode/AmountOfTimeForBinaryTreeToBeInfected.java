package BetterCodeAnswer.Medium.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import BetterCodeAnswer.Medium.TreeNode.Class.TreeNode;

/**
 * AmountOfTimeForBinaryTreeToBeInfected
 */
public class AmountOfTimeForBinaryTreeToBeInfected {
    public static void main(String[] args) {
        Object[][][] tests = {
            {{1,5,3,null,4,10,6,9,2},{3}},
            {{1},{1}},
        };

        for (Object[][] arr : tests) {
            TreeNode root1 = TreeNode.addNode(arr[0],0);
            int start = (int) arr[1][0];

            System.out.println(new AmountOfTimeForBinaryTreeToBeInfected_Solution().amountOfTime(root1, start));
        }
    }
}

// 8 ms 78.6 MB
class AmountOfTimeForBinaryTreeToBeInfected_Solution2 {
    private int ans;

    public int amountOfTime(TreeNode root, int start) {
        dfs(root, start);
        return ans;
    }

    public int dfs(TreeNode root, int start) {
        if (root == null) return 0;

        int leftDepth = dfs(root.left, start);
        int rightDepth = dfs(root.right, start);

        if (root.val == start) {
            ans = Math.max(leftDepth, rightDepth);
            return -1;
        } else if (leftDepth >= 0 && rightDepth >= 0) {
            return Math.max(leftDepth, rightDepth) + 1;
        } else {
            ans = Math.max(ans, Math.abs(leftDepth - rightDepth));
            return Math.min(leftDepth, rightDepth) - 1;
        }
    }
}

// 101 ms 119.8 MB
class AmountOfTimeForBinaryTreeToBeInfected_Solution {
    private Map<Integer, List<Integer>> adjacencyList = new HashMap<>();

    public int amountOfTime(TreeNode root, int start) {
        convertToGraph(root);
        Deque<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
      
        queue.offer(start);
        int time = -1; 
      
        while (!queue.isEmpty()) {
            time++;
            for (int i = queue.size(); i > 0; i--) {
                int currentNode = queue.pollFirst();
                visited.add(currentNode);
              
                if (adjacencyList.containsKey(currentNode)) {
                    for (int neighbor : adjacencyList.get(currentNode)) {
                        if (!visited.contains(neighbor)) {
                            queue.offer(neighbor);
                        }
                    }
                }
            }
        }
        return time;
    }

    private void convertToGraph(TreeNode node) {
        if (node == null) {
            return;
        }
      
        if (node.left != null) {
            adjacencyList.computeIfAbsent(node.val, k -> new ArrayList<>()).add(node.left.val);
            adjacencyList.computeIfAbsent(node.left.val, k -> new ArrayList<>()).add(node.val);
        }
      
        if (node.right != null) {
            adjacencyList.computeIfAbsent(node.val, k -> new ArrayList<>()).add(node.right.val);
            adjacencyList.computeIfAbsent(node.right.val, k -> new ArrayList<>()).add(node.val);
        }
      
        
        convertToGraph(node.left);
        convertToGraph(node.right);
    }
}