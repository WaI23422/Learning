package Hard.Array;

import java.util.Arrays;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/minimum-difficulty-of-a-job-schedule/">1335.Minimum Difficulty of a Job Schedule</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>You want to schedule a list of jobs in <code>d</code> days. Jobs are dependent (i.e To work on the <code>i<sup>th</sup></code> job, you have to finish all the jobs <code>j</code> where <code>0 &lt;= j &lt; i</code>).</p>

<p>You have to finish <strong>at least</strong> one task every day. The difficulty of a job schedule is the sum of difficulties of each day of the <code>d</code> days. The difficulty of a day is the maximum difficulty of a job done on that day.</p>

<p>You are given an integer array <code>jobDifficulty</code> and an integer <code>d</code>. The difficulty of the <code>i<sup>th</sup></code> job is <code>jobDifficulty[i]</code>.</p>

<p>Return <em>the minimum difficulty of a job schedule</em>. If you cannot find a schedule for the jobs return <code>-1</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/01/16/untitled.png" style="width: 365px; height: 370px;">
<pre><strong>Input:</strong> jobDifficulty = [6,5,4,3,2,1], d = 2
<strong>Output:</strong> 7
<strong>Explanation:</strong> First day you can finish the first 5 jobs, total difficulty = 6.
Second day you can finish the last job, total difficulty = 1.
The difficulty of the schedule = 6 + 1 = 7 
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> jobDifficulty = [9,9,9], d = 4
<strong>Output:</strong> -1
<strong>Explanation:</strong> If you finish a job per day you will still have a free day. you cannot find a schedule for the given jobs.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> jobDifficulty = [1,1,1], d = 3
<strong>Output:</strong> 3
<strong>Explanation:</strong> The schedule is one job per day. total difficulty will be 3.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= jobDifficulty.length &lt;= 300</code></li>
	<li><code>0 &lt;= jobDifficulty[i] &lt;= 1000</code></li>
	<li><code>1 &lt;= d &lt;= 10</code></li>
</ul>
</div></div>
 */
public class MinimumDifficultyOfAJobSchedule {
    public static void main(String[] args) {
        int[][][] tests = {
            {{6,5,4,3,2,1},{2}},
            {{9,9,9},{4}},
            {{1,1,1},{3}},
            {{11,111,22,222,33,333,44,444},{6}}
        };   

        for (int[][] test : tests) {
            int[] jobDifficulty = test[0];
            int d = test[1][0];

            System.out.println(new MinimumDifficultyOfAJobSchedule_Solution().minDifficulty(jobDifficulty, d));
        }
    }
}

// Wrong @see BetterCodeAnswer.Hard.Array.MinimumDifficultyOfAJobSchedule.java
class MinimumDifficultyOfAJobSchedule_Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        if (d > jobDifficulty.length) {return -1;}
        
        int minDifficulty = 0, jobLength = jobDifficulty.length;

        Arrays.sort(jobDifficulty);

        minDifficulty += jobDifficulty[jobLength-1];
        for (int i = 0; i < d-1; i++) {minDifficulty += jobDifficulty[i];}

        return minDifficulty;
    }
}