package BetterCodeAnswer.Easy.TreeNode;

import BetterCodeAnswer.Easy.TreeNode.Class.TreeNode;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/construct-string-from-binary-tree/">606.Construct String from Binary Tree</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>Given the <code>root</code> of a binary tree, construct a string consisting of parenthesis and integers from a binary tree with the preorder traversal way, and return it.</p>

<p>Omit all the empty parenthesis pairs that do not affect the one-to-one mapping relationship between the string and the original binary tree.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/05/03/cons1-tree.jpg" style="width: 292px; height: 301px;">
<pre><strong>Input:</strong> root = [1,2,3,4]
<strong>Output:</strong> "1(2(4))(3)"
<strong>Explanation:</strong> Originally, it needs to be "1(2(4)())(3()())", but you need to omit all the unnecessary empty parenthesis pairs. And it will be "1(2(4))(3)"
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/05/03/cons2-tree.jpg" style="width: 207px; height: 293px;">
<pre><strong>Input:</strong> root = [1,2,3,null,4]
<strong>Output:</strong> "1(2()(4))(3)"
<strong>Explanation:</strong> Almost the same as the first example, except we cannot omit the first parenthesis pair to break the one-to-one mapping relationship between the input and the output.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the tree is in the range <code>[1, 10<sup>4</sup>]</code>.</li>
	<li><code>-1000 &lt;= Node.val &lt;= 1000</code></li>
</ul>
</div></div>
 */
public class ConstructStringFromBinaryTree {
    public static void main(String[] args) {
        Object[][] tests = {
            {1,2,3,4},
            {1,2,3,null,4},
        };

        for (Object[] arr : tests) {
            TreeNode t = TreeNode.addNode(arr,0);
            System.out.println(new ConstructStringFromBinaryTree_Solution().tree2str(t));
        }
    }
}

class ConstructStringFromBinaryTree_Solution {
    StringBuilder builder;
    public String tree2str(TreeNode root) {
        builder = new StringBuilder();
        preorderModified(root);
        return builder.toString();
    }
    void preorderModified(TreeNode node) {
        if (node != null) {
            if (node.left == null && node.right == null)
                builder.append(Integer.toString(node.val));

            else {
                builder.append(Integer.toString(node.val));
                builder.append('(');
                preorderModified(node.left);
                builder.append(')');
                if (node.right != null) {
                    builder.append('(');
                    preorderModified(node.right);
                    builder.append(')');
                }
            }
        }
    }
}