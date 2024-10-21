package Medium.TreeNode;

import java.util.ArrayList;
import java.util.List;

import Medium.TreeNode.Class.TreeNode;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/find-largest-value-in-each-tree-row/">515.Find Largest Value in Each Tree Row</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>Given the <code>root</code> of a binary tree, return <em>an array of the largest value in each row</em> of the tree <strong>(0-indexed)</strong>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/08/21/largest_e1.jpg" style="width: 200px; height: 172px;">
<pre><strong>Input:</strong> root = [1,3,2,5,3,null,9]
<strong>Output:</strong> [1,3,9]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> root = [1,2,3]
<strong>Output:</strong> [1,3]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the tree will be in the range <code>[0, 10<sup>4</sup>]</code>.</li>
	<li><code>-2<sup>31</sup> &lt;= Node.val &lt;= 2<sup>31</sup> - 1</code></li>
</ul>
</div></div>
 */
public class FindLargestValueInEachTreeRow {
    public static void main(String[] args) {
        TreeNode branch1 = new TreeNode(3);
        TreeNode branch2 = new TreeNode(2);
        TreeNode test = new TreeNode(1, branch1, branch2);
        
        FindLargestValueInEachTreeRow_Solution res = new FindLargestValueInEachTreeRow_Solution();

        System.out.println(res.largestValues(test).toString());
    }
}

class FindLargestValueInEachTreeRow_Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        // @see BetterCodeAnswer.Medium.Array.FindLargestValueInEachTreeRow.java;

        return res;
    }
}


