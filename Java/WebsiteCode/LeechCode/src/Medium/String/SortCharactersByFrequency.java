package Medium.String;

import java.util.Arrays;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/sort-characters-by-frequency/">451.Sort Characters By Frequency</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given a string <code>s</code>, sort it in <strong>decreasing order</strong> based on the <strong>frequency</strong> of the characters. The <strong>frequency</strong> of a character is the number of times it appears in the string.</p>

<p>Return <em>the sorted string</em>. If there are multiple answers, return <em>any of them</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> s = "tree"
<strong>Output:</strong> "eert"
<strong>Explanation:</strong> 'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> s = "cccaaa"
<strong>Output:</strong> "aaaccc"
<strong>Explanation:</strong> Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
Note that "cacaca" is incorrect, as the same characters must be together.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> s = "Aabb"
<strong>Output:</strong> "bbAa"
<strong>Explanation:</strong> "bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 5 * 10<sup>5</sup></code></li>
	<li><code>s</code> consists of uppercase and lowercase English letters and digits.</li>
</ul>
</div>
 */
public class SortCharactersByFrequency {
    public static void main(String[] args) {
        String[] tests = {
            "tree", 
            "cccaaa",
            "Aabb",
            "caCCccbcddd",
            "2a554442f544asfasssffffasss"
        };

        for (String s : tests) {
            System.out.println(new SortCharactersByFrequency_Solution().frequencySort(s));
        }
    }
}

// 208 ms 46.8 MB
class SortCharactersByFrequency_Solution {
    public String frequencySort(String s) {
        if (s.length() == 1) {return s;}

        String[] charsArray = new String[123]; Arrays.fill(charsArray, "");
        StringBuilder ans = new StringBuilder();

        for (char c : s.toCharArray()) {
            charsArray[c-0]+= c;
        }

        Arrays.sort(charsArray, (a,b) -> Integer.compare(a.length(), b.length())); 
        // Or:
        // Arrays.sort(charsArray, Comparator.comparingInt(String::length));
        // Or:
        // Arrays.sort(W, new java.util.Comparator<String>() {
        //     @Override
        //     public int compare(String s1, String s2) {
        //         return s1.length() - s2.length();// comparision
        //     }
        // })

        for (int i = charsArray.length-1; i >= 0; i--) {
            if (charsArray[i] == "") {
                break;
            } else {
                ans.append(charsArray[i]);
            }
        }

        System.out.println(Arrays.toString(charsArray));

        return ans.toString();
    }
}