package Easy.Number;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/n-th-tribonacci-number/">1137. N-th Tribonacci Number</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>The Tribonacci sequence T<sub>n</sub> is defined as follows:&nbsp;</p>

<p>T<sub>0</sub> = 0, T<sub>1</sub> = 1, T<sub>2</sub> = 1, and T<sub>n+3</sub> = T<sub>n</sub> + T<sub>n+1</sub> + T<sub>n+2</sub> for n &gt;= 0.</p>

<p>Given <code>n</code>, return the value of T<sub>n</sub>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> n = 4
<strong>Output:</strong> 4
<strong>Explanation:</strong>
T_3 = 0 + 1 + 1 = 2
T_4 = 1 + 1 + 2 = 4
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> n = 25
<strong>Output:</strong> 1389537
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= n &lt;= 37</code></li>
	<li>The answer is guaranteed to fit within a 32-bit integer, ie. <code>answer &lt;= 2^31 - 1</code>.</li>
</ul></div>
 */
public class NthTribonacciNumber {
    public static void main(String[] args) {
        int[] tests = {
            0,1,2,3,4,5,37
        };

        for (int n : tests) {
            System.out.println(new NthTribonacciNumber_Solution().tribonacci(n));
        }
    }
}

// 0 ms 40.3 MB
class NthTribonacciNumber_Solution {
    public int tribonacci(int n) {
        int num1 = 0, num2 = 1, num3 = 1;

        for (int i = 0; i < n-1; i++) {
            if (i%3 == 0) {
                num1 += num2 + num3;
            } else if (i%3 == 1) {
                num2 += num1 + num3;
            } else {
                num3 += num1 + num2;
            }
        }

        return n%3 == 0 ? num1 : (n%3 == 1 ? num2 : num3);
    }
}