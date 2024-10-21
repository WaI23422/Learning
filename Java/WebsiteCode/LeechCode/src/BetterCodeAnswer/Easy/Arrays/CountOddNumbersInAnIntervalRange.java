package BetterCodeAnswer.Easy.Arrays;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/count-odd-numbers-in-an-interval-range/">1523.Count Odd Numbers in an Interval Range</a>
 * 
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given two non-negative integers <code>low</code> and <code><font face="monospace">high</font></code>. Return the <em>count of odd numbers between </em><code>low</code><em> and </em><code><font face="monospace">high</font></code><em>&nbsp;(inclusive)</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> low = 3, high = 7
<strong>Output:</strong> 3
<b>Explanation: </b>The odd numbers between 3 and 7 are [3,5,7].</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> low = 8, high = 10
<strong>Output:</strong> 1
<b>Explanation: </b>The odd numbers between 8 and 10 are [9].</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= low &lt;= high&nbsp;&lt;= 10^9</code></li>
</ul></div>
 */
public class CountOddNumbersInAnIntervalRange {
    public static void main(String[] args) {
        int[][] tests = {
            {3,7},
            {8,10}
        };

        for (int[] test : tests) {
            int low = test[0],
                high = test[1];

            System.out.println( new CountOddNumbersInAnIntervalRange_Solution().countOdds(low, high));
        }
    }
}

// 0 ms 40.56 MB
class CountOddNumbersInAnIntervalRange_Solution {
    public int countOdds(int low, int high) {
        int N = (high - low)/2;
        if (high % 2 != 0 || low % 2 != 0) N++;
        return N;
    }
}