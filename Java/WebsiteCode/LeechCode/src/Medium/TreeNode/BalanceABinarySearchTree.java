package Medium.TreeNode;

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

// 2 ms 45.6 MB
class BalanceABinarySearchTree_Solution {
    public TreeNode balanceBST(TreeNode root) {
        inOrder(root);
        return bst(0, ordered.size() - 1);
    }

    private TreeNode bst(int start, int end) {
        if (start > end) return null;
        else if (start == end) {
            TreeNode ret = ordered.get(start);
            ret.left = null;
            ret.right = null;
            return ret;
        } else {
            int mid = start + (end - start) / 2;
            TreeNode ret = ordered.get(mid);
            ret.left = bst(start, mid - 1);
            ret.right = bst(mid + 1, end);
            return ret;
        }
    }

    private void inOrder(TreeNode node) {
        if (node == null) return;
        inOrder(node.left);
        ordered.add(node);
        inOrder(node.right);
    }
    
    private List<TreeNode> ordered = new ArrayList<>();
}
