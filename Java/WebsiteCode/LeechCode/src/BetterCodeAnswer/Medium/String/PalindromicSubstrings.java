package BetterCodeAnswer.Medium.String;

/*
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/palindromic-substrings/">647.Palindromic Substrings</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given a string <code>s</code>, return <em>the number of <strong>palindromic substrings</strong> in it</em>.</p>

<p>A string is a <strong>palindrome</strong> when it reads the same backward as forward.</p>

<p>A <strong>substring</strong> is a contiguous sequence of characters within the string.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> s = "abc"
<strong>Output:</strong> 3
<strong>Explanation:</strong> Three palindromic strings: "a", "b", "c".
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> s = "aaa"
<strong>Output:</strong> 6
<strong>Explanation:</strong> Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 1000</code></li>
	<li><code>s</code> consists of lowercase English letters.</li>
</ul>
</div>
 */
public class PalindromicSubstrings {
    public static void main(String[] args) {
        String[] tests = {
            "abc",
            "aaa",
            "abbbcac"
        };
        
        for (String s : tests) {
            System.out.println(new PalindromicSubstrings_Solution().countSubstrings(s));
        }
    }
}

// 0 ms 41.73 MB
class PalindromicSubstrings_Solution {
    int start=0,length=0,maxLength=0,count=0;
    public int countSubstrings(String s) {
         length =s.length();

        for(int i=0;i<length;i++){
            i = countAndReturnNextIndex(s,i);
            // count++;
        }   
        return count;
    }
    
    public int countAndReturnNextIndex(String s,int k){
        
        int left = k-1,right=k;
        while(right<length -1 && s.charAt(right) == s.charAt(right+1)) right++;
        int countOfSameChar = right-left;
        if(countOfSameChar >=1){
            //5 =5 + 4 +3 + 2 +1
            //4 = 4 +3 + 2 +1
            count+= (countOfSameChar*(countOfSameChar+1))/2 ;
            // System.out.println(left+" "+right+" "+length);
            // System.out.println(countOfSameChar);
        }
        int nextIndex = right++;
        while(left>=0 && right<length && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
            count++;
        }
        return nextIndex;

    }
}