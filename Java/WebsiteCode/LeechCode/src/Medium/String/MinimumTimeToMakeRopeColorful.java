package Medium.String;

import java.util.Arrays;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/minimum-time-to-make-rope-colorful/">1578.Minimum Time to Make Rope Colorful</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>Alice has <code>n</code> balloons arranged on a rope. You are given a <strong>0-indexed</strong> string <code>colors</code> where <code>colors[i]</code> is the color of the <code>i<sup>th</sup></code> balloon.</p>

<p>Alice wants the rope to be <strong>colorful</strong>. She does not want <strong>two consecutive balloons</strong> to be of the same color, so she asks Bob for help. Bob can remove some balloons from the rope to make it <strong>colorful</strong>. You are given a <strong>0-indexed</strong> integer array <code>neededTime</code> where <code>neededTime[i]</code> is the time (in seconds) that Bob needs to remove the <code>i<sup>th</sup></code> balloon from the rope.</p>

<p>Return <em>the <strong>minimum time</strong> Bob needs to make the rope <strong>colorful</strong></em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/12/13/ballon1.jpg" style="width: 404px; height: 243px;">
<pre><strong>Input:</strong> colors = "abaac", neededTime = [1,2,3,4,5]
<strong>Output:</strong> 3
<strong>Explanation:</strong> In the above image, 'a' is blue, 'b' is red, and 'c' is green.
Bob can remove the blue balloon at index 2. This takes 3 seconds.
There are no longer two consecutive balloons of the same color. Total time = 3.</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/12/13/balloon2.jpg" style="width: 244px; height: 243px;">
<pre><strong>Input:</strong> colors = "abc", neededTime = [1,2,3]
<strong>Output:</strong> 0
<strong>Explanation:</strong> The rope is already colorful. Bob does not need to remove any balloons from the rope.
</pre>

<p><strong class="example">Example 3:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/12/13/balloon3.jpg" style="width: 404px; height: 243px;">
<pre><strong>Input:</strong> colors = "aabaa", neededTime = [1,2,3,4,1]
<strong>Output:</strong> 2
<strong>Explanation:</strong> Bob will remove the ballons at indices 0 and 4. Each ballon takes 1 second to remove.
There are no longer two consecutive balloons of the same color. Total time = 1 + 1 = 2.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == colors.length == neededTime.length</code></li>
	<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= neededTime[i] &lt;= 10<sup>4</sup></code></li>
	<li><code>colors</code> contains only lowercase English letters.</li>
</ul>
</div></div>
 */
public class MinimumTimeToMakeRopeColorful {
    public static void main(String[] args) {
        Object[][][] tests = {
            {{"abaac"},{1,2,3,4,5}},
            {{"abc"},{1,2,3}},
            {{"aabaa"},{1,2,3,4,1}},
            {{"aaaaa"},{1,2,3,2,1}},
            {{"aaabbbabbbb"},{3,5,10,7,5,3,5,5,4,8,1}}
        };

        for (Object[][] test : tests) {
            String colors = test[0][0].toString();
            int[] neededTime = Arrays.stream(test[1]).mapToInt(t->(int) t).toArray();

            System.out.println(new MinimumTimeToMakeRopeColorful_Solution().minCost(colors, neededTime));
        }
    }
}

// 5ms 61.06 MB
class MinimumTimeToMakeRopeColorful_Solution {
    public int minCost(String colors, int[] neededTime) {
        if (colors.length() ==1) {return 0;}

        int timeConsume = 0;
        char[] colorsArr = colors.toCharArray();
        
        for (int i = 1; i < colorsArr.length; i++) {
            if (colorsArr[i] != colorsArr[i-1]) {continue;}
            else if (colorsArr[i] == colorsArr[i-1]) {
                timeConsume += Math.min(neededTime[i], neededTime[i-1]);
                neededTime[i] = Math.max(neededTime[i], neededTime[i-1]);
            }
        }

        System.gc(); // 7ms 53.5 MB
        return timeConsume;   
    }
}