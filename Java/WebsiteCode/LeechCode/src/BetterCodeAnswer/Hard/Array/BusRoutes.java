package BetterCodeAnswer.Hard.Array;

import java.util.Arrays;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/bus-routes/">815.Bus Routes</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>You are given an array <code>routes</code> representing bus routes where <code>routes[i]</code> is a bus route that the <code>i<sup>th</sup></code> bus repeats forever.</p>

<ul>
	<li>For example, if <code>routes[0] = [1, 5, 7]</code>, this means that the <code>0<sup>th</sup></code> bus travels in the sequence <code>1 -&gt; 5 -&gt; 7 -&gt; 1 -&gt; 5 -&gt; 7 -&gt; 1 -&gt; ...</code> forever.</li>
</ul>

<p>You will start at the bus stop <code>source</code> (You are not on any bus initially), and you want to go to the bus stop <code>target</code>. You can travel between bus stops by buses only.</p>

<p>Return <em>the least number of buses you must take to travel from </em><code>source</code><em> to </em><code>target</code>. Return <code>-1</code> if it is not possible.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> routes = [[1,2,7],[3,6,7]], source = 1, target = 6
<strong>Output:</strong> 2
<strong>Explanation:</strong> The best strategy is take the first bus to the bus stop 7, then take the second bus to the bus stop 6.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> routes = [[7,12],[4,5,15],[6],[15,19],[9,12,13]], source = 15, target = 12
<strong>Output:</strong> -1
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= routes.length &lt;= 500</code>.</li>
	<li><code>1 &lt;= routes[i].length &lt;= 10<sup>5</sup></code></li>
	<li>All the values of <code>routes[i]</code> are <strong>unique</strong>.</li>
	<li><code>sum(routes[i].length) &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= routes[i][j] &lt; 10<sup>6</sup></code></li>
	<li><code>0 &lt;= source, target &lt; 10<sup>6</sup></code></li>
</ul>
</div></div>
 */
public class BusRoutes {
    public static void main(String[] args) {
        int[][][][] tests = {
            {{{1,2,7},{3,6,7}},{{1},{6}}},
        };

        BusRoutes_Solution res = new BusRoutes_Solution();

        for (int[][][] test : tests) {
            int[][] routes = test[0];
            int source = test[1][0][0], target = test[1][1][0];

            System.out.println(res.numBusesToDestination(routes, source, target));
        }
    }
}

/**
 * <h1 id="complexity">Complexity</h1>
 * <p>The problem involves finding the least number of buses one must take to travel from a source bus stop to a target bus stop. Each bus travels in a repeating sequence, and you can only travel between bus stops using buses. The task is to determine the minimum number of bus rides needed to reach the target bus stop from the source bus stop.</p>
 * <h1 id="approach">Approach</h1>
 * 
 * <ol>
<li>
<p>First, identify the maximum bus stop number (<code>maxStop</code>) across all routes. If <code>maxStop</code> is less than the target bus stop, it means there is no route to reach the target, and we return -1.</p>
</li>
<li>
<p>Initialize an array <code>minBusesToReach</code>, where <code>minBusesToReach[i]</code> represents the minimum number of buses needed to reach bus stop <code>i</code> from the source. Initialize this array with a value greater than the total number of routes.</p>
</li>
<li>
<p>Use a loop to iteratively update the <code>minBusesToReach</code> array. For each route, find the minimum value in <code>minBusesToReach</code> for the stops in that route and increment it by 1. Update the <code>minBusesToReach</code> array if a smaller number of buses is found.</p>
</li>
<li>
<p>Continue this process until no further updates can be made to <code>minBusesToReach</code>. The final value at <code>minBusesToReach[target]</code> will represent the minimum number of buses needed to reach the target from the source.</p>
</li>
<li>
<p>Return the result: <code>minBusesToReach[target]</code> if it is less than the total number of routes, otherwise, return -1.</p>
</li>
</ol>

 */
class BusRoutes_Solution {
    // 3 ms 53.9 MB
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        int maxStop = -1;
        for (int[] route : routes) {
            for (int stop : route) {
                maxStop = Math.max(maxStop, stop);
            }
        }
        if (maxStop < target) {
            return -1;
        }
        int n = routes.length;
        int[] minBusesToReach = new int[maxStop + 1];
        Arrays.fill(minBusesToReach, n + 1);
        minBusesToReach[source] = 0;
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int[] route : routes) {
                int min = n + 1;
                for (int stop : route) {
                    min = Math.min(min, minBusesToReach[stop]);
                }
                min++;
                for (int stop : route) {
                    if (minBusesToReach[stop] > min) {
                        minBusesToReach[stop] = min;
                        flag = true;
                    }
                }
            }
            
        }
        return (minBusesToReach[target] < n + 1 ? minBusesToReach[target] : -1);
    }
}
