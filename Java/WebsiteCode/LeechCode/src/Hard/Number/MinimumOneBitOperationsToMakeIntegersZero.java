package Hard.Number;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/minimum-one-bit-operations-to-make-integers-zero/">1611.Minimum One Bit Operations to Make Integers Zero</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>Given an integer <code>n</code>, you must transform it into <code>0</code> using the following operations any number of times:</p>

<ul>
	<li>Change the rightmost (<code>0<sup>th</sup></code>) bit in the binary representation of <code>n</code>.</li>
	<li>Change the <code>i<sup>th</sup></code> bit in the binary representation of <code>n</code> if the <code>(i-1)<sup>th</sup></code> bit is set to <code>1</code> and the <code>(i-2)<sup>th</sup></code> through <code>0<sup>th</sup></code> bits are set to <code>0</code>.</li>
</ul>

<p>Return <em>the minimum number of operations to transform </em><code>n</code><em> into </em><code>0</code><em>.</em></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> n = 3
<strong>Output:</strong> 2
<strong>Explanation:</strong> The binary representation of 3 is "11".
"<u>1</u>1" -&gt; "<u>0</u>1" with the 2<sup>nd</sup> operation since the 0<sup>th</sup> bit is 1.
"0<u>1</u>" -&gt; "0<u>0</u>" with the 1<sup>st</sup> operation.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> n = 6
<strong>Output:</strong> 4
<strong>Explanation:</strong> The binary representation of 6 is "110".
"<u>1</u>10" -&gt; "<u>0</u>10" with the 2<sup>nd</sup> operation since the 1<sup>st</sup> bit is 1 and 0<sup>th</sup> through 0<sup>th</sup> bits are 0.
"01<u>0</u>" -&gt; "01<u>1</u>" with the 1<sup>st</sup> operation.
"0<u>1</u>1" -&gt; "0<u>0</u>1" with the 2<sup>nd</sup> operation since the 0<sup>th</sup> bit is 1.
"00<u>1</u>" -&gt; "00<u>0</u>" with the 1<sup>st</sup> operation.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= n &lt;= 10<sup>9</sup></code></li>
</ul>
</div></div>
 */
public class MinimumOneBitOperationsToMakeIntegersZero {
    public static void main(String[] args) {
        int[] tests =  {
            0,
            1,
            3,
            6
        };

        for (int n : tests) {
            System.out.println(new MinimumOneBitOperationsToMakeIntegersZero_Solution().minimumOneBitOperations(n));
        }
    }
}

class MinimumOneBitOperationsToMakeIntegersZero_Solution {
    // 0 ms 39.7 MB
    public int minimumOneBitOperations(int n) {
        if (n == 0) {
            return 0;
        }
        
        int k = 0;
        int curr = 1;
        while (curr * 2 <= n) {
            curr *= 2;
            k++;
        }
        
        return (1 << (k + 1)) - 1 - minimumOneBitOperations(n ^ curr);
    }
}