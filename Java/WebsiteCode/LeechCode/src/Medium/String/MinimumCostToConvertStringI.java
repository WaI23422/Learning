package Medium.String;

import java.util.stream.Stream;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/minimum-cost-to-convert-string-i/">2976. Minimum Cost to Convert String I</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You are given two <strong>0-indexed</strong> strings <code>source</code> and <code>target</code>, both of length <code>n</code> and consisting of <strong>lowercase</strong> English letters. You are also given two <strong>0-indexed</strong> character arrays <code>original</code> and <code>changed</code>, and an integer array <code>cost</code>, where <code>cost[i]</code> represents the cost of changing the character <code>original[i]</code> to the character <code>changed[i]</code>.</p>
 * 
 * <p>You start with the string <code>source</code>. In one operation, you can pick a character <code>x</code> from the string and change it to the character <code>y</code> at a cost of <code>z</code> <strong>if</strong> there exists <strong>any</strong> index <code>j</code> such that <code>cost[j] == z</code>, <code>original[j] == x</code>, and <code>changed[j] == y</code>.</p>
 * 
 * <p>Return <em>the <strong>minimum</strong> cost to convert the string </em><code>source</code><em> to the string </em><code>target</code><em> using <strong>any</strong> number of operations. If it is impossible to convert</em> <code>source</code> <em>to</em> <code>target</code>, <em>return</em> <code>-1</code>.</p>
 * 
 * <p><strong>Note</strong> that there may exist indices <code>i</code>, <code>j</code> such that <code>original[j] == original[i]</code> and <code>changed[j] == changed[i]</code>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> source = "abcd", target = "acbe", original = ["a","b","c","c","e","d"], changed = ["b","c","b","e","b","e"], cost = [2,5,5,1,2,20]
 * <strong>Output:</strong> 28
 * <strong>Explanation:</strong> To convert the string "abcd" to string "acbe":
 * - Change value at index 1 from 'b' to 'c' at a cost of 5.
 * - Change value at index 2 from 'c' to 'e' at a cost of 1.
 * - Change value at index 2 from 'e' to 'b' at a cost of 2.
 * - Change value at index 3 from 'd' to 'e' at a cost of 20.
 * The total cost incurred is 5 + 1 + 2 + 20 = 28.
 * It can be shown that this is the minimum possible cost.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> source = "aaaa", target = "bbbb", original = ["a","c"], changed = ["c","b"], cost = [1,2]
 * <strong>Output:</strong> 12
 * <strong>Explanation:</strong> To change the character 'a' to 'b' change the character 'a' to 'c' at a cost of 1, followed by changing the character 'c' to 'b' at a cost of 2, for a total cost of 1 + 2 = 3. To change all occurrences of 'a' to 'b', a total cost of 3 * 4 = 12 is incurred.
 * </pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <pre><strong>Input:</strong> source = "abcd", target = "abce", original = ["a"], changed = ["e"], cost = [10000]
 * <strong>Output:</strong> -1
 * <strong>Explanation:</strong> It is impossible to convert source to target because the value at index 3 cannot be changed from 'd' to 'e'.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= source.length == target.length &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>source</code>, <code>target</code> consist of lowercase English letters.</li>
 * 	<li><code>1 &lt;= cost.length == original.length == changed.length &lt;= 2000</code></li>
 * 	<li><code>original[i]</code>, <code>changed[i]</code> are lowercase English letters.</li>
 * 	<li><code>1 &lt;= cost[i] &lt;= 10<sup>6</sup></code></li>
 * 	<li><code>original[i] != changed[i]</code></li>
 * </ul>
 * </div>
 */
public class MinimumCostToConvertStringI {
    public static void main(String[] args) {
        Object[][][] tests= {
            {
                {"abcd"},
                {"acbe"},
                {'a','b','c','c','e','d'},
                {'b','c','b','e','b','e'},
                {2,5,5,1,2,20}
            }
        };

        for (Object[][] test : tests) {
            String source = (String) test[0][0],
                   target = (String) test[1][0];
            char[] original = Stream.of(test[2])
                                    .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                                    .toString()
                                    .toCharArray(),
                   changed = Stream.of(test[3])
                                   .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                                   .toString()
                                   .toCharArray();
            int[] cost = Stream.of(test[4])
                               .mapToInt(t -> (int) t)
                               .toArray();

            System.out.println(new MinimumCostToConvertStringI_Solution().minimumCost(source, target, original, changed, cost));
        }
    }
}

// 22ms 46.06MB
class MinimumCostToConvertStringI_Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int len = original.length;
        long minCost = 0,
             charChangedCostMin[][] = new long[26][26];

        for(int i = 0; i < 26; i++) {
            for(int j = 0; j < 26; j++) {
                if(i != j) {
                    charChangedCostMin[i][j]=Integer.MAX_VALUE;
                }
            }
        }

        for (int i = 0; i < len; i++) {
            int charPos = original[i] - 'a',
                changePos = changed[i] - 'a';
            
                charChangedCostMin[charPos][changePos] = Math.min(charChangedCostMin[charPos][changePos], cost[i]);
        }

        for(int k = 0; k < 26 ; k++) {
            for(int i = 0; i < 26 ; i++) {
                for(int j = 0 ; j < 26 ; j++) {
                    charChangedCostMin[i][j] = Math.min(charChangedCostMin[i][j], charChangedCostMin[i][k]+charChangedCostMin[k][j]);
                }
            }
        }

        len = source.length();
        char[] sourceChars = source.toCharArray(),
               targetChars = target.toCharArray();
        for (int i = 0; i < len; i++) {
            int sourcePos = sourceChars[i]-'a',
                targetPos = targetChars[i]-'a';
            long costChange = charChangedCostMin[sourcePos][targetPos];
            if (costChange == Integer.MAX_VALUE) {
                return -1;
            } else {
                minCost += costChange;
            }
        }


        return minCost;
    }
}