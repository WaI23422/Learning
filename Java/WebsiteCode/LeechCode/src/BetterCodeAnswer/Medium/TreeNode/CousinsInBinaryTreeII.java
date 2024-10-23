package BetterCodeAnswer.Medium.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import Medium.TreeNode.Class.TreeNode;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/cousins-in-binary-tree-ii/">2641. Cousins in Binary Tree II</a>
 * 
 * <div><div class="elfjS" data-track-load="description_content"><p>Given the <code>root</code> of a binary tree, replace the value of each node in the tree with the <strong>sum of all its cousins' values</strong>.</p>
 * 
 * <p>Two nodes of a binary tree are <strong>cousins</strong> if they have the same depth with different parents.</p>
 * 
 * <p>Return <em>the </em><code>root</code><em> of the modified tree</em>.</p>
 * 
 * <p><strong>Note</strong> that the depth of a node is the number of edges in the path from the root node to it.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2023/01/11/example11.png" style="width: 571px; height: 151px;">
 * <pre><strong>Input:</strong> root = [5,4,9,1,10,null,7]
 * <strong>Output:</strong> [0,0,0,7,7,null,11]
 * <strong>Explanation:</strong> The diagram above shows the initial binary tree and the binary tree after changing the value of each node.
 * - Node with value 5 does not have any cousins so its sum is 0.
 * - Node with value 4 does not have any cousins so its sum is 0.
 * - Node with value 9 does not have any cousins so its sum is 0.
 * - Node with value 1 has a cousin with value 7 so its sum is 7.
 * - Node with value 10 has a cousin with value 7 so its sum is 7.
 * - Node with value 7 has cousins with values 1 and 10 so its sum is 11.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2023/01/11/diagram33.png" style="width: 481px; height: 91px;">
 * <pre><strong>Input:</strong> root = [3,1,2]
 * <strong>Output:</strong> [0,0,0]
 * <strong>Explanation:</strong> The diagram above shows the initial binary tree and the binary tree after changing the value of each node.
 * - Node with value 3 does not have any cousins so its sum is 0.
 * - Node with value 1 does not have any cousins so its sum is 0.
 * - Node with value 2 does not have any cousins so its sum is 0.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li>The number of nodes in the tree is in the range <code>[1, 10<sup>5</sup>]</code>.</li>
 * 	<li><code>1 &lt;= Node.val &lt;= 10<sup>4</sup></code></li>
 * </ul>
 * </div></div>
 */
public class CousinsInBinaryTreeII {
    public static void main(String[] args) {
        Object[][] tests = {
            {5,4,9,1,10,null,7},
        };

        for (Object[] arr : tests) {
            TreeNode root = TreeNode.addNode(arr,0);

            System.out.println(Arrays.toString(TreeNode.toArray(new CousinsInBinaryTreeII_Solution().replaceValueInTree(root))));
        }
    }    
}

// 6ms 73.21MB
class CousinsInBinaryTreeII_Solution {
    static final TreeNode[] nodes = new TreeNode[50_000];
    
    public TreeNode replaceValueInTree(TreeNode root) {
        nodes[0] = root;
        int sumL = root.val;
        int sumR = 0;
        final int startL = 0;
        final int startR = nodes.length - 1;
        int lastL = startL + 1;
        int lastR = startR;
        TreeNode node = null;
        
        while (lastL != 0) {
            sumR = 0;
            while (lastL > 0) {
                node = nodes[--lastL];
                node.val = sumL - node.val;
                if (node.left != null) {
                    if (node.right != null) {    // If two children.
                        sumR += node.left.val = node.right.val = 
                                    node.left.val + node.right.val;
                        nodes[lastR--] = node.left;
                        nodes[lastR--] = node.right;
                    } else {                     // If left child only.
                        sumR += node.left.val;
                        nodes[lastR--] = node.left;
                    }
                } else if (node.right != null) { // If right child only.
                    sumR += node.right.val;
                    nodes[lastR--] = node.right;
                }
            }
            if (lastR == startR)  break;    // If no more levels.
            // Process the list of nodes on the right side of 
            // nodes[] while building the list of the next level's 
            // nodes on the left side of nodes[].
            sumL = 0;
            while (lastR < startR) {
                node = nodes[++lastR];
                node.val = sumR - node.val;
                if (node.left != null) {
                    if (node.right != null) {    // If two children.
                        sumL += node.left.val = node.right.val = 
                                    node.left.val + node.right.val;
                        nodes[lastL++] = node.left;
                        nodes[lastL++] = node.right;
                    } else {                     // If left child only.
                        sumL += node.left.val;
                        nodes[lastL++] = node.left;
                    }
                } else if (node.right != null) { // If right child only.
                    sumL += node.right.val;
                    nodes[lastL++] = node.right;
                }
            }
        }
        return root;
    }
}

// 13ms 77.3MB
class Solution {
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int currLvlSum = root.val;
        while (!queue.isEmpty()) {
            int n = queue.size();
            int nextLvlSum = 0;
            for(int i = 0; i < n; i++){
                TreeNode node = queue.poll();
                node.val = currLvlSum - node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                    nextLvlSum += node.left.val;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    nextLvlSum += node.right.val;
                }

                if (node.left != null && node.right != null) {
                    int sum = node.left.val + node.right.val;
                    node.left.val = node.right.val = sum;
                }
            }
            currLvlSum = nextLvlSum;
        }
        return root;
    }
}