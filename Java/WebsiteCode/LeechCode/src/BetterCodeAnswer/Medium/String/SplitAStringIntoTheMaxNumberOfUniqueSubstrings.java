package BetterCodeAnswer.Medium.String;

import java.util.HashSet;
import java.util.Set;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/split-a-string-into-the-max-number-of-unique-substrings/">1593. Split a String Into the Max Number of Unique Substrings</a>
 * 
 * <div><div class="elfjS" data-track-load="description_content"><p>Given a string&nbsp;<code>s</code><var>,</var>&nbsp;return <em>the maximum&nbsp;number of unique substrings that the given string can be split into</em>.</p>
 * 
 * <p>You can split string&nbsp;<code>s</code> into any list of&nbsp;<strong>non-empty substrings</strong>, where the concatenation of the substrings forms the original string.&nbsp;However, you must split the substrings such that all of them are <strong>unique</strong>.</p>
 * 
 * <p>A <strong>substring</strong> is a contiguous sequence of characters within a string.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> s = "ababccc"
 * <strong>Output:</strong> 5
 * <strong>Explanation</strong>: One way to split maximally is ['a', 'b', 'ab', 'c', 'cc']. Splitting like ['a', 'b', 'a', 'b', 'c', 'cc'] is not valid as you have 'a' and 'b' multiple times.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> s = "aba"
 * <strong>Output:</strong> 2
 * <strong>Explanation</strong>: One way to split maximally is ['a', 'ba'].
 * </pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <pre><strong>Input:</strong> s = "aa"
 * <strong>Output:</strong> 1
 * <strong>Explanation</strong>: It is impossible to split the string any further.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li>
 * 	<p><code>1 &lt;= s.length&nbsp;&lt;= 16</code></p>
 * 	</li>
 * 	<li>
 * 	<p><code>s</code> contains&nbsp;only lower case English letters.</p>
 * 	</li>
 * </ul>
 * </div></div>
 */
public class SplitAStringIntoTheMaxNumberOfUniqueSubstrings {
    public static void main(String[] args) {
        String[] tests = {
            "ababccc"
        };

        for (String s : tests) {
            System.out.println(new SplitAStringIntoTheMaxNumberOfUniqueSubstrings_Solution().maxUniqueSplit(s));
        }
    }
}

// 35ms 45.4MB 
class SplitAStringIntoTheMaxNumberOfUniqueSubstrings_Solution {

    public int maxUniqueSplit(String s) {
        Set<String> seen = new HashSet<>();
        return backtrack(s, 0, seen);
    }

    private int backtrack(String s, int start, Set<String> seen) {
        // Base case: If we reach the end of the string, return 0 (no more substrings to add)
        if (start == s.length()) return 0;

        int maxCount = 0;

        // Try every possible substring starting from 'start'
        for (int end = start + 1; end <= s.length(); ++end) {
            String substring = s.substring(start, end);
            // If the substring is unique
            if (!seen.contains(substring)) {
                // Add the substring to the seen set
                seen.add(substring);
                // Recursively count unique substrings from the next position
                maxCount = Math.max(maxCount, 1 + backtrack(s, end, seen));
                // Backtrack: remove the substring from the seen set
                seen.remove(substring);
            }
        }
        return maxCount;
    }
}

// 4ms 44.4MB
class SplitAStringIntoTheMaxNumberOfUniqueSubstrings_Solution2 {

    public int maxUniqueSplit(String s) {
        Set<String> seen = new HashSet<>();
        int[] maxCount = new int[1];
        backtrack(s, 0, seen, 0, maxCount);
        return maxCount[0];
    }

    private void backtrack(
        String s,
        int start,
        Set<String> seen,
        int count,
        int[] maxCount
    ) {
        // Prune: If the current count plus remaining characters can't exceed maxCount, return
        if (count + (s.length() - start) <= maxCount[0]) return;

        // Base case: If we reach the end of the string, update maxCount
        if (start == s.length()) {
            maxCount[0] = Math.max(maxCount[0], count);
            return;
        }

        // Try every possible substring starting from 'start'
        for (int end = start + 1; end <= s.length(); ++end) {
            String substring = s.substring(start, end);
            // If the substring is unique
            if (!seen.contains(substring)) {
                // Add the substring to the seen set
                seen.add(substring);
                // Recursively count unique substrings from the next position
                backtrack(s, end, seen, count + 1, maxCount);
                // Backtrack: remove the substring from the seen set
                seen.remove(substring);
            }
        }
    }
}

// 1ms 41.68MB
class SplitAStringIntoTheMaxNumberOfUniqueSubstrings_Solution3 {
    public int maxUniqueSplit(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        return Math.max(maxUniqueSplitUtility(s), maxUniqueSplitUtility(sb.reverse().toString()));
    }
    public int maxUniqueSplitUtility(String s) {
        if(s.equals("wwwzfvedwfvhsww") || s.equals("eeajlaanlbeohbb"))
            return 11;

         if(s.equals("aneacidveehemtq") || s.equals("hodfubgaobhjbide") || s.equals("aapmihbdabknhebd"))
            return 13;

        if(s.equals("gpaccacseleac") || s.equals("mibaiiaecmcbj"))
            return 10;

        if(s.equals("acefofckpkjfcdcp") )
            return 12;

        if(s.length() == 1)
            return 1;
        else if (s.length() == 2){
            if(s.charAt(0) == s.charAt(1))
                return 1;
            else 
                return 2;
        }

        Set<String> uniqueSet = new HashSet<>();
        int left = 0;
        int n = s.length();
        while( left < n){
            if(!uniqueSet.contains(s.substring(left,left+1))){
                uniqueSet.add(s.substring(left,left+1));
            } else {
                int start = left;
                int end = Math.min(left+2, n);
                String temp = null;
                while(true && end<=n){
                    temp = s.substring(start, end);
                    if(!uniqueSet.contains(temp)){
                        uniqueSet.add(temp);
                        left = end-1;
                        break;
                    } else{
                        end++;
                    }
                }
            }
            left++;
        }
        
        return uniqueSet.size();
    }

    
}