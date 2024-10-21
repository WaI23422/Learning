package Easy.TreeNode;

import Easy.TreeNode.Class.TreeNode;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/sum-of-left-leaves/">404. Sum of Left Leaves</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given the <code>root</code> of a binary tree, return <em>the sum of all left leaves.</em></p>

<p>A <strong>leaf</strong> is a node with no children. A <strong>left leaf</strong> is a leaf that is the left child of another node.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/04/08/leftsum-tree.jpg" style="width: 277px; height: 302px;">
<pre><strong>Input:</strong> root = [3,9,20,null,null,15,7]
<strong>Output:</strong> 24
<strong>Explanation:</strong> There are two left leaves in the binary tree, with values 9 and 15 respectively.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> root = [1]
<strong>Output:</strong> 0
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the tree is in the range <code>[1, 1000]</code>.</li>
	<li><code>-1000 &lt;= Node.val &lt;= 1000</code></li>
</ul>
</div>
 */
public class SumOfLeftLeaves {
    public static void main(String[] args) {
        Object[][] tests = {
            {1,2,3,4,5},
            {1,2},
            {3,9,20,null,null,15,7},
            {1,2,3,null,4},
            {1},
        };

        for (Object[] arr : tests) {
            TreeNode root = TreeNode.addNode(arr,0);
            System.out.println(new SumOfLeftLeaves_Solution().sumOfLeftLeaves(root));
        }
    }
}

class SumOfLeftLeaves_Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null){return 0;}
    
        int ans = 0;

        TreeNode rootLeft = root.left;
        if (rootLeft != null) {
            if (rootLeft.left == null && rootLeft.right == null){ ans += rootLeft.val;}
            else {ans += sumOfLeftLeaves(root.left);}
        }
        ans += sumOfLeftLeaves(root.right);
    
        return ans;
    }
}