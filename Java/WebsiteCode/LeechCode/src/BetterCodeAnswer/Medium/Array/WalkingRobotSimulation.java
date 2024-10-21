package BetterCodeAnswer.Medium.Array;

import java.util.HashSet;
import java.util.Set;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/walking-robot-simulation/">874. Walking Robot Simulation</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>A robot on an infinite XY-plane starts at point <code>(0, 0)</code> facing north. The robot can receive a sequence of these three possible types of <code>commands</code>:</p>
 * 
 * <ul>
 * 	<li><code>-2</code>: Turn left <code>90</code> degrees.</li>
 * 	<li><code>-1</code>: Turn right <code>90</code> degrees.</li>
 * 	<li><code>1 &lt;= k &lt;= 9</code>: Move forward <code>k</code> units, one unit at a time.</li>
 * </ul>
 * 
 * <p>Some of the grid squares are <code>obstacles</code>. The <code>i<sup>th</sup></code> obstacle is at grid point <code>obstacles[i] = (x<sub>i</sub>, y<sub>i</sub>)</code>. If the robot runs into an obstacle, then it will instead stay in its current location and move on to the next command.</p>
 * 
 * <p>Return <em>the <strong>maximum Euclidean distance</strong> that the robot ever gets from the origin <strong>squared</strong> (i.e. if the distance is </em><code>5</code><em>, return </em><code>25</code><em>)</em>.</p>
 * 
 * <p><strong>Note:</strong></p>
 * 
 * <ul>
 * 	<li>North means +Y direction.</li>
 * 	<li>East means +X direction.</li>
 * 	<li>South means -Y direction.</li>
 * 	<li>West means -X direction.</li>
 * 	<li>There can be obstacle in&nbsp;[0,0].</li>
 * </ul>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> commands = [4,-1,3], obstacles = []
 * <strong>Output:</strong> 25
 * <strong>Explanation:</strong> The robot starts at (0, 0):
 * 1. Move north 4 units to (0, 4).
 * 2. Turn right.
 * 3. Move east 3 units to (3, 4).
 * The furthest point the robot ever gets from the origin is (3, 4), which squared is 3<sup>2</sup> + 4<sup>2</sup> = 25 units away.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> commands = [4,-1,4,-2,4], obstacles = [[2,4]]
 * <strong>Output:</strong> 65
 * <strong>Explanation:</strong> The robot starts at (0, 0):
 * 1. Move north 4 units to (0, 4).
 * 2. Turn right.
 * 3. Move east 1 unit and get blocked by the obstacle at (2, 4), robot is at (1, 4).
 * 4. Turn left.
 * 5. Move north 4 units to (1, 8).
 * The furthest point the robot ever gets from the origin is (1, 8), which squared is 1<sup>2</sup> + 8<sup>2</sup> = 65 units away.
 * </pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <pre><strong>Input:</strong> commands = [6,-1,-1,6], obstacles = []
 * <strong>Output:</strong> 36
 * <strong>Explanation:</strong> The robot starts at (0, 0):
 * 1. Move north 6 units to (0, 6).
 * 2. Turn right.
 * 3. Turn right.
 * 4. Move south 6 units to (0, 0).
 * The furthest point the robot ever gets from the origin is (0, 6), which squared is 6<sup>2</sup> = 36 units away.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= commands.length &lt;= 10<sup>4</sup></code></li>
 * 	<li><code>commands[i]</code> is either <code>-2</code>, <code>-1</code>, or an integer in the range <code>[1, 9]</code>.</li>
 * 	<li><code>0 &lt;= obstacles.length &lt;= 10<sup>4</sup></code></li>
 * 	<li><code>-3 * 10<sup>4</sup> &lt;= x<sub>i</sub>, y<sub>i</sub> &lt;= 3 * 10<sup>4</sup></code></li>
 * 	<li>The answer is guaranteed to be less than <code>2<sup>31</sup></code>.</li>
 * </ul>
 * </div>
 */
public class WalkingRobotSimulation {
    public static void main(String[] args) {
        int[][][][] tests = {
            {
                {{6,-1,-1,6}},
                {}
            }
        };

        for (int[][][] test : tests) {
            int commands[] = test[0][0],
                obstacles[][] = test[1];

            System.out.println(new WalkingRobotSimulation_Solution().robotSim(commands, obstacles));
        }
    }
}

//10ms 48.73MB
class WalkingRobotSimulation_Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Robot robot = new Robot();
        Set<Obstacle> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstacleSet.add(new Obstacle(obstacle[0], obstacle[1]));
        }
        for (int command : commands) robot.handleCommand(command, obstacleSet);
        return robot.maxDistance;
    }
    private static class Robot {
        public int x = 0, y = 0, dir = 0, maxDistance = 0;

        Robot() {}
        private void handleCommand(int command, Set<Obstacle> obstacles) {
            switch (command) {
                case -2:
                    dir = (dir + 3) % 4;
                    return;
                case -1:
                    dir = (dir + 1) % 4;
                    return;
                default: {
                    while (command-- > 0) {
                        int newX = x, newY = y;
                        switch (dir) {
                            case 0: ++newY; break;
                            case 1: ++newX; break;
                            case 2: --newY; break;
                            default: --newX;
                        }
                        if (!obstacles.contains(new Obstacle(newX, newY))) {
                            x = newX;
                            y = newY;
                        }
                    }
                    maxDistance = Math.max(x * x + y * y, maxDistance);
                }
            }
        }
    }
    private static class Obstacle {
        public int x, y;

        public Obstacle(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public boolean equals(Object other) {
            return x == ((Obstacle) other).x && y == ((Obstacle) other).y;
        }
        public int hashCode() {
            return x + y * 413;
        }
    }
}