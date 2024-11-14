package BetterCodeAnswer.Medium.Array;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/minimized-maximum-of-products-distributed-to-any-store/">2064. Minimized Maximum of Products Distributed to Any Store</a>
 * 
 * <div><div class="elfjS" data-track-load="description_content"><p>You are given an integer <code>n</code> indicating there are <code>n</code> specialty retail stores. There are <code>m</code> product types of varying amounts, which are given as a <strong>0-indexed</strong> integer array <code>quantities</code>, where <code>quantities[i]</code> represents the number of products of the <code>i<sup>th</sup></code> product type.</p>
 * 
 * <p>You need to distribute <strong>all products</strong> to the retail stores following these rules:</p>
 * 
 * <ul>
 * 	<li>A store can only be given <strong>at most one product type</strong> but can be given <strong>any</strong> amount of it.</li>
 * 	<li>After distribution, each store will have been given some number of products (possibly <code>0</code>). Let <code>x</code> represent the maximum number of products given to any store. You want <code>x</code> to be as small as possible, i.e., you want to <strong>minimize</strong> the <strong>maximum</strong> number of products that are given to any store.</li>
 * </ul>
 * 
 * <p>Return <em>the minimum possible</em> <code>x</code>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> n = 6, quantities = [11,6]
 * <strong>Output:</strong> 3
 * <strong>Explanation:</strong> One optimal way is:
 * - The 11 products of type 0 are distributed to the first four stores in these amounts: 2, 3, 3, 3
 * - The 6 products of type 1 are distributed to the other two stores in these amounts: 3, 3
 * The maximum number of products given to any store is max(2, 3, 3, 3, 3, 3) = 3.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> n = 7, quantities = [15,10,10]
 * <strong>Output:</strong> 5
 * <strong>Explanation:</strong> One optimal way is:
 * - The 15 products of type 0 are distributed to the first three stores in these amounts: 5, 5, 5
 * - The 10 products of type 1 are distributed to the next two stores in these amounts: 5, 5
 * - The 10 products of type 2 are distributed to the last two stores in these amounts: 5, 5
 * The maximum number of products given to any store is max(5, 5, 5, 5, 5, 5, 5) = 5.
 * </pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <pre><strong>Input:</strong> n = 1, quantities = [100000]
 * <strong>Output:</strong> 100000
 * <strong>Explanation:</strong> The only optimal way is:
 * - The 100000 products of type 0 are distributed to the only store.
 * The maximum number of products given to any store is max(100000) = 100000.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>m == quantities.length</code></li>
 * 	<li><code>1 &lt;= m &lt;= n &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>1 &lt;= quantities[i] &lt;= 10<sup>5</sup></code></li>
 * </ul>
 * </div></div>
 */
public class MinimizedMaximumOfProductsDistributedToAnyStore {
    public static void main(String[] args) {
        int[][][] tests = {
            {
                {11,6},
                {6}
            }
        };

        for (int[][] test : tests) {
            int quantities[] = test[0],
                n = test[1][0];
            
            System.out.println(new MinimizedMaximumOfProductsDistributedToAnyStore_Solution().minimizedMaximum(n, quantities));
        }
    }
}

// 22ms 57.64MB
class MinimizedMaximumOfProductsDistributedToAnyStore_Solution {
    public boolean func(int n, int[] quantities, int m) {
        for(int q : quantities) {
            n -= (q+m-1)/m;
            if(n < 0) return false;
        }
        return true;
    }
    public int minimizedMaximum(int n, int[] quantities) {
        int l = 1, r = 100000;
        while(l <= r) {
            int mid = l + (r-l)/2;
            if(func(n, quantities, mid)) r = mid-1;
            else l = mid+1;
        }
        return l;
    }
}