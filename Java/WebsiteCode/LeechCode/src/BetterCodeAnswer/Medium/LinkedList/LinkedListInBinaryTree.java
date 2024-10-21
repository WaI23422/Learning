package BetterCodeAnswer.Medium.LinkedList;

import Medium.LinkedList.Class.ListNode;
import Medium.TreeNode.Class.TreeNode;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;


public class LinkedListInBinaryTree {
    public static void main(String[] args) {
        Object[][][] tests = {
            {
                {4,2,8},
                {1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3}
            }    
        }; 

        for (Object[][] test : tests) {
            ListNode head = ListNode.addNode(
                Arrays.stream(test[0])
                      .mapToInt(x-> (int) x)
                      .toArray()
                , 0);
            TreeNode root = TreeNode.addNode(test[1],0);
            
            System.out.println(new LinkedListInBinaryTree_Solution().isSubPath(head, root));
        }
    }
}

// 1ms 44.94MB
class LinkedListInBinaryTree_Solution {

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) return false;
        return (
            dfs(root, head) ||
            isSubPath(head, root.left) ||
            isSubPath(head, root.right)
        );
    }

    private boolean dfs(TreeNode node, ListNode head) {
        if (head == null) return true; // All nodes in the list matched
        if (node == null) return false; // Reached end of tree without matching all nodes
        if (node.val != head.val) return false; // Value mismatch
        // Check both left and right children
        return dfs(node.left, head.next) || dfs(node.right, head.next);
    }
}

// 1ms 45.28MB
class LinkedListInBinaryTree_Solution2 {

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) return false;
        return checkPath(root, head);
    }

    private boolean checkPath(TreeNode node, ListNode head) {
        if (node == null) return false;
        if (dfs(node, head)) return true; // If a matching path is found
        // Recursively check left and right subtrees
        return checkPath(node.left, head) || checkPath(node.right, head);
    }

    private boolean dfs(TreeNode node, ListNode head) {
        if (head == null) return true; // All nodes in the list matched
        if (node == null) return false; // Reached end of tree without matching all nodes
        if (node.val != head.val) return false; // Value mismatch
        return dfs(node.left, head.next) || dfs(node.right, head.next);
    }
}

// 1ms 45.20MB Knuth-Morris-Pratt (KMP) Algorithm
class LinkedListInBinaryTree_Solution3 {

    public boolean isSubPath(ListNode head, TreeNode root) {
        // Build the pattern and prefix table from the linked list
        List<Integer> pattern = new ArrayList<>();
        List<Integer> prefixTable = new ArrayList<>();
        pattern.add(head.val);
        prefixTable.add(0);
        int patternIndex = 0;
        head = head.next;

        while (head != null) {
            while (patternIndex > 0 && head.val != pattern.get(patternIndex)) {
                patternIndex = prefixTable.get(patternIndex - 1);
            }
            patternIndex += head.val == pattern.get(patternIndex) ? 1 : 0;
            pattern.add(head.val);
            prefixTable.add(patternIndex);
            head = head.next;
        }

        // Perform DFS to search for the pattern in the tree
        return searchInTree(root, 0, pattern, prefixTable);
    }

    private boolean searchInTree(
        TreeNode node,
        int patternIndex,
        List<Integer> pattern,
        List<Integer> prefixTable
    ) {
        if (node == null) return false;

        while (patternIndex > 0 && node.val != pattern.get(patternIndex)) {
            patternIndex = prefixTable.get(patternIndex - 1);
        }
        patternIndex += node.val == pattern.get(patternIndex) ? 1 : 0;

        // Check if the pattern is fully matched
        if (patternIndex == pattern.size()) return true;

        // Recursively search left and right subtrees
        return (
            searchInTree(node.left, patternIndex, pattern, prefixTable) ||
            searchInTree(node.right, patternIndex, pattern, prefixTable)
        );
    }
}