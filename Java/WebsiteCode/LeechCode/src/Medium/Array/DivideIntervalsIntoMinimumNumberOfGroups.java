package Medium.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

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

// Time Limit Exceeded
class Node implements Comparable<Node> {
    int end;

    public Node(int end) {
        this.end = end;
    }

    public int compareTo(Node o) {
        return this.end - o.end;
    }
}

class DivideIntervalsIntoMinimumNumberOfGroups_Solution {
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        PriorityQueue<Node> groups = new PriorityQueue<>();
        
        OUT: for (int[] interval : intervals) {
            int start = interval[0],
                end = interval[1];
            for (Node node : groups) {
                if (node.end < start) {
                    node.end = end;
                    continue OUT;
                }
            }

            groups.add(new Node(end));
        }

        return groups.size();    
    }
}

// 138ms 79.22MB
class DivideIntervalsIntoMinimumNumberOfGroups_Solution2 {

    public int minGroups(int[][] intervals) {
        // Convert the intervals to two events
        // start as {start, 1} and end as {end + 1, -1}
        List<int[]> events = new ArrayList<>();

        for (int[] interval : intervals) {
            events.add(new int[] { interval[0], 1 }); // Start event
            events.add(new int[] { interval[1] + 1, -1 }); // End event (interval[1] + 1)
        }

        // Sort the events first by time, and then by type (1 for start, -1 for end).
        Collections.sort(events, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]); // Sort by type (1 before -1)
            } else {
                return Integer.compare(a[0], b[0]); // Sort by time
            }
        });

        int concurrentIntervals = 0;
        int maxConcurrentIntervals = 0;

        // Sweep through the events
        for (int[] event : events) {
            concurrentIntervals += event[1]; // Track currently active intervals
            maxConcurrentIntervals = Math.max(
                maxConcurrentIntervals,
                concurrentIntervals
            ); // Update max
        }

        return maxConcurrentIntervals;
    }
}