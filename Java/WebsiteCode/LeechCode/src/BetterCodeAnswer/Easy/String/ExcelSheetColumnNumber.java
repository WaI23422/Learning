package BetterCodeAnswer.Easy.String;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/excel-sheet-column-number/">171.Excel Sheet Column Number</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given a string <code>columnTitle</code> that represents the column title as appears in an Excel sheet, return <em>its corresponding column number</em>.</p>

<p>For example:</p>

<pre>A -&gt; 1
B -&gt; 2
C -&gt; 3
...
Z -&gt; 26
AA -&gt; 27
AB -&gt; 28 
...
</pre>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> columnTitle = "A"
<strong>Output:</strong> 1
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> columnTitle = "AB"
<strong>Output:</strong> 28
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> columnTitle = "ZY"
<strong>Output:</strong> 701
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= columnTitle.length &lt;= 7</code></li>
	<li><code>columnTitle</code> consists only of uppercase English letters.</li>
	<li><code>columnTitle</code> is in the range <code>["A", "FXSHRXW"]</code>.</li>
</ul>
</div>
 */
public class ExcelSheetColumnNumber {
    public static void main(String[] args) {
        String[] tests = {
            "A",
            "AB",
            "CYZ",
            "ZZZ",
            "FXSHRXW"
        };

        for (String columnTitle : tests) {
            System.out.println(new ExcelSheetColumnNumber_Solution().titleToNumber(columnTitle));
        }
    }
}

// 1ms 41.92 MB
class ExcelSheetColumnNumber_Solution {
    public int titleToNumber(String col) {
        int n=col.length();
        int columnNumber=0;
        for(int i=0;i<n;i++){
            int currentColumn=col.charAt(i)-'A'+1;
            columnNumber= columnNumber*26+currentColumn;
        }
        return columnNumber;
    }
}