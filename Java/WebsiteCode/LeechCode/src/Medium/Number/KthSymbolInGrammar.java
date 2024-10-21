package Medium.Number;

import java.util.ArrayList;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/k-th-symbol-in-grammar/">779. K-th Symbol in Grammar</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>We build a table of <code>n</code> rows (<strong>1-indexed</strong>). We start by writing <code>0</code> in the <code>1<sup>st</sup></code> row. Now in every subsequent row, we look at the previous row and replace each occurrence of <code>0</code> with <code>01</code>, and each occurrence of <code>1</code> with <code>10</code>.</p>

<ul>
	<li>For example, for <code>n = 3</code>, the <code>1<sup>st</sup></code> row is <code>0</code>, the <code>2<sup>nd</sup></code> row is <code>01</code>, and the <code>3<sup>rd</sup></code> row is <code>0110</code>.</li>
</ul>

<p>Given two integer <code>n</code> and <code>k</code>, return the <code>k<sup>th</sup></code> (<strong>1-indexed</strong>) symbol in the <code>n<sup>th</sup></code> row of a table of <code>n</code> rows.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> n = 1, k = 1
<strong>Output:</strong> 0
<strong>Explanation:</strong> row 1: <u>0</u>
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> n = 2, k = 1
<strong>Output:</strong> 0
<strong>Explanation:</strong> 
row 1: 0
row 2: <u>0</u>1
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> n = 2, k = 2
<strong>Output:</strong> 1
<strong>Explanation:</strong> 
row 1: 0
row 2: 0<u>1</u>
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 30</code></li>
	<li><code>1 &lt;= k &lt;= 2<sup>n - 1</sup></code></li>
</ul>
</div></div>
 */
public class KthSymbolInGrammar {
    public static void main(String[] args) {
        int[][] tests = {
            {1,1},
            {2,2},
            {2,1}
        };

        KthSymbolInGrammar_Solution res = new KthSymbolInGrammar_Solution();

        for (int[] test : tests) {
            System.out.println(res.kthGrammar(test[0], test[1]));
        }
    }
}

// Memory Limit Exceed
class KthSymbolInGrammar_Solution {
    public int kthGrammar(int n, int k) {
        int track = 1;
        ArrayList<Integer> myList = new ArrayList<>();
        ArrayList<Integer> CopyList = new ArrayList<>();

        myList.add(0);
        while (track < n) {
            CopyList.addAll(myList);
            myList.clear();    
            for (Integer integer : CopyList) {
                if (integer == 0) {
                    myList.add(0);
                    myList.add(1);
                } else {
                    myList.add(1);
                    myList.add(0);
                }
            }

            track++;
            CopyList.clear();
        }

        return myList.get(k-1);
    }
}
