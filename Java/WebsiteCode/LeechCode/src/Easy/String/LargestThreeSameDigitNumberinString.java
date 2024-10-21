package Easy.String;

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
    // 5 ms 40.6 MB
    public String largestGoodInteger(String num) {
        char[] numArr = num.toCharArray();
        char hold = ' ';
        String ans = "";

        for (int i = 0; i < numArr.length-2; i++) {
            if (numArr[i] - numArr[i+1] == 0 && numArr[i+1] - numArr[i+2] == 0) {
                if (hold - numArr[i] <0) { hold = numArr[i];}
            }
        }

        if (hold != ' ') {
            for (int i = 0; i < 3; i++) {ans += hold;}
        }

        return ans;
    }
}

class LargestThreeSameDigitNumberinString_Solution2 {
    //6 ms 41.5 MB
    public boolean isThreeSameDigit(char num1, char num2, char num3){
        if (num1 - num2 == 0 && num2 - num3 ==0) {return true;}

        return false;
    }

    public String largestGoodInteger(String num) {
        char[] numArr = num.toCharArray();
        char hold = ' ';

        for (int i = 0; i < numArr.length-2; i++) {
            if (isThreeSameDigit(numArr[i], numArr[i+1], numArr[i+2])) {
                if (hold - numArr[i] <0) { hold = numArr[i];}
            }
        }

        if (hold != ' ') {
            String ans = "";
            for (int i = 0; i < 3; i++) {ans += hold;}
            return ans;
        }

        return "";
    }
}