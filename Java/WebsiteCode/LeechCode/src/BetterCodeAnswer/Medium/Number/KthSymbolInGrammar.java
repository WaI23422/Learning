package BetterCodeAnswer.Medium.Number;

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

/**
 * <h1 id="solution-1-recursive-approach">Solution 1: Recursive Approach</h1>
 * 
 * <h2 id="intuition">Intuition</h2>
 * <p>The initial thought on solving the problem revolves around understanding the pattern of sequence generation as described in the problem statement. As the sequence grows by replacing 0 with 01 and 1 with 10, we can observe a recursive relationship between the nth row and the (n-1)th row.</p>
 * <h2 id="approach">Approach</h2>
 * <p>Our approach is to leverage the recursive pattern observed. The length of the nth row is double the length of the (n-1)th row. If k is in the first half of the nth row, the symbol at position k in the nth row is the same as the symbol at position k in the (n-1)th row. If k is in the second half of the nth row, the symbol at position k in the nth row is the opposite of the symbol at position (k - length of (n-1)th row) in the (n-1)th row.</p>
 */
class KthSymbolInGrammar_Solution {
    // 0 ms 
    // 39.5 MB
    public int kthGrammar(int n, int k) {
        if (n == 1) return 0;
        int length = 1 << (n - 2);
        if (k <= length) return kthGrammar(n - 1, k);
        else return 1 - kthGrammar(n - 1, k - length);
    }
}

class KthSymbolInGrammar_Solution2 {    
    // 0 ms 
    // 39 MB
    public int kthGrammar(int n, int k) {
        if (n == 1) return 0;
        int parent = kthGrammar(n-1, k / 2 + ((k % 2 == 0) ? 0 : 1));
        if (k % 2 == 1) {
            if (parent == 0) 
                return 0;
            else 
                return 1;
        }
        else {
            if (parent == 0) 
                return 1;
            else 
                return 0;
        }
    }
}
