package Medium.Number;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/determine-if-a-cell-is-reachable-at-a-given-time/">2849.Determine if a Cell Is Reachable at a Given Time</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>You are given four integers <code>sx</code>, <code>sy</code>, <code>fx</code>, <code>fy</code>, and a <strong>non-negative</strong> integer <code>t</code>.</p>

<p>In an infinite 2D grid, you start at the cell <code>(sx, sy)</code>. Each second, you <strong>must</strong> move to any of its adjacent cells.</p>

<p>Return <code>true</code> <em>if you can reach cell </em><code>(fx, fy)</code> <em>after<strong> exactly</strong></em> <code>t</code> <strong><em>seconds</em></strong>, <em>or</em> <code>false</code> <em>otherwise</em>.</p>

<p>A cell's <strong>adjacent cells</strong> are the 8 cells around it that share at least one corner with it. You can visit the same cell several times.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2023/08/05/example2.svg" style="width: 443px; height: 243px;">
<pre><strong>Input:</strong> sx = 2, sy = 4, fx = 7, fy = 7, t = 6
<strong>Output:</strong> true
<strong>Explanation:</strong> Starting at cell (2, 4), we can reach cell (7, 7) in exactly 6 seconds by going through the cells depicted in the picture above. 
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2023/08/05/example1.svg" style="width: 383px; height: 202px;">
<pre><strong>Input:</strong> sx = 3, sy = 1, fx = 7, fy = 3, t = 3
<strong>Output:</strong> false
<strong>Explanation:</strong> Starting at cell (3, 1), it takes at least 4 seconds to reach cell (7, 3) by going through the cells depicted in the picture above. Hence, we cannot reach cell (7, 3) at the third second.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= sx, sy, fx, fy &lt;= 10<sup>9</sup></code></li>
	<li><code>0 &lt;= t &lt;= 10<sup>9</sup></code></li>
</ul>
</div></div>
 */
public class DetermineIfACellIsReachableAtAGivenTime {
    public static void main(String[] args) {
        int[][] tests = {
            {2,4,7,7,6},
            {2,2,7,7,6},
            {1,2,1,2,1}
        };

        DetermineIfACellIsReachableAtAGivenTime_Solution res = new DetermineIfACellIsReachableAtAGivenTime_Solution();

        for (int[] test : tests) {
            int sx = test[0],sy = test[1], fx = test[2], fy = test[3],t = test[4];
            System.out.println(res.isReachableAtTime(sx, sy, fx, fy, t));
        }
    }
}

// @see BetterCodeAnswer.Number.Array.DetermineIfACellIsReachableAtAGivenTime.java
class DetermineIfACellIsReachableAtAGivenTime_Solution {
    // 1 ms 39.4 MB
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int xCompare = Math.abs(sx - fx), yCompare = Math.abs(fy - sy), minTime;
        if (xCompare == 0 && yCompare==0) {return t != 1;}

        if (xCompare > yCompare) {minTime = xCompare;}
        else {minTime = yCompare;}

        return minTime <= t;
    }
}