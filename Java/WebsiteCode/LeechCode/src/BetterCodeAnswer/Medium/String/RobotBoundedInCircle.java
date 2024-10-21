package BetterCodeAnswer.Medium.String;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/robot-bounded-in-circle/">1041.Robot Bounded In Circle</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>On an infinite plane, a robot initially stands at <code>(0, 0)</code> and faces north. Note that:</p>

<ul>
	<li>The <strong>north direction</strong> is the positive direction of the y-axis.</li>
	<li>The <strong>south direction</strong> is the negative direction of the y-axis.</li>
	<li>The <strong>east direction</strong> is the positive direction of the x-axis.</li>
	<li>The <strong>west direction</strong> is the negative direction of the x-axis.</li>
</ul>

<p>The robot can receive one of three instructions:</p>

<ul>
	<li><code>"G"</code>: go straight 1 unit.</li>
	<li><code>"L"</code>: turn 90 degrees to the left (i.e., anti-clockwise direction).</li>
	<li><code>"R"</code>: turn 90 degrees to the right (i.e., clockwise direction).</li>
</ul>

<p>The robot performs the <code>instructions</code> given in order, and repeats them forever.</p>

<p>Return <code>true</code> if and only if there exists a circle in the plane such that the robot never leaves the circle.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> instructions = "GGLLGG"
<strong>Output:</strong> true
<strong>Explanation:</strong> The robot is initially at (0, 0) facing the north direction.
"G": move one step. Position: (0, 1). Direction: North.
"G": move one step. Position: (0, 2). Direction: North.
"L": turn 90 degrees anti-clockwise. Position: (0, 2). Direction: West.
"L": turn 90 degrees anti-clockwise. Position: (0, 2). Direction: South.
"G": move one step. Position: (0, 1). Direction: South.
"G": move one step. Position: (0, 0). Direction: South.
Repeating the instructions, the robot goes into the cycle: (0, 0) --&gt; (0, 1) --&gt; (0, 2) --&gt; (0, 1) --&gt; (0, 0).
Based on that, we return true.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> instructions = "GG"
<strong>Output:</strong> false
<strong>Explanation:</strong> The robot is initially at (0, 0) facing the north direction.
"G": move one step. Position: (0, 1). Direction: North.
"G": move one step. Position: (0, 2). Direction: North.
Repeating the instructions, keeps advancing in the north direction and does not go into cycles.
Based on that, we return false.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> instructions = "GL"
<strong>Output:</strong> true
<strong>Explanation:</strong> The robot is initially at (0, 0) facing the north direction.
"G": move one step. Position: (0, 1). Direction: North.
"L": turn 90 degrees anti-clockwise. Position: (0, 1). Direction: West.
"G": move one step. Position: (-1, 1). Direction: West.
"L": turn 90 degrees anti-clockwise. Position: (-1, 1). Direction: South.
"G": move one step. Position: (-1, 0). Direction: South.
"L": turn 90 degrees anti-clockwise. Position: (-1, 0). Direction: East.
"G": move one step. Position: (0, 0). Direction: East.
"L": turn 90 degrees anti-clockwise. Position: (0, 0). Direction: North.
Repeating the instructions, the robot goes into the cycle: (0, 0) --&gt; (0, 1) --&gt; (-1, 1) --&gt; (-1, 0) --&gt; (0, 0).
Based on that, we return true.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= instructions.length &lt;= 100</code></li>
	<li><code>instructions[i]</code> is <code>'G'</code>, <code>'L'</code> or, <code>'R'</code>.</li>
</ul>
</div></div>
 */
public class RobotBoundedInCircle {
    public static void main(String[] args) {
        String[] tests = {
            "GGLLGG",
            "GG",
            "GL",
            "GLGRGL",
            "LRLR"
        };  

        RobotBoundedInCircle_Solution res = new RobotBoundedInCircle_Solution();

        for (String instructions : tests) {
            System.out.println(res.isRobotBounded(instructions));
        }
    }
}

class RobotBoundedInCircle_Solution {
    // 0 ms
    // 40.2 MB
    public boolean isRobotBounded(String ins) {
        int x = 0, y = 0, i = 0, d[][] = {{0, 1}, {1, 0}, {0, -1}, { -1, 0}};
        for (int j = 0; j < ins.length(); ++j)
            if (ins.charAt(j) == 'R')
                i = (i + 1) % 4;
            else if (ins.charAt(j) == 'L')
                i = (i + 3) % 4;
            else {
                x += d[i][0]; y += d[i][1];
            }
        return x == 0 && y == 0 || i > 0;
    }
}

/**
 * My thought process:
    So in question its given we are initially at 0, 0 at North directions. So we need to keep track of the points as well as the directions in which the robot travels. So we can have x, y = 0 and directions = North
    
    Now our problem is to find whether the robot is moving outside the circle after following some instructions. So the robot leaves the circle if it keep moving in the North direction.
    
    So lets loop through each and every character from the instruction string, then:
    1. We check whether its G, if G then we have to move one point from the current position.
        SO if we are at North direction, then if we consider the coordinate, we are at +y directions, so we will move only up, just understand like that, SO we increment our y by 1, by following this pattern we can automatically deduce that if we are at South, then decrement y by 1. Same way for East, increment x by 1 and for West decrement x by 1.
    2. Next we check wheter its L, then we have to move 90 degree left wards.
                    North
            West                East    , So do a counter clockwise assumption. If we are at a directions North, then its 
                                          counter clockwis, yes West update direction by west, Same way if our directions is                          South                West, them its counter clockwise south, same way for direction south, update                                                     direction by east. So just rememebr if chaarcter is L, then counter clockwise.
    3. Next whetehr the character if R, then we already got it rememebr about clockwise direction and update direction according to it
    
    Finally we check whetehr the robot get back to the position, if yes, return true as the robot donot go out of the circle.
    We check whether the direction is still North, then it will sure go out of the circle, so return false.
    If none of the above condition satisfies, then also the robot will be some where inside the circle, so return true.
 */
class RobotBoundedInCircle_Solution2 {
    // 0 ms 
    // 40.8 MB
    public boolean isRobotBounded(String instructions) {
        if (instructions.length() == 0)
            return false;
        int x = 0;
        int y = 0;  // initial points of the robot
        String directions = "North"; // initial direction of robot
        /*
                    North
            West                East
                    South
                    
        */
        for (char ch: instructions.toCharArray()) {
            if (ch == 'G') {
                if (directions.equals("North"))
                    y += 1;
                else if (directions.equals("South"))
                    y -= 1;
                else if(directions.equals("East"))
                    x += 1;
                else
                    x -= 1;
            }
            else if (ch == 'L') {
                if (directions.equals("North"))
                    directions = "West";
                else if (directions.equals("West"))
                    directions = "South";
                else if (directions.equals("South"))
                    directions = "East";
                else directions = "North";
            }
            else if (ch == 'R') {
                if (directions.equals("North"))
                    directions = "East";
                else if (directions.equals("East"))
                    directions = "South";
                else if (directions.equals("South"))
                    directions = "West";
                else directions = "North";
            }
        }
        if (x == 0 && y == 0)
            return true;
        if (directions.equals("North"))
            return false;
        return true;
    }
}