package BetterCodeAnswer.Medium.TreeNode;

import Medium.TreeNode.Class.TreeNode;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/step-by-step-directions-from-a-binary-tree-node-to-another/">2096. Step-By-Step Directions From a Binary Tree Node to Another</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You are given the <code>root</code> of a <strong>binary tree</strong> with <code>n</code> nodes. Each node is uniquely assigned a value from <code>1</code> to <code>n</code>. You are also given an integer <code>startValue</code> representing the value of the start node <code>s</code>, and a different integer <code>destValue</code> representing the value of the destination node <code>t</code>.</p>
 * 
 * <p>Find the <strong>shortest path</strong> starting from node <code>s</code> and ending at node <code>t</code>. Generate step-by-step directions of such path as a string consisting of only the <strong>uppercase</strong> letters <code>'L'</code>, <code>'R'</code>, and <code>'U'</code>. Each letter indicates a specific direction:</p>
 * 
 * <ul>
 * 	<li><code>'L'</code> means to go from a node to its <strong>left child</strong> node.</li>
 * 	<li><code>'R'</code> means to go from a node to its <strong>right child</strong> node.</li>
 * 	<li><code>'U'</code> means to go from a node to its <strong>parent</strong> node.</li>
 * </ul>
 * 
 * <p>Return <em>the step-by-step directions of the <strong>shortest path</strong> from node </em><code>s</code><em> to node</em> <code>t</code>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/11/15/eg1.png" style="width: 214px; height: 163px;">
 * <pre><strong>Input:</strong> root = [5,1,2,3,null,6,4], startValue = 3, destValue = 6
 * <strong>Output:</strong> "UURL"
 * <strong>Explanation:</strong> The shortest path is: 3 → 1 → 5 → 2 → 6.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/11/15/eg2.png" style="width: 74px; height: 102px;">
 * <pre><strong>Input:</strong> root = [2,1], startValue = 2, destValue = 1
 * <strong>Output:</strong> "L"
 * <strong>Explanation:</strong> The shortest path is: 2 → 1.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li>The number of nodes in the tree is <code>n</code>.</li>
 * 	<li><code>2 &lt;= n &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>1 &lt;= Node.val &lt;= n</code></li>
 * 	<li>All the values in the tree are <strong>unique</strong>.</li>
 * 	<li><code>1 &lt;= startValue, destValue &lt;= n</code></li>
 * 	<li><code>startValue != destValue</code></li>
 * </ul>
 * </div>
 */
public class StepByStepDirectionsFromABinaryTreeNodeToAnother {
    public static void main(String[] args) {
        Object[][][] tests = {
            {
                {5,1,2,3,null,6,4},
                {3},
                {6}
            }
        };

        for (Object[][] test : tests) {
            int startValue = (int) test[1][0],
                destValue = (int) test[2][0];
            TreeNode root = TreeNode.addNode(test[0], 0);

            System.out.println(new StepByStepDirectionsFromABinaryTreeNodeToAnother_Solution().getDirections(root, startValue, destValue));
        }
    }
}

// 13 ms 80.6 MB
class StepByStepDirectionsFromABinaryTreeNodeToAnother_Solution {
    static byte[] path = new byte[200_001];
    int strtLevel = -1; 
    int destLevel = -1;
    int comnLevel = -1;
    
    public String getDirections(TreeNode root, int startValue, int destValue) {
        findPaths(root, startValue, destValue, 100_000);
        int answerIdx = comnLevel;
        for (int i = strtLevel; i > comnLevel; i--)  
            path[--answerIdx] = 'U';
        return new String(path, answerIdx, destLevel - answerIdx);
    }
    
    private int findPaths(TreeNode node, int strtVal, int destVal, int level) {
        if (node == null)  return 0;
        int result = 0;
        if (node.val == strtVal) {
            strtLevel = level;
            result = 1;
        } else if (node.val == destVal) {
            destLevel = level;
            result = 1;
        }
        int leftFound = 0;
        int rightFound = 0;
        if (comnLevel < 0) {
            if (destLevel < 0)  path[level] = 'L';
            leftFound = findPaths(node.left, strtVal, destVal, level + 1);
            rightFound = 0;
            if (comnLevel < 0) {
                if (destLevel < 0)  path[level] = 'R';
                rightFound = findPaths(node.right, strtVal, destVal, level + 1);
            }
        }
        if (comnLevel < 0 && leftFound + rightFound + result == 2) 
            comnLevel = level;
        return result | leftFound | rightFound;
    }
}