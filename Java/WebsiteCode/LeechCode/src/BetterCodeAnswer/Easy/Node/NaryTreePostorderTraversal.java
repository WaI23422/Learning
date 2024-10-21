package BetterCodeAnswer.Easy.Node;

import java.util.ArrayList;
import java.util.List;

import Easy.Node.Class.Node;


/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/n-ary-tree-postorder-traversal/">590. N-ary Tree Postorder Traversal</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given the <code>root</code> of an n-ary tree, return <em>the postorder traversal of its nodes' values</em>.</p>
 * 
 * <p>Nary-Tree input serialization is represented in their level order traversal. Each group of children is separated by the null value (See examples)</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img src="https://assets.leetcode.com/uploads/2018/10/12/narytreeexample.png" style="width: 100%; max-width: 300px;">
 * <pre><strong>Input:</strong> root = [1,null,3,2,4,null,5,6]
 * <strong>Output:</strong> [5,6,3,2,4,1]
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2019/11/08/sample_4_964.png" style="width: 296px; height: 241px;">
 * <pre><strong>Input:</strong> root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * <strong>Output:</strong> [2,6,14,11,7,3,12,8,4,13,9,10,5,1]
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li>The number of nodes in the tree is in the range <code>[0, 10<sup>4</sup>]</code>.</li>
 * 	<li><code>0 &lt;= Node.val &lt;= 10<sup>4</sup></code></li>
 * 	<li>The height of the n-ary tree is less than or equal to <code>1000</code>.</li>
 * </ul>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Follow up:</strong> Recursive solution is trivial, could you do it iteratively?</p>
 * </div>
 */
@SuppressWarnings("all") // Test haven't build
public class NaryTreePostorderTraversal {
    public static void main(String[] args) {
        Object[][] tests = {
            {3,9,20,null,null,15,7},
            {2,null,3,null,4,null,5,null,6}
        };

        for (Object[] arr : tests) {
            Node root = new Node();
            
            System.out.println(new NaryTreePostorderTraversal_Solution().postorder(root));
        }
    }
}

// 0ms 44.6Mb
class NaryTreePostorderTraversal_Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        findPostOrder(root, res);
        return res;
    }

    private void findPostOrder(Node node, List<Integer> res){
        if(node == null) return;

        for(Node childNode : node.children){
            findPostOrder(childNode, res);
        }
        res.add(node.val);
    }
}

