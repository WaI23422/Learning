package BetterCodeAnswer.Medium.String;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/minimum-deletions-to-make-string-balanced/">1653. Minimum Deletions to Make String Balanced</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You are given a string <code>s</code> consisting only of characters <code>'a'</code> and <code>'b'</code>​​​​.</p>
 * 
 * <p>You can delete any number of characters in <code>s</code> to make <code>s</code> <strong>balanced</strong>. <code>s</code> is <strong>balanced</strong> if there is no pair of indices <code>(i,j)</code> such that <code>i &lt; j</code> and <code>s[i] = 'b'</code> and <code>s[j]= 'a'</code>.</p>
 * 
 * <p>Return <em>the <strong>minimum</strong> number of deletions needed to make </em><code>s</code><em> <strong>balanced</strong></em>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> s = "aababbab"
 * <strong>Output:</strong> 2
 * <strong>Explanation:</strong> You can either:
 * Delete the characters at 0-indexed positions 2 and 6 ("aa<u>b</u>abb<u>a</u>b" -&gt; "aaabbb"), or
 * Delete the characters at 0-indexed positions 3 and 6 ("aab<u>a</u>bb<u>a</u>b" -&gt; "aabbbb").
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> s = "bbaaaaabb"
 * <strong>Output:</strong> 2
 * <strong>Explanation:</strong> The only solution is to delete the first two characters.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= s.length &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>s[i]</code> is&nbsp;<code>'a'</code> or <code>'b'</code>​​.</li>
 * </ul>
 * </div>
 */
public class MinimumDeletionsToMakeStringBalanced {
    public static void main(String[] args) {
        String[] tests = {
            "a",
            "aaaaa",
            "bbbbbbbbbbbbbb",
            "aababbab",
            "bbaaaaabb",
        };

        for (String s : tests) {
            System.out.println(new MinimumDeletionsToMakeStringBalanced_Solution().minimumDeletions(s));
        }
    }
}

// 11ms 45.52MB
class MinimumDeletionsToMakeStringBalanced_Solution {
    public int minimumDeletions(String s) {
        char[] letters = s.toCharArray();
        int aCount = 0;
        int bCount = 0;
        int output = Integer.MAX_VALUE;
        for (int i = 0; i < letters.length; i++)
            aCount += ('b' - letters[i]);

        for (int i = 0; i < s.length(); i++)
        {
            output = Math.min(output, aCount + bCount);
            aCount -= ('b' - letters[i]);
            bCount += (letters[i] - 'a');
        }

        output = Math.min(output, aCount + bCount);
        return output;
    }
}

// 18ms 45.41MB
class MinimumDeletionsToMakeStringBalanced_Solution2 {
    public int minimumDeletions(String s) {
      int bCt = 0;
      int deleteCt = 0;
      for(char ch: s.toCharArray()){
          if(ch == 'b')
              bCt++;
          else if(bCt > 0){
              deleteCt++;
              bCt--;
          }
      }
      return deleteCt;
  }
}

// 23ms 45.15MB
class MinimumDeletionsToMakeStringBalanced_Solution3 {

    public int minimumDeletions(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        int bCount = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'b') {
                dp[i + 1] = dp[i];
                bCount++;
            } else {
                dp[i + 1] = Math.min(dp[i] + 1, bCount);
            }
        }

        return dp[n];
    }
}