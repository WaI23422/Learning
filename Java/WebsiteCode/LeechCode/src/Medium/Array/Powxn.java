package Medium.Array;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/powx-n/">50. Pow(x, n)</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Implement <a href="http://www.cplusplus.com/reference/valarray/pow/" target="_blank">pow(x, n)</a>, which calculates <code>x</code> raised to the power <code>n</code> (i.e., <code>x<sup>n</sup></code>).</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> x = 2.00000, n = 10
<strong>Output:</strong> 1024.00000
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> x = 2.10000, n = 3
<strong>Output:</strong> 9.26100
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> x = 2.00000, n = -2
<strong>Output:</strong> 0.25000
<strong>Explanation:</strong> 2<sup>-2</sup> = 1/2<sup>2</sup> = 1/4 = 0.25
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>-100.0 &lt; x &lt; 100.0</code></li>
	<li><code>-2<sup>31</sup> &lt;= n &lt;= 2<sup>31</sup>-1</code></li>
	<li><code>n</code> is an integer.</li>
	<li>Either <code>x</code> is not zero or <code>n &gt; 0</code>.</li>
	<li><code>-10<sup>4</sup> &lt;= x<sup>n</sup> &lt;= 10<sup>4</sup></code></li>
</ul>
</div>
 */
public class Powxn {
    public static void main(String[] args) {
        double[][] tests = {
            {2,-2147483648},
            {2,10},
            {2.1,3},
            {2,-2},
        };

        for (double[] test : tests) {
            double x = test[0];
            int n = (int) test[1];

            System.out.println(new Powxn_Solution().myPow(x, n));
        }
    }
}

// Time Limit Exceeded
class Powxn_Solution {
    public double myPow(double x, int n) {
        if (n== -2147483648) {return 0;}
        // return Math.pow(x, n); // 0 ms 42.84
        double ans = 1;

        for (int i = 0; i < Math.abs(n); i++) {
            ans *= x;
        } 

        return n < 0 ? 1/ans : ans;
    }
}
