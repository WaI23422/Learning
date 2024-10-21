package BetterCodeAnswer.Medium.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

// 24 ms 44.7 MB
class MaximumLengthOfAConcatenatedStringWithUniqueCharacters_Solution3 {
    private int result = 0;
    public int maxLength(List<String> arr) {
            if (arr == null || arr.size() == 0)    return 0;

        dfs(arr, "", 0);
        return result;
    }

    private void dfs(List<String> arr, String path, int idx) {
        boolean isUniqueChar = isUniqueChars(path);

        if (isUniqueChar) {
            result = Math.max(path.length(), result);
        }

        if (idx == arr.size() || !isUniqueChar) {
            return;
        }

        for (int i = idx; i < arr.size(); i++) {
            dfs(arr, path + arr.get(i), i + 1);
        }

    }

    private boolean isUniqueChars(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
        if (set.contains(c)) {
            return false;
        }
            set.add(c);
        }
        return true;
    }
}

// 14 ms 43.2 MB
class MaximumLengthOfAConcatenatedStringWithUniqueCharacters_Solution2 {
    public int maxLength(List<String> arr) {
        List<Integer> dp = new ArrayList<>();
        dp.add(0);
        int res = 0;
        for (String s : arr) {
            int a = 0, dup = 0;
            for (char c : s.toCharArray()) {
                dup |= a & (1 << (c - 'a'));
                a |= 1 << (c - 'a');
            }
            if (dup > 0)    continue;
            for (int i = dp.size() - 1; i >= 0; i--) {
                if ((dp.get(i) & a) > 0) continue;
                dp.add(dp.get(i) | a);
                res = Math.max(res, Integer.bitCount(dp.get(i) | a));
            }
            
        }
        return res;
    }
}

// 1 ms 41 MB
class MaximumLengthOfAConcatenatedStringWithUniqueCharacters_Solution {
    public int solve(String strs[], int no, int a[], int index, int c) {
        if(index==c)
            return 0;
        int x=no & a[index];
        if(x==0)        
            return Math.max(strs[index].length()+solve(strs,no^a[index],a,index+1,c),solve(strs,no,a,index+1,c));
        else
            return solve(strs,no,a,index+1,c);
    }
    public int maxLength(List<String> arr) {
        int a[]=new int[arr.size()];int c=0;String strs[]=new String[a.length];
        for(String s:arr) {
            int x=0,fl=0;
            for(char ch:s.toCharArray()) 
            {
                int z=x|(1<<(ch-96));
                if(x==z)
                {
                    fl=1;break;                
                }
                x=z;
            }
            if(fl==0)
            {
                a[c]=x;
                strs[c++]=s;
            }
        }
        return solve(strs,0,a,0,c);
    }
}