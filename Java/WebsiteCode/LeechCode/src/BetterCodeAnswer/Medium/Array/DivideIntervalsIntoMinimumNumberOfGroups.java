package BetterCodeAnswer.Medium.Array;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/divide-intervals-into-minimum-number-of-groups/">2406. Divide Intervals Into Minimum Number of Groups</a>
 * 
 * <div><div class="elfjS" data-track-load="description_content"><p>You are given a 2D integer array <code>intervals</code> where <code>intervals[i] = [left<sub>i</sub>, right<sub>i</sub>]</code> represents the <strong>inclusive</strong> interval <code>[left<sub>i</sub>, right<sub>i</sub>]</code>.</p>
 * 
 * <p>You have to divide the intervals into one or more <strong>groups</strong> such that each interval is in <strong>exactly</strong> one group, and no two intervals that are in the same group <strong>intersect</strong> each other.</p>
 * 
 * <p>Return <em>the <strong>minimum</strong> number of groups you need to make</em>.</p>
 * 
 * <p>Two intervals <strong>intersect</strong> if there is at least one common number between them. For example, the intervals <code>[1, 5]</code> and <code>[5, 8]</code> intersect.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> intervals = [[5,10],[6,8],[1,5],[2,3],[1,10]]
 * <strong>Output:</strong> 3
 * <strong>Explanation:</strong> We can divide the intervals into the following groups:
 * - Group 1: [1, 5], [6, 8].
 * - Group 2: [2, 3], [5, 10].
 * - Group 3: [1, 10].
 * It can be proven that it is not possible to divide the intervals into fewer than 3 groups.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> intervals = [[1,3],[5,6],[8,10],[11,13]]
 * <strong>Output:</strong> 1
 * <strong>Explanation:</strong> None of the intervals overlap, so we can put all of them in one group.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= intervals.length &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>intervals[i].length == 2</code></li>
 * 	<li><code>1 &lt;= left<sub>i</sub> &lt;= right<sub>i</sub> &lt;= 10<sup>6</sup></code></li>
 * </ul>
 * </div></div>
 */
public class DivideIntervalsIntoMinimumNumberOfGroups {
    public static void main(String[] args) {
        int[][][] tests = {
            {{5,10},{6,8},{1,5},{2,3},{1,10}}
        };

        for (int[][] intervals : tests) {
            System.out.println(new DivideIntervalsIntoMinimumNumberOfGroups_Solution().minGroups(intervals));
        }
    }
}

// 26ms 95.09MB
class DivideIntervalsIntoMinimumNumberOfGroups_Solution {

    public int minGroups(int[][] intervals) {
        // Find the minimum and maximum value in the intervals
        int rangeStart = Integer.MAX_VALUE;
        int rangeEnd = Integer.MIN_VALUE;
        for (int[] interval : intervals) {
            rangeStart = Math.min(rangeStart, interval[0]);
            rangeEnd = Math.max(rangeEnd, interval[1]);
        }

        // Initialize the array with all zeroes
        int[] pointToCount = new int[rangeEnd + 2];
        for (int[] interval : intervals) {
            pointToCount[interval[0]]++; // Increment at the start of the interval
            pointToCount[interval[1] + 1]--; // Decrement right after the end of the interval
        }

        int concurrentIntervals = 0;
        int maxConcurrentIntervals = 0;
        for (int i = rangeStart; i <= rangeEnd; i++) {
            // Update currently active intervals
            concurrentIntervals += pointToCount[i];
            maxConcurrentIntervals = Math.max(
                maxConcurrentIntervals,
                concurrentIntervals
            );
        }

        return maxConcurrentIntervals;
    }
}