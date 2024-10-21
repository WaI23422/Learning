package BetterCodeAnswer.Hard.Array;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/robot-collisions/">2751. Robot Collisions</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>There are <code>n</code> <strong>1-indexed</strong> robots, each having a position on a line, health, and movement direction.</p>
 * 
 * <p>You are given <strong>0-indexed</strong> integer arrays <code>positions</code>, <code>healths</code>, and a string <code>directions</code> (<code>directions[i]</code> is either <strong>'L'</strong> for <strong>left</strong> or <strong>'R'</strong> for <strong>right</strong>). All integers in <code>positions</code> are <strong>unique</strong>.</p>
 * 
 * <p>All robots start moving on the line<strong> simultaneously</strong> at the <strong>same speed </strong>in their given directions. If two robots ever share the same position while moving, they will <strong>collide</strong>.</p>
 * 
 * <p>If two robots collide, the robot with <strong>lower health</strong> is <strong>removed</strong> from the line, and the health of the other robot <strong>decreases</strong> <strong>by one</strong>. The surviving robot continues in the <strong>same</strong> direction it was going. If both robots have the <strong>same</strong> health, they are both<strong> </strong>removed from the line.</p>
 * 
 * <p>Your task is to determine the <strong>health</strong> of the robots that survive the collisions, in the same <strong>order </strong>that the robots were given,<strong> </strong>i.e. final heath of robot 1 (if survived), final health of robot 2 (if survived), and so on. If there are no survivors, return an empty array.</p>
 * 
 * <p>Return <em>an array containing the health of the remaining robots (in the order they were given in the input), after no further collisions can occur.</em></p>
 * 
 * <p><strong>Note:</strong> The positions may be unsorted.</p>
 * 
 * <div class="notranslate" style="all: initial;">&nbsp;</div>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <p><img height="169" src="https://assets.leetcode.com/uploads/2023/05/15/image-20230516011718-12.png" width="808"></p>
 * 
 * <pre><strong>Input:</strong> positions = [5,4,3,2,1], healths = [2,17,9,15,10], directions = "RRRRR"
 * <strong>Output:</strong> [2,17,9,15,10]
 * <strong>Explanation:</strong> No collision occurs in this example, since all robots are moving in the same direction. So, the health of the robots in order from the first robot is returned, [2, 17, 9, 15, 10].
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <p><img height="176" src="https://assets.leetcode.com/uploads/2023/05/15/image-20230516004433-7.png" width="717"></p>
 * 
 * <pre><strong>Input:</strong> positions = [3,5,2,6], healths = [10,10,15,12], directions = "RLRL"
 * <strong>Output:</strong> [14]
 * <strong>Explanation:</strong> There are 2 collisions in this example. Firstly, robot 1 and robot 2 will collide, and since both have the same health, they will be removed from the line. Next, robot 3 and robot 4 will collide and since robot 4's health is smaller, it gets removed, and robot 3's health becomes 15 - 1 = 14. Only robot 3 remains, so we return [14].
 * </pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <p><img height="172" src="https://assets.leetcode.com/uploads/2023/05/15/image-20230516005114-9.png" width="732"></p>
 * 
 * <pre><strong>Input:</strong> positions = [1,2,5,6], healths = [10,10,11,11], directions = "RLRL"
 * <strong>Output:</strong> []
 * <strong>Explanation:</strong> Robot 1 and robot 2 will collide and since both have the same health, they are both removed. Robot 3 and 4 will collide and since both have the same health, they are both removed. So, we return an empty array, [].</pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= positions.length == healths.length == directions.length == n &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>1 &lt;= positions[i], healths[i] &lt;= 10<sup>9</sup></code></li>
 * 	<li><code>directions[i] == 'L'</code> or <code>directions[i] == 'R'</code></li>
 * 	<li>All values in <code>positions</code> are distinct</li>
 * </ul>
 * </div>
 */
public class RobotCollisions {
    public static void main(String[] args) {
        Object[][][] tests = {
            {
                {3,5,2,6},
                {10,10,15,12},
                {"RLRL"}
            },
            {
                {5,4,3,2,1},
                {2,17,9,15,10},
                {"RRRRR"}
            }
        };

        for (Object[][] test : tests) {
            int[] positions = Arrays.stream(test[0])
                                    .mapToInt(x -> (int) x)
                                    .toArray(),
                  healths = Arrays.stream(test[1])
                                    .mapToInt(x -> (int) x)
                                    .toArray();
            String directions = (String) test[2][0];

            System.out.println(new RobotCollisions_Solution().survivedRobotsHealths(positions, healths, directions));
        }
    }
}

// 38 ms 57.7 MB
class RobotCollisions_Solution {

    public List<Integer> survivedRobotsHealths(
        int[] positions,
        int[] healths,
        String directions
    ) {
        int n = positions.length;
        Integer[] indices = new Integer[n];
        List<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (int index = 0; index < n; ++index) {
            indices[index] = index;
        }

        Arrays.sort(
            indices,
            (lhs, rhs) -> Integer.compare(positions[lhs], positions[rhs])
        );

        for (int currentIndex : indices) {
            // Add right-moving robots to the stack
            if (directions.charAt(currentIndex) == 'R') {
                stack.push(currentIndex);
            } else {
                while (!stack.isEmpty() && healths[currentIndex] > 0) {
                    // Pop the top robot from the stack for collision check
                    int topIndex = stack.pop();

                    // Top robot survives, current robot is destroyed
                    if (healths[topIndex] > healths[currentIndex]) {
                        healths[topIndex] -= 1;
                        healths[currentIndex] = 0;
                        stack.push(topIndex);
                    } else if (healths[topIndex] < healths[currentIndex]) {
                        // Current robot survives, top robot is destroyed
                        healths[currentIndex] -= 1;
                        healths[topIndex] = 0;
                    } else {
                        // Both robots are destroyed
                        healths[currentIndex] = 0;
                        healths[topIndex] = 0;
                    }
                }
            }
        }

        // Collect surviving robots
        for (int index = 0; index < n; ++index) {
            if (healths[index] > 0) {
                result.add(healths[index]);
            }
        }
        return result;
    }
}

// 32 ms 60.2 MB
class RobotCollisions_Solution2 {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] h, String directions) {
        int n = positions.length;
        List<Integer> ind = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ind.add(i);
        }
        ind.sort((a, b) -> Integer.compare(positions[a], positions[b]));

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i : ind) {
            if (directions.charAt(i) == 'R') {
                stack.push(i);
                continue;
            }
            while (!stack.isEmpty() && h[i] > 0) {
                if (h[stack.peek()] < h[i]) {
                    h[stack.pop()] = 0;
                    h[i] -= 1;
                } else if (h[stack.peek()] > h[i]) {
                    h[stack.peek()] -= 1;
                    h[i] = 0;
                } else {
                    h[stack.pop()] = 0;
                    h[i] = 0;
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int v : h) {
            if (v > 0) {
                res.add(v);
            }
        }
        return res;
    }
}

class Robot {
    public int index;
    public int position;
    public int health;
    public char direction;
    public Robot(int index, int position, int health, char direction) {
        this.index = index;
        this.position = position;
        this.health = health;
        this.direction = direction;
    }
}

// 28ms 62.56 MB
class RobotCollisions_Solution3 {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
      List<Integer> ans = new ArrayList<>();
      Robot[] robots = new Robot[positions.length];
      List<Robot> stack = new ArrayList<>(); // running robots
  
      for (int i = 0; i < positions.length; ++i)
        robots[i] = new Robot(i, positions[i], healths[i], directions.charAt(i));
  
      Arrays.sort(robots, (a, b) -> a.position - b.position);
  
      for (Robot robot : robots) {
        if (robot.direction == 'R') {
          stack.add(robot);
          continue;
        }
        // Collide with robots going right if any.
        while (!stack.isEmpty() && stack.get(stack.size() - 1).direction == 'R' && robot.health > 0) {
            if (stack.get(stack.size() - 1).health == robot.health) {
                stack.remove(stack.size() - 1);
                robot.health = 0;
            } else if (stack.get(stack.size() - 1).health < robot.health) {
                stack.remove(stack.size() - 1);
                robot.health -= 1;
            } else { // stack[-1].health > robot.health
                stack.get(stack.size() - 1).health -= 1;
                robot.health = 0;
            }
        }
        if (robot.health > 0)
          stack.add(robot);
      }
  
      stack.sort((a, b) -> a.index - b.index);
  
      for (Robot robot : stack)
        ans.add(robot.health);
  
      return ans;
    }
  }