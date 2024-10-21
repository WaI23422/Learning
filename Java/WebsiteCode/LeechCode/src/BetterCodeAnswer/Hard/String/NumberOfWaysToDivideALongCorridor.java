package BetterCodeAnswer.Hard.String;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/number-of-ways-to-divide-a-long-corridor/">2147.Number of Ways to Divide a Long Corridor</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>Along a long library corridor, there is a line of seats and decorative plants. You are given a <strong>0-indexed</strong> string <code>corridor</code> of length <code>n</code> consisting of letters <code>'S'</code> and <code>'P'</code> where each <code>'S'</code> represents a seat and each <code>'P'</code> represents a plant.</p>

<p>One room divider has <strong>already</strong> been installed to the left of index <code>0</code>, and <strong>another</strong> to the right of index <code>n - 1</code>. Additional room dividers can be installed. For each position between indices <code>i - 1</code> and <code>i</code> (<code>1 &lt;= i &lt;= n - 1</code>), at most one divider can be installed.</p>

<p>Divide the corridor into non-overlapping sections, where each section has <strong>exactly two seats</strong> with any number of plants. There may be multiple ways to perform the division. Two ways are <strong>different</strong> if there is a position with a room divider installed in the first way but not in the second way.</p>

<p>Return <em>the number of ways to divide the corridor</em>. Since the answer may be very large, return it <strong>modulo</strong> <code>10<sup>9</sup> + 7</code>. If there is no way, return <code>0</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/12/04/1.png" style="width: 410px; height: 199px;">
<pre><strong>Input:</strong> corridor = "SSPPSPS"
<strong>Output:</strong> 3
<strong>Explanation:</strong> There are 3 different ways to divide the corridor.
The black bars in the above image indicate the two room dividers already installed.
Note that in each of the ways, <strong>each</strong> section has exactly <strong>two</strong> seats.
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/12/04/2.png" style="width: 357px; height: 68px;">
<pre><strong>Input:</strong> corridor = "PPSPSP"
<strong>Output:</strong> 1
<strong>Explanation:</strong> There is only 1 way to divide the corridor, by not installing any additional dividers.
Installing any would create some section that does not have exactly two seats.
</pre>

<p><strong class="example">Example 3:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/12/12/3.png" style="width: 115px; height: 68px;">
<pre><strong>Input:</strong> corridor = "S"
<strong>Output:</strong> 0
<strong>Explanation:</strong> There is no way to divide the corridor because there will always be a section that does not have exactly two seats.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == corridor.length</code></li>
	<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>corridor[i]</code> is either <code>'S'</code> or <code>'P'</code>.</li>
</ul>
</div></div>
 */
public class NumberOfWaysToDivideALongCorridor {
    public static void main(String[] args) {
        String[] tests = {
            "SSPPSPS",
            "PPSPSP",
            "S"
        };

        for (String corridor : tests) {
            System.out.println(new NumberOfWaysToDivideALongCorridor_Solution().numberOfWays(corridor));
        }
    }    
}

/**
 * <h1 id="intuition">Intuition</h1>
 * <p>To divide the corridor into non-overlapping sections with exactly two seats and any number of plants in between, we need to identify the positions where dividers can be installed. The problem constrains the installation of dividers such that each position between indices i-1 and i (1 &lt;= i &lt;= n - 1) can have at most one divider.</p>
 * <h1 id="approach">Approach</h1>
 * <ol>
<li>Initialize variables to keep track of chairs, result, and iterate through the corridor.</li>
<li>When a seat ('S') is encountered, count it, skip any plants ('P') until the next seat is found, and count that seat as well.</li>
<li>After identifying adjacent pairs of seats, count the divisions between them and consider each plant as an additional division.</li>
<li>If there are extra divisions (more than one) and more characters in the corridor, update the result accordingly.</li>
<li>Repeat the process until the end of the corridor is reached.</li>
<li>Check if there are chairs and an even number of chairs, then return the final result; otherwise, return 0.</li>
</ol>
<h1 id="complexity">Complexity</h1>
<ul>
<li>The time complexity is O(n), where n is the length of the corridor, as we iterate through the corridor once.</li>
<li>The space complexity is O(1), as we use a constant amount of space for variables.</li>
</ul>
 */
class NumberOfWaysToDivideALongCorridor_Solution {
    // 16 ms 44.6 MB
    public int numberOfWays(String corridor) {

        char[] array = corridor.toCharArray();
        int chairs = 0;
        long result = 1;

        for (int i = 0; i < array.length; i++) {

            
            if (array[i] == 'S') {
                chairs++;

                
                while (++i < array.length && array[i] != 'S');
                if (i < array.length && array[i] == 'S') {
                    chairs++;
                }


                
                int divisions = 1;
                while (++i < array.length && array[i] != 'S') {
                    divisions++;
                }

                           
                if (divisions > 1 && i < array.length) {
                    result = (result * divisions) % 1000000007;
                }
                i--;
            }
        }

        return (chairs != 0 && chairs % 2 == 0) ? (int) result : 0;
    }
}