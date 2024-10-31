package BetterCodeAnswer.Hard.Array;

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

// 49ms 44.04MB
class MinimumTotalDistanceTraveled_Solution {

    public long minimumTotalDistance(List<Integer> robots, int[][] factories) {
        // Sort robots and factories by position
        Collections.sort(robots);
        Arrays.sort(factories, Comparator.comparingInt(a -> a[0]));

        // Flatten factory positions according to their capacities
        List<Integer> factoryPositions = new ArrayList<>();
        for (int[] factory : factories) {
            for (int i = 0; i < factory[1]; i++) {
                factoryPositions.add(factory[0]);
            }
        }

        int robotCount = robots.size(), factoryCount = factoryPositions.size();
        long[] next = new long[factoryCount + 1];
        long[] current = new long[factoryCount + 1];

        // Fill DP table using two rows for optimization
        for (int i = robotCount - 1; i >= 0; i--) {
            // No factories left case
            if (i != robotCount - 1) next[factoryCount] = (long) 1e12;
            // Initialize current row
            current[factoryCount] = (long) 1e12;

            for (int j = factoryCount - 1; j >= 0; j--) {
                // Assign current robot to current factory
                long assign =
                    Math.abs((long) robots.get(i) - factoryPositions.get(j)) +
                    next[j + 1];
                // Skip current factory for this robot
                long skip = current[j + 1];
                // Take the minimum option
                current[j] = Math.min(assign, skip);
            }
            // Move to next robot
            System.arraycopy(current, 0, next, 0, factoryCount + 1);
        }

        // Return minimum distance starting from the first robot
        return current[0];
    }
}

// 52ms 55.27MB
class MinimumTotalDistanceTraveled_Solution2 {

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

        // Initialize dp array
        long[][] dp = new long[robotCount + 1][factoryCount + 1];

        // Initialize base cases
        for (int i = 0; i < robotCount; i++) {
            dp[i][factoryCount] = (long) 1e12; // No factories left
        }

        // Fill DP table bottom-up
        for (int i = robotCount - 1; i >= 0; i--) {
            for (int j = factoryCount - 1; j >= 0; j--) {
                // Option 1: Assign current robot to current factory
                long assign =
                    Math.abs(robot.get(i) - factoryPositions.get(j)) +
                    dp[i + 1][j + 1];

                // Option 2: Skip current factory for the current robot
                long skip = dp[i][j + 1];

                // Take the minimum option
                dp[i][j] = Math.min(assign, skip);
            }
        }

        // Minimum distance starting from first robot and factory
        return dp[0][0];
    }
}

// 34ms 42.86MB
class MinimumTotalDistanceTraveled_Solution3 {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, (f1, f2) -> f1[0] - f2[0]);
        long[][] dp = new long[factory.length][robot.size()];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1L);
        }

        long dis = 0;
        for (int r = 0; r < Math.min(factory[0][1], robot.size()); r++) {
            dis += Math.abs(factory[0][0] - robot.get(r));
            dp[0][r] = dis;
        }

        //System.out.println(Arrays.toString(dp[0]));

        for (int f = 1; f < factory.length; f++) {
            int limit = factory[f][1];
            for (int r = 0; r < robot.size(); r++) {
                dis = 0;
                dp[f][r] = dp[f - 1][r];
                for (int fix = 0; fix < limit; fix++) {
                    int rr = r - fix;
                    if (rr < 0) {
                        break;
                    }
                    dis += Math.abs(factory[f][0] - robot.get(rr));
                    long total = dis;
                    if (rr > 0) {
                        if (dp[f - 1][rr - 1] < 0) {
                            continue;
                        }
                        total += dp[f - 1][rr - 1];
                        /*
                        if (r == 2) {
                            System.out.println(rr + ": " + total);
                        }
                        */
                    }
                    if (total < dp[f][r] || dp[f][r] < 0) {
                        dp[f][r] = total;
                    }
                    /*
                    if (r == 2) {
                        System.out.println(rr + ", " + dis + ", t: " + total + ": " + Arrays.toString(dp[f]));
                    }
                    */
                }
            }
            // System.out.println(Arrays.toString(dp[f]));
        }
        return dp[factory.length - 1][robot.size() - 1];
    }
}