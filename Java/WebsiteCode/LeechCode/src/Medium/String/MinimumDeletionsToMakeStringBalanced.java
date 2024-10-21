package Medium.String;

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

// Time Limit Exceeded 
// -> 47ms 46.10
class MinimumDeletionsToMakeStringBalanced_Solution {
    char[] sChars;
    //Add:
    int[] left,
          right;
    // 47ms 46.10
    public int minimumDeletions(String s) {
        sChars = s.toCharArray();

        int len = s.length(),
            minDelete = Integer.MAX_VALUE;
            // Add:
            left = new int[len];
            right = new int[len];
            // 47ms 46.10
        for (int i = 1; i < len; i++) {
            if (sChars[i] == 'a'){right[0]++;}
        }

        for (int i = 0; i < len; i++) {
            int pivot = i;
            minDelete = Math.min(minDelete, delete(pivot));
        }

        return minDelete;
    }

    private int delete (int pivot) {
        if (pivot == 0) {return left[pivot] + right[pivot];}
        int leftDelete = left[pivot-1] + (sChars[pivot-1] == 'b' ? 1 : 0),
            rightDelete = right[pivot-1] - (sChars[pivot] == 'a' ? 1 : 0);

        left[pivot] = leftDelete; right[pivot] = rightDelete;

        return leftDelete+rightDelete;
        // return deleteLeft(pivot) + deleteRight(pivot);
    }

    // private int deleteLeft(int pivot){
    //     int del = 0;
    //     for (int i = 0; i < pivot; i++) {
    //         if (sChars[i] == 'b'){del++;}
    //     }

    //     return del;
    // }

    // private int deleteRight(int pivot) {
    //     int len = sChars.length,
    //         del = 0;
    //     for (int i = pivot+1; i < len; i++) {
    //         if (sChars[i] == 'a'){del++;}
    //     }

    //     return del;
    // }
}