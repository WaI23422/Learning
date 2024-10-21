package BetterCodeAnswer.Easy.Arrays;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/minimum-number-of-moves-to-seat-everyone/">2037. Minimum Number of Moves to Seat Everyone</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>There are <code>n</code> seats and <code>n</code> students in a room. You are given an array <code>seats</code> of length <code>n</code>, where <code>seats[i]</code> is the position of the <code>i<sup>th</sup></code> seat. You are also given the array <code>students</code> of length <code>n</code>, where <code>students[j]</code> is the position of the <code>j<sup>th</sup></code> student.</p>
 * 
 * <p>You may perform the following move any number of times:</p>
 * 
 * <ul>
 * 	<li>Increase or decrease the position of the <code>i<sup>th</sup></code> student by <code>1</code> (i.e., moving the <code>i<sup>th</sup></code> student from position&nbsp;<code>x</code>&nbsp;to <code>x + 1</code> or <code>x - 1</code>)</li>
 * </ul>
 * 
 * <p>Return <em>the <strong>minimum number of moves</strong> required to move each student to a seat</em><em> such that no two students are in the same seat.</em></p>
 * 
 * <p>Note that there may be <strong>multiple</strong> seats or students in the <strong>same </strong>position at the beginning.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> seats = [3,1,5], students = [2,7,4]
 * <strong>Output:</strong> 4
 * <strong>Explanation:</strong> The students are moved as follows:
 * - The first student is moved from from position 2 to position 1 using 1 move.
 * - The second student is moved from from position 7 to position 5 using 2 moves.
 * - The third student is moved from from position 4 to position 3 using 1 move.
 * In total, 1 + 2 + 1 = 4 moves were used.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> seats = [4,1,5,9], students = [1,3,2,6]
 * <strong>Output:</strong> 7
 * <strong>Explanation:</strong> The students are moved as follows:
 * - The first student is not moved.
 * - The second student is moved from from position 3 to position 4 using 1 move.
 * - The third student is moved from from position 2 to position 5 using 3 moves.
 * - The fourth student is moved from from position 6 to position 9 using 3 moves.
 * In total, 0 + 1 + 3 + 3 = 7 moves were used.
 * </pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <pre><strong>Input:</strong> seats = [2,2,6,6], students = [1,3,2,6]
 * <strong>Output:</strong> 4
 * <strong>Explanation:</strong> Note that there are two seats at position 2 and two seats at position 6.
 * The students are moved as follows:
 * - The first student is moved from from position 1 to position 2 using 1 move.
 * - The second student is moved from from position 3 to position 6 using 3 moves.
 * - The third student is not moved.
 * - The fourth student is not moved.
 * In total, 1 + 3 + 0 + 0 = 4 moves were used.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>n == seats.length == students.length</code></li>
 * 	<li><code>1 &lt;= n &lt;= 100</code></li>
 * 	<li><code>1 &lt;= seats[i], students[j] &lt;= 100</code></li>
 * </ul>
 * </div>
 */
public class MinimumNumberOfMovesToSeatEveryone {
    public static void main(String[] args) {
        int[][][] tests = {
            {
                {3,1,5},
                {2,7,4}
            }
        };

        for (int[][] test : tests) {
            int[] seats = test[0],
                  students = test[1];
            
            System.out.println( new MinimumNumberOfMovesToSeatEveryone_Solution().minMovesToSeat(seats, students));
        }
    }
}

// 1 ms 43.5 MB
class MinimumNumberOfMovesToSeatEveryone_Solution {

    public int minMovesToSeat(int[] seats, int[] students) {
        // Find the maximum position in the arrays
        int maxPosition = Math.max(findMax(seats), findMax(students));

        // Stores difference between number of seats and students at each position
        int[] differences = new int[maxPosition];

        // Count the available seats at each position
        for (int position : seats) {
            differences[position - 1]++;
        }

        // Remove a seat for each student at that position
        for (int position : students) {
            differences[position - 1]--;
        }

        // Calculate the number of moves needed to seat the students
        int moves = 0;
        int unmatched = 0;
        for (int difference : differences) {
            moves += Math.abs(unmatched);
            unmatched += difference;
        }

        return moves;
    }

    private int findMax(int[] array) {
        int maximum = 0;
        for (int num : array) {
            if (num > maximum) {
                maximum = num;
            }
        }
        return maximum;
    }
}