package Easy.TreeNode;

import Easy.TreeNode.Class.TreeNode;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/range-sum-of-bst/">938.Range Sum of BST</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>Given the <code>root</code> node of a binary search tree and two integers <code>low</code> and <code>high</code>, return <em>the sum of values of all nodes with a value in the <strong>inclusive</strong> range </em><code>[low, high]</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/05/bst1.jpg" style="width: 400px; height: 222px;">
<pre><strong>Input:</strong> root = [10,5,15,3,7,null,18], low = 7, high = 15
<strong>Output:</strong> 32
<strong>Explanation:</strong> Nodes 7, 10, and 15 are in the range [7, 15]. 7 + 10 + 15 = 32.
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/05/bst2.jpg" style="width: 400px; height: 335px;">
<pre><strong>Input:</strong> root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
<strong>Output:</strong> 23
<strong>Explanation:</strong> Nodes 6, 7, and 10 are in the range [6, 10]. 6 + 7 + 10 = 23.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the tree is in the range <code>[1, 2 * 10<sup>4</sup>]</code>.</li>
	<li><code>1 &lt;= Node.val &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= low &lt;= high &lt;= 10<sup>5</sup></code></li>
	<li>All <code>Node.val</code> are <strong>unique</strong>.</li>
</ul>
</div></div>
 */
public class RangeSumOfBST {
    public static void main(String[] args) {
        Object[][][] tests = {
            {{10,5,15,3,7,null,18},{7},{15}},
            {{10,5,15,3,7,13,18,1,null,6},{6},{10}},
        };

        for (Object[][] arr : tests) {
            TreeNode root = TreeNode.addNode(arr[0],0);
            int low = (int) arr[1][0], high = (int) arr[2][0];
            
            System.out.println(new RangeSumOfBST_Solution().rangeSumBST(root, low, high));;
        }
    }
}

// 1 ms 50.8 MB
class RangeSumOfBST_Solution {
    int total = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {return total;}

        if (root.val >= low && root.val <= high) {total += root.val;}
        
        rangeSumBST(root.left, low, high);
        rangeSumBST(root.right, low, high);

        return total;
    }
}