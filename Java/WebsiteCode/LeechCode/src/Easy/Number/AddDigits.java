package Easy.Number;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/add-digits/">258. Add Digits</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given an integer <code>num</code>, repeatedly add all its digits until the result has only one digit, and return it.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> num = 38
<strong>Output:</strong> 2
<strong>Explanation:</strong> The process is
38 --&gt; 3 + 8 --&gt; 11
11 --&gt; 1 + 1 --&gt; 2 
Since 2 has only one digit, return it.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> num = 0
<strong>Output:</strong> 0
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= num &lt;= 2<sup>31</sup> - 1</code></li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong> Could you do it without any loop/recursion in <code>O(1)</code> runtime?</p>
</div>
 */
public class AddDigits {
    public static void main(String[] args) {
        int[] tests = {
            0,
            38,
            2147483646 
        };

        for (int num : tests) {
            System.out.println(new AddDigits_Solution().addDigits(num));
        }
    }
}

// 0 ms 40.6 MB
class AddDigits_Solution {
    public int addDigits(int num) {
        if (num/10 ==0) {return num;}
        
        int repNum = 0, len = lengthNum(num);
        for (int i = 0; i < len; i++) {
            repNum += num%10;
            num /= 10;
        }

        return addDigits(repNum);
    }

    private int lengthNum (int num) {
        int len = 0;
        while (num > 0) {
            len++;
            num/=10;
        }

        return len;
    }
}
