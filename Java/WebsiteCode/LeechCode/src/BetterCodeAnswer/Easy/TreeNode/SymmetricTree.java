package BetterCodeAnswer.Easy.TreeNode;

import BetterCodeAnswer.Easy.TreeNode.Class.TreeNode;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/convert-sorted-array-to-binary-search-tree/">108.Convert Sorted Array to Binary Search Tree</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>Given an integer array <code>nums</code> where the elements are sorted in <strong>ascending order</strong>, convert <em>it to a </em><span data-keyword="height-balanced" class=" cursor-pointer relative text-dark-blue-s text-sm"><div class="popover-wrapper inline-block" data-headlessui-state=""><div><div aria-expanded="false" data-headlessui-state="" id="headlessui-popover-button-:rj:"><div><strong><em>height-balanced</em></strong></div></div><div style="position: fixed; z-index: 40; inset: 0px auto auto 0px; transform: translate(81px, 290px);"></div></div></div></span> <em>binary search tree</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/18/btree1.jpg" style="width: 302px; height: 222px;">
<pre><strong>Input:</strong> nums = [-10,-3,0,5,9]
<strong>Output:</strong> [0,-3,9,-10,null,5]
<strong>Explanation:</strong> [0,-10,5,null,-3,null,9] is also accepted:
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/18/btree2.jpg" style="width: 302px; height: 222px;">
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/18/btree.jpg" style="width: 342px; height: 142px;">
<pre><strong>Input:</strong> nums = [1,3]
<strong>Output:</strong> [3,1]
<strong>Explanation:</strong> [1,null,3] and [3,1] are both height-balanced BSTs.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
	<li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
	<li><code>nums</code> is sorted in a <strong>strictly increasing</strong> order.</li>
</ul>
</div></div>
 */
public class SymmetricTree {
    public static void main(String[] args) {
        Object[][] tests = {
            {1,2,2,3,4,4,3},
            {1,2,2,null,3,null,3},
        };

        for (Object[] nums : tests) {
            System.out.println(new SymmetricTree_Solution().isSymmetric(TreeNode.addNode(nums, 0)));
        }
    }
}

// 0 ms 41.3 MB
class SymmetricTree_Solution {
   public boolean isSymmetric(TreeNode root) {
    return isMirror(root, root);
}

public boolean isMirror(TreeNode t1, TreeNode t2) {
   if(t1==null && t2==null) return true;
   if(t1==null || t2==null) return false;

   return (t1.val==t2.val && isMirror(t1.left,t2.right) && isMirror(t1.right,t2.left));
}
}