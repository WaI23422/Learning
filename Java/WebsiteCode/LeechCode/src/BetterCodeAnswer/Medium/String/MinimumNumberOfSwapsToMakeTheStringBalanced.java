package BetterCodeAnswer.Medium.String;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/minimum-number-of-swaps-to-make-the-string-balanced/">1963. Minimum Number of Swaps to Make the String Balanced</a>
 * 
 * <div><div class="elfjS" data-track-load="description_content"><p>You are given a <strong>0-indexed</strong> string <code>s</code> of <strong>even</strong> length <code>n</code>. The string consists of <strong>exactly</strong> <code>n / 2</code> opening brackets <code>'['</code> and <code>n / 2</code> closing brackets <code>']'</code>.</p>
 * 
 * <p>A string is called <strong>balanced</strong> if and only if:</p>
 * 
 * <ul>
 * 	<li>It is the empty string, or</li>
 * 	<li>It can be written as <code>AB</code>, where both <code>A</code> and <code>B</code> are <strong>balanced</strong> strings, or</li>
 * 	<li>It can be written as <code>[C]</code>, where <code>C</code> is a <strong>balanced</strong> string.</li>
 * </ul>
 * 
 * <p>You may swap the brackets at <strong>any</strong> two indices <strong>any</strong> number of times.</p>
 * 
 * <p>Return <em>the <strong>minimum</strong> number of swaps to make </em><code>s</code> <em><strong>balanced</strong></em>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> s = "][]["
 * <strong>Output:</strong> 1
 * <strong>Explanation:</strong> You can make the string balanced by swapping index 0 with index 3.
 * The resulting string is "[[]]".
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> s = "]]][[["
 * <strong>Output:</strong> 2
 * <strong>Explanation:</strong> You can do the following to make the string balanced:
 * - Swap index 0 with index 4. s = "[]][][".
 * - Swap index 1 with index 5. s = "[[][]]".
 * The resulting string is "[[][]]".
 * </pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <pre><strong>Input:</strong> s = "[]"
 * <strong>Output:</strong> 0
 * <strong>Explanation:</strong> The string is already balanced.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>n == s.length</code></li>
 * 	<li><code>2 &lt;= n &lt;= 10<sup>6</sup></code></li>
 * 	<li><code>n</code> is even.</li>
 * 	<li><code>s[i]</code> is either <code>'[' </code>or <code>']'</code>.</li>
 * 	<li>The number of opening brackets <code>'['</code> equals <code>n / 2</code>, and the number of closing brackets <code>']'</code> equals <code>n / 2</code>.</li>
 * </ul>
 * </div></div>
 */
public class MinimumNumberOfSwapsToMakeTheStringBalanced {
    public static void main(String[] args) {
        String[] tests = {
            "]]]][[][[][[[]]][[]][[[[][]]][[]]]]]][]][[][][[]][][[]]]][[[[[[[",
            "][[]][][[][]",
            "]]][[[",
            "[[[]]]][][]][[]]][[[",
            "][][]["
        };

        for (String s : tests) {
            System.out.println(new MinimumNumberOfSwapsToMakeTheStringBalanced_Solution().minSwaps(s));
        }
    }
}

// 10ms 54.07MB
class MinimumNumberOfSwapsToMakeTheStringBalanced_Solution {
    public int minSwaps(String s) {
        int opening = 0;
        int unbalanced = 0;

        for (var c: s.getBytes()) {
            if (c == '[') {
                opening++;
            } else {
                if (opening > 0)
                    opening--;
                else
                    unbalanced++;    
            }
        }

        return unbalanced / 2 + unbalanced % 2;
    }
}