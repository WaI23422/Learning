package Easy.String;

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

// 3 ms 42.7 MB
class AddStrings_Solution {
    public String addStrings(String num1, String num2) {
        StringBuffer ans = new StringBuffer();
        int len1 = num1.length(),
            len2 = num2.length(),
            len = len1 > len2 ? len2 : len1,
            remain =0 ;
        char[] nums1 = num1.toCharArray(),
               nums2 = num2.toCharArray();

        for (int i = 0; i < len; i++) {
            int total = (nums1[len1 - 1 - i] - '0') + (nums2[len2 - 1 - i] - '0') + remain;
            
            remain = 0;
            if (total > 9) {
                total%=10;
                remain = 1;
            }
            
            ans.append(total);
        }

        if (len1 - len == 0) {
            nums1 = nums2;
            len1 = len2;
        }
        for (int i = len1-len-1; i >= 0; i--) {
            int total = (nums1[i]-'0') + remain;
            
            remain = 0;
            if (total > 9) {
                total%=10;
                remain = 1;
            }

            ans.append(total);
        }

        if (remain == 1) {ans.append(1);}

        return ans.reverse().toString();
    }
}