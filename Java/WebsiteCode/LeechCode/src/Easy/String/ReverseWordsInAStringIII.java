package Easy.String;

import java.util.ArrayList;

/**
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>Given a string <code>s</code>, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> s = "Let's take LeetCode contest"
<strong>Output:</strong> "s'teL ekat edoCteeL tsetnoc"
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> s = "God Ding"
<strong>Output:</strong> "doG gniD"
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 5 * 10<sup>4</sup></code></li>
	<li><code>s</code> contains printable <strong>ASCII</strong> characters.</li>
	<li><code>s</code> does not contain any leading or trailing spaces.</li>
	<li>There is <strong>at least one</strong> word in <code>s</code>.</li>
	<li>All the words in <code>s</code> are separated by a single space.</li>
</ul>
</div></div>
 */
public class ReverseWordsInAStringIII {
    public static void main(String[] args) {

        ReverseWordsInAStringIII_Solution reverseWordsInAStringIII_Solution = new ReverseWordsInAStringIII_Solution();
        
        System.out.println(reverseWordsInAStringIII_Solution.reverseWords("Let's take LeetCode contest"));
        
        
    }    
}

class ReverseWordsInAStringIII_Solution{
    // 317 ms
    // 45
    public String reverseWords(String s) {
        String res = "";
        ArrayList<Integer> spaceIndexArray = new ArrayList<>();
        int spaceIndex = 0;

        if (s.contains(" ")){
            while (spaceIndex >= 0) {
                spaceIndex = s.indexOf(" ", spaceIndex + 1); 
                if (spaceIndex>=0) {
                    spaceIndexArray.add(spaceIndex);   
                }
            }
            spaceIndexArray.add(s.length());

            int sizeIncrease = 0;
            int trackChar = 1;
            int trackSpace = spaceIndexArray.get(0);
        
            for (int i = 0; i < s.length(); i++) {
                if (i < trackSpace) {
                    res += s.charAt(trackSpace - trackChar);
                    trackChar++;  
                } else {
                    res += " ";
                    trackChar = 1;
                    sizeIncrease += 1;
                    trackSpace = spaceIndexArray.get(sizeIncrease);
                }
            }
            
        } else {
            for (int i = s.length()-1; i >=0 ; i--) {
                res += s.charAt(i);
            }
        }   

        return res;
        
    }
}