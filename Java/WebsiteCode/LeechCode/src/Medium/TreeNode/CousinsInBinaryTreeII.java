package Medium.TreeNode;

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

// 23ms 76.03MB
class CousinsInBinaryTreeII_Solution {
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode[]> root_val = new LinkedList<>();

        root_val.add(new TreeNode[]{null,root});
        int pre_sum = 0;
        while (!root_val.isEmpty()) {
            int size = root_val.size();

            for (int i = 0; i < size; i++) {
                TreeNode[] temp_root = root_val.remove();
                if (temp_root[0] != null) {
                    pre_sum += temp_root[0].val;
                } 
                if (temp_root[1] != null) {
                    pre_sum += temp_root[1].val;
                }
                root_val.add(temp_root);
            }

            for (int i = 0; i < size; i++) {
                TreeNode[] temp_root = root_val.remove();
                if (temp_root[1] != null && temp_root[0] != null) {
                    int extract = temp_root[1].val + temp_root[0].val;
                    temp_root[0].val = pre_sum - extract;
                    temp_root[1].val = pre_sum - extract;
                } else if (temp_root[0] != null) {
                    temp_root[0].val = pre_sum - temp_root[0].val;
                } else if (temp_root[1] != null) {
                    temp_root[1].val = pre_sum - temp_root[1].val;
                }

                if (temp_root[0] != null) {
                    root_val.add(new TreeNode[]{temp_root[0].left,temp_root[0].right});
                }
                if (temp_root[1] != null) {
                    root_val.add(new TreeNode[]{temp_root[1].left,temp_root[1].right});
                }
            }

            pre_sum = 0;
        }
        
        return root;
    }
}