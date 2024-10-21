package BetterCodeAnswer.Medium.Array;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

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

// 24 ms 61.5 MB
class DailyTemperatures_Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> deque = new ArrayDeque<>();
        
        int[] res = new int[temperatures.length];

        for (int i = temperatures.length - 1; i >= 0; --i) {
            if (deque.isEmpty()) {
                deque.offerFirst(i);
                res[i] = 0;
            } else {
                while (!deque.isEmpty() && temperatures[i] >= temperatures[deque.peekFirst()]) {
                    deque.pollFirst();
                }

                if (deque.isEmpty()) {
                    res[i] = 0;
                } else {
                    res[i] = deque.peekFirst() - i;
                }

                deque.offerFirst(i);
            }
        }

        return res;
    }
}

// 6 ms 60.5 MB
class DailyTemperatures_Solution2 {
    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;
        
        int hottest = 0;
        
        int answer[] = new int[n];
        
        for (int currDay = n - 1; currDay >= 0; currDay--) {

            int currentTemp = temperatures[currDay];

            // hottest temp seen so far moving from the right
            if (currentTemp >= hottest) {
                hottest = currentTemp;
                continue;
            }
            
            int days = 1;

            while (temperatures[currDay + days] <= currentTemp) {
                // Use information from answer to search for the next warmer day
                days += answer[currDay + days];
            }

            answer[currDay] = days;
        }
        
        return answer;
    }
}