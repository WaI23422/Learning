package BetterCodeAnswer.Medium.Array;

import java.util.Arrays;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/minimum-number-of-arrows-to-burst-balloons/">452. Minimum Number of Arrows to Burst Balloons</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>There are some spherical balloons taped onto a flat wall that represents the XY-plane. The balloons are represented as a 2D integer array <code>points</code> where <code>points[i] = [x<sub>start</sub>, x<sub>end</sub>]</code> denotes a balloon whose <strong>horizontal diameter</strong> stretches between <code>x<sub>start</sub></code> and <code>x<sub>end</sub></code>. You do not know the exact y-coordinates of the balloons.</p>

<p>Arrows can be shot up <strong>directly vertically</strong> (in the positive y-direction) from different points along the x-axis. A balloon with <code>x<sub>start</sub></code> and <code>x<sub>end</sub></code> is <strong>burst</strong> by an arrow shot at <code>x</code> if <code>x<sub>start</sub> &lt;= x &lt;= x<sub>end</sub></code>. There is <strong>no limit</strong> to the number of arrows that can be shot. A shot arrow keeps traveling up infinitely, bursting any balloons in its path.</p>

<p>Given the array <code>points</code>, return <em>the <strong>minimum</strong> number of arrows that must be shot to burst all balloons</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> points = [[10,16],[2,8],[1,6],[7,12]]
<strong>Output:</strong> 2
<strong>Explanation:</strong> The balloons can be burst by 2 arrows:
- Shoot an arrow at x = 6, bursting the balloons [2,8] and [1,6].
- Shoot an arrow at x = 11, bursting the balloons [10,16] and [7,12].
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> points = [[1,2],[3,4],[5,6],[7,8]]
<strong>Output:</strong> 4
<strong>Explanation:</strong> One arrow needs to be shot for each balloon for a total of 4 arrows.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> points = [[1,2],[2,3],[3,4],[4,5]]
<strong>Output:</strong> 2
<strong>Explanation:</strong> The balloons can be burst by 2 arrows:
- Shoot an arrow at x = 2, bursting the balloons [1,2] and [2,3].
- Shoot an arrow at x = 4, bursting the balloons [3,4] and [4,5].
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= points.length &lt;= 10<sup>5</sup></code></li>
	<li><code>points[i].length == 2</code></li>
	<li><code>-2<sup>31</sup> &lt;= x<sub>start</sub> &lt; x<sub>end</sub> &lt;= 2<sup>31</sup> - 1</code></li>
</ul>
</div>
 */
public class MinimumNumberOfArrowsToBurstBalloons {
    public static void main(String[] args) {
        int[][][] tests = {
            {{10,16},{2,8},{1,6},{7,12}},
            {{-19,57},{-40,-5}},
            {{1,2},{2,3},{3,4},{4,5}}
        };

        for (int[][] points : tests) {
            System.out.println(new MinimumNumberOfArrowsToBurstBalloons_Solution().findMinArrowShots(points));
        }
    }
}

// 20 ms 78.5MB
class MinimumNumberOfArrowsToBurstBalloons_Solution {
    public int findMinArrowShots(int[][] points) {
        long[] A = new long[points.length];
        for(int i=0; i < points.length; i++){
            A[i] = (((long)points[i][1]) << 32) | (points[i][0] & 0xFFFFFFFFL);
        }
        Arrays.sort(A);
        int prev = (int)(A[0] >>> 32);
        int count = 1;
        for(int i=1; i< A.length; i++){
            if((int)A[i] > prev){
                count++;
                prev = (int)(A[i] >>> 32);
            }
        }
        return count;
    }
}

// 28 ms 74.4 MB
class MinimumNumberOfArrowsToBurstBalloons_Solution2 {
    static void quicksort(int[][] points,int low,int high){
        if(low<high){
            int i=low;
            int j=high;
            int mid=(low+high)/2;
            int pivot=points[mid][1];
            while(true){

                while(points[i][1]<pivot){i++;}
                while(points[j][1]>pivot){j--;}
                if(i>=j){break;}

                int[] temp=points[i];
                points[i]=points[j];
                points[j]=temp;
                i++;
                j--;
            }
            quicksort(points,low,j);
            quicksort(points,j+1,high);
        }
    }

    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {return 0;}
        quicksort(points, 0, points.length - 1);

        int cnt = 0;
        int prevEnd = Integer.MAX_VALUE;

        for (int i = 0; i < points.length; ++i) {
            int[] curr = points[i];
            int currStart = curr[0];
            int currEnd = curr[1];
            if (currStart <= prevEnd) {
                prevEnd = Math.min(currEnd, prevEnd);
            } else {
                ++cnt;
                prevEnd = currEnd;
            }
        }

        return cnt + 1;
    }
}