package BetterCodeAnswer.Easy.Arrays;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/check-if-it-is-a-straight-line/">1232.Check If It Is a Straight Line</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You are given an array&nbsp;<code>coordinates</code>, <code>coordinates[i] = [x, y]</code>, where <code>[x, y]</code> represents the coordinate of a point. Check if these points&nbsp;make a straight line in the XY plane.</p>

<p>&nbsp;</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2019/10/15/untitled-diagram-2.jpg" style="width: 336px; height: 336px;"></p>

<pre><strong>Input:</strong> coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
<strong>Output:</strong> true
</pre>

<p><strong class="example">Example 2:</strong></p>

<p><strong><img alt="" src="https://assets.leetcode.com/uploads/2019/10/09/untitled-diagram-1.jpg" style="width: 348px; height: 336px;"></strong></p>

<pre><strong>Input:</strong> coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
<strong>Output:</strong> false
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;=&nbsp;coordinates.length &lt;= 1000</code></li>
	<li><code>coordinates[i].length == 2</code></li>
	<li><code>-10^4 &lt;=&nbsp;coordinates[i][0],&nbsp;coordinates[i][1] &lt;= 10^4</code></li>
	<li><code>coordinates</code>&nbsp;contains no duplicate point.</li>
</ul>
</div>
 */
public class CheckIfItIsAStraightLine {
    public static void main(String[] args) {
        int[][][] tests = {
            {{0,0},{0,1},{0,-1}},
            {{1,2},{2,3},{3,5}},
            {{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}},
            {{1,1},{2,2},{3,4},{4,5},{5,6},{7,7}},
        };

        for (int[][] coordinate : tests) {
            System.out.println(new CheckIfItIsAStraightLine_Solution().checkStraightLine(coordinate));
        }
    }   
}

// 0 ms 43.4 MB
class CheckIfItIsAStraightLine_Solution {
    public boolean checkStraightLine(int[][] c) {
       int m=1;
        float k=0;
        try {
            m = (c[0][1] - c[1][1]) / (c[0][0] - c[1][0]);
            if(Math.abs((c[0][0] - c[1][0]))>Math.abs(c[0][1] - c[1][1])){
                k=(float)(c[0][1] - c[1][1]) / (c[0][0] - c[1][0]);
            }
        }
        catch (Exception e){
            for(int i=0;i<c.length-1;i++){
                if(c[i][0]!=c[i+1][0]){
                    return false;
                }
            }
            return true;
        }
        for(int i=0;i<c.length;i++){
            if(k!=0){
                if((float)(c[i][1]-c[0][1])!=k*(float)(c[i][0]-c[0][0])){
                    return false;
                }
            }
            if((c[i][1]-c[0][1])!=m*(c[i][0]-c[0][0]) && k==0){
                return false;
            }
        }
        return true;
    }
}