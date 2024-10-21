package BetterCodeAnswer.Easy.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import Easy.TreeNode.Class.TreeNode;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/binary-tree-paths/">257.Binary Tree Paths</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given the <code>root</code> of a binary tree, return <em>all root-to-leaf paths in <strong>any order</strong></em>.</p>

<p>A <strong>leaf</strong> is a node with no children.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/03/12/paths-tree.jpg" style="width: 207px; height: 293px;">
<pre><strong>Input:</strong> root = [1,2,3,null,5]
<strong>Output:</strong> ["1-&gt;2-&gt;5","1-&gt;3"]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> root = [1]
<strong>Output:</strong> ["1"]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the tree is in the range <code>[1, 100]</code>.</li>
	<li><code>-100 &lt;= Node.val &lt;= 100</code></li>
</ul>
</div>
 */
public class BinaryTreePaths {
    public static void main(String[] args) {
        Object[][] tests = {
            {1,2,3,4},
            {1,2,3,null,5},
            {1}
        };

        for (Object[] arr : tests) {
            TreeNode t = TreeNode.addNode(arr,0);
            System.out.println(new BinaryTreePaths_Solution().binaryTreePaths(t));
        }
    }
}

// 0 ms 42.2 MB
class BinaryTreePaths_Solution {
    List<String> ans = new ArrayList<String>();

    public List<String> binaryTreePaths(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        loop(root, sb);
        return ans;
    }
    private void loop(TreeNode root, StringBuilder sb) {
        if (root==null) {
            return;
        }
        int length = sb.length();
        sb.append(root.val);
        if (root.left==null && root.right==null) {
            ans.add(sb.toString());
        }
        sb.append("->");
        loop(root.left, sb);
        loop(root.right, sb);
        sb.setLength(length);
    }
}

// 1 ms 42.5 MB
class BinaryTreePaths_Solution2 {
    private List<String> result;
    private StringBuilder sb;

    public List<String> binaryTreePaths(TreeNode root) {
        result = new LinkedList<>();
        sb = new StringBuilder();
        if (root == null){
            return result;
        }
        sb.append(root.val);
        if (root.left == null && root.right == null){
            result.add(sb.toString());
        } else {
            if (root.left != null) {
                dfs(root.left);
            }
            if (root.right != null) {
                dfs(root.right);
            }
        }
        return result;
    }

    private void dfs(TreeNode node) {
        int start = sb.length();
        sb.append("->").append(node.val);
        if (node.left == null && node.right == null) {
            result.add(sb.toString());
        } else {
            if (node.left != null) {
                dfs(node.left);
            }
            if (node.right != null) {
                dfs(node.right);
            }
        }
        sb.delete(start, sb.length());
    }
}