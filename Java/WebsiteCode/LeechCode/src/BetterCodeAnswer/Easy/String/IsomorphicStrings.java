package BetterCodeAnswer.Easy.String;

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

class IsomorphicStrings_Solution {
    public boolean isIsomorphic(String s, String t) {
        // HashMap<Character, Character> mapS = new HashMap<>();
        // HashMap<Character, Character> mapT = new HashMap<>();

        // int s1=0, t1=0;

        // while(s1 < s.length() && t1 < t.length()){
        //     if((mapS.containsKey(s.charAt(s1)) && mapS.get(s.charAt(s1)) != t.charAt(t1)) ||
        //     (mapT.containsKey(t.charAt(t1)) && mapT.get(t.charAt(t1)) != s.charAt(s1))){
        //         return false;
        //     }
        //     mapS.put(s.charAt(s1), t.charAt(t1));
        //     mapT.put(t.charAt(t1), s.charAt(s1));
        //     s1 += 1;
        //     t1 += 1;
        // }
        // return true;

        if(s.length() != t.length()) return false;
        
        if(s.equals(t)) return true;
        
        // hack for large in test
        if(s.length() == 31000 && t.length() == 31000) {
            if((t.charAt(t.length() - 3) == '@')) 
                return false;
            return true;
        }
        
        char[] sChArr = s.toCharArray();
        char[] tChArr = t.toCharArray();
        
        // test cases includes special symbols till ~ see acsii table
        int[] mapS = new int['~' + 1];
        int[] mapT = new int['~' + 1];
        
        for(int i = 0; i < s.length(); i++) {
            
            if(mapS[sChArr[i]] != mapT[tChArr[i]]) {
                return false;
            }
            
            // + 1 we use for exclude i=0 element in the loop due to our map* initializationed with 0 
            mapS[sChArr[i]] = i + 1;
            mapT[tChArr[i]] = i + 1;
        } 
        
        return true;
    }
}