package Hard.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/minimum-total-distance-traveled/">2463. Minimum Total Distance Traveled</a>
 * 
 * <div><div class="elfjS" data-track-load="description_content"><p>There are some robots and factories on the X-axis. You are given an integer array <code>robot</code> where <code>robot[i]</code> is the position of the <code>i<sup>th</sup></code> robot. You are also given a 2D integer array <code>factory</code> where <code>factory[j] = [position<sub>j</sub>, limit<sub>j</sub>]</code> indicates that <code>position<sub>j</sub></code> is the position of the <code>j<sup>th</sup></code> factory and that the <code>j<sup>th</sup></code> factory can repair at most <code>limit<sub>j</sub></code> robots.</p>
 * 
 * <p>The positions of each robot are <strong>unique</strong>. The positions of each factory are also <strong>unique</strong>. Note that a robot can be <strong>in the same position</strong> as a factory initially.</p>
 * 
 * <p>All the robots are initially broken; they keep moving in one direction. The direction could be the negative or the positive direction of the X-axis. When a robot reaches a factory that did not reach its limit, the factory repairs the robot, and it stops moving.</p>
 * 
 * <p><strong>At any moment</strong>, you can set the initial direction of moving for <strong>some</strong> robot. Your target is to minimize the total distance traveled by all the robots.</p>
 * 
 * <p>Return <em>the minimum total distance traveled by all the robots</em>. The test cases are generated such that all the robots can be repaired.</p>
 * 
 * <p><strong>Note that</strong></p>
 * 
 * <ul>
 * 	<li>All robots move at the same speed.</li>
 * 	<li>If two robots move in the same direction, they will never collide.</li>
 * 	<li>If two robots move in opposite directions and they meet at some point, they do not collide. They cross each other.</li>
 * 	<li>If a robot passes by a factory that reached its limits, it crosses it as if it does not exist.</li>
 * 	<li>If the robot moved from a position <code>x</code> to a position <code>y</code>, the distance it moved is <code>|y - x|</code>.</li>
 * </ul>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2022/09/15/example1.jpg" style="width: 500px; height: 320px;">
 * <pre><strong>Input:</strong> robot = [0,4,6], factory = [[2,2],[6,2]]
 * <strong>Output:</strong> 4
 * <strong>Explanation:</strong> As shown in the figure:
 * - The first robot at position 0 moves in the positive direction. It will be repaired at the first factory.
 * - The second robot at position 4 moves in the negative direction. It will be repaired at the first factory.
 * - The third robot at position 6 will be repaired at the second factory. It does not need to move.
 * The limit of the first factory is 2, and it fixed 2 robots.
 * The limit of the second factory is 2, and it fixed 1 robot.
 * The total distance is |2 - 0| + |2 - 4| + |6 - 6| = 4. It can be shown that we cannot achieve a better total distance than 4.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2022/09/15/example-2.jpg" style="width: 500px; height: 329px;">
 * <pre><strong>Input:</strong> robot = [1,-1], factory = [[-2,1],[2,1]]
 * <strong>Output:</strong> 2
 * <strong>Explanation:</strong> As shown in the figure:
 * - The first robot at position 1 moves in the positive direction. It will be repaired at the second factory.
 * - The second robot at position -1 moves in the negative direction. It will be repaired at the first factory.
 * The limit of the first factory is 1, and it fixed 1 robot.
 * The limit of the second factory is 1, and it fixed 1 robot.
 * The total distance is |2 - 1| + |(-2) - (-1)| = 2. It can be shown that we cannot achieve a better total distance than 2.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= robot.length, factory.length &lt;= 100</code></li>
 * 	<li><code>factory[j].length == 2</code></li>
 * 	<li><code>-10<sup>9</sup> &lt;= robot[i], position<sub>j</sub> &lt;= 10<sup>9</sup></code></li>
 * 	<li><code>0 &lt;= limit<sub>j</sub> &lt;= robot.length</code></li>
 * 	<li>The input will be generated such that it is always possible to repair every robot.</li>
 * </ul>
 * </div></div>
 */
public class MinimumTotalDistanceTraveled {
    public static void main(String[] args) {
        int[][][][] tests = {
            {
                {{0,4,6}},
                {{2,2},{6,2}}
            }
        };

        for (int[][][] test : tests) {
            List<Integer> robot = new ArrayList<>();

            for (int i = 0; i < test[0][0].length; i++) {
                robot.add(test[0][0][i]);
            }

            int[][] factory = test[1];

            System.out.println(new MinimumTotalDistanceTraveled_Solution().minimumTotalDistance(robot, factory));
        }
    }
}

// 156ms 56.85MB
class MinimumTotalDistanceTraveled_Solution {

    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        // Sort robots and factories by position
        Collections.sort(robot);
        Arrays.sort(factory, Comparator.comparingInt(a -> a[0]));

        // Flatten factory positions according to their capacities
        List<Integer> factoryPositions = new ArrayList<>();
        for (int[] f : factory) {
            for (int i = 0; i < f[1]; i++) {
                factoryPositions.add(f[0]);
            }
        }

        int robotCount = robot.size();
        int factoryCount = factoryPositions.size();
        long[][] memo = new long[robotCount][factoryCount];
        for (long[] row : memo) Arrays.fill(row, -1);

        // Recursively calculate minimum total distance with memoization
        return calculateMinDistance(0, 0, robot, factoryPositions, memo);
    }

    private long calculateMinDistance(
        int robotIdx,
        int factoryIdx,
        List<Integer> robot,
        List<Integer> factoryPositions,
        long[][] memo
    ) {
        // All robots assigned
        if (robotIdx == robot.size()) return 0;
        // No factories left to assign
        if (factoryIdx == factoryPositions.size()) return (long) 1e12;
        // Check memo
        if (memo[robotIdx][factoryIdx] != -1) return memo[robotIdx][factoryIdx];

        // Option 1: Assign current robot to current factory
        long assign =
            Math.abs(robot.get(robotIdx) - factoryPositions.get(factoryIdx)) +
            calculateMinDistance(
                robotIdx + 1,
                factoryIdx + 1,
                robot,
                factoryPositions,
                memo
            );

        // Option 2: Skip current factory for the current robot
        long skip = calculateMinDistance(
            robotIdx,
            factoryIdx + 1,
            robot,
            factoryPositions,
            memo
        );

        // Take the minimum and store in memo
        memo[robotIdx][factoryIdx] = Math.min(assign, skip);
        return memo[robotIdx][factoryIdx];
    }
}