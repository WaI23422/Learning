package Easy.String;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/robot-return-to-origin/">657.Robot Return to Origin</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>There is a robot starting at the position <code>(0, 0)</code>, the origin, on a 2D plane. Given a sequence of its moves, judge if this robot <strong>ends up at </strong><code>(0, 0)</code> after it completes its moves.</p>

<p>You are given a string <code>moves</code> that represents the move sequence of the robot where <code>moves[i]</code> represents its <code>i<sup>th</sup></code> move. Valid moves are <code>'R'</code> (right), <code>'L'</code> (left), <code>'U'</code> (up), and <code>'D'</code> (down).</p>

<p>Return <code>true</code><em> if the robot returns to the origin after it finishes all of its moves, or </em><code>false</code><em> otherwise</em>.</p>

<p><strong>Note</strong>: The way that the robot is "facing" is irrelevant. <code>'R'</code> will always make the robot move to the right once, <code>'L'</code> will always make it move left, etc. Also, assume that the magnitude of the robot's movement is the same for each move.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> moves = "UD"
<strong>Output:</strong> true
<strong>Explanation</strong>: The robot moves up once, and then down once. All moves have the same magnitude, so it ended up at the origin where it started. Therefore, we return true.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> moves = "LL"
<strong>Output:</strong> false
<strong>Explanation</strong>: The robot moves left twice. It ends up two "moves" to the left of the origin. We return false because it is not at the origin at the end of its moves.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= moves.length &lt;= 2 * 10<sup>4</sup></code></li>
	<li><code>moves</code> only contains the characters <code>'U'</code>, <code>'D'</code>, <code>'L'</code> and <code>'R'</code>.</li>
</ul>
</div></div>
 */
public class RobotReturnToOrigin {
    public static void main(String[] args) {
        String moves = "RLUURDDDLU";

        RobotReturnToOrigin_Solution res = new RobotReturnToOrigin_Solution();

        System.out.println(res.judgeCircle(moves));
    }
}

class RobotReturnToOrigin_Solution {
    // 3 ms 
    // 43.6 MB
    public boolean judgeCircle(String moves) {
        int vertical = 0, horizontal = 0;
        
        for (char move : moves.toCharArray()) {
            switch (move) {
                case 'L':
                    vertical++;
                    break;
                
                case 'R':
                    vertical--;
                    break;

                case 'U':
                    horizontal++;
                    break;

                default:
                    horizontal--;
                    break;
            }
        }

        if (vertical == 0 && horizontal == 0 ) {
            return true;
        } else {
            return false;
        }
    }
}

class RobotReturnToOrigin_Solution2 {
    // 4 ms 
    // 43.3 MB
    public boolean judgeCircle(String moves) {
        int[] coor = {0,0};
        
        for (char move : moves.toCharArray()) {
            switch (move) {
                case 'L':
                    coor[0]++;
                    break;
                
                case 'R':
                    coor[0]--;
                    break;

                case 'U':
                    coor[1]++;
                    break;

                default:
                    coor[1]--;
                    break;
            }
        }

        if (coor[0] == 0 && coor[1] == 0 ) {
            return true;
        } else {
            return false;
        }
    }
}
