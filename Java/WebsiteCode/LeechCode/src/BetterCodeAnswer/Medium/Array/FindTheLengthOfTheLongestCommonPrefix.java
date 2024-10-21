package BetterCodeAnswer.Medium.Array;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/find-the-length-of-the-longest-common-prefix/">3043. Find the Length of the Longest Common Prefix</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You are given two arrays with <strong>positive</strong> integers <code>arr1</code> and <code>arr2</code>.</p>
 * 
 * <p>A <strong>prefix</strong> of a positive integer is an integer formed by one or more of its digits, starting from its <strong>leftmost</strong> digit. For example, <code>123</code> is a prefix of the integer <code>12345</code>, while <code>234</code> is <strong>not</strong>.</p>
 * 
 * <p>A <strong>common prefix</strong> of two integers <code>a</code> and <code>b</code> is an integer <code>c</code>, such that <code>c</code> is a prefix of both <code>a</code> and <code>b</code>. For example, <code>5655359</code> and <code>56554</code> have a common prefix <code>565</code> while <code>1223</code> and <code>43456</code> <strong>do not</strong> have a common prefix.</p>
 * 
 * <p>You need to find the length of the <strong>longest common prefix</strong> between all pairs of integers <code>(x, y)</code> such that <code>x</code> belongs to <code>arr1</code> and <code>y</code> belongs to <code>arr2</code>.</p>
 * 
 * <p>Return <em>the length of the <strong>longest</strong> common prefix among all pairs</em>.<em> If no common prefix exists among them</em>, <em>return</em> <code>0</code>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> arr1 = [1,10,100], arr2 = [1000]
 * <strong>Output:</strong> 3
 * <strong>Explanation:</strong> There are 3 pairs (arr1[i], arr2[j]):
 * - The longest common prefix of (1, 1000) is 1.
 * - The longest common prefix of (10, 1000) is 10.
 * - The longest common prefix of (100, 1000) is 100.
 * The longest common prefix is 100 with a length of 3.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> arr1 = [1,2,3], arr2 = [4,4,4]
 * <strong>Output:</strong> 0
 * <strong>Explanation:</strong> There exists no common prefix for any pair (arr1[i], arr2[j]), hence we return 0.
 * Note that common prefixes between elements of the same array do not count.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= arr1.length, arr2.length &lt;= 5 * 10<sup>4</sup></code></li>
 * 	<li><code>1 &lt;= arr1[i], arr2[i] &lt;= 10<sup>8</sup></code></li>
 * </ul>
 * </div>
 */
public class FindTheLengthOfTheLongestCommonPrefix {
    public static void main(String[] args) {
        int[][][] tests = {
            {
                {1,10,100},
                {1010,1000}
            }
        };

        for (int[][] test : tests) {
            int arr1[] = test[0],
                arr2[] = test[1];

            System.out.println(new FindTheLengthOfTheLongestCommonPrefix_Solution().longestCommonPrefix(arr1, arr2));
        }
    }
}

// 22ms 56.72MB
class FindTheLengthOfTheLongestCommonPrefix_Solution {
    private class Trie {
        Trie[] children = new Trie[10];
    }
    
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Trie root = new Trie();
        for (int n : arr1) {
            int multi = multi(n);
            Trie parent = root;
            while(multi > 0) {
                int d = (n/multi) % 10;
                if (parent.children[d] == null) parent.children[d] = new Trie();
                parent = parent.children[d];
                multi /= 10;
            }
        }

        int maxLen = 0;
        for (int n : arr2) {
            int multi = multi(n);
            int len = 0;
            Trie parent = root;
            while (multi > 0) {
                int d = (n/multi) % 10;
                parent = parent.children[d];
                if (parent == null) break;
                len++;
                maxLen = Math.max(maxLen, len);
                multi /= 10;
            }
        }
        return maxLen;
    }

    private int multi(int n) {
        int mult = 1;
        while (mult * 10 <= n) {
            mult = mult * 10;
        }
        return mult;
    }
}