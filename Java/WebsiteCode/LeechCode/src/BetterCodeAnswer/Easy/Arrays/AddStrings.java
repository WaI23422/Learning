package BetterCodeAnswer.Easy.Arrays;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/add-strings/">415. Add Strings</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given two non-negative integers, <code>num1</code> and <code>num2</code> represented as string, return <em>the sum of</em> <code>num1</code> <em>and</em> <code>num2</code> <em>as a string</em>.</p>

<p>You must solve the problem without using any built-in library for handling large integers (such as <code>BigInteger</code>). You must also not convert the inputs to integers directly.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> num1 = "11", num2 = "123"
<strong>Output:</strong> "134"
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> num1 = "456", num2 = "77"
<strong>Output:</strong> "533"
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> num1 = "0", num2 = "0"
<strong>Output:</strong> "0"
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= num1.length, num2.length &lt;= 10<sup>4</sup></code></li>
	<li><code>num1</code> and <code>num2</code> consist of only digits.</li>
	<li><code>num1</code> and <code>num2</code> don't have any leading zeros except for the zero itself.</li>
</ul>
</div>
 */
public class AddStrings {
    public static void main(String[] args) {
        String[][] tests =  {
            {"11","123"},
            {"123","456"},
            {"999","1"},
            {"1","999"},
        };

        for (String[] test : tests) {
            String num1 = test[0],
                   num2 = test[1];

            System.out.println(new AddStrings_Solution().addStrings(num1, num2));
        }
    }
}

// 2 ms 42.7 MB
class AddStrings_Solution {
    public String addStrings(String num1, String num2) {
        return sum(num1, num2);
    }
    
    
    String sum(String num1, String num2){
        char[] arr1 = num1.toCharArray();
        char[] arr2 = num2.toCharArray();
        int i = arr1.length - 1;
        int j = arr2.length - 1;
        StringBuilder sb = new StringBuilder();
        int carr = 0;
        while(i >= 0 && j >= 0){
            int res = add(carr, arr1[i--], arr2[j--]);
            sb.append(res % 10);
            carr = res / 10;
        }
        while(i >= 0){
            int res = add(carr, arr1[i--]);
            sb.append(res % 10);
            carr = res / 10;
        }
        while(j >= 0){
            int res = add(carr, arr2[j--]);
            sb.append(res % 10);
            carr = res / 10;
        }
        if(carr > 0){
            sb.append(carr);
        }
        return sb.reverse().toString();
    }
    int add(int b, char... arr){
        int sum = 0;
        for(char a : arr){
            sum += (a - '0');
        }
        return sum + b;
    }
}

// 2 ms 42.7 MB
class AddStrings_Solution2 {
    // time:o(n) space:o(1)
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1;
        StringBuilder ans = new StringBuilder();
        int carry = 0;
        while(i >= 0 || j >= 0) {
            int c1 = i >= 0 ? num1.charAt(i--) - '0' : 0;
            int c2 = j >= 0 ? num2.charAt(j--) - '0' : 0;
            int num = c1 + c2 + carry;
            int digit = num % 10;
            carry = num / 10;
            // here we don't do ans.insert(0, digit) because it will make the time complexit to be o(n^2)
            ans.append(digit);
        }
        
        if(carry != 0) {
            ans.append(carry);
        }
        return ans.reverse().toString();
    }

    // follow up - float number
    /*private static final String ZERO = "0";

    // Time: O(Max (N, M)); N = str1 length, M = str2 length
    // Space: O(N + M)
    public String addString(String str1, String str2) {

        String[] s1 = str1.split("\\.");
        String[] s2 = str2.split("\\.");

        StringBuilder sb = new StringBuilder();

        // step 1. calculate decimal points after .
        // decimal points
        // prepare decimal point.
        String sd1 = s1.length > 1 ? s1[1] : ZERO;
        String sd2 = s2.length > 1 ? s2[1] : ZERO;
        while (sd1.length() != sd2.length()) {
            if (sd1.length() < sd2.length()) {
                sd1 += ZERO;
            } else {
                sd2 += ZERO;
            }
        }
        int carry = addStringHelper(sd1, sd2, sb, 0);

        sb.append(".");

        // Step 2. Calculate Number before decimal point.
        // Number
        addStringHelper(s1[0], s2[0], sb, carry);
        return sb.reverse().toString();
    }

    // This is modified version of add strings.
    private int addStringHelper(String str1, String str2, StringBuilder sb, int carry) {
        int i = str1.length() - 1;
        int j = str2.length() - 1;
        while (i >= 0 || j >= 0) {
            int c1 = i >= 0 ? str1.charAt(i--) - '0' : 0;
            int c2 = j >= 0 ? str2.charAt(j--) - '0' : 0;
            int num = c1 + c2 + carry;
            int digit = num % 10;
            carry = num / 10;
            // here we don't do ans.insert(0, digit) because it will make the time complexit to be o(n^2)
            ans.append(digit);
        }
        return carry;
    }*/
}