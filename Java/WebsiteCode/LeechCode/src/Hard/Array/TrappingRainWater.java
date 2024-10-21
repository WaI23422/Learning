package Hard.Array;

import java.util.Arrays;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/trapping-rain-water/">42. Trapping Rain Water</a>
 * <div class="elfjS" data-track-load="description_content"><p>Given <code>n</code> non-negative integers representing an elevation map where the width of each bar is <code>1</code>, compute how much water it can trap after raining.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img src="https://assets.leetcode.com/uploads/2018/10/22/rainwatertrap.png" style="width: 412px; height: 161px;">
<pre><strong>Input:</strong> height = [0,1,0,2,1,0,1,3,2,1,2,1]
<strong>Output:</strong> 6
<strong>Explanation:</strong> The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> height = [4,2,0,3,2,5]
<strong>Output:</strong> 9
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == height.length</code></li>
	<li><code>1 &lt;= n &lt;= 2 * 10<sup>4</sup></code></li>
	<li><code>0 &lt;= height[i] &lt;= 10<sup>5</sup></code></li>
</ul>
</div>
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        int[][] tests = {
            {0,2,8,2,9,7,4},
            {4,2,3},
            {5,2,0,3,2,4},
            {0,1,0,2,1,0,1,3,2,1,2,1},
            {4,2,0,3,2,5},
            {4,3,5},
            {4},
            {4,5},
            {2,0,2},
            {5,5,1,7,1,1,5,2,7,6},
        };

        for (int[] height : tests) {
            System.out.println(new TrappingRainWater_Solution().trap(height));
        }
    }
}

// 1 ms 46.2 MB
class TrappingRainWater_Solution {
    public int trap(int[] height) {
        int low = 0, 
            high = 1,
            len = height.length,
            inx = 1,
            last = 0,
            total = 0;
        boolean reverseCheck = true;
        
        int[] fromLeft = new int[len];
        Arrays.fill(fromLeft, -1);
        fromLeft[0]= 0;
        while (high < len) {
            if (height[low] <= height[high]) {
                if (high == len-1) {reverseCheck = false;}
                fromLeft[inx++] = high;
                last = high;
                low = high;
                high++;
            } else {
                high++;
            }
        }

        for (int i = 0; i < len-1; i++) {
            int from = fromLeft[i], to = fromLeft[i+1];
            if (from == -1 || to == -1) {break;}
            if (to - from == 1) {continue;}

            int minHeight = Math.min(height[from], height[to]);

            for (int j = from+1; j < to; j++) {
                total += minHeight-height[j];
            }
        }

        if (reverseCheck) {
            low = len-1; 
            high = len-2;
            fromLeft[len-1] = len-1;
            inx = len-2;
            while (high >= last) {
                if (height[low] <= height[high]) {
                    fromLeft[inx--] = high;
                    low = high;
                    high--;
                } else {
                    high--;
                }
            }

            for (int i = len-1; i > 0; i--) {
                int from = fromLeft[i], to = fromLeft[i-1];
                if (from == -1 || to == -1 || from == last) {break;}
                if (from - to == 1) {continue;}
    
                int minHeight = Math.min(height[from], height[to]);
    
                for (int j = from-1; j > to; j--) {
                    total += minHeight-height[j];
                }
            }
        }

        return total;
    }
}