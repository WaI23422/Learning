package BetterCodeAnswer.Medium.Array;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/validate-binary-tree-nodes/">1361.Validate Binary Tree Nodes</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>You have <code>n</code> binary tree nodes numbered from <code>0</code> to <code>n - 1</code> where node <code>i</code> has two children <code>leftChild[i]</code> and <code>rightChild[i]</code>, return <code>true</code> if and only if <strong>all</strong> the given nodes form <strong>exactly one</strong> valid binary tree.</p>

<p>If node <code>i</code> has no left child then <code>leftChild[i]</code> will equal <code>-1</code>, similarly for the right child.</p>

<p>Note that the nodes have no values and that we only use the node numbers in this problem.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2019/08/23/1503_ex1.png" style="width: 195px; height: 287px;">
<pre><strong>Input:</strong> n = 4, leftChild = [1,-1,3,-1], rightChild = [2,-1,-1,-1]
<strong>Output:</strong> true
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2019/08/23/1503_ex2.png" style="width: 183px; height: 272px;">
<pre><strong>Input:</strong> n = 4, leftChild = [1,-1,3,-1], rightChild = [2,3,-1,-1]
<strong>Output:</strong> false
</pre>

<p><strong class="example">Example 3:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2019/08/23/1503_ex3.png" style="width: 82px; height: 174px;">
<pre><strong>Input:</strong> n = 2, leftChild = [1,0], rightChild = [-1,-1]
<strong>Output:</strong> false
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == leftChild.length == rightChild.length</code></li>
	<li><code>1 &lt;= n &lt;= 10<sup>4</sup></code></li>
	<li><code>-1 &lt;= leftChild[i], rightChild[i] &lt;= n - 1</code></li>
</ul>
</div></div>
 */
public class ValidateBinaryTreeNodes {
    public static void main(String[] args) {
        int n = 4; 
        int[] leftChild = {1,-1,3,-1}, rightChild = {2,-1,-1,-1};

        ValidateBinaryTreeNodes_Solution res = new ValidateBinaryTreeNodes_Solution();

        System.out.println(res.validateBinaryTreeNodes(n, leftChild, rightChild));
    }
}

class ValidateBinaryTreeNodes_Solution {
    // 3 ms
    // 45.3 MB
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {

    int[] inDegree = new int[n];
    int root = -1;

    // If inDegree of any node > 1, return false
    for (final int child : leftChild)
      if (child != -1 && ++inDegree[child] == 2)
        return false;

    for (final int child : rightChild)
      if (child != -1 && ++inDegree[child] == 2)
        return false;

    // Find the root (node with inDegree == 0)
    for (int i = 0; i < n; ++i)
      if (inDegree[i] == 0)
        if (root == -1)
          root = i;
        else
          return false; // Multiple roots

    // didn't find the root
    if (root == -1)
      return false;

    // Perform DFS from the root
        boolean[] visited = new boolean[n];
        if(!dfs(root, leftChild, rightChild, visited)) return false;

        //Return false if there exists any node that cannot be reached from the root.
        for(boolean v: visited) if(!v) return false;
        return true;
    }

    private boolean dfs(int source, int[] leftChild, int[] rightChild, boolean[] visited) {
        visited[source] = true;
        int left = leftChild[source], right = rightChild[source];
        
        if(left >= 0) {
            if(visited[left] || !dfs(left, leftChild, rightChild, visited)) return false;
        }

        if(right >= 0) {
            if(visited[right] || !dfs(right, leftChild, rightChild, visited)) return false;
        }

        return true;
    }
}