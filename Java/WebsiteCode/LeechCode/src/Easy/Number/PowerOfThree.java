package Easy.Number;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/power-of-three/">326. Power of Three</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given an integer <code>n</code>, return <em><code>true</code> if it is a power of three. Otherwise, return <code>false</code></em>.</p>

<p>An integer <code>n</code> is a power of three, if there exists an integer <code>x</code> such that <code>n == 3<sup>x</sup></code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> n = 27
<strong>Output:</strong> true
<strong>Explanation:</strong> 27 = 3<sup>3</sup>
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> n = 0
<strong>Output:</strong> false
<strong>Explanation:</strong> There is no x where 3<sup>x</sup> = 0.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> n = -1
<strong>Output:</strong> false
<strong>Explanation:</strong> There is no x where 3<sup>x</sup> = (-1).
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>-2<sup>31</sup> &lt;= n &lt;= 2<sup>31</sup> - 1</code></li>
</ul>

<p>&nbsp;</p>
<strong>Follow up:</strong> Could you solve it without loops/recursion?</div>
 */
public class PowerOfThree {
    public static void main(String[] args) {
        int[] tests = {
            27,
            0,
            -1,
            2147483647
        };

        for (int n : tests) {
            System.out.println(new PowerOfThree_Solution().isPowerOfThree(n));
        }
    }
}

// 7 ms 43.8 MB
class PowerOfThree_Solution1 {
    public boolean isPowerOfThree(int n) {
        if (
            n == 1 ||
            n == 3 ||
            n == 9 ||
            n == 27 ||
            n == 81 ||
            n == 243 ||
            n == 729 ||
            n == 2187 ||
            n == 6561 ||
            n == 19683 ||
            n == 59049 ||
            n == 177147 ||
            n == 531441 ||
            n == 1594323 ||
            n == 4782969 ||
            n == 14348907 ||
            n == 43046721 ||
            n == 129140163 ||
            n == 387420489 ||
            n == 1162261467
        ) {
            return true;
        }

        return false;
    }
}

// 8 ms 43.7 MB
class PowerOfThree_Solution2 {
    public boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }

        while (n > 1) {
            if (n%3 == 0) {
                n /= 3;
            } else {
                return false;
            }
        }

        return true;
    }
}

// 8 ms 43.86 MB
class PowerOfThree_Solution {
    public boolean isPowerOfThree(int n) {
        if(n<1){ return false;}

        while(n%3==0){n=n/3;}

        return n == 1;
    }
}