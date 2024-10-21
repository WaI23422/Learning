package Hard.Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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

// 75 ms 64.4 MB
class IPO_Solution {
    // Defining the Project class within the Solution class
    private static class Project {
        int capital;
        int profit;

        Project(int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
        }
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        List<Project> projects = new ArrayList<>();

        // Creating list of projects with capital and profits
        for (int i = 0; i < n; i++) {
            projects.add(new Project(capital[i], profits[i]));
        }

        // Sorting projects by capital required
        Collections.sort(projects, (a, b) -> a.capital - b.capital);

        // Max-heap to store profits (using a min-heap with inverted values)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x, y) -> y - x);
        int i = 0;

        // Main loop to select up to k projects
        for (int j = 0; j < k; j++) {
            // Add all profitable projects that we can afford
            while (i < n && projects.get(i).capital <= w) {
                maxHeap.add(projects.get(i).profit);
                i++;
            }

            // If no projects can be funded, break out of the loop
            if (maxHeap.isEmpty()) {
                break;
            }

            // Otherwise, take the project with the maximum profit
            w += maxHeap.poll();
        }

        return w;
    }
}
