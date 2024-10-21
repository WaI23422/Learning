package Easy.Arrays;


import java.util.Arrays;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/buy-two-chocolates/">2706.Buy Two Chocolates</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>You are given an integer array <code>prices</code> representing the prices of various chocolates in a store. You are also given a single integer <code>money</code>, which represents your initial amount of money.</p>

<p>You must buy <strong>exactly</strong> two chocolates in such a way that you still have some <strong>non-negative</strong> leftover money. You would like to minimize the sum of the prices of the two chocolates you buy.</p>

<p>Return <em>the amount of money you will have leftover after buying the two chocolates</em>. If there is no way for you to buy two chocolates without ending up in debt, return <code>money</code>. Note that the leftover must be non-negative.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> prices = [1,2,2], money = 3
<strong>Output:</strong> 0
<strong>Explanation:</strong> Purchase the chocolates priced at 1 and 2 units respectively. You will have 3 - 3 = 0 units of money afterwards. Thus, we return 0.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> prices = [3,2,3], money = 3
<strong>Output:</strong> 3
<strong>Explanation:</strong> You cannot buy 2 chocolates without going in debt, so we return 3.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= prices.length &lt;= 50</code></li>
	<li><code>1 &lt;= prices[i] &lt;= 100</code></li>
	<li><code>1 &lt;= money &lt;= 100</code></li>
</ul>
</div></div>
 */
public class BuyTwoChocolates {
    public static void main(String[] args) {
        int[][][] tests = {
            // {{1,2,2},{3}},
            // {{3,2,3},{3}},
            {{4,5,6,55,1,12,12,1},{3}}
        };

        for (int[][] test : tests) {
            int[] prices = test[0];
            int monay = test[1][0];

            System.out.println(new BuyTwoChocolates_Solution().buyChoco(prices, monay));
        }
    }
}

// 1 ms 43.3 MB
class BuyTwoChocolates_Solution {
    public int buyChoco(int[] prices, int money) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min2) {
                if (min2 < min1) {min1 = min2;}
                min2 = prices[i];
            } else if (prices[i] < min1){
                min1 = prices[i];
            }
        }

        System.gc(); // 22 ms 41.1 MB
        return money-min1-min2 >= 0 ? money-min1-min2 : money;  
    }
}

// 2 ms 43.4 MB
class BuyTwoChocolates_Solution2 {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        
        int spending = money - prices[0] - prices[1];

        return spending >= 0 ? spending : money;  
    }
}

