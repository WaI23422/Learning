package BetterCodeAnswer.Easy.Arrays;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/convert-a-number-to-hexadecimal/">405. Convert a Number to Hexadecimal</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given an integer <code>num</code>, return <em>a string representing its hexadecimal representation</em>. For negative integers, <a href="https://en.wikipedia.org/wiki/Two%27s_complement" target="_blank">two’s complement</a> method is used.</p>

<p>All the letters in the answer string should be lowercase characters, and there should not be any leading zeros in the answer except for the zero itself.</p>

<p><strong>Note:&nbsp;</strong>You are not allowed to use any built-in library method to directly solve this problem.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> num = 26
<strong>Output:</strong> "1a"
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> num = -1
<strong>Output:</strong> "ffffffff"
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>-2<sup>31</sup> &lt;= num &lt;= 2<sup>31</sup> - 1</code></li>
</ul>
</div>
 */
public class ConvertANumberToHexadecimal {
    public static void main(String[] args) {
        int[] tests = {
            -26,
            26,
        };
    
        for (int num : tests) {
            System.out.println(new ConvertANumberToHexadecimal_Solution().toHex(num));;
        }
    }
}

// 0 ms 40.6 MB
class ConvertANumberToHexadecimal_Solution {
    public String toHex(int num) {
        if (num == 0) return "0";
        StringBuilder result = new StringBuilder();

        long n = num < 0 ? (long) num + (1L << 32) : num;
        
        while (n > 0) {
            int rem = (int) (n % 16);
            char hexDigit = rem < 10 ? (char) ('0' + rem) : (char) ('a' + rem - 10);
            result.insert(0, hexDigit);
            n /= 16;
        }
        
        return result.toString();
    }
}
