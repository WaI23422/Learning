package Easy.Number;

import java.util.ArrayList;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/happy-number/">202.Happy Number</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Write an algorithm to determine if a number <code>n</code> is happy.</p>

<p>A <strong>happy number</strong> is a number defined by the following process:</p>

<ul>
	<li>Starting with any positive integer, replace the number by the sum of the squares of its digits.</li>
	<li>Repeat the process until the number equals 1 (where it will stay), or it <strong>loops endlessly in a cycle</strong> which does not include 1.</li>
	<li>Those numbers for which this process <strong>ends in 1</strong> are happy.</li>
</ul>

<p>Return <code>true</code> <em>if</em> <code>n</code> <em>is a happy number, and</em> <code>false</code> <em>if not</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> n = 19
<strong>Output:</strong> true
<strong>Explanation:</strong>
1<sup>2</sup> + 9<sup>2</sup> = 82
8<sup>2</sup> + 2<sup>2</sup> = 68
6<sup>2</sup> + 8<sup>2</sup> = 100
1<sup>2</sup> + 0<sup>2</sup> + 0<sup>2</sup> = 1
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> n = 2
<strong>Output:</strong> false
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 2<sup>31</sup> - 1</code></li>
</ul>
</div>
 */
public class HappyNumber {
    public static void main(String[] args) {
        int[] tests = {
            1,
            2,
            7,
            19,
            38
        };

        for (int n : tests) {
            System.out.println(new HappyNumber_Solution().isHappy(n));
        }
    }
}

// 1 ms 40.7 MB
class HappyNumber_Solution {
    public boolean isHappy(int n) {
        ArrayList<Integer> appearArr = new ArrayList<>();

        while (!appearArr.contains(n)) {
            if (n == 1) {return true;}

            appearArr.add(n);
            n = sumDigitsNumber(n);
        }   

        return false;
    }

    private int sumDigitsNumber(int number) {
        int n = 0;

        while (number != 0) {
            int digits = number%10;
            n += digits*digits;
            number/=10;
        }

        return n;
    }
}

