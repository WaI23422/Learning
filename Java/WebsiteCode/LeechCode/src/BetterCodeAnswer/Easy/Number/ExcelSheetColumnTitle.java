package BetterCodeAnswer.Easy.Number;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/excel-sheet-column-title/">168.Excel Sheet Column Title</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given an integer <code>columnNumber</code>, return <em>its corresponding column title as it appears in an Excel sheet</em>.</p>

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

<pre><strong>Input:</strong> columnNumber = 1
<strong>Output:</strong> "A"
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> columnNumber = 28
<strong>Output:</strong> "AB"
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> columnNumber = 701
<strong>Output:</strong> "ZY"
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= columnNumber &lt;= 2<sup>31</sup> - 1</code></li>
</ul>
</div>
 */
public class ExcelSheetColumnTitle {
    public static void main(String[] args) {
        int[] tests = {
            1,
            260,
            701,
            28,
            26
        };

        for (int columnNumber : tests) {
            System.out.println(new ExcelSheetColumnTitle_Solution().convertToTitle(columnNumber));
        }
    }
}

// 0 ms 40.78 MB
class ExcelSheetColumnTitle_Solution {
    public String convertToTitle(int columnNumber) {
        char arr[] = new char[27];
        String str = "";

        for(int i=1;i<arr.length;i++){
            arr[i] = (char)(64+i);
        }

        if(columnNumber > 26){
            while(columnNumber/26 >= 1){
                 
                if(columnNumber%26 <= 26){
                    if(columnNumber%26 == 0){
                        str = "Z"+str;
                        columnNumber = columnNumber-1;
                    }else {
                        str = String.valueOf(arr[columnNumber%26])+str;
                    }
                }
                if(columnNumber/26 <= 26){
                    str = String.valueOf(arr[columnNumber/26])+str;
                    break;
                }else {
                    columnNumber = columnNumber/26;
                }
            }
        }else{
            str = String.valueOf(arr[columnNumber]);
        }

        return str;
    }
}