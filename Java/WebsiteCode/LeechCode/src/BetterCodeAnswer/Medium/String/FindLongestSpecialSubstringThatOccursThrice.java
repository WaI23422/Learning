package BetterCodeAnswer.Medium.String;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/find-longest-special-substring-that-occurs-thrice-i/">2981. Find Longest Special Substring That Occurs Thrice I</a>
 * 
 * <div><div class="elfjS" data-track-load="description_content"><p>You are given a string <code>s</code> that consists of lowercase English letters.</p>
 * 
 * <p>A string is called <strong>special</strong> if it is made up of only a single character. For example, the string <code>"abc"</code> is not special, whereas the strings <code>"ddd"</code>, <code>"zz"</code>, and <code>"f"</code> are special.</p>
 * 
 * <p>Return <em>the length of the <strong>longest special substring</strong> of </em><code>s</code> <em>which occurs <strong>at least thrice</strong></em>, <em>or </em><code>-1</code><em> if no special substring occurs at least thrice</em>.</p>
 * 
 * <p>A <strong>substring</strong> is a contiguous <strong>non-empty</strong> sequence of characters within a string.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> s = "aaaa"
 * <strong>Output:</strong> 2
 * <strong>Explanation:</strong> The longest special substring which occurs thrice is "aa": substrings "<u><strong>aa</strong></u>aa", "a<u><strong>aa</strong></u>a", and "aa<u><strong>aa</strong></u>".
 * It can be shown that the maximum length achievable is 2.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> s = "abcdef"
 * <strong>Output:</strong> -1
 * <strong>Explanation:</strong> There exists no special substring which occurs at least thrice. Hence return -1.
 * </pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <pre><strong>Input:</strong> s = "abcaba"
 * <strong>Output:</strong> 1
 * <strong>Explanation:</strong> The longest special substring which occurs thrice is "a": substrings "<u><strong>a</strong></u>bcaba", "abc<u><strong>a</strong></u>ba", and "abcab<u><strong>a</strong></u>".
 * It can be shown that the maximum length achievable is 1.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>3 &lt;= s.length &lt;= 50</code></li>
 * 	<li><code>s</code> consists of only lowercase English letters.</li>
 * </ul>
 * </div></div>
 */
public class FindLongestSpecialSubstringThatOccursThrice {
    public static void main(String[] args) {
        
    }
}

// 1ms 42.50MB
class Solution {
    public int maximumLength(String s) {
        int[] f1=new int[26];
        int[] f2=new int[26];
        int curr=1;
        int ans=-1;
        char[] a=s.toCharArray();
        f2[(int)(a[0]-'a')]=1;
        f1[(int)(a[0]-'a')]=1;
        int n=s.length();
        for(int i=1;i<n;i++){
            if(a[i]==a[i-1]){
                curr++;
            }else{
                curr=1;
            }
            int g=(int)(a[i]-'a');
            if(curr>f1[g]){
                f1[g]=curr;
                ans=Math.max(ans,curr-2);
                if(f2[g]>=2)ans=Math.max(curr-1,ans);
                f2[g]=1;
            }
            else if(curr==f1[g]-1){
                ans=Math.max(curr,ans);
                ans=Math.max(ans,curr-2);
            }else if(curr==f1[g]){
                f2[g]++;
                if(f2[g]>=3)ans=Math.max(curr,ans);
            }
        }
        return ans<=0?-1:ans;
    }
}