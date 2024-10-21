package BetterCodeAnswer.Easy.String;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/reverse-string-ii/">541. Reverse String II</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given a string <code>s</code> and an integer <code>k</code>, reverse the first <code>k</code> characters for every <code>2k</code> characters counting from the start of the string.</p>
 * 
 * <p>If there are fewer than <code>k</code> characters left, reverse all of them. If there are less than <code>2k</code> but greater than or equal to <code>k</code> characters, then reverse the first <code>k</code> characters and leave the other as original.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <pre><strong>Input:</strong> s = "abcdefg", k = 2
 * <strong>Output:</strong> "bacdfeg"
 * </pre><p><strong class="example">Example 2:</strong></p>
 * <pre><strong>Input:</strong> s = "abcd", k = 2
 * <strong>Output:</strong> "bacd"
 * </pre>
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= s.length &lt;= 10<sup>4</sup></code></li>
 * 	<li><code>s</code> consists of only lowercase English letters.</li>
 * 	<li><code>1 &lt;= k &lt;= 10<sup>4</sup></code></li>
 * </ul>
 * </div>
 */
public class ReverseStringII {
    public static void main(String[] args) {
        Object[][] tests = {
            {"abcdefg", 2}
        };

        for (Object[] test : tests) {
            String s = (String) test[0];
            int k = (int) test[1];

            System.out.println(new ReverseStringII_Solution().reverseStr(s, k));
        }
    }
}

// 0 ms 43.7 MB
class ReverseStringII_Solution {
    public String reverseStr(String s, int k) {
        char[] str=s.toCharArray();
        if(str.length<k){
            char[] ans=new char[str.length];
            for(int i=0;i<str.length;i++){
                ans[i]=str[str.length-i-1];
            }
            return new String(ans);
        }
        for(int i=0;i<s.length();i+=(2*k)){
            int a=i;
            int b=Math.min(i+k-1, s.length()-1);
            swap(str,a,b);
        }
        String ans=new String(str);
        return ans;
    }

    public void swap(char[] str, int a, int b){
        while(a<b){
            char temp=str[a];
            str[a]=str[b];
            str[b]=temp;
            a++;
            b--;
        }
    }
}

// 1ms 43.5MB
class ReverseStringII_Solution2 {
    public String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();
        for(int i = 0; i < s.length() - 1; i += (k * 2)) {
            int l = i, r = Math.min(i + k - 1, s.length() - 1);
            while(l < r) {
                char tmp = ch[l];
                ch[l++] = ch[r];
                ch[r--] = tmp;
            }
        }
        return new String(ch);
    }
}