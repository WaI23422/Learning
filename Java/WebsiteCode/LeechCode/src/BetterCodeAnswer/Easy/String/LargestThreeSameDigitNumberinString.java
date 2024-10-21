package BetterCodeAnswer.Easy.String;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/largest-3-same-digit-number-in-string/">2264.Largest 3-Same-Digit Number in String</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>You are given a string <code>num</code> representing a large integer. An integer is <strong>good</strong> if it meets the following conditions:</p>

<ul>
	<li>It is a <strong>substring</strong> of <code>num</code> with length <code>3</code>.</li>
	<li>It consists of only one unique digit.</li>
</ul>

<p>Return <em>the <strong>maximum good </strong>integer as a <strong>string</strong> or an empty string </em><code>""</code><em> if no such integer exists</em>.</p>

<p>Note:</p>

<ul>
	<li>A <strong>substring</strong> is a contiguous sequence of characters within a string.</li>
	<li>There may be <strong>leading zeroes</strong> in <code>num</code> or a good integer.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> num = "6<strong><u>777</u></strong>133339"
<strong>Output:</strong> "777"
<strong>Explanation:</strong> There are two distinct good integers: "777" and "333".
"777" is the largest, so we return "777".
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> num = "23<strong><u>000</u></strong>19"
<strong>Output:</strong> "000"
<strong>Explanation:</strong> "000" is the only good integer.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> num = "42352338"
<strong>Output:</strong> ""
<strong>Explanation:</strong> No substring of length 3 consists of only one unique digit. Therefore, there are no good integers.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>3 &lt;= num.length &lt;= 1000</code></li>
	<li><code>num</code> only consists of digits.</li>
</ul>
</div></div>
 */
public class LargestThreeSameDigitNumberinString {
    public static void main(String[] args) {
        String[] tests = {
            "6777133339",
            "2300019",
            "42352338"
        };

        for (String num : tests) {
            System.out.println(new LargestThreeSameDigitNumberinString_Solution().largestGoodInteger(num));
        }
    }
}

class LargestThreeSameDigitNumberinString_Solution {
    // 1 ms 40.8 MB
    public String largestGoodInteger(String num) {
        int result = -1;
        for (int i = 0; i + 2 < num.length(); i++) {
            if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i) == num.charAt(i + 2)) {
                result = Math.max(result, num.charAt(i) - '0');
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            builder.append((char)(48 + result));
        }
        return result == -1 ? "" : builder.toString();
    }
}

class LargestThreeSameDigitNumberinString_Solution2 {
    public String largestGoodInteger(String num) {
        if (num.indexOf("999") != -1) {
            return "999";
        } else if (num.indexOf("888") != -1) {
            return "888";
        } else if (num.indexOf("777") != -1) {
            return "777";
        } else if (num.indexOf("666") != -1) {
            return "666";
        } else if (num.indexOf("555") != -1) {
            return "555";
        } else if (num.indexOf("444") != -1) {
            return "444";
        } else if (num.indexOf("333") != -1) {
            return "333";
        } else if (num.indexOf("222") != -1) {
            return "222";
        } else if (num.indexOf("111") != -1) {
            return "111";
        } else if (num.indexOf("000") != -1) {
            return "000";
        }

        return "";
        
    }
}