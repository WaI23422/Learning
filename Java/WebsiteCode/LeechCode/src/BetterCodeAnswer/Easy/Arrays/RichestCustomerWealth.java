package BetterCodeAnswer.Easy.Arrays;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/richest-customer-wealth/">1672.Richest Customer Wealth</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>You are given an <code>m x n</code> integer grid <code>accounts</code> where <code>accounts[i][j]</code> is the amount of money the <code>i​​​​​<sup>​​​​​​th</sup>​​​​</code> customer has in the <code>j​​​​​<sup>​​​​​​th</sup></code>​​​​ bank. Return<em> the <strong>wealth</strong> that the richest customer has.</em></p>

<p>A customer's <strong>wealth</strong> is the amount of money they have in all their bank accounts. The richest customer is the customer that has the maximum <strong>wealth</strong>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> accounts = [[1,2,3],[3,2,1]]
<strong>Output:</strong> 6
<strong>Explanation</strong><strong>:</strong>
<code>1st customer has wealth = 1 + 2 + 3 = 6
</code><code>2nd customer has wealth = 3 + 2 + 1 = 6
</code>Both customers are considered the richest with a wealth of 6 each, so return 6.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> accounts = [[1,5],[7,3],[3,5]]
<strong>Output:</strong> 10
<strong>Explanation</strong>: 
1st customer has wealth = 6
2nd customer has wealth = 10 
3rd customer has wealth = 8
The 2nd customer is the richest with a wealth of 10.</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> accounts = [[2,8,7],[7,1,3],[1,9,5]]
<strong>Output:</strong> 17
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>m ==&nbsp;accounts.length</code></li>
	<li><code>n ==&nbsp;accounts[i].length</code></li>
	<li><code>1 &lt;= m, n &lt;= 50</code></li>
	<li><code>1 &lt;= accounts[i][j] &lt;= 100</code></li>
</ul>
</div></div>
 */
public class RichestCustomerWealth {
    public static void main(String[] args) {
        int[][][] tests = {
            {{1,2,3},{1,2,3}},
            {{1}},
            {{2},{1},{4}}
        };

        RichestCustomerWealth_Solution res = new RichestCustomerWealth_Solution();

        for (int[][] accounts : tests) {
            System.out.println(res.maximumWealth(accounts));;
        }
    }
}

class RichestCustomerWealth_Solution {
    // 0 ms
    // 41.3 MB
    public int maximumWealth(int[][] account) {
        int sum = 0;
        int maxe = 0;
        // int column= account[0].length;
        for(int i = 0; i < account.length; i++)
        {
            for(int j = 0; j < account[0].length; j++)
            {
                sum = sum + account[i][j];
            }
            maxe = Math.max(sum,maxe);
            sum = 0;
        }
        return maxe;
    }
}