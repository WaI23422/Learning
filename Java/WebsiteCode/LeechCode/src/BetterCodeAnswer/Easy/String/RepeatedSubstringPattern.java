package BetterCodeAnswer.Easy.String;

/**
 * <div class="flex-1"><div class="flex h-full items-center"><a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/repeated-substring-pattern/">459.Repeated Substring Pattern</a><div class="inline-flex min-h-[20px] items-center space-x-2 align-top mt-1"><div class="inline-flex items-center space-x-2"></div></div></div></div>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>Given a string <code>s</code>, check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> s = "abab"
<strong>Output:</strong> true
<strong>Explanation:</strong> It is the substring "ab" twice.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> s = "aba"
<strong>Output:</strong> false
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> s = "abcabcabcabc"
<strong>Output:</strong> true
<strong>Explanation:</strong> It is the substring "abc" four times or the substring "abcabc" twice.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>4</sup></code></li>
	<li><code>s</code> consists of lowercase English letters.</li>
</ul>
</div></div>
 */
public class RepeatedSubstringPattern {
    public static void main(String[] args) {
        String s = "ababab";

        RepeatedSubstringPattern_Solution repeatedSubstringPattern_Solution = new RepeatedSubstringPattern_Solution();

        System.out.println(repeatedSubstringPattern_Solution.repeatedSubstringPattern(s));;
    }   
}

/**
 * <h1 id="intuition">Intuition</h1>
 * 
 * <p>Using KMP - create LPS array for given String to check if we see a pattern</p>
 * 
 * <h1 id="approach">Approach</h1>
 * 
 * <p>We start by creating LPS array, for a given string: abaadabaadabaad, LPS array would be<br>
[0,0,1,1,0,1,2,3,4,5,6,7,8,9,10]<br>
We see a pattern i.e. LPS array values are monotonically increasing from idx 5 ( patternLength ) in the above example</p>
<div class="mb-6 rounded-lg px-3 py-2.5 font-menlo text-sm bg-fill-3 dark:bg-dark-fill-3"><div class="group relative" translate="no"><pre style="color: black; font-size: 13px; text-shadow: none; font-family: Menlo, Monaco, Consolas; text-align: left; white-space: pre; word-spacing: normal; word-break: normal; line-height: 1.5; tab-size: 4; hyphens: none; padding: 0px; margin: 0px; overflow: auto; background: transparent; overflow-wrap: normal;"><code class="language-sql" style="text-shadow: none; white-space: pre;"><span><span>condition </span><span class="token" style="color: rgb(153, 0, 85);">1</span><span>: so</span><span class="token" style="color: rgb(153, 153, 153);">,</span><span> the lps</span><span class="token" style="color: rgb(153, 153, 153);">[</span><span>n</span><span class="token" style="color: rgb(154, 110, 58); background: rgba(255, 255, 255, 0.5);">-</span><span class="token" style="color: rgb(153, 0, 85);">1</span><span class="token" style="color: rgb(153, 153, 153);">]</span><span> </span><span class="token" style="color: rgb(154, 110, 58); background: rgba(255, 255, 255, 0.5);">=</span><span> stringLength </span><span class="token" style="color: rgb(154, 110, 58); background: rgba(255, 255, 255, 0.5);">-</span><span> patternLength
</span></span><span><span>condition </span><span class="token" style="color: rgb(153, 0, 85);">2</span><span>: we also know that </span><span class="token" style="color: rgb(153, 153, 153);">(</span><span>stringLength </span><span class="token" style="color: rgb(154, 110, 58); background: rgba(255, 255, 255, 0.5);">%</span><span> patternLength </span><span class="token" style="color: rgb(154, 110, 58); background: rgba(255, 255, 255, 0.5);">=</span><span class="token" style="color: rgb(154, 110, 58); background: rgba(255, 255, 255, 0.5);">=</span><span> </span><span class="token" style="color: rgb(153, 0, 85);">0</span><span class="token" style="color: rgb(153, 153, 153);">)</span><span> </span><span class="token" style="color: rgb(0, 119, 170);">for</span><span> repetition</span></span></code></pre><div class="h-4 w-4 cursor-pointer fill-gray-6 hover:fill-gray-7 dark:fill-dark-gray-6 dark:hover:fill-dark-gray-7 absolute right-0 top-0"><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="1em" height="1em" fill="currentColor" class="h-4 w-4 text-gray-6 hover:text-gray-7 dark:text-dark-gray-6 dark:hover:text-dark-gray-7 hidden group-hover:block"><path fill-rule="evenodd" d="M11.3 8.3H19a3 3 0 013 3V19a3 3 0 01-3 3h-7.7a3 3 0 01-3-3v-7.7a3 3 0 013-3zm0 2a1 1 0 00-1 1V19a1 1 0 001 1H19a1 1 0 001-1v-7.7a1 1 0 00-1-1h-7.7zm-5.6 3.4a1 1 0 110 2h-.9A2.8 2.8 0 012 12.9V4.8A2.8 2.8 0 014.8 2h8.1a2.8 2.8 0 012.8 2.8v.9a1 1 0 11-2 0v-.9a.8.8 0 00-.8-.8H4.8a.8.8 0 00-.8.8v8.1a.8.8 0 00.8.8h.9z" clip-rule="evenodd"></path></svg></div></div></div>
 */
class RepeatedSubstringPattern_Solution {
    // 7 ms
    // 44.3 MB
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        if( len == 1) {
            return false;
        }
        return isRepeatedPatternUsingKMP(s, len);
    }


    // KMP - O(n)
    // we start by creating LPS array, for a given string: abaadabaadabaad, LPS array would be
    // [0,0,1,1,0,1,2,3,4,5,6,7,8,9,10]
    // we see a pattern i.e. LPS array values are monotonically increasing from idx 5 ( patternLength ) in the above example
    // condition 2: so, the lps[n-1] = stringLength - patternLength
    // condition 1: we also know that (stringLength % patternLength == 0) for repetition

    boolean isRepeatedPatternUsingKMP(String s, int len){
        int[] lps = preprocessing(s, len);
        int lastElement = lps[len-1];

        // check condition for all valid pattern lengths
        for(int patLen=1; patLen <= len/2; patLen++){
            if(len % patLen == 0){
                // valid patternLength - condition 1
                if(lastElement == len - patLen){
                    // condition 2
                    return true;
                }
            }
        }
        return false;
    }

    //preprocessing - creating LPS array
    int[] preprocessing(String s, int len){
        int[] lps = new int[len];

        int i=0, j= 1;

        while(j < len){
            if(s.charAt(i) == s.charAt(j)){
                // matching
                lps[j] = i+1;
                i++;
                j++;
            }else{
                // not matching
                if(i != 0){
                    i = lps[i-1];
                }else{
                    // reached leftmost idx, couldn't find : put zero, let's move on
                    lps[j] =0;
                    j++;
                }
            }
        }
        return lps;
    }
}

class RepeatedSubstringPattern_Solution2 {
    // 74 ms
    // 44.5 MB
    public boolean repeatedSubstringPattern(String s) {
        String doubled = s + s;
        String sub = doubled.substring(1, doubled.length() - 1);
        return sub.contains(s);
    }

    
}