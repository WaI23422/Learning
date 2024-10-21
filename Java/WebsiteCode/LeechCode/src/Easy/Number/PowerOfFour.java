package Easy.Number;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/power-of-four/">342.Power of Four</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>Given an integer <code>n</code>, return <em><code>true</code> if it is a power of four. Otherwise, return <code>false</code></em>.</p>

<p>An integer <code>n</code> is a power of four, if there exists an integer <code>x</code> such that <code>n == 4<sup>x</sup></code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> n = 16
<strong>Output:</strong> true
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> n = 5
<strong>Output:</strong> false
</pre><p><strong class="example">Example 3:</strong></p>
<pre><strong>Input:</strong> n = 1
<strong>Output:</strong> true
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>-2<sup>31</sup> &lt;= n &lt;= 2<sup>31</sup> - 1</code></li>
</ul>

<p>&nbsp;</p>
<strong>Follow up:</strong> Could you solve it without loops/recursion?</div></div>
 */
public class PowerOfFour {
    public static void main(String[] args) {
        int[] nArr = {16,5,1,(int) Math.pow(2, 31)-1};

        PowerOfFour_Solution res = new PowerOfFour_Solution();

        for (int n : nArr) {
            System.out.println(res.isPowerOfFour(n));
        }
    }
}

class PowerOfFour_Solution {
    // 1 ms
    // 38.8 MB
    public boolean isPowerOfFour(int n) {
        int compareNum = 1;

        if (n <= 0) {return false;}

        while (compareNum < n) {
            compareNum*=4;
            if (compareNum == 0) {
                return false;
            }
        }
        
        if (compareNum == 1 || compareNum == n) {
            return true;
        } else {
            return false;
        }
    }
}
