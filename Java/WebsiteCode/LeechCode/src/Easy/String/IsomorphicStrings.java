package Easy.String;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/isomorphic-strings/">205.Isomorphic Strings</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given two strings <code>s</code> and <code>t</code>, <em>determine if they are isomorphic</em>.</p>

<p>Two strings <code>s</code> and <code>t</code> are isomorphic if the characters in <code>s</code> can be replaced to get <code>t</code>.</p>

<p>All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> s = "egg", t = "add"
<strong>Output:</strong> true
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> s = "foo", t = "bar"
<strong>Output:</strong> false
</pre><p><strong class="example">Example 3:</strong></p>
<pre><strong>Input:</strong> s = "paper", t = "title"
<strong>Output:</strong> true
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 5 * 10<sup>4</sup></code></li>
	<li><code>t.length == s.length</code></li>
	<li><code>s</code> and <code>t</code> consist of any valid ascii character.</li>
</ul>
</div>
 */
public class IsomorphicStrings {
    public static void main(String[] args) {
        String[][] tests = {
            {"egg",  "add"},
            {"foo",  "bar"},
            {"paper", "title"},
            {"badc","baba"},
            {"bab","cad"}
        };

        for (String[] test : tests) {
            String s = test[0],
                   t = test[1];

            System.out.println(new IsomorphicStrings_Solution().isIsomorphic(s, t));
        }
    }
}

// 8 ms 42.7 MB
class IsomorphicStrings_Solution {
    public boolean isIsomorphic(String s, String t) {

        int map1[]=new int[200];
        int map2[]=new int[200];

        if(s.length()!=t.length())
            return false;

        for(int i=0;i<s.length();i++){
            if(map1[s.charAt(i)]!=map2[t.charAt(i)])
                return false;

            map1[s.charAt(i)]=i+1;
            map2[t.charAt(i)]=i+1;
        }
        return true;
    }
}

// Wrong: Just for Alphabet Characters.
class IsomorphicStrings_Solution2 {
    public boolean isIsomorphic(String s, String t) {
        char[] toChar = new char[27], 
               sChars = s.toCharArray(),
               tChars= t.toCharArray();
        boolean[] charTo = new boolean[26];
        
        for (int i = 0; i < sChars.length; i++) {
            final char tChar = tChars[i],
                       sChar = sChars[i];
            final int poss = sChar-'`',
                      post = tChar-'a';
            
            if (toChar[poss] == 0) {
                if (charTo[post] && toChar[poss] != tChar) {return false;}

                toChar[poss] = tChar;
                charTo[post] = true;
            } else {
                if (toChar[poss] != tChar) {
                    return false;
                }
            }
        }

        return true;
    }
}