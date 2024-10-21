package BetterCodeAnswer.Medium.TreeNode;

import java.util.Arrays;

import Medium.TreeNode.Class.TreeNode;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/smallest-string-starting-from-leaf/">988. Smallest String Starting From Leaf</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You are given the <code>root</code> of a binary tree where each node has a value in the range <code>[0, 25]</code> representing the letters <code>'a'</code> to <code>'z'</code>.</p>

<p>Return <em>the <strong>lexicographically smallest</strong> string that starts at a leaf of this tree and ends at the root</em>.</p>

<p>As a reminder, any shorter prefix of a string is <strong>lexicographically smaller</strong>.</p>

<ul>
	<li>For example, <code>"ab"</code> is lexicographically smaller than <code>"aba"</code>.</li>
</ul>

<p>A leaf of a node is a node that has no children.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2019/01/30/tree1.png" style="width: 534px; height: 358px;">
<pre><strong>Input:</strong> root = [0,1,2,3,4,3,4]
<strong>Output:</strong> "dba"
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2019/01/30/tree2.png" style="width: 534px; height: 358px;">
<pre><strong>Input:</strong> root = [25,1,3,1,3,0,2]
<strong>Output:</strong> "adz"
</pre>

<p><strong class="example">Example 3:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2019/02/01/tree3.png" style="height: 490px; width: 468px;">
<pre><strong>Input:</strong> root = [2,2,1,null,1,0,null,0]
<strong>Output:</strong> "abc"
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the tree is in the range <code>[1, 8500]</code>.</li>
	<li><code>0 &lt;= Node.val &lt;= 25</code></li>
</ul>
</div>
 */
public class SmallestStringStartingFromLeaf {
    public static void main(String[] args) {
        Object[][] tests = {
            {25,1,3,1,3,0,2},
            {0,1,2,3,4,3,4},
            {1}
        };

        for (Object[] arr : tests) {
            TreeNode root1 = TreeNode.addNode(arr,0);

            System.out.println(new SmallestStringStartingFromLeaf_Solution().smallestFromLeaf(root1));
        }
    }
}

// 0 ms 44.3 MB
class SmallestStringStartingFromLeaf_Solution {

    char[] chs = null;
    int l = 0;
    public String smallestFromLeaf(TreeNode root) {
        int d = depth(root);
        solve(root, new char[d], d-1);
        return new String(chs, l, d-l);
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }

    private void solve(TreeNode node, char[] t, int i) {
        if (node == null) {
            return;
        }
        t[i] = (char) ('a' + node.val);
        if (node.left == null && node.right == null) {
            if (chs == null) {
                chs = Arrays.copyOf(t, t.length);
                l = i;
            } else {
                for (int k = 0, d = Math.max(l, i); k + d < t.length; k++) {
                    if (chs[l+k] < t[i+k]) {
                        return;
                    } else if (chs[l+k] > t[i+k]) {
                        chs = Arrays.copyOf(t, t.length);
                        l = i;
                        return;
                    }
                }
                if (l < i) {
                    chs = Arrays.copyOf(t, t.length);
                    l = i;
                }
            }
            return;
        }
        solve(node.left, t, i-1);
        solve(node.right, t, i-1);
    }
}