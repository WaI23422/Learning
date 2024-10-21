package Medium.Array;

import java.util.Arrays;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/daily-temperatures/">739.Daily Temperatures</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given an array of integers <code>temperatures</code> represents the daily temperatures, return <em>an array</em> <code>answer</code> <em>such that</em> <code>answer[i]</code> <em>is the number of days you have to wait after the</em> <code>i<sup>th</sup></code> <em>day to get a warmer temperature</em>. If there is no future day for which this is possible, keep <code>answer[i] == 0</code> instead.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> temperatures = [73,74,75,71,69,72,76,73]
<strong>Output:</strong> [1,1,4,2,1,1,0,0]
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> temperatures = [30,40,50,60]
<strong>Output:</strong> [1,1,1,0]
</pre><p><strong class="example">Example 3:</strong></p>
<pre><strong>Input:</strong> temperatures = [30,60,90]
<strong>Output:</strong> [1,1,0]
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;=&nbsp;temperatures.length &lt;= 10<sup>5</sup></code></li>
	<li><code>30 &lt;=&nbsp;temperatures[i] &lt;= 100</code></li>
</ul>
</div>
 */
public class DailyTemperatures {
    public static void main(String[] args) {
        int[][] tests = {
            {73,74,75,71,69,72,76,73},
            {30,40,50,60},
            {30,60,90},
        };

        for (int[] test : tests) {
            System.out.println(Arrays.toString(new DailyTemperatures_Solution().dailyTemperatures(test)));
        }
    }
}

// Time Limit Exceeded
class DailyTemperatures_Solution {
    // public int[] dailyTemperatures(int[] temperatures) {
    //     int[] waitArr = new int[temperatures.length];

    //     for (int i = 0; i < temperatures.length; i++) {
    //         waitArr[i] = higherTemp(temperatures, i);
    //     }

    //     return waitArr; 
    // }

    // public int higherTemp(int[] temperature, int at) {
    //     int far = 0;

    //     for (int i = at+1; i < temperature.length; i++) {
    //         if (temperature[i] > temperature[at]) {far++; return far;}
    //         far++;
    //     }

    //     return 0;
    // }

    public int[] dailyTemperatures(int[] temperatures) {
        int[] waitArr = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            for (int j = i+1; j < temperatures.length; j++) {
                if (temperatures[j] > temperatures[i]) {waitArr[i] = j-i; break;}    
            }
        }
        
        return waitArr; 
    }
}