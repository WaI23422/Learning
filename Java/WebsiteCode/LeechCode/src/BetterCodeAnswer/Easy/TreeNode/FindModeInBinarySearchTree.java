package BetterCodeAnswer.Easy.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;

import BetterCodeAnswer.Easy.TreeNode.Class.TreeNode;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/find-mode-in-binary-search-tree/">501.Find Mode in Binary Search Tree</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>Given the <code>root</code> of a binary search tree (BST) with duplicates, return <em>all the <a href="https://en.wikipedia.org/wiki/Mode_(statistics)" target="_blank">mode(s)</a> (i.e., the most frequently occurred element) in it</em>.</p>

<p>If the tree has more than one mode, return them in <strong>any order</strong>.</p>

<p>Assume a BST is defined as follows:</p>

<ul>
	<li>The left subtree of a node contains only nodes with keys <strong>less than or equal to</strong> the node's key.</li>
	<li>The right subtree of a node contains only nodes with keys <strong>greater than or equal to</strong> the node's key.</li>
	<li>Both the left and right subtrees must also be binary search trees.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/03/11/mode-tree.jpg" style="width: 142px; height: 222px;">
<pre><strong>Input:</strong> root = [1,null,2,2]
<strong>Output:</strong> [2]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> root = [0]
<strong>Output:</strong> [0]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the tree is in the range <code>[1, 10<sup>4</sup>]</code>.</li>
	<li><code>-10<sup>5</sup> &lt;= Node.val &lt;= 10<sup>5</sup></code></li>
</ul>

<p>&nbsp;</p>
<strong>Follow up:</strong> Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).</div></div>
 */
public class FindModeInBinarySearchTree {
    static int index;

    public static void addNode(TreeNode root, Integer[] list){
        if (list[index] == null){ return;}

        root.val = list[index];
        index++;

        if (index < list.length){
            if (list[index] != null) {
                root.left = new TreeNode();
                addNode(root.left, list);
            }
            index++;
        }

        if (index < list.length) {
            if (list[index] != null) {
                root.right = new TreeNode();
                addNode(root.right, list);
            }
            index++;
        }
    }

    public static void main(String[] args) {
        Integer[][] tests = {
            {1,null,3,4},
            {1,null,2,2},
            // {0},
            // {1,null,1,1,null,1}
        };

        FindModeInBinarySearchTree_Solution res = new FindModeInBinarySearchTree_Solution();

        for (Integer[] list : tests) {
            index =0;
            TreeNode root = new TreeNode();
            addNode(root, list);

            System.out.println(Arrays.toString(res.findMode(root)));
        }
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class FindModeInBinarySearchTree_Solution {
    TreeNode pre = null;
    int count;
    int maxCount = 0;
    ArrayList<Integer> resList = new ArrayList<>();
    
    // 0 ms
    // 43.2 MB
    public int[] findMode(TreeNode root) {
        recursive(root);
        int[] res = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }
        return res;
    }
    
    void recursive(TreeNode cur) {
        if (cur == null) {
            return;
        }
        recursive(cur.left);
        
        if (pre == null) {
            count = 1;
        } else if (pre.val == cur.val) {
            count++;
        } else {
            count = 1;
        }
        
        if (count > maxCount) {
            maxCount = count;
            resList.clear();
            resList.add(cur.val);
        } else if (count == maxCount) {
            resList.add(cur.val);
        }
        pre = cur;
        
        recursive(cur.right);
    }
}