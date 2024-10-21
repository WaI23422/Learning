package BetterCodeAnswer.Easy.Arrays;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/min-cost-climbing-stairs/">746.Min Cost Climbing Stairs</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>You are given an integer array <code>cost</code> where <code>cost[i]</code> is the cost of <code>i<sup>th</sup></code> step on a staircase. Once you pay the cost, you can either climb one or two steps.</p>

<p>You can either start from the step with index <code>0</code>, or the step with index <code>1</code>.</p>

<p>Return <em>the minimum cost to reach the top of the floor</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> cost = [10,<u>15</u>,20]
<strong>Output:</strong> 15
<strong>Explanation:</strong> You will start at index 1.
- Pay 15 and climb two steps to reach the top.
The total cost is 15.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> cost = [<u>1</u>,100,<u>1</u>,1,<u>1</u>,100,<u>1</u>,<u>1</u>,100,<u>1</u>]
<strong>Output:</strong> 6
<strong>Explanation:</strong> You will start at index 0.
- Pay 1 and climb two steps to reach index 2.
- Pay 1 and climb two steps to reach index 4.
- Pay 1 and climb two steps to reach index 6.
- Pay 1 and climb one step to reach index 7.
- Pay 1 and climb two steps to reach index 9.
- Pay 1 and climb one step to reach the top.
The total cost is 6.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= cost.length &lt;= 1000</code></li>
	<li><code>0 &lt;= cost[i] &lt;= 999</code></li>
</ul>
</div></div>
 */
public class MinCostClimbingStairs {
    public static void main(String[] args) {
        int[] cost = {1,100,1,1,1,100,1,1,100,1};

        MinCostClimbingStairs_Solution result = new MinCostClimbingStairs_Solution();

        System.out.println(result.minCostClimbingStairs(cost));
    }
}

class MinCostClimbingStairs_Solution {
    // 0 ms
    // 43 MB
    public int minCostClimbingStairs(int[] cost) {
        for(int i = 2; i<cost.length; i++){
            cost[i] +=Math.min(cost[i-1], cost[i-2]);
        }
        return Math.min(cost[cost.length-1],cost[cost.length-2]);
    }
}

class MinCostClimbingStairs_Solution_Solution2 {
    public int minCostClimbingStairs(int[] cost) {
        int step1=0;
        int step2=0;

        for(int i= cost.length-1;i>=0;i--){
            int current_step = cost[i]+ Math.min(step1,step2);
            step1=step2;
            step2=current_step;

        }
        
        System.gc();
        return Math.min(step1,step2);

    }
}