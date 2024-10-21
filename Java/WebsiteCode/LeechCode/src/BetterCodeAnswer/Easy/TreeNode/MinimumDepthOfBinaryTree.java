package BetterCodeAnswer.Easy.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

import BetterCodeAnswer.Easy.TreeNode.Class.TreeNode;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/minimum-depth-of-binary-tree/">111.Minimum Depth of Binary Tree</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>Given a binary tree, find its minimum depth.</p>

<p>The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.</p>

<p><strong>Note:</strong>&nbsp;A leaf is a node with no children.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/12/ex_depth.jpg" style="width: 432px; height: 302px;">
<pre><strong>Input:</strong> root = [3,9,20,null,null,15,7]
<strong>Output:</strong> 2
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> root = [2,null,3,null,4,null,5,null,6]
<strong>Output:</strong> 5
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the tree is in the range <code>[0, 10<sup>5</sup>]</code>.</li>
	<li><code>-1000 &lt;= Node.val &lt;= 1000</code></li>
</ul>
</div></div>
 */
public class MinimumDepthOfBinaryTree {
    public static void main(String[] args) {
        Object[][] tests = {
            {3,9,20,null,null,15,7},
            {2,null,3,null,4,null,5,null,6}
        };

        for (Object[] arr : tests) {
            TreeNode root = TreeNode.addNode(arr, 0);

            System.out.println(new MinimumDepthOfBinaryTree_Solution().minDepth(root));
        }
    }
}

// 1 ms 61.3 MB
class MinimumDepthOfBinaryTree_Solution {
    public int minDepth(TreeNode root) {
        if(root==null){ return 0; }
        
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int depth=1;
        
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode node=q.remove();
                if(node.left==null && node.right==null){ return depth; }
                if(node.left!=null){ q.add(node.left);}
                if(node.right!=null){ q.add(node.right); }
            }

            depth++;
        }

        return depth;
    }
}

// 1 ms 61.2 MB
class MinimumDepthOfBinaryTree_Solution2 {
    public int minDepth(TreeNode root) {
        if(root==null) {return 0;}

        Queue<TreeNode> q = new LinkedList<>();
        
        q.offer(root);

        int c=1;

        while(q.size()>0){
            int len = q.size();

            for(int i=0;i<len;i++){
                TreeNode node1 = q.poll();
                if(node1.left==null && node1.right==null){ return c;}
                if(node1.left!=null){ q.offer(node1.left); }
                if(node1.right!=null){ q.offer(node1.right); }
            }

            c++;
        }
        
        return c;
    }
}
 