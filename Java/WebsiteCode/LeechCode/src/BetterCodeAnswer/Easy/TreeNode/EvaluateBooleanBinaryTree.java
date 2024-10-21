package BetterCodeAnswer.Easy.TreeNode;

import Easy.TreeNode.Class.TreeNode;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/evaluate-boolean-binary-tree/">2331. Evaluate Boolean Binary Tree</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You are given the <code>root</code> of a <strong>full binary tree</strong> with the following properties:</p>

<ul>
	<li><strong>Leaf nodes</strong> have either the value <code>0</code> or <code>1</code>, where <code>0</code> represents <code>False</code> and <code>1</code> represents <code>True</code>.</li>
	<li><strong>Non-leaf nodes</strong> have either the value <code>2</code> or <code>3</code>, where <code>2</code> represents the boolean <code>OR</code> and <code>3</code> represents the boolean <code>AND</code>.</li>
</ul>

<p>The <strong>evaluation</strong> of a node is as follows:</p>

<ul>
	<li>If the node is a leaf node, the evaluation is the <strong>value</strong> of the node, i.e. <code>True</code> or <code>False</code>.</li>
	<li>Otherwise, <strong>evaluate</strong> the node's two children and <strong>apply</strong> the boolean operation of its value with the children's evaluations.</li>
</ul>

<p>Return<em> the boolean result of <strong>evaluating</strong> the </em><code>root</code><em> node.</em></p>

<p>A <strong>full binary tree</strong> is a binary tree where each node has either <code>0</code> or <code>2</code> children.</p>

<p>A <strong>leaf node</strong> is a node that has zero children.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2022/05/16/example1drawio1.png" style="width: 700px; height: 252px;">
<pre><strong>Input:</strong> root = [2,1,3,null,null,0,1]
<strong>Output:</strong> true
<strong>Explanation:</strong> The above diagram illustrates the evaluation process.
The AND node evaluates to False AND True = False.
The OR node evaluates to True OR False = True.
The root node evaluates to True, so we return true.</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> root = [0]
<strong>Output:</strong> false
<strong>Explanation:</strong> The root node is a leaf node and it evaluates to false, so we return false.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the tree is in the range <code>[1, 1000]</code>.</li>
	<li><code>0 &lt;= Node.val &lt;= 3</code></li>
	<li>Every node has either <code>0</code> or <code>2</code> children.</li>
	<li>Leaf nodes have a value of <code>0</code> or <code>1</code>.</li>
	<li>Non-leaf nodes have a value of <code>2</code> or <code>3</code>.</li>
</ul>
</div>
 */
public class EvaluateBooleanBinaryTree {
    public static void main(String[] args) {
        Object[][] tests = {
            {3,3,2,0,0,3,2,null,null,null,null,1,3,1,1,null,null,2,1,null,null,null,null,1,1,null,null,null,null,null,null},
            {1,2,3,4},
        };

        for (Object[] arr : tests) {
            TreeNode root = TreeNode.addNode(arr,0);
            System.out.println(new EvaluateBooleanBinaryTree_Solution().evaluateTree(root));
        }
    }
}

// 0 ms 44.3 MB
class EvaluateBooleanBinaryTree_Solution {
    public boolean helper(TreeNode root) {
        if(root.val == 0 || root.val == 1) {
            return root.val == 1;
        } else if(root.val == 2) {
            return helper(root.left) || helper(root.right);
        } else if(root.val == 3) {
            return helper(root.left) && helper(root.right);
        } 

        return false;
    }
    public boolean evaluateTree(TreeNode root) {
        return helper(root);
    }
}