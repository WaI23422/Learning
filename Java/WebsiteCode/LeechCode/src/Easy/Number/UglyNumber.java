package Easy.Number;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/ugly-number/">263. Ugly Number</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>An <strong>ugly number</strong> is a positive integer whose prime factors are limited to <code>2</code>, <code>3</code>, and <code>5</code>.</p>

<p>Given an integer <code>n</code>, return <code>true</code> <em>if</em> <code>n</code> <em>is an <strong>ugly number</strong></em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> n = 6
<strong>Output:</strong> true
<strong>Explanation:</strong> 6 = 2 × 3
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> n = 1
<strong>Output:</strong> true
<strong>Explanation:</strong> 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> n = 14
<strong>Output:</strong> false
<strong>Explanation:</strong> 14 is not ugly since it includes the prime factor 7.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>-2<sup>31</sup> &lt;= n &lt;= 2<sup>31</sup> - 1</code></li>
</ul>
</div>
 */
public class UglyNumber {
    public static void main(String[] args) {
        int[] tests  = {
            0,1,2,3,2147483647
        };

        for (int n : tests) {
            System.out.println(new UglyNumber_Solution().isUgly(n));
        }
    }
}

class UglyNumber_Solution {
    public boolean isUgly(int n) {
        if (n == 0) {return false;}

        while (n != 1) {
            if (n%2 == 0) {n /= 2;}
            else if (n%3 == 0) {n /= 3;}
            else if (n%5 == 0) { n/= 5;}
            else {break;}
        }
        
        return n == 1;
    }
}