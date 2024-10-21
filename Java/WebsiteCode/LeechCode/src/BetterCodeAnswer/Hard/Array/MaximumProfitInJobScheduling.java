package BetterCodeAnswer.Hard.Array;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumProfitInJobScheduling {
    public static void main(String[] args) {
        int[][][] tests = {
            {{1,2,3,3},{3,4,5,6},{50,10,40,70}},
            {{1,2,3,4,6},{3,5,10,6,9},{20,20,100,70,60}},
            {{1,1,1},{2,3,4},{5,6,4}},
        };

        for (int[][] test : tests) {
            int[] startTime = test[0], endTime = test[1], profit = test[2];

            System.out.println(new MaximumProfitInJobScheduling_Solution().jobScheduling(startTime, endTime, profit));
        }
    }
}

// 24 ms 56.6 MB
/**
 * <h1 id="approach">Approach:</h1>
 * <p>The implementation of this problem utilizes a sorted list, binary search, and dynamic programming to calculate the maximum profit for scheduling non-overlapping jobs. Each step of the approach is essential for the efficiency and correctness of the solution:</p>
 * <ol>
<li>
<p><strong>Sorting Jobs</strong>: First, we pair each job's endTime, startTime, and profit together and sort these pairs based on their endTime. This is done to consider jobs by the order they finish. The sorting is achieved through the sorted function, which sorts the zipped lists of end times, start times, and profits.</p>
<div class="mb-6 rounded-lg px-3 py-2.5 font-menlo text-sm bg-fill-3 dark:bg-dark-fill-3"><div class="group relative" translate="no"><pre style="color: black; font-size: 13px; text-shadow: none; font-family: Menlo, Monaco, Consolas; text-align: left; white-space: pre; word-spacing: normal; word-break: normal; line-height: 1.5; tab-size: 4; hyphens: none; padding: 0px; margin: 0px; overflow: auto; background: transparent; overflow-wrap: normal;"><code class="language-python" style="text-shadow: none; white-space: pre;"><span><span>jobs </span><span class="token" style="color: rgb(154, 110, 58); background: rgba(255, 255, 255, 0.5);">=</span><span> </span><span class="token" style="color: rgb(102, 153, 0);">sorted</span><span class="token" style="color: rgb(153, 153, 153);">(</span><span class="token" style="color: rgb(102, 153, 0);">zip</span><span class="token" style="color: rgb(153, 153, 153);">(</span><span>endTime</span><span class="token" style="color: rgb(153, 153, 153);">,</span><span> startTime</span><span class="token" style="color: rgb(153, 153, 153);">,</span><span> profit</span><span class="token" style="color: rgb(153, 153, 153);">)</span><span class="token" style="color: rgb(153, 153, 153);">)</span></span></code></pre><div class="h-4 w-4 cursor-pointer fill-gray-6 hover:fill-gray-7 dark:fill-dark-gray-6 dark:hover:fill-dark-gray-7 absolute right-0 top-0" data-state="closed"><div><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="1em" height="1em" fill="currentColor" class="h-4 w-4 text-gray-6 hover:text-gray-7 dark:text-dark-gray-6 dark:hover:text-dark-gray-7 hidden group-hover:block"><path fill-rule="evenodd" d="M11.3 8.3H19a3 3 0 013 3V19a3 3 0 01-3 3h-7.7a3 3 0 01-3-3v-7.7a3 3 0 013-3zm0 2a1 1 0 00-1 1V19a1 1 0 001 1H19a1 1 0 001-1v-7.7a1 1 0 00-1-1h-7.7zm-5.6 3.4a1 1 0 110 2h-.9A2.8 2.8 0 012 12.9V4.8A2.8 2.8 0 014.8 2h8.1a2.8 2.8 0 012.8 2.8v.9a1 1 0 11-2 0v-.9a.8.8 0 00-.8-.8H4.8a.8.8 0 00-.8.8v8.1a.8.8 0 00.8.8h.9z" clip-rule="evenodd"></path></svg></div></div></div></div>
</li>
<li>
<p><strong>Dynamic Programming Table (dp)</strong>: We define a DP table dp of size n+1, where n is the number of jobs to store the maximum profit up to each job. We initialize this table with zeros.</p>
<div class="mb-6 rounded-lg px-3 py-2.5 font-menlo text-sm bg-fill-3 dark:bg-dark-fill-3"><div class="group relative" translate="no"><pre style="color: black; font-size: 13px; text-shadow: none; font-family: Menlo, Monaco, Consolas; text-align: left; white-space: pre; word-spacing: normal; word-break: normal; line-height: 1.5; tab-size: 4; hyphens: none; padding: 0px; margin: 0px; overflow: auto; background: transparent; overflow-wrap: normal;"><code style="text-shadow: none; white-space: pre;"><span><span>dp = [0] * (n + 1)</span></span></code></pre><div class="h-4 w-4 cursor-pointer fill-gray-6 hover:fill-gray-7 dark:fill-dark-gray-6 dark:hover:fill-dark-gray-7 absolute right-0 top-0" data-state="closed"><div><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="1em" height="1em" fill="currentColor" class="h-4 w-4 text-gray-6 hover:text-gray-7 dark:text-dark-gray-6 dark:hover:text-dark-gray-7 hidden group-hover:block"><path fill-rule="evenodd" d="M11.3 8.3H19a3 3 0 013 3V19a3 3 0 01-3 3h-7.7a3 3 0 01-3-3v-7.7a3 3 0 013-3zm0 2a1 1 0 00-1 1V19a1 1 0 001 1H19a1 1 0 001-1v-7.7a1 1 0 00-1-1h-7.7zm-5.6 3.4a1 1 0 110 2h-.9A2.8 2.8 0 012 12.9V4.8A2.8 2.8 0 014.8 2h8.1a2.8 2.8 0 012.8 2.8v.9a1 1 0 11-2 0v-.9a.8.8 0 00-.8-.8H4.8a.8.8 0 00-.8.8v8.1a.8.8 0 00.8.8h.9z" clip-rule="evenodd"></path></svg></div></div></div></div>
</li>
<li>
<p><strong>Binary Search</strong> : For each job, we need to find the closest job that finished before the current job's start. This is where bisect_right from the bisect module is used. It performs a binary search to find the insertion point of the current job’s start time in the sorted jobs array to ensure no overlap.</p>
<div class="mb-6 rounded-lg px-3 py-2.5 font-menlo text-sm bg-fill-3 dark:bg-dark-fill-3"><div class="group relative" translate="no"><pre style="color: black; font-size: 13px; text-shadow: none; font-family: Menlo, Monaco, Consolas; text-align: left; white-space: pre; word-spacing: normal; word-break: normal; line-height: 1.5; tab-size: 4; hyphens: none; padding: 0px; margin: 0px; overflow: auto; background: transparent; overflow-wrap: normal;"><code class="language-python" style="text-shadow: none; white-space: pre;"><span><span>j </span><span class="token" style="color: rgb(154, 110, 58); background: rgba(255, 255, 255, 0.5);">=</span><span> bisect_right</span><span class="token" style="color: rgb(153, 153, 153);">(</span><span>jobs</span><span class="token" style="color: rgb(153, 153, 153);">,</span><span> s</span><span class="token" style="color: rgb(153, 153, 153);">,</span><span> hi</span><span class="token" style="color: rgb(154, 110, 58); background: rgba(255, 255, 255, 0.5);">=</span><span>i</span><span class="token" style="color: rgb(153, 153, 153);">,</span><span> key</span><span class="token" style="color: rgb(154, 110, 58); background: rgba(255, 255, 255, 0.5);">=</span><span class="token" style="color: rgb(0, 119, 170);">lambda</span><span> x</span><span class="token" style="color: rgb(153, 153, 153);">:</span><span> x</span><span class="token" style="color: rgb(153, 153, 153);">[</span><span class="token" style="color: rgb(153, 0, 85);">0</span><span class="token" style="color: rgb(153, 153, 153);">]</span><span class="token" style="color: rgb(153, 153, 153);">)</span></span></code></pre><div class="h-4 w-4 cursor-pointer fill-gray-6 hover:fill-gray-7 dark:fill-dark-gray-6 dark:hover:fill-dark-gray-7 absolute right-0 top-0" data-state="closed"><div><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="1em" height="1em" fill="currentColor" class="h-4 w-4 text-gray-6 hover:text-gray-7 dark:text-dark-gray-6 dark:hover:text-dark-gray-7 hidden group-hover:block"><path fill-rule="evenodd" d="M11.3 8.3H19a3 3 0 013 3V19a3 3 0 01-3 3h-7.7a3 3 0 01-3-3v-7.7a3 3 0 013-3zm0 2a1 1 0 00-1 1V19a1 1 0 001 1H19a1 1 0 001-1v-7.7a1 1 0 00-1-1h-7.7zm-5.6 3.4a1 1 0 110 2h-.9A2.8 2.8 0 012 12.9V4.8A2.8 2.8 0 014.8 2h8.1a2.8 2.8 0 012.8 2.8v.9a1 1 0 11-2 0v-.9a.8.8 0 00-.8-.8H4.8a.8.8 0 00-.8.8v8.1a.8.8 0 00.8.8h.9z" clip-rule="evenodd"></path></svg></div></div></div></div>
<p>The callback lambda x: x[0] is used to ensure the search operates on the endTime of the jobs. j is the index where the job can be inserted without conflict, so dp[j] corresponds to the maximum profit up to the job that finishes right before the current job can start.</p>
</li>
<li>
<p><strong>Profit Calculation</strong> : For every job at index i, we perform a calculation to determine the maximum profit including the current job versus excluding it. To include the current job, we take the profit of the current job p and add it to the profit accumulated until the closest non-conflicting job, which is dp[j]. If this sum is greater than the maximum profit without the current job dp[i], we update our dp at i+1 with this larger value; else, we carry over the maximum profit without the current job.</p>
<div class="mb-6 rounded-lg px-3 py-2.5 font-menlo text-sm bg-fill-3 dark:bg-dark-fill-3"><div class="group relative" translate="no"><pre style="color: black; font-size: 13px; text-shadow: none; font-family: Menlo, Monaco, Consolas; text-align: left; white-space: pre; word-spacing: normal; word-break: normal; line-height: 1.5; tab-size: 4; hyphens: none; padding: 0px; margin: 0px; overflow: auto; background: transparent; overflow-wrap: normal;"><code class="language-python" style="text-shadow: none; white-space: pre;"><span><span>dp</span><span class="token" style="color: rgb(153, 153, 153);">[</span><span>i </span><span class="token" style="color: rgb(154, 110, 58); background: rgba(255, 255, 255, 0.5);">+</span><span> </span><span class="token" style="color: rgb(153, 0, 85);">1</span><span class="token" style="color: rgb(153, 153, 153);">]</span><span> </span><span class="token" style="color: rgb(154, 110, 58); background: rgba(255, 255, 255, 0.5);">=</span><span> </span><span class="token" style="color: rgb(102, 153, 0);">max</span><span class="token" style="color: rgb(153, 153, 153);">(</span><span>dp</span><span class="token" style="color: rgb(153, 153, 153);">[</span><span>i</span><span class="token" style="color: rgb(153, 153, 153);">]</span><span class="token" style="color: rgb(153, 153, 153);">,</span><span> dp</span><span class="token" style="color: rgb(153, 153, 153);">[</span><span>j</span><span class="token" style="color: rgb(153, 153, 153);">]</span><span> </span><span class="token" style="color: rgb(154, 110, 58); background: rgba(255, 255, 255, 0.5);">+</span><span> p</span><span class="token" style="color: rgb(153, 153, 153);">)</span></span></code></pre><div class="h-4 w-4 cursor-pointer fill-gray-6 hover:fill-gray-7 dark:fill-dark-gray-6 dark:hover:fill-dark-gray-7 absolute right-0 top-0" data-state="closed"><div><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="1em" height="1em" fill="currentColor" class="h-4 w-4 text-gray-6 hover:text-gray-7 dark:text-dark-gray-6 dark:hover:text-dark-gray-7 hidden group-hover:block"><path fill-rule="evenodd" d="M11.3 8.3H19a3 3 0 013 3V19a3 3 0 01-3 3h-7.7a3 3 0 01-3-3v-7.7a3 3 0 013-3zm0 2a1 1 0 00-1 1V19a1 1 0 001 1H19a1 1 0 001-1v-7.7a1 1 0 00-1-1h-7.7zm-5.6 3.4a1 1 0 110 2h-.9A2.8 2.8 0 012 12.9V4.8A2.8 2.8 0 014.8 2h8.1a2.8 2.8 0 012.8 2.8v.9a1 1 0 11-2 0v-.9a.8.8 0 00-.8-.8H4.8a.8.8 0 00-.8.8v8.1a.8.8 0 00.8.8h.9z" clip-rule="evenodd"></path></svg></div></div></div></div>
</li>
<li>
<p><strong>Result</strong>: After considering all jobs, the maximum profit that can be achieved is stored at the end of the dp array. Therefore, the last entry dp[n] is returned as the final result.</p>
<div class="mb-6 rounded-lg px-3 py-2.5 font-menlo text-sm bg-fill-3 dark:bg-dark-fill-3"><div class="group relative" translate="no"><pre style="color: black; font-size: 13px; text-shadow: none; font-family: Menlo, Monaco, Consolas; text-align: left; white-space: pre; word-spacing: normal; word-break: normal; line-height: 1.5; tab-size: 4; hyphens: none; padding: 0px; margin: 0px; overflow: auto; background: transparent; overflow-wrap: normal;"><code class="language-kotlin" style="text-shadow: none; white-space: pre;"><span><span class="token" style="color: rgb(0, 119, 170);">return</span><span> dp</span><span class="token" style="color: rgb(153, 153, 153);">[</span><span>n</span><span class="token" style="color: rgb(153, 153, 153);">]</span></span></code></pre><div class="h-4 w-4 cursor-pointer fill-gray-6 hover:fill-gray-7 dark:fill-dark-gray-6 dark:hover:fill-dark-gray-7 absolute right-0 top-0" data-state="closed"><div><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="1em" height="1em" fill="currentColor" class="h-4 w-4 text-gray-6 hover:text-gray-7 dark:text-dark-gray-6 dark:hover:text-dark-gray-7 hidden group-hover:block"><path fill-rule="evenodd" d="M11.3 8.3H19a3 3 0 013 3V19a3 3 0 01-3 3h-7.7a3 3 0 01-3-3v-7.7a3 3 0 013-3zm0 2a1 1 0 00-1 1V19a1 1 0 001 1H19a1 1 0 001-1v-7.7a1 1 0 00-1-1h-7.7zm-5.6 3.4a1 1 0 110 2h-.9A2.8 2.8 0 012 12.9V4.8A2.8 2.8 0 014.8 2h8.1a2.8 2.8 0 012.8 2.8v.9a1 1 0 11-2 0v-.9a.8.8 0 00-.8-.8H4.8a.8.8 0 00-.8.8v8.1a.8.8 0 00.8.8h.9z" clip-rule="evenodd"></path></svg></div></div></div></div>
</li>
</ol>
 */
class MaximumProfitInJobScheduling_Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int numJobs = profit.length; // Number of jobs
        Job[] jobs = new Job[numJobs];

        for (int i = 0; i < numJobs; ++i) {
            jobs[i] = new Job(endTime[i], startTime[i], profit[i]);
        }

        Arrays.sort(jobs, Comparator.comparingInt(job -> job.endTime));
        int[] dp = new int[numJobs + 1];

        for (int i = 0; i < numJobs; ++i) {
            int startTimeValue = jobs[i].startTime;
            int profitValue = jobs[i].profit;

            int latestNonConflictJobIndex = upperBound(jobs, i, startTimeValue);
            dp[i + 1] = Math.max(dp[i], dp[latestNonConflictJobIndex] + profitValue);
        }

        return dp[numJobs];
    }

    private int upperBound(Job[] jobs, int endIndex, int targetTime) {
        int low = 0;
        int high = endIndex;

        while (low < high) {
            int mid = (low + high) / 2;
            if (jobs[mid].endTime <= targetTime) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    private static class Job {
        int endTime;
        int startTime;
        int profit;

        public Job(int endTime, int startTime, int profit) {
            this.endTime = endTime;
            this.startTime = startTime;
            this.profit = profit;
        }
    }
}