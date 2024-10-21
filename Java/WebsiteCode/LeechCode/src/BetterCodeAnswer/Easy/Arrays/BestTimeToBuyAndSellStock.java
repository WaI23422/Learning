package BetterCodeAnswer.Easy.Arrays;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/best-time-to-buy-and-sell-stock/">121.Best Time to Buy and Sell Stock</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>You are given an array <code>prices</code> where <code>prices[i]</code> is the price of a given stock on the <code>i<sup>th</sup></code> day.</p>

<p>You want to maximize your profit by choosing a <strong>single day</strong> to buy one stock and choosing a <strong>different day in the future</strong> to sell that stock.</p>

<p>Return <em>the maximum profit you can achieve from this transaction</em>. If you cannot achieve any profit, return <code>0</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> prices = [7,1,5,3,6,4]
<strong>Output:</strong> 5
<strong>Explanation:</strong> Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> prices = [7,6,4,3,1]
<strong>Output:</strong> 0
<strong>Explanation:</strong> In this case, no transactions are done and the max profit = 0.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= prices.length &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= prices[i] &lt;= 10<sup>4</sup></code></li>
</ul>
</div></div>
 */
public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[][] tests = {
            {7,1,5,3,6,4},
            {7,6,4,3,1},
            {3,1,2,4,1,5,4},
            {2,5,1,4}
        };

        for (int[] prices : tests) {
            System.out.println(new BestTimeToBuyAndSellStock_Solution().maxProfit(prices));
        }
    }
}

// 1 ms 59.4 MB
class BestTimeToBuyAndSellStock_Solution {
    public int maxProfit(int[] prices) { 
        int min = prices[0];
        int maxProfit = 0;
        int temp = 0;
        for (int i = 1; i < prices.length; i++) {
            temp = prices[i];
            if (temp < min) {
                min = temp;
            }
            else {
                maxProfit = Math.max(maxProfit, temp - min);
            }
        }

        // System.gc(); // 4 ms 51.7 MB
        return maxProfit;
    }
}