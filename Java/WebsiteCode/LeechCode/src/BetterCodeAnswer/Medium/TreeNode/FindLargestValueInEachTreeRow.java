package BetterCodeAnswer.Medium.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import BetterCodeAnswer.Medium.TreeNode.Class.TreeNode;


/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/find-largest-value-in-each-tree-row/">515.Find Largest Value in Each Tree Row</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>Given the <code>root</code> of a binary tree, return <em>an array of the largest value in each row</em> of the tree <strong>(0-indexed)</strong>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/08/21/largest_e1.jpg" style="width: 300px; height: 172px;">
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
        
        FindLargestValueInEachTreeRow_SolutionBFS res = new FindLargestValueInEachTreeRow_SolutionBFS();

        System.out.println(res.largestValues(test).toString());
    }
}

/**
 * <h1 id="approach">Approach</h1>
 * <ol>
<li><strong>Initialization</strong>: Begin with initializing a queue and adding the root node to it. This queue will help in level order traversal.</li>
<li><strong>Level-wise Traversal</strong>: As long as the queue is not empty, we keep on processing nodes. For each level, we will calculate its size (i.e., the number of nodes in the current level). This helps in segregating nodes of different levels.</li>
<li><strong>Capture Maximum</strong>: For each level, initialize a variable <code>max_val</code> with the smallest possible integer. As we process each node in the current level, we update <code>max_val</code> to be the maximum between the node's value and the current <code>max_val</code>.</li>
<li><strong>Child Processing</strong>: After processing a node, we add its left and right children (if they exist) to the queue for the next level's processing.</li>
<li><strong>Result Update</strong>: Once all nodes of a level are processed, the maximum value for that level (<code>max_val</code>) is added to the result list.</li>
</ol>
 */
class FindLargestValueInEachTreeRow_SolutionBFS {
    // 2 ms
    // 43.5 MB
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) return new ArrayList<>();
        
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int curr_level_size = queue.size();
            int max_val = Integer.MIN_VALUE;
            
            for (int i = 0; i < curr_level_size; i++) {
                TreeNode node = queue.poll();
                max_val = Math.max(max_val, node.val);
                
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            
            result.add(max_val);
        }
        
        return result;
    }
}

/**
 * <h4 id="approach-2-depth-first-search-dfs">Approach 2: Depth First Search (DFS)</h4>
 * 
 * <p><strong>Intuition</strong></p>
 * <blockquote>
<p>Note: This problem is perfect for BFS, but an interviewer might you to implement DFS as a follow-up. We have included a DFS approach for completeness.</p>
</blockquote>
<p>In BFS, we handle each row explicitly, so it's easy to just keep track of the maximum value as we traverse through the row.</p>
<p>In DFS, the order in which we move through the tree is not related to the rows. Thus, we need to be more creative to find the maximum value in each row. The first observation to make is that each row can be described by the depth of its nodes.</p>
<p><img src="https://leetcode.com/problems/find-largest-value-in-each-tree-row/Figures/515/1.png" alt="depth"><br>
<br></p>
<p>The depth of a node is its distance from the root. The root has a depth of <code>0</code>, and every child has a depth of <code>1</code> greater than its parent. You may also notice that in terms of indices, each node's depth corresponds to its index in the answer.</p>
<p>For example, if <code>ans</code> is our answer list, then <code>ans[2]</code> holds the maximum value of all nodes with depth <code>2</code>.</p>
<p>If we keep track of each node's depth during the traversal, then we can update <code>ans</code> directly. How do we keep track of the depth? We will pass an additional argument <code>depth</code> in our <code>dfs</code> function. When we initially call <code>dfs</code> with <code>root</code>, we will pass <code>depth = 0</code>. When we call <code>dfs</code> on a child, we will pass <code>depth + 1</code>.</p>
<p>There is one problem: how do we know what length <code>ans</code> should be? We will initialize <code>ans</code> as an empty list. If we are at a <code>depth</code> that would be out of bounds if we tried to access <code>ans[depth]</code>, then we will simply initialize the current <code>node.val</code> as the maximum value seen at <code>depth</code> so far by pushing <code>node.val</code> to <code>ans</code>.</p>
<p><strong>Algorithm</strong></p>
<ol>
<li>Initialize <code>ans</code> as an empty list.</li>
<li>Define a function <code>dfs(node, depth)</code>:
<ul>
<li>If <code>node</code> is null, return.</li>
<li>If <code>depth == ans.length</code>, then push <code>node.val</code> to <code>ans</code>. Otherwise, try to update <code>ans[depth]</code> with <code>node.val</code> if its larger.</li>
<li>Call <code>dfs</code> on <code>node.left</code> and <code>node.right</code> with <code>depth + 1</code> as the second argument.</li>
</ul>
</li>
<li>Call <code>dfs(root, 0)</code> and then <code>return ans</code>.</li>
</ol>
 */
class FindLargestValueInEachTreeRow_SolutionDFS {
    List<Integer> ans;
    
    // 1 ms 
    // 44.1 MB
    public List<Integer> largestValues(TreeNode root) {
        ans = new ArrayList<Integer>();
        dfs(root, 0);
        return ans;
    }
    
    public void dfs(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        
        if (depth == ans.size()) {
            ans.add(node.val);
        } else {
            ans.set(depth, Math.max(ans.get(depth), node.val));
        }
        
        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }
}
