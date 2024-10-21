package Easy.TreeNode;

import java.util.ArrayList;
import java.util.List;

import Easy.TreeNode.Class.TreeNode;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/leaf-similar-trees/">872.Leaf-Similar Trees</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>Consider all the leaves of a binary tree, from&nbsp;left to right order, the values of those&nbsp;leaves form a <strong>leaf value sequence</strong><em>.</em></p>

<p><img alt="" src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/07/16/tree.png" style="width: 400px; height: 336px;"></p>

<p>For example, in the given tree above, the leaf value sequence is <code>(6, 7, 4, 9, 8)</code>.</p>

<p>Two binary trees are considered <em>leaf-similar</em>&nbsp;if their leaf value sequence is the same.</p>

<p>Return <code>true</code> if and only if the two given trees with head nodes <code>root1</code> and <code>root2</code> are leaf-similar.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/09/03/leaf-similar-1.jpg" style="width: 600px; height: 237px;">
<pre><strong>Input:</strong> root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
<strong>Output:</strong> true
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/09/03/leaf-similar-2.jpg" style="width: 300px; height: 110px;">
<pre><strong>Input:</strong> root1 = [1,2,3], root2 = [1,3,2]
<strong>Output:</strong> false
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in each tree will be in the range <code>[1, 200]</code>.</li>
	<li>Both of the given trees will have values in the range <code>[0, 200]</code>.</li>
</ul>
</div></div>
 */
public class LeafSimilarTrees {
    public static void main(String[] args) {
        Object[][][] tests = {
            {{3,5,1,6,2,9,8,null,null,7,4},{3,5,1,6,7,4,2,null,null,null,null,null,null,9,8}},
            {{1,2,3},{1,3,2}},
        };

        for (Object[][] arr : tests) {
            TreeNode root1 = TreeNode.addNode(arr[0],0);
            TreeNode root2 = TreeNode.addNode(arr[1], 0);

            System.out.println(new LeafSimilarTrees_Solution().leafSimilar(root1, root2));
        }
    }
}

// 0 ms 41.6 MB
class LeafSimilarTrees_Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        addLeaf(list1, root1);
        addLeaf(list2, root2);

        if(list1.equals(list2)) {return true;}
        else {return false;}        
    }
    
    private void addLeaf(List<Integer>list , TreeNode root){
        if(root == null){ return;}

        if(root.left == null && root.right==null){ list.add(root.val); return;}
        else{
            addLeaf(list, root.left);
            addLeaf(list, root.right);
        }
    }
}