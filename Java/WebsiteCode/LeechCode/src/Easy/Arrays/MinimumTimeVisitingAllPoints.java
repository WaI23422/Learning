package Easy.Arrays;


/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/minimum-time-visiting-all-points/">1266.Minimum Time Visiting All Points</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>On a 2D plane, there are <code>n</code> points with integer coordinates <code>points[i] = [x<sub>i</sub>, y<sub>i</sub>]</code>. Return <em>the <strong>minimum time</strong> in seconds to visit all the points in the order given by </em><code>points</code>.</p>

<p>You can move according to these rules:</p>

<ul>
	<li>In <code>1</code> second, you can either:

	<ul>
		<li>move vertically by one&nbsp;unit,</li>
		<li>move horizontally by one unit, or</li>
		<li>move diagonally <code>sqrt(2)</code> units (in other words, move one unit vertically then one unit horizontally in <code>1</code> second).</li>
	</ul>
	</li>
	<li>You have to visit the points in the same order as they appear in the array.</li>
	<li>You are allowed to pass through points that appear later in the order, but these do not count as visits.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2019/11/14/1626_example_1.PNG" style="width: 500px; height: 428px;">
<pre><strong>Input:</strong> points = [[1,1],[3,4],[-1,0]]
<strong>Output:</strong> 7
<strong>Explanation: </strong>One optimal path is <strong>[1,1]</strong> -&gt; [2,2] -&gt; [3,3] -&gt; <strong>[3,4] </strong>-&gt; [2,3] -&gt; [1,2] -&gt; [0,1] -&gt; <strong>[-1,0]</strong>   
Time from [1,1] to [3,4] = 3 seconds 
Time from [3,4] to [-1,0] = 4 seconds
Total time = 7 seconds</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> points = [[3,2],[-2,2]]
<strong>Output:</strong> 5
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>points.length == n</code></li>
	<li><code>1 &lt;= n&nbsp;&lt;= 100</code></li>
	<li><code>points[i].length == 2</code></li>
	<li><code>-1000&nbsp;&lt;= points[i][0], points[i][1]&nbsp;&lt;= 1000</code></li>
</ul>
</div></div>
 */
public class MinimumTimeVisitingAllPoints {
    public static void main(String[] args) {
        int[][][] tests = {
            {{1,1},{3,4},{-1,0}},
            {{3,2},{-2,2}}
        };

        for (int[][] points : tests) {
            System.out.println(new MinimumTimeVisitingAllPoints_Solution().minTimeToVisitAllPoints(points));
        }
    }
}

class MinimumTimeVisitingAllPoints_Solution {
    // 1 ms 43.4 MB
    public int minTimeToVisitAllPoints(int[][] points) {
        int distance = 0;

        for (int i = 1; i < points.length; i++) {
            distance += Math.max(Math.abs(points[i][0] - points[i-1][0]), Math.abs(points[i][1] - points[i-1][1]));
        }

        return distance;
    }
}

class MinimumTimeVisitingAllPoints_Solution2 {
    // 1 ms 43.5 MB
    public int minTimeToVisitAllPoints(int[][] points) {
        int distance = 0, coorX, coorY;

        for (int i = 1; i < points.length; i++) {
            coorX  = Math.abs(points[i][0] - points[i-1][0]);
            coorY =  Math.abs(points[i][1] - points[i-1][1]);
            if ( coorX < coorY) {distance += coorY;} 
            else { distance+= coorX; } 
        }

        System.gc(); // 3 ms 41.5 MB
        return distance;
    }
}

class MinimumTimeVisitingAllPoints_Solution3 {
    // 1 ms 43.7 MB
    public int minTimeToVisitAllPoints(int[][] points) {
        int distance = 0, coorX, coorY;
        int[] pointA = points[0], pointB; 

        for (int i = 1; i < points.length; i++) {
            pointB = points[i];
            
            coorX = Math.abs(pointA[0] - pointB[0]);
            coorY = Math.abs(pointA[1] - pointB[1]);

            if (coorX < coorY) {distance += coorY;} 
            else { distance+= coorX; } 

            pointA = pointB;
        }

        return distance;
    }
}