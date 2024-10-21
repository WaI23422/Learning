package Medium.TreeNode;

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

// Memory Limit Exceeded -> 34 ms 87.6 MB
class StepByStepDirectionsFromABinaryTreeNodeToAnother_Solution {
    private int startValue,
                destValue;
    private char[] startPath,
                   destPath;

    public String getDirections(TreeNode root, int startValue, int destValue) {
        this.startValue = startValue;
        this.destValue = destValue;

        // goThroughTree(root, "");
        goThroughTree(root, new StringBuilder());

        StringBuilder path = new StringBuilder();
        int countSamePath = 0,
            minPath = startPath.length > destPath.length ? destPath.length : startPath.length;
        while (countSamePath < minPath) {
            if (startPath[countSamePath] != destPath[countSamePath]) {
                break;
            }
            countSamePath++;
        }

        path.repeat('U', startPath.length-countSamePath);

        for (int i = countSamePath; i < destPath.length; i++) {
            path.append(destPath[i]);
        }
        
        return path.toString();
    }

    // private void goThroughTree(TreeNode root, String prePath){
    private void goThroughTree(TreeNode root, StringBuilder prePath){
        if (root == null) {return;}   

        // if (root.val == startValue) {startPath = prePath.toCharArray();}
        // if (root.val == destValue) {destPath = prePath.toCharArray();}
        if (root.val == startValue) {startPath = prePath.toString().toCharArray();}
        if (root.val == destValue) {destPath = prePath.toString().toCharArray();}

        // goThroughTree(root.left, prePath+"L");
        // goThroughTree(root.right, prePath+"R");
        goThroughTree(root.left, prePath.append("L"));
        prePath.deleteCharAt(prePath.length()-1);
        goThroughTree(root.right, prePath.append("R"));
        prePath.deleteCharAt(prePath.length()-1);
    }
}