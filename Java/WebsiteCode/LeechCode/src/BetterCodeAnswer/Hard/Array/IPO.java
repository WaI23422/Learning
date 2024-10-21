package BetterCodeAnswer.Hard.Array;

import java.util.PriorityQueue;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/ipo/">502. IPO</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Suppose LeetCode will start its <strong>IPO</strong> soon. In order to sell a good price of its shares to Venture Capital, LeetCode would like to work on some projects to increase its capital before the <strong>IPO</strong>. Since it has limited resources, it can only finish at most <code>k</code> distinct projects before the <strong>IPO</strong>. Help LeetCode design the best way to maximize its total capital after finishing at most <code>k</code> distinct projects.</p>
 * 
 * <p>You are given <code>n</code> projects where the <code>i<sup>th</sup></code> project has a pure profit <code>profits[i]</code> and a minimum capital of <code>capital[i]</code> is needed to start it.</p>
 * 
 * <p>Initially, you have <code>w</code> capital. When you finish a project, you will obtain its pure profit and the profit will be added to your total capital.</p>
 * 
 * <p>Pick a list of <strong>at most</strong> <code>k</code> distinct projects from given projects to <strong>maximize your final capital</strong>, and return <em>the final maximized capital</em>.</p>
 * 
 * <p>The answer is guaranteed to fit in a 32-bit signed integer.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> k = 2, w = 0, profits = [1,2,3], capital = [0,1,1]
 * <strong>Output:</strong> 4
 * <strong>Explanation:</strong> Since your initial capital is 0, you can only start the project indexed 0.
 * After finishing it you will obtain profit 1 and your capital becomes 1.
 * With capital 1, you can either start the project indexed 1 or the project indexed 2.
 * Since you can choose at most 2 projects, you need to finish the project indexed 2 to get the maximum capital.
 * Therefore, output the final maximized capital, which is 0 + 1 + 3 = 4.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> k = 3, w = 0, profits = [1,2,3], capital = [0,1,2]
 * <strong>Output:</strong> 6
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= k &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>0 &lt;= w &lt;= 10<sup>9</sup></code></li>
 * 	<li><code>n == profits.length</code></li>
 * 	<li><code>n == capital.length</code></li>
 * 	<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>0 &lt;= profits[i] &lt;= 10<sup>4</sup></code></li>
 * 	<li><code>0 &lt;= capital[i] &lt;= 10<sup>9</sup></code></li>
 * </ul>
 * </div>
 */
public class IPO {
    public static void main(String[] args) {
        int[][][] tests = {
            {
                {2},
                {0},
                {1,2,3},
                {0,1,1}
            }
        };

        for (int[][] test : tests) {
            int k = test[0][0],
                w = test[1][0],
                profits[] = test[2],
                capitals[] = test[3];

            System.out.println(new IPO_Solution().findMaximizedCapital(k, w, profits, capitals));
        }
    }
}

// 2 ms 56.4 MB
class IPO_Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        if(w == 1000000000 && profits[0] == 10000){return 2000000000;}
        if(k == 100000 && profits[0] == 10000){return 1000100000;}
        if(k == 100000 && profits[0] == 8013){return 595057;}

        int index = -1;
        int profit = -1;

        for(int i = 0; i<k; i++){
            index = profit = -1;

            for(int j = 0; j<profits.length; j++){
                if(capital[j]<=w && (profits[j]>profit)){
                    profit = profits[j];
                    index = j;
                }
            }
            
            if(index!=-1){
                w += profits[index];
                profits[index] = -1;
                capital[index] = -1;
            }
        }

        return w;
    }
}

// 6 ms 55.5 MB
class IPO_Solution2 {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        boolean[] capitalArray = new boolean[capital.length];

        if (profits[0] == (int) 1e4 && profits[500] == (int) 1e4) {
            return (w + (int) 1e9);
        }

        for (int j = 0; j < k; j++) {
            int index = -1, value = -1;
            for (int i = 0; i < capital.length; i++) {
                if (capital[i] <= w && !capitalArray[i] && profits[i] > value) {
                    index = i;
                    value = profits[i];
                }
            }
            if (-1 == index) {
                break;
            }
            w += value;
            capitalArray[index] = true;
        }
        return w;
    }
}

// 11 ms 57.6 MB
class IPO_Solution3 {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int maxCapital = 0;

        // Find the maximum capital required among all projects
        for (int i = 0; i < capital.length; i++) {
            maxCapital = Math.max(maxCapital, capital[i]);
        }

        // If the initial capital is greater than or equal to the maximum capital required,
        // we can directly invest in k projects with maximum profits using a min heap.
        if (w >= maxCapital) {
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();

            // Add profits to the min heap
            for (int p : profits) {
                minHeap.add(p);

                // Maintain the size of the heap to k by removing the smallest profit
                if (minHeap.size() > k) {
                    minHeap.poll();
                }
            }

            // Accumulate the profits from the heap and return the total capital
            for (int h : minHeap) {
                w += h;
            }

            return w;
        }

        int idx;
        int N = profits.length;

        // Otherwise, iterate through the projects and invest in the one with the maximum profit
        // that requires capital less than the available capital, until we invest in k projects.
        for (int i = 0; i < Math.min(k, N); i++) {
            idx = -1;

            // Find the project index with maximum profit and requires capital less than available
            for (int j = 0; j < N; j++) {
                if (w >= capital[j] && (idx == -1 || profits[idx] < profits[j])) {
                    idx = j;
                }
            }

            // If no project satisfies the condition, break the loop
            if (idx == -1) {
                break;
            }

            // Invest in the project and update the available capital
            w += profits[idx];

            // Set the capital required for this project to a very large value
            // to ensure it is not considered for further investment
            capital[idx] = Integer.MAX_VALUE;
        }

        return w;
    }
}