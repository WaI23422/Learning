package Easy.Arrays;


/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/time-needed-to-buy-tickets/">2073. Time Needed to Buy Tickets</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>There are <code>n</code> people in a line queuing to buy tickets, where the <code>0<sup>th</sup></code> person is at the <strong>front</strong> of the line and the <code>(n - 1)<sup>th</sup></code> person is at the <strong>back</strong> of the line.</p>

<p>You are given a <strong>0-indexed</strong> integer array <code>tickets</code> of length <code>n</code> where the number of tickets that the <code>i<sup>th</sup></code> person would like to buy is <code>tickets[i]</code>.</p>

<p>Each person takes <strong>exactly 1 second</strong> to buy a ticket. A person can only buy <strong>1 ticket at a time</strong> and has to go back to <strong>the end</strong> of the line (which happens <strong>instantaneously</strong>) in order to buy more tickets. If a person does not have any tickets left to buy, the person will <strong>leave </strong>the line.</p>

<p>Return <em>the <strong>time taken</strong> for the person at position </em><code>k</code><em>&nbsp;</em><strong><em>(0-indexed)</em>&nbsp;</strong><em>to finish buying tickets</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> tickets = [2,3,2], k = 2
<strong>Output:</strong> 6
<strong>Explanation:</strong> 
- In the first pass, everyone in the line buys a ticket and the line becomes [1, 2, 1].
- In the second pass, everyone in the line buys a ticket and the line becomes [0, 1, 0].
The person at&nbsp;position 2 has successfully bought 2 tickets and it took 3 + 3 = 6 seconds.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> tickets = [5,1,1,1], k = 0
<strong>Output:</strong> 8
<strong>Explanation:</strong>
- In the first pass, everyone in the line buys a ticket and the line becomes [4, 0, 0, 0].
- In the next 4 passes, only the person in position 0 is buying tickets.
The person at&nbsp;position 0 has successfully bought 5 tickets and it took 4 + 1 + 1 + 1 + 1 = 8 seconds.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == tickets.length</code></li>
	<li><code>1 &lt;= n &lt;= 100</code></li>
	<li><code>1 &lt;= tickets[i] &lt;= 100</code></li>
	<li><code>0 &lt;= k &lt; n</code></li>
</ul>
</div>
 */
public class TimeNeededToBuyTickets {
    public static void main(String[] args) {
        int[][][] tests = {
            {{2,3,2},{2}},
            {{5,1,1,1},{0}}
        };

        for (int[][] test : tests) {
            int[] tickets = test[0];
            int k = test[1][0];

            System.out.println(new TimeNeededToBuyTickets_Solution().timeRequiredToBuy(tickets, k));
        }
    }
}

// 2 ms 41 MB
class TimeNeededToBuyTickets_Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int count= 0;

        while (tickets[k] != 0) {
            for (int i = 0; i < tickets.length; i++) {
                if (tickets[i] != 0) {
                    count++;
                    tickets[i]--;
                }

                if (tickets[k] == 0) {
                    break;
                }
            }
        }

        return count;
    }
}