package BetterCodeAnswer.Easy.Arrays;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/assign-cookies/">455.Assign Cookies</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at most one cookie.</p>

<p>Each child <code>i</code> has a greed factor <code>g[i]</code>, which is the minimum size of a cookie that the child will be content with; and each cookie <code>j</code> has a size <code>s[j]</code>. If <code>s[j] &gt;= g[i]</code>, we can assign the cookie <code>j</code> to the child <code>i</code>, and the child <code>i</code> will be content. Your goal is to maximize the number of your content children and output the maximum number.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> g = [1,2,3], s = [1,1]
<strong>Output:</strong> 1
<strong>Explanation:</strong> You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3. 
And even though you have 2 cookies, since their size is both 1, you could only make the child whose greed factor is 1 content.
You need to output 1.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> g = [1,2], s = [1,2,3]
<strong>Output:</strong> 2
<strong>Explanation:</strong> You have 2 children and 3 cookies. The greed factors of 2 children are 1, 2. 
You have 3 cookies and their sizes are big enough to gratify all of the children, 
You need to output 2.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= g.length &lt;= 3 * 10<sup>4</sup></code></li>
	<li><code>0 &lt;= s.length &lt;= 3 * 10<sup>4</sup></code></li>
	<li><code>1 &lt;= g[i], s[j] &lt;= 2<sup>31</sup> - 1</code></li>
</ul>
</div></div>
 */
public class AssignCookies {
    public static void main(String[] args) {
        int[][][] tests = {
            {{1,2,3},{1,1}},
            {{1,2},{1,2,3}}
        };

        for (int[][] test : tests) {
            int[] g = test[0], s = test[1];

            System.out.println(new AssignCookies_Solution().findContentChildren(g, s));
        }
    }
}

// @see Easy.Array.AssignCookies.java
class AssignCookies_Solution {
    public int findContentChildren(int[] g, int[] s) {
        return 0;
    }
}
