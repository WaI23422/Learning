package Medium.Number;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/integer-break/">343.Integer Break</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>Given an integer <code>n</code>, break it into the sum of <code>k</code> <strong>positive integers</strong>, where <code>k &gt;= 2</code>, and maximize the product of those integers.</p>

<p>Return <em>the maximum product you can get</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> n = 2
<strong>Output:</strong> 1
<strong>Explanation:</strong> 2 = 1 + 1, 1 × 1 = 1.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> n = 10
<strong>Output:</strong> 36
<strong>Explanation:</strong> 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= n &lt;= 58</code></li>
</ul>
</div></div>
 */
public class IntegerBreak {
    public static void main(String[] args) {
        int n = 7;

        IntegerBreak_Solution result = new IntegerBreak_Solution();

        System.out.println(result.integerBreak(n));
    }
}   

class IntegerBreak_Solution {
    // 0 ms
    // 39.2 MB
    public int integerBreak(int n) {
        int res = 1; 
        
        if (n == 2) {
            return 1;
        } else if (n==3) {
            return 2;
        }
        
        while (n > 0) {
            if (n%3 != 0) {
                res*=2;
                n-=2;
            } else {
                res*=3;
                n-=3;
            }
        }

        return res;
    }
}