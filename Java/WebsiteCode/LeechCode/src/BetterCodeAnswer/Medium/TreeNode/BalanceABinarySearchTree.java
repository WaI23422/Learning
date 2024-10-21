package BetterCodeAnswer.Medium.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Medium.TreeNode.Class.TreeNode;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/balance-a-binary-search-tree/">1382. Balance a Binary Search Tree</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given the <code>root</code> of a binary search tree, return <em>a <strong>balanced</strong> binary search tree with the same node values</em>. If there is more than one answer, return <strong>any of them</strong>.</p>
 * 
 * <p>A binary search tree is <strong>balanced</strong> if the depth of the two subtrees of every node never differs by more than <code>1</code>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/08/10/balance1-tree.jpg" style="width: 500px; height: 319px;">
 * <pre><strong>Input:</strong> root = [1,null,2,null,3,null,4,null,null]
 * <strong>Output:</strong> [2,1,3,null,null,null,4]
 * <b>Explanation:</b> This is not the only correct answer, [3,1,4,null,2] is also correct.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/08/10/balanced2-tree.jpg" style="width: 224px; height: 145px;">
 * <pre><strong>Input:</strong> root = [2,1,3]
 * <strong>Output:</strong> [2,1,3]
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li>The number of nodes in the tree is in the range <code>[1, 10<sup>4</sup>]</code>.</li>
 * 	<li><code>1 &lt;= Node.val &lt;= 10<sup>5</sup></code></li>
 * </ul>
 * </div>
 */
public class BalanceABinarySearchTree {
    public static void main(String[] args) {
        Object[][] tests = {
            {4,1,6,0,2,5,7,null,null,null,3,null,null,null,8},
        };

        for (Object[] arr : tests) {
            TreeNode root = TreeNode.addNode(arr,0);

            System.out.println(Arrays.toString(TreeNode.toArray(new BalanceABinarySearchTree_Solution().balanceBST(root))));
        }
    }
}

// 5 ms 45.3 MB
class BalanceABinarySearchTree_Solution {

    public TreeNode balanceBST(TreeNode root) {
        if (root == null) return null;

        // Step 1: Create the backbone (vine)
        // Temporary dummy node
        TreeNode vineHead = new TreeNode(0);
        vineHead.right = root;
        TreeNode current = vineHead;
        while (current.right != null) {
            if (current.right.left != null) {
                rightRotate(current, current.right);
            } else {
                current = current.right;
            }
        }

        // Step 2: Count the nodes
        int nodeCount = 0;
        current = vineHead.right;
        while (current != null) {
            ++nodeCount;
            current = current.right;
        }

        // Step 3: Create a balanced BST
        int m =
            (int) Math.pow(
                2,
                Math.floor(Math.log(nodeCount + 1) / Math.log(2))
            ) -
            1;
        makeRotations(vineHead, nodeCount - m);
        while (m > 1) {
            m /= 2;
            makeRotations(vineHead, m);
        }

        TreeNode balancedRoot = vineHead.right;
        return balancedRoot;
    }

    // Function to perform a right rotation
    private void rightRotate(TreeNode parent, TreeNode node) {
        TreeNode tmp = node.left;
        node.left = tmp.right;
        tmp.right = node;
        parent.right = tmp;
    }

    // Function to perform a left rotation
    private void leftRotate(TreeNode parent, TreeNode node) {
        TreeNode tmp = node.right;
        node.right = tmp.left;
        tmp.left = node;
        parent.right = tmp;
    }

    // Function to perform a series of left rotations to balance the vine
    private void makeRotations(TreeNode vineHead, int count) {
        TreeNode current = vineHead;
        for (int i = 0; i < count; ++i) {
            TreeNode tmp = current.right;
            leftRotate(current, tmp);
            current = current.right;
        }
    }
}

// 2 ms 45.6 MB
class BalanceABinarySearchTree_Solution2 {

    public TreeNode balanceBST(TreeNode root) {
        // Create a list to store the inorder traversal of the BST
        List<Integer> inorder = new ArrayList<>();
        inorderTraversal(root, inorder);

        // Construct and return the balanced BST
        return createBalancedBST(inorder, 0, inorder.size() - 1);
    }

    private void inorderTraversal(TreeNode root, List<Integer> inorder) {
        // Perform an inorder traversal to store the elements in sorted order
        if (root == null) return;
        inorderTraversal(root.left, inorder);
        inorder.add(root.val);
        inorderTraversal(root.right, inorder);
    }

    private TreeNode createBalancedBST(
        List<Integer> inorder,
        int start,
        int end
    ) {
        // Base case: if the start index is greater than the end index, return null
        if (start > end) return null;

        // Find the middle element of the current range
        int mid = start + (end - start) / 2;

        // Recursively construct the left and right subtrees
        TreeNode leftSubtree = createBalancedBST(inorder, start, mid - 1);
        TreeNode rightSubtree = createBalancedBST(inorder, mid + 1, end);

        // Create a new node with the middle element and attach the subtrees
        TreeNode node = new TreeNode(
            inorder.get(mid),
            leftSubtree,
            rightSubtree
        );
        return node;
    }
}