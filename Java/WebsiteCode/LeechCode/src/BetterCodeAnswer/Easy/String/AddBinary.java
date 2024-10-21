package BetterCodeAnswer.Easy.String;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/add-binary/">67.Add Binary</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>Given two binary strings <code>a</code> and <code>b</code>, return <em>their sum as a binary string</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> a = "11", b = "1"
<strong>Output:</strong> "100"
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> a = "1010", b = "1011"
<strong>Output:</strong> "10101"
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= a.length, b.length &lt;= 10<sup>4</sup></code></li>
	<li><code>a</code> and <code>b</code> consist&nbsp;only of <code>'0'</code> or <code>'1'</code> characters.</li>
	<li>Each string does not contain leading zeros except for the zero itself.</li>
</ul>
</div></div>
 */
public class AddBinary {
    public static void main(String[] args) {
        String[][] tests = {
            {"11","1"},
            {"1010","1011"}
        };

        for (String[] test : tests) {
            String a = test[0], b = test[1];

            System.out.println(new AddBinary_Solution().addBinary(a, b));
        }
    }
}

// @see Easy.String.AddBinary.java
class AddBinary_Solution {
    public String addBinary(String a, String b) {
        return "";
    }
}