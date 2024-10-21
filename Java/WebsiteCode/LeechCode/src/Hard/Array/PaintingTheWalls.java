package Hard.Array;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/painting-the-walls/">2742.Painting the Walls</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>You are given two <strong>0-indexed</strong> integer arrays,&nbsp;<code>cost</code> and <code>time</code>, of size <code>n</code> representing the costs and the time taken to paint <code>n</code> different walls respectively. There are two painters available:</p>

<ul>
	<li>A<strong>&nbsp;paid painter</strong>&nbsp;that paints the <code>i<sup>th</sup></code> wall in <code>time[i]</code> units of time and takes <code>cost[i]</code> units of money.</li>
	<li>A<strong>&nbsp;free painter</strong> that paints&nbsp;<strong>any</strong> wall in <code>1</code> unit of time at a cost of <code>0</code>. But the&nbsp;free painter can only be used if the paid painter is already <strong>occupied</strong>.</li>
</ul>

<p>Return <em>the minimum amount of money required to paint the </em><code>n</code><em>&nbsp;walls.</em></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> cost = [1,2,3,2], time = [1,2,3,2]
<strong>Output:</strong> 3
<strong>Explanation:</strong> The walls at index 0 and 1 will be painted by the paid painter, and it will take 3 units of time; meanwhile, the free painter will paint the walls at index 2 and 3, free of cost in 2 units of time. Thus, the total cost is 1 + 2 = 3.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> cost = [2,3,4,2], time = [1,1,1,1]
<strong>Output:</strong> 4
<strong>Explanation:</strong> The walls at index 0 and 3 will be painted by the paid painter, and it will take 2 units of time; meanwhile, the free painter will paint the walls at index 1 and 2, free of cost in 2 units of time. Thus, the total cost is 2 + 2 = 4.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= cost.length &lt;= 500</code></li>
	<li><code>cost.length == time.length</code></li>
	<li><code>1 &lt;= cost[i] &lt;= 10<sup>6</sup></code></li>
	<li><code>1 &lt;= time[i] &lt;= 500</code></li>
</ul>
</div></div>
 */
public class PaintingTheWalls {
    public static void main(String[] args) {
        int[] cost = {1,3,2,2};
        int[] time = {1,3,0,1};
        PaintingTheWalls_Solution result = new PaintingTheWalls_Solution();

        System.out.println(result.paintWalls(cost, time));
    }
}

class PaintingTheWalls_Solution {
    // 58 ms 
    // 57.3 MB
    public int paintWalls(int[] cost, int[] time) {
        int n=cost.length;
        return (int)paintWallsHelper(cost,time,0,0,new Long[n][501]);
    }
    
    private long paintWallsHelper(int[] cost, int[] time, int index, int total, Long[][] memo) {
        if(total >= cost.length)
            return 0;
        if(index >= cost.length)
            return Integer.MAX_VALUE;
        if(memo[index][total] != null)
            return memo[index][total];
        
        long with=cost[index] + paintWallsHelper(cost,time,index+1,total+time[index]+1,memo);
        long without=paintWallsHelper(cost,time,index+1,total,memo);
        return memo[index][total]=Math.min(with,without);
    }
}
