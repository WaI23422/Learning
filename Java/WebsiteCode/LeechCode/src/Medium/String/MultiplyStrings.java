package Medium.String;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/multiply-strings/">43. Multiply Strings</a>
 * <div class="elfjS" data-track-load="description_content"><p>Given two non-negative integers <code>num1</code> and <code>num2</code> represented as strings, return the product of <code>num1</code> and <code>num2</code>, also represented as a string.</p>

<p><strong>Note:</strong>&nbsp;You must not use any built-in BigInteger library or convert the inputs to integer directly.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> num1 = "2", num2 = "3"
<strong>Output:</strong> "6"
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> num1 = "123", num2 = "456"
<strong>Output:</strong> "56088"
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= num1.length, num2.length &lt;= 200</code></li>
	<li><code>num1</code> and <code>num2</code> consist of digits only.</li>
	<li>Both <code>num1</code> and <code>num2</code>&nbsp;do not contain any leading zero, except the number <code>0</code> itself.</li>
</ul>
</div>
 */
public class MultiplyStrings {
    public static void main(String[] args) {
        String[][] tests = {
            {"99999", "1"},
            {"1","99999"},
            {"2","3"},
            {"123","456"},
            {"99","999"},
            {"17317453154533857284828218582046236657752671385677683468533627243431230454047757848212053766172182634016160823230828522321133077678043137202138254630744336805370104034482553070272878382414438258733300",
            "10465206512830645480168160783478070578066444573040351225025041762777143753236887285187323616458006552481435485066053534036378865686568522252185448810820727044137783524847807252363082181071475135575600"},
        };

        for (String[] test : tests) {
            String num1 = test[0],
                   num2 = test[1];

            System.out.println(new MultiplyStrings_Solution().multiply(num1, num2));
        }
    }
}

// 2 ms 41.5 MB 
class MultiplyStrings_Solution {
    public String multiply(String num1, String num2) {
        int len1 = num1.length(), 
            len2 = num2.length();
        
        if (num1.equals("0") || num2.equals("0")) {return "0";} // 6 ms 42.5 MB -> 5 ms 41.7 MB
        // if (len2 == 1) {
        //     if (num2.equals("1")) {
        //         return num1;
        //     }
        //     if (num2.equals("0")) {
        //         return "0";
        //     }
        // }
        // if (len1 == 1) {
        //     if (num1.equals("1")) {
        //         return num2;
        //     }
        //     if (num1.equals("0")) {
        //         return "0";
        //     }
        // }
        
        StringBuilder ans = new StringBuilder();

        // int[] num1Arr = num1.chars()
        //                     .map(x -> x- '0')
        //                     .toArray();
        // int[] num2Arr = num2.chars()
        //                     .map(x -> x - '0')
        //                     .toArray();
        char[] num1Arr = num1.toCharArray(), // 5 ms 41.7 MB -> 2 ms 42.2 MB
               num2Arr = num2.toCharArray();

        int[] sumArr = new int[len1+len2-1];

        for (int i = 0; i < num1Arr.length; i++) {
            for (int j = 0; j < num2Arr.length; j++) {
                sumArr[i + j] += (num1Arr[i]-'0')*(num2Arr[j]-'0');
            }
        }

        int remain = 0;
        for (int i = sumArr.length-1; i >= 0; i--) {
            // int num = sumArr[i]+remain;
            // ans.append(num%10);
            // remain = num/10;
            ans.append((sumArr[i]+remain)%10); // 2 ms 42.2 MB -> 2 ms 41.5 MB 
            remain = (sumArr[i]+remain)/10;
        }

        if (remain !=0) {
            ans.append(remain);
        }

        return ans.reverse().toString();
    }
}