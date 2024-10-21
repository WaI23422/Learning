package Easy.TreeNode;

import java.util.ArrayList;
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

// 10 ms 42.4 MB
class BinaryTreePaths_Solution1 {
    final List<String> store = new ArrayList<>();
    
    public List<String> binaryTreePaths(TreeNode root) {
        addString(root, "");
        
        return store;
    }

    private void addString(TreeNode root, String s) {
        if (root.left == null && root.right == null) {
            s += root.val ;
            store.add(s.toString());
        } else {
            s += root.val +"->";
        }

        if (root.left != null) {
            addString(root.left, s);
        }

        if (root.right != null) {
            addString(root.right, s);
        }
    }
}

// 5 ms 42.6 MB
class BinaryTreePaths_Solution {
    final List<String> store = new ArrayList<>();
    
    public List<String> binaryTreePaths(TreeNode root) {
        addString(root, new StringBuilder());
        
        return store;
    }

    private void addString(TreeNode root, StringBuilder s) {
        if (root.left == null && root.right == null) {
            s.append(root.val) ;
            store.add(s.toString());
        } else {
            s.append(root.val +"->");
        }

        StringBuilder sCopy = new StringBuilder(s);
        if (root.left != null) {
            addString(root.left, s);
        }

        if (root.right != null) {
            addString(root.right, sCopy);
        }
    }
}