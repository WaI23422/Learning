package BetterCodeAnswer.Easy.Number;

import java.util.LinkedList;
import java.util.List;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/find-the-winner-of-the-circular-game/">1823. Find the Winner of the Circular Game</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>There are <code>n</code> friends that are playing a game. The friends are sitting in a circle and are numbered from <code>1</code> to <code>n</code> in <strong>clockwise order</strong>. More formally, moving clockwise from the <code>i<sup>th</sup></code> friend brings you to the <code>(i+1)<sup>th</sup></code> friend for <code>1 &lt;= i &lt; n</code>, and moving clockwise from the <code>n<sup>th</sup></code> friend brings you to the <code>1<sup>st</sup></code> friend.</p>
 * 
 * <p>The rules of the game are as follows:</p>
 * 
 * <ol>
 * 	<li><strong>Start</strong> at the <code>1<sup>st</sup></code> friend.</li>
 * 	<li>Count the next <code>k</code> friends in the clockwise direction <strong>including</strong> the friend you started at. The counting wraps around the circle and may count some friends more than once.</li>
 * 	<li>The last friend you counted leaves the circle and loses the game.</li>
 * 	<li>If there is still more than one friend in the circle, go back to step <code>2</code> <strong>starting</strong> from the friend <strong>immediately clockwise</strong> of the friend who just lost and repeat.</li>
 * 	<li>Else, the last friend in the circle wins the game.</li>
 * </ol>
 * 
 * <p>Given the number of friends, <code>n</code>, and an integer <code>k</code>, return <em>the winner of the game</em>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/03/25/ic234-q2-ex11.png" style="width: 500px; height: 345px;">
 * <pre><strong>Input:</strong> n = 5, k = 2
 * <strong>Output:</strong> 3
 * <strong>Explanation:</strong> Here are the steps of the game:
 * 1) Start at friend 1.
 * 2) Count 2 friends clockwise, which are friends 1 and 2.
 * 3) Friend 2 leaves the circle. Next start is friend 3.
 * 4) Count 2 friends clockwise, which are friends 3 and 4.
 * 5) Friend 4 leaves the circle. Next start is friend 5.
 * 6) Count 2 friends clockwise, which are friends 5 and 1.
 * 7) Friend 1 leaves the circle. Next start is friend 3.
 * 8) Count 2 friends clockwise, which are friends 3 and 5.
 * 9) Friend 5 leaves the circle. Only friend 3 is left, so they are the winner.</pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> n = 6, k = 5
 * <strong>Output:</strong> 1
 * <strong>Explanation:</strong> The friends leave in this order: 5, 4, 6, 2, 3. The winner is friend 1.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= k &lt;= n &lt;= 500</code></li>
 * </ul>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Follow up:</strong></p>
 * 
 * <p>Could you solve this problem in linear time with constant space?</p>
 * </div>
 */
public class FindTheWinnerOfTheCircularGame {
    public static void main(String[] args) {
        int[][] tests = {
            {5,2},
            {6,5}
        };
    
        for (int[] test : tests) {
            int n = test[0],
                k = test[1];

            System.out.println(new FindTheWinnerOfTheCircularGame_Solution().findTheWinner(n, k));
        }
    }
}

// 3ms 41.05MB
class FindTheWinnerOfTheCircularGame_Solution {

    public int findTheWinner(int n, int k) {
        // Initialize list of N friends, labeled from 1-N
        List<Integer> circle = new LinkedList<Integer>();
        for (int i = 1; i <= n; i++) {
            circle.add(i);
        }

        // Maintain the index of the friend to start the count on
        int startIndex = 0;

        // Perform eliminations while there is more than 1 friend left
        while (circle.size() > 1) {
            // Calculate the index of the friend to be removed
            int removalIndex = (startIndex + k - 1) % circle.size();

            // Erase the friend at removalIndex
            circle.remove(removalIndex);

            // Update startIndex for the next round
            startIndex = removalIndex;
        }

        return circle.getFirst();
    }
}

// 0ms 40.68MB
class FindTheWinnerOfTheCircularGame_Solution2 {

    public int findTheWinner(int n, int k) {
        return winnerHelper(n, k) + 1;
    }

    private int winnerHelper(int n, int k) {
        if (n == 1) {
            return 0;
        }
        return (winnerHelper(n - 1, k) + k) % n;
    }
}

// 0ms 40.03MB
class FindTheWinnerOfTheCircularGame_Solution3 {

    public int findTheWinner(int n, int k) {
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = (ans + k) % i;
        }
        // add 1 to convert back to 1 indexing
        return ans + 1;
    }
}