package Medium.String;

import java.util.PriorityQueue;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/longest-happy-string/">1405. Longest Happy String</a>
 * 
 * <div><div class="elfjS" data-track-load="description_content"><p>A string <code>s</code> is called <strong>happy</strong> if it satisfies the following conditions:</p>
 * 
 * <ul>
 * 	<li><code>s</code> only contains the letters <code>'a'</code>, <code>'b'</code>, and <code>'c'</code>.</li>
 * 	<li><code>s</code> does not contain any of <code>"aaa"</code>, <code>"bbb"</code>, or <code>"ccc"</code> as a substring.</li>
 * 	<li><code>s</code> contains <strong>at most</strong> <code>a</code> occurrences of the letter <code>'a'</code>.</li>
 * 	<li><code>s</code> contains <strong>at most</strong> <code>b</code> occurrences of the letter <code>'b'</code>.</li>
 * 	<li><code>s</code> contains <strong>at most</strong> <code>c</code> occurrences of the letter <code>'c'</code>.</li>
 * </ul>
 * 
 * <p>Given three integers <code>a</code>, <code>b</code>, and <code>c</code>, return <em>the <strong>longest possible happy </strong>string</em>. If there are multiple longest happy strings, return <em>any of them</em>. If there is no such string, return <em>the empty string </em><code>""</code>.</p>
 * 
 * <p>A <strong>substring</strong> is a contiguous sequence of characters within a string.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> a = 1, b = 1, c = 7
 * <strong>Output:</strong> "ccaccbcc"
 * <strong>Explanation:</strong> "ccbccacc" would also be a correct answer.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> a = 7, b = 1, c = 0
 * <strong>Output:</strong> "aabaa"
 * <strong>Explanation:</strong> It is the only correct answer in this case.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>0 &lt;= a, b, c &lt;= 100</code></li>
 * 	<li><code>a + b + c &gt; 0</code></li>
 * </ul>
 * </div></div>
 */
public class LongestHappyString {
    public static void main(String[] args) {
        int[][] tests = {
            {1,1,7},
            {7,7,7},
            {2,0,0},
            {0,0,0}
        };

        for (int[] test : tests) {
            int a = test[0],
                b = test[1],
                c = test[2];

            System.out.println(new LongestHappyString_Solution().longestDiverseString(a, b, c));
        }
    }
}

class LongestHappyString_Solution {

    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) ->
            (y.count - x.count)
        );
        // Add the counts of a, b and c in priority queue.
        if (a > 0) {
            pq.add(new Pair(a, 'a'));
        }

        if (b > 0) {
            pq.add(new Pair(b, 'b'));
        }

        if (c > 0) {
            pq.add(new Pair(c, 'c'));
        }

        StringBuilder ans = new StringBuilder();
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int count = p.count;
            char character = p.character;
            // If three consecutive characters exists, pick the second most
            // frequent character.
            if (
                ans.length() >= 2 &&
                ans.charAt(ans.length() - 1) == p.character &&
                ans.charAt(ans.length() - 2) == p.character
            ) {
                if (pq.isEmpty()) break;

                Pair temp = pq.poll();
                ans.append(temp.character);
                if (temp.count - 1 > 0) {
                    pq.add(new Pair(temp.count - 1, temp.character));
                }
            } else {
                count--;
                ans.append(character);
            }

            // If count is greater than zero, add it to priority queue.
            if (count > 0) {
                pq.add(new Pair(count, character));
            }
        }
        return ans.toString();
    }

    class Pair {

        public int count;
        public char character;
    
        public Pair(int count, char character) {
            this.count = count;
            this.character = character;
        }
    
    }
}