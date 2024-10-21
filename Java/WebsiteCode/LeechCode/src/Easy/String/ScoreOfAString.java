package Easy.String;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/score-of-a-string/">3110. Score of a String</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You are given a string <code>s</code>. The <strong>score</strong> of a string is defined as the sum of the absolute difference between the <strong>ASCII</strong> values of adjacent characters.</p>
 * 
 * <p>Return the <strong>score</strong> of<em> </em><code>s</code>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <div class="example-block">
 * <p><strong>Input:</strong> <span class="example-io">s = "hello"</span></p>
 * 
 * <p><strong>Output:</strong> <span class="example-io">13</span></p>
 * 
 * <p><strong>Explanation:</strong></p>
 * 
 * <p>The <strong>ASCII</strong> values of the characters in <code>s</code> are: <code>'h' = 104</code>, <code>'e' = 101</code>, <code>'l' = 108</code>, <code>'o' = 111</code>. So, the score of <code>s</code> would be <code>|104 - 101| + |101 - 108| + |108 - 108| + |108 - 111| = 3 + 7 + 0 + 3 = 13</code>.</p>
 * </div>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <div class="example-block">
 * <p><strong>Input:</strong> <span class="example-io">s = "zaz"</span></p>
 * 
 * <p><strong>Output:</strong> <span class="example-io">50</span></p>
 * 
 * <p><strong>Explanation:</strong></p>
 * 
 * <p>The <strong>ASCII</strong> values of the characters in <code>s</code> are: <code>'z' = 122</code>, <code>'a' = 97</code>. So, the score of <code>s</code> would be <code>|122 - 97| + |97 - 122| = 25 + 25 = 50</code>.</p>
 * </div>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>2 &lt;= s.length &lt;= 100</code></li>
 * 	<li><code>s</code> consists only of lowercase English letters.</li>
 * </ul>
 * </div>
 */
public class ScoreOfAString {
    public static void main(String[] args) {
        String[] tests = {
            "hello"
        };

        for (String s : tests) {
            System.out.println(new ScoreOfAString_Solution().scoreOfString(s));
        }
    }
}

// 1 ms 41.6 MB
class ScoreOfAString_Solution {
    public int scoreOfString(String s) {
        int score = 0,
            len = s.length()-1;

        for (int i = 0; i < len; i++) {
            score += Math.abs(s.charAt(i)-s.charAt(i+1));
        }

        return score;
    }
}