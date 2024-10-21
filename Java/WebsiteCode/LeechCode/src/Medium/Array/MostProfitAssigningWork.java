package Medium.Array;

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

// 1589 ms 46.1 MB
class MostProfitAssigningWork_Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int total_profit = 0,
            len = difficulty.length;

        Sort(difficulty, profit, 0, len-1);

        for (int worker_diff : worker) {
            int idx = 0,
                diff = difficulty[idx],
                profitAt = profit[idx],
                pre_profit = 0;
            while (diff <= worker_diff) {
                if (profitAt > pre_profit) {
                    total_profit += profitAt - pre_profit;
                    pre_profit = profitAt;
                }

                idx++;
                if (idx >= len) {break;}
                diff = difficulty[idx];
                profitAt = profit[idx];
            }
        }

        return total_profit;
    }

    static void Sort(int[] arr, int[] attach, int low, int high){
        if (low < high) {
            int pi = partition(arr,attach, low, high);
            Sort(arr,attach, low, pi - 1);
            Sort(arr,attach, pi + 1, high);
        }
    }

    private static void swap(int[] arr,int[] attach, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        temp = attach[i];
        attach[i] = attach[j];
        attach[j] = temp;
    }

    private static int partition(int[] arr,int[] attach, int low, int high){
        int pivot = arr[high];
        int i = (low - 1);
 
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr,attach, i, j);
            }
        }
        swap(arr,attach, i + 1, high);
        return (i + 1);
    }
}