package BetterCodeAnswer.Medium.Number;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/perfect-squares/">279.Perfect Squares</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given an integer <code>n</code>, return <em>the least number of perfect square numbers that sum to</em> <code>n</code>.</p>

<p>A <strong>perfect square</strong> is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, <code>1</code>, <code>4</code>, <code>9</code>, and <code>16</code> are perfect squares while <code>3</code> and <code>11</code> are not.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> n = 12
<strong>Output:</strong> 3
<strong>Explanation:</strong> 12 = 4 + 4 + 4.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> n = 13
<strong>Output:</strong> 2
<strong>Explanation:</strong> 13 = 4 + 9.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 10<sup>4</sup></code></li>
</ul>
</div>
 */
public class PerfectSquares {
    public static void main(String[] args) {
        int[] tests = {
            12,
            13,
            1,
            4,
            5
        };

        for (int n : tests) {
            System.out.println(new PerfectSquares_Solution().numSquares(n));
        }
    }
}

// 0 ms 40.5 MB
class PerfectSquares_Solution {
    public int numSquares(int n) {
         int sqrt = (int) Math.sqrt(n);

        if (sqrt * sqrt == n)
            return 1;

        while (n % 4 == 0)
            n = n / 4;

        if (n % 8 == 7) return 4;

        for (int i = 1; i * i <= n; i++) {
            int square = i * i;
            int base = (int) Math.sqrt(n - square);

            if (base * base == n - square) return 2;
        }

        return 3;
    }
}