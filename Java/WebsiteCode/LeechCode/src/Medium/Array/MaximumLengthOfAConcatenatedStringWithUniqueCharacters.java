package Medium.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <div data-cy="question-title" class="css-v3d350">1239.Maximum Length of a Concatenated String with Unique Characters</div>
 * 
 * <div class="content__u3I1 question-content__JfgR"><div><p>You are given an array of strings <code>arr</code>. A string <code>s</code> is formed by the <strong>concatenation</strong> of a <strong>subsequence</strong> of <code>arr</code> that has <strong>unique characters</strong>.</p>

<p>Return <em>the <strong>maximum</strong> possible length</em> of <code>s</code>.</p>

<p>A <strong>subsequence</strong> is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> arr = ["un","iq","ue"]
<strong>Output:</strong> 4
<strong>Explanation:</strong> All the valid concatenations are:
- ""
- "un"
- "iq"
- "ue"
- "uniq" ("un" + "iq")
- "ique" ("iq" + "ue")
Maximum length is 4.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> arr = ["cha","r","act","ers"]
<strong>Output:</strong> 6
<strong>Explanation:</strong> Possible longest valid concatenations are "chaers" ("cha" + "ers") and "acters" ("act" + "ers").
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> arr = ["abcdefghijklmnopqrstuvwxyz"]
<strong>Output:</strong> 26
<strong>Explanation:</strong> The only string in arr has all 26 characters.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= arr.length &lt;= 16</code></li>
	<li><code>1 &lt;= arr[i].length &lt;= 26</code></li>
	<li><code>arr[i]</code> contains only lowercase English letters.</li>
</ul>
</div></div>
 */
public class MaximumLengthOfAConcatenatedStringWithUniqueCharacters {
    public static void main(String[] args) {
        String[][] tests = {
            {"un","iq","ue"},
            {"cha","r","act","ers"},
            {"abcdefghijklmnopqrstuvwxyz"},
            {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p"}
        };

        for (String[] strings : tests) {
            List<String> arr = new ArrayList<>();

            arr.addAll(Arrays.asList(strings));

            System.out.println(new MaximumLengthOfAConcatenatedStringWithUniqueCharacters_Solution().maxLength(arr));
        }
    }
}

// 9 ms 45.4 MB
class MaximumLengthOfAConcatenatedStringWithUniqueCharacters_Solution {
    public static boolean hasduplicate(String s1,String s2){
        int[] arr = new int[26];
        for(char ch:s1.toCharArray()){
            if(arr[ch-'a']>0){
                return true;
            }
            arr[ch-'a']++;
        }
        for(char ch:s2.toCharArray()){
            if(arr[ch-'a']>0){
                return true;
            }
        }
        return false;
    }

    public  int solve(int idx,List<String> arr,String temp,int n){
        if(idx>=n) return temp.length();

        int include =0 ;
        int exclude =0;
        if(hasduplicate(arr.get(idx),temp)){
            exclude = solve(idx+1,arr,temp,n);
        }
        else{
            exclude = solve(idx+1,arr,temp,n);
            include = solve(idx+1,arr,temp+arr.get(idx),n);
        }
        return  Math.max(exclude,include);
    }
    
    public int maxLength(List<String> arr) {
        String temp = "";
        int n = arr.size();

        return solve(0,arr,temp,n);
    }
}