package BetterCodeAnswer.Medium.Array;

import java.util.stream.Stream;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/task-scheduler/">621.Task Scheduler</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You are given an array of CPU <code>tasks</code>, each represented by letters&nbsp;A&nbsp;to Z, and a cooling time, <code>n</code>. Each cycle or interval allows the completion of one task. Tasks can be completed in any order, but there's a constraint: <strong>identical</strong> tasks must be separated by at least <code>n</code> intervals due to cooling time.</p>

<p>​Return the <em>minimum number of intervals</em> required to complete all tasks.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block" style="border-color: var(--border-tertiary); border-left-width: 2px; color: var(--text-secondary); font-size: 0.875rem; margin-bottom: 1rem; margin-top: 1rem; overflow: visible; padding-left: 1rem;">
<p><strong>Input:</strong> <span class="example-io" style="font-family: Menlo, sans-serif; font-size: 0.85rem;">tasks = ["A","A","A","B","B","B"], n = 2</span></p>

<p><strong>Output:</strong> <span class="example-io" style="font-family: Menlo, sans-serif; font-size: 0.85rem;">8</span></p>

<p><strong>Explanation:</strong> A possible sequence is: A -&gt; B -&gt; idle -&gt; A -&gt; B -&gt; idle -&gt; A -&gt; B.</p>

<p>After completing task A, you must wait two cycles before doing A again. The same applies to task B. In the 3<sup>rd</sup> interval, neither A nor B can be done, so you idle. By the 4<sup>th</sup> cycle, you can do A again as 2 intervals have passed.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block" style="border-color: var(--border-tertiary); border-left-width: 2px; color: var(--text-secondary); font-size: 0.875rem; margin-bottom: 1rem; margin-top: 1rem; overflow: visible; padding-left: 1rem;">
<p><strong>Input:</strong> <span class="example-io" style="font-family: Menlo, sans-serif; font-size: 0.85rem;">tasks = ["A","C","A","B","D","B"], n = 1</span></p>

<p><strong>Output:</strong> <span class="example-io" style="font-family: Menlo, sans-serif; font-size: 0.85rem;">6</span></p>

<p><strong>Explanation:</strong> A possible sequence is: A -&gt; B -&gt; C -&gt; D -&gt; A -&gt; B.</p>

<p>With a cooling interval of 1, you can repeat a task after just one other task.</p>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block" style="border-color: var(--border-tertiary); border-left-width: 2px; color: var(--text-secondary); font-size: 0.875rem; margin-bottom: 1rem; margin-top: 1rem; overflow: visible; padding-left: 1rem;">
<p><strong>Input:</strong> <span class="example-io" style="font-family: Menlo, sans-serif; font-size: 0.85rem;">tasks = ["A","A","A", "B","B","B"], n = 3</span></p>

<p><strong>Output:</strong> <span class="example-io" style="font-family: Menlo, sans-serif; font-size: 0.85rem;">10</span></p>

<p><strong>Explanation:</strong> A possible sequence is: A -&gt; B -&gt; idle -&gt; idle -&gt; A -&gt; B -&gt; idle -&gt; idle -&gt; A -&gt; B.</p>

<p>There are only two types of tasks, A and B, which need to be separated by 3 intervals. This leads to idling twice between repetitions of these tasks.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= tasks.length &lt;= 10<sup>4</sup></code></li>
	<li><code>tasks[i]</code> is an uppercase English letter.</li>
	<li><code>0 &lt;= n &lt;= 100</code></li>
</ul>
</div>
 */
public class TaskScheduler {
    public static void main(String[] args) {
        Object[][][] tests = {
            {
                {"A","B","C","A","C","D"},
                {2}
            },
            {
                {"A","A","A"},
                {1}
            },
            {
                {"A","A","A","B","B","B"},
                {2}
            },
            {
                {"A","C","A","B","D","B"},
                {1}
            },
            {
                {"A","A","A","B","B","B"},
                {3}
            },
        };

        for (Object[][] test : tests) {
            char[] tasks = Stream.of(test[0])
                                 .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                                 .toString()
                                 .toCharArray();
            int n = (int) test[1][0];
        
            System.out.println(new TaskScheduler_Solution().leastInterval(tasks, n));
        }
    }
}

// 2ms 45.32 MB
class TaskScheduler_Solution {
    public int leastInterval(char[] tasks, int n) {
       if (n == 0) {
           return tasks.length;
       }
       int[] f = new int[26];
       for (char c : tasks) {
           f[c - 'A']++;
       }
       int max = 0;
       int count = 0;
       for (int i : f) {
           if (i > max) {
               max = i;
               count = 1;
           } else if (i == max) {
               count++;
           }

       }
       return Math.max(tasks.length, (max - 1) * (n + 1) + count);
       // (max-1)*n su pauze između + max sami taskovi -1 + count (ako je count 1,
       // -1+1=0)
   }
}