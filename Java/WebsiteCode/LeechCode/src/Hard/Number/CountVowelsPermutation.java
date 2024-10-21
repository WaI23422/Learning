package Hard.Number;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/count-vowels-permutation/">1220.Count Vowels Permutation</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>Given an integer <code>n</code>, your task is to count how many strings of length <code>n</code> can be formed under the following rules:</p>

<ul>
	<li>Each character is a lower case vowel&nbsp;(<code>'a'</code>, <code>'e'</code>, <code>'i'</code>, <code>'o'</code>, <code>'u'</code>)</li>
	<li>Each vowel&nbsp;<code>'a'</code> may only be followed by an <code>'e'</code>.</li>
	<li>Each vowel&nbsp;<code>'e'</code> may only be followed by an <code>'a'</code>&nbsp;or an <code>'i'</code>.</li>
	<li>Each vowel&nbsp;<code>'i'</code> <strong>may not</strong> be followed by another <code>'i'</code>.</li>
	<li>Each vowel&nbsp;<code>'o'</code> may only be followed by an <code>'i'</code> or a&nbsp;<code>'u'</code>.</li>
	<li>Each vowel&nbsp;<code>'u'</code> may only be followed by an <code>'a'.</code></li>
</ul>

<p>Since the answer&nbsp;may be too large,&nbsp;return it modulo <code>10^9 + 7.</code></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> n = 1
<strong>Output:</strong> 5
<strong>Explanation:</strong> All possible strings are: "a", "e", "i" , "o" and "u".
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> n = 2
<strong>Output:</strong> 10
<strong>Explanation:</strong> All possible strings are: "ae", "ea", "ei", "ia", "ie", "io", "iu", "oi", "ou" and "ua".
</pre>

<p><strong class="example">Example 3:&nbsp;</strong></p>

<pre><strong>Input:</strong> n = 5
<strong>Output:</strong> 68</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 2 * 10^4</code></li>
</ul>
</div></div>
 */
public class CountVowelsPermutation {
    public static void main(String[] args) {
        int[] tests = {1,2,5};

        CountVowelsPermutation_Solution res= new CountVowelsPermutation_Solution();

        for (int numb : tests) {
            System.out.println(res.countVowelPermutation(numb));
            res.res = 0;
        }
    }
}

class CountVowelsPermutation_Solution {
    int res;
    
    // Time Limit Exceeded
    public void Counting(char c, int n){
        if (n == 0) {
            res++;
            return;
        }
        
        if (c == 'a') {
            Counting('e', n-1);
        } else if (c == 'e') {
            Counting('a', n-1);
            Counting('i', n-1);
        } else if (c == 'i') {
            Counting('a', n-1);
            Counting('e', n-1);
            Counting('o', n-1);
            Counting('u', n-1);
        } else if (c == 'o') {
            Counting('u', n-1);
            Counting('i', n-1);
        } else {
            Counting('a', n-1);
        }
    }

    public int countVowelPermutation(int n) {
        int MOD = 1000000007;

        Counting('a', n-1);
        Counting('e', n-1);
        Counting('i', n-1);
        Counting('o', n-1);
        Counting('u', n-1);

        return res%MOD;
    }
}
