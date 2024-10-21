package BetterCodeAnswer.Hard.Array;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/greatest-common-divisor-traversal/">2709.Greatest Common Divisor Traversal</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You are given a <strong>0-indexed</strong> integer array <code>nums</code>, and you are allowed to <strong>traverse</strong> between its indices. You can traverse between index <code>i</code> and index <code>j</code>, <code>i != j</code>, if and only if <code>gcd(nums[i], nums[j]) &gt; 1</code>, where <code>gcd</code> is the <strong>greatest common divisor</strong>.</p>

<p>Your task is to determine if for <strong>every pair</strong> of indices <code>i</code> and <code>j</code> in nums, where <code>i &lt; j</code>, there exists a <strong>sequence of traversals</strong> that can take us from <code>i</code> to <code>j</code>.</p>

<p>Return <code>true</code><em> if it is possible to traverse between all such pairs of indices,</em><em> or </em><code>false</code><em> otherwise.</em></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [2,3,6]
<strong>Output:</strong> true
<strong>Explanation:</strong> In this example, there are 3 possible pairs of indices: (0, 1), (0, 2), and (1, 2).
To go from index 0 to index 1, we can use the sequence of traversals 0 -&gt; 2 -&gt; 1, where we move from index 0 to index 2 because gcd(nums[0], nums[2]) = gcd(2, 6) = 2 &gt; 1, and then move from index 2 to index 1 because gcd(nums[2], nums[1]) = gcd(6, 3) = 3 &gt; 1.
To go from index 0 to index 2, we can just go directly because gcd(nums[0], nums[2]) = gcd(2, 6) = 2 &gt; 1. Likewise, to go from index 1 to index 2, we can just go directly because gcd(nums[1], nums[2]) = gcd(3, 6) = 3 &gt; 1.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [3,9,5]
<strong>Output:</strong> false
<strong>Explanation:</strong> No sequence of traversals can take us from index 0 to index 2 in this example. So, we return false.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> nums = [4,3,12,8]
<strong>Output:</strong> true
<strong>Explanation:</strong> There are 6 possible pairs of indices to traverse between: (0, 1), (0, 2), (0, 3), (1, 2), (1, 3), and (2, 3). A valid sequence of traversals exists for each pair, so we return true.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
</ul>
</div>
 */
public class GreatestCommonDivisorTraversal {
    public static void main(String[] args) {
        int[][] tests = {
            {2,3,6},
            {3,9,5},
            {4,3,12,8},
            {30,30},
            {2,2,4,4},
            {49,39,20,30,28,35,26,16,10,44}
        };

        for (int[] nums : tests) {
            System.out.println(new GreatestCommonDivisorTraversal_Solution().canTraverseAllPairs(nums));
        }
    }
}

// 14 ms 57.3 MB
class GreatestCommonDivisorTraversal_Solution {

    int[] parent;
    int[] count;

    int max;
    public boolean canTraverseAllPairs(int[] nums) {
        for (int x : nums) 
            max = Math.max(max, x);

        int n = nums.length;
        parent = new int[max +1];
        count = new int[max+1];

        if(n == 1) return true;

        for(int i = 0; i < n; i++)
            if(nums[i]==1) return false;
        
        for(int i = 1; i <= max; i++)
            parent[i] = i;
        
        for(int x:nums)
            count[x]++;
        

        boolean[] visited = new boolean[max+1];

        for(int i = 2; i* 2 <= max; i++){
            if(visited[i]) continue;
            for(int j = i+i; j <= max; j+=i){
                visited[j] = true;
                if(count[j]!=0){
                    union(i, j);
                }
            }
        }

        int p = find(nums[0]);
        for(int i = 1; i < n; i++)
            if(find(nums[i]) != p) return false;
        
        return true;
    }

    private int find(int x) {
        return parent[x] == x ? x : (parent[x] = find(parent[x]));
    }
    
    private void union(int x, int y) {
        
        x = find(x);
        y = find(y);
        if (x == y) 
            return;

        parent[y] = x;
    }
}