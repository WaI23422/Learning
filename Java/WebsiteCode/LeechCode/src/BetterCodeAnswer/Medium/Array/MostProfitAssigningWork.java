package BetterCodeAnswer.Medium.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/most-profit-assigning-work/">826. Most Profit Assigning Work</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You have <code>n</code> jobs and <code>m</code> workers. You are given three arrays: <code>difficulty</code>, <code>profit</code>, and <code>worker</code> where:</p>
 * 
 * <ul>
 * 	<li><code>difficulty[i]</code> and <code>profit[i]</code> are the difficulty and the profit of the <code>i<sup>th</sup></code> job, and</li>
 * 	<li><code>worker[j]</code> is the ability of <code>j<sup>th</sup></code> worker (i.e., the <code>j<sup>th</sup></code> worker can only complete a job with difficulty at most <code>worker[j]</code>).</li>
 * </ul>
 * 
 * <p>Every worker can be assigned <strong>at most one job</strong>, but one job can be <strong>completed multiple times</strong>.</p>
 * 
 * <ul>
 * 	<li>For example, if three workers attempt the same job that pays <code>$1</code>, then the total profit will be <code>$3</code>. If a worker cannot complete any job, their profit is <code>$0</code>.</li>
 * </ul>
 * 
 * <p>Return the maximum profit we can achieve after assigning the workers to the jobs.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> difficulty = [2,4,6,8,10], profit = [10,20,30,40,50], worker = [4,5,6,7]
 * <strong>Output:</strong> 100
 * <strong>Explanation:</strong> Workers are assigned jobs of difficulty [4,4,6,6] and they get a profit of [20,20,30,30] separately.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> difficulty = [85,47,57], profit = [24,66,99], worker = [40,25,25]
 * <strong>Output:</strong> 0
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>n == difficulty.length</code></li>
 * 	<li><code>n == profit.length</code></li>
 * 	<li><code>m == worker.length</code></li>
 * 	<li><code>1 &lt;= n, m &lt;= 10<sup>4</sup></code></li>
 * 	<li><code>1 &lt;= difficulty[i], profit[i], worker[i] &lt;= 10<sup>5</sup></code></li>
 * </ul>
 * </div>
 */
public class MostProfitAssigningWork {
    public static void main(String[] args) {
        int[][][] tests = {
            {
                {13,37,58},
                {4,90,96},
                {34,73,45},
            },
            {
                {2,4,6,8,10},
                {10,20,30,40,50},
                {4,5,6,7},
            },
        };

        for (int[][] test : tests) {
            int[] difficulty = test[0],
                  profit = test[1],
                  worker = test[2];

            System.out.println(new MostProfitAssigningWork_Solution().maxProfitAssignment(difficulty, profit, worker));
        }
    }
}

// 25 ms 45.4 MB
class MostProfitAssigningWork_Solution {

    public int maxProfitAssignment(
        int[] difficulty,
        int[] profit,
        int[] worker
    ) {
        List<int[]> jobProfile = new ArrayList<>();
        jobProfile.add(new int[] { 0, 0 });
        for (int i = 0; i < difficulty.length; i++) {
            jobProfile.add(new int[] { difficulty[i], profit[i] });
        }

        // Sort by difficulty values in increasing order.
        Collections.sort(jobProfile, (a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 0; i < jobProfile.size() - 1; i++) {
            jobProfile.get(i + 1)[1] = Math.max(
                jobProfile.get(i)[1],
                jobProfile.get(i + 1)[1]
            );
        }

        int netProfit = 0;
        for (int i = 0; i < worker.length; i++) {
            int ability = worker[i];

            // Find the job with just smaller or equal difficulty than ability.
            int l = 0, r = jobProfile.size() - 1, jobProfit = 0;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (jobProfile.get(mid)[0] <= ability) {
                    jobProfit = Math.max(jobProfit, jobProfile.get(mid)[1]);
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

            // Increment profit of current worker to total profit.
            netProfit += jobProfit;
        }
        return netProfit;
    }
}

// 20ms 46.36MB
class MostProfitAssigningWork_Solution2 {

    public int maxProfitAssignment(
        int[] difficulty,
        int[] profit,
        int[] worker
    ) {
        List<int[]> jobProfile = new ArrayList<>();
        for (int i = 0; i < difficulty.length; i++) {
            jobProfile.add(new int[] { difficulty[i], profit[i] });
        }

        // Sort both worker and jobProfile arrays
        Arrays.sort(worker);
        jobProfile.sort((a, b) -> Integer.compare(a[0], b[0]));

        int netProfit = 0, maxProfit = 0, index = 0;
        for (int i = 0; i < worker.length; i++) {
            // While the index has not reached the end and worker can pick a job
            // with greater difficulty move ahead.
            while (
                index < difficulty.length &&
                worker[i] >= jobProfile.get(index)[0]
            ) {
                maxProfit = Math.max(maxProfit, jobProfile.get(index)[1]);
                index++;
            }
            netProfit += maxProfit;
        }
        return netProfit;
    }
}

// 12ms 46.26MB
class MostProfitAssigningWork_Solution3 {

    public int maxProfitAssignment(
        int[] difficulty,
        int[] profit,
        int[] worker
    ) {
        // Find maximum ability in the worker array.
        int maxAbility = Arrays.stream(worker).max().getAsInt();
        int[] jobs = new int[maxAbility + 1];

        for (int i = 0; i < difficulty.length; i++) {
            if (difficulty[i] <= maxAbility) {
                jobs[difficulty[i]] = Math.max(jobs[difficulty[i]], profit[i]);
            }
        }

        // Take maxima of prefixes.
        for (int i = 1; i <= maxAbility; i++) {
            jobs[i] = Math.max(jobs[i], jobs[i - 1]);
        }

        int netProfit = 0;
        for (int ability : worker) {
            netProfit += jobs[ability];
        }
        return netProfit;
    }
}

// 6ms 45.51MB
class MostProfitAssigningWork_Solution4 {

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        if (difficulty.length != profit.length) {return 0;}

        int maxDifficulty = 0;
        for (int diff: difficulty) {
            maxDifficulty = Math.max(maxDifficulty, diff);
        }

        int[] bestProfit = new int[maxDifficulty + 1];
        for (int i = 0; i < profit.length; i++) {
            bestProfit[difficulty[i]] = Math.max(bestProfit[difficulty[i]], profit[i]);
        }

        int maxProfit = 0;
        for (int i = 0; i < bestProfit.length; i++) {
            if (bestProfit[i] > maxProfit) {
                maxProfit = bestProfit[i];
            }
            bestProfit[i] = maxProfit;
        }

        int result = 0;
        for (int w: worker) {
            if (w > maxDifficulty) {
                result += bestProfit[maxDifficulty];
            } else {
                result += bestProfit[w];
            }
        }
        return result;
    }
}