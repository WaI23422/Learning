package BetterCodeAnswer.Easy.Node;

import Easy.Node.Class.Node;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/maximum-depth-of-n-ary-tree/">559. Maximum Depth of N-ary Tree</a>
 * 
 * <div><div class="elfjS" data-track-load="description_content"><p>Given a n-ary tree, find its maximum depth.</p>
 * 
 * <p>The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.</p>
 * 
 * <p><em>Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).</em></p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <p><img src="https://assets.leetcode.com/uploads/2018/10/12/narytreeexample.png" style="width: 100%; max-width: 300px;"></p>
 * 
 * <pre><strong>Input:</strong> root = [1,null,3,2,4,null,5,6]
 * <strong>Output:</strong> 3
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <p><img alt="" src="https://assets.leetcode.com/uploads/2019/11/08/sample_4_964.png" style="width: 296px; height: 241px;"></p>
 * 
 * <pre><strong>Input:</strong> root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * <strong>Output:</strong> 5
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li>The total number of nodes is in the range <code>[0, 10<sup>4</sup>]</code>.</li>
 * 	<li>The depth of the n-ary tree is less than or equal to <code>1000</code>.</li>
 * </ul>
 * </div></div>
 */
@SuppressWarnings("all") // Test haven't build
public class MaximumDepthOfNaryTree {
    public static void main(String[] args) {
        Object[][] tests = {
            {1,null,3,2,4,null,5,6},
        };

        for (Object[] arr : tests) {
            Node root = new Node();
            
            System.out.println(new NaryTreePostorderTraversal_Solution().postorder(root));
        }
    }
}

// 0ms 42.90MB
class MaximumDepthOfNaryTree_Solution {
    public int maxDepth(Node root) {
        if (root == null) return 0;
        if (root.children == null || root.children.size() == 0) return 1;

        int max = 0;
        for (int i = 0; i < root.children.size(); i++) {
            max = Math.max(max, maxDepth(root.children.get(i)));
        }

        return max + 1;
    }
}