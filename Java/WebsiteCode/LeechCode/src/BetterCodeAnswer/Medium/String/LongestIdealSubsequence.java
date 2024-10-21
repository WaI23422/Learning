package BetterCodeAnswer.Medium.String;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/longest-ideal-subsequence/">2370. Longest Ideal Subsequence</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You are given a string <code>s</code> consisting of lowercase letters and an integer <code>k</code>. We call a string <code>t</code> <strong>ideal</strong> if the following conditions are satisfied:</p>

<ul>
	<li><code>t</code> is a <strong>subsequence</strong> of the string <code>s</code>.</li>
	<li>The absolute difference in the alphabet order of every two <strong>adjacent</strong> letters in <code>t</code> is less than or equal to <code>k</code>.</li>
</ul>

<p>Return <em>the length of the <strong>longest</strong> ideal string</em>.</p>

<p>A <strong>subsequence</strong> is a string that can be derived from another string by deleting some or no characters without changing the order of the remaining characters.</p>

<p><strong>Note</strong> that the alphabet order is not cyclic. For example, the absolute difference in the alphabet order of <code>'a'</code> and <code>'z'</code> is <code>25</code>, not <code>1</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> s = "acfgbd", k = 2
<strong>Output:</strong> 4
<strong>Explanation:</strong> The longest ideal string is "acbd". The length of this string is 4, so 4 is returned.
Note that "acfgbd" is not ideal because 'c' and 'f' have a difference of 3 in alphabet order.</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> s = "abcd", k = 3
<strong>Output:</strong> 4
<strong>Explanation:</strong> The longest ideal string is "abcd". The length of this string is 4, so 4 is returned.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= k &lt;= 25</code></li>
	<li><code>s</code> consists of lowercase English letters.</li>
</ul>
</div>
 */
public class LongestIdealSubsequence {
    public static void main(String[] args) {
        String[][] tests = {
            {"acfgbd","2"},
            {"abcd","3"},
        };

        for (String[] test : tests) {
            String s = test[0];
            int k = Integer.parseInt(test[1]);

            System.out.println(new LongestIdealSubsequence_Solution().longestIdealString(s, k));
        }
    }
}

// 13 ms 45 MB
class LongestIdealSubsequence_Solution {
    public int longestIdealString(String s, int k) {
        
        int[] dp = new int[27];
        int n = s.length();
        
        for(int i = n-1; i >= 0 ;i--){
            char cc = s.charAt(i);
            int idx = cc - 'a';
            int max  = Integer.MIN_VALUE;
            
            int left = Math.max((idx-k), 0);
            int right = Math.min((idx + k), 26);
            
            for(int j = left; j <= right ; j++){
                max = Math.max(max, dp[j]);
            }
            
            dp[idx] = max+1;
        }
        
        int max = Integer.MIN_VALUE;
        
        for(int ele : dp){
            max = Math.max(ele, max);
        }
        
        return max;
    }
}

// 17 ms 44.5 MB
class LongestIdealSubsequence_Solution2 {
    //approach: calculate the max subsequence formed at each character
    public int longestIdealString(String s, int k) {
        return helper(s.toCharArray(),k);
    }
   public int helper(char arr[],int k) {
       int freq[]=new int[26];
       for(int i=0;i<arr.length;i++){
           int chk1=Math.max(97,arr[i]-k)-97;
           int chk2=Math.min(122,arr[i]+k)-97;
           int l=0,h=0;
           for(int j=chk1;j<=(arr[i]+0)-97;j++)
               l=Math.max(freq[j],l);
           for(int j=(arr[i]+1)-97;j<=chk2;j++)
               h=Math.max(freq[j],h);
           int x=Math.max(l,h)+1;
           freq[arr[i]-97]=x;
       }
       int max=0;
       for(int i:freq){
           max=Math.max(i,max);
       }
       return max;
    }
}