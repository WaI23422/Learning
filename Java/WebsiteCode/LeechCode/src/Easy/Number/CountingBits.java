package Easy.Number;

import java.util.Arrays;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/counting-bits/">338. Counting Bits</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given an integer <code>n</code>, return <em>an array </em><code>ans</code><em> of length </em><code>n + 1</code><em> such that for each </em><code>i</code><em> </em>(<code>0 &lt;= i &lt;= n</code>)<em>, </em><code>ans[i]</code><em> is the <strong>number of </strong></em><code>1</code><em><strong>'s</strong> in the binary representation of </em><code>i</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> n = 2
<strong>Output:</strong> [0,1,1]
<strong>Explanation:</strong>
0 --&gt; 0
1 --&gt; 1
2 --&gt; 10
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> n = 5
<strong>Output:</strong> [0,1,1,2,1,2]
<strong>Explanation:</strong>
0 --&gt; 0
1 --&gt; 1
2 --&gt; 10
3 --&gt; 11
4 --&gt; 100
5 --&gt; 101
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= n &lt;= 10<sup>5</sup></code></li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong></p>

<ul>
	<li>It is very easy to come up with a solution with a runtime of <code>O(n log n)</code>. Can you do it in linear time <code>O(n)</code> and possibly in a single pass?</li>
	<li>Can you do it without using any built-in function (i.e., like <code>__builtin_popcount</code> in C++)?</li>
</ul>
</div>
 */
public class CountingBits {
    public static void main(String[] args) {
        int[] tests = {
            2,
            5,
            // 100000
        };

        for (int n : tests) {
            System.out.println(Arrays.toString(new CountingBits_Solution().countBits(n)));
        }
    }
}

// 6 ms 46.8 MB
class CountingBits_Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];

        for (int i = 0; i < n+1; i++) {
            ans[i] = countOne(i);
        }

        return ans;
    }

    private int countOne(int n) {
        int count = 0;

        while (n != 0) {
            if ((n&1) == 1) {
                count++;
            }
            n>>=1;
        }

        return count;
    }
}